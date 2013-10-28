package edu.vt.bmac.gpstracker;

import android.hardware.SensorEvent;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

//-------------------------------------------------------------------------
/**
*  Class used to setup and record GPS locations Subclass gpsInfo calculates
*  information used in this project
*
*  This class will call the GPS and have it update.
*  This class will be created in the
*  mainActivity class and will run in the background.
*
*
*  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
*  @version Apr 3, 2013
*/
public class GPS implements LocationListener, Serializable
{
    private Context mContext;
    //Used to grab gps locations
    private LocationManager gps;
    private int id;
    private SensorManager sm;
    //GPSlist stores all locations that are valid based on user settings
    private gpsList list = null;
    //private Trails trails;
    //Stores how often to record GPS locations, User defined
    private int updateTime = 10;
    //units to display 0 is km, 1 is meters 2 is miles 3 is feet, user defined
    private int units = 0;
    //Used to send update signals to the main screen
    private GpsListener updater = null;
    //Handle updates based on timer
    private Handler handler;
    //Used to temp store all gps locations during inactive period
    private Stack<Location> locations;
    //True fetches elevation from web false gets from GPS, user defined
    private Boolean altMethod = false;
    //max radius for GPS locations to record. user defined
    private int maxRadius = 5;
    //min distance between locations before recording. user Defined
    private int minTravel = 3;
    private ArrayList<Double> elevation = new ArrayList<Double>();
    /**
     * constructor
     * @param mContext the super class providing access to Activity
     * @param listener the class that extends GpsListener
     */
    public GPS(Context mContext, GpsListener listener, int id) {
        this.mContext = mContext;
        this.id = id;
        locations = new Stack<Location>();
        sm = (SensorManager)mContext.getSystemService(Context.SENSOR_SERVICE);
        SensorEventListener listnerr = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event)
            {
                float[] list = event.values;
                //Log.d("Sensor", Float.toString(list[0]) + " " + SensorManager.getAltitude(sm.PRESSURE_STANDARD_ATMOSPHERE, list[0]));

                //if (list[0] )

            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy)
            {
                // TODO Auto-generated method stub

            }
        };
        sm.registerListener(listnerr, sm.getDefaultSensor(Sensor.TYPE_PRESSURE), 1);
        updater = listener;
        //list = trails.addTrail();
        handler = new Handler();
        gps = (LocationManager)this.mContext.getSystemService(
            Context.LOCATION_SERVICE);
        if (!this.gps.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Intent intent = new Intent(
                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            this.mContext.startActivity(intent);
        }
        list = new gpsList(id);

        //handler.postDelayed(addGpsData, this.updateTime * 1000);
    }
    public int getId() {
        return id;
    }
    /**
     * returns the list of gps locations
     * @return a gpslist class
     */
    public gpsList getList() {
        return list;
    }
    public Trail stopRunning(String name) {
        handler.removeCallbacks(addGpsData);
        GpsInfo info = getStats();
        Trail ret = new Trail(name, java.util.Calendar.getInstance().toString(), id, list.getList(), info.totalTime(), info.totalDistance(), info.getAltChange(), info.getAvgSpeed());
        return ret;
    }
    public void startTrail() {
        gps.requestLocationUpdates(LocationManager.GPS_PROVIDER,
            0, //Must use 0 to keep GPS active and up to date
            0,
            this);
        onSettingUpdate();
        handler.postDelayed(addGpsData, this.updateTime * 1000);
    }
    /**
     * Pulls the settings from the Shared preferences Gets called
     * when user changes them from the settings menu
     */
    public void onSettingUpdate() {
        SharedPreferences pref = PreferenceManager
            .getDefaultSharedPreferences(mContext);
        String freq = pref.getString("location_update", "");
        String metricSet = pref.getString("m_km", "");
        String acc = pref.getString("distance", "");
        String alt = pref.getString("alt", "");
        String dist = pref.getString("dist", "");
        try {
            if (Integer.valueOf(freq) != null
                && Integer.valueOf(metricSet) != null
                && Integer.valueOf(acc) != null) {
                this.updateTime = Integer.valueOf(freq);
                this.units = Integer.valueOf(metricSet);
                this.maxRadius = Integer.valueOf(acc);
                this.altMethod = Integer.valueOf(alt) == 0 ? false : true;
                this.minTravel = Integer.valueOf(dist);
            }
            updater.onUpdate("gpsUpdate");
        }
        catch(Exception e) {
            android.util.Log.d("Exception", "Could not load settings");
        }
    }
    /**
     * When the system gets a new update from the GPS it will push it to a
     * queue to be examened later
     * @param location the location class containing info from GPS
     */
    public void onLocationChanged(Location location)
    {
        android.util.Log.d("Satellites info",
            Integer.toString(location.getExtras().getInt("satellites")));
        locations.push(location);

    }
    /**
     * Used to start recording and storing the GPS data
     */
    public Runnable addGpsData = new Runnable() {
        /**
         * Default run command, runs when called by the timer
         */
        public void run()
        {
            android.util.Log.d("GPS Location", "Timer has been called");
            //While temp locations contain items
            if (locations.size() == 0) {
                String curStatus = "GPS unavailable.";
                updater.onStatusUpdate(curStatus);
            }
            while(true && locations.size() > 0) {
                //update status
                String curStatus = "";
                curStatus = "GPS Locked. ";
                int sat = locations.peek()
                    .getExtras().getInt("satellites");
                float acc = locations.peek().getAccuracy();
                if (sat < 4) {
                    curStatus += "Inadequate satellites";
                }
                if (acc > maxRadius) {
                    curStatus += "Inaccurate lock";
                }

                curStatus += sat > 0 ? "\n# of Satellites: "
                    + String.valueOf(sat) : "\n# of Satellites: Unknown";
                curStatus += acc > 0.0 ? "\nAccuracy: "
                    + String.valueOf(acc) : "\nAccuracy: Unknown";
                updater.onStatusUpdate(curStatus);
                //load the last most location
                Location location = locations.pop();
                android.util.Log.d("GPS Accuracy",
                    Float.toString(location.getAccuracy()));
                // ensures gps has a fix, the radius is within user range
                //and the travel distance is in user range before adding
                //to list
                double nodeDist = 0;
                if (list.size() > 0) {
                    nodeDist = list.top().distanceTo(location);
                }
                if (location.getExtras().getInt("satellites") >= 4
                        && location.getAccuracy() <= maxRadius
                        && (list.size() == 0 || nodeDist >= minTravel)) {
                    list.add(new Node(location));
                    if (altMethod) {
                        //Calls to fetch the altitude from web
                        new getAlt().execute(location.getLongitude(),
                            location.getLatitude());
                    }
                    else {
                        //adds it from GPS
                        elevation.add(location.getAltitude());
                    }
                    android.util.Log.d("Location Update", "Lon="
                        + location.getLongitude()
                        + " lat=" + location.getLatitude());
                    updater.onUpdate("gpsUpdate");
                    locations.clear();
                    break;
                }
                else {
                    continue;
                }
            }
            //call for an update after user defined settings
            handler.postDelayed(this, updateTime * 1000);
        }

    };
    /**
     * If the GPS is disabled it will prompt to enable it
     */
    public void onProviderDisabled(String provider)
    {
        Intent intent = new Intent(
            Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        this.mContext.startActivity(intent);

    }
    /**
     * when the GPS is enabled this gets called.
     * Not used in this project
     * @param provider the gps provoder
     */
    public void onProviderEnabled(String provider)
    {
        // TODO Auto-generated method stub

    }
    /**
     * When the GPS status updates, We update the info in the main screen
     * @param provider the GPS provider
     * @param status the status of the GPS
     * @param extras extra info
     */
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        if (status == LocationProvider.AVAILABLE) {
            String curStatus = "GPS Locked.";
            if (list != null && list.size() > 0) {
                int sat = list.top().getSat();
                float acc = list.top().getAccuracy();
                curStatus += sat > 0 ? "\n# of Satellites: "
                    + String.valueOf(sat) : "\n# of Satellites: Unknown";
                curStatus += acc > 0.0 ? "\nAccuracy: "
                    + String.valueOf(acc) : "\nAccuracy: Unknown";
            }
            updater.onStatusUpdate(curStatus);
        }
        else if (status == LocationProvider.TEMPORARILY_UNAVAILABLE
            || status == LocationProvider.OUT_OF_SERVICE) {
            updater.onStatusUpdate("GPS Unavailable."
                +"\n# of Satellites: Unknown\nAccuracy: Unknown");
        }

    }
    /**
     * Gets a new instance of GpsInfo used to update the main display or use
     * with other tools that need total distance etc.
     * @return a new instance of GpsInfo
     */
    public GpsInfo getStats() {
        if (list == null)
            return null;
        return new GpsInfo(this.list, this.elevation, this.units, this.id);
    }
    // ----------------------------------------------------------
    /**
     * Gets a "stats" class that used the arraylist and calculates info based
     * off the stored locations.
     *
     *
     */
    protected static class GpsInfo implements Serializable
    {
        private int size;
        private float timeInHour = 0;
        private int hour = 0;
        private int min = 0;
        private int sec = 0;
        private float distance = 0;
        private String unit = "";
        private int id;
        private double alt;
        private String altStr = null;
        private String dist = null;
        public GpsInfo (String alt, String dist) {
            this.altStr = alt;
            this.dist = dist;
        }
        /**
         * constructor
         */
        protected GpsInfo(gpsList list, ArrayList<Double> elevation, int units, int id) {
            this.id = id;
            if (units == 0) {
                unit = " km";
            }
            else if (units == 1) {
                unit = " m";
            }
            else if (units == 2) {
                unit = " mi";
            }
            else if (units == 3) {
                unit = " ft";
            }
            size = list.size();
            //Calculate the time initially to have it for the time
            //and average speed
            long totalTime = 0;
            for (int i = 0; i < size - 1; i++) {
                if (list.at(i).getTime().before(list.at(i + 1).getTime())) {
                    long firstTime = list.at(i).getTime().getTimeInMillis();
                    long secTime = list.at(i + 1).getTime().getTimeInMillis();
                    long diff = secTime - firstTime;
                    totalTime += diff;
                }
            }
            hour = (int)(totalTime / 3600000);
            min = (int) ((totalTime - (3600000 * hour)) / 60000);
            sec = (int)((totalTime - (60000 * min)) / 1000);
            timeInHour = hour + (min/60f) + (sec/(60f * 60f));
            /**
             * Calculate the distance for total distance and average speed
             */
            for (int i = 0; i < size - 1; i++) {
                android.util.Log.d("Location Update",
                    Float.toString(list.at(i).distanceTo(
                    list.at(i + 1).getLocation())));
                distance += list.at(i).distanceTo(
                    list.at(i + 1).getLocation());
            }
            if (units == 2) {
                distance *= 0.000621371;
            }
            else if (units == 0) {
                distance *= 0.001;
            }
            else if (units == 3) {
                distance *= 3.28084;
            }
            for (int i = 0; i < elevation.size() - 1; i++) {
                if (elevation.get(i) == 0.0
                    || elevation.get(i + 1) == 0.0) {
                    continue;
                }
                alt += elevation.get(i + 1) - elevation.get(i);
            }
            if (units == 2) {
                alt *= 0.000621371;
            }
            else if (units == 0) {
                alt *= 0.001;
            }
            else if (units == 3) {
                alt *= 3.28084;
            }
        }
        public int getId() {
            return this.id;
        }
        /**
         * calculates the total distance traveled
         * @return the distance traveled
         */
        public String totalDistance() {
            return String.valueOf(distance) + unit;
        }
        /**
         * calculates the total time traveled
         * @return time traveled
         */
        public String totalTime() {
            @SuppressWarnings("resource")
            java.util.Formatter out = new java.util.Formatter();
            return out.format("%02d:%02d:%02d",
                hour, min, sec).toString();
        }
        /**
         * calculates the change in elevation if available
         * @return the change in altitude
         */
        public String getAltChange() {
            if (altStr != null)
                return altStr;
            return String.valueOf(alt) + unit;

        }
        /**
         * gets the average speed traveled
         * @return a formated string with the needed info
         */
        public String getAvgSpeed()
        {
            if (dist != null) {
                return dist;
            }
            return String.valueOf(distance / timeInHour)
                + unit + "/hour";
        }

    }

    private class getAlt extends AsyncTask<Double, Integer, Double> {

        @Override
        protected Double doInBackground(Double... params)
        {
            double longitude = params[0];
            double latitude = params[1];
            double result = Double.NaN;
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            String url = "http://gisdata.usgs.gov/"
                    + "xmlwebservices2/elevation_service.asmx/"
                    + "getElevation?X_Value=" + String.valueOf(longitude)
                    + "&Y_Value=" + String.valueOf(latitude)
                    + "&Elevation_Units=METERS&Source_Layer=-1&Elevation_Only=true";
            HttpGet httpGet = new HttpGet(url);
            try {
                HttpResponse response = httpClient.execute(httpGet, localContext);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream instream = entity.getContent();
                    int r = -1;
                    StringBuffer respStr = new StringBuffer();
                    while ((r = instream.read()) != -1)
                        respStr.append((char) r);
                    String tagOpen = "<double>";
                    String tagClose = "</double>";
                    if (respStr.indexOf(tagOpen) != -1) {
                        int start = respStr.indexOf(tagOpen) + tagOpen.length();
                        int end = respStr.indexOf(tagClose);
                        String value = respStr.substring(start, end);
                        result = Double.parseDouble(value);
                    }
                    instream.close();
                }
            } catch (ClientProtocolException e) {
                //Nothing
            }
            catch (IOException e) {
                //Nothing
            }
            return result;


        }
        protected void onPostExecute(Double results) {
            elevation.add(results);
        }

    }

}

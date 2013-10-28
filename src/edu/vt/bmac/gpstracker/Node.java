package edu.vt.bmac.gpstracker;

import android.R.integer;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import android.location.Location;
import android.text.format.Time;

// -------------------------------------------------------------------------
/**
 *  Used to store gps info, time and altitude.
 *
 *  @author Brian McNamara (bmac), Anthony Allen(ala2555), Chris Pan (chrisp3)
 *  @version Mar 31, 2013
 */

public class Node implements Serializable
{
    private Double lat;
    private Double lon;
    private Double alt;
    private float accuracy;
    private Integer satalites;
    private float speed;
    private Calendar time;
    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * @param location A location instance
     */
    public Node(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
        alt = location.getAltitude();
        satalites = location.getExtras().getInt("satellites");
        accuracy = location.getAccuracy();
        speed = location.getSpeed();
        time = Calendar.getInstance();
    }
    public Node(double lat, double lon, double alt, float accuracy, int sat, float speed, long time) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.accuracy = accuracy;
        this.satalites = sat;
        this.speed = speed;
        this.time = Calendar.getInstance();
        this.time.setTime(new Date(time));
    }
    // ----------------------------------------------------------
    /**
     * Updates the time to the current time
     */
    public void setTime() {
        time = Calendar.getInstance();
    }
    // ----------------------------------------------------------
    /**
     * returns the longitude
     * @return the longitude
     */
    public double getLong() {
        return lon;
    }
    // ----------------------------------------------------------
    /**
     * returns latitude
     * @return latitude
     */
    public double getLat() {
        return lat;
    }
    // ----------------------------------------------------------
    /**
     * returns the time instance
     * @return the time instance
     */
    public Calendar getTime() {
        return time;
    }

    // ----------------------------------------------------------
    /**
     * returns the altitude
     * @return altitude
     */
    public double getAlt() {
        return alt;
    }

    public int getSat() {
        return satalites;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public float distanceTo(Location other) {
        Location here = new Location("nothing");
        here.setAccuracy(accuracy);
        here.setAltitude(alt);
        here.setLatitude(lat);
        here.setLongitude(lon);
        here.setSpeed(speed);
        return here.distanceTo(other);

    }
    public Location getLocation() {
        Location here = new Location("nothing");
        here.setAccuracy(accuracy);
        here.setAltitude(alt);
        here.setLatitude(lat);
        here.setLongitude(lon);
        here.setSpeed(speed);
        return here;
    }
}

package edu.vt.bmac.gpstracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.vt.bmac.gpstracker.GPS.GpsInfo;
import java.text.SimpleDateFormat;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 23, 2013
 */

public class TrackerActivity extends Activity implements GpsListener
{
    private TextView distance;
    private TextView speed;
    private TextView time;
    private TextView alt;
    private TextView status;
    private Button map;
    private GPS location;
    private Button stop;
    private Button begin;
    private Friend user;
    private Trail trail;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.tracking);
        user = (Friend)this.getIntent().getSerializableExtra("friend");
        distance = (TextView)findViewById(R.id.distanceView);
        speed = (TextView)findViewById(R.id.speedView);
        time = (TextView)findViewById(R.id.timeView);
        alt = (TextView)findViewById(R.id.altChange);
        map = (Button)findViewById(R.id.openMaps);
        status = (TextView)findViewById(R.id.GPS_Status);
        stop = (Button)findViewById(R.id.stopTrail);
        begin = (Button)findViewById(R.id.startTrail);
        location = new GPS(this, this, user.getNewSessionId());

        begin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                location.startTrail();

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                trail = location.stopRunning(user.getName());
                user.updateSession(trail);

            }
        });

        map.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                android.util.Log.d("Clicked", "button clicked");
                gpsList list = location.getList();
                if (list.size() >= 0) {
                    double[] lon = new double[list.size()];
                    double[] lat = new double[list.size()];
                    String[] times = new String[list.size()];
                    SimpleDateFormat formater = new SimpleDateFormat("h:m:s");
                    for (int i = 0; i < list.size(); i++) {
                        lon[i] = list.at(i).getLong();
                        lat[i] = list.at(i).getLat();
                        times[i] = formater.format(list.at(i).getTime().getTime());
                    }
                    Intent intent = new Intent(TrackerActivity.this
                        , MapsActivity.class);
                    intent.putExtra("lat", lat);
                    intent.putExtra("lon", lon);
                    intent.putExtra("time", times);
                    startActivity(intent);
                }
            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("trail", trail);
        setResult(1, intent);
        finish();
    }
    @Override
    public void onUpdate(String item)
    {
        if (item == "gpsUpdate") {
            GpsInfo stats = location.getStats();
            if(stats != null) {
                distance.setText(stats.totalDistance());
                speed.setText(stats.getAvgSpeed());
                alt.setText(stats.getAltChange());
                time.setText(stats.totalTime());
            }
        }

    }
    @Override
    public void onError(Throwable error)
    {
        // TODO Auto-generated method stub

    }
    @Override
    public void onStatusUpdate(String Status)
    {
        status.setText(Status);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public boolean  onOptionsItemSelected (MenuItem item) {
        if (item.getTitle().toString().equals("Settings")) {
            android.util.Log.d("Settings", "The settings button was hit!");
            Intent settings = new Intent(TrackerActivity.this, SettingsActivity.class);
            settings.putExtra("settings", "tracker");
            startActivityForResult(settings, 1);
            return true;
        }
        return false;
    }
    protected void onActivityResult(int requestCode, int resultCode,
        Intent data) {
        android.util.Log.d("settings", "Activity returned");
        if (requestCode == 1) {
            this.location.onSettingUpdate();
        }
    }
}

package edu.vt.bmac.gpstracker;

import java.util.ArrayList;
import android.content.Intent;
import java.text.SimpleDateFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.vt.bmac.gpstracker.GPS.GpsInfo;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 25, 2013
 */

public class TrailActivity extends Activity
{
    private TextView distance;
    private TextView speed;
    private TextView time;
    private TextView alt;
    private TextView status;
    private Button map;
    private Button stop;
    private Button begin;
    private Trail info;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.tracking);
        info = (Trail)this.getIntent().getSerializableExtra("GPS");
        distance = (TextView)findViewById(R.id.distanceView);
        speed = (TextView)findViewById(R.id.speedView);
        time = (TextView)findViewById(R.id.timeView);
        alt = (TextView)findViewById(R.id.altChange);
        map = (Button)findViewById(R.id.openMaps);
        status = (TextView)findViewById(R.id.GPS_Status);
        stop = (Button)findViewById(R.id.stopTrail);
        begin = (Button)findViewById(R.id.startTrail);
        begin.setVisibility(View.INVISIBLE);
        stop.setVisibility(View.INVISIBLE);
        status.setVisibility(View.INVISIBLE);
        distance.setText(info.getDist());
        speed.setText(info.getSpeed());
        time.setText(info.getTime());
        alt.setText(info.getAlt());
        map.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                android.util.Log.d("Clicked", "button clicked");
                ArrayList<Node> list = info.getPlots();
                if (list.size() >= 0) {
                    double[] lon = new double[list.size()];
                    double[] lat = new double[list.size()];
                    String[] times = new String[list.size()];
                    SimpleDateFormat formater = new SimpleDateFormat("h:m:s");
                    for (int i = 0; i < list.size(); i++) {
                        lon[i] = list.get(i).getLong();
                        lat[i] = list.get(i).getLat();
                        times[i] = formater.format(list.get(i).getTime().getTime());
                    }
                    Intent intent = new Intent(TrailActivity.this
                        , MapsActivity.class);
                    intent.putExtra("lat", lat);
                    intent.putExtra("lon", lon);
                    intent.putExtra("time", times);
                    startActivity(intent);
                }
            }
        });



    }
}

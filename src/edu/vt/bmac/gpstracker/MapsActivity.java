package edu.vt.bmac.gpstracker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Shows the google maps and updates the locations. Will have to get the gps
 *  list imported somehow
 *  http://www.vogella.com/articles/AndroidGoogleMaps/article.html
 *
 *   @author Brian McNamara
*  @version 10 27, 2013
 */
public class MapsActivity
    extends Activity
{
    private double[] lat;
    private double[] lon;
    private String[] name;
    private GoogleMap map;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.map);
        Intent intent = this.getIntent();
        android.util.Log.d("Maps screen", "Maps started");
        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        lon = intent.getDoubleArrayExtra("lon");
        lat = intent.getDoubleArrayExtra("lat");
        name = intent.getStringArrayExtra("time");
        LatLngBounds.Builder frame = new LatLngBounds.Builder();
        android.util.Log.d("Maps screen", "Size of " + String.valueOf(lon.length));
        ArrayList<Marker> markers = new ArrayList<Marker>();
        ArrayList<Polyline> line = new ArrayList<Polyline>();
        for (int i = 0; i < lon.length; i++) {
            LatLng location = new LatLng(lat[i], lon[i]);
            markers.add(map.addMarker(
                new MarkerOptions().position(location).title(name[i])));
            if (i < lon.length - 1) {
                line.add(map.addPolyline(new PolylineOptions()
                .add(location, new LatLng(lat[i+1], lon[i+1])).width(5)
                .color(Color.BLUE)));
            }
            frame.include(location);
        }
        if (lon.length > 0) {
            final LatLngBounds bound = frame.build();
            map.setOnCameraChangeListener(new OnCameraChangeListener() {

                public void onCameraChange(CameraPosition position)
                {
                    map.moveCamera(CameraUpdateFactory.newLatLngBounds(bound, 20));
                    map.setOnCameraChangeListener(null);

                }
            });
        }

    }
}

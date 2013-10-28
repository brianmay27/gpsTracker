package edu.vt.bmac.gpstracker;

import android.widget.ImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import edu.vt.bmac.gpstracker.GPS.GpsInfo;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 25, 2013
 */

public class FriendAdapter extends BaseAdapter
{
    private Trails trails;
    private ArrayList<Trail> gps;
    private static android.view.LayoutInflater inflater=null;
    public FriendAdapter(Context a, Trails trails) {
        this.trails = trails;
        gps = new ArrayList<Trail>(trails.getTrails());
        inflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return gps.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.trails, parent, false);
        }
        TextView distance = (TextView)view.findViewById(R.id.trailDistance);
        TextView id = (TextView)view.findViewById(R.id.trailId);
        TextView time = (TextView)view.findViewById(R.id.trailTime);
        distance.setText(gps.get(position).getDist());
        time.setText(gps.get(position).getTime());
        id.setText(Integer.toString(gps.get(position).getId()));
        return view;
    }

}

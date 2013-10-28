package edu.vt.bmac.gpstracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 23, 2013
 */

public class ListAdapter extends BaseAdapter
{
    private static android.view.LayoutInflater inflater=null;
    public ListAdapter(Context a) {
        inflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return 4;
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
            view = inflater.inflate(R.layout.buttons, parent, false);

        }
        view.setId(position);
        TextView text = (TextView)view.findViewById(R.id.buttonText);
        ImageView image = (ImageView)view.findViewById(R.id.buttonImage);
        switch(position) {
            case 0:
                text.setText("Begin Friend Tracking");
                break;
            case 1:
                text.setText("Begin Trail Tracking");
                break;

            case 2:
                text.setText("Friends");
                break;
            case 3:
                text.setText("Your picture");
        }
        return view;
    }

}

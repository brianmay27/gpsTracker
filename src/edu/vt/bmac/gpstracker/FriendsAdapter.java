package edu.vt.bmac.gpstracker;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import android.widget.ImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
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

public class FriendsAdapter extends BaseAdapter
{
    private Friends friends;
    private static android.view.LayoutInflater inflater=null;
    private ArrayList<Friend> friendsList;
    public FriendsAdapter(Context a, Friends friends) {
        inflater = (LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.friends = friends;
        friendsList = new ArrayList<Friend>(this.friends.getFriends());
    }
    @Override
    public int getCount()
    {
        return friends.getFriends().size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.friend, parent, false);
        }
        TextView name = (TextView)view.findViewById(R.id.friendName);
        TextView trails = (TextView)view.findViewById(R.id.numOfTrails);
        ImageView image = (ImageView)view.findViewById(R.id.friendImage);
        byte[] imageB;
        if ((imageB = friendsList.get(position).getImage()) != null) {
            ByteBuffer buffer = ByteBuffer.wrap(imageB);
            Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.RGB_565);
            bitmap.copyPixelsFromBuffer(buffer);
            image.setImageBitmap(bitmap);
        }
        name.setText(friendsList.get(position).getName());
        trails.setText(Integer.toString(friendsList.get(position).sessionSize()));
        return view;
    }

}

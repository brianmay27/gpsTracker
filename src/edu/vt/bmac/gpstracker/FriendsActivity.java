package edu.vt.bmac.gpstracker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 25, 2013
 */

public class FriendsActivity extends ListActivity
{
    private ListView view;
    private FriendsAdapter adapter;
    private Friends friends;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_view);
        view = (ListView)findViewById(android.R.id.list);
        friends = (Friends)getIntent().getSerializableExtra("friends");
        adapter = new FriendsAdapter(this,friends);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(
                AdapterView<?> arg0,
                View arg1,
                int arg2,
                long arg3)
            {
               String name = ((TextView)arg1.findViewById(R.id.friendName)).getText().toString();
               Intent intent = new Intent(FriendsActivity.this, FriendActivity.class);
               intent.putExtra("trails", friends.getFriend(name).getTrails());
               startActivity(intent);

            }
        });
    }
}

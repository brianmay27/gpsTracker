package edu.vt.bmac.gpstracker;

import java.io.Serializable;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import edu.vt.bmac.gpstracker.Trail;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Brian
 *  @version Oct 25, 2013
 */

public class FriendActivity extends ListActivity {
    private ListView view;
    private Trails trails;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.list_view);
        trails = (Trails)getIntent().getSerializableExtra("trails");
        this.view = (ListView)findViewById(android.R.id.list);
        FriendAdapter adapter = new FriendAdapter(this, trails);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(
                AdapterView<?> arg0,
                View arg1,
                int arg2,
                long arg3)
            {
                TextView id = (TextView)arg1.findViewById(R.id.trailId);
                Intent intent = new Intent(FriendActivity.this, TrailActivity.class);
                intent.putExtra("GPS", trails.getTrail(Integer.valueOf(id.getText().toString())));
                startActivity(intent);


            }
        });
    }
}

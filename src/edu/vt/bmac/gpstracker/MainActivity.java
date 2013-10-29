package edu.vt.bmac.gpstracker;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;
import edu.vt.bmac.gpstracker.friendendpoint.Friendendpoint;
import edu.vt.bmac.gpstracker.friendendpoint.model.CollectionResponseFriend;
import edu.vt.bmac.gpstracker.trailendpoint.Trailendpoint;
import edu.vt.bmac.gpstracker.trailendpoint.model.CollectionResponseTrail;
import edu.vt.bmac.gpstracker.trailendpoint.model.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

// -------------------------------------------------------------------------
/**
 *  Main screen, will contain some textedits, some way to get to the maps
 *  activity and other functionality
 *  http://www.websmithing.com/2011/02/01/how-to-update-the-ui-in-an-android-activity-using-data-from-a-background-service/
 *
 *  This implements GpsListner that allows the GPS class to update the screen
 *  when new information is received.
 *
 *
 *   @author Brian McNamara
*  @version 10 27, 2013
 */
public class MainActivity
    extends ListActivity
{
    private ListView view;
    private ListAdapter adapter;
    private Friends friends;
    private String userName = "default";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        SharedPreferences pref = PreferenceManager
            .getDefaultSharedPreferences(this);
        userName = pref.getString("userName", "default");
        if (userName.equals("default")) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Create a user").setMessage("Please create a user").setCancelable(false).setPositiveButton("Lets go!", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                    settings.putExtra("settings", "main");
                    startActivityForResult(settings, 2);

                }

            });
        }
        String url = pref.getString("hostName", "");
        if (!url.equals(""))
            CloudEndpointUtils.LOCAL_APP_ENGINE_SERVER_URL_FOR_ANDROID = url;
        friends = new Friends();
        friends.addFriend(userName);
        AsyncTask<Friends, Integer, Friends> task = new getAll().execute(friends);
        try
        {
            friends = task.get();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        view = (ListView)findViewById(android.R.id.list);
        adapter = new ListAdapter(this);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(
                AdapterView<?> arg0,
                View arg1,
                int arg2,
                long arg3)
            {
                switch(arg1.getId()) {
                    case 0:

                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, TrackerActivity.class);
                        intent.putExtra("friend", friends.getFriend(userName));
                        startActivityForResult(intent, 1);
                        break;
                    case 2:
                        Intent friendsIntent = new Intent(MainActivity.this, FriendsActivity.class);
                        friendsIntent.putExtra("friends", friends);
                        startActivity(friendsIntent);
                        break;
                    case 3:
                        Intent register = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(register, 3);
                        break;
                }

            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            Trail trail = (Trail)data.getSerializableExtra("trail");
            friends.getFriend(userName).addSession(trail);
            new newTrail().execute(trail);
        }
        else if (requestCode == 2) {
            SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
            userName = pref.getString("userName", "default");
            String url = pref.getString("hostName", "");
            if (!url.startsWith("http://"))
                url = "http://" + url;
            //if (!url.matches("http://(\\w+ || (\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}))
            CloudEndpointUtils.LOCAL_APP_ENGINE_SERVER_URL_FOR_ANDROID = url;
            Friend neu = friends.addFriend(userName);
            new newUser().execute(neu);
        }
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
            Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
            settings.putExtra("settings", "main");
            startActivityForResult(settings, 2);
            return true;
        }
        return false;
    }

    public class newUser extends AsyncTask<Friend, Integer, Integer> {
        protected Integer doInBackground(Friend... in) {

               Friendendpoint.Builder endpointBuilder = new Friendendpoint.Builder(
              AndroidHttp.newCompatibleTransport(),
              new JacksonFactory(),
              new HttpRequestInitializer() {
              public void initialize(HttpRequest httpRequest) { }
              });
           Friendendpoint endpoint = CloudEndpointUtils.updateBuilder(
      endpointBuilder).build();
      try {
          edu.vt.bmac.gpstracker.friendendpoint.model.Friend friend = endpoint.getFriend(in[0].getName()).execute();
          if (friend == null || friend.getName() == null) {
              friend = new edu.vt.bmac.gpstracker.friendendpoint.model.Friend();
              friend.setName(in[0].getName());
              endpoint.insertFriend(friend).execute();
          }

      } catch (IOException e) {
        e.printStackTrace();
      }
          return 0;
        }
    }


    public class newTrail extends AsyncTask<Trail, Integer, Integer> {
        protected Integer doInBackground(Trail... in) {

               Trailendpoint.Builder endpointBuilder = new Trailendpoint.Builder(
              AndroidHttp.newCompatibleTransport(),
              new JacksonFactory(),
              new HttpRequestInitializer() {
              public void initialize(HttpRequest httpRequest) { }
              });
           Trailendpoint endpoint = CloudEndpointUtils.updateBuilder(
      endpointBuilder).build();
      try {
          edu.vt.bmac.gpstracker.trailendpoint.model.Trail trail = new edu.vt.bmac.gpstracker.trailendpoint.model.Trail();
          trail.setAlt(in[0].getAlt());
          trail.setDist(in[0].getDist());
          trail.setHash(Long.valueOf(in[0].getName().hashCode()));
          trail.setId(in[0].getId());
          trail.setName(in[0].getName());
          trail.setSpeed(in[0].getSpeed());
          trail.setTime(in[0].getTime());
//          Key key = new Key().setAppId(null).setId(Long.valueOf(in[0].getName().hashCode())).setKind("Trail").setNamespace("edu.vt.bmac.gpstracker").setParent(null).setComplete(true);
//          trail.setKey(key);

          trail.setUsername(in[0].getUsername());
          List<Node> nodes = new ArrayList<Node>();
          for (edu.vt.bmac.gpstracker.Node node : in[0].getPlots()) {
              Node newNode = new Node();
              newNode.setAccuracy(node.getAccuracy());
              newNode.setAlt(node.getAlt());
              newNode.setLat(node.getLat());
              newNode.setLon(node.getLong());
              newNode.setSatalites(node.getSat());
              newNode.setSpeed(0.0f);
              newNode.setTime(node.getTime().getTimeInMillis());
              newNode.setId(Long.valueOf(in[0].getId() + 1));
              nodes.add(newNode);
          }
          trail.setPlots(nodes);
          endpoint.insertTrail(trail).execute();

      } catch (IOException e) {
        e.printStackTrace();
      }
          return 0;
        }
    }
//    public class updateUser extends AsyncTask<Friend, Integer, Integer> {
//        protected Integer doInBackground(Friend... contexts) {
//
//               Friendendpoint.Builder endpointBuilder = new Friendendpoint.Builder(
//              AndroidHttp.newCompatibleTransport(),
//              new JacksonFactory(),
//              new HttpRequestInitializer() {
//              public void initialize(HttpRequest httpRequest) { }
//              });
//           Friendendpoint endpoint = CloudEndpointUtils.updateBuilder(
//      endpointBuilder).build();
//      try {
//          edu.vt.bmac.gpstracker.friendendpoint.model.Friend friend = new edu.vt.bmac.gpstracker.friendendpoint.model.Friend();
//          friend.setName(contexts[0].getName());
//          friend.setNewSessionId(contexts[0].getNewSessionId());
//          Trails trails= new Trails();
//          ArrayList<GpsInfo> list = new ArrayList<GpsInfo>();
//          for (edu.vt.bmac.gpstracker.GPS.GpsInfo location : contexts[0].getTrails().getTrails()) {
//              GpsInfo put = new GpsInfo();
//              if (location == null || location.getAltChange() == null)
//                  break;
//              put.setAltChange(location.getAltChange());
//              put.setAvgSpeed(location.getAvgSpeed());
//              put.setId(location.getId());
//              list.add(put);
//          }
//          trails.setTrails(list);
//          friend.setTrails(new Trails());
//          friend.setSessions(list);
//          endpoint.updateFriend(friend).execute();
//
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//          return 0;
//        }
//    }
//
    public class getAll extends AsyncTask<Friends, Integer, Friends> {
        protected Friends doInBackground(Friends... contexts) {

               Friendendpoint.Builder FriendBuilder = new Friendendpoint.Builder(
              AndroidHttp.newCompatibleTransport(),
              new JacksonFactory(),
              new HttpRequestInitializer() {
              public void initialize(HttpRequest httpRequest) { }
              });
           Friendendpoint Friendpoint = CloudEndpointUtils.updateBuilder(
      FriendBuilder).build();
           Trailendpoint.Builder TrailBuilder = new Trailendpoint.Builder(
               AndroidHttp.newCompatibleTransport(),
               new JacksonFactory(),
               new HttpRequestInitializer() {
               public void initialize(HttpRequest httpRequest) { }
               });
            Trailendpoint Trailpoint = CloudEndpointUtils.updateBuilder(
       TrailBuilder).build();
      try {
          Friends allFriends = contexts[0];
          CollectionResponseFriend friends = Friendpoint.listFriend().execute();
          if (friends.getItems() == null)
              return allFriends;
          for (edu.vt.bmac.gpstracker.friendendpoint.model.Friend name : friends.getItems()) {
              Friend friend = allFriends.addFriend(name.getName());
          }
          CollectionResponseTrail alltrails = Trailpoint.listTrail().execute();
          if (alltrails.getItems() == null)
              return allFriends;
          for (edu.vt.bmac.gpstracker.trailendpoint.model.Trail serverTrail : alltrails.getItems()) {
              ArrayList<edu.vt.bmac.gpstracker.Node> nodes = new ArrayList<edu.vt.bmac.gpstracker.Node>();
              if (serverTrail.getPlots() != null) {
                  for (edu.vt.bmac.gpstracker.trailendpoint.model.Node node : serverTrail.getPlots()) {
                      edu.vt.bmac.gpstracker.Node newNode = new edu.vt.bmac.gpstracker.Node(
                          node.getLat(), node.getLon(), node.getAlt(), node.getAccuracy(),
                          node.getSatalites(), node.getSpeed(), node.getTime());
                      nodes.add(newNode);
                  }
              }
              Trail newTrail = new Trail(serverTrail.getUsername(),
                  serverTrail.getName(), serverTrail.getId(), nodes,
                  serverTrail.getTime(), serverTrail.getDist(), serverTrail.getAlt(), serverTrail.getSpeed());
              allFriends.getFriend(serverTrail.getUsername()).addSession(newTrail);
          }

          return allFriends;


      } catch (IOException e) {
        e.printStackTrace();
      }
          return contexts[0];
        }
    }


}

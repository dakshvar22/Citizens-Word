package com.example.root.janagraha;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
//import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.root.janagraha.app.AppController;

public class MainActivity extends Activity implements LocationListener {

    private LocationManager locationManager;
    String questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button b1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG = "MAIN ACTIVITY";


        AppController appController = new AppController();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000, 1, this);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify("Citizens Word","Would you like to give feedback on Bugle Rock Park");
            }
        });
        b1.setVisibility(View.INVISIBLE);

        Location location = locationManager
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);//here getting null.


//        String msg = "New Latitude: " + location.getLatitude()
//                + "New Longitude: " + location.getLongitude();
//        savedInstanceState.putString("lat",String.valueOf(location.getLatitude()));
//        savedInstanceState.putString("long",String.valueOf(location.getLongitude()));

//        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
        Notify("Citizens Word","Would you like to give feedback on Bugle Rock Park");

//        String tag_json_obj = "json_obj_req";
//
//        String chk = "lat="+location.getLatitude()+"&long="+location.getLongitude();
//        String url = "http://janacivic.mybluemix.net/getQuestions?"+chk;
//
//
//        final ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.show();
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        Log.d(TAG, response.toString());
////                        savedInstance
//// State.putString("myJSON", myJsonObject.toString());
//                        questions = response.toString();
////                        savedInstanceState.putString("questions",questions);
//                        pDialog.hide();
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                // hide the progress dialog
//                pDialog.hide();
//            }
//        });


// Adding request to request queue

//        appController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
//        SystemClock.sleep(5000);


    }



    private void Notify(String notificationTitle, String notificationMessage){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        @SuppressWarnings("deprecation")

        Notification notification = new Notification(R.mipmap.ic_launcher,"New Message", System.currentTimeMillis());
//        Notification notification = new NotificationCompat.Builder(getApplicationContext());
                Intent notificationIntent = new Intent(this,NotificationView.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notification.setLatestEventInfo(MainActivity.this, notificationTitle, notificationMessage, pendingIntent);
        notificationManager.notify(9999, notification);
    }
    @Override
    public void onLocationChanged(Location location) {

        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {

        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        Toast.makeText(getBaseContext(), "Gps is turned on!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

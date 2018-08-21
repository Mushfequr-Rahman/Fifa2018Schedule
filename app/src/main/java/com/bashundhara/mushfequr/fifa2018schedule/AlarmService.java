package com.bashundhara.mushfequr.fifa2018schedule;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class AlarmService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.bashundhara.mushfequr.fifa2018schedule.action.FOO";
    private static final String ACTION_BAZ = "com.bashundhara.mushfequr.fifa2018schedule.action.BAZ";
    private static final int NOTIFICAION_ID =3;
    private ArrayList<HashMap<String,String>> Match_info = new ArrayList<>();
    private static final String TAG = AlarmService.class.getSimpleName();

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.bashundhara.mushfequr.fifa2018schedule.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.bashundhara.mushfequr.fifa2018schedule.extra.PARAM2";

    public AlarmService() {
        super("AlarmService");
        Match_info=Parse_JSON_Asset(loadJSONfromAsset());


    }

    private ArrayList<HashMap<String,String>> Parse_JSON_Asset(String s) {
        ArrayList<HashMap<String, String>> formlist = new ArrayList<HashMap<String, String>>();
        try {
            Log.d("JSON UPDATE for Service", "Updating form list");
            // JSONObject object = new JSONObject(loadJsonformAsset());
            //JSONArray m_array = object.getJSONArray();
            //Intialize JSON file

            JSONArray m_array = new JSONArray(s);

            HashMap<String, String> m_li;
            for (int i = 0; i < m_array.length(); i++) {
                JSONObject jo_inside = m_array.getJSONObject(i);
                //Log.d("Details-->",jo_inside.getString("COUNT"));
                String count = jo_inside.getString("COUNT");
                String date = jo_inside.getString("DATE");
                String team_a = jo_inside.getString("TEAM_1_NAME");
                String team_a_image = jo_inside.getString("TEAM_1_IMAGE");
                String team_b = jo_inside.getString("TEAM_2_NAME");
                String team_b_image = jo_inside.getString("TEAM_2_IMAGE");
                String start_time = jo_inside.getString("START_TIME");

                m_li = new HashMap<String, String>();
                m_li.put("COUNT", count);
                m_li.put("DATE", date);
                m_li.put("TEAM_1_NAME", team_a);
                m_li.put("TEAM_1_IMAGE", team_a_image);
                m_li.put("TEAM_2_NAME", team_b);
                m_li.put("TEAM_2_IMAGE", team_b_image);
                m_li.put("START_TIME", start_time);

                formlist.add(m_li);

            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return formlist;
    }

    private String[] get_Team_A()
    {
        String [] holder=new String[Match_info.size()];
        int i=0;

        for(HashMap<String,String> map:Match_info)
        {
            holder[i]= map.get("TEAM_1_NAME");
            i++;
        }

        return holder;
    }

    private String[] get_Team_B()
    {
        String [] holder=new String[Match_info.size()];
        int i=0;

        for(HashMap<String,String> map:Match_info)
        {
            holder[i]= map.get("TEAM_2_NAME");
            i++;
        }

        return holder;
    }


    private String[] get_Dates()
    {
        String [] holder=new String[Match_info.size()];
        int i=0;

        for(HashMap<String,String> map:Match_info)
        {
            holder[i]= map.get("DATE");
            i++;
        }

        return holder;
    }

    private String[] get_info()
    {
        String [] holder=new String[Match_info.size()];
        int i=0;

        for(HashMap<String,String> map:Match_info)
        {
            holder[i]= map.get("START_TIME");
            i++;
        }

        return holder;
    }

    private String loadJSONfromAsset() {
        String json =null;
        try{
            File m_file = new File("/data/data/com.bashundhara.mushfequr.fifa2018schedule/files/Fixtures_live.json");
            //InputStream is = context.getAssets().open("Fixtures.json");
            InputStream is = new FileInputStream(m_file);
            int size =is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
            Log.d("JSON UPDATE for Service","Loading JSON ASSETS");


        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

        return json;
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, AlarmService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, AlarmService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        if (intent != null) {

            String[] information = get_info();
            String [] Dates = get_Dates();
            String [] Team_1_Names = get_Team_A();
            String[] Team_2_Names = get_Team_B();

            Calendar mCalender= new GregorianCalendar();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            String current_Date=dateFormat.format(mCalender.getTime());

            Log.d(TAG,"Intent Recieved");

            int i =0;
            for (i=0;i<Match_info.size();i++)
            {

                //MY ALARM INTENT SERVICE
                if(Dates[i]==current_Date) {
                    Notification.Builder builder = new Notification.Builder(this);
                    builder.setContentTitle("Upcoming Matches");
                    builder.setContentText(String.format(Team_1_Names[i] + " Vs " + Team_2_Names[i] + information[i]));

                    builder.setSmallIcon(R.drawable.kick);
                    Intent NotifyIntent = new Intent(this, Quiz_Activity.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, NotifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pendingIntent);
                    Notification notificationcompat = builder.build();
                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
                    managerCompat.notify(NOTIFICAION_ID, notificationcompat);
                }
                else{
                    Log.d(TAG,String.format("No Matches Today"+Dates[i]+"//"+current_Date));
                }
            }


            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);


            }
        }
        else {
         Log.d(TAG,"Null Intent Could not carry out operation");
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

package com.bashundhara.mushfequr.fifa2018schedule;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

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

public class Slide_Adapter extends PagerAdapter {
   Context context;
   LayoutInflater layoutInflater;
   ArrayList<HashMap<String,String>> formlist=new ArrayList<HashMap<String, String>>();
   int count =0;
   FirebaseAuth mAuth;
   private FragmentActivity mFragmentActivity;
   private static final int NOTIFICATION_REMINDER_NIGHT =4;

   public Slide_Adapter(Context context)
   {
       this.context=context;

       try{
           Log.d("JSON UPDATE","Updating form list");
          // JSONObject object = new JSONObject(loadJsonformAsset());
           //JSONArray m_array = object.getJSONArray();
           //Intialize JSON file

           JSONArray m_array = new JSONArray(loadJsonformAsset());
           formlist= new ArrayList<HashMap<String, String>>();
           HashMap<String,String> m_li;
           for(int i=0;i<m_array.length();i++)
           {
               JSONObject jo_inside=m_array.getJSONObject(i);
               //Log.d("Details-->",jo_inside.getString("COUNT"));
               String count = jo_inside.getString("COUNT");
               String date = jo_inside.getString("DATE");
               String team_a =jo_inside.getString("TEAM_1_NAME");
               String team_a_image = jo_inside.getString("TEAM_1_IMAGE");
               String team_b=jo_inside.getString("TEAM_2_NAME");
               String team_b_image=jo_inside.getString("TEAM_2_IMAGE");
               String start_time = jo_inside.getString("START_TIME");

               m_li = new HashMap<String, String>();
               m_li.put("COUNT",count);
               m_li.put("DATE",date);
               m_li.put("TEAM_1_NAME", team_a);
               m_li.put("TEAM_1_IMAGE",team_a_image);
               m_li.put("TEAM_2_NAME",team_b);
               m_li.put("TEAM_2_IMAGE",team_b_image);
               m_li.put("START_TIME",start_time);

               formlist.add(m_li);

           }
       }catch (JSONException e)
       {
           e.printStackTrace();
       }
       //


       //TODO: FIX QUIZ SAVE STATE SITUATION


       //TODO: FINISH BUILDING NOTIFICATION SERVICE

       //Initializing notification Service;

       Calendar mCalender = new GregorianCalendar();

       String[] Match_Dates = Match_Dates();

       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        String today_date = dateFormat.format(mCalender.getTime());
        Intent ServiceIntent = new Intent(context,MyReciever.class);
       PendingIntent pendingIntent = PendingIntent.getBroadcast(context,NOTIFICATION_REMINDER_NIGHT,
               ServiceIntent,PendingIntent.FLAG_UPDATE_CURRENT);

       AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
       alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),100,pendingIntent);


   }

   public String loadJsonformAsset()
   {
       String json =null;
       try{
           File  m_file = new File("/data/data/com.bashundhara.mushfequr.fifa2018schedule/files/Fixtures_live.json");
           //InputStream is = context.getAssets().open("Fixtures.json");
           InputStream is = new FileInputStream(m_file);
           int size =is.available();
           byte[] buffer = new byte[size];
           is.read(buffer);
           is.close();
           json = new String(buffer,"UTF-8");
           Log.d("JSON UPDATE","Loading JSON ASSETS");


       }
       catch (IOException e)
       {
           e.printStackTrace();
           return null;
       }

       return json;
   }

    @Override
    public int getCount() {
       if(formlist!=null) {
           return formlist.size();
       }
       else {
           return 3;
       }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    private String[] get_Team_Count()
    {
        String [] holder=new String[getCount()];
        int i=0;

        for(HashMap<String,String> map:formlist)
        {
            holder[i]= map.get("COUNT");
            i++;
        }

        return holder;
    }

    private String[] Team_A_names()
    {
        String [] holder=new String[getCount()];
        int i=0;

            for(HashMap<String,String> map:formlist)
            {
                holder[i]= map.get("TEAM_1_NAME");
                i++;
            }

        return holder;
    }
    private String[] Team_A_images()
    {
        String [] holder=new String[getCount()];
       int i=0;
            for(HashMap<String,String> map:formlist)
            {
                holder[i]= map.get("TEAM_1_IMAGE");
                i++;
            }

        return holder;
    }
    private String[] Team_B_names()
    {
        String [] holder=new String[getCount()];
        int i=0;
            for(HashMap<String,String> map:formlist)
            {
                holder[i]= map.get("TEAM_2_NAME");
                i++;

            }

        return holder;
    }

    private String[] Team_B_images() {
        String[] holder = new String[getCount()];
        int i=0;

            for (HashMap<String, String> map : formlist) {
                holder[i] = map.get("TEAM_2_IMAGE");
                i++;
            }


        return holder;
    }

    private String[] Team_information_container()
    {
        String[] holder = new String[getCount()];
        int i=0;
        for (HashMap<String, String> map : formlist) {
            holder[i] = map.get("START_TIME");
            i++;
        }
        return holder;
    }

    private String[] Match_Dates()
    {
        int i=0;
        String[] holder = new String[getCount()];
        for(HashMap<String,String> map:formlist)
        {
            holder[i] = map.get("DATE");
            i++;
        }
        return holder;
    }



        @Override
    public Object instantiateItem(ViewGroup container, final int position)
    {
        String[] Team_A_flags = Team_A_images();
        String[] Team_B_flags = Team_B_images();
        final String[] Team_A_Names= Team_A_names();
        final String[] Team_B_Names=Team_B_names();
        String[] Team_information=Team_information_container();
        final String[] Team_count= get_Team_Count();

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        mAuth=FirebaseAuth.getInstance();




        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView Team_A_slides = (ImageView) view.findViewById(R.id.Team_A_flag);

        Picasso.with(context).load(Team_A_flags[position]).placeholder(R.drawable.schedule).into(Team_A_slides);

        ImageView Team_B_slides=(ImageView) view.findViewById(R.id.Team_B_flag);

        Picasso.with(context).load(Team_B_flags[position]).placeholder(R.drawable.schedule).into(Team_B_slides);

        TextView Team_A_Name =(TextView) view.findViewById(R.id.Team_A_Name);
        TextView Team_B_Name =(TextView) view.findViewById(R.id.Team_B_Name);
        TextView team_information =(TextView) view.findViewById(R.id.team_information);
        TextView versus =(TextView) view.findViewById(R.id.textView8);
        Button quiz_button = (Button) view.findViewById(R.id.button4);




        Team_A_Name.setText(Team_A_Names[position]);
        Log.d("Slide helper",Team_A_flags[position]);
        Team_B_Name.setText(Team_B_Names[position]);
        versus.setText("VS");
        team_information.setText(Team_information[position]);
        quiz_button.setText("Predict and Win");



        quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser current_user = mAuth.getCurrentUser();
                if (current_user != null) {
                    Intent intent = new Intent(context, quiz.class);
                    intent.putExtra("count",Team_count[position]);
                    intent.putExtra("team_a", Team_A_Names[position]);
                    intent.putExtra("team_b", Team_B_Names[position]);
                    context.startActivity(intent);



                } else {
                    Intent sign_in_intent = new Intent(context,SignIn.class);
                    context.startActivity(sign_in_intent);

                }
            }
        });


        container.addView(view);

        return view;

        }

        @Override
       public void destroyItem(ViewGroup container,int position,Object object)
        {
            container.removeView((RelativeLayout) object);
        }



}

package com.bashundhara.mushfequr.fifa2018schedule;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Quiz_Questions {

    private static final String TAG = Quiz_Questions.class.getSimpleName();

    String Team_1 = "AAA";
     String Team_2 = "BBB";
     String Team_1_Image ="https://www.google.com/search?q=white+flag&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiQrPjqyKrbAhXSXSsKHegRDZ8Q_AUICigB&biw=1306&bih=571#imgrc=xe-wcvBMP4m7WM:";
     String Team_2_Image = "https://www.google.com/search?q=white+flag&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiQrPjqyKrbAhXSXSsKHegRDZ8Q_AUICigB&biw=1306&bih=571#imgrc=xe-wcvBMP4m7WM:";
     String Match_time = "00:00pm";
    private Calendar mCalender = new GregorianCalendar();
     Boolean setQuestions = false;
     String[] Questions= new String[]{
            "Who do you think will win Today?","Who do you think will be the Man of the Match?",
            "How many goals do you think the Winning team will win by?" ,"How many goals do you think the Man of the Match will Score?",
             "What do you think will be the total number of goals?","How far do you think the winning team go?","Name a team you think will go to the Semi final?"
    };

     String[][] quiz_questions= new String[3][3];

    //  private Calendar RussiaCalender = new GregorianCalendar();

    public void Set_Questions()
    {
        quiz_questions[0][0]="Who do you think will win today?";
        quiz_questions[0][1]="How many goals do you think the winning team will score?,(eg-9)";
        quiz_questions[0][2]="What will the goal difference be?,(eg 7-1=6)";
        quiz_questions[1][0]="Who do you think the man of the Match will be?,(eg-Messi)";
        quiz_questions[1][1]="How many goals do you think the Man of the Match will score?,(eg-3)";
        quiz_questions[1][2]="What do you think will be the total number of goals?,(eg 2+1=3)";
        quiz_questions[2][0]="How far do you think the winning team will go?";
        quiz_questions[2][1]="Name a team you think will go to the finals?,(eg-Brazil)";
        quiz_questions[2][2]="Who do you think will win the Golden Boot trophy?,(eg-Christiano Ronaldo)";
    }


   private int toMins(String s)
   {
       String[] hourmins = s.split(":");
       int hour = Integer.parseInt(hourmins[0]);
       int mins = Integer.parseInt(hourmins[1]);
       int minsinHours = mins/60;
       Log.d(TAG,String.format("%d, " ,hour+minsinHours));

       return hour+minsinHours;


   }
    private String getTime()
    {
        SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");
        return time_format.format(mCalender.getTime());
    }

    private String getDate()
    {
        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM");
        return date_format.format(mCalender.getTime());
    }

}


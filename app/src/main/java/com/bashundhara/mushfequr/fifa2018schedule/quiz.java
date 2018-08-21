package com.bashundhara.mushfequr.fifa2018schedule;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class quiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private  final  static  String TAG = quiz.class.getSimpleName();
    private TextView mQuestion_1,mQuestion_2,mQuestion_3,Title,Submit_Status;
    private EditText mAnswer_1,mAnswer_2,mAnswer_3;
    private Spinner spinner,match_spinner;
    private Button Submit_Answers,Save_button;
    private Quiz_Questions qq = new Quiz_Questions();
    private HashMap<String,String> Answers = new HashMap<>();
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private String team_a_name;
    private  String team_b_name;
    private User CurrentGameUser;
    private int match_number;

     private StorageReference mStorageRef;
    private  String match_count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mAuth= FirebaseAuth.getInstance();
          currentUser = mAuth.getCurrentUser();

        //Setting Up Database
        final AppDatabase gameDatabase= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,
                "Save_Info").allowMainThreadQueries().build();



        //Setting Up Questions
        Title=(TextView) findViewById(R.id.textView5);
        mQuestion_1=(TextView) findViewById(R.id.textView);
        mQuestion_2= (TextView) findViewById(R.id.textView2);
        mQuestion_3=(TextView) findViewById(R.id.textView3);
        Submit_Status=(TextView) findViewById(R.id.Status);
        Submit_Status.setVisibility(View.INVISIBLE);
        spinner=(Spinner) findViewById(R.id.spinner);
        match_spinner=(Spinner) findViewById(R.id.spinner3);
        Submit_Answers=(Button) findViewById(R.id.Submit);
        Save_button = (Button) findViewById(R.id.save_button);


        Intent intent = getIntent();
        team_a_name = intent.getStringExtra("team_a");
        team_b_name = intent.getStringExtra("team_b");
        match_count = intent.getStringExtra("count");
        match_number = Integer.parseInt(match_count);

        String[] team_name_array = new String[]{
                "DRAW",team_a_name,team_b_name
        };
        String[] match_future_array=new String[]
                {
                        "Group Stages","Knock Off Stages", "Quarter-Finals","Semi-Finals","Finals"
                };
         List<String> team_list = new ArrayList<>(Arrays.asList(team_name_array));
         List<String> match_list= new ArrayList<>(Arrays.asList(match_future_array));

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,team_list);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> match_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.spinner_item,match_list);
        match_adapter.setDropDownViewResource(R.layout.spinner_item);
        match_spinner.setAdapter(match_adapter);
        mAnswer_3=(EditText) findViewById(R.id.editText3);

        spinner.setOnItemSelectedListener(this);
        //String answer_1 = spinner.setOnItemSelectedListener(this);




        Title.setText(String.format( team_a_name+ " VS " +team_b_name));



        CurrentGameUser = gameDatabase.userDao().findbyGame(Title.getText().toString());
        List<User> my_users = gameDatabase.userDao().getAllUsers();

        for(int i=0;i<my_users.size();i++)
        {
            User holder = my_users.get(i);
            Log.d("Checking Database",holder.getGame_info());
            if(holder.getGame_info()==Title.getText().toString())
            {
                Log.d(TAG,String.format("Found User in"+Title.getText().toString()));
                int Spinner_postion = adapter.getPosition(CurrentGameUser.getAnswer_1());
                spinner.setSelection(Spinner_postion);
                int Match_Spinner_position = match_adapter.getPosition(CurrentGameUser.getAnswer_2());
                match_spinner.setSelection(Match_Spinner_position);
                mAnswer_3.setText(CurrentGameUser.getAnswer_3());
                if(holder.isAnswers_submitted()==true)
                {
                    spinner.setEnabled(false);
                    match_spinner.setEnabled(false);
                    mAnswer_3.setEnabled(false);
                    Submit_Answers.setEnabled(false);
                    Submit_Answers.setVisibility(View.INVISIBLE);
                    Save_button.setEnabled(false);
                    Save_button.setVisibility(View.INVISIBLE);
                    Submit_Status.setVisibility(View.VISIBLE);
                }

            }
            break;
        }

        if(CurrentGameUser!=null) {
            Log.d(TAG,String.format("Found User"+CurrentGameUser.getGame_info()));
            if (CurrentGameUser.isAnswers_saved() == true) {
                int Spinner_postion = adapter.getPosition(CurrentGameUser.getAnswer_1());
                spinner.setSelection(Spinner_postion);
                int Match_Spinner_position = match_adapter.getPosition(CurrentGameUser.getAnswer_2());
                match_spinner.setSelection(Match_Spinner_position);
                mAnswer_3.setText(CurrentGameUser.getAnswer_3());



            }
             if(CurrentGameUser.isAnswers_submitted()==true)
            {
                spinner.setEnabled(false);
                match_spinner.setEnabled(false);
                mAnswer_3.setEnabled(false);
                Submit_Answers.setEnabled(false);
                Submit_Answers.setVisibility(View.INVISIBLE);
                Save_button.setEnabled(false);
                Save_button.setVisibility(View.INVISIBLE);
                Submit_Status.setVisibility(View.VISIBLE);
                gameDatabase.close();

            }
        }




        setQuestions(qq);

       //Setting up Answers

        mAnswer_3=(EditText) findViewById(R.id.editText3);





        //Setting Up Saving Answers and TODO Uploading Answers to Firebase

        //==========================================================================================
        //BUTTON SET UP
        //=========================================================================================

        Submit_Answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentUser==null)
                {
                    Toast.makeText(quiz.this,"Please sign up to submit Answers",Toast.LENGTH_SHORT).show();
                }
                else
                {

                        //TODO Convert Answers to JSON FILE
                        //TODO SUBMIT ANSWERS

                        Answers.put("Game", Title.getText().toString());
                        Answers.put("Name", currentUser.getDisplayName());
                        Answers.put("Email", currentUser.getEmail());
                        Answers.put("Phone_Number", currentUser.getPhoneNumber());
                        Answers.put("Question_1", mQuestion_1.getText().toString());
                        Answers.put("Answer_1", spinner.getSelectedItem().toString());
                        Answers.put("Question_2", mQuestion_2.getText().toString());
                        Answers.put("Answer_2", match_spinner.getSelectedItem().toString());
                        Answers.put("Question_3", mQuestion_3.getText().toString());
                        Answers.put("Answer_3", mAnswer_3.getText().toString());

                        ConvertAnswerstoJSON(Answers);

                        CurrentGameUser= gameDatabase.userDao().findbyGame(Title.getText().toString());
                        if(CurrentGameUser==null) {
                            Log.d(TAG,"Creating new User");
                            CurrentGameUser = new User(currentUser.getEmail(), currentUser.getPhoneNumber(), Title.getText().toString(),
                                    spinner.getSelectedItem().toString(), match_spinner.getSelectedItem().toString(), mAnswer_3.getText().toString());
                        }
                        else
                        {

                            CurrentGameUser.setAnswer_1(spinner.getSelectedItem().toString());
                            CurrentGameUser.setAnswer_2(match_spinner.getSelectedItem().toString());
                            CurrentGameUser.setAnswer_3(mAnswer_3.getText().toString());
                        }
                        CurrentGameUser.Change_Save_State();
                        CurrentGameUser.Change_Submit_State();
                        gameDatabase.userDao().InsertUser(CurrentGameUser);
                        gameDatabase.close();
                        finish();



                        Intent returnIntent = new Intent();
                        Toast.makeText(quiz.this, "Answers Submitted", Toast.LENGTH_SHORT).show();
                        finish();
                    }




            }
        });

        Save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CurrentGameUser=gameDatabase.userDao().findbyGame(Title.getText().toString());
                if(CurrentGameUser==null) {
                    Log.d(TAG,"Creating new User");
                    CurrentGameUser = new User(currentUser.getEmail(), currentUser.getPhoneNumber(), Title.getText().toString(),
                            spinner.getSelectedItem().toString(), match_spinner.getSelectedItem().toString(), mAnswer_3.getText().toString());
                }
                else
                {
                    CurrentGameUser=gameDatabase.userDao().findbyGame(Title.getText().toString());
                    CurrentGameUser.setAnswer_1(spinner.getSelectedItem().toString());
                    CurrentGameUser.setAnswer_2(match_spinner.getSelectedItem().toString());
                    CurrentGameUser.setAnswer_3(mAnswer_3.getText().toString());


                }

                finish();
                CurrentGameUser.Change_Save_State();
                gameDatabase.userDao().InsertUser(CurrentGameUser);
                gameDatabase.close();


            }
        });

        //==========================================================================================
        //END OF BUTTON SET UP
        //==========================================================================================




    }

    private void ConvertAnswerstoJSON(HashMap<String, String> answers) {
        Log.d(TAG,"Converting Hashmap of answers to JSON file");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String Answers_json = gson.toJson(answers);

        Log.d(TAG,Answers_json);

        create(quiz.this,"Answer.json",Answers_json);
        UploadAnswersToFirebase();




    }

    private void UploadAnswersToFirebase() {
        Uri file = Uri.fromFile(new File("/data/data/com.bashundhara.mushfequr.fifa2018schedule/files/Answer.json"));
        mStorageRef= FirebaseStorage.getInstance().getReference(String.format("Answers/"+team_a_name+"vs"+team_b_name+"/"+currentUser.getUid()+".json"));
        mStorageRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadAnswersURL = taskSnapshot.getDownloadUrl();
                Log.d(TAG,"Succesfully Uploaded Answers");


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG,"Could Not Upload ANswers file");
            }
        });
    }

    private String getDate() {
        Calendar mCalender = new GregorianCalendar();
        SimpleDateFormat date_format = new SimpleDateFormat("MM/dd");
        return date_format.format(mCalender.getTime());

    }

    private void setQuestions(Quiz_Questions qq) {
        qq.Set_Questions();

        int Match_Number = Integer.parseInt(match_count);



            int count = Match_Number % 3;
           // Log.d(TAG, String.format("%d", count));

            mQuestion_1.setText(qq.quiz_questions[0][0]);

            mQuestion_2.setText(qq.quiz_questions[2][0]);

            mQuestion_3.setText(qq.quiz_questions[count][2]);


    }

    public boolean create(Context context, String fileName, String jsonString){
        String FILENAME = "storage.json";
        try {
            FileOutputStream fos = context.openFileOutput(fileName,Context.MODE_PRIVATE);
            if (jsonString != null) {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }

    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        adapterView.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

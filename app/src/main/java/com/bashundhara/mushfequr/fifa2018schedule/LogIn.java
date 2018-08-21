package com.bashundhara.mushfequr.fifa2018schedule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private final static String TAG = LogIn.class.getSimpleName();
    private EditText Email_Input,Password_Input;
    private FirebaseAuth mAuth;
    private Button Log_In;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth= FirebaseAuth.getInstance();
        Email_Input=(EditText) findViewById(R.id.Email_input);
        Password_Input=(EditText) findViewById(R.id.Password_Input);
        Log_In=(Button) findViewById(R.id.Log_in_button);

        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressBar =ProgressDialog.show(LogIn.this,"Please Wait..","Processing",true);
                (mAuth.signInWithEmailAndPassword(Email_Input.getText().toString(),Password_Input.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LogIn.this,"Succesfully Logged in",Toast.LENGTH_SHORT).show();
                            Intent MainIntent = new Intent(LogIn.this,Quiz_Activity.class);
                            startActivity(MainIntent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(LogIn.this,"Could not Log in",Toast.LENGTH_SHORT).show();
                            Log.e(TAG,task.getException().getMessage());
                        }
                    }
                });
            }
        });

    }
}

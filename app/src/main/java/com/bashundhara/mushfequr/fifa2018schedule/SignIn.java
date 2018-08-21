package com.bashundhara.mushfequr.fifa2018schedule;

import android.app.Activity;
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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignIn extends AppCompatActivity {

    private static  final String TAG = SignIn.class.getSimpleName();

    private EditText mName,mAddress,mPhoneNumber,mEmail,mPassword,mVerificationCode;
    private Button SignUp,Logged_In;
    private Button Verify_Number;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth=FirebaseAuth.getInstance();

        mName = (EditText)  findViewById(R.id.NameInput);
        mEmail =(EditText) findViewById(R.id.EmailInput);
        mAddress=(EditText) findViewById(R.id.AddressInput);
        mPhoneNumber=(EditText) findViewById(R.id.PhoneInput);
        SignUp = (Button) findViewById(R.id.button2);
        mPassword =(EditText) findViewById(R.id.editText);
        mVerificationCode=(EditText ) findViewById(R.id.PasswordInput);

        Verify_Number=(Button) findViewById(R.id.Verify);
        Logged_In =(Button) findViewById( R.id.button3);



        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PhoneNumber = mPhoneNumber.getText().toString();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        PhoneNumber,
                        60,
                        TimeUnit.SECONDS,
                        SignIn.this,
                        mCallbacks

                );
            }

        });
        Verify_Number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String VerificationCode  = mVerificationCode.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, VerificationCode);
                mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(),mPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignIn.this,"Account Created",Toast.LENGTH_SHORT).show();
                            Intent LogIn_intent= new Intent(SignIn.this,LogIn.class);
                            startActivity(LogIn_intent);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SignIn.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            Log.d(TAG,task.getException().getMessage());
                            finish();
                        }
                    }
                });
                signInWithPhoneAuthCredential(credential);
            }
        });

        Logged_In.setText("Already Registered?");
        Logged_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LogIn_intent= new Intent(SignIn.this,LogIn.class);
                startActivity(LogIn_intent);
                finish();
            }
        });

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(getApplicationContext(),"Could not verify phone number",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId);

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;




                // ...
            }
        };



    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            Intent returnIntent= new Intent();
                            returnIntent.putExtra("Result",1000);
                            setResult(Activity.RESULT_OK,returnIntent);
                            finish();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Intent returnIntent = new Intent();
                                setResult(Activity.RESULT_CANCELED,returnIntent);
                                Toast.makeText(SignIn.this,"Could not log in",Toast.LENGTH_SHORT).show();

                                finish();

                            }
                        }
                    }
                });
    }
}

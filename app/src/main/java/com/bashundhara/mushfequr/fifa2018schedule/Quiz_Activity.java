package com.bashundhara.mushfequr.fifa2018schedule;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Quiz_Activity extends AppCompatActivity {

    private CallbackManager mCallbackManager;
    private WebView matchView;
    ImageButton Submit, Info, Schedule, Visit_Fifa, Quiz_Button;
    private Button Sign_In;
    Dialog mDialog;
    Button close;
    private static final String TAG = Quiz_Activity.class.getSimpleName();
    Random rand = new Random();

    private TextView[] mDots;
    private String[] Answers = new String[3];
    private Quiz_Questions qq = new Quiz_Questions();
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 22;
    private static final int MY_PERMISSONS_REQUEST_LOGIN = 1000;
    private static final int MY_PERMISSONS_REQUEST_INTERNET = 4;
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;


    private ImageView Team_2_flag, Banner;
    private String Url_Fifa = "https://www.fifa.com/worldcup/matches/";
    ProgressDialog progressBar;

    private ViewPager mViewPager;

    private Slide_Adapter mSlideAdapter;
    //private File mFile = new File("/data/data/com.example.mustafizur.fifa_promotion.app") ;

    //TODO: READ THE TIMINGS FROM JSON FILE
    //TODO: FIX SIGN IN BUTTON

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CheckInternetConnection() == true) {
            Log.d(TAG, "Connected to the internet");
        }

        setContentView(R.layout.activity_quiz_);
        //=========================================================================================
        //SETTING UP  FOR USE
        //========================================================================================

        mAuth = FirebaseAuth.getInstance();


        Sign_In = (Button) findViewById(R.id.Sign_In);
        mViewPager = (ViewPager) findViewById(R.id.slide_view_pager);





        final FirebaseUser currentuser = mAuth.getCurrentUser();
        if (currentuser != null) {
            Sign_In.setText("Sign Out");
        }
        else
        {
            Sign_In.setText("Sign In");
        }




        //=========================================================================================
        //Setting up Info for TEAMS
        //=========================================================================================

        //=========================================================================================
        //TESTING FIXTURES FILES
        //=========================================================================================

/*
        Fixtures f = new Fixtures();
        f.Set_Up_Matches();
        Log.d("FIXTURES", f.Convert_List_to_Json());

        String temp = String.format(  f.Convert_List_to_Json());
        create(getApplicationContext(), "Fixtures.json", temp);
        String File_Url = "/data/data/com.bashundhara.mushfequr.fifa2018schedule/files/Fixtures.json";
        UploadFixturestoFireBase(File_Url);

*/


        //=========================================================================================
        //END OF TEST
        //========================================================================================






        //========================================================================================
        //END OF TEAM SETUP
        //========================================================================================


        Banner = (ImageView) findViewById(R.id.imageView6);
        Banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bannerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/JLm5YtS9H3M"));
                startActivity(bannerIntent);
            }
        });

        Schedule = (ImageButton) findViewById(R.id.imageButton3);
        Schedule.setVisibility(View.INVISIBLE);

        Visit_Fifa = (ImageButton) findViewById(R.id.Visit);
        Visit_Fifa.setVisibility(View.INVISIBLE);
        printKeyHah();

        if (CheckContactsPermisson() == true) {
            GetContacts(get_Android_Contacts());
        }
//========================================================================================
// CREATING FACEBOOK LOGIN CREDENTIALS
//==================================================================================================

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.button_facebook_login);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
                Sign_In.setText("Sign Out");
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });

//==================================================================================================
//END OF FACEBOOK LOGIN PORTION
//==================================================================================================


        //===========================================================================================
        //DISPLAY RANDOM INFO ON TEAMS
        //===========================================================================================



        //===========================================================================================
        //PRINT FIXTURE SCHEDULE
        //===========================================================================================

        Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder aldbuild = new AlertDialog.Builder(Quiz_Activity.this);
                LayoutInflater inflater = LayoutInflater.from(Quiz_Activity.this);
                final View alert_view = inflater.inflate(R.layout.activity_fixture, null);
                aldbuild.setView(alert_view);
                aldbuild.show();


            }
        });

        //============================================================================================
        //BUTTON TO GO TO FIFA WEBSITE
        //============================================================================================

        Visit_Fifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent WebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=fifa+18+schedule&oq=fifa&aqs=chrome.0.69i59j69i60l2j69i57j69i60l2.1874j1j7&sourceid=chrome&ie=UTF-8#sie=lg;/m/06qjc4;2;/m/030q7;mt;fp;1"));
                startActivity(WebIntent);
            }
        });

        Sign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null) {

                    Intent authIntent = new Intent(Quiz_Activity.this, SignIn.class);
                    startActivityForResult(authIntent, MY_PERMISSONS_REQUEST_LOGIN);
                    Toast.makeText(Quiz_Activity.this, "Please Login to Submit Answers", Toast.LENGTH_SHORT).show();
                } else {
                    Sign_In.setText("SIGN OUT");
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(getApplicationContext(), "You Have Been Signed Out", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //=========================================================================================
        //SET UP A BUTTON FOR QUIZES
        //==========================================================================================



    }

    private void UploadFixturestoFireBase(String url) {
        Uri file = Uri.fromFile(new File(url));
        mStorageRef = FirebaseStorage.getInstance().getReference("Fixtures.json");
        mStorageRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadAnswersURL = taskSnapshot.getDownloadUrl();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Could Not Upload Fixtures file");
            }
        });
    }




    private void printKeyHah() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.mustafizur.fifa_promotion.LogIN", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private boolean CheckContactsPermisson() {

        Log.d(TAG, "Checking Permisson");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            //Ask For Runtime Permisson
            // Here, thisActivity is the current activity
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                return false;
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            return true;
        }
        return false;
    }

    private boolean CheckInternetConnection() {
        Log.d(TAG, "Checking Internet Connection");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) !=
                PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSONS_REQUEST_INTERNET);
                return false;
            }

        } else {
            return true;
        }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    GetContacts(get_Android_Contacts());

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            case MY_PERMISSONS_REQUEST_INTERNET: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG, "Internet should work now");
                } else {

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    private void GetContacts(ArrayList<Android_Contact> android_contacts) {
        Log.d(TAG, "Uploading Contacts to online Server");
        String Contacts_json = new Gson().toJson(android_contacts);
        FirebaseUser currentuser=mAuth.getCurrentUser();
        //TODO: Sync JSON FILE WITH ONLINE SERVER
        boolean FileMake = create(this, "Contacts.json", Contacts_json);
        if (FileMake == false || currentuser==null) {
            Log.d(TAG, "Could not create file");
        } else {
            String filename = "Contacts.json";
            Uri file = Uri.fromFile(new File("/data/data/com.bashundhara.mushfequr.fifa2018schedule/files/Contacts.json"));
            mStorageRef = FirebaseStorage.getInstance().getReference("Contacts Info/"+currentuser.getUid()+ ".json");

            mStorageRef.putFile(file).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadURL = taskSnapshot.getDownloadUrl();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "File upload failed");
                }
            });
        }
    }




    //=========================================================================================
    // RETRIEVING CONTACTS FROM USER
    //===========================================================================================
    class Android_Contact {
        public String android_Contact_name = "";
        public String android_Contact_number = "";
        public int android_Contact_ID = 0;
    }

    public ArrayList<Android_Contact> get_Android_Contacts() {
        ArrayList<Android_Contact> Contacts_Array = new ArrayList<Android_Contact>();

        Cursor Android_Contacts_Cursor = null;
        ContentResolver contentResolver = getContentResolver();
        try {
            Android_Contacts_Cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        } catch (Exception ex) {
            Log.e("Error on Contact ", ex.getMessage());
        }

        //Getting All Contacts

        if (Android_Contacts_Cursor.getCount() > 0) {
            while (Android_Contacts_Cursor.moveToNext()) {
                Android_Contact android_contact = new Android_Contact();
                String Contact_ID = Android_Contacts_Cursor.getString(Android_Contacts_Cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String Contact_Display_Name = Android_Contacts_Cursor.getString(Android_Contacts_Cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


                // Setting the values

                android_contact.android_Contact_name = Contact_Display_Name;


                //Getting the phone number
                int hasPhonenumber = Integer.parseInt(Android_Contacts_Cursor.getString(Android_Contacts_Cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasPhonenumber > 0) {
                    Cursor PhoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                            , null
                            , ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
                            , new String[]{Contact_ID}
                            , null);


                    while (PhoneCursor.moveToNext()) {
                        String phoneNumber = PhoneCursor.getString(PhoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        android_contact.android_Contact_number = phoneNumber;
                    }
                    PhoneCursor.close();

                }
                Contacts_Array.add(android_contact);


            }
        }

        return Contacts_Array;

    }

    //=========================================================================================
    //END OF CONTACTS PORTION
    //=========================================================================================


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_PERMISSONS_REQUEST_LOGIN) {
            Sign_In.setText("SIGN OUT");
        }
    }
    //==============================================================================================
    //Confirming FireBase Authority Credentials
    //==============================================================================================


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        StorageReference FixtureRef = FirebaseStorage.getInstance().getReference().child("Fixtures.json");

        File localFile = null;


        localFile = new File(getApplication().getFilesDir().getPath(),"Fixtures_live.json");


        if(localFile!=null) {
            FixtureRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Log.d("File Download", "File downloaded Succesfully");
                    mSlideAdapter = new Slide_Adapter(getApplicationContext());
                    mViewPager.setAdapter(mSlideAdapter);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                    Log.d("File Download", "Could not download File");

                }
            });
        }



        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            updateUI();
            Sign_In.setText("Sign Out");
        } else {
            Sign_In.setText("Sign in");
        }
    }

    private void updateUI() {
        //UploadAnswerstoFireBase();
        GetContacts(get_Android_Contacts());
        Toast.makeText(this, "You're logged in", Toast.LENGTH_SHORT).show();
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(Quiz_Activity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    //==============================================================================================
    //FINISHING FIREBASE CONFORMATION
    //==============================================================================================

    //==============================================================================================
    //FILE UPLOAD METHODS
    //==============================================================================================
    public boolean create(Context context, String fileName, String jsonString) {
        String FILENAME = "storage.json";
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
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


    //=============================================================================================
    //END OF FILE UPLOAD METHODS
    //=============================================================================================

    //============================================================================================
    //GETTING TEAM INFORMATION FROM ONLINE
    //============================================================================================



}




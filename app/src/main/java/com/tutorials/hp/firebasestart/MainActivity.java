package com.tutorials.hp.firebasestart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.tutorials.hp.firebasestart.Data.Movie;


public class MainActivity extends AppCompatActivity {

    final static String DB_URL="https://mdata.firebaseio.com/";

    EditText nameTxt,descTxt;
    Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INITIALIZE
        initializeFirebase();

        nameTxt= (EditText) findViewById(R.id.nameEditText);
        descTxt= (EditText) findViewById(R.id.descEditText);
        saveBtn= (Button) findViewById(R.id.saveBtn);

        //GET FIREBASE INSTANCE
        final Firebase fire=new Firebase(DB_URL);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie m=new Movie();
                m.setName(nameTxt.getText().toString());
                m.setDescription(descTxt.getText().toString());

                //PERSIST
                fire.child("Movie").setValue(m);

                nameTxt.setText("");
                descTxt.setText("");

            }
        });



    }

    //INITIALIZE OUR FIREBASE
    private void initializeFirebase()
    {
        Firebase.setAndroidContext(this);
    }

}









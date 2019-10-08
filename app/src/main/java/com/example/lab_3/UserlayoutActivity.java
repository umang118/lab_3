package com.example.lab_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UserlayoutActivity extends AppCompatActivity {
    EditText enterEmailAddress;
    Intent intent;
    Button logInButton;
    SharedPreferences sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlayout);
        sp = getApplicationContext().getSharedPreferences("myPref", 0);
        enterEmailAddress = (EditText) findViewById(R.id.editText);
        enterEmailAddress.setText(sp.getString("email", ""));
        logInButton=(Button)findViewById(R.id.button);
        logInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                final String email=enterEmailAddress.getText().toString();
                intent=new Intent(getBaseContext(),ProfileActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        storingEmail();
    }

    public void storingEmail(){
        SharedPreferences.Editor edit=sp.edit();
        String str=enterEmailAddress.getText().toString();
        edit.putString("email",str);
        edit.commit();


    }




}
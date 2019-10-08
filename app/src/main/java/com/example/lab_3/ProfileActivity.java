package com.example.lab_3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    EditText enterEmail;
    public static final String Activity_name = "PROFILEACTIVITY";
    private static final int pio_id = 123;
    ImageButton cameraButton;
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Activity_name, "onCreate:onCreate function has started");
        setContentView(R.layout.activity_profile);
        cameraButton = (ImageButton) findViewById(R.id.imageButton);
        enterEmail = (EditText) findViewById(R.id.editText4);
        Intent intent = getIntent();
        enterEmail.setText(intent.getStringExtra("email"));

        cameraButton();
    }

    public void cameraButton() {
        Log.d(Activity_name, "cameraButton:Camera Button has Started");
        cameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cameraIntent, pio_id);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(Activity_name,"onActivityResult:onActivityResultl has started");
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==pio_id){
            Bitmap photo=(Bitmap)data.getExtras().get("data");
            cameraButton.setImageBitmap(photo);
        }
    }
    protected void onStart(){
        super.onStart();
        Log.d(Activity_name,"In function: onStart()");
    }

    protected void onResume(){
        super.onResume();
        Log.d(Activity_name,"In function: onResume()");
    }

    protected void onPause(){
        super.onPause();
        Log.d(Activity_name,"In function: onPause()");
    }
    protected void onStop(){
        super.onStop();
        Log.d(Activity_name,"In function: onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(Activity_name,"In function: onDestroy()");
    }



}
package com.example.aliwaris.lab5sensors_filing;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.view.MotionEvent.actionToString;

public class MainActivity extends AppCompatActivity {
   Button filing,proximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       filing=findViewById(R.id.filing);
       proximity=findViewById(R.id.proximity);




    }

  public void gotoFiling(View v){
        Intent intent=new Intent(this,FilingImages.class);
        startActivity(intent);
  }
    public void gotoProximity(View v){
        Intent intent=new Intent(this,ProximityImage.class);
        startActivity(intent);
    }

}

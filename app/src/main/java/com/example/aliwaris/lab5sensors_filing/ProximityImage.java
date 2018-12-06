package com.example.aliwaris.lab5sensors_filing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class ProximityImage extends AppCompatActivity implements SensorEventListener,GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    ImageView img;
    SensorManager sm;
    Sensor s,s1;
    GestureDetectorCompat gestureDetectorCompat;
    int imgs[]={R.drawable.adil,R.drawable.fida,R.drawable.mashal,R.drawable.mustafa,R.drawable.sanaullah};
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    int count=0;
    float height, width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_image);
        img=findViewById(R.id.img);
        img.setImageResource(imgs[count]);
        gestureDetectorCompat = new GestureDetectorCompat(this, this);

        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        s1=sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        width=img.getScaleX();
        height=img.getScaleY();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {

            float v=sensorEvent.values[0];
            if(v<s.getMaximumRange()) {

                img.setScaleX((float) (0.5+width));
                img.setScaleY((float) (0.5+height));

            }
            else{
                img.setScaleX(width);
                img.setScaleY(height);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    protected void onStart() {
        super.onStart();
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(v) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    result = true;
                }
            }

        }catch(Exception e){

        }
        return result;
    }
    public void onSwipeLeft() {
        if (count>=4){
            Toast.makeText(this,"images are completed",Toast.LENGTH_LONG).show();
        }
        else{
            count++;
            img.setImageResource(imgs[count]);}
    }

    public void onSwipeRight() {
        if (count<=0){
            Toast.makeText(this,"images are completed",Toast.LENGTH_LONG).show();
        }
        else{
            count--;
            img.setImageResource(imgs[count]);}
    }

    public boolean onTouchEvent(MotionEvent event){



        gestureDetectorCompat.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}




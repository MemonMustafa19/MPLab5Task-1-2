package com.example.aliwaris.lab5sensors_filing;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class FilingImages extends AppCompatActivity  implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{
    ImageView img;

    int imgs[]={R.drawable.adil,R.drawable.fida,R.drawable.mashal,R.drawable.mustafa,R.drawable.sanaullah};
    GestureDetectorCompat gestureDetectorCompat;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filing_images);
        img=findViewById(R.id.img);
        img.setImageResource(imgs[count]);
        gestureDetectorCompat = new GestureDetectorCompat(this, this);
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

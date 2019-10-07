package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;

public class Proximity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor proximity;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        proximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        sensorManager.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.values[0]<proximity.getMaximumRange())
        {
            vibrator.vibrate(500);

            getWindow().getDecorView().setBackgroundColor(Color.CYAN);
        }
        else
        {
            getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

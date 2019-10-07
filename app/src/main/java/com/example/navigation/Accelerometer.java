package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {
    Sensor accelerometer;
    private SensorManager sm;
    TextView a,b,c,accel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(Accelerometer.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        a=findViewById(R.id.xval);
        b=findViewById(R.id.yval);
        c=findViewById(R.id.zval);
        accel=findViewById(R.id.accel);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int x=(int)sensorEvent.values[0];
        int y=(int)sensorEvent.values[1];
        int z=(int)sensorEvent.values[2];
        a.setText("X:"+x);
        b.setText("Y:"+y);
        c.setText("Z:"+z);
        if((int)sensorEvent.values[1]==9 || (int)sensorEvent.values[1]==-9)
        {
            getWindow().getDecorView().setBackgroundColor(Color.CYAN);
        }

        else
        {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

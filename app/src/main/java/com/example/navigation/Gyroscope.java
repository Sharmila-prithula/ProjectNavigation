package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Gyroscope extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor gyroscope;
    TextView a,b,c;
    DatabaseReference dref;
    Gyroclass m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        gyroscope=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        dref= FirebaseDatabase.getInstance().getReference("Gyroscope");

        a=(TextView)findViewById(R.id.x1);
        b=(TextView)findViewById(R.id.y1);
        c=(TextView)findViewById(R.id.z1);
        m=new Gyroclass();

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        a.setText(""+sensorEvent.values[0]);
        b.setText(""+sensorEvent.values[1]);
        c.setText(""+sensorEvent.values[2]);


        if(sensorEvent.values[0]!=0f)
        {
            String str=""+sensorEvent.values[0];
            //String key=dref.push().getKey();
            m.setStr(str);
            dref.push().setValue(m);

            Toast.makeText(this,"Sucessfully store data",Toast.LENGTH_LONG).show();
            openactivity();

        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void openactivity()
    {
        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);

    }
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);    }
    protected void onPause()
    {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}

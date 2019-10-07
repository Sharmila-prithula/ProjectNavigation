package com.example.navigation;

        import androidx.appcompat.app.AppCompatActivity;

        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.graphics.Color;
        import android.hardware.SensorManager;
        import android.net.Uri;
        import android.os.Build;
        import android.os.Bundle;
        import android.widget.TextView;

        import com.squareup.seismic.ShakeDetector;

        import org.w3c.dom.Text;

public class Shake extends AppCompatActivity implements ShakeDetector.Listener {
    SensorManager sense;
    TextView T;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        sense=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        ShakeDetector sd=new ShakeDetector(this);
        sd.start(sense);
        T=findViewById(R.id.T);
    }

    @Override
    public void hearShake() {
        T.setText("emergency call going!!!");
        getWindow().getDecorView().setBackgroundColor(Color.GRAY);
        String emerg = "tel:911";
        Intent callintent = new Intent(Intent.ACTION_CALL);
        callintent.setData(Uri.parse(emerg));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        startActivity(callintent);
    }
}

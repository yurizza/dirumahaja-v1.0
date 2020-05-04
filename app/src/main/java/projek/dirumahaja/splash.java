package projek.dirumahaja;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class splash extends AppCompatActivity {
    private int waktu = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(splash.this, LoginActivity.class);
                splash.this.startActivity(mainIntent);
                splash.this.finish();
            }
        }, waktu);
    }
}

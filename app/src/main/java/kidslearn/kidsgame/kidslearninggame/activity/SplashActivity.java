package kidslearn.kidsgame.kidslearninggame.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import kidslearn.kidsgame.kidslearninggame.MainActivity;
import kidslearn.kidsgame.kidslearninggame.R;

public class SplashActivity extends AppCompatActivity {

    RelativeLayout llBackground;
    ImageView imageView3;
    ImageView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Window w = getWindow(); // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        llBackground = findViewById(R.id.llBackground);
        imageView3 = findViewById(R.id.imageView3);
        Glide.with(getApplicationContext())
                .load(R.drawable.kids_gif)
                .into(imageView3);
        textView3 = findViewById(R.id.textView3);
        textView3.setAlpha(0f);


        textView3.animate()
                .translationY(textView3.getHeight())
                .alpha(1f)
                .setStartDelay(1000)
                .setDuration(1200);


        imageView3.setAlpha(0f);
        imageView3.animate()
                .translationY(textView3.getHeight())
                .alpha(1f)
                .setDuration(800);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}


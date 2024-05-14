package in.adityashukla.lopark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView animationView;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
       animationView = findViewById(R.id.animation);
        animationView.setAnimation(R.raw.parking);
        animationView.playAnimation();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(mAuth == null){
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                        finish();

                    }else {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                }
            },2200);


    }



}
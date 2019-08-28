package myfirstapp.digitalsoftware.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessAct extends AppCompatActivity {

    Button btn_explore;
    Animation app_splash, btt, ttb;
    ImageView icon_success;
    TextView app_title_success, app_subtitle_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        icon_success = findViewById(R.id.icon_success);
        app_title_success = findViewById(R.id.app_title_success);
        app_subtitle_success = findViewById(R.id.app_subtitle_success);
        btn_explore = findViewById(R.id.btn_explore);


        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run animation
        btn_explore.startAnimation(btt);
        icon_success.startAnimation(app_splash);
        app_title_success.startAnimation(ttb);
        app_subtitle_success.startAnimation(ttb);

        //
        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotohome = new Intent(SuccessAct.this,HomeAct.class);
                startActivity(gotohome);
            }
        });

    }
}

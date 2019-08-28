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

public class SuccessPaymentAct extends AppCompatActivity {

    Button btn_dashboard, btn_view_ticket;
    Animation app_splash, btt, ttb;
    TextView title_success_pay, subtitle_succes_pay;
    ImageView icon_success_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_payment);

        //mendapati ID
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        btn_dashboard = findViewById(R.id.btn_dashboard);
        title_success_pay = findViewById(R.id.title_success_pay);
        subtitle_succes_pay = findViewById(R.id.subtitle_succes_pay);
        icon_success_pay = findViewById(R.id.icon_success_pay);


        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run animation
        icon_success_pay.startAnimation(app_splash);

        title_success_pay.startAnimation(ttb);
        subtitle_succes_pay.startAnimation(ttb);

        btn_view_ticket.startAnimation(btt);
        btn_dashboard.startAnimation(btt);


        //intent menuju hal lain
        btn_view_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoviewticket = new Intent(SuccessPaymentAct.this,MyProfileAct.class);
                startActivity(gotoviewticket);
            }
        });

        btn_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodash = new Intent(SuccessPaymentAct.this,HomeAct.class);
                startActivity(gotodash);
            }
        });
    }
}

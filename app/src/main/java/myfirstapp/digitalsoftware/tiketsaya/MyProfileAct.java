package myfirstapp.digitalsoftware.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyProfileAct extends AppCompatActivity {

    Button btn_signout, btn_edit_profile;
    LinearLayout pisa_ticket_purchase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_edit_profile = findViewById(R.id.btn_edit_profile);
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editmyprofile = new Intent(MyProfileAct.this,EditMyProfile.class);
                startActivity(editmyprofile);
            }
        });


        btn_signout = findViewById(R.id.btn_signout);
        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signout = new Intent(MyProfileAct.this,GetStartedAct.class);
                startActivity(signout);
            }
        });



        pisa_ticket_purchase = findViewById(R.id.pisa_ticket_purchase);
        pisa_ticket_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotopisapurchase = new Intent(MyProfileAct.this,MyTicketPurchased.class);
                startActivity(gotopisapurchase);
            }
        });
    }
}

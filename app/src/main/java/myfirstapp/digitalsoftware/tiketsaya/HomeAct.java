package myfirstapp.digitalsoftware.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeAct extends AppCompatActivity {

    View circle_profile;
    LinearLayout btn_ticket_pisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        circle_profile = findViewById(R.id.circle_profile);
        circle_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gototicket = new Intent(HomeAct.this,MyProfileAct.class);
                startActivity(gototicket);
            }
        });


        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotopisa = new Intent(HomeAct.this,TicketDetailsAct.class);
                startActivity(gotopisa);
            }
        });
    }
}

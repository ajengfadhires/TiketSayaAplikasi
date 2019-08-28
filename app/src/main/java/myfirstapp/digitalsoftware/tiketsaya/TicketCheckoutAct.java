package myfirstapp.digitalsoftware.tiketsaya;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {


    Button btn_buy_ticket, btn_minus, btn_plus;
    TextView textjumlahtiket, texttotalharga, textmybalance;
    Integer valuejumlahtiket = 1;
    Integer mybalance =  200;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 75;
    ImageView notice_uang;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);
        textmybalance = findViewById(R.id.textmybalance);
        texttotalharga = findViewById(R.id.texttotalharga );
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        notice_uang = findViewById(R.id.notice_uang);

        //set value baru pada beberapa komponen
        textjumlahtiket.setText(valuejumlahtiket.toString());
        textmybalance.setText("USD " + mybalance+"");
        valuetotalharga = valuejumlahtiket * valuehargatiket;
        texttotalharga.setText("USD " + valuetotalharga+"");
        notice_uang.setVisibility(View.GONE);

        //secara default, kita hide btn_minus dari awal
        btn_minus.animate().alpha(0).setDuration(300).start();
        btn_minus.setEnabled(false);

        //registrasi button jika di-klik

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuejumlahtiket+=1;
                textjumlahtiket.setText(valuejumlahtiket.toString());
                    if (valuejumlahtiket > 1) {
                    btn_minus.animate().alpha(1).setDuration(300).start();
                    btn_minus.setEnabled(true);

                }
                    valuetotalharga = valuejumlahtiket * valuehargatiket;
                    texttotalharga.setText("USD " + valuetotalharga+"");
                    if (valuetotalharga > mybalance){btn_buy_ticket.animate().translationY(250).
                            alpha(0).setDuration(350).start();
                            btn_buy_ticket.setEnabled(false);
                            textmybalance.setTextColor(Color.parseColor("#D1206B"));
                            notice_uang.setVisibility(View.VISIBLE);


                    }
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valuejumlahtiket-=1;
                textjumlahtiket.setText(valuejumlahtiket.toString());
                    if (valuejumlahtiket < 2) {
                    btn_minus.animate().alpha(0).setDuration(300).start();
                    btn_minus.setEnabled(false);
                }
                valuetotalharga = valuejumlahtiket * valuehargatiket;
                texttotalharga.setText("USD " + valuetotalharga+"");
                if (valuetotalharga < mybalance){btn_buy_ticket.animate().translationY(0 ).
                        alpha(1 ).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);

                }
            }
        });

         //button gotopay
        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosuccesspay = new Intent(TicketCheckoutAct.this,SuccessPaymentAct.class);
                startActivity(gotosuccesspay);
            }
        });
    }
}

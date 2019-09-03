package myfirstapp.digitalsoftware.tiketsaya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class TicketDetailsAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_buy_ticket;
    TextView title_ticket, location_ticket, photo_spot,
            wifi_available, festival, short_desc_ticket;
    ImageView header_ticket_detail;

    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_details);

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btn_back = findViewById(R.id.btn_back);

        title_ticket = findViewById(R.id.title_ticket);
        location_ticket = findViewById(R.id.location_ticket);
        photo_spot = findViewById(R.id.photo_spot);
        wifi_available = findViewById(R.id.wifi_available);
        festival = findViewById(R.id.festival);
        short_desc_ticket = findViewById(R.id.short_desc_ticket);
        Picasso.with(HomeAct.this)
                .load(dataSnapshot.child("url_thumbnail")
                        .getValue().toString()).centerCrop().fit()
                .into(header_ticket_detail);

        //mengambil data dari Intent
        Bundle bundle = getIntent().getExtras();
        String jenis_tiket_baru = bundle.getString("jenis tiket");

        //ambil data dari firebase berdasarkan intent
        reference = FirebaseDatabase.getInstance().getReference().child("Wisata").child(jenis_tiket_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //menimpa data yang ada dengan yang baru
                title_ticket.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                location_ticket.setText(dataSnapshot.child("lokasi").getValue().toString());
                photo_spot.setText(dataSnapshot.child("is_photo_spot").getValue().toString());
                wifi_available.setText(dataSnapshot.child("is_wifi").getValue().toString());
                festival.setText(dataSnapshot.child("is_festival").getValue().toString());
                short_desc_ticket.setText(dataSnapshot.child("short_desc").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotocheckout = new Intent(TicketDetailsAct.this,TicketCheckoutAct.class);
                startActivity(gotocheckout);
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoback = new Intent(TicketDetailsAct.this,HomeAct.class);
                startActivity(gotoback);
            }
        });
    }
}

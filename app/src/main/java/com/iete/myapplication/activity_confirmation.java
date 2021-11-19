package com.iete.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.auth.User;
import com.google.gson.Gson;

public class activity_confirmation extends AppCompatActivity {
    private Button con;
    private Button logout;
    private TextView confirmation_msg;
    private TextView timeSlot;
    private GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        Intent confirmation_pg = getIntent();
        String Slot = confirmation_pg.getStringExtra("Slot");
        TextView timeSlot = findViewById(R.id.timeSlot);
        timeSlot.setText(Slot);

        con = findViewById(R.id.con);
        logout = findViewById(R.id.logout);
        User user=new Gson().fromJson(getIntent().getStringExtra("user"), User.class);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent con = new Intent(activity_confirmation.this,activity_category.class);
                startActivity(con);
            }
        });
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient= GoogleSignIn.getClient(this,gso);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(  @NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(activity_confirmation.this,MainActivity.class));
                            finish();
                        }
                    }
                });

            }
        });
    }
}

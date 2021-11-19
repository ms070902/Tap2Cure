package com.iete.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_appointment extends AppCompatActivity {
    private Button confirm;
    RadioGroup radioGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        radioGroup = findViewById(R.id.radioGroup);

        Intent intent = getIntent();



        confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                String msg = radioButton.getText().toString();
                Intent confirmation_pg = new Intent(activity_appointment.this,activity_confirmation.class);
                confirmation_pg.putExtra("Slot",msg);
                startActivity(confirmation_pg);
            }
        });



    }


}

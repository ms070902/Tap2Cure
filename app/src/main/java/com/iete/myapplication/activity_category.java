package com.iete.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_category extends AppCompatActivity implements View.OnClickListener {
    private TextView human;
    private TextView animals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent loginPg = getIntent();

        Button ct_general_human = findViewById(R.id.ct_general_human);
        Button ct_eyeSpecialist = findViewById(R.id.ct_eyeSpecialist);
        Button ct_neureo = findViewById(R.id.ct_neureo);
        Button ct_cardio = findViewById(R.id.ct_cardio);
        Button ct_surgeon = findViewById(R.id.ct_surgeon);
        Button ct_general_animals = findViewById(R.id.ct_general_animals);

        ct_general_human.setOnClickListener(this);
        ct_eyeSpecialist.setOnClickListener(this);
        ct_neureo.setOnClickListener(this);
        ct_cardio.setOnClickListener(this);
        ct_surgeon.setOnClickListener(this);
        ct_general_animals.setOnClickListener(this);

        Intent con = getIntent();

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ct_general_human:
                Intent ct_doc = new Intent(activity_category.this,activity_doctors_general.class);
                startActivity(ct_doc);
                break;
            case R.id.ct_eyeSpecialist:
                Intent ct_eyeSpecialist = new Intent(activity_category.this,activity_doctors_eyeSpecialist.class);
                startActivity(ct_eyeSpecialist);
                break;
            case R.id.ct_neureo:
                Intent ct_neureo = new Intent(activity_category.this,activity_doctors_neureo.class);
                startActivity(ct_neureo);
                break;
            case R.id.ct_cardio:
                Intent ct_cardio = new Intent(activity_category.this,activity_doctors_cardio.class);
                startActivity(ct_cardio);
                break;
            case R.id.ct_surgeon:
                Intent ct_surgeon = new Intent(activity_category.this,activity_doctors_surgeon.class);
                startActivity(ct_surgeon);
                break;
            case R.id.ct_general_animals:
                Intent ct_genAnimals = new Intent(activity_category.this,activity_doctors_gen_animals.class);
                startActivity(ct_genAnimals);
                break;
        }

    }
}
package com.futureapp.exploremycity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Language extends AppCompatActivity {
    Button btnNumbers,btnColors,btnPhrases,btnFamily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

            setContentView(R.layout.activity_main);
            btnColors=findViewById(R.id.btnColors);
            btnFamily=findViewById(R.id.btnFamily);
            btnNumbers=findViewById(R.id.btnNumber);
            btnPhrases=findViewById(R.id.btnPhrases);

            btnColors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Language.this,ColorsActivity.class));
                }
            });
            btnPhrases.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Language.this,PhrasesActivity.class));
                }
            });
            btnNumbers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Language.this,NumbersActivity.class));
                }
            });
            btnFamily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Language.this,FamilyActivity.class));
                }
            });

        }
    }

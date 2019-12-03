package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpcionesActivity extends AppCompatActivity {


    private Button jugarButton;
    private Button opcionesbutton;
    private Button creditosbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        jugarButton = findViewById(R.id.jugarbutton);
        opcionesbutton = findViewById(R.id.opcionesbutton);
        creditosbutton = findViewById(R.id.creditosbutton);
        inicializarBotones();
    }


    private void inicializarBotones() {

        jugarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesActivity.this, ElegirRegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        creditosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OpcionesActivity.this, CreditosActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElegirRegistroActivity extends AppCompatActivity {

    private Button buttonBackReg;
    private Button buttonSin;
    private Button buttonReg;
    private Button buttonRegistrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_registro);
        buttonBackReg = findViewById(R.id.buttonBackReg);
        buttonSin = findViewById(R.id.buttonSin);
        buttonReg = findViewById(R.id.buttonReg);
        buttonRegistrate = findViewById(R.id.buttonRegistrate);
        inicializarBotonReg();
    }

    private void inicializarBotonReg() {

        buttonBackReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElegirRegistroActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElegirRegistroActivity.this, JugarSinRegistro.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElegirRegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonRegistrate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ElegirRegistroActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });

    }

}



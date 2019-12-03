package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JugarSinRegistro extends AppCompatActivity {

    private Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar_sin_registro);
        buttonBack = findViewById(R.id.buttonBack);
        inicializar();
    }


    private void inicializar() {

        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JugarSinRegistro.this, ElegirRegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

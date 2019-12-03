package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreditosActivity extends AppCompatActivity {

    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        buttonBack = findViewById(R.id.buttonBack);
        inicializarBoton();
    }

    private void inicializarBoton() {

        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditosActivity.this, OpcionesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

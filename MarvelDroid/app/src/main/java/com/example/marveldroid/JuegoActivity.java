package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

public class JuegoActivity extends AppCompatActivity {
    private ImageView imaagenPuzle;
    private String imagenUri;
    public static final String KEY_IMAGEN = "IMAGEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Intent intent = getIntent();
        imagenUri = intent.getStringExtra(KEY_IMAGEN);
        System.out.println(imagenUri);
        inicializar();
    }

    private void inicializar() {
        imaagenPuzle = findViewById(R.id.imagenPuzle);
        imaagenPuzle.post(new Runnable() {
            @Override
            public void run() {
                if (imagenUri != null) {
                    imaagenPuzle.setImageURI(Uri.parse(imagenUri));
                }
            }
        });
    }
}

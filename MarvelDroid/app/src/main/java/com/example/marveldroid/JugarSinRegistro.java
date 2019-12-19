package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;
import java.net.URI;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.provider.MediaStore;


public class JugarSinRegistro extends AppCompatActivity {

    public static final String KEY_JUGAR = "JUGAR";
    private Button buttonBack;
    private ImageButton botonImagenes;
    private Bitmap guardarImagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar_sin_registro);
        buttonBack = findViewById(R.id.buttonBack);
        botonImagenes = findViewById(R.id.botonImagenes);

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

        botonImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargarImagen();
            }
        });
    }

    private void CargarImagen(){
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("image/");
//        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),10);
        startActivityForResult(intent, 100);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {
            Uri miPath = data.getData();
            assert miPath != null;
            guardarImagen = BitmapFactory.decodeFile(miPath.getPath());
            Intent intent = new Intent(JugarSinRegistro.this, JuegoActivity.class);
            intent.putExtra(JuegoActivity.KEY_IMAGEN, miPath.getPath());
            startActivity(intent);
        }

    }


}

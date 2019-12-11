package com.example.marveldroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Bundle;

public class OpcionesActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_activityy);
    }

    //Método para asignar las funciones a los items
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemAyuda){
            Intent intent = new Intent(OpcionesActivity.this, WebViewActivity.class);
            startActivity(intent);
            finish();
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);

    }
}

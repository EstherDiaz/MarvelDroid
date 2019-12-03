package com.example.marveldroid;

import android.app.PictureInPictureParams;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marveldroid.data.DatabaseUtils;
import com.example.marveldroid.data.PersistenceHelper;

public class LoginActivity extends AppCompatActivity {

    private Button buttonBack;
    private PersistenceHelper persistenceHelper;
    private TextView textUserReg;
    private TextView textPassReg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializar();
        this.persistenceHelper =
                new PersistenceHelper(this,
                        DatabaseUtils.DATABASE,
                        null,
                        1);

    }
    private void inicializar() {

        buttonBack = findViewById(R.id.buttonBack);
        textPassReg = findViewById(R.id.textPassReg);
        textUserReg = findViewById(R.id.textUserReg);

        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ElegirRegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    private String findUser(String user, String pass){
        SQLiteDatabase database = persistenceHelper.getReadableDatabase();
        String[] args = new String[] {user, pass};
        Cursor c = database.rawQuery("SELECT " + DatabaseUtils.NAME_FIELD + " , " +
                DatabaseUtils.PASSWORD_FIELD +
                " FROM " + DatabaseUtils.USER_TABLE +
                " WHERE " + DatabaseUtils.NAME_FIELD + "=? " +
                " AND " + DatabaseUtils.PASSWORD_FIELD + "=?", args);
        if(c.getCount() > 0) {
            return user;
        }
        return "";
    }

    private void loginUser(){
        String user = textUserReg.getText().toString();
        String password = textPassReg.getText().toString();
        String usuario = findUser(user, password);
        if ("".equals(usuario)){
            Toast.makeText(getApplicationContext(),
                "Tu usuario o contraseña no son correctos", Toast.LENGTH_SHORT).show();

        }else{
            Intent intent = new Intent(LoginActivity.this, JugarSinRegistro.class);
            startActivity(intent);
            finish();
        }
    }
}

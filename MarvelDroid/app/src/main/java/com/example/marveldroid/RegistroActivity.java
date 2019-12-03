package com.example.marveldroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.marveldroid.data.DatabaseUtils;
import com.example.marveldroid.data.PersistenceHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

public class RegistroActivity extends AppCompatActivity {

    private Button buttonBack;
    private EditText userText;
    private EditText passText;
    private Button guardar;
    private PersistenceHelper persistenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializar();
        this.persistenceHelper =
                new PersistenceHelper(this,
                        DatabaseUtils.DATABASE,
                        null,
                        1);
    }



    public Long save(String nombre, String pass) {
        SQLiteDatabase database = persistenceHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(DatabaseUtils.NAME_FIELD,nombre);
        values.put(DatabaseUtils.PASSWORD_FIELD,pass );

        Long resultId = database.insert(DatabaseUtils.USER_TABLE,DatabaseUtils.ID_FIELD,values);

        return resultId;
    }

    public boolean findUser(String usuario){
        SQLiteDatabase database = persistenceHelper.getReadableDatabase();
        String[] args = new String[] {usuario};
        Cursor c = database.rawQuery("SELECT " + DatabaseUtils.NAME_FIELD +
                " FROM " + DatabaseUtils.USER_TABLE +
                " WHERE " + DatabaseUtils.NAME_FIELD + "=? ", args);
        if(c.getCount() == 0){
            return false;
        }
        return true;
    }

    private void inicializar() {

        buttonBack = findViewById(R.id.buttonBack);
        userText = findViewById(R.id.textUserReg);
        passText = findViewById(R.id.textPassReg);
        guardar = findViewById(R.id.guardarReg);

        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, ElegirRegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        guardar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = userText.getText().toString();
                String password = passText.getText().toString();

                if (!findUser(user)) {
                    Long resultado = save(user, password);

                    if (resultado != null) {

                        Toast.makeText(getApplicationContext(),
                                "Tu usuario a sido guardado con éxito", Toast.LENGTH_SHORT).show();

                        onBackPressed();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Tu usuario ya existe", Toast.LENGTH_SHORT).show();
                }

            }


        }  );
    }

}

package com.example.laba93isp9_14;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends Activity implements View.OnClickListener {

    EditText editTextLogin, editTextPassword;
    Button buttonSave, buttonLoad;

    SharedPreferences Log;
    SharedPreferences Pas;

    final String SAVED_LOG = "saved_LOG";
    final String SAVED_PAS = "saved_PAS";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSave = (Button) findViewById(R.id.btnReg);
        buttonSave.setOnClickListener(this);
        buttonLoad = (Button) findViewById(R.id.btnJoin);
        buttonLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReg:
                saveText();
                break;
            case R.id.btnJoin:
                checkText();
                break;
            default:
                break;
        }
    }

    void saveText() {
        Log = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor L = Log.edit();
        L.putString(SAVED_LOG, editTextLogin.getText().toString());
        L.commit();
        Pas = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor P = Pas.edit();
        P.putString(SAVED_PAS, editTextPassword.getText().toString());
        P.commit();
        Toast.makeText(this, "Пользователь сохранен", Toast.LENGTH_SHORT).show();
    }

    void checkText() {
        Log = getPreferences(MODE_PRIVATE);
        String Login = Log.getString(SAVED_LOG, "Логин сохранен");
        Pas = getPreferences(MODE_PRIVATE);
        String Password = Pas.getString(SAVED_PAS, "Пароль сохранен");
        if(Login.equals(editTextLogin.getText().toString())) {
            if (Password.equals(editTextPassword.getText().toString())) {
                Toast.makeText(this, "Вход успешно выполнен", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

}
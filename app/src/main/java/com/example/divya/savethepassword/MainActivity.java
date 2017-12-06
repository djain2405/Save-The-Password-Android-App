package com.example.divya.savethepassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.divya.savethepassword.Database.AppDatabase;
import com.example.divya.savethepassword.Database.Password;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText userid;
    private EditText password;
    private Button save;
    private Button view;

    private Password pwd;
    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        userid = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);
        save = (Button) findViewById(R.id.savepassword);
        view = (Button) findViewById(R.id.viewpassword);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.passwordDao().InsertPassword(new Password(name.getText().toString(), userid.getText().toString(), password.getText().toString()));
            }
        });

        view.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), ViewPasswordActivity.class);
                startActivity(i);
            }
        }
        );


    }


}

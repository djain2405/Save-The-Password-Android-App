package com.example.divya.savethepassword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.divya.savethepassword.Database.AppDatabase;
import com.example.divya.savethepassword.Database.Password;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divya on 12/5/2017.
 */

public class ViewPasswordActivity extends AppCompatActivity {

    private List<Password> passwordList;
    private RecyclerView recyclerView;
    private PasswordListAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_password);
        recyclerView = findViewById(R.id.recycler_view);

        db = AppDatabase.getAppDatabase(getApplicationContext());
        passwordList = new ArrayList<>();

        preparePasswordList();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new PasswordListAdapter(passwordList);
        recyclerView.setAdapter(adapter);
    }

    void preparePasswordList()
    {
        passwordList = db.passwordDao().getAll();
        //adapter.notifyDataSetChanged();
    }

}

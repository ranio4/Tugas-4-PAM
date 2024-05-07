package com.example.PAM4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import com.example.PAM4.database.AppDatabase;
import com.example.PAM4.database.adapter.UserAdapter;
import com.example.PAM4.database.entitas.User;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnTambah;
    private AppDatabase database;
    private UserAdapter userAdapter;
    private List<User> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        btnTambah = findViewById(R.id.btn_tambah);

        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list = database.userDao().getAll();
        userAdapter = new UserAdapter(getApplicationContext(),list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityTambah.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.userDao().getAll());
        userAdapter.notifyDataSetChanged();
    }
}
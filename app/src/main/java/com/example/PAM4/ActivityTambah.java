package com.example.PAM4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.PAM4.database.AppDatabase;

public class ActivityTambah extends AppCompatActivity {
    private EditText editName, editNim;
    private Button btnSave;
    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        editName = findViewById(R.id.full_name);
        editNim = findViewById(R.id.nim);
        btnSave = findViewById(R.id.btn_save);

        database = AppDatabase.getInstance(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.userDao().insertAll(editName.getText().toString(),editNim.getText().toString());
                finish();
            }
        });
    }
}
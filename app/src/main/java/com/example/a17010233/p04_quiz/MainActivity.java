package com.example.a17010233.p04_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;
    Button btnInsert, btnRetrieve;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tvResult = findViewById(R.id.tvResult);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertStudent(etName.getText().toString(), Double.valueOf(etGPA.getText().toString()));
                db.close();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Student> data = db.getStudent();
                db.close();


                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    // Log.d("Database Content", data.get(i).getId() + ". " + data.get(i).getName() + ". " + data.get(i).getGpa());
                    txt += data.get(i).getId() + ". " + data.get(i).getName() + ". " + data.get(i).getGpa()+ "\n";

                }
                tvResult.setText(txt);
            }
        });


    }
}

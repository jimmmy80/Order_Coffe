package com.example.admin.active_tutoria;

import android.app.Activity;
import android.database.DatabaseUtils;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Active_tutoria extends Activity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_tutoria);
        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editSurname = (EditText) findViewById(R.id.editText_surname);
        //editMarks = (EditText) findViewById(R.id.editText_marks);
        btnAdd = (Button) findViewById(R.id.btn_Add);
    }
}

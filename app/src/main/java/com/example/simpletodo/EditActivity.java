package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    Button btnSave;
    EditText etEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnSave = findViewById(R.id.btnSave);
        etEdit = findViewById(R.id.etEdit);

        getSupportActionBar().setTitle("Edit Item");

        Intent i = getIntent();
        String data = i.getStringExtra(MainActivity.KEY_ITEM_TEXT);
        etEdit.setText(data);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an intent which will contain the results
                Intent intent = new Intent();
                // pass the data
                String newData = etEdit.getText().toString();
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, newData);
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, i.getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set the result of the intent
                setResult(RESULT_OK, intent);
                // finish activity, close the screen and go back
                finish();
            }
        });

    }
}
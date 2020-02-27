package edu.auburn.comp3710.assignment3comp3710;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    int numberOfNotes;
    EditText txtContent, txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);


        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numberOfNotes ++;
                        NoteModel note = new NoteModel();
                        note.id = txtTitle.getText().toString();
                        note.title = txtTitle.getText().toString();
                        note.content = note.title;

                        SharedPreferences pref = getPreferences(0);
                        SharedPreferences.Editor editor = pref.edit();

                        String json = note.toJson();

                            Log.i("json", json);

                            editor.putString(note.id, json);
                            editor.commit();


                            note.fromJson(json);

                            txtContent.setText(txtContent.getText().toString() +  "\n" + numberOfNotes + ".) " + note.content);

                    }
                });


    }
}


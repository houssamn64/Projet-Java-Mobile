package com.example.qcm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;





public class MainActivity extends AppCompatActivity {

    private List<String> questions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Genere un QCM aleatoire a partie de la liste des questions
        final EditText questionEditText = findViewById(R.id.question_edittext);
        final EditText reponse1EditText = findViewById(R.id.reponse1_edittext);
        final EditText reponse2EditText = findViewById(R.id.reponse2_edittext);
        final EditText reponse3EditText = findViewById(R.id.reponse3_edittext);
        final EditText reponse4EditText = findViewById(R.id.reponse4_edittext);

        Button ajouter = findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questions.add(questionEditText.getText().toString());
                questions.add(reponse1EditText.getText().toString());
                questions.add(reponse2EditText.getText().toString());
                questions.add(reponse3EditText.getText().toString());
                questions.add(reponse4EditText.getText().toString());
            }
        });
    }

    public void startdbapp ()
    {
        new DbManager(this);
        startActivity(new Intent(this,InsertData.class));

    }

}
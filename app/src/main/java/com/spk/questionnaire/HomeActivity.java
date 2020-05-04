package com.spk.questionnaire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpToolbar();
    }
    public void c1OnClick(View view){
        Log.e("cId",": "+1);
        Intent questions = new Intent(HomeActivity.this, MainActivity.class);
        questions.putExtra("Id",1);
        startActivity(questions);


    }
    public void c2OnClick(View view){
        Log.e("cId",": "+1);
        Intent questions = new Intent(HomeActivity.this, MainActivity.class);
        questions.putExtra("Id",2);
        startActivity(questions);
    }
    public void c3OnClick(View view){
        Log.e("cId",": "+1);
        Intent questions = new Intent(HomeActivity.this, MainActivity.class);
        questions.putExtra("Id",3);
        startActivity(questions);
    }
    public void c4OnClick(View view){
        Log.e("cId",": "+1);
        Intent questions = new Intent(HomeActivity.this, MainActivity.class);
        questions.putExtra("Id",4);

        startActivity(questions);
    }

    void setUpToolbar()
    {
        Toolbar mainPageToolbar = findViewById(R.id.mainPageToolbar);
        setSupportActionBar(mainPageToolbar);
        getSupportActionBar().setTitle("Questionnaire Demo");
    }
}

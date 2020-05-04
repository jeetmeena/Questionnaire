package com.spk.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spk.questionnaire.questions.AnswersActivity;
import com.spk.questionnaire.questions.QuestionActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity
{
    private static final int QUESTIONNAIRE_REQUEST = 2018;
    Button resultButton;
    private TextView questionPositionTV;
    private TextView nameQuiz;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        Button questionnaireButton = findViewById(R.id.questionnaireButton);
        nameQuiz=findViewById(R.id.tv_t);
        imageView=findViewById(R.id.iv_i1);
        resultButton = findViewById(R.id.resultButton);
        Intent intent = getIntent();
         int message = intent.getIntExtra("Id",0);
        if(message==1){
            //you have to pass as an extra the json string.
            nameQuiz.setText("Mathematics Quiz");
            imageView.setImageResource(R.drawable.bran_image);
        }
        else if(message==2){
            //you have to pass as an extra the json string.
            nameQuiz.setText("Information Technology");

            imageView.setImageResource(R.drawable.computer_image);
        }
        else if(message==3){
            //you have to pass as an extra the json string.
            nameQuiz.setText("General Knowledge");

            imageView.setImageResource(R.drawable.gk_image);
        }
        else{
            //you have to pass as an extra the json string.
            nameQuiz.setText("Environment Quiz");

            imageView.setImageResource(R.drawable.test_na);
        }
        questionnaireButton.setOnClickListener(v -> {
            resultButton.setVisibility(View.GONE);
           logData(message);
        });

        resultButton.setOnClickListener(v -> {
            Intent questions = new Intent(MainActivity.this, AnswersActivity.class);
            startActivity(questions);
        });
    }

    private void logData(int a){
        Intent questions = new Intent(MainActivity.this, QuestionActivity.class);
        Log.e("Id",": "+a);

           if(a==1){
                //you have to pass as an extra the json string.
                String data=loadQuestionnaireJson("mat_x.json");
                Log.e("Id1",": ");
                questions.putExtra("json_questions", data);
                questions.putExtra("nameClass", "Mathematics Quiz ");
                startActivityForResult(questions, QUESTIONNAIRE_REQUEST);
            }
            else if(a==2){
                 //you have to pass as an extra the json string.
                String data=loadQuestionnaireJson("questions_example.json");
                Log.e("Id3",": ");
                questions.putExtra("nameClass", "Information Technology  ");
                questions.putExtra("json_questions", data);
                startActivityForResult(questions, QUESTIONNAIRE_REQUEST);
            }
            else if(a==3){
                 //you have to pass as an extra the json string.
                String data=loadQuestionnaireJson("jknowledg.json");
                Log.e("Id",": 3");
                questions.putExtra("nameClass", "General Knowledge ");
                questions.putExtra("json_questions", data);
                startActivityForResult(questions, QUESTIONNAIRE_REQUEST);
            }
            else if(a==4){
                 //you have to pass as an extra the json string.
                String data=loadQuestionnaireJson("enverment_q.json");
                Log.e("Id",": 4");
                questions.putExtra("nameClass", "Environment Quiz  ");
                questions.putExtra("json_questions", data);
                startActivityForResult(questions, QUESTIONNAIRE_REQUEST);
            }
            else
           { Log.e("ss","s"+a);}
        }


    void setUpToolbar()
    {
        Toolbar mainPageToolbar = findViewById(R.id.mainPageToolbar);
        setSupportActionBar(mainPageToolbar);
        mainPageToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mainPageToolbar.setNavigationOnClickListener(v -> onBackPressed());
        getSupportActionBar().setTitle("Questionnaire Demo");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == QUESTIONNAIRE_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                resultButton.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Questionnaire Completed!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void toolBarInit()
    {
        Toolbar questionToolbar = findViewById(R.id.questionToolbar);


        //questionToolbarTitle = questionToolbar.findViewById(R.id.questionToolbarTitle);
        questionPositionTV = questionToolbar.findViewById(R.id.questionPositionTV);

        //questionToolbarTitle.setText("Questions");
    }
    //json stored in the assets folder. but you can get it from wherever you like.
    private String loadQuestionnaireJson(String filename)
    {
        try
        {
            InputStream is = getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            Log.e("dlfkdsj",buffer.toString());
            return new String(buffer, "UTF-8");
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
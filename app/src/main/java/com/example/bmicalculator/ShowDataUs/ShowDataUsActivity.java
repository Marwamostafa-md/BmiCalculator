package com.example.bmicalculator.ShowDataUs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bmicalculator.HomePage1.HomePage1Activity;
import com.example.bmicalculator.R;

public class ShowDataUsActivity extends AppCompatActivity {
    TextView textView2;
    TextView bmiShow2;
    ImageView showImage2;
    SharedPreferences sharedPreferences;
    Float bodyMass;
    int gender;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home){
            Intent intent=new Intent(ShowDataUsActivity.this, HomePage1Activity.class);
            startActivity(intent);}

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_data_us);
        sharedPreferences=getSharedPreferences("weight us",MODE_PRIVATE);
        showImage2=findViewById(R.id.showimage2);
        bmiShow2=findViewById(R.id.bmishow2);
        textView2=findViewById(R.id.advice2);
        bodyMass=sharedPreferences.getFloat("bmi", 0);
        gender=sharedPreferences.getInt("gender", 0);
        if(gender==1){
            //Log.d("ShowDataActivity","bady mass:"+bodyMass);
            showDataWomen2(bodyMass,gender);}
        else if(gender==2){
            manBmi2(bodyMass,gender);
        }
    }

    public void showDataWomen2(Float mass,int gender ){

        if(mass<16&&mass>10){
            showImage2.setImageResource(R.drawable.underweightedwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories. ");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed. ");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());

        }
        else if(mass>=16&&mass<17){
            showImage2.setImageResource(R.drawable.underweightedwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories. ");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed. ");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());
        }
        else  if(mass >=17&& mass<18.5  ){
            showImage2.setImageResource(R.drawable.underweightedwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories. ");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed. ");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());

        }
        else if(mass>=18.5&&mass<25){
            showImage2.setImageResource(R.drawable.normalwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("You're doing a great job maintaining a healthy weight.");
            sb.append(" Keep up the good work with your balanced diet and regular exercise—it's making a positive difference for your overall well-being. \n");

            textView2.setText(sb.toString());

        }
        else if(mass>=25&&mass<30){

            showImage2.setImageResource(R.drawable.overweightwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("Managing your weight can be challenging, but it's great that you're taking steps to ");
            sb.append(" improve your health. Focus on gradual, sustainable changes in your diet and exercise ");
            sb.append("routine, and remember that progress takes time. Your efforts are valuable, and every");
            sb.append("small step contributes to your overall well-being.\n");

            textView2.setText(sb.toString());
        }
        else if(mass>=30&&mass<35){

            showImage2.setImageResource(R.drawable.obesewomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("Addressing obesity can be tough, but it's commendable that you're seeking to ");
            sb.append(" improve your health. Focus on setting realistic goals and making gradual, positive ");
            sb.append("changes in your diet and physical activity. Remember, seeking support from ");
            sb.append("healthcare professionals and building a supportive network can make a significant difference");

            textView2.setText(sb.toString());
        }
        else if(mass>=35){

            showImage2.setImageResource(R.drawable.extremweightwomen);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("taking steps towards better health is incredibly important. Focus on small,");
            sb.append("manageable changes in diet and exercise, and seek professional guidance for a ");
            sb.append("personalized plan. Remember, progress is a journey, and every positive step you take ");
            sb.append("is a significant achievement towards improving your overall health and well-being.\n");

            textView2.setText(sb.toString());
        }
    }
    public void manBmi2(Float mass,int gender){

        if(mass<16&&mass>10){
            showImage2.setImageResource(R.drawable.underweightedman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories. ");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed.");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());
        }
        else if(mass>=16&&mass<17){
            showImage2.setImageResource(R.drawable.underweightedman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories.");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed.");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());
        }
        else  if(mass >=17&& mass<18.5 ){
            showImage2.setImageResource(R.drawable.underweightedman);

            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("you are underweight, it’s important to follow a balanced diet that is high in calories. ");
            sb.append("Focus on consuming meals rich in proteins, healthy fats, and carbohydrates, and consider eating more frequent meals if needed. ");
            sb.append("Consulting with a nutritionist can help you create a personalized eating plan. Additionally, incorporating strength training exercises can help build muscle mass.");

            textView2.setText(sb.toString());
        }
        else if(mass>=18.5&&mass<25){
            showImage2.setImageResource(R.drawable.normalweightedman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("You're doing a great job maintaining a healthy weight. ");
            sb.append(" Keep up the good work with your balanced diet and regular exercise—it's making a positive difference for your overall well-being. \n");

            textView2.setText(sb.toString());
        }
        else if(mass>=25&&mass<30){

            showImage2.setImageResource(R.drawable.overweightman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("Managing your weight can be challenging, but it's great that you're taking steps to ");
            sb.append(" improve your health. Focus on gradual, sustainable changes in your diet and exercise ");
            sb.append("routine, and remember that progress takes time. Your efforts are valuable, and every");
            sb.append("small step contributes to your overall well-being.\n");

            textView2.setText(sb.toString());
        }
        else if(mass>=30&&mass<35){

            showImage2.setImageResource(R.drawable.obesityman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("Addressing obesity can be tough, but it's commendable that you're seeking to  ");
            sb.append(" improve your health. Focus on setting realistic goals and making gradual, positive ");
            sb.append("changes in your diet and physical activity. Remember,seeking support from ");
            sb.append("healthcare professionals and building a supportive network can make a significant difference\n");

            textView2.setText(sb.toString());
        }
        else if(mass>=35){

            showImage2.setImageResource(R.drawable.extremeobesityman);
            bmiShow2.setText(String.format("%.2f",mass));
            StringBuilder sb = new StringBuilder();
            textView2.setMaxLines(Integer.MAX_VALUE);
            textView2.setEllipsize(null);
            sb.append("taking steps towards better health is incredibly important. Focus on small,");
            sb.append("manageable changes in diet and exercise, and seek professional guidance for a");
            sb.append("personalized plan. Remember, progress is a journey, and every positive step you take ");
            sb.append("is a significant achievement towards improving your overall health and well-being.");

            textView2.setText(sb.toString());
        }



    }}


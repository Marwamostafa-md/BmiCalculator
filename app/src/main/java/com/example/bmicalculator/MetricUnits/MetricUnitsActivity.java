package com.example.bmicalculator.MetricUnits;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bmicalculator.HomePage1.HomePage1Activity;
import com.example.bmicalculator.R;
import com.example.bmicalculator.ShowData.ShowDataActivity;

public class MetricUnitsActivity extends AppCompatActivity {
    Spinner spinner;
    String userAge ,userLength ,userWeight;
    ImageView imageView;
    Button calculate,back;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText weight, length, age;
    boolean chose = false,validag,validWei,validLen;
    Float bmi;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_metric_units);
        back=findViewById(R.id.backhome);
        spinner = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);
        length = findViewById(R.id.length);
        age=findViewById(R.id.age);
        calculate=findViewById(R.id.calculate);
        imageView = findViewById(R.id.image);

        sharedPreferences = getSharedPreferences("weight", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    imageView.setImageResource(R.drawable.women1);
                    chose=true;
                    type=1;
                }
                if (position == 2) {
                    imageView.setImageResource(R.drawable.man);
                    chose=true;
                    type=2;
                }
                else {
                    //Toast.makeText(HomePageActivity.this, "you should determine your gender", Toast.LENGTH_SHORT).show();
                    // chose =false;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                chose=false;

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAge=age.getText().toString();
                userLength=length.getText().toString();
                userWeight=weight.getText().toString();
                validag=isValidAge(userAge,userLength,userWeight);
                validWei=isValidWeight(userWeight);
                validLen=isValidLength(userLength);
                if(chose==false)

                    Toast.makeText(MetricUnitsActivity.this," You should determine Gender",Toast.LENGTH_LONG).show();
                else {
                    if (validag && validLen && validWei && chose) {
                        Float bmi1 = calculateBmi(userLength, userWeight);
                        editor.putFloat("bmi", bmi1);
                        editor.putInt("gender", type);
                        editor.apply();
                        Intent intent = new Intent(MetricUnitsActivity.this, ShowDataActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MetricUnitsActivity.this, HomePage1Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public boolean isValidAge(String userAge,String userLength,String userWeight){

        if(userAge.isEmpty()){
            Toast.makeText(MetricUnitsActivity.this,"empity age",Toast.LENGTH_LONG).show();

            return false;
        }

        else {
            for(char c:userAge.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(MetricUnitsActivity.this,"age should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }

            int age=Integer.parseInt(userAge);

            if(age<=0||age<20||age>120){
                Toast.makeText(MetricUnitsActivity.this, "invalid age", Toast.LENGTH_SHORT).show();
                return false;
            }

            else
                return true;

        }}
    public boolean isValidLength(String userLength){
        int count=0;
        if(userLength.isEmpty()){
            Toast.makeText(MetricUnitsActivity.this,"empity length",Toast.LENGTH_LONG).show();
            return false;
        }else{
            for(char c:userLength.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(MetricUnitsActivity.this,"Length should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }

            Float length=Float.valueOf(userLength);
            if(length<=0||length<140||length>210){
                Toast.makeText(MetricUnitsActivity.this, "invalid length", Toast.LENGTH_SHORT).show();
                return false;

            }else
                return true;

        }}
    public boolean isValidWeight(String userWeight){
        int count=0;
        if(userWeight.isEmpty()){
            Toast.makeText(MetricUnitsActivity.this,"the weight empty",Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            for(char c:userWeight.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(MetricUnitsActivity.this,"Weight should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }
            Float weight1=Float.parseFloat(userWeight);
            if(weight1<=0||weight1<10){
                Toast.makeText(MetricUnitsActivity.this, "invalid weight", Toast.LENGTH_SHORT).show();
                return false;

            }
            else
                return true;}
    }
    public Float calculateBmi(String userLength,String userWeght){
        if(userLength.equals(null)&&userWeght.equals(null)){
            return 0.0F;

        }else{
            Float length=Float.parseFloat(userLength);
            Float weight=Float.parseFloat(userWeght);
            bmi=weight/((length/100)*(length/100));

            return bmi;}
    }
/*public Float bmiPrime(String userLength,String userWeght ){
        Float userBmi=calculateMbi(userLength,userWeght);
        float bmiPrime=bmi/25;
        return bmiPrime;
}*/
}


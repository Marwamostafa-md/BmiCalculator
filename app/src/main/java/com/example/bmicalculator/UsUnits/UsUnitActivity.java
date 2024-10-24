package com.example.bmicalculator.UsUnits;

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
import com.example.bmicalculator.MetricUnits.MetricUnitsActivity;
import com.example.bmicalculator.R;
import com.example.bmicalculator.ShowData.ShowDataActivity;
import com.example.bmicalculator.ShowDataUs.ShowDataUsActivity;

public class UsUnitActivity extends AppCompatActivity {
   Button back2;
    Spinner spinner2;
    String userAge ,userLength ,userWeight;
    ImageView imageView;
    Button calculate2,back;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText weight, length, age;
    boolean chose = false,validag,validWei,validLen;
    Float bmi;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_us_unit);
    back2=findViewById(R.id.backhome2);
    back2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(UsUnitActivity.this, HomePage1Activity.class);
        startActivity(intent);
        finish();
    }
});
        spinner2 = findViewById(R.id.gender2);
        weight = findViewById(R.id.weight2);
        length = findViewById(R.id.length2);
        age=findViewById(R.id.age2);
        calculate2=findViewById(R.id.calculate2);
        imageView = findViewById(R.id.image2);

        sharedPreferences = getSharedPreferences("weight us", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        spinner2.setSelection(0);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAge=age.getText().toString();
                userLength=length.getText().toString();
                userWeight=weight.getText().toString();
                validag=isValidAge2(userAge,userLength,userWeight);
                validWei=isValidWeight2(userWeight);
                validLen=isValidLength2(userLength);
                if(chose==false)

                    Toast.makeText(UsUnitActivity.this," You should determine Gender",Toast.LENGTH_LONG).show();
                else {
                    if (validag && validLen && validWei && chose) {
                        Float bmi1 = calculateBmi2(userLength, userWeight);
                        editor.putFloat("bmi", bmi1);
                        editor.putInt("gender", type);
                        editor.apply();
                        Intent intent = new Intent(UsUnitActivity.this, ShowDataUsActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsUnitActivity.this, HomePage1Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public boolean isValidAge2(String userAge,String userLength,String userWeight){

        if(userAge.isEmpty()){
            Toast.makeText(UsUnitActivity.this,"empity age",Toast.LENGTH_LONG).show();

            return false;
        }

        else {
            for(char c:userAge.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(UsUnitActivity.this,"age should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }

            int age=Integer.parseInt(userAge);

            if(age<=0||age<20||age>120){
                Toast.makeText(UsUnitActivity.this, "invalid age", Toast.LENGTH_SHORT).show();
                return false;
            }

            else
                return true;

        }}
    public boolean isValidLength2(String userLength){
        int count=0;
        if(userLength.isEmpty()){
            Toast.makeText(UsUnitActivity.this,"empity length",Toast.LENGTH_LONG).show();
            return false;
        }else{
            for(char c:userLength.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(UsUnitActivity.this,"Length should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }

            Float length=Float.valueOf(userLength);
            if(length<=0||length<55.12||length>82.68){
                Toast.makeText(UsUnitActivity.this, "invalid length", Toast.LENGTH_SHORT).show();
                return false;

            }else
                return true;

        }}
    public boolean isValidWeight2(String userWeight){

        if(userWeight.isEmpty()){
            Toast.makeText(UsUnitActivity.this,"the weight empty",Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            for(char c:userWeight.toCharArray()){
                if(!Character.isDigit(c)){
                    if(c=='.'){}
                    else{
                    Toast.makeText(UsUnitActivity.this,"Weight should be only positvive number ",Toast.LENGTH_LONG).show();
                    return false;}
                }
            }
            Float weight1=Float.parseFloat(userWeight);
            if(weight1<=0||weight1<88.18){
                Toast.makeText(UsUnitActivity.this, "invalid weight", Toast.LENGTH_SHORT).show();
                return false;

            }
            else
                return true;}
    }
    public Float calculateBmi2(String userLength,String userWeght){
        if(userLength.equals(null)&&userWeght.equals(null)){
            return 0.0F;

        }else{
            Float length=Float.parseFloat(userLength);
            Float weight=Float.parseFloat(userWeght);
            bmi=703*weight/((length*length));

            return bmi;}
    }
/*public Float bmiPrime(String userLength,String userWeght ){
        Float userBmi=calculateMbi(userLength,userWeght);
        float bmiPrime=bmi/25;
        return bmiPrime;
}*/
}




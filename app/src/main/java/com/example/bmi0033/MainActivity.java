package com.example.bmi0033;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calculate(View v){

        EditText w,h;

        TextView t;
        t=findViewById(R.id.result);

        w=findViewById(R.id.weight);
        h=findViewById(R.id.height);

        float w1=Float.parseFloat(w.getText().toString());
        float h1=Float.parseFloat(h.getText().toString());

         float heightmetre=h1/100;
        float calculates=w1/(heightmetre*heightmetre);


        if(calculates<18.5){
            t.setText("you are underweight");

        } else if (calculates>18.5 && calculates<=24.9) {

            t.setText("you are Normal");

        } else if (calculates>25&& calculates<=29.9) {

            t.setText("you are overweight");
        }else{
            t.setText("error in input");
        }


    }
}
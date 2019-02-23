package com.example.werainkhatri.simplecalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double no1 = 0, no2 = 0;int b = 0;
    TextView t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textOut);
    }

    //NUMBERS
    public void one(View view) {
        t1.setText(t1.getText() + "1");
    }

    public void two(View view) {
        t1.setText(t1.getText() + "2");
    }

    public void three(View view) {
        t1.setText(t1.getText() + "3");
    }

    public void four(View view) {
        t1.setText(t1.getText() + "4");
    }

    public void five(View view) {
        t1.setText(t1.getText() + "5");
    }

    public void six(View view) {
        t1.setText(t1.getText() + "6");
    }

    public void seven(View view) {
        t1.setText(t1.getText() + "7");
    }

    public void eight(View view) {
        t1.setText(t1.getText() + "8");
    }

    public void nine(View view) {
        t1.setText(t1.getText() + "9");
    }

    public void zero(View view) {
        t1.setText(t1.getText() + "0");
    }
    //OPERATIONS
    public void add(View view) {
        b = 1; //b = 1 implies addition is being done
        no1 = Double.parseDouble(t1.getText() + ""); //To get first number
        t2.setText(t1.getText() + "+"); //printing on the next TextView
        t1.setText(""); //clearing for next number
    }

    public void sub(View view) {
        b = 2; //b = 2 implies subtraction is being done
        no1 = Double.parseDouble(t1.getText() + ""); //To get first number
        t2.setText(t1.getText() + "-"); //printing on the next TextView
        t1.setText(""); //clearing for next number
    }

    public void multiply(View view) {
        b = 3; //b = 3 implies multiplication is being done
        no1 = Double.parseDouble(t1.getText() + ""); //To get first number
        t2.setText(t1.getText() + "*"); //printing on the next TextView
        t1.setText(""); //clearing for next number
    }

    public void divide(View view) {
        b = 4; //b = 4 implies subtraction is being done
        no1 = Double.parseDouble(t1.getText() + ""); //To get first number
        t2.setText(t1.getText() + "/"); //printing on the next TextView
        t1.setText(""); //clearing for next number
    }

    public void sqroot(View view) {
        b = 5; //b = 5 implies subtraction is being done
        no1 = Double.parseDouble(t1.getText() + ""); //To get first number
        t2.setText("√" + t1.getText()); //printing on the next TextView
        t1.setText(""); //clearing for next number
    }

    public void decimal(View view) {
        t1.setText(t1.getText() + ".");
    }

    public void power(View view) {
        b = 6; // b = 6 implies power is being used
        no1 = Double.parseDouble(t1.getText() + "");
        t2.setText(t1.getText() + "^");
        t1.setText("");
    }

    public void equal(View view) { //When = is clicked
        switch (b) {
            case 1: //for addition
                no2 = Double.parseDouble(t1.getText() + "");
                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 + no2;
                t1.setText(Double.toString(no1) + "");
                no2 = 0;
                break;
            case 2: //for subtraction
                no2 = Double.parseDouble(t1.getText() + "");
                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 - no2;
                t1.setText(Double.toString(no1) + "");
                no2 = 0;
                break;
            case 3: //for multiplication
                no2 = Double.parseDouble(t1.getText() + "");
                t2.setText(t2.getText() + Double.toString(no2));
                no1 *= no2;
                t1.setText(Double.toString(no1) + "");
                no2 = 0;
                break;
            case 4: //for division
                no2 = Double.parseDouble(t1.getText() + "");
                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 / no2;
                t1.setText(Double.toString(no1) + "");
                no2 = 0;
                break;
            case 5: //for square root
                no1 = (Double)Math.sqrt(no1);
                t1.setText(Double.toString(no1) + "");
                break;
            case 6:
                no2 = Double.parseDouble(t1.getText() + "");
                t2.setText(t2.getText() + Double.toString(no2));
                no1 = (Double) Math.pow(no1, no2);
                t1.setText(Double.toString(no1) + "");
                no2 = 0;
                break;
            default:
                Toast.makeText(this, "Retry", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void clearAll(View view) {
        t1.setText("");
        t2.setText("=0");
        no1 = 0;
        no2 = 0;
        b = 0;
    }
}

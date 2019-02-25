package com.example.werainkhatri.simplecalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double no1 = 0, no2 = 0; //numbers
    int check = 0; //operation check
    int posi = 0; //finding next number
    String text = ""; //text in t1
    boolean cont = false;
    TextView t0, t1, t2; //text fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView2);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textOut);
    }

    //NUMBERS
    public void one(View view) {
        t1.append("1");
        text = t1.getText().toString();
    }

    public void two(View view) {
        t1.append("2");
        text = t1.getText().toString();
    }

    public void three(View view) {
        t1.append("3");
        text = t1.getText().toString();
    }

    public void four(View view) {
        t1.append("4");
        text = t1.getText().toString();
    }

    public void five(View view) {
        t1.append("5");
        text = t1.getText().toString();
    }

    public void six(View view) {
        t1.append("6");
        text = t1.getText().toString();
    }

    public void seven(View view) {
        t1.append("7");
        text = t1.getText().toString();
    }

    public void eight(View view) {
        t1.append("8");
        text = t1.getText().toString();
    }

    public void nine(View view) {
        t1.append("9");
        text = t1.getText().toString();
    }

    public void zero(View view) {
        t1.append("0");
        text = t1.getText().toString();
    }


    //OPERATIONS
    public void add(View view) {
        if(!cont)
            no1 = Double.parseDouble(t1.getText().toString()); //To get first number
        check = 1; //check = 1 implies addition is being done
        t1.append("+"); //printing on the next TextView
        posi = text.length(); //getting the position

    }

    public void sub(View view) {
        if(!cont)
            no1 = Double.parseDouble(t1.getText().toString()); //To get first number
        check = 2; //check = 2 implies subtraction is being done
        t1.append("-"); //printing on the next TextView
        posi = text.length(); //getting the position
    }

    public void multiply(View view) {
        if(!cont)
            no1 = Double.parseDouble(t1.getText().toString()); //To get first number
        check = 3; //check = 3 implies multiplication is being done
        t1.append("×"); //printing on the next TextView
        posi = text.length(); //getting the position
    }

    public void divide(View view) {
        if(!cont)
            no1 = Double.parseDouble(t1.getText().toString()); //To get first number
        check = 4; //check = 4 implies subtraction is being done
        t1.append("/"); //printing on the next TextView
        posi = text.length(); //getting the position
    }

    public void sqroot(View view) {
//        if(!cont)
//            no1 = Double.parseDouble(t1.getText().toString()); //To get first number
        check = 5; //check = 5 implies sqroot is being done
        t1.append("√"); //printing on the next TextView
        posi = text.length(); //getting the position
    }

    public void decimal(View view) {
        t1.append(".");
    }

    public void power(View view) {
        if(!cont)
            no1 = Double.parseDouble(t1.getText().toString());
        check = 6; // check = 6 implies power is being used
        t1.append("^"); //printing on the next TextView
        posi = text.length(); //getting the position
    }

    public void equal(View view) { //When = is clicked
//        Toast.makeText(this, "3×".length() + "", Toast.LENGTH_SHORT).show();
        cont = true;
        switch (check) {
            case 1: //for addition
                no2 = Double.parseDouble(t1.getText().toString().substring(posi));
//                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 + no2;
                t2.setText(String.format("=%.4f",no1));
                no2 = 0;
                check = 0;
                break;
            case 2: //for subtraction
                no2 = Double.parseDouble(t1.getText().toString().substring(posi));
//                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 - no2;
                t2.setText(String.format("=%.4f",no1));
                no2 = 0;
                check = 0;
                break;
            case 3: //for multiplication
                no2 = Double.parseDouble(t1.getText().toString().substring(posi+1));
//                t2.setText(t2.getText() + Double.toString(no2));
                no1 *= no2;
                t2.setText(String.format("=%.4f",no1));
                no2 = 0;
                check = 0;
                break;
            case 4: //for division
                no2 = Double.parseDouble(t1.getText().toString().substring(posi+1));
//                t2.setText(t2.getText() + Double.toString(no2));
                no1 = no1 / no2;
                t2.setText(String.format("=%.4f",no1));
                no2 = 0;
                check = 0;
                break;
            case 5: //for square root
                no1 = Double.parseDouble(t1.getText().toString().substring(posi+1));
                no1 = (Double)Math.sqrt(no1);
                t2.setText(String.format("=%.4f",no1));
                check = 0;
                break;
            case 6: //for power
                no2 = Double.parseDouble(t1.getText().toString().substring(posi+1));
//                t2.setText(t2.getText() + Double.toString(no2));
                no1 = (Double) Math.pow(no1, no2);
                t2.setText(String.format("=%.4f",no1));
                no2 = 0;
                check = 0;
                break;
            default:
                Toast.makeText(this, "Wrong Input. Retry", Toast.LENGTH_SHORT).show();
                check = 0;
                break;
        }
    }

    public void clearAll(View view) {
        t1.setText("");
        t2.setText("");
        no1 = 0;
        no2 = 0;
        check = 0;
        cont = false;
    }
}

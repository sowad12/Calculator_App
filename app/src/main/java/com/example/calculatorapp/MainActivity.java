package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private TextView input,output;
String number="",tempNum="";
String oldNum="",newNum="";
String op="";

    double sum=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();
    }
    public void display(){
        input=findViewById(R.id.inputText);
        output=findViewById(R.id.outputText);
    }
public  void updateValue(String value){
      number+=value;
      input.setText(number);
}
public  void updateOp(String value){
    number+=value;
    input.setText(number);
}
public  void calculation(String value,String op){
if(value.split("\\+").length==2){
    String []res=value.split("\\+");
    double d=Double.parseDouble(res[0])+Double.parseDouble(res[1]);
     String ans=String .valueOf(d);
    output.setText(ans);
    number=ans+"";
}

   else if(value.split("\\-").length==2){
        String []res=value.split("\\-");
        if(Double.parseDouble(res[0])<Double.parseDouble(res[1])){
            double d=Double.parseDouble(res[0])-Double.parseDouble(res[1]);
            String ans=String .valueOf(d);
            output.setText(ans);
            number=ans+"";
        }
        else {
            double d=Double.parseDouble(res[0])-Double.parseDouble(res[1]);
            String ans=String .valueOf(d);
            output.setText(ans);
            number=ans+"";
        }

    }
    if(value.split("x").length==2){
        String []res=value.split("x");
        double d=Double.parseDouble(res[0])*Double.parseDouble(res[1]);
        String ans=String .valueOf(d);
        output.setText(ans);
        number=ans+"";
    }
    if(value.split("÷").length==2){
        String []res=value.split("÷");
        double d=Double.parseDouble(res[0])/Double.parseDouble(res[1]);
        String ans=String .valueOf(d);
        output.setText(ans);
        number=ans+"";
    }

}
    public  void NumbersBtn(View v){

        switch (v.getId()){
            case R.id.btn7:
            updateValue("7");
            break;
            case R.id.btn8:
                updateValue("8");
                break;
            case R.id.btn9:
                updateValue("9");
                break;
            case R.id.btn4:
                updateValue("4");
                break;
            case R.id.btn5:
                updateValue("5");
                break;
            case R.id.btn6:
                updateValue("6");
                break;
            case R.id.btn1:
                updateValue("1");
                break;
            case R.id.btn2:
                updateValue("2");
                break;
            case R.id.btn3:
                updateValue("3");
                break;
            case R.id.btn0:
                updateValue("0");
                break;
            case R.id.btndot:
                updateValue(".");
                break;
            case R.id.Del:
                StringBuffer sb= new StringBuffer(number);
                sb.deleteCharAt(sb.length()-1);
                number=sb.toString();
                input.setText(number);
                break;
            case R.id.Clr:
                number="";
                tempNum="";
                newNum="";
                oldNum="";
                sum=0;
                input.setText("Enter Value");
                output.setText("0");
                break;

            default:
                break;
        }

    }
    public void opsBtn(View v){
      oldNum=output.getText().toString();
        switch (v.getId()){
            case R.id.btnPlus:

                calculation(number,op);
                updateOp("+");


                break;
            case R.id.btnMinus:
                calculation(number,op);
                updateOp("-");

                break;

            case R.id.btnDiv:
                calculation(number,op);
                updateOp("÷");

                break;
            case R.id.btnMulti:
                calculation(number,op);
                updateOp("x");

                break;
            default:
                break;

        }

    }
    public void equalBtn(View v){
    switch (v.getId()){
        case R.id.btnEqual:
            calculation(number,op);
            break;
        default:
            break;
    }

    }

}
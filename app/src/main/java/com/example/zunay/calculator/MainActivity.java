package com.example.zunay.calculator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import static java.lang.Math.sqrt;

public class MainActivity extends Activity {
    private String value1;
    private String value2;
    private String operator;
    private String result;
    private int counter;
    private int fValue;
    private String output;
    SharedPreferences sharedPref;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value1="";
        value2="";
        result="";
        operator="";
        counter=0;
        fValue=0;
        sharedPref = getSharedPreferences("",Context.MODE_PRIVATE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
    }


    public void textAppend(View view) {
        editText= (EditText) findViewById(R.id.editText);
        if(editText.getText().toString().equals(result) || fValue==0)
        {
            fValue++;//to avoid 1st 0 from the edittext
            editText.setText("");
        }
        Button content = (Button)view;
        String buttonText = content.getText().toString();
        editText.append(buttonText);
    }
    public void allClear(View view) {
        editText= (EditText) findViewById(R.id.editText);
        editText.setText("");
        value1="";
        value2="";
        result="";
        operator="";
        counter=0;
    }
    public void clear(View view) {
        editText= (EditText)findViewById(R.id.editText);
        editText.setText("");
    }
    public void memo(View view) {
        Intent intent= new Intent(MainActivity.this,Memo.class);
        startActivity(intent);
    }
    public void calculate(View view) throws IOException {
        editText= (EditText) findViewById(R.id.editText);
        value2=editText.getText().toString();
        if(operator.equals("+")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
        }
        else if(operator.equals("-")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
        }
        else if(operator.equals("*")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
        }
        else if(operator.equals("/")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)/Double.valueOf(value2)));
        }
        output=value1+operator+value2+"="+result+"\n";
        operator="";
        editText.setText(result);
        counter=0;
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putString(getString(R.string.write_in_memo),result);
        //editor.commit();

        File Root = Environment.getExternalStorageDirectory();
        File Dir = new File(Root.getAbsolutePath() + "/Demolist");
        if (!Dir.exists()) {Dir.mkdir();} //Makes the directory if not exists
        File file = new File(Root.getAbsolutePath() + "/Demolist","demo.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(output.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();
    }
    public void plus(View view) {
        editText= (EditText) findViewById(R.id.editText);
        operator="+";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
            editText.setText(result);
            output=value1+operator+value2+"="+result+"\n";
            value1=result;
        }
        else if(counter<1) {
            value1=editText.getText().toString();//for the first value
            editText.setText("");
        }
        counter++;
    }
    public void minus(View view){
        editText= (EditText) findViewById(R.id.editText);
        operator="-";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
            editText.setText(result);
            output=value1+operator+value2+"="+result+"\n";
            value1=result;
        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            editText.setText("");
        }
        counter++;
    }
    public void multiplication(View view){
        editText= (EditText) findViewById(R.id.editText);
        operator="*";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
            editText.setText(result);
            output=value1+operator+value2+"="+result+"\n";
            value1=result;
        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            editText.setText("");
        }
        counter++;
    }
    public void division(View view){
        editText= (EditText) findViewById(R.id.editText);
        operator="/";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            if(!value2.equals(0))
            {
                DecimalFormat df = new DecimalFormat("#.############################################");
                df.setDecimalSeparatorAlwaysShown(false);
                result = String.valueOf(df.format(Double.valueOf(value1)/Double.valueOf(value2)));
                editText.setText(result);
            }
            else
            {
                editText.setText("Invalid");
                result="Invalid";
            }

            output=value1+operator+value2+"="+result+"\n";
            value1=result;
        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            editText.setText("");
        }
        counter++;
    }
    public void SQRT(View view){
        editText= (EditText) findViewById(R.id.editText);
        value1=editText.getText().toString();
        result=String.valueOf(sqrt(Double.valueOf(value1)));
        editText.setText(result);
        value1=result;
    }
}
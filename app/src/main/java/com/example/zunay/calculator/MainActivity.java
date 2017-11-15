package com.example.zunay.calculator;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends Activity {
    private static String value1="0";
    private static String value2="0";
    private static String operator="";
    private static String result="0";
    private static int counter=0;
    private static int fValue=0;
    private static String output="";
    //SharedPreferences sharedPref;
    EditText editText;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sharedPref = getSharedPreferences("",Context.MODE_PRIVATE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        requestPermission();

    }
    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat
                    .requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    public void textAppend(View view) {
        editText=findViewById(R.id.editText);
        if(editText.getText().toString().equals(result) || fValue==0)
        {
            fValue++;//to avoid 1st 0 from the edittext
            editText.setText("");
        }
        Button content = (Button)view;
        String buttonText = content.getText().toString();
        editText.append(buttonText);
    }
    public void allClear(View view) throws FileNotFoundException {
        editText=findViewById(R.id.editText);
        editText.setText("");
        value1="0";
        value2="0";
        result="0";
        operator="";
        counter=0;
        fValue=0;
        File Root = Environment.getExternalStorageDirectory();
        File file = new File(Root.getAbsolutePath() + "/Memolist","memo.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
    public void clear(View view) {
        editText=findViewById(R.id.editText);
        if(editText.getText().toString().equals(""))
        {
            editText.setText("");
        }
        else
        {
            String text = editText.getText().toString();
            editText.setText(text.substring(0, text.length() - 1));
        }

    }
    public void memo(View view) {
        Intent intent= new Intent(MainActivity.this,Memo.class);
        startActivity(intent);
    }
    public void calculate(View view) throws IOException {

        editText= findViewById(R.id.editText);
        value2=editText.getText().toString();


        if(operator.equals("+")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            if(!value1.equals("") && !value2.equals(""))
            {
                result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value1.equals("") && value2.equals(""))
            {
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value2.equals("") && value1.equals(""))
            {
                value1="0";
                result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(value2.equals("") && value1.equals(""))
            {
                value1="0";
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)+Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
        }

        else if(operator.equals("-")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);

            if(!value1.equals("") && !value2.equals(""))
            {
                result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value1.equals("") && value2.equals(""))
            {
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value2.equals("") && value1.equals(""))
            {
                value1="0";
                result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(value2.equals("") && value1.equals(""))
            {
                value1="0";
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)-Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }

        }
        else if(operator.equals("*")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            if(!value1.equals("") && !value2.equals(""))
            {
                result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value1.equals("") && value2.equals(""))
            {
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(!value2.equals("") && value1.equals(""))
            {
                value1="0";
                result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(value2.equals("") && value1.equals(""))
            {
                value1="0";
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)*Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }

        }
        else if(operator.equals("/")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            if(!value1.equals("") && !value2.equals(""))
            {
                if(value2.equals("0"))
                {
                    result ="Invalid";
                    output="Invalid";
                    value1="0";
                }
                else
                {
                    result = String.valueOf(df.format(Double.valueOf(value1)/Double.valueOf(value2)));
                    output=value1+operator+value2+"="+result+"\n";
                    value1=result;
                }

            }
            else if(!value1.equals("") && value2.equals(""))
            {
                value2="0";
                result ="Invalid";
                output="Invalid";
                value1="0";
            }
            else if(!value2.equals("") && value1.equals(""))
            {
                value1="0";
                result = String.valueOf(df.format(Double.valueOf(value1)/Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }
            else if(value2.equals("") && value1.equals(""))
            {
                value1="0";
                value2="0";
                result = String.valueOf(df.format(Double.valueOf(value1)/Double.valueOf(value2)));
                output=value1+operator+value2+"="+result+"\n";
                value1=result;
            }

        }
        else if(operator.equals("^")){
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            if(!value1.equals("") && !value2.equals(""))
            {
                result = String.valueOf(df.format(pow(Double.valueOf(value1),Double.valueOf(value2))));
                output=value1+"powerof("+value2+")="+result+"\n";
            }
            else if(!value1.equals("") && value2.equals(""))
            {
                value2="0";
                result = String.valueOf(df.format(pow(Double.valueOf(value1),Double.valueOf(value2))));
                output=value1+"powerof("+value2+")="+result+"\n";
            }
            else if(!value2.equals("") && value1.equals(""))
            {
                value1="0";
                result = String.valueOf(df.format(pow(Double.valueOf(value1),Double.valueOf(value2))));
                output=value1+"powerof("+value2+")="+result+"\n";
            }
            else if(value2.equals("") && value1.equals(""))
            {
                value1="0";
                value2="0";
                result = String.valueOf(df.format(pow(Double.valueOf(value1),Double.valueOf(value2))));
                output=value1+"powerof("+value2+")="+result+"\n";
            }
        }
        //operator="";
        editText.setText(result);
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putString(getString(R.string.write_in_memo),result);
        //editor.commit();

        File Root = Environment.getExternalStorageDirectory();
        File Dir = new File(Root.getAbsolutePath() + "/Memolist");
        if (!Dir.exists()) {Dir.mkdir();} //Makes the directory if not exists
        File file = new File(Root.getAbsolutePath() + "/Memolist","memo.txt");
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
    public void plus(View view)throws IOException {
        editText=findViewById(R.id.editText);
        operator="+";
        output="";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            calculate(view);
        }
        else if(counter<1) {
            value1=editText.getText().toString();//for the first value
            if(value1.equals(""))
            {
                value1="0";
            }
            editText.setText("");
        }
        counter++;

    }
    public void minus(View view) throws IOException {
        editText= findViewById(R.id.editText);
        operator="-";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            calculate(view);
        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            if(value1.equals(""))
            {
                value1="0";
            }
            editText.setText("");
        }
        counter++;
    }
    public void multiplication(View view) throws IOException {
        editText= findViewById(R.id.editText);
        operator="*";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            DecimalFormat df = new DecimalFormat("#.############################################");
            df.setDecimalSeparatorAlwaysShown(false);
            calculate(view);

        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            if(value1.equals(""))
            {
                value1="0";
            }
            editText.setText("");
        }
        counter++;
    }
    public void division(View view) throws IOException {
        editText= findViewById(R.id.editText);
        operator="/";
        DecimalFormat df = new DecimalFormat("#.############################################");
        df.setDecimalSeparatorAlwaysShown(false);
        if(counter>=1)
        {
            value2=editText.getText().toString();
            calculate(view);
        }
        else if(counter<1)
        {
            value1=editText.getText().toString();
            if(value1.equals(""))
            {
                value1="0";
            }
            editText.setText("");
        }
        counter++;
    }
    public void SQRT(View view) throws IOException {
        operator="√";
        editText= findViewById(R.id.editText);
        value1=editText.getText().toString();
        if(!value1.equals("")) {
            result = String.valueOf(sqrt(Double.valueOf(value1)));
            editText.setText(result);
            output = operator + value1 + "=" + result + "\n";
            File Root = Environment.getExternalStorageDirectory();
            File Dir = new File(Root.getAbsolutePath() + "/Memolist");
            if (!Dir.exists()) {
                Dir.mkdir();
            } //Makes the directory if not exists
            File file = new File(Root.getAbsolutePath() + "/Memolist", "memo.txt");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write(output.getBytes());
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
            value1 = result;
        }
    }
    public void SQUARE(View view) throws IOException {
        editText= findViewById(R.id.editText);
        value1=editText.getText().toString();
        if (value1.equals(""))
        {
            value1="0";
        }
        result=String.valueOf(Double.valueOf(value1)*Double.valueOf(value1));
        editText.setText(result);
        output=value1+"\u00B2"+"="+result+"\n";
        File Root = Environment.getExternalStorageDirectory();
        File Dir = new File(Root.getAbsolutePath() + "/Memolist");
        if (!Dir.exists()) {Dir.mkdir();} //Makes the directory if not exists
        File file = new File(Root.getAbsolutePath() + "/Memolist","memo.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(output.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();
        value1=result;
    }
    public void INVERSE(View view){
        editText= findViewById(R.id.editText);
        value1=editText.getText().toString();
        if(!value1.equals(""))
        {
            result=String.valueOf(1/(Double.valueOf(value1)));
            editText.setText(result);
            value1=result;
            File Root = Environment.getExternalStorageDirectory();
            File Dir = new File(Root.getAbsolutePath() + "/Memolist");
            if (!Dir.exists()) {
                Dir.mkdir();
            } //Makes the directory if not exists
            File file = new File(Root.getAbsolutePath() + "/Memolist", "memo.txt");
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write(output.getBytes());
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
            value1 = result;
        }

    }
    public void powerOfX(View view) throws IOException {
        editText=findViewById(R.id.editText);
        operator="^";
        output="";
        if(counter>=1)
        {
            value2=editText.getText().toString();
            calculate(view);
        }
        else if(counter<1) {
            value1=editText.getText().toString();//for the first value
            if(value1.equals(""))
            {
                value1="0";
            }
            editText.setText("");
        }
        counter++;
    }



    @Override
    protected void onStop(){
        super.onStop();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        File Root = Environment.getExternalStorageDirectory();
        File file = new File(Root.getAbsolutePath() + "/Memolist","memo.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

    /* @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // Permission Denied
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }*/

}
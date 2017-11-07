package com.example.zunay.calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by zunay on 10/24/2017.
 */

public class Memo extends Activity{
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        sharedPref = getSharedPreferences("",MODE_PRIVATE);

    }
    protected void onResume()
    {
        super.onResume();
        setContentView(R.layout.memo);
        TextView textView=(TextView) findViewById(R.id.memo_textView);
        //String defaultValue = getResources().getString(R.string.write_in_memo);

        //String highScore = sharedPref.getString(getString(R.string.write_in_memo),"");
        //Toast.makeText(getApplicationContext(),"Value:"+highScore,Toast.LENGTH_SHORT).show();
       // textView.setText(highScore);
        StringBuilder stringBuilder=new StringBuilder();
        String eachLine=null;
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Demolist","demo.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((eachLine=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(eachLine);
                stringBuilder.append("\n");
            }

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        textView.setText(stringBuilder.toString());
    }

}
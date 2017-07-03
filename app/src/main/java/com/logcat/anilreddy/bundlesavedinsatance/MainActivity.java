package com.logcat.anilreddy.bundlesavedinsatance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counter;
    EditText et;
    String etString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;
        et = (EditText) findViewById(R.id.ET);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        etString = et.getText().toString();

        outState.putString("editTextValue",etString);
        outState.putInt("counter",counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        et.setText(savedInstanceState.getString("editTextValue"));
       counter = savedInstanceState.getInt("counter");

    }

    public void performAction(View v){

        switch (v.getId()){
            case R.id.btn1:
                   counter +=1;
                break;
            case R.id.btn2:
                Toast.makeText(getApplicationContext(),"The Counter value is:"+counter,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

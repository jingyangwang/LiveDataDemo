package com.example.wangjingyang.myapplication;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyObserver observer = new MyObserver();

        MyData data = new MyData();
        data.observe(this, observer);




    }


    private class MyObserver implements Observer<String> {
        @Override
        public void onChanged(@Nullable String o) {
            Toast.makeText(getApplicationContext(),String.valueOf(o), Toast.LENGTH_SHORT).show();
        }
    }

}

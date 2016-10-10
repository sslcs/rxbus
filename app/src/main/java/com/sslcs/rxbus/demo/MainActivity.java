package com.sslcs.rxbus.demo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sslcs.rxbus.Callback;
import com.sslcs.rxbus.R;
import com.sslcs.rxbus.RxBus;
import com.sslcs.rxbus.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onClickStartTest(View view) {
        RxBus.getDefault().subscribe(this, new Callback<ArrayList<String>>() {
            @Override
            public void onEvent(ArrayList<String> event) {
                binding.tvEventFirst.setBackgroundColor(0xff123456);
                binding.tvEventFirst
                    .setText(System.currentTimeMillis() + " onEvent : " + event.getClass().getSimpleName());
            }
        });
        RxBus.getDefault().subscribe(this, new Callback<TestEvent>() {
            @Override
            public void onEvent(TestEvent event) {
                binding.tvEventSecond.setBackgroundColor(0xff456789);
                binding.tvEventSecond
                    .setText(System.currentTimeMillis() + " onEvent : " + event.getClass().getSimpleName());
            }
        });

        startActivity(new Intent(this, TestActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        RxBus.getDefault().unsubscribe(this);
    }
}

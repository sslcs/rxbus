package com.sslcs.rxbus.demo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sslcs.rxbus.R;
import com.sslcs.rxbus.RxBus;
import com.sslcs.rxbus.databinding.ActivityTestBinding;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
    }

    public void onClickSendFirst(View view) {
        RxBus.getDefault().post(new ArrayList<String>());
    }

    public void onClickSendSecond(View view) {
        RxBus.getDefault().post(new TestEvent());
    }
}

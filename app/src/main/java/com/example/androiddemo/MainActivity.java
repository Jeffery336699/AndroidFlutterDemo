package com.example.androiddemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.flutter.facade.Flutter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        createFlutterView();
        createFlutterFragment();
    }

    private void createFlutterView() {
        View flutterView = Flutter.createView(
                MainActivity.this, getLifecycle(), "r1");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addContentView(flutterView, layoutParams);
    }

    private void createFlutterFragment() {
        setContentView(R.layout.activity_main);
        Fragment flutterFragment = Flutter.createFragment("r2");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, flutterFragment);
        ft.commit();
    }
}

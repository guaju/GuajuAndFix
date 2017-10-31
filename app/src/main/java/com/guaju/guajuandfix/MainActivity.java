package com.guaju.guajuandfix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void print(View view) {
        Log.e(TAG, "nobug了" );
        Toast.makeText(this, "没有bug了", Toast.LENGTH_SHORT).show();


    }

    public void installpatch(View view) {
        try {
            MyApplication.isHasPatch=true;
            MyApplication.andFixManager.checkHasPatch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.sasiroot.talde_proyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateaccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacc);
        this.setTitle(R.string.create_acc);
    }

    public void cancel(View view) {
        this.finish();
    }

    public void save(View view) {

    }
}

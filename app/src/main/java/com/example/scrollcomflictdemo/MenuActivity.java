package com.example.scrollcomflictdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scrollcomflictdemo.iner.CaseTwoActivity;
import com.example.scrollcomflictdemo.outer.CaseOneActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void caseOne(View view){
        startActivity(new Intent(this, CaseOneActivity.class));
    }

    public void caseTwo(View view){
        startActivity(new Intent(this, CaseTwoActivity.class));
    }
}

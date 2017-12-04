package com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.carl.ist422finalproject.R;

/**
 * Created by aschn on 12/3/2017.
 */

public class credits extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_credits);
        EditText mEdit = (EditText) findViewById(R.id.creditsTitle);
        mEdit.setEnabled(false);
    }
}

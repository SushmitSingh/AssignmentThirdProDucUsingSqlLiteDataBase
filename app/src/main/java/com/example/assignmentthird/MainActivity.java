package com.example.assignmentthird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout name, count, productId;
    FloatingActionButton fb;
    Button sbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (TextInputLayout) findViewById(R.id.proName);
        count = (TextInputLayout) findViewById(R.id.proCount);
        productId = (TextInputLayout) findViewById(R.id.proId);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        sbmt = (Button) findViewById(R.id.sbmt_add);


        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(name.getEditText().getText().toString(),count.getEditText().getText().toString(),productId.getEditText().getText().toString());
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });


    }

    private void processinsert(String n, String c, String e)
    {

        String res=new dbmanager(this).addrecord(n,c,e);
        name.getEditText().setText("");
        count.getEditText().setText("");
        productId.getEditText().setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }


}
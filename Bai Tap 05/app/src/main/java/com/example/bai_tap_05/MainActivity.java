package com.example.bai_tap_05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button btsignin;
    EditText  txtUser,txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btsignin = (Button) findViewById(R.id.button_signin);
        txtUser =(EditText) findViewById(R.id.textUser);
        txtpass=(EditText) findViewById(R.id.textPassword);
        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUser.getText().toString().equals("phuoc") && txtpass.getText().toString().equals("333")) {
                    doOpenChildActivity();
                    Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(myIntent);
    }
}
package com.example.bai_tap_08 ;

import android.content.Intent ;
import android.os.Bundle ;
import android.view.View ;
import android.widget.Button ;

import androidx.appcompat.app.AppCompatActivity ;

public class Main_Activity extends AppCompatActivity
{
    Button B_CLASS_MANAGEMENT , B_STUDENT_MANAGEMENT , B_SIGN_OUT ;
    String USER = "" , PASSWORD = "" ;

    @Override
    protected void onCreate( Bundle SAVED_INSTANCE_STATE )
    {
        super.onCreate( SAVED_INSTANCE_STATE ) ;
        setContentView( R.layout.activity_main ) ;
        initView() ;
        initListener() ;
//        showLogin() ;
    }

    private void initListener()
    {
        B_CLASS_MANAGEMENT.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Intent INTENT_01 = new Intent(Main_Activity.this, Class_Management.class ) ;
                startActivity( INTENT_01 ) ;
            }
        }) ;

        B_STUDENT_MANAGEMENT.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Intent INTENT_02 = new Intent(Main_Activity.this, Student_Management.class ) ;
                startActivity( INTENT_02 ) ;
            }
        }) ;
    }

    private void initView()
    {
        B_CLASS_MANAGEMENT = ( Button ) findViewById( R.id.B_CLASS_MANAGER ) ;
        B_STUDENT_MANAGEMENT = ( Button ) findViewById( R.id.B_STUDENT_MANAGER ) ;
//        SIGN_OUT = ( Button ) findViewById( R.id.B_SIGN_OUT ) ;
    }
}
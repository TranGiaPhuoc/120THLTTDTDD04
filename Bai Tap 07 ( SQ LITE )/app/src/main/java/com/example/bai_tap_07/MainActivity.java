package com.example.bai_tap_07 ;

import android.os.Bundle ;
import android.view.View ;
import android.widget.Button ;
import android.widget.EditText ;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity ;

public class MainActivity extends AppCompatActivity
{
    private Button B_ADD ;
    private Button B_DELETE ;
    private Button B_EDIT ;
    private EditText ET_ID ;
    private EditText ET_NAME ;
    private EditText ET_CHEMISTRY ;
    private EditText ET_MATH ;
    private EditText ET_PHYSICS ;
    private My_Database MY_DATABASE ;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState ) ;
        setContentView( R.layout.activity_main ) ;
        MY_DATABASE = new My_Database( this ) ;
        initView() ;
        initListener() ;
    }

    private void initListener()
    {
        B_ADD.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String CHEMISTRY = ET_CHEMISTRY.getText().toString() ;
                String MATH = ET_MATH.getText().toString() ;
                String NAME = ET_NAME.getText().toString() ;
                String PHYSICS = ET_PHYSICS.getText().toString() ;
                boolean BOOLEAN = MY_DATABASE.INSERT( NAME , CHEMISTRY , PHYSICS , MATH ) ;
                if ( BOOLEAN )
                    Toast.makeText( MainActivity.this , "INSERTED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( MainActivity.this , "INSERT FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;
        B_DELETE.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String ID = ET_ID.getText().toString() ;
                boolean BOOLEAN = MY_DATABASE.DELETE( ID ) ;
                if ( BOOLEAN )
                    Toast.makeText( MainActivity.this , "DELETED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( MainActivity.this , "DELETE FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;
        B_EDIT.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String CHEMISTRY = ET_CHEMISTRY.getText().toString() ;
                String ID = ET_ID.getText().toString() ;
                String MATH = ET_MATH.getText().toString() ;
                String NAME = ET_NAME.getText().toString() ;
                String PHYSICS = ET_PHYSICS.getText().toString() ;
                boolean BOOLEAN = MY_DATABASE.UPDATE( ID , NAME , CHEMISTRY , PHYSICS , MATH ) ;
                if ( BOOLEAN )
                    Toast.makeText( MainActivity.this , "UPDATED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( MainActivity.this , "UPDATE FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;
    }

    private void initView()
    {
        B_ADD = ( Button ) findViewById( R.id.B_ADD ) ;
        B_DELETE = ( Button ) findViewById( R.id.B_DELETE ) ;
        B_EDIT = ( Button ) findViewById( R.id.B_EDIT ) ;
        ET_CHEMISTRY = ( EditText ) findViewById( R.id.ET_CHEMISTRY ) ;
        ET_ID = ( EditText ) findViewById( R.id.ET_ID ) ;
        ET_MATH = ( EditText ) findViewById( R.id.ET_MATH ) ;
        ET_NAME = ( EditText ) findViewById( R.id.ET_NAME ) ;
        ET_PHYSICS = ( EditText ) findViewById( R.id.ET_PHYSICS ) ;
    }
}
package com.example.bai_tap_07 ;

import android.os.Bundle ;
import android.view.View ;
import android.widget.Button ;
import android.widget.EditText ;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity ;

public class Main_Activity extends AppCompatActivity
{
    private Button B_ADD ;
    private Button B_DELETE ;
    private Button B_EDIT ;
    private Database DATABASE ;
    private EditText ET_Id ;
    private EditText ET_NAME ;
    private EditText ET_CHEMISTRY ;
    private EditText ET_MATH ;
    private EditText ET_PHYSICS ;

    @Override
    protected void onCreate( Bundle SAVED_INSTANCE_STATE )
    {
        super.onCreate( SAVED_INSTANCE_STATE ) ;
        setContentView( R.layout.activity_main) ;
        DATABASE = new Database( this ) ;
        initView() ;
        initListener() ;
    }

    private void initListener()
    {
        B_ADD.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String CHEMISTRY = ET_CHEMISTRY.getText().toString() ;
                String MATH = ET_MATH.getText().toString() ;
                String NAME = ET_NAME.getText().toString() ;
                String PHYSICS = ET_PHYSICS.getText().toString() ;
                boolean BOOLEAN = DATABASE.INSERT( NAME , CHEMISTRY , PHYSICS , MATH ) ;
                if ( BOOLEAN )
                    Toast.makeText( Main_Activity.this , "INSERTED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( Main_Activity.this , "INSERT FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;

        B_DELETE.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String ID = ET_Id.getText().toString() ;
                boolean BOOLEAN = DATABASE.DELETE( ID ) ;
                if ( BOOLEAN )
                    Toast.makeText( Main_Activity.this , "DELETED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( Main_Activity.this , "DELETE FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;

        B_EDIT.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                String CHEMISTRY = ET_CHEMISTRY.getText().toString() ;
                String ID = ET_Id.getText().toString() ;
                String MATH = ET_MATH.getText().toString() ;
                String NAME = ET_NAME.getText().toString() ;
                String PHYSICS = ET_PHYSICS.getText().toString() ;
                boolean BOOLEAN = DATABASE.UPDATE( ID , NAME , CHEMISTRY , PHYSICS , MATH ) ;
                if ( BOOLEAN )
                    Toast.makeText( Main_Activity.this , "UPDATED" , Toast.LENGTH_LONG ).show() ;
                else
                    Toast.makeText( Main_Activity.this , "UPDATE FAIL" , Toast.LENGTH_LONG ).show() ;
            }
        }) ;
    }

    private void initView()
    {
        B_ADD = ( Button ) findViewById( R.id.B_ADD ) ;
        B_DELETE = ( Button ) findViewById( R.id.B_DELETE ) ;
        B_EDIT = ( Button ) findViewById( R.id.B_EDIT ) ;
        ET_CHEMISTRY = ( EditText ) findViewById( R.id.ET_CHEMISTRY ) ;
        ET_Id = ( EditText ) findViewById( R.id.ET_Id ) ;
        ET_MATH = ( EditText ) findViewById( R.id.ET_MATH ) ;
        ET_NAME = ( EditText ) findViewById( R.id.ET_NAME ) ;
        ET_PHYSICS = ( EditText ) findViewById( R.id.ET_PHYSICS ) ;
    }
}
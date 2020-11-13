package com.example.bai_tap_08 ;

import android.os.Bundle ;
import android.view.View ;
import android.widget.AdapterView ;
import android.widget.ArrayAdapter ;
import android.widget.Button ;
import android.widget.EditText ;
import android.widget.ListView ;
import android.widget.TextView ;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity ;
import java.util.ArrayList ;

public class Class_Management extends AppCompatActivity
{
    ArrayList< Class > CLASS = new ArrayList<>() ;
    Button B_ADD_01 , B_DELETE_01 , B_EDIT_01 ;
    EditText ET_Id , ET_NAME ;
    int LOCATION = -1 ;
    ListView LV_01 ;
    TextView TV_COUNT_01 ;

    @Override
    protected void onCreate( Bundle SAVED_INSTANCE_STATE )
    {
        super.onCreate( SAVED_INSTANCE_STATE ) ;
        setContentView( R.layout.class_management ) ;
        initView() ;
        initListener() ;
    }

    private void initListener()
    {
        CLASS.add( new Class( "PT01" , "MOB" )) ;
        CLASS.add( new Class( "PT01" , "MOB" )) ;
        CLASS.add( new Class( "PT01" , "MOB" )) ;
        final ArrayAdapter< Class > ARRAY_ADAPTER = new ArrayAdapter<> ( this , android.R.layout.simple_list_item_1 , CLASS ) ;
        LV_01.setAdapter( ARRAY_ADAPTER ) ;
        TV_COUNT_01.setText("Count : " + CLASS.size());

        B_ADD_01.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Class C = new Class() ;
                C.setId( ET_Id.getText().toString()) ;
                C.setNAME( ET_NAME.getText().toString()) ;
                CLASS.add( C ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
                TV_COUNT_01.setText("Count : " + CLASS.size());
                ET_Id.setText( "" ) ;
                ET_NAME.setText( "" ) ;
            }
        }) ;

        LV_01.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick( AdapterView<?> PARENT , View VIEW , int POSITION , long Id )
            {
                Toast.makeText( getApplicationContext() , "Item " + POSITION , Toast.LENGTH_SHORT ).show() ;
                Class C = CLASS.get( POSITION ) ;
                ET_Id.setText( C.getId()) ;
                ET_NAME.setText( C.getNAME()) ;
                LOCATION = POSITION ;
            }
        }) ;

        B_EDIT_01.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Class C = new Class() ;
                C.setId( ET_Id.getText().toString()) ;
                C.setNAME( ET_NAME.getText().toString()) ;
                CLASS.set( LOCATION , C ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
            }
        }) ;

        B_DELETE_01.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                ET_Id.setText( "" ) ;
                ET_NAME.setText( "" ) ;
                CLASS.remove( LOCATION ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
                TV_COUNT_01.setText("Count : " + CLASS.size());
            }
        }) ;
    }

    private void initView()
    {
        B_ADD_01 = ( Button ) findViewById( R.id.B_ADD_01 ) ;
        B_DELETE_01 = ( Button ) findViewById( R.id.B_DELETE_01 ) ;
        B_EDIT_01 = ( Button ) findViewById( R.id.B_DELETE_01 ) ;
        ET_Id = ( EditText ) findViewById( R.id.ET_Id ) ;
        ET_NAME = ( EditText ) findViewById( R.id.ET_NAME ) ;
        LV_01 = ( ListView ) findViewById( R.id.LV_01 ) ;
        TV_COUNT_01 = ( TextView ) findViewById( R.id.TV_COUNT_01 ) ;
    }
}

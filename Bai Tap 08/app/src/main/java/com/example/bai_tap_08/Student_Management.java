package com.example.bai_tap_08 ;

import android.os.Bundle ;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button ;
import android.widget.EditText ;
import android.widget.ListView ;
import android.widget.TextView ;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity ;

import java.util.ArrayList;

public class Student_Management extends AppCompatActivity
{
    ArrayList< Student > STUDENT = new ArrayList<>() ;
    Button B_ADD_02 , B_DELETE_02 , B_EDIT_02 ;
    EditText ET_ADDRESS , ET_AGE , ET_EMAIL , ET_PHONE , ET_STUDENTS_CODE , ET_STUDENTS_NAME ;
    int LOCATION = -1 ;
    ListView LV_02 ;
    TextView TV_COUNT_02 ;

    @Override
    protected void onCreate( Bundle SAVED_INSTANCE_STATE )
    {
        super.onCreate( SAVED_INSTANCE_STATE ) ;
        setContentView( R.layout.student_management ) ;
        initView() ;
        initListener() ;
    }

    private void initListener()
    {
        STUDENT.add( new Student( "331" , "Lê A" , "20" , "Đà Nẵng" , "A@gmail.com" , "120331" )) ;
        STUDENT.add( new Student( "332" , "Nguyễn B" , "20" , "Đà Nẵng" , "B@gmail.com" , "120332" )) ;
        STUDENT.add( new Student( "1811505310333" , "Trần Gia Phước" , "20" , "Đà Nẵng" , "phuocgiatran780@gmail.com" , "0795724957" )) ;
        final ArrayAdapter< Student > ARRAY_ADAPTER = new ArrayAdapter<> ( this , android.R.layout.simple_list_item_1 , STUDENT ) ;
        LV_02.setAdapter( ARRAY_ADAPTER ) ;
        TV_COUNT_02.setText("Count : " + STUDENT.size()) ;

        B_ADD_02.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Student S = new Student() ;
                S.setSTUDENTS_CODE( ET_STUDENTS_CODE.getText().toString()) ;
                S.setSTUDENTS_NAME( ET_STUDENTS_NAME.getText().toString()) ;
                S.setAGE( ET_AGE.getText().toString()) ;
                S.setADDRESS( ET_ADDRESS.getText().toString()) ;
                S.setEMAIL( ET_EMAIL.getText().toString()) ;
                S.setPHONE( ET_PHONE.getText().toString()) ;
                STUDENT.add( S ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
                TV_COUNT_02.setText("Count : " + STUDENT.size()) ;
                ET_ADDRESS.setText( "" ) ;
                ET_AGE.setText( "" ) ;
                ET_EMAIL.setText( "" ) ;
                ET_PHONE.setText( "" ) ;
                ET_STUDENTS_CODE.setText( "" ) ;
                ET_STUDENTS_NAME.setText( "" ) ;
            }
        }) ;

        LV_02.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick( AdapterView<?> PARENT , View VIEW , int POSITION , long Id )
            {
                Toast.makeText( getApplicationContext() , "Item " + POSITION , Toast.LENGTH_SHORT ).show() ;
                Student S = STUDENT.get( POSITION ) ;
                ET_STUDENTS_CODE.setText( S.getSTUDENTS_CODE()) ;
                ET_STUDENTS_NAME.setText( S.getSTUDENTS_NAME()) ;
                ET_AGE.setText( S.getAGE()) ;
                ET_ADDRESS.setText( S.getADDRESS()) ;
                ET_EMAIL.setText( S.getEMAIL()) ;
                ET_PHONE.setText( S.getPHONE()) ;
                LOCATION = POSITION ;
            }
        }) ;

        B_EDIT_02.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                Student S = new Student() ;
                S.setSTUDENTS_CODE( ET_STUDENTS_CODE.getText().toString()) ;
                S.setSTUDENTS_NAME( ET_STUDENTS_NAME.getText().toString()) ;
                S.setAGE( ET_AGE.getText().toString()) ;
                S.setADDRESS( ET_ADDRESS.getText().toString()) ;
                S.setEMAIL( ET_EMAIL.getText().toString()) ;
                S.setPHONE( ET_PHONE.getText().toString()) ;
                STUDENT.set( LOCATION , S ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
            }
        }) ;

        B_DELETE_02.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View VIEW )
            {
                ET_ADDRESS.setText( "" ) ;
                ET_AGE.setText( "" ) ;
                ET_EMAIL.setText( "" ) ;
                ET_PHONE.setText( "" ) ;
                ET_STUDENTS_CODE.setText( "" ) ;
                ET_STUDENTS_NAME.setText( "" ) ;
                STUDENT.remove( LOCATION ) ;
                ARRAY_ADAPTER.notifyDataSetChanged() ;
                TV_COUNT_02.setText("Count : " + STUDENT.size());
            }
        }) ;
    }

    private void initView()
    {
        B_ADD_02 = ( Button ) findViewById( R.id.B_ADD_02 ) ;
        B_DELETE_02 = ( Button ) findViewById( R.id.B_DELETE_02 ) ;
        B_EDIT_02 = ( Button ) findViewById( R.id.B_EDIT_02 ) ;
        ET_ADDRESS = ( EditText ) findViewById( R.id.ET_ADDRESS ) ;
        ET_AGE = ( EditText ) findViewById( R.id.ET_AGE ) ;
        ET_EMAIL = ( EditText ) findViewById( R.id.ET_EMAIL ) ;
        ET_PHONE = ( EditText ) findViewById( R.id.ET_PHONE ) ;
        ET_STUDENTS_CODE = ( EditText ) findViewById( R.id.ET_STUDENTS_CODE ) ;
        ET_STUDENTS_NAME = ( EditText ) findViewById( R.id.ET_STUDENTS_NAME ) ;
        LV_02 = ( ListView ) findViewById( R.id.LV_02 ) ;
        TV_COUNT_02 = ( TextView ) findViewById( R.id.TV_COUNT_02 ) ;
    }
}
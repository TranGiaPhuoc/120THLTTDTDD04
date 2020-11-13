package com.example.bai_tap_07 ;

import android.content.ContentValues ;
import android.content.Context ;
import android.database.sqlite.SQLiteDatabase ;
import android.database.sqlite.SQLiteOpenHelper ;

public class Database extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Database.DB" ;
    private static final String LINE_01 = "Id" ;
    private static final String LINE_02 = "NAME" ;
    private static final String LINE_03 = "CHEMISTRY" ;
    private static final String LINE_04 = "PHYSICS" ;
    private static final String LINE_05 = "MATH" ;
    private static final String TABLE_NAME = "Sinh_Vien" ;

    public Database( Context CONTEXT )
    {
        super ( CONTEXT , DATABASE_NAME , null , 1 ) ;
    }

    @Override
    public void onCreate( SQLiteDatabase SQ_LITE_DATABASE )
    {
        SQ_LITE_DATABASE.execSQL( "CREATE TABLE " + TABLE_NAME + " (" + LINE_01 + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
               LINE_02 + " TEXT , " + LINE_03 + " INTEGER , " + LINE_04 + " INTEGER , " + LINE_05 + " INTEGER )") ;
    }

    @Override
    public void onUpgrade( SQLiteDatabase SQ_LITE_DATABASE , int INT_01 , int INT_02 )
    {
        SQ_LITE_DATABASE.execSQL( "DROP TABLE IF EXISTS " + TABLE_NAME  ) ;
        onCreate( SQ_LITE_DATABASE ) ;
    }

    public boolean DELETE( String Id )
    {
        SQLiteDatabase DATABASE = this.getWritableDatabase() ;
        long RESULTS = DATABASE.delete( TABLE_NAME , LINE_01 + " = ?" , new String[] { Id }) ;
        if ( RESULTS == -1 )
            return false ;
        else
            return true ;
    }

    public boolean INSERT( String NAME , String CHEMISTRY , String PHYSICS , String MATH )
    {
        SQLiteDatabase DATABASE = this.getWritableDatabase() ;
        ContentValues VALUES = new ContentValues() ;
        VALUES.put( LINE_02 , NAME ) ;
        VALUES.put( LINE_03 , CHEMISTRY ) ;
        VALUES.put( LINE_04 , PHYSICS ) ;
        VALUES.put( LINE_05 , MATH ) ;
        long RESULTS = DATABASE.insert( TABLE_NAME , null , VALUES ) ;
        if ( RESULTS == -1 )
            return false ;
        else
            return true ;
    }

    public boolean UPDATE( String Id , String NAME , String CHEMISTRY , String PHYSICS , String MATH )
    {
        SQLiteDatabase DATABASE = this.getWritableDatabase() ;
        ContentValues VALUES = new ContentValues() ;
        VALUES.put( LINE_01 , Id ) ;
        VALUES.put( LINE_02 , NAME ) ;
        VALUES.put( LINE_03 , CHEMISTRY ) ;
        VALUES.put( LINE_04 , PHYSICS ) ;
        VALUES.put( LINE_05 , MATH ) ;
        long RESULTS = DATABASE.update( TABLE_NAME , VALUES , LINE_01 + " = ?" , new String[] { Id }) ;
        if ( RESULTS == -1 )
            return false ;
        else
            return true ;
    }
}
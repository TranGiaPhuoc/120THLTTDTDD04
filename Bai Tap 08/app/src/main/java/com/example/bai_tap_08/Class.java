package com.example.bai_tap_08 ;

public class Class
{
    private String Id ;
    private String NAME ;

    public Class() {}

    public Class( String Id , String NAME )
    {
        this.Id = Id ;
        this.NAME = NAME ;
    }

    public String getId()
    {
        return Id ;
    }

    public String getNAME()
    {
        return NAME ;
    }

    public void setId( String Id )
    {
        this.Id = Id ;
    }

    public void setNAME( String NAME )
    {
        this.NAME = NAME ;
    }

    @Override
    public String toString()
    {
        return getId() + " - " + getNAME() ;
    }
}

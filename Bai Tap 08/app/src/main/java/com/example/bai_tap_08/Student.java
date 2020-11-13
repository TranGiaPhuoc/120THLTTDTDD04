package com.example.bai_tap_08 ;

public class Student
{
    private String ADDRESS ;
    private String AGE ;
    private String EMAIL ;
    private String PHONE ;
    private String STUDENTS_CODE ;
    private String STUDENTS_NAME ;

    public Student() {}

    public Student( String STUDENTS_CODE , String STUDENTS_NAME , String AGE , String ADDRESS , String EMAIL , String PHONE )
    {
        this.ADDRESS = ADDRESS ;
        this.AGE = AGE ;
        this.EMAIL = EMAIL ;
        this.PHONE = PHONE ;
        this.STUDENTS_CODE = STUDENTS_CODE ;
        this.STUDENTS_NAME = STUDENTS_NAME ;
    }

    public String getADDRESS()
    {
        return ADDRESS ;
    }

    public String getAGE()
    {
        return AGE ;
    }

    public  String getEMAIL()
    {
        return EMAIL ;
    }

    public String getPHONE()
    {
        return PHONE ;
    }

    public String getSTUDENTS_CODE()
    {
        return STUDENTS_CODE ;
    }

    public String getSTUDENTS_NAME()
    {
        return STUDENTS_NAME ;
    }

    public void setADDRESS( String ADDRESS )
    {
        this.ADDRESS = ADDRESS ;
    }

    public void setAGE(String AGE )
    {
        this.AGE = AGE ;
    }

    public void setEMAIL( String EMAIL )
    {
        this.EMAIL = EMAIL ;
    }

    public void setPHONE( String PHONE )
    {
        this.PHONE = PHONE ;
    }

    public void setSTUDENTS_CODE( String STUDENTS_CODE )
    {
        this.STUDENTS_CODE = STUDENTS_CODE ;
    }

    public void setSTUDENTS_NAME( String STUDENTS_NAME )
    {
        this.STUDENTS_NAME = STUDENTS_NAME ;
    }

    @Override
    public String toString()
    {
        return getSTUDENTS_CODE() + " - " + getSTUDENTS_NAME() + " - " + getAGE() + " - " + getADDRESS() + " - " + getEMAIL() + " - " + getPHONE() ;
    }
}

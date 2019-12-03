package com.example.marveldroid.data;

public class DatabaseUtils {

    //Database
    public static final String DATABASE ="db_marveldroid";

    //Constants
    public static final String USER_TABLE="user";
    public static final String MARK_TABLE="mark";


    //Common constants
    public static final String ID_FIELD="id";


    //Constants User table
    public static final String NAME_FIELD="name";
    public static final String PASSWORD_FIELD="password";


    //Constants Password table
    public static final String SCORE_FIELD="score";

    public static final String CREATE_TABLE_USER=
            "CREATE TABLE " + USER_TABLE + "( " +
                    ID_FIELD + " INTEGER, " +
                    NAME_FIELD + " TEXT, " +
                    PASSWORD_FIELD + " TEXT)";

    public static final String CREATE_TABLE_MARKS=
            "CREATE TABLE " + MARK_TABLE + " ( " +
                    ID_FIELD + "INTEGER, " +
                    SCORE_FIELD + " TEXT)";

}

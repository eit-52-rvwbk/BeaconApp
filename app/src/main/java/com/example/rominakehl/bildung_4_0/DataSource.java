package com.example.rominakehl.bildung_4_0;

/**
 * Created by david on 12.06.17.
 */

public final class DataSource {
    public static final String TABLENAME = "Measurements";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_L1 = "L1";
    public static final String COLUMN_L2 = "L2";
    public static final String COLUMN_L3 = "L3";
    public static final String COLUMN_H1 = "H1";
    public static final String COLUMN_H2 = "H2";
    public static final String COLUMN_H3 = "H3";
    public static final String COLUMN_B1 = "B1";
    public static final String COLUMN_B2 = "B2";
    public static final String COLUMN_B3 = "B3";
    public static final String COLUMN_COLOR = "Color";
    public static final String COLUMN_CUSTOMER = "Customer";
    public static final String COLUMN_TESTER = "Tester";
    public static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + TABLENAME + " (" +
        COLUMN_ID + " INTEGER PRIMARY KEY," +
        COLUMN_L1 + " REAL," +
        COLUMN_L2 + " REAL," +
        COLUMN_L3 + " REAL," +
        COLUMN_H1 + " REAL," +
        COLUMN_H2 + " REAL," +
        COLUMN_H3 + " REAL," +
        COLUMN_B1 + " REAL," +
        COLUMN_B2 + " REAL," +
        COLUMN_B3 + " REAL," +
        COLUMN_COLOR + " TEXT," +
        COLUMN_CUSTOMER + " TEXT," +
        COLUMN_TESTER + " TEXT)";
}

package gotz8.disease;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class myDBClass extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "DiseaseMonitor.db";

    // Table Name
    private static final String TABLE_BAC ="BacTable";
    private static final String TABLE_VIRUS = "VirusTable";
    private static final String TABLE_VACCINE = "VaccineTable";

    public myDBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // Create Table Name
        //db.execSQL("DROP TABLE IF EXISTS "+ TABLE_VIRUS);
        // db.execSQL("DROP TABLE IF EXISTS"+ TABLE_BAC);
        // db.execSQL("DROP TABLE IF EXISTS"+ TABLE_VACCINE);


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_VIRUS +
                "(VIR_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " VIR_NAME_EN TEXT(100)," +
                " VIR_NAME_TH TEXT(100)," +
                " VIR_VACCINE TEXT(100)," +
                " VIR_DATA TEXT(400));");
        Log.d("CREATE TABLE","Create Table Successfully.");

        //table bacteria
        db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_BAC +
                "(BAC_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BAC_NAME_EN TEXT(100)," +
                "BAC_NAME_TH TEXT(100)," +
                "BAC_VACCINE TEXT(100)," +
                "BAC_DATA TEXT(400));");
        Log.d("CREATE TABLE","Create Table Successfully.");

        //table vaccine
        db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_VACCINE +
                "(VAC_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "VAC_NAME TEXT(100)," +
                "VAC_PRODUCT_DIS TEXT(100)," +
                "VAC_YEAR_PD TEXT(100)," +
                "VAC_MANUFACTURER TEXT(100)," +
                "VAC_TYPE TEXT(100)," +
                "VAC_DESCRIPTION TEXT(200));"
        );

    }

    // Show All Data
    public ArrayList<HashMap<String, String>> SelectVirusTableData(Virus word,String search_dis) {
        // TODO Auto-generated method stub

        ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;


        SQLiteDatabase db;
        db = this.getReadableDatabase(); // Read Data
        String strSQL =  "";
        if(search_dis.isEmpty())
            strSQL = "SELECT  * FROM VirusTable";
        else
            strSQL = "SELECT  * FROM VirusTable WHERE VIR_NAME_EN LIKE '%"+search_dis+"%'";

        //String str1SQL = "SELECT * FROM BacTable";
        Cursor cursor = db.rawQuery(strSQL, null);
        //Cursor cursor1 = db.rawQuery(str1SQL, null);

        if(cursor != null)
        {
            while (cursor.moveToNext()){
                map = new HashMap<String, String>();
                map.put("VIR_ID", cursor.getString(0));
                map.put("VIR_NAME_EN", cursor.getString(1));
                map.put("VIR_NAME_TH", cursor.getString(2));
                map.put("VIR_VACCINE", cursor.getString(3));
                map.put("VIR_DATA", cursor.getString(4));
                MyArrList.add(map);
            }
        }
        assert cursor != null;
        cursor.close();
        db.close();
        return MyArrList;


    }
    public ArrayList<HashMap<String, String>> SelectVaccineData(Context t,String search_dis) {
        // TODO Auto-generated method stub

        ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;


        SQLiteDatabase db;
        db = this.getReadableDatabase(); // Read Data
        String strSQL =  "";
        if(search_dis.isEmpty())
            strSQL = "select * from VaccineTable";
        else
            strSQL = "SELECT * FROM VaccineTable WHERE VAC_PRODUCT_DIS LIKE '%"+search_dis+"%'";

        //String str1SQL = "SELECT * FROM BacTable";
        Cursor cursor = db.rawQuery(strSQL, null);
        //Cursor cursor1 = db.rawQuery(str1SQL, null);

        if(cursor != null)
        {
            while (cursor.moveToNext()){
                map = new HashMap<String, String>();
                map.put("VAC_ID", cursor.getString(0));
                map.put("VAC_NAME", cursor.getString(1));
                map.put("VAC_PRODUCT_DIS", cursor.getString(2));
                map.put("VAC_YEAR_PD", cursor.getString(3));
                map.put("VAC_MANUFACTURER", cursor.getString(4));
                map.put("VAC_TYPE", cursor.getString(5));
                map.put("VAC_DESCRIPTION", cursor.getString(6));
                MyArrList.add(map);
            }
        }
        assert cursor != null;
        cursor.close();
        db.close();
        return MyArrList;


    }

    public ArrayList<HashMap<String, String>> SelectAnotherData(Context t,String search_dis) {
        // TODO Auto-generated method stub

        ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;


        SQLiteDatabase db;
        db = this.getReadableDatabase(); // Read Data
        String strSQL =  "";
        if(search_dis.isEmpty())
            strSQL = "select * from BacTable";
        else
            strSQL = "SELECT * FROM BacTable WHERE BAC_NAME_EN LIKE '%"+search_dis+"%' OR BAC_NAME_TH LIKE '%"+search_dis+"%'";
        //String str1SQL = "SELECT * FROM BacTable";
        Cursor cursor = db.rawQuery(strSQL, null);
        //Cursor cursor1 = db.rawQuery(str1SQL, null);

        if(cursor != null)
        {
            while (cursor.moveToNext()){
                map = new HashMap<String, String>();
                map.put("BAC_ID", cursor.getString(0));
                map.put("BAC_NAME_EN", cursor.getString(1));
                map.put("BAC_NAME_TH", cursor.getString(2));
                map.put("BAC_VACCINE", cursor.getString(3));
                map.put("BAC_DATA", cursor.getString(4));
                MyArrList.add(map);
            }
        }
        assert cursor != null;
        cursor.close();
        db.close();
        return MyArrList;


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_VIRUS);
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_BAC);
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_VACCINE);
        // Re Create on method  onCreate
        onCreate(db);
    }


}
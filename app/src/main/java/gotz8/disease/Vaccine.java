package gotz8.disease;

/**
 * Created by Gotz8 on 3/22/2018.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Vaccine extends Activity {
    ArrayList<HashMap<String, String>> dirArray;
    SQLiteDatabase mDb;
    MyDBHelper mHelper;
    Cursor mCursor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vaccine);

        ListView listViewVir = (ListView)findViewById(R.id.listViewVacType);

        mHelper = new MyDBHelper(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        //mCursor = mDb.rawQuery("SELECT " + MyDBHelper.COL_NAME + ", "
        //        + MyDBHelper.COL_PIECE_PRICE + ", " + MyDBHelper.COL_CAKE_PRICE
        //        + " FROM " + MyDBHelper.TABLE_NAME, null);

        mCursor = mDb.rawQuery("SELECT  * FROM VacTable",null);
        dirArray = new ArrayList<>();


        mCursor.moveToFirst();
        while ( !mCursor.isAfterLast() ){
            HashMap<String, String> map = new HashMap<>();
            map.put("VAC_NAME",mCursor.getString(mCursor.getColumnIndex("VAC_NAME")));
            map.put("VAC_PRODUCT_DIS",mCursor.getString(mCursor.getColumnIndex("VAC_PRODUCT_DIS")));
            map.put("VAC_YEAR_PD",mCursor.getString(mCursor.getColumnIndex("VAC_YEAR_PD")));
            map.put("VAC_MANUFACTURER",mCursor.getString(mCursor.getColumnIndex("VAC_MANUFACTURER")));
            map.put("VAC_TYPE",mCursor.getString(mCursor.getColumnIndex("VAC_TYPE")));
            map.put("VAC_DESCRIPTION",mCursor.getString(mCursor.getColumnIndex("VAC_DESCRIPTION")));
            dirArray.add(map);
            mCursor.moveToNext();

        }

        final SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(Vaccine.this, dirArray, R.layout.activity_list_vaccine
                ,new String[] {"VAC_NAME", "VAC_PRODUCT_DIS", "VAC_YEAR_PD"}
                ,new int[] {R.id.VacName, R.id.VacProduct, R.id.VacYear});
        listViewVir.setAdapter(sAdap);
    }

    public void onPause() {
        super.onPause();
        mHelper.close();

        mDb.close();
    }
    public void ClickVac (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome
}
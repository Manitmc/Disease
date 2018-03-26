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

import android.widget.AdapterView;
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
        listViewVir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //               String item = VirusList.get(i).get("VIR_NAME_EN");

                String item2 =dirArray.get(i).get("VAC_NAME");
                String item3 =dirArray.get(i).get("VAC_MANUFACTURER");
                String item4 =dirArray.get(i).get("VAC_TYPE");
                String item5 =dirArray.get(i).get("VAC_DESCRIPTION");
                Intent intent = new Intent(Vaccine.this,VaccineData.class);

                intent.putExtra("VAC_NAME",item2);
                intent.putExtra("VAC_MANUFACTURER",item3);
                intent.putExtra("VAC_TYPE",item4);
                intent.putExtra("VAC_DESCRIPTION",item5);
                startActivity(intent);

/*
                   Context context = getApplicationContext();
                 int duration = Toast.LENGTH_SHORT;
                   Toast toast = Toast.makeText(context, item, duration);
                 toast.show();
*/
//                    ClickVirus();
            }
        });
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
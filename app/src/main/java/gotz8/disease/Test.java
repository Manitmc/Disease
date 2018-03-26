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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Test extends Activity {
    ArrayList<HashMap<String, String>> dirArray;
    ListView listViewVir;
    SQLiteDatabase mDb;
    MyDBHelper mHelper;
    Cursor mCursor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        ListView listViewVir = (ListView)findViewById(R.id.listViewvir);

        mHelper = new MyDBHelper(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);

        //mCursor = mDb.rawQuery("SELECT " + MyDBHelper.COL_NAME + ", "
        //        + MyDBHelper.COL_PIECE_PRICE + ", " + MyDBHelper.COL_CAKE_PRICE
        //        + " FROM " + MyDBHelper.TABLE_NAME, null);

        mCursor = mDb.rawQuery("SELECT  * FROM VirusTable",null);
        dirArray = new ArrayList<>();


        mCursor.moveToFirst();
        while ( !mCursor.isAfterLast() ){
            HashMap<String, String> map = new HashMap<>();
            map.put("VIR_NAME_EN",mCursor.getString(mCursor.getColumnIndex("VIR_NAME_EN")));
            map.put("VIR_NAME_TH",mCursor.getString(mCursor.getColumnIndex("VIR_NAME_TH")));
            map.put("VIR_VACCINE",mCursor.getString(mCursor.getColumnIndex("VIR_VACCINE")));
            map.put("VIR_DATA",mCursor.getString(mCursor.getColumnIndex("VIR_DATA")));
            dirArray.add(map);
            mCursor.moveToNext();
        }

        final SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(Test.this, dirArray, R.layout.activity_list_virus
                ,new String[] {"VIR_NAME_EN", "VIR_NAME_TH", "VIR_VACCINE","VIR_DATA"}
                ,new int[] {R.id.VirNameEng, R.id.VirNameTH, R.id.VirVaccine,R.id.VirDT});
        listViewVir.setAdapter(sAdap);
        listViewVir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //               String item = VirusList.get(i).get("VIR_NAME_EN");

                String item2 =dirArray.get(i).get("VIR_NAME_EN");
                String item3 =dirArray.get(i).get("VIR_DATA");

                Intent intent = new Intent(Test.this,VirusData.class);

                intent.putExtra("VIR_NAME_EN",item2);
                intent.putExtra("VIR_DATA",item3);
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
    public void ClickVirus (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome
}
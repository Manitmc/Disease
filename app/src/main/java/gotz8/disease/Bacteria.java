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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Bacteria extends Activity {
    ArrayList<HashMap<String, String>> dirArray;
    SQLiteDatabase mDb;
    MyDBHelper mHelper;
    Cursor mCursor;
    Button finddis;
    EditText search_dis;
    String word_search;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bac);
        search_dis = (EditText) findViewById(R.id.bac_search);
        finddis = (Button) findViewById(R.id.bac_btn);
        ListView listViewฺBacType = (ListView)findViewById(R.id.listViewฺBacType);

        mHelper = new MyDBHelper(this);
        mDb = mHelper.getWritableDatabase();
        mHelper.onUpgrade(mDb, 1, 1);
        finddis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                word_search = search_dis.getText().toString();

            }
        });

        //mCursor = mDb.rawQuery("SELECT " + MyDBHelper.COL_NAME + ", "
        //        + MyDBHelper.COL_PIECE_PRICE + ", " + MyDBHelper.COL_CAKE_PRICE
        //        + " FROM " + MyDBHelper.TABLE_NAME, null);

        mCursor = mDb.rawQuery("SELECT  * FROM BacTable",null);
        dirArray = new ArrayList<>();


        mCursor.moveToFirst();
        while ( !mCursor.isAfterLast() ){
            HashMap<String, String> map = new HashMap<>();
            map.put("BAC_NAME_EN",mCursor.getString(mCursor.getColumnIndex("BAC_NAME_EN")));
            map.put("BAC_NAME_TH",mCursor.getString(mCursor.getColumnIndex("BAC_NAME_TH")));
            map.put("BAC_VACCINE",mCursor.getString(mCursor.getColumnIndex("BAC_VACCINE")));
            map.put("BAC_DATA",mCursor.getString(mCursor.getColumnIndex("BAC_DATA")));
            dirArray.add(map);
            mCursor.moveToNext();
        }

        final SimpleAdapter sAdap;
        sAdap = new SimpleAdapter(Bacteria.this, dirArray, R.layout.activity_list_bac
                ,new String[] {"BAC_NAME_EN", "BAC_NAME_TH", "BAC_VACCINE","BAC_DATA"}
                ,new int[] {R.id.BacNameEng, R.id.BacNameTH, R.id.BacVaccine,R.id.BACDT});
        listViewฺBacType.setAdapter(sAdap);
        listViewฺBacType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //               String item = VirusList.get(i).get("VIR_NAME_EN");

                String item2 =dirArray.get(i).get("BAC_NAME_EN");
                String item3 =dirArray.get(i).get("BAC_DATA");

                Intent intent = new Intent(Bacteria.this,BacData.class);

                intent.putExtra("BAC_NAME_EN",item2);
                intent.putExtra("BAC_DATA",item3);
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
    public void ClickBac (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome
}
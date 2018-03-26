package gotz8.disease;

/**
 * Created by Gotz8 on 10/19/2017.
 */

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;



@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /** Pegando id tabhost **/
        TabHost tabHost = findViewById(android.R.id.tabhost);

        /** กำหนดแต่ละส่วนแท็บ **/
        TabHost.TabSpec tab1 = tabHost.newTabSpec("HOME");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("AREA");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("NEWS");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("ABOUT");





        /** set tab1 **/
        tab1.setIndicator("HOME");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.ic_home));
        tab1.setContent(new Intent(this, Home.class));



        /** สset tab2 **/
        tab2.setIndicator("AREA");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.ic_area));
        tab2.setContent(new Intent(this,Map.class));


        /** set tab3 **/
        tab3.setIndicator("NEWS");
        tab3.setIndicator("", getResources().getDrawable(R.drawable.ic_news));
        tab3.setContent(new Intent(this, News.class));


        /** set tab4 **/
        tab4.setIndicator("ABOUT");
        tab4.setIndicator("", getResources().getDrawable(R.drawable.about_icon));
        tab4.setContent(new Intent(this, About.class));









        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);




        //Check Empty Databaseเช็คว่าในแอพเรามีข้อมูลมั้ยถ้าไม่มีให้ไปที่หน้าไไหนถ้ามีไปหน้าไหน เพื่อถ้าไม่มีข้อมูลจะสามารถรันได้ปกติ
        //    checkUserTABLE();

    }//OnCreate





}//MainClass
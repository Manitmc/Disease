package gotz8.disease;

/**
 * Created by Gotnpd on 3/10/2560.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class TreatmentVirus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatmentvirus);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageVirus);
        TreatmentVirusAdapter adapterView = new TreatmentVirusAdapter(this);
        mViewPager.setAdapter(adapterView);

    }
    public void ClickTreatment (View view) {
        startActivity(new Intent(getApplicationContext(), TreatmentMain.class));
    }//ClickBackHome
}

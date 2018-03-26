package gotz8.disease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Gotz8 on 3/21/2018.
 */

public class TreatmentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatmentmain);


    }
    public void ClickTreatVirus (View view) {
        startActivity(new Intent(getApplicationContext(), TreatmentVirus.class));
    }//ClickBackHome
    public void ClickTreatBac (View view) {
        startActivity(new Intent(getApplicationContext(), Treatment.class));
    }//ClickBackHome
    public void ClickTreatment (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome
}
package gotz8.disease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends Activity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
    public void ClickVirus(View view) {
        startActivity(new Intent(getApplicationContext(),Test.class));
    }//ClickVirus
    public void ClickBac(View view) {
        startActivity(new Intent(getApplicationContext(),Bacteria.class));
    }//ClickVirus

    public void ClickTreatment (View view) {
        startActivity(new Intent(getApplicationContext(),TreatmentMain.class));
    }//ClickTreatmemt
    public void ClickVac (View view) {
        startActivity(new Intent(getApplicationContext(),Vaccine.class));
    }//ClickTreatmemt

}//Oncreate

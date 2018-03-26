package gotz8.disease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gotz8 on 1/17/2018.
 */

public class VaccineData extends Activity {
    TextView tv;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_data);
        tv = findViewById(R.id.VacName);
        tv2 = findViewById(R.id.vacman);
        tv3 = findViewById(R.id.vactype);
        tv4 = findViewById(R.id.vacm1);
        Intent intent = getIntent();
        String item2 = intent.getExtras().getString("VAC_NAME");
        String item3 = intent.getExtras().getString("VAC_MANUFACTURER");
        String item4 = intent.getExtras().getString("VAC_TYPE");
        String item5 = intent.getExtras().getString("VAC_DESCRIPTION");
        tv.setText(item2);
        tv2.setText(item3);
        tv3.setText(item4);
        tv4.setText(item5);
    }
    public void ClickVacData (View view) {
        startActivity(new Intent(getApplicationContext(), Vaccine.class));
    }//ClickBackHome

}
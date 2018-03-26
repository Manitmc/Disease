package gotz8.disease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gotz8 on 1/17/2018.
 */

public class VirusData extends Activity {
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus_data);
        tv = findViewById(R.id.VirNameEng);
        tv2 = findViewById(R.id.VirDT);
        Intent intent = getIntent();
        String item2 = intent.getExtras().getString("VIR_NAME_EN");
        String item3 = intent.getExtras().getString("VIR_DATA");
        tv.setText(item2);
        tv2.setText(item3);
    }

    public void ClickVirusData (View view) {
        startActivity(new Intent(getApplicationContext(), Virus.class));
    }//ClickBackHome
}
package gotz8.disease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gotz8 on 1/17/2018.
 */

public class BacData extends Activity {
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac_data);
        tv = findViewById(R.id.BacNameEng);
        tv2 = findViewById(R.id.BACDT);
        Intent intent = getIntent();
        String item2 = intent.getExtras().getString("BAC_NAME_EN");
        String item3 = intent.getExtras().getString("BAC_DATA");
        tv.setText(item2);
        tv2.setText(item3);
    }
    public void ClickBacData (View view) {
        startActivity(new Intent(getApplicationContext(), Bacteria.class));
    }//ClickBackHome

}
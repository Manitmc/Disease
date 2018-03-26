package gotz8.disease;

/**
 * Created by Gotnpd on 30/9/2560.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class Develop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop);
    }


    public void ClickDev (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome
}
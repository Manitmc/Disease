package gotz8.disease;

/**
 * Created by Gotnpd on 2/10/2560.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gotz8.disease.model.Extension;

import static gotz8.disease.R.string.cdc;


public class Contact extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact1);
        final TextView cdc =  findViewById(R.id.textView41);


        cdc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url1 = "https://www.google.co.th/maps/search/center+for+disease+control/@33.7993178,-84.3301967,17z/data=!3m1!4b1?dcr=0";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Contact.this, R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow), "Share", Extension.createPendingShareIntent(Contact.this));
                builder.build().launchUrl(Contact.this, Uri.parse(url1));
            }
        });

    }
    public void ClickContact (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome

}
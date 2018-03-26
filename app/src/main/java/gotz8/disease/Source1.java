package gotz8.disease;

/**
 * Created by Gotz8 on 2/8/2018.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gotz8.disease.model.Extension;


/**
 * Created by Gotnpd on 1/10/2560.
 */

public class Source1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source1);


        final ImageView cdc = (ImageView) findViewById(R.id.cdcv);
        final ImageView who = (ImageView) findViewById(R.id.who1);
        final ImageView discon = (ImageView) findViewById(R.id.discon);


        cdc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url1 = "http://www.cdc.gov";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Source1.this, R.color.colorTab1));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow_s), "Share", Extension.createPendingShareIntent(Source1.this));
                builder.build().launchUrl(Source1.this, Uri.parse(url1));
            }
        });


        who.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url1 = "http://www.who.int/en/";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Source1.this,R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(),R.drawable.arrow_s),"Share", Extension.createPendingShareIntent(Source1.this));
                builder.build().launchUrl(Source1.this, Uri.parse(url1));
            }
        });

        discon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url3 = "http://www.ddc.moph.go.th/";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Source1.this,R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(),R.drawable.arrow_s),"Share", Extension.createPendingShareIntent(Source1.this));
                builder.build().launchUrl(Source1.this, Uri.parse(url3));
            }
        });
        discon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url3 = "http://www.nvi.go.th/";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Source1.this,R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(),R.drawable.arrow_s),"Share", Extension.createPendingShareIntent(Source1.this));
                builder.build().launchUrl(Source1.this, Uri.parse(url3));
            }
        });
    }





    public void ClickSource(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }//ClickBackHome

}



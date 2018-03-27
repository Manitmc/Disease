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
import android.support.v7.app.AppCompatActivity;
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

        final ImageView p2 =  findViewById(R.id.p2);
        final ImageView p3 =  findViewById(R.id.p3);
        final ImageView p4 =  findViewById(R.id.p4);
        final ImageView p5 =  findViewById(R.id.p5);


        p4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url2 = "https://www.facebook.com/CDC";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Contact.this, R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow_s), "Share", Extension.createPendingShareIntent(Contact.this));
                builder.build().launchUrl(Contact.this, Uri.parse(url2));
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url1 = "https://www.instagram.com/CDCgov/";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Contact.this, R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow_s), "Share", Extension.createPendingShareIntent(Contact.this));
                builder.build().launchUrl(Contact.this, Uri.parse(url1));
            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url3 = "https://www.youtube.com/user/CDCstreamingHealth";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Contact.this, R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow_s), "Share", Extension.createPendingShareIntent(Contact.this));
                builder.build().launchUrl(Contact.this, Uri.parse(url3));
            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url4 = "https://twitter.com/CDCgov";

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setToolbarColor(ContextCompat.getColor(Contact.this, R.color.colorPrimary));
                builder.setShowTitle(true);
                builder.setActionButton(BitmapFactory.decodeResource(getResources(), R.drawable.arrow_s), "Share", Extension.createPendingShareIntent(Contact.this));
                builder.build().launchUrl(Contact.this, Uri.parse(url4));
            }
        });


    }
    public void ClickContact (View view) {
        finish();
    }//ClickBackHome

}
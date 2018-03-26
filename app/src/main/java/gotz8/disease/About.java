package gotz8.disease;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Gotnpd on 30/9/2560.
 */

public class About extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView source = (ImageView) findViewById(R.id.source);
        source.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Source1.class));
                //Intent myintent = new Intent(About.this,Source1.class);
                //startActivity(myintent);
            }
        });
        ImageView help = (ImageView) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final AlertDialog alertDialog = new AlertDialog.Builder(About.this).create();
                alertDialog.setTitle("ขออภัย ขณะนี้ระบบยังไม่เปิดให้บริการ");
                alertDialog.setMessage("Sorry! Not available yet. ");

                alertDialog.setButton(Dialog.BUTTON_POSITIVE,"OK",new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.cancel();
                    }
                });


                alertDialog.show();  //<-- See This!
            }

        });

    }
    public void ClickDev(View view) {
        startActivity(new Intent(getApplicationContext(), Develop.class));
    }
    public void ClickContact(View view) {
        startActivity(new Intent(getApplicationContext(), Contact.class));
    }
    public void ClickSource(View view) {
        Intent myintent = new Intent(About.this,Source1.class);
        startActivity(myintent);
    }

}//Oncreate

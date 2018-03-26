package gotz8.disease;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import java.util.Locale;

/**
 * Created by Gotz8 on 3/21/2018.
 */

public class TreatmentMain extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatmentmain);

               tts = new TextToSpeech(this, this, "com.google.android.tts");;
            }

            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(new Locale("th"));
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                    speak("กรุณาเลือกเมนูที่ต้องการ");

                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }


            @Override
            protected void onDestroy() {
                if (tts != null) {
                    tts.stop();
                    tts.shutdown();
                }
                super.onDestroy();
            }

    private void speak(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }else{
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
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
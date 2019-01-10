package com.babycount.fpapp.babycount;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class CountActivity extends AppCompatActivity implements BabyCount {

    private TextToSpeech ttobj;
    private static int count = 0;
    private static int limit = 10;
    private static String strcount = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

       /* final Bundle parameter = getIntent().getExtras();

        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR && parameter != null && parameter.containsKey(LOCALE_KEY)) {

                    ttobj.setLanguage((Locale) parameter.getSerializable(LOCALE_KEY));
                }
            }
        });


        Button btn = (Button) findViewById(R.id.btnOne);
        ImageButton btnReplay = (ImageButton) findViewById(R.id.btnReplay);
        final GridView gridV = (GridView) findViewById(R.id.biberonGridview);
        final BiberonAdapter biberonAdapter = new BiberonAdapter(this);
        gridV.setAdapter(biberonAdapter);
        final TextView counter = (TextView) findViewById(R.id.lblCounter);

        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                count++;
                if(count > COUNT_LIMIT) {
                    count = 1;
                    biberonAdapter.resetBiberones();
                }
                strcount = String.valueOf(count);
                counter.setText(strcount);
                ttobj.speak(strcount, TextToSpeech.QUEUE_FLUSH, null);
                biberonAdapter.addBiberon(count);

            }

        });

        btnReplay.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                ttobj.speak(strcount, TextToSpeech.QUEUE_FLUSH, null);

            }

        });*/
    }

    @Override
    public void onResume()
    {
        count = 0;
        super.onResume();

    }
}

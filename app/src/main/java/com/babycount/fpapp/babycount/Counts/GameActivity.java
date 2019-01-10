package com.babycount.fpapp.babycount.Counts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.babycount.fpapp.babycount.R;
import com.babycount.fpapp.babycount.util.ActivityUtils;

public class GameActivity extends AppCompatActivity {

    private CountPresenter mCountPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        CountFragment countFragment =
                (CountFragment) getSupportFragmentManager().findFragmentById(R.id.countFrame);
        if (countFragment == null) {
            // Create the fragment
            countFragment = CountFragment.newInstance("","");
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), countFragment, R.id.countFrame);
        }

        // Create the presenter
        mCountPresenter = new CountPresenter(countFragment);


    }
}

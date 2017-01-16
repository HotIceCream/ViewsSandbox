package ru.hoticecream.animations.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.hoticecream.animations.R;
import ru.hoticecream.animations.fragments.FirstFragment;
import ru.hoticecream.animations.fragments.SecondFragment;


public class AnimationsActivity extends AppCompatActivity {

    private static final String TAG = "AnimationsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FirstFragment.newInstance())
                    .commit();
        }
    }

    public void onCatClicked(View sharedView, FirstFragment.CatItem item) {
        getSupportFragmentManager().beginTransaction()
                .addSharedElement(sharedView, item.name)
                .replace(R.id.container, SecondFragment.newInstance(item))
                .addToBackStack("second")
                .commit();
    }
}

package ru.hoticecream.animations.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;

import ru.hoticecream.animations.activities.AnimationsActivity;

/**
 * Created by v.kholyavin (16/01/2017)
 */

public class BaseFragment extends AppCompatDialogFragment {

    public static final String IMAGE_URL = "http://elite-british.by/wp-content/uploads/2014/12/britanskij-kotenok-zolotaja-shinshilla.jpg";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setShowsDialog(false);
    }

    public AnimationsActivity getViewParent() {
        return (AnimationsActivity) getActivity();
    }
}

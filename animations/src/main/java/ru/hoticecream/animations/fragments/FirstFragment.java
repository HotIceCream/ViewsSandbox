package ru.hoticecream.animations.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.hoticecream.animations.R;

/**
 * Created by v.kholyavin (16/01/2017)
 */

public class FirstFragment extends BaseFragment {

    @BindView(R.id.image_cat)
    ImageView imageCat;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        getViewParent().setSupportActionBar(toolbar);
        Picasso.with(getContext()).load(IMAGE_URL).into(imageCat);
        return view;
    }

    @OnClick(R.id.image_cat)
    void onCatClick() {
        getViewParent().onCatClicked();
    }

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }
}

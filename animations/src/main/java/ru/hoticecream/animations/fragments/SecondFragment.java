package ru.hoticecream.animations.fragments;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.hoticecream.animations.R;


/**
 * Created by v.kholyavin (16/01/2017)
 */

public class SecondFragment extends BaseFragment {

    private static final String KEY_ITEM = "item";
    private static final String TAG = "SecondFragment";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_cat)
    ImageView imageCat;

    @BindView(R.id.card1)
    CardView card1;
    @BindView(R.id.card2)
    CardView card2;
    @BindView(R.id.card3)
    CardView card3;

    private FirstFragment.CatItem item;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments().getParcelable(KEY_ITEM);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ButterKnife.bind(this, view);
        getViewParent().setSupportActionBar(toolbar);
        Picasso.with(getContext()).load(item.url).into(imageCat);
        ViewCompat.setTransitionName(imageCat, item.name);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate4(card1);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate2(card2);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate3(card3);
            }
        });
    }

    private void animate3(View view) {
        Animator animation = AnimatorInflater.loadAnimator(getContext(), R.animator.animation3);
        animation.setTarget(view);
        animation.start();
    }

    private void animate1(final View view) {
        view.animate()
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setRotation(0);
                    }
                })
                .setDuration(2000)
                .rotation(100)
                .start();
    }

    private void animate2(View view) {
        Animator animation = AnimatorInflater.loadAnimator(getContext(), R.animator.animation2);
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(TAG, "onAnimationRepeat");
            }
        });
        animation.setTarget(view);
        animation.start();
    }

    private void animate4(final View view) {
        ValueAnimator pathAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        final Path path = new Path();
        path.addCircle(0, 0, 100, Path.Direction.CCW);
        path.close();
        pathAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float[] point = new float[2];
            PathMeasure pathMeasure = new PathMeasure(path, true);

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float val = animation.getAnimatedFraction();
                pathMeasure.getPosTan(pathMeasure.getLength() * val, point, null);
                view.setX(point[0]);
                view.setY(point[1]);
            }
        });
        pathAnimator.setRepeatCount(ValueAnimator.INFINITE);
        pathAnimator.start();
    }

    public static SecondFragment newInstance(FirstFragment.CatItem item) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_ITEM, item);
        fragment.setArguments(bundle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(new DetailsTransition());
            fragment.setEnterTransition(new Fade());
            fragment.setExitTransition(new Fade());
            fragment.setSharedElementReturnTransition(new DetailsTransition());
        }
        return fragment;
    }

    public static class DetailsTransition extends TransitionSet {
        public DetailsTransition() {
            setOrdering(ORDERING_TOGETHER);
            addTransition(new ChangeBounds()).
                    addTransition(new ChangeTransform()).
                    addTransition(new ChangeImageTransform());
        }
    }
}

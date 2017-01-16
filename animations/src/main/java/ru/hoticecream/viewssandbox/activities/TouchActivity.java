package ru.hoticecream.viewssandbox.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import ru.hoticecream.viewssandbox.R;

public class TouchActivity extends AppCompatActivity {

    private static final String TAG = "TouchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        findViewById(R.id.layout_1).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Layout 1, Action DOWN");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.d(TAG, "Layout 1, Action CANCEL");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "Layout 1, Action UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "Layout 1, Action MOVE");
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        Log.d(TAG, "Layout 1, Action OUTSIDE");
                        break;
                }
                return true;
            }
        });
        findViewById(R.id.layout_2).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Layout 2, Action DOWN");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.d(TAG, "Layout 2, Action CANCEL");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "Layout 2, Action UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "Layout 2, Action MOVE");
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        Log.d(TAG, "Layout 2, Action OUTSIDE");
                        break;
                }
                return true;
            }
        });
        findViewById(R.id.layout_3).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(TAG, "Layout 3, Action DOWN");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.d(TAG, "Layout 3, Action CANCEL");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(TAG, "Layout 3, Action UP");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d(TAG, "Layout 3, Action MOVE");
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        Log.d(TAG, "Layout 3, Action OUTSIDE");
                        break;
                }
                return false;
            }
        });
        FrameLayout layout1 = (FrameLayout) findViewById(R.id.layout_1);
        FrameLayout layout2 = (FrameLayout) findViewById(R.id.layout_2);
        FrameLayout layout3 = (FrameLayout) findViewById(R.id.layout_3);
        layout1.requestDisallowInterceptTouchEvent(true);
        layout2.requestDisallowInterceptTouchEvent(true);
        layout3.requestDisallowInterceptTouchEvent(true);
    }
}

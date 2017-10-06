package com.popland.pop.mayjorsystemcollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutDemo extends AppCompatActivity {
GridLayout gridLayout;
    Button btnShow;
    int TouchSlop;// = 12 on SS Galaxy S2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_demo);
        ViewConfiguration vc = ViewConfiguration.get(this);
        TouchSlop = vc.getScaledTouchSlop();
        gridLayout = (GridLayout) findViewById(R.id.activity_grid_layout_demo);
        btnShow = (Button)findViewById(R.id.btnShow);
        gridLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {//RawX = X
                btnShow.setText("X:"+event.getX()+"| Y:"+event.getX());// get a Touch's coordinates
                Log.d("TouchSlop:",TouchSlop+"");
                return false;
            }
        });
    }
}

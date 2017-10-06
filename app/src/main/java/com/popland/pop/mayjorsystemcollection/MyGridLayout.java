package com.popland.pop.mayjorsystemcollection;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.GridLayout;

/**
 * Created by hai on 04/05/2017.
 */

public class MyGridLayout extends GridLayout {// in XML custom Layout must be called with absolute path
    Boolean isBeingDragged = false;
    float LastX, LastY,StartY;
    int TouchSlop;
// must implement at least 3 constructor
    public MyGridLayout(Context context) {
        super(context);
    }

    public MyGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override // dispatch TouchEvent to parent instead of childView
    public boolean onInterceptTouchEvent(MotionEvent ev) {// MotionEvent include actionCode, Axis values, pointers(index, id, coordinates)
        ViewConfiguration vc = ViewConfiguration.get(getContext());
        TouchSlop = vc.getScaledTouchSlop();// threshold to determine user wanna scroll
        final int action = ev.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                LastX = ev.getX();// get coordinates of press pointer
                LastY = ev.getY();
                Log.d("LastX - LastY ",LastX+" - "+LastY);
                StartY = LastY;
                Log.d("StartY down:",StartY+"");
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                isBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:// when scrolling, axis system does not change.
               float x = ev.getX();
               float y = ev.getY();
                Log.d("x - y:",x+" - "+y);
                float xDelta = Math.abs(x - LastX);
                float yDelta = Math.abs(y - LastY);
                 Log.d("xDelta - yDelta: ",xDelta+" - "+yDelta);
                float yDeltaTotal = y - StartY;
                Log.d("yDeltaTotal: ",yDeltaTotal+"");
                if( yDelta>xDelta && Math.abs(yDeltaTotal)>TouchSlop){
                    isBeingDragged = true;
                    StartY = y;
                    Log.d("StartY move:",StartY+"");
                    return true;// pass on parent's onTouchEvent
                }
//                else
//                    return false; can't return TouchEvent to StackView
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        final int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                isBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                Log.d("LastX move - LastY move",LastX+" - "+LastY);
                 float xDelta = Math.abs(x - LastX);
                 float yDelta = Math.abs(y - LastY);

                 float yDeltaTotal = y - StartY;
                if ( !isBeingDragged && yDelta > xDelta && Math.abs(yDeltaTotal) > TouchSlop) {
                    isBeingDragged = true;
                    StartY = y;
                    yDeltaTotal = 0;
                }
                if (yDeltaTotal < 0)
                    yDeltaTotal = 0;

                if (isBeingDragged) {
                    scrollTo(0, (int)yDeltaTotal);
                }

                LastX = x;
                LastY = y;
                break;
        }

        return true;// must be true to handle TouchEvent

    }
}

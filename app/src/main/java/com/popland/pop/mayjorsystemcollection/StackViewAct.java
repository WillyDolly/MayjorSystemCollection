package com.popland.pop.mayjorsystemcollection;

import android.content.Context;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StackViewAct extends AppCompatActivity {
StackView stackView0, stackView00,stackView10,stackView20,stackView30,
    stackView40,stackView50,stackView60,stackView70,stackView80,stackView90;
GridLayout gridLayout;
float LastX, LastY,StartY;
    Boolean isBeingDragged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        anhXa();
        // create Msystem from basic Array letters
        ArrayList<DoiTuong> Msystem = new ArrayList<>();
        String[] letters = getResources().getStringArray(R.array.Letters);
        String[][] id = new String[11][10];
        String[][] keyword = new String[11][10];
        for(int r=0;r<11;r++){
            for(int c=0;c<10;c++){
                if(r==0){
                    id[r][c] = String.valueOf(c);
                    keyword[r][c] = letters[c];
                }else{
                    id[r][c] = String.valueOf(r-1)+c;
                    keyword[r][c] = letters[r-1]+"   "+letters[c];
                }
            }
        }

        for(int r=0;r<11;r++) {
            for (int c = 0; c < 10; c++) {
                 Msystem.add(new DoiTuong(id[r][c],keyword[r][c],R.mipmap.ic_launcher));
            }
        }
        stackView0.setAdapter(new StackViewAdapter(Msystem.subList(0,10),this));
        stackView00.setAdapter(new StackViewAdapter(Msystem.subList(10,20),this));
        stackView10.setAdapter(new StackViewAdapter(Msystem.subList(20,30),this));
        stackView20.setAdapter(new StackViewAdapter(Msystem.subList(30,40),this));
        stackView30.setAdapter(new StackViewAdapter(Msystem.subList(40,50),this));
        stackView40.setAdapter(new StackViewAdapter(Msystem.subList(50,60),this));
        stackView50.setAdapter(new StackViewAdapter(Msystem.subList(60,70),this));
        stackView60.setAdapter(new StackViewAdapter(Msystem.subList(70,80),this));
        stackView70.setAdapter(new StackViewAdapter(Msystem.subList(80,90),this));
        stackView80.setAdapter(new StackViewAdapter(Msystem.subList(90,100),this));
        stackView90.setAdapter(new StackViewAdapter(Msystem.subList(100,110),this));
//algorithm to scroll GridLayout which contains scrollable StackView
        //press down, hold, scroll up & down
        for(int i=0;i<gridLayout.getChildCount();i++){
            StackView sv = (StackView)gridLayout.getChildAt(i);
            sv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ViewConfiguration vc = ViewConfiguration.get(StackViewAct.this);
                    int TouchSlop = vc.getScaledTouchSlop();
                    int action = event.getAction();
                    switch (action){
                        case MotionEvent.ACTION_DOWN:
                            LastX = event.getRawX();// get coordinates in pixels
                            LastY = event.getRawY();// getY return pointer's index
                           Log.d("LastX - LastY ",LastX+" - "+LastY);
                            StartY = LastY;
                            Log.d("StartY down:",StartY+"");
                            break;
                        case MotionEvent.ACTION_CANCEL:// when release touch
                        case MotionEvent.ACTION_UP:
                            isBeingDragged = false;
                            Log.d("isBeingDraggedUp: ",isBeingDragged+"");
                            break;
                        case MotionEvent.ACTION_MOVE:// when scrolling, axis system does not change.
                            float x = event.getRawX();// get RawX during scroll
                            float y = event.getRawY();
                            Log.d("x - y:",x+" - "+y);
                            Log.d("LastX - LastY ",LastX+" - "+LastY);
                            float xDelta = Math.abs(x - LastX);// compare xDelta, yDelta to identify horizontal/ vertical
                            float yDelta = Math.abs(y - LastY);
                            Log.d("xDelta - yDelta: ",xDelta+" - "+yDelta);
                            float yDeltaTotal = y - StartY;// coordinates to scrollTo & pointer's length
                            Log.d("yDeltaTotal1: ",yDeltaTotal+"");
                            Log.d("isBeingDraggedMove: ",isBeingDragged+"");

                            // isBeingDragged false at first, then true during scroll
                            if( !isBeingDragged && yDelta>xDelta && Math.abs(yDeltaTotal)>150) {//first 150 scroll
                                isBeingDragged = true;
                               // StartY = y;
                              Log.d("StartY move:", StartY + "");
                                yDeltaTotal = 0;
                            }//start to scroll even Math.abs(yDeltaTotal) < 150
                            // scroll when GridLayout at bottom, it will start from top

                            if(yDeltaTotal<0)// as scroll up
                                yDeltaTotal = 0;
//                            if(yDeltaTotal > gridLayout.getBottom()) {
//                                yDeltaTotal = gridLayout.getBottom();
//                               Log.d("getBottom",gridLayout.getBottom()+"");
//                            }

                            if(isBeingDragged) {//after 150 scroll, skip 1st if to implement this if
                                Log.d("yDeltaTotalRoll: ", yDeltaTotal + "");
                                gridLayout.scrollTo(0, (int) yDeltaTotal);
                            }
                            LastX = x;// LastX, LastY updates new x,y
                            LastY = y;
                    }
                    return false;
                }
            });
        }
    }

    public void anhXa(){
        stackView0 = (StackView)findViewById(R.id.stackView0);
        stackView00 = (StackView)findViewById(R.id.stackView00);
        stackView10 = (StackView)findViewById(R.id.stackView10);
        stackView20 = (StackView)findViewById(R.id.stackView20);
        stackView30 = (StackView)findViewById(R.id.stackView30);
        stackView40 = (StackView)findViewById(R.id.stackView40);
        stackView50 = (StackView)findViewById(R.id.stackView50);
        stackView60 = (StackView)findViewById(R.id.stackView60);
        stackView70 = (StackView)findViewById(R.id.stackView70);
        stackView80 = (StackView)findViewById(R.id.stackView80);
        stackView90 = (StackView)findViewById(R.id.stackView90);

        gridLayout = (GridLayout) findViewById(R.id.activity_stack_view);
    }

    private class StackViewAdapter extends BaseAdapter{
        List<DoiTuong> pics;// ArrayList implements List
        Context context;

        StackViewAdapter(List<DoiTuong> pics, Context context){
            this.pics = pics;
            this.context = context;
        }
        @Override
        public int getCount() {
            return pics.size();
        }

        @Override
        public DoiTuong getItem(int position) {
            return pics.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
class ViewHolder{
    ImageView iv;
    TextView tv;
}
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           ViewHolder viewHolder = null;
            LayoutInflater inflater = null;
            if(convertView == null){
                inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               convertView = inflater.inflate(R.layout.stackview_custom,null);
                viewHolder = new ViewHolder();
                viewHolder.iv = (ImageView)convertView.findViewById(R.id.ivAnh);
                viewHolder.tv = (TextView)convertView.findViewById(R.id.tvTitle);
                convertView.setTag(viewHolder);
            }
            ViewHolder v = (ViewHolder)convertView.getTag();
            DoiTuong p = getItem(position);
            if(p!=null) {
                v.tv.setText(p.id+"."+p.keyword);
                v.iv.setImageResource(p.illustration);
            }
            return convertView;
        }
    }
}
//C:\Users\hai\AppData\Local\Android\sdk1\platform-tools
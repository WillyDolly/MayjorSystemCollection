package com.popland.pop.mayjorsystemcollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.List;

public class StackInHorizontalScroll extends AppCompatActivity {
    StackView stackView0, stackView00,stackView10,stackView20,stackView30,
            stackView40,stackView50,stackView60,stackView70,stackView80,stackView90;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_in_horizontal_scroll);
        anhXa();
        ArrayList<Integer> anh = new ArrayList<>();
        for(int i=0;i<110;i++)
            anh.add(R.mipmap.ic_launcher);

        stackView0.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(0,10)));
        stackView00.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(10,20)));
        stackView10.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(20,30)));
        stackView20.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(30,40)));
        stackView30.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(40,50)));
        stackView40.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(50,60)));
        stackView50.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(60,70)));
        stackView60.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(70,80)));
        stackView70.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(80,90)));
        stackView80.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(90,100)));
        stackView90.setAdapter(new StackInHorizontalScroll.StackViewAdapter(anh.subList(100,110)));
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
    }

     class StackViewAdapter extends BaseAdapter{
         List<Integer> anh;
         StackViewAdapter(List<Integer> anh){
             this.anh = anh;
         }
         @Override
         public int getCount() {
             return anh.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
              View v = getLayoutInflater().inflate(R.layout.stackview_image,parent,false);//3rd attachToRoot must false
             ImageView IV  = (ImageView)v.findViewById(R.id.iv);
             IV.setImageResource(anh.get(position));
             return v;
         }
     }
}

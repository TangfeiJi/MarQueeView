package com.example.administrator.marqueeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MarqueeView marquee_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marquee_view=findViewById(R.id.marquee_view);
        initScrollView();
    }
    private void initScrollView() {
        List<Integer> imgList=new ArrayList<>();
        imgList.add(R.mipmap.touxiang1);
        imgList.add(R.mipmap.touxiang2);
        imgList.add(R.mipmap.touxiang3);
        imgList.add(R.mipmap.touxiang4);
        imgList.add(R.mipmap.touxiang5);
        imgList.add(R.mipmap.touxiang6);

        for (int i = 0; i < imgList.size(); i++) {
            View view = View.inflate(MainActivity.this, R.layout.item_horscrollview, null);
            ImageView img_img = (ImageView) view.findViewById(R.id.img_img);
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText("用户"+ComUtils.getTel()+"已开通黄金会员");
            img_img.setImageResource(imgList.get(i));
            marquee_view.addViewInQueue(view);
        }
        marquee_view.setScrollSpeed(8);
        marquee_view.setScrollDirection(MarqueeView.RIGHT_TO_LEFT);
        marquee_view.setViewMargin(15);
        marquee_view.startScroll();
    }
}

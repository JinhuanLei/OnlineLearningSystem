package com.example.administrator.testui7.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.testui7.R;

import cn.bmob.v3.BmobUser;

public class UserinfoActivity extends AppCompatActivity {
    private String mUrl;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mIvUser;
    private TextView mTvTitle;
    private TextView mTvMsg;
    private TextView mTvRating;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        //设置Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//决定左上角的图标是否可以点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//决定左上角图标的右侧是否有向左的小箭头
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mIvUser = (ImageView) findViewById(R.id.iv_user);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);
        mTvRating = (TextView) findViewById(R.id.tv_rating);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("收藏"));
        mTabLayout.addTab(mTabLayout.newTab().setText("购买"));

        mTvMsg.setText("我的信息");
        mTvRating.setText("123");
        mTvTitle.setText("aha");

        mIvUser.setImageResource(R.drawable.user1);
        mCollapsingToolbarLayout.setTitleEnabled(false);

    }
}

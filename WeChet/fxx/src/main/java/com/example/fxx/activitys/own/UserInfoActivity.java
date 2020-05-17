package com.example.fxx.activitys.own;

import android.widget.Toast;

import com.example.fxx.base.BaseActivity;
import com.example.fxx.R;
import com.example.fxx.interfaces.IBasePersenter;

public class UserInfoActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String uid = getIntent().getStringExtra("uid"); //打开用户信息页面传入用户的uid
        Toast.makeText(this,"接收到的用户uid："+uid,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }
}

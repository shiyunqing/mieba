package com.example.fxx.persenters.login;


import com.example.fxx.base.BasePersenter;
import com.example.fxx.common.CommonSubscriber;
import com.example.fxx.interfaces.login.LoginConstract;
import com.example.fxx.module.HttpManager;
import com.example.fxx.module.bean.UserInfoBean;
import com.example.fxx.utils.RxUtils;

public class LoginPersenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Persenter {
    @Override
    public void login(String username, String password) {
        addSubscribe(HttpManager.getInstance().getChatApi().login(username,password)
        .compose(RxUtils.<UserInfoBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<UserInfoBean>(mView) {
            @Override
            public void onNext(UserInfoBean userInfoBean) {
                mView.loginReturn(userInfoBean);
            }
        }));
    }
}

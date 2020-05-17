package com.example.fxx.interfaces.login;


import com.example.fxx.interfaces.IBasePersenter;
import com.example.fxx.interfaces.IBaseView;
import com.example.fxx.module.bean.UserInfoBean;

public interface LoginConstract {

    interface View extends IBaseView {
        void loginReturn(UserInfoBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void login(String username, String password);
    }

}

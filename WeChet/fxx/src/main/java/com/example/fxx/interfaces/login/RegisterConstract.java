package com.example.fxx.interfaces.login;

import com.example.fxx.interfaces.IBasePersenter;
import com.example.fxx.interfaces.IBaseView;

public interface RegisterConstract {

    interface View extends IBaseView {
        //void getVerifyReturn(VerifyBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getVerify();
    }

}

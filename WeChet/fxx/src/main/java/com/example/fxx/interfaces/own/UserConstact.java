package com.example.fxx.interfaces.own;

import com.example.fxx.interfaces.IBasePersenter;
import com.example.fxx.interfaces.IBaseView;
import com.example.fxx.module.bean.DetailsUpdateBean;
import com.example.fxx.module.bean.UserDetailsBean;

import java.util.Map;

public interface UserConstact {

    interface DetailsView extends IBaseView{
        void getDetailsReturn(UserDetailsBean result);

        //更新用户详情信息的返回
        void updateDetailsReturn(DetailsUpdateBean result);
    }

    interface DetailsPersenter extends IBasePersenter<DetailsView>{
        void getDetails();

        //更新用户信息
        void updateDetails(Map<String, String> map);
    }

}

package com.example.fxx.persenters.own;

import com.example.fxx.base.BasePersenter;
import com.example.fxx.common.CommonSubscriber;
import com.example.fxx.interfaces.own.UserConstact;
import com.example.fxx.module.HttpManager;
import com.example.fxx.module.bean.DetailsUpdateBean;
import com.example.fxx.module.bean.UserDetailsBean;
import com.example.fxx.module.bean.UserInfoBean;
import com.example.fxx.utils.RxUtils;

import java.util.Map;

public class DetailsPersenter extends BasePersenter<UserConstact.DetailsView> implements UserConstact.DetailsPersenter {
    @Override
    public void getDetails() {
        addSubscribe(HttpManager.getInstance().getChatApi().getUserDetails()
                .compose(RxUtils.<UserDetailsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserDetailsBean>(mView) {
                    @Override
                    public void onNext(UserDetailsBean result) {
                        mView.getDetailsReturn(result);
                    }
                }));
    }

    /**
     * 更新用户信息
     * @param map
     */
    @Override
    public void updateDetails(Map<String, String> map) {
        addSubscribe(HttpManager.getInstance().getChatApi().updateUserDetails(map)
                .compose(RxUtils.<DetailsUpdateBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<DetailsUpdateBean>(mView) {
                    @Override
                    public void onNext(DetailsUpdateBean result) {
                        mView.updateDetailsReturn(result);
                    }
                }));
    }
}

package com.example.fxx.persenters.trends;

import com.example.fxx.base.BasePersenter;
import com.example.fxx.common.CommonSubscriber;
import com.example.fxx.interfaces.trends.TrendsStract;
import com.example.fxx.module.HttpManager;
import com.example.fxx.module.bean.PublishTrendsBean;
import com.example.fxx.module.bean.UserDetailsBean;
import com.example.fxx.utils.RxUtils;

public class TrendsPersenter extends BasePersenter<TrendsStract.View> implements TrendsStract.Persenter {
    @Override
    public void sendTrends(String content, String resources) {
        addSubscribe(HttpManager.getInstance().getChatApi().sendTrends(content,resources)
                .compose(RxUtils.<PublishTrendsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<PublishTrendsBean>(mView) {
                    @Override
                    public void onNext(PublishTrendsBean result) {
                        mView.sendTrendsReturn(result);
                    }
                }));
    }
}

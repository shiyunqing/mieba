package com.example.fxx.persenters.trends;

import com.example.fxx.base.BasePersenter;
import com.example.fxx.common.CommonSubscriber;
import com.example.fxx.interfaces.trends.TrendsStract;
import com.example.fxx.interfaces.trends.TrendsStract.TrendsListPersenter;
import com.example.fxx.module.HttpManager;
import com.example.fxx.module.bean.PublishTrendsBean;
import com.example.fxx.module.bean.ReplyBean;
import com.example.fxx.module.bean.TrendsBean;
import com.example.fxx.utils.RxUtils;

/**
 * 获取动态列表的操作
 */
public class TrendsPagerPersenter extends BasePersenter<TrendsStract.TrendsListView> implements TrendsListPersenter {

    @Override
    public void queryTrends(int page, int size, int trendsid) {
        addSubscribe(HttpManager.getInstance().getChatApi().queryTrends(page,size,trendsid)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<TrendsBean>(mView) {
                    @Override
                    public void onNext(TrendsBean result) {
                        mView.queryTrendsReturn(result);
                    }
                }));
    }

    /**
     * 回复接口
     * @param trendsid
     * @param discussid
     * @param targettype
     * @param targetuid
     * @param content
     */
    @Override
    public void sendReply(int trendsid, int discussid, int targettype, String targetuid, String content) {
        addSubscribe(HttpManager.getInstance().getChatApi().sendReply(trendsid,discussid,targettype,targetuid,content)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ReplyBean>(mView) {
                    @Override
                    public void onNext(ReplyBean result) {
                        mView.sendReplyReturn(result);
                    }
                }));
    }

}

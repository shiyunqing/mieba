package com.example.fxx.interfaces.trends;

import com.example.fxx.interfaces.IBasePersenter;
import com.example.fxx.interfaces.IBaseView;
import com.example.fxx.module.bean.PublishTrendsBean;
import com.example.fxx.module.bean.ReplyBean;
import com.example.fxx.module.bean.TrendsBean;

/**
 * 动态的契约类
 */
public interface TrendsStract {

    //发布动态的view层接口
    interface View extends IBaseView{
        //发布动态返回的接口
        void sendTrendsReturn(PublishTrendsBean result);
    }

    //发布动态的P层接口
    interface Persenter extends IBasePersenter<View>{
        //发布动态的接口
        void sendTrends(String content,String resources);
    }

    //动态列表的view层
    interface TrendsListView extends IBaseView{
        void queryTrendsReturn(TrendsBean trendsBean);

        void sendReplyReturn(ReplyBean replyBean);
    }

    //动态类别的p层
    interface TrendsListPersenter extends IBasePersenter<TrendsListView>{
        void queryTrends(int page,int size,int trendsid);

        /**
         * 回复数据的接口
         * @param trendsid
         * @param discussid
         * @param targettype
         * @param targetuid
         * @param content
         */
        void sendReply(int trendsid,int discussid,int targettype,String targetuid,String content);
    }

}

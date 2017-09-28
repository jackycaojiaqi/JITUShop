package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/28.
 */
public class MessageEntity extends BasePaserEntity {


    /**
     * Result : [{"CM_Content":"大青蛙多多群无多群","CM_CreateTime":"2017-08-20T00:00:00","CM_Title":"我问问分为","CM_Type":0,"CM_IsCheck":0,"CM_NoticeId":1}]
     * Count : 1
     */

    private int Count;
    private List<ResultBean> Result;

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public List<ResultBean> getResult() {
        return Result;
    }

    public void setResult(List<ResultBean> Result) {
        this.Result = Result;
    }

    public static class ResultBean {
        /**
         * CM_Content : 大青蛙多多群无多群
         * CM_CreateTime : 2017-08-20T00:00:00
         * CM_Title : 我问问分为
         * CM_Type : 0
         * CM_IsCheck : 0
         * CM_NoticeId : 1
         */

        private String CM_Content;
        private String CM_CreateTime;
        private String CM_Title;
        private int CM_Type;
        private int CM_IsCheck;
        private int CM_NoticeId;

        public String getCM_Content() {
            return CM_Content;
        }

        public void setCM_Content(String CM_Content) {
            this.CM_Content = CM_Content;
        }

        public String getCM_CreateTime() {
            return CM_CreateTime;
        }

        public void setCM_CreateTime(String CM_CreateTime) {
            this.CM_CreateTime = CM_CreateTime;
        }

        public String getCM_Title() {
            return CM_Title;
        }

        public void setCM_Title(String CM_Title) {
            this.CM_Title = CM_Title;
        }

        public int getCM_Type() {
            return CM_Type;
        }

        public void setCM_Type(int CM_Type) {
            this.CM_Type = CM_Type;
        }

        public int getCM_IsCheck() {
            return CM_IsCheck;
        }

        public void setCM_IsCheck(int CM_IsCheck) {
            this.CM_IsCheck = CM_IsCheck;
        }

        public int getCM_NoticeId() {
            return CM_NoticeId;
        }

        public void setCM_NoticeId(int CM_NoticeId) {
            this.CM_NoticeId = CM_NoticeId;
        }
    }
}

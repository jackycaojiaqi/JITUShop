package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/8/28.
 */
public class MainMenuEntity {


    /**
     * ErrorCode : 0
     * Token : null
     * Result : {"Table":[{"CM_MenuId":1,"CM_MenuName":"订单管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0},{"CM_MenuId":2,"CM_MenuName":"商品管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0},{"CM_MenuId":3,"CM_MenuName":"提现管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0},{"CM_MenuId":4,"CM_MenuName":"商家管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0},{"CM_MenuId":5,"CM_MenuName":"消息","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0},{"CM_MenuId":6,"CM_MenuName":"设置","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0}]}
     * Count : 0
     */

    private int ErrorCode;
    private Object Token;
    private ResultBean Result;
    private int Count;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public Object getToken() {
        return Token;
    }

    public void setToken(Object Token) {
        this.Token = Token;
    }

    public ResultBean getResult() {
        return Result;
    }

    public void setResult(ResultBean Result) {
        this.Result = Result;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public static class ResultBean {
        private List<TableBean> Table;

        public List<TableBean> getTable() {
            return Table;
        }

        public void setTable(List<TableBean> Table) {
            this.Table = Table;
        }

        public static class TableBean {
            /**
             * CM_MenuId : 1
             * CM_MenuName : 订单管理
             * CM_ImgPath :
             * CM_Url :
             * CM_Type : 0
             * CM_State : 0
             */

            private int CM_MenuId;
            private String CM_MenuName;
            private String CM_ImgPath;
            private String CM_Url;
            private int CM_Type;
            private int CM_State;
            private boolean is_show_spot = false;


            public boolean is_show_spot() {
                return is_show_spot;
            }

            public void setIs_show_spot(boolean is_show_spot) {
                this.is_show_spot = is_show_spot;
            }

            public int getCM_MenuId() {
                return CM_MenuId;
            }

            public void setCM_MenuId(int CM_MenuId) {
                this.CM_MenuId = CM_MenuId;
            }

            public String getCM_MenuName() {
                return CM_MenuName;
            }

            public void setCM_MenuName(String CM_MenuName) {
                this.CM_MenuName = CM_MenuName;
            }

            public String getCM_ImgPath() {
                return CM_ImgPath;
            }

            public void setCM_ImgPath(String CM_ImgPath) {
                this.CM_ImgPath = CM_ImgPath;
            }

            public String getCM_Url() {
                return CM_Url;
            }

            public void setCM_Url(String CM_Url) {
                this.CM_Url = CM_Url;
            }

            public int getCM_Type() {
                return CM_Type;
            }

            public void setCM_Type(int CM_Type) {
                this.CM_Type = CM_Type;
            }

            public int getCM_State() {
                return CM_State;
            }

            public void setCM_State(int CM_State) {
                this.CM_State = CM_State;
            }
        }
    }
}

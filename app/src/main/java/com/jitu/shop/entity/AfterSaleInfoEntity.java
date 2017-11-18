package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/11/16.
 */
public class AfterSaleInfoEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : {"CM_Type":2,"CM_State":0,"CM_ServiceId":"2017111611294885","CM_Reason":"... 铃铃铃","CM_Json":"{\"typename\":\"买家申请退货退款\",\"time\":\"2017-11-16 11:29:28\",\"handlers\":0,\"remark\":null}","CM_ImgPath":"C://ServiceImg/17111611282983835/0.jpeg|C://ServiceImg/17111611282983835/1.jpeg|C://ServiceImg/17111611282983835/2.jpeg|","CM_CreateTime":"2017-11-16T11:28:29.837","CM_Count":null,"CM_OrderDetailsId":0,"CM_OrderId":"17111611101183320","Addr":"浙江台州市椒江区浙江省台州市啦啦啦","consignee":"阿强伯","phone":"13777185820","amount":28,"CM_SendMoney":11}
     * Count : 0
     */

    private ResultBean Result;
    private int Count;

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
        /**
         * CM_Type : 2
         * CM_State : 0
         * CM_ServiceId : 2017111611294885
         * CM_Reason : ... 铃铃铃
         * CM_Json : {"typename":"买家申请退货退款","time":"2017-11-16 11:29:28","handlers":0,"remark":null}
         * CM_ImgPath : C://ServiceImg/17111611282983835/0.jpeg|C://ServiceImg/17111611282983835/1.jpeg|C://ServiceImg/17111611282983835/2.jpeg|
         * CM_CreateTime : 2017-11-16T11:28:29.837
         * CM_Count : null
         * CM_OrderDetailsId : 0
         * CM_OrderId : 17111611101183320
         * Addr : 浙江台州市椒江区浙江省台州市啦啦啦
         * consignee : 阿强伯
         * phone : 13777185820
         * amount : 28
         * CM_SendMoney : 11
         */

        private int CM_Type;
        private int CM_State;
        private String CM_ServiceId;
        private String CM_Reason;
        private String CM_Json;
        private String CM_ImgPath;
        private String CM_CreateTime;
        private Object CM_Count;
        private int CM_OrderDetailsId;
        private String CM_OrderId;
        private String Addr;
        private String consignee;
        private String phone;
        private String amount;
        private String CM_SendMoney;
        private int CM_CirculationState;

        public int getCM_CirculationState() {
            return CM_CirculationState;
        }

        public void setCM_CirculationState(int CM_CirculationState) {
            this.CM_CirculationState = CM_CirculationState;
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

        public String getCM_ServiceId() {
            return CM_ServiceId;
        }

        public void setCM_ServiceId(String CM_ServiceId) {
            this.CM_ServiceId = CM_ServiceId;
        }

        public String getCM_Reason() {
            return CM_Reason;
        }

        public void setCM_Reason(String CM_Reason) {
            this.CM_Reason = CM_Reason;
        }

        public String getCM_Json() {
            return CM_Json;
        }

        public void setCM_Json(String CM_Json) {
            this.CM_Json = CM_Json;
        }

        public String getCM_ImgPath() {
            return CM_ImgPath;
        }

        public void setCM_ImgPath(String CM_ImgPath) {
            this.CM_ImgPath = CM_ImgPath;
        }

        public String getCM_CreateTime() {
            return CM_CreateTime;
        }

        public void setCM_CreateTime(String CM_CreateTime) {
            this.CM_CreateTime = CM_CreateTime;
        }

        public Object getCM_Count() {
            return CM_Count;
        }

        public void setCM_Count(Object CM_Count) {
            this.CM_Count = CM_Count;
        }

        public int getCM_OrderDetailsId() {
            return CM_OrderDetailsId;
        }

        public void setCM_OrderDetailsId(int CM_OrderDetailsId) {
            this.CM_OrderDetailsId = CM_OrderDetailsId;
        }

        public String getCM_OrderId() {
            return CM_OrderId;
        }

        public void setCM_OrderId(String CM_OrderId) {
            this.CM_OrderId = CM_OrderId;
        }

        public String getAddr() {
            return Addr;
        }

        public void setAddr(String Addr) {
            this.Addr = Addr;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCM_SendMoney() {
            return CM_SendMoney;
        }

        public void setCM_SendMoney(String CM_SendMoney) {
            this.CM_SendMoney = CM_SendMoney;
        }
    }
}

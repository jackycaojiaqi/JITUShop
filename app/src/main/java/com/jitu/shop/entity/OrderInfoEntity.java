package com.jitu.shop.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacky on 2017/9/1.
 */
public class OrderInfoEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : {"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002001","States":33,"consignee":"","amount":25600,"memNote":"是的范德萨","Addr":"SDFDSF","phone":"","TB_OrderDetails":[{"number":10,"pcice":null,"pname":"是的范德萨","skuUserName":"发都是附近的时刻令肌肤","states":1,"ProductName":null,"pCode":null,"mainImg":null},{"number":5,"pcice":null,"pname":"水电费发生过","skuUserName":"多少分五个色鬼公司范德萨","states":1,"ProductName":null,"pCode":null,"mainImg":null}]}
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
         * CreatTime : 2017-02-25T00:00:00
         * OrderCode : 33100201703221552002001
         * States : 33
         * consignee :
         * amount : 25600
         * memNote : 是的范德萨
         * Addr : SDFDSF
         * phone :
         * TB_OrderDetails : [{"number":10,"pcice":null,"pname":"是的范德萨","skuUserName":"发都是附近的时刻令肌肤","states":1,"ProductName":null,"pCode":null,"mainImg":null},{"number":5,"pcice":null,"pname":"水电费发生过","skuUserName":"多少分五个色鬼公司范德萨","states":1,"ProductName":null,"pCode":null,"mainImg":null}]
         */

        private String CreatTime;
        private String OrderCode;
        private int States;
        private String consignee;
        private int amount;
        private String memNote;
        private String Addr;
        private String phone;
        private List<TBOrderDetailsBean> TB_OrderDetails;

        public String getCreatTime() {
            return CreatTime;
        }

        public void setCreatTime(String CreatTime) {
            this.CreatTime = CreatTime;
        }

        public String getOrderCode() {
            return OrderCode;
        }

        public void setOrderCode(String OrderCode) {
            this.OrderCode = OrderCode;
        }

        public int getStates() {
            return States;
        }

        public void setStates(int States) {
            this.States = States;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getMemNote() {
            return memNote;
        }

        public void setMemNote(String memNote) {
            this.memNote = memNote;
        }

        public String getAddr() {
            return Addr;
        }

        public void setAddr(String Addr) {
            this.Addr = Addr;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<TBOrderDetailsBean> getTB_OrderDetails() {
            return TB_OrderDetails;
        }

        public void setTB_OrderDetails(List<TBOrderDetailsBean> TB_OrderDetails) {
            this.TB_OrderDetails = TB_OrderDetails;
        }

        public static class TBOrderDetailsBean {
            /**
             * number : 10
             * pcice : null
             * pname : 是的范德萨
             * skuUserName : 发都是附近的时刻令肌肤
             * states : 1
             * ProductName : null
             * pCode : null
             * mainImg : null
             */

            private int number;
            private String pcice;
            private String pname;
            private String skuUserName;
            private int states;
            private String ProductName;
            private String pCode;
            private String mainImg;

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getPcice() {
                return pcice;
            }

            public void setPcice(String pcice) {
                this.pcice = pcice;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public String getSkuUserName() {
                return skuUserName;
            }

            public void setSkuUserName(String skuUserName) {
                this.skuUserName = skuUserName;
            }

            public int getStates() {
                return states;
            }

            public void setStates(int states) {
                this.states = states;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public String getPCode() {
                return pCode;
            }

            public void setPCode(String pCode) {
                this.pCode = pCode;
            }

            public String getMainImg() {
                return mainImg;
            }

            public void setMainImg(String mainImg) {
                this.mainImg = mainImg;
            }
        }
    }
}

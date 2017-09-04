package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/8/30.
 */
public class OrderListEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002001","States":33,"consignee":"","amount":25600,"TB_List":[{"number":10,"states":1,"price":0,"sales":88.89,"SKuONname":null,"skuOAname":null,"ProductName":"是大方的说法","pCode":"DSFDS5435435","mainImg":""},{"number":5,"states":1,"price":0,"sales":21,"SKuONname":null,"skuOAname":null,"ProductName":"水电费家大四都是附近的时刻","pCode":"3366666","mainImg":""}]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002002","States":15,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002003","States":20,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002004","States":30,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002005","States":33,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002006","States":33,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002007","States":1,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002008","States":1,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002009","States":1,"consignee":"","amount":25600,"TB_List":[]},{"CreatTime":"2017-02-25T00:00:00","OrderCode":"33100201703221552002010","States":1,"consignee":"","amount":25600,"TB_List":[]}]
     * Count : 264
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
         * CreatTime : 2017-02-25T00:00:00
         * OrderCode : 33100201703221552002001
         * States : 33
         * consignee :
         * amount : 25600
         * TB_List : [{"number":10,"states":1,"price":0,"sales":88.89,"SKuONname":null,"skuOAname":null,"ProductName":"是大方的说法","pCode":"DSFDS5435435","mainImg":""},{"number":5,"states":1,"price":0,"sales":21,"SKuONname":null,"skuOAname":null,"ProductName":"水电费家大四都是附近的时刻","pCode":"3366666","mainImg":""}]
         */

        private String CreatTime;
        private String OrderCode;
        private int States;
        private String consignee;
        private int amount;
        private List<TBListBean> TB_List;

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

        public List<TBListBean> getTB_List() {
            return TB_List;
        }

        public void setTB_List(List<TBListBean> TB_List) {
            this.TB_List = TB_List;
        }

        public static class TBListBean {
            /**
             * number : 10
             * states : 1
             * price : 0
             * sales : 88.89
             * SKuONname : null
             * skuOAname : null
             * ProductName : 是大方的说法
             * pCode : DSFDS5435435
             * mainImg :
             */
            private String pname;
            private int number;
            private int states;
            private int price;
            private double sales;
            private Object SKuONname;
            private Object skuOAname;
            private String ProductName;
            private String pCode;
            private String mainImg;

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public String getpCode() {
                return pCode;
            }

            public void setpCode(String pCode) {
                this.pCode = pCode;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getStates() {
                return states;
            }

            public void setStates(int states) {
                this.states = states;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public double getSales() {
                return sales;
            }

            public void setSales(double sales) {
                this.sales = sales;
            }

            public Object getSKuONname() {
                return SKuONname;
            }

            public void setSKuONname(Object SKuONname) {
                this.SKuONname = SKuONname;
            }

            public Object getSkuOAname() {
                return skuOAname;
            }

            public void setSkuOAname(Object skuOAname) {
                this.skuOAname = skuOAname;
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

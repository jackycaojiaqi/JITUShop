package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/1.
 */
public class OrderInfoEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : {"CreatTime":"2017-11-13T10:58:39","OrderCode":null,"States":15,"consignee":"阿强伯","amount":0.5,"memNote":null,"Addr":"浙江台州市椒江区浙江省台州市啦啦啦","phone":"13777185820","TB_OrderDetails":[{"number":1,"pcice":0.5,"pname":"大白兔，白又白奶糖","skuUserName":"颜色:粉红色 尺码:3XL","states":1,"ProductName":"大白兔，白又白奶糖","mainImg":[{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171109163110193054.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134231998322.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134245676920.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134307484063.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134323509226.jpg"}]}]}
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
         * CreatTime : 2017-11-13T10:58:39
         * OrderCode : null
         * States : 15
         * consignee : 阿强伯
         * amount : 0.5
         * memNote : null
         * Addr : 浙江台州市椒江区浙江省台州市啦啦啦
         * phone : 13777185820
         * TB_OrderDetails : [{"number":1,"pcice":0.5,"pname":"大白兔，白又白奶糖","skuUserName":"颜色:粉红色 尺码:3XL","states":1,"ProductName":"大白兔，白又白奶糖","mainImg":[{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171109163110193054.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134231998322.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134245676920.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134307484063.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134323509226.jpg"}]}]
         */

        private String CreatTime;
        private String OrderCode;
       private String orderid;
        private int States;
        private String consignee;
        private double amount;
        private String memNote;
        private String Addr;
        private String phone;
        private List<TBOrderDetailsBean> TB_OrderDetails;

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

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

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
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
             * number : 1
             * pcice : 0.5
             * pname : 大白兔，白又白奶糖
             * skuUserName : 颜色:粉红色 尺码:3XL
             * states : 1
             * ProductName : 大白兔，白又白奶糖
             * mainImg : [{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171109163110193054.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134231998322.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134245676920.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134307484063.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134323509226.jpg"}]
             */

            private int number;
            private double pcice;
            private String pname;
            private String skuUserName;
            private int states;
            private String ProductName;
            private List<MainImgBean> mainImg;

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public double getPcice() {
                return pcice;
            }

            public void setPcice(double pcice) {
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

            public List<MainImgBean> getMainImg() {
                return mainImg;
            }

            public void setMainImg(List<MainImgBean> mainImg) {
                this.mainImg = mainImg;
            }

            public static class MainImgBean {
                /**
                 * imgserver : C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171109163110193054.jpg
                 */

                private String imgserver;

                public String getImgserver() {
                    return imgserver;
                }

                public void setImgserver(String imgserver) {
                    this.imgserver = imgserver;
                }
            }
        }
    }
}

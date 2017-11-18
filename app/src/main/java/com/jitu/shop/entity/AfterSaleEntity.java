package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/11/15.
 */
public class AfterSaleEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"CM_CreateTime":"2017-11-15T15:50:57.797","CM_ImgPath":"C://ServiceImg/17111515505779392/0.png|","CM_Json":"{\"typename\":\"买家申请退货退款\",\"time\":\"2017-11-15 15:57:50\",\"handlers\":0,\"remark\":null}","CM_OrderDetailsId":0,"CM_Reason":"... 有问题","CM_ServiceId":2,"CM_State":1,"CM_Type":2,"UserName":"15867083398","Mobile":"15867083398","TB_Details":[{"number":1,"pcice":50,"pname":"大颗粒猪排骨","skuUserName":"颜色:红色 尺码:S","states":1,"ProductName":"大颗粒猪排骨","mainImg":[{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171110083258018227.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134348692552.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134407812935.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134422407212.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134441243435.jpeg"}]}]},{"CM_CreateTime":"2017-11-15T15:45:36.327","CM_ImgPath":"","CM_Json":"{\"typename\":\"买家申请退款\",\"time\":\"2017-11-15 15:36:45\",\"handlers\":0,\"remark\":null}","CM_OrderDetailsId":0,"CM_Reason":"... 有问题","CM_ServiceId":1,"CM_State":1,"CM_Type":1,"UserName":"15867083398","Mobile":"15867083398","TB_Details":[{"number":1,"pcice":0.5,"pname":"大白兔，白又白奶糖","skuUserName":"颜色:粉红色 尺码:3XL","states":1,"ProductName":"大白兔，白又白奶糖","mainImg":[{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171109163110193054.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134231998322.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134245676920.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134307484063.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134323509226.jpg"}]}]}]
     * Count : 0
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
         * CM_CreateTime : 2017-11-15T15:50:57.797
         * CM_ImgPath : C://ServiceImg/17111515505779392/0.png|
         * CM_Json : {"typename":"买家申请退货退款","time":"2017-11-15 15:57:50","handlers":0,"remark":null}
         * CM_OrderDetailsId : 0
         * CM_Reason : ... 有问题
         * CM_ServiceId : 2
         * CM_State : 1
         * CM_Type : 2
         * UserName : 15867083398
         * Mobile : 15867083398
         * TB_Details : [{"number":1,"pcice":50,"pname":"大颗粒猪排骨","skuUserName":"颜色:红色 尺码:S","states":1,"ProductName":"大颗粒猪排骨","mainImg":[{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171110083258018227.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134348692552.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134407812935.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134422407212.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134441243435.jpeg"}]}]
         */

        private String CM_CreateTime;
        private String CM_ImgPath;
        private String CM_Json;
        private int CM_OrderDetailsId;
        private String CM_Reason;
        private String CM_ServiceId;
        private int CM_State;
        private int CM_Type;
        private String UserName;
        private String Mobile;
        private List<TBDetailsBean> TB_Details;

        public String getCM_CreateTime() {
            return CM_CreateTime;
        }

        public void setCM_CreateTime(String CM_CreateTime) {
            this.CM_CreateTime = CM_CreateTime;
        }

        public String getCM_ImgPath() {
            return CM_ImgPath;
        }

        public void setCM_ImgPath(String CM_ImgPath) {
            this.CM_ImgPath = CM_ImgPath;
        }

        public String getCM_Json() {
            return CM_Json;
        }

        public void setCM_Json(String CM_Json) {
            this.CM_Json = CM_Json;
        }

        public int getCM_OrderDetailsId() {
            return CM_OrderDetailsId;
        }

        public void setCM_OrderDetailsId(int CM_OrderDetailsId) {
            this.CM_OrderDetailsId = CM_OrderDetailsId;
        }

        public String getCM_Reason() {
            return CM_Reason;
        }

        public void setCM_Reason(String CM_Reason) {
            this.CM_Reason = CM_Reason;
        }

        public String getCM_ServiceId() {
            return CM_ServiceId;
        }

        public void setCM_ServiceId(String CM_ServiceId) {
            this.CM_ServiceId = CM_ServiceId;
        }

        public int getCM_State() {
            return CM_State;
        }

        public void setCM_State(int CM_State) {
            this.CM_State = CM_State;
        }

        public int getCM_Type() {
            return CM_Type;
        }

        public void setCM_Type(int CM_Type) {
            this.CM_Type = CM_Type;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String Mobile) {
            this.Mobile = Mobile;
        }

        public List<TBDetailsBean> getTB_Details() {
            return TB_Details;
        }

        public void setTB_Details(List<TBDetailsBean> TB_Details) {
            this.TB_Details = TB_Details;
        }

        public static class TBDetailsBean {
            /**
             * number : 1
             * pcice : 50.0
             * pname : 大颗粒猪排骨
             * skuUserName : 颜色:红色 尺码:S
             * states : 1
             * ProductName : 大颗粒猪排骨
             * mainImg : [{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171110083258018227.jpg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134348692552.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134407812935.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134422407212.jpeg"},{"imgserver":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171111134441243435.jpeg"}]
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
                 * imgserver : C://web/HT/eShop.jjsqwg.com/images/eShop/ShopProductPics/7/20171110083258018227.jpg
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

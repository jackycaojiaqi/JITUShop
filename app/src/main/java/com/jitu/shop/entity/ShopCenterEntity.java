package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/9/28.
 */
public class ShopCenterEntity extends BasePaserEntity {


    /**
     * Result : {"ShopName":"浙江框架回访身份","logo":"images/eShop/ShopPics/ShopLogo_2.jpg","ispass":null,"ispay":null,"closingtime":null,"openingtime":null}
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
         * ShopName : 浙江框架回访身份
         * logo : images/eShop/ShopPics/ShopLogo_2.jpg
         * ispass : null
         * ispay : null
         * closingtime : null
         * openingtime : null
         */

        private String ShopName;
        private String logo;
        private int ispass;
        private int ispay;
        private String closingtime;
        private String openingtime;

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public int getIspass() {
            return ispass;
        }

        public void setIspass(int ispass) {
            this.ispass = ispass;
        }

        public int getIspay() {
            return ispay;
        }

        public void setIspay(int ispay) {
            this.ispay = ispay;
        }

        public String getClosingtime() {
            return closingtime;
        }

        public void setClosingtime(String closingtime) {
            this.closingtime = closingtime;
        }

        public String getOpeningtime() {
            return openingtime;
        }

        public void setOpeningtime(String openingtime) {
            this.openingtime = openingtime;
        }
    }
}

package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/9/28.
 */
public class ShopInfoEntity extends BasePaserEntity {


    /**
     * Result : {"mouthordersun":0,"monthturnover":null,"dayordernum":0,"dayturnover":null,"sellersun":12,"unsellersun":6,"notshipped":0}
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
         * mouthordersun : 0
         * monthturnover : null
         * dayordernum : 0
         * dayturnover : null
         * sellersun : 12
         * unsellersun : 6
         * notshipped : 0
         */

        private int mouthordersun;
        private Object monthturnover;
        private int dayordernum;
        private Object dayturnover;
        private int sellersun;
        private int unsellersun;
        private int notshipped;

        public int getMouthordersun() {
            return mouthordersun;
        }

        public void setMouthordersun(int mouthordersun) {
            this.mouthordersun = mouthordersun;
        }

        public Object getMonthturnover() {
            return monthturnover;
        }

        public void setMonthturnover(Object monthturnover) {
            this.monthturnover = monthturnover;
        }

        public int getDayordernum() {
            return dayordernum;
        }

        public void setDayordernum(int dayordernum) {
            this.dayordernum = dayordernum;
        }

        public Object getDayturnover() {
            return dayturnover;
        }

        public void setDayturnover(Object dayturnover) {
            this.dayturnover = dayturnover;
        }

        public int getSellersun() {
            return sellersun;
        }

        public void setSellersun(int sellersun) {
            this.sellersun = sellersun;
        }

        public int getUnsellersun() {
            return unsellersun;
        }

        public void setUnsellersun(int unsellersun) {
            this.unsellersun = unsellersun;
        }

        public int getNotshipped() {
            return notshipped;
        }

        public void setNotshipped(int notshipped) {
            this.notshipped = notshipped;
        }
    }
}

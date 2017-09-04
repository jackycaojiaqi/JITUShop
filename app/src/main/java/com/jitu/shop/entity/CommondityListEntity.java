package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/1.
 */
public class CommondityListEntity extends BasePaserEntity {


    /**
     * Result : [{"mainImg":"","inventory":0,"sales":88.89,"IsSale":false,"PackingName":"","CreatTime":"2017-04-05T11:13:02.507","TB_Sku":[]},{"mainImg":"","inventory":150,"sales":21,"IsSale":true,"PackingName":"","CreatTime":"2017-04-05T14:19:15.86","TB_Sku":[]},{"mainImg":"","inventory":200,"sales":88,"IsSale":true,"PackingName":"","CreatTime":"2017-04-13T17:57:48.11","TB_Sku":[]},{"mainImg":"","inventory":0,"sales":65,"IsSale":false,"PackingName":"","CreatTime":"2017-04-13T18:07:54.28","TB_Sku":[]},{"mainImg":"","inventory":173,"sales":558,"IsSale":true,"PackingName":"","CreatTime":"2017-04-13T18:17:03.5","TB_Sku":[]},{"mainImg":"","inventory":100,"sales":77,"IsSale":false,"PackingName":"","CreatTime":"2017-04-13T18:21:33.02","TB_Sku":[]},{"mainImg":"","inventory":34,"sales":66,"IsSale":false,"PackingName":"","CreatTime":"2017-04-13T19:33:23.9","TB_Sku":[]},{"mainImg":"","inventory":11,"sales":152,"IsSale":true,"PackingName":"","CreatTime":"2017-04-22T16:49:24.847","TB_Sku":[]},{"mainImg":"","inventory":55,"sales":44,"IsSale":false,"PackingName":"","CreatTime":"2017-04-25T18:53:07.897","TB_Sku":[]},{"mainImg":"","inventory":66,"sales":66,"IsSale":true,"PackingName":"","CreatTime":"2017-04-25T18:55:31.693","TB_Sku":[]}]
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
         * mainImg :
         * inventory : 0
         * sales : 88.89
         * IsSale : false
         * PackingName :
         * CreatTime : 2017-04-05T11:13:02.507
         * TB_Sku : []
         */
        private int id;
        private String mainImg;
        private int inventory;
        private double sales;
        private boolean IsSale;
        private String PackingName;
        private String CreatTime;
        private List<?> TB_Sku;
        private boolean is_check;
        private String sellernum;
        private String pCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getpCode() {
            return pCode;
        }

        public void setpCode(String pCode) {
            this.pCode = pCode;
        }

        public String getSellernum() {
            return sellernum;
        }

        public void setSellernum(String sellernum) {
            this.sellernum = sellernum;
        }

        public boolean is_check() {
            return is_check;
        }

        public void setIs_check(boolean is_check) {
            this.is_check = is_check;
        }

        public String getMainImg() {
            return mainImg;
        }

        public void setMainImg(String mainImg) {
            this.mainImg = mainImg;
        }

        public int getInventory() {
            return inventory;
        }

        public void setInventory(int inventory) {
            this.inventory = inventory;
        }

        public double getSales() {
            return sales;
        }

        public void setSales(double sales) {
            this.sales = sales;
        }

        public boolean isIsSale() {
            return IsSale;
        }

        public void setIsSale(boolean IsSale) {
            this.IsSale = IsSale;
        }

        public String getPackingName() {
            return PackingName;
        }

        public void setPackingName(String PackingName) {
            this.PackingName = PackingName;
        }

        public String getCreatTime() {
            return CreatTime;
        }

        public void setCreatTime(String CreatTime) {
            this.CreatTime = CreatTime;
        }

        public List<?> getTB_Sku() {
            return TB_Sku;
        }

        public void setTB_Sku(List<?> TB_Sku) {
            this.TB_Sku = TB_Sku;
        }
    }
}

package com.jitu.shop.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jacky on 2017/9/1.
 */
public class CommondityListEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"id":41,"inventory":0,"sales":0.5,"IsSale":true,"ProductName":"大白兔，白又白奶糖","CreatTime":"2017-11-09T15:14:28.583","pCode":"111111","skuid":0,"price":0,"skuOAname":"","skuOAid":0,"skuOValue":0,"skuOname":"","SKuONname":"","skuTAname":"","skuTAid":0,"skuTValue":0,"skuTname":"","skuTNname":"","skuinventory":0,"skuIsSale":false,"mainImg":[]},{"id":42,"inventory":0,"sales":50,"IsSale":true,"ProductName":"大颗粒猪排骨","CreatTime":"2017-11-09T15:20:44.983","pCode":"222222","skuid":0,"price":0,"skuOAname":"","skuOAid":0,"skuOValue":0,"skuOname":"","SKuONname":"","skuTAname":"","skuTAid":0,"skuTValue":0,"skuTname":"","skuTNname":"","skuinventory":0,"skuIsSale":false,"mainImg":[]},{"id":43,"inventory":0,"sales":30,"IsSale":true,"ProductName":"大扫把","CreatTime":"2017-11-09T15:21:34.61","pCode":"33333","skuid":0,"price":0,"skuOAname":"","skuOAid":0,"skuOValue":0,"skuOname":"","SKuONname":"","skuTAname":"","skuTAid":0,"skuTValue":0,"skuTname":"","skuTNname":"","skuinventory":0,"skuIsSale":false,"mainImg":[]}]
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
         * id : 41
         * inventory : 0
         * sales : 0.5
         * IsSale : true
         * ProductName : 大白兔，白又白奶糖
         * CreatTime : 2017-11-09T15:14:28.583
         * pCode : 111111
         * skuid : 0
         * price : 0.0
         * skuOAname :
         * skuOAid : 0
         * skuOValue : 0
         * skuOname :
         * SKuONname :
         * skuTAname :
         * skuTAid : 0
         * skuTValue : 0
         * skuTname :
         * skuTNname :
         * skuinventory : 0
         * skuIsSale : false
         * mainImg : []
         */

        private String id;
        private int inventory;
        private double sales;
        private boolean IsSale;
        private int isSku;

        private String ProductName;
        private String CreatTime;
        private String pCode;
        private int skuid;
        private double price;
        private String skuOAname;
        private int skuOAid;
        private int skuOValue;
        private String skuOname;
        private String SKuONname;
        private String skuTAname;
        private int skuTAid;
        private int skuTValue;
        private String skuTname;
        private String skuTNname;
        private int skuinventory;
        private boolean skuIsSale;
        private List<ImagBean> mainImg;
        private boolean is_check;

        public int getIsSku() {
            return isSku;
        }

        public void setIsSku(int isSku) {
            this.isSku = isSku;
        }

        public boolean isIs_check() {
            return is_check;
        }

        public void setIs_check(boolean is_check) {
            this.is_check = is_check;
        }

        public static class ImagBean {
            /**
             * mainImg : C://IMG/v1.jpg
             */

            private String imgserver;

            public String getMainImg() {
                return imgserver;
            }

            public void setMainImg(String mainImg) {
                this.imgserver = mainImg;
            }
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getProductName() {
            return ProductName;
        }

        public void setProductName(String ProductName) {
            this.ProductName = ProductName;
        }

        public String getCreatTime() {
            return CreatTime;
        }

        public void setCreatTime(String CreatTime) {
            this.CreatTime = CreatTime;
        }

        public String getPCode() {
            return pCode;
        }

        public void setPCode(String pCode) {
            this.pCode = pCode;
        }

        public int getSkuid() {
            return skuid;
        }

        public void setSkuid(int skuid) {
            this.skuid = skuid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getSkuOAname() {
            return skuOAname;
        }

        public void setSkuOAname(String skuOAname) {
            this.skuOAname = skuOAname;
        }

        public int getSkuOAid() {
            return skuOAid;
        }

        public void setSkuOAid(int skuOAid) {
            this.skuOAid = skuOAid;
        }

        public int getSkuOValue() {
            return skuOValue;
        }

        public void setSkuOValue(int skuOValue) {
            this.skuOValue = skuOValue;
        }

        public String getSkuOname() {
            return skuOname;
        }

        public void setSkuOname(String skuOname) {
            this.skuOname = skuOname;
        }

        public String getSKuONname() {
            return SKuONname;
        }

        public void setSKuONname(String SKuONname) {
            this.SKuONname = SKuONname;
        }

        public String getSkuTAname() {
            return skuTAname;
        }

        public void setSkuTAname(String skuTAname) {
            this.skuTAname = skuTAname;
        }

        public int getSkuTAid() {
            return skuTAid;
        }

        public void setSkuTAid(int skuTAid) {
            this.skuTAid = skuTAid;
        }

        public int getSkuTValue() {
            return skuTValue;
        }

        public void setSkuTValue(int skuTValue) {
            this.skuTValue = skuTValue;
        }

        public String getSkuTname() {
            return skuTname;
        }

        public void setSkuTname(String skuTname) {
            this.skuTname = skuTname;
        }

        public String getSkuTNname() {
            return skuTNname;
        }

        public void setSkuTNname(String skuTNname) {
            this.skuTNname = skuTNname;
        }

        public int getSkuinventory() {
            return skuinventory;
        }

        public void setSkuinventory(int skuinventory) {
            this.skuinventory = skuinventory;
        }

        public boolean isSkuIsSale() {
            return skuIsSale;
        }

        public void setSkuIsSale(boolean skuIsSale) {
            this.skuIsSale = skuIsSale;
        }

        public List<ImagBean> getMainImg() {
            return mainImg;
        }

        public void setMainImg(List<ImagBean> mainImg) {
            this.mainImg = mainImg;
        }
    }
}

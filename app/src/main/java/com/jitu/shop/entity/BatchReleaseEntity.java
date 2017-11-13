package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/11/10.
 */
public class BatchReleaseEntity {


    private List<ProductidsBean> productids;

    public List<ProductidsBean> getProductids() {
        return productids;
    }

    public void setProductids(List<ProductidsBean> productids) {
        this.productids = productids;
    }

    public static class ProductidsBean {
        /**
         * productid : 123
         * count : 100
         * skus : [{"skuid":"111","inventory":"100"}]
         */

        private String productid;
        private String count;
        private List<SkusBean> skus;

        public String getProductid() {
            return productid;
        }

        public void setProductid(String productid) {
            this.productid = productid;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<SkusBean> getSkus() {
            return skus;
        }

        public void setSkus(List<SkusBean> skus) {
            this.skus = skus;
        }

        public static class SkusBean {
            /**
             * skuid : 111
             * inventory : 100
             */

            private String skuid;
            private String inventory;

            public String getSkuid() {
                return skuid;
            }

            public void setSkuid(String skuid) {
                this.skuid = skuid;
            }

            public String getInventory() {
                return inventory;
            }

            public void setInventory(String inventory) {
                this.inventory = inventory;
            }
        }
    }
}

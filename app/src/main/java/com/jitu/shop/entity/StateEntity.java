package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/9/16.
 */
public class StateEntity extends BasePaserEntity {


    /**
     * Result : {"unpaid":254,"piad":0,"shipped":2,"completed":0,"ispass":0}
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
         * unpaid : 254
         * piad : 0
         * shipped : 2
         * completed : 0
         * ispass : 0
         */

        private int unpaid;
        private int piad;
        private int shipped;
        private int completed;
        private int ispass;

        public int getUnpaid() {
            return unpaid;
        }

        public void setUnpaid(int unpaid) {
            this.unpaid = unpaid;
        }

        public int getPiad() {
            return piad;
        }

        public void setPiad(int piad) {
            this.piad = piad;
        }

        public int getShipped() {
            return shipped;
        }

        public void setShipped(int shipped) {
            this.shipped = shipped;
        }

        public int getCompleted() {
            return completed;
        }

        public void setCompleted(int completed) {
            this.completed = completed;
        }

        public int getIspass() {
            return ispass;
        }

        public void setIspass(int ispass) {
            this.ispass = ispass;
        }
    }
}

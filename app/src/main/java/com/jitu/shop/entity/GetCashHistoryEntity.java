package com.jitu.shop.entity;




        import java.util.List;

/**
 * Created by jacky on 2017/9/25.
 */
public class GetCashHistoryEntity extends BasePaserEntity {


    /**
     * Result : [{"$id":"1","CM_Id":0,"CM_CardNum":"6227001481180146163","CM_BankName":"建设银行.龙卡储蓄卡","CM_Name":"caojaiqi","CM_BankAddress":"jiangjiang.taizhou","CM_ShopId":2,"CM_CreateTime":"2017-09-25T10:41:07.957","CM_AddAdminId":7,"EntityKey":{"$id":"2","EntitySetName":"TB_Card","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_Id","Type":"System.Int32","Value":"0"}]}},{"$id":"3","CM_Id":1,"CM_CardNum":"6227001481180146163","CM_BankName":"建设银行.龙卡储蓄卡","CM_Name":"caojiaqi","CM_BankAddress":"caojiaqn.jiaojiang","CM_ShopId":2,"CM_CreateTime":"2017-09-25T10:54:15.753","CM_AddAdminId":7,"EntityKey":{"$id":"4","EntitySetName":"TB_Card","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_Id","Type":"System.Int32","Value":"1"}]}}]
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
         * CM_ApplyId : 7
         * CM_Money : 32
         * CM_CreateTime : 2017-09-29T09:37:23.5
         * CM_CardNum : 6214808801003979610
         * CM_BankName : 泰隆城市信用社.
         */

        private int CM_ApplyId;
        private int CM_Money;
        private String CM_CreateTime;
        private String CM_CardNum;
        private String CM_BankName;

        public int getCM_ApplyId() {
            return CM_ApplyId;
        }

        public void setCM_ApplyId(int CM_ApplyId) {
            this.CM_ApplyId = CM_ApplyId;
        }

        public int getCM_Money() {
            return CM_Money;
        }

        public void setCM_Money(int CM_Money) {
            this.CM_Money = CM_Money;
        }

        public String getCM_CreateTime() {
            return CM_CreateTime;
        }

        public void setCM_CreateTime(String CM_CreateTime) {
            this.CM_CreateTime = CM_CreateTime;
        }

        public String getCM_CardNum() {
            return CM_CardNum;
        }

        public void setCM_CardNum(String CM_CardNum) {
            this.CM_CardNum = CM_CardNum;
        }

        public String getCM_BankName() {
            return CM_BankName;
        }

        public void setCM_BankName(String CM_BankName) {
            this.CM_BankName = CM_BankName;
        }
    }
}

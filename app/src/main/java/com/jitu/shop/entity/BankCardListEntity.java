package com.jitu.shop.entity;
import com.jitu.shop.entity.BasePaserEntity;

import java.util.List;

/**
 * Created by jacky on 2017/9/25.
 */
public class BankCardListEntity extends BasePaserEntity {


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
         * $id : 1
         * CM_Id : 0
         * CM_CardNum : 6227001481180146163
         * CM_BankName : 建设银行.龙卡储蓄卡
         * CM_Name : caojaiqi
         * CM_BankAddress : jiangjiang.taizhou
         * CM_ShopId : 2
         * CM_CreateTime : 2017-09-25T10:41:07.957
         * CM_AddAdminId : 7
         * EntityKey : {"$id":"2","EntitySetName":"TB_Card","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_Id","Type":"System.Int32","Value":"0"}]}
         */

        private String $id;
        private int CM_Id;
        private String CM_CardNum;
        private String CM_BankName;
        private String CM_Name;
        private String CM_BankAddress;
        private int CM_ShopId;
        private String CM_CreateTime;
        private int CM_AddAdminId;
        private EntityKeyBean EntityKey;
        private boolean is_checked = false;

        public boolean is_checked() {
            return is_checked;
        }

        public void setIs_checked(boolean is_checked) {
            this.is_checked = is_checked;
        }

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }

        public int getCM_Id() {
            return CM_Id;
        }

        public void setCM_Id(int CM_Id) {
            this.CM_Id = CM_Id;
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

        public String getCM_Name() {
            return CM_Name;
        }

        public void setCM_Name(String CM_Name) {
            this.CM_Name = CM_Name;
        }

        public String getCM_BankAddress() {
            return CM_BankAddress;
        }

        public void setCM_BankAddress(String CM_BankAddress) {
            this.CM_BankAddress = CM_BankAddress;
        }

        public int getCM_ShopId() {
            return CM_ShopId;
        }

        public void setCM_ShopId(int CM_ShopId) {
            this.CM_ShopId = CM_ShopId;
        }

        public String getCM_CreateTime() {
            return CM_CreateTime;
        }

        public void setCM_CreateTime(String CM_CreateTime) {
            this.CM_CreateTime = CM_CreateTime;
        }

        public int getCM_AddAdminId() {
            return CM_AddAdminId;
        }

        public void setCM_AddAdminId(int CM_AddAdminId) {
            this.CM_AddAdminId = CM_AddAdminId;
        }

        public EntityKeyBean getEntityKey() {
            return EntityKey;
        }

        public void setEntityKey(EntityKeyBean EntityKey) {
            this.EntityKey = EntityKey;
        }

        public static class EntityKeyBean {
            /**
             * $id : 2
             * EntitySetName : TB_Card
             * EntityContainerName : JJCommunityEntities
             * EntityKeyValues : [{"Key":"CM_Id","Type":"System.Int32","Value":"0"}]
             */

            private String $id;
            private String EntitySetName;
            private String EntityContainerName;
            private List<EntityKeyValuesBean> EntityKeyValues;

            public String get$id() {
                return $id;
            }

            public void set$id(String $id) {
                this.$id = $id;
            }

            public String getEntitySetName() {
                return EntitySetName;
            }

            public void setEntitySetName(String EntitySetName) {
                this.EntitySetName = EntitySetName;
            }

            public String getEntityContainerName() {
                return EntityContainerName;
            }

            public void setEntityContainerName(String EntityContainerName) {
                this.EntityContainerName = EntityContainerName;
            }

            public List<EntityKeyValuesBean> getEntityKeyValues() {
                return EntityKeyValues;
            }

            public void setEntityKeyValues(List<EntityKeyValuesBean> EntityKeyValues) {
                this.EntityKeyValues = EntityKeyValues;
            }

            public static class EntityKeyValuesBean {
                /**
                 * Key : CM_Id
                 * Type : System.Int32
                 * Value : 0
                 */

                private String Key;
                private String Type;
                private String Value;

                public String getKey() {
                    return Key;
                }

                public void setKey(String Key) {
                    this.Key = Key;
                }

                public String getType() {
                    return Type;
                }

                public void setType(String Type) {
                    this.Type = Type;
                }

                public String getValue() {
                    return Value;
                }

                public void setValue(String Value) {
                    this.Value = Value;
                }
            }
        }
    }
}
package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/11/13.
 */
public class DeliverCompanyEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"$id":"1","CM_LogisticsId":1,"CM_Name":"中通快递","EntityKey":{"$id":"2","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"1"}]}},{"$id":"3","CM_LogisticsId":2,"CM_Name":"顺丰快递","EntityKey":{"$id":"4","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"2"}]}},{"$id":"5","CM_LogisticsId":3,"CM_Name":"申通快递","EntityKey":{"$id":"6","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"3"}]}},{"$id":"7","CM_LogisticsId":4,"CM_Name":"天天快递","EntityKey":{"$id":"8","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"4"}]}},{"$id":"9","CM_LogisticsId":5,"CM_Name":"韵达快递","EntityKey":{"$id":"10","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"5"}]}}]
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
         * CM_LogisticsId : 1
         * CM_Name : 中通快递
         * EntityKey : {"$id":"2","EntitySetName":"TB_Logistics","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"1"}]}
         */

        private String $id;
        private int CM_LogisticsId;
        private String CM_Name;
        private EntityKeyBean EntityKey;

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }

        public int getCM_LogisticsId() {
            return CM_LogisticsId;
        }

        public void setCM_LogisticsId(int CM_LogisticsId) {
            this.CM_LogisticsId = CM_LogisticsId;
        }

        public String getCM_Name() {
            return CM_Name;
        }

        public void setCM_Name(String CM_Name) {
            this.CM_Name = CM_Name;
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
             * EntitySetName : TB_Logistics
             * EntityContainerName : JJCommunityEntities
             * EntityKeyValues : [{"Key":"CM_LogisticsId","Type":"System.Int32","Value":"1"}]
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
                 * Key : CM_LogisticsId
                 * Type : System.Int32
                 * Value : 1
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

package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/11/13.
 */
public class CourierPeopleEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"$id":"1","ID":"31C3E051-6B58-4041-BF85-326CF384D45C","ShopID":7,"realName":"外服人员1","mobile":"15678765678","sex":"男","CardNo":"","Photo":"","EntityKey":{"$id":"2","EntitySetName":"De_Shop_Senders","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"ID","Type":"System.String","Value":"31C3E051-6B58-4041-BF85-326CF384D45C"}]}},{"$id":"3","ID":"5F3172C0-1A22-4E2D-A6E7-00B03D0A884E","ShopID":7,"realName":"王五","mobile":"13256585455","sex":"男","CardNo":"331002199207051039","Photo":"","EntityKey":{"$id":"4","EntitySetName":"De_Shop_Senders","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"ID","Type":"System.String","Value":"5F3172C0-1A22-4E2D-A6E7-00B03D0A884E"}]}},{"$id":"5","ID":"DA6044BC-45AE-4A53-9423-C92D0FC70BE9","ShopID":7,"realName":"武松","mobile":"15636212512","sex":"女","CardNo":"410256198811051100","Photo":"","EntityKey":{"$id":"6","EntitySetName":"De_Shop_Senders","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"ID","Type":"System.String","Value":"DA6044BC-45AE-4A53-9423-C92D0FC70BE9"}]}}]
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
         * ID : 31C3E051-6B58-4041-BF85-326CF384D45C
         * ShopID : 7
         * realName : 外服人员1
         * mobile : 15678765678
         * sex : 男
         * CardNo :
         * Photo :
         * EntityKey : {"$id":"2","EntitySetName":"De_Shop_Senders","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"ID","Type":"System.String","Value":"31C3E051-6B58-4041-BF85-326CF384D45C"}]}
         */

        private String $id;
        private String ID;
        private int ShopID;
        private String realName;
        private String mobile;
        private String sex;
        private String CardNo;
        private String Photo;
        private EntityKeyBean EntityKey;

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public int getShopID() {
            return ShopID;
        }

        public void setShopID(int ShopID) {
            this.ShopID = ShopID;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getCardNo() {
            return CardNo;
        }

        public void setCardNo(String CardNo) {
            this.CardNo = CardNo;
        }

        public String getPhoto() {
            return Photo;
        }

        public void setPhoto(String Photo) {
            this.Photo = Photo;
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
             * EntitySetName : De_Shop_Senders
             * EntityContainerName : JJCommunityEntities
             * EntityKeyValues : [{"Key":"ID","Type":"System.String","Value":"31C3E051-6B58-4041-BF85-326CF384D45C"}]
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
                 * Key : ID
                 * Type : System.String
                 * Value : 31C3E051-6B58-4041-BF85-326CF384D45C
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

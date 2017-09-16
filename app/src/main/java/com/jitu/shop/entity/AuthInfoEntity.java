package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/16.
 */
public class AuthInfoEntity extends BasePaserEntity {


    /**
     * Result : {"$id":"1","id":3,"Isdelete":null,"deltime":null,"CreatTime":"2017-09-16T11:04:10.983","creatUser":"自以为是","ShopName":"用肉在真肉在","phone":"18886646646","address":"浙江省台州市椒江区东环大道568号靠近台州创业服务园五联园区","contact":null,"contactPhone":null,"email":null,"fax":null,"withinType":null,"serviceTime":null,"logo":null,"baneer":null,"bankgroud":null,"industry":null,"note":null,"discountMax":null,"discountReal":null,"IsSendMoney":null,"MinSendMoney":null,"DefaultSendMoney":null,"PositionX":28.641581,"PositionY":28.641581,"cartimg":"C://ApplicationsImg/0.jpeg|","otherimg":"C://ApplicationsImg/1.jpeg|","classid":17,"ispass":0,"provincesid":34,"cityid":7,"regionid":123,"adminid":7,"EntityKey":{"$id":"2","EntitySetName":"De_Shop","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"id","Type":"System.Int64","Value":"3"}]}}
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
         * $id : 1
         * id : 3
         * Isdelete : null
         * deltime : null
         * CreatTime : 2017-09-16T11:04:10.983
         * creatUser : 自以为是
         * ShopName : 用肉在真肉在
         * phone : 18886646646
         * address : 浙江省台州市椒江区东环大道568号靠近台州创业服务园五联园区
         * contact : null
         * contactPhone : null
         * email : null
         * fax : null
         * withinType : null
         * serviceTime : null
         * logo : null
         * baneer : null
         * bankgroud : null
         * industry : null
         * note : null
         * discountMax : null
         * discountReal : null
         * IsSendMoney : null
         * MinSendMoney : null
         * DefaultSendMoney : null
         * PositionX : 28.641581
         * PositionY : 28.641581
         * cartimg : C://ApplicationsImg/0.jpeg|
         * otherimg : C://ApplicationsImg/1.jpeg|
         * classid : 17
         * ispass : 0
         * provincesid : 34
         * cityid : 7
         * regionid : 123
         * adminid : 7
         * EntityKey : {"$id":"2","EntitySetName":"De_Shop","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"id","Type":"System.Int64","Value":"3"}]}
         */

        private String $id;
        private int id;
        private Object Isdelete;
        private Object deltime;
        private String CreatTime;
        private String creatUser;
        private String ShopName;
        private String phone;
        private String address;
        private Object contact;
        private Object contactPhone;
        private Object email;
        private Object fax;
        private Object withinType;
        private Object serviceTime;
        private Object logo;
        private Object baneer;
        private Object bankgroud;
        private Object industry;
        private Object note;
        private Object discountMax;
        private Object discountReal;
        private Object IsSendMoney;
        private Object MinSendMoney;
        private Object DefaultSendMoney;
        private double PositionX;
        private double PositionY;
        private String cartimg;
        private String otherimg;
        private int classid;
        private int ispass;
        private int provincesid;
        private int cityid;
        private int regionid;
        private int adminid;
        private EntityKeyBean EntityKey;

        private String provincesname;
        private String cityname;
        private String regionname;
        private String classname;

        public String getProvincesname() {
            return provincesname;
        }

        public void setProvincesname(String provincesname) {
            this.provincesname = provincesname;
        }

        public String getCityname() {
            return cityname;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }

        public String getRegionname() {
            return regionname;
        }

        public void setRegionname(String regionname) {
            this.regionname = regionname;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getIsdelete() {
            return Isdelete;
        }

        public void setIsdelete(Object Isdelete) {
            this.Isdelete = Isdelete;
        }

        public Object getDeltime() {
            return deltime;
        }

        public void setDeltime(Object deltime) {
            this.deltime = deltime;
        }

        public String getCreatTime() {
            return CreatTime;
        }

        public void setCreatTime(String CreatTime) {
            this.CreatTime = CreatTime;
        }

        public String getCreatUser() {
            return creatUser;
        }

        public void setCreatUser(String creatUser) {
            this.creatUser = creatUser;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getContact() {
            return contact;
        }

        public void setContact(Object contact) {
            this.contact = contact;
        }

        public Object getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(Object contactPhone) {
            this.contactPhone = contactPhone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
            this.fax = fax;
        }

        public Object getWithinType() {
            return withinType;
        }

        public void setWithinType(Object withinType) {
            this.withinType = withinType;
        }

        public Object getServiceTime() {
            return serviceTime;
        }

        public void setServiceTime(Object serviceTime) {
            this.serviceTime = serviceTime;
        }

        public Object getLogo() {
            return logo;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }

        public Object getBaneer() {
            return baneer;
        }

        public void setBaneer(Object baneer) {
            this.baneer = baneer;
        }

        public Object getBankgroud() {
            return bankgroud;
        }

        public void setBankgroud(Object bankgroud) {
            this.bankgroud = bankgroud;
        }

        public Object getIndustry() {
            return industry;
        }

        public void setIndustry(Object industry) {
            this.industry = industry;
        }

        public Object getNote() {
            return note;
        }

        public void setNote(Object note) {
            this.note = note;
        }

        public Object getDiscountMax() {
            return discountMax;
        }

        public void setDiscountMax(Object discountMax) {
            this.discountMax = discountMax;
        }

        public Object getDiscountReal() {
            return discountReal;
        }

        public void setDiscountReal(Object discountReal) {
            this.discountReal = discountReal;
        }

        public Object getIsSendMoney() {
            return IsSendMoney;
        }

        public void setIsSendMoney(Object IsSendMoney) {
            this.IsSendMoney = IsSendMoney;
        }

        public Object getMinSendMoney() {
            return MinSendMoney;
        }

        public void setMinSendMoney(Object MinSendMoney) {
            this.MinSendMoney = MinSendMoney;
        }

        public Object getDefaultSendMoney() {
            return DefaultSendMoney;
        }

        public void setDefaultSendMoney(Object DefaultSendMoney) {
            this.DefaultSendMoney = DefaultSendMoney;
        }

        public double getPositionX() {
            return PositionX;
        }

        public void setPositionX(double PositionX) {
            this.PositionX = PositionX;
        }

        public double getPositionY() {
            return PositionY;
        }

        public void setPositionY(double PositionY) {
            this.PositionY = PositionY;
        }

        public String getCartimg() {
            return cartimg;
        }

        public void setCartimg(String cartimg) {
            this.cartimg = cartimg;
        }

        public String getOtherimg() {
            return otherimg;
        }

        public void setOtherimg(String otherimg) {
            this.otherimg = otherimg;
        }

        public int getClassid() {
            return classid;
        }

        public void setClassid(int classid) {
            this.classid = classid;
        }

        public int getIspass() {
            return ispass;
        }

        public void setIspass(int ispass) {
            this.ispass = ispass;
        }

        public int getProvincesid() {
            return provincesid;
        }

        public void setProvincesid(int provincesid) {
            this.provincesid = provincesid;
        }

        public int getCityid() {
            return cityid;
        }

        public void setCityid(int cityid) {
            this.cityid = cityid;
        }

        public int getRegionid() {
            return regionid;
        }

        public void setRegionid(int regionid) {
            this.regionid = regionid;
        }

        public int getAdminid() {
            return adminid;
        }

        public void setAdminid(int adminid) {
            this.adminid = adminid;
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
             * EntitySetName : De_Shop
             * EntityContainerName : JJCommunityEntities
             * EntityKeyValues : [{"Key":"id","Type":"System.Int64","Value":"3"}]
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
                 * Key : id
                 * Type : System.Int64
                 * Value : 3
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

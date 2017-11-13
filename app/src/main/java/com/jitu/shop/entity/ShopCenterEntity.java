package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/28.
 */
public class ShopCenterEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : {"$id":"1","id":7,"Isdelete":0,"deltime":"2017-11-09T15:27:07.683","CreatTime":"2017-11-09T11:03:18.693","creatUser":"曹佳琪","ShopName":"台州大超市旗舰店","phone":"15867083398","address":"浙江省台州市椒江区东环大道568号靠近台州创业服务园·五联园区","contact":"曹佳琪","contactPhone":"15867083398","email":"","fax":"","withinType":null,"serviceTime":null,"logo":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopLogo_7.jpg","baneer":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopBanner_7.jpg","bankgroud":"C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopBackGround_7.jpg","industry":20,"note":"一个十分可爱的商家","discountMax":null,"discountReal":100,"IsSendMoney":1,"MinSendMoney":10,"DefaultSendMoney":11,"PositionX":121.4269892324,"PositionY":28.641665,"cartimg":"C://ApplicationsImg/0.jpeg|","otherimg":"C://ApplicationsImg/1.jpeg|","classid":"20","ispass":2,"premium":null,"ispay":0,"provincesid":34,"cityid":7,"regionid":123,"adminid":18,"provincesname":"浙江","cityname":"台州市","regionname":"椒江区","classname":"生活超市 - 社区超市","closingtime":null,"openingtime":null,"worktimeBegin":"07:35     ","worktimeEnd":"19:00     ","LogoWeb":"images/eShop/ShopPics/ShopLogo_7.jpg","baneerWeb":"images/eShop/ShopPics/ShopBanner_7.jpg","bankgroudWeb":"images/eShop/ShopPics/ShopBackGround_7.jpg","commissionRatio":0,"ServiceType":0,"shopstore":null,"cartimgWeb":null,"otherimgWeb":null,"bSelfSendProd":1,"EntityKey":{"$id":"2","EntitySetName":"De_Shop","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"id","Type":"System.Int64","Value":"7"}]}}
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
         * id : 7
         * Isdelete : 0
         * deltime : 2017-11-09T15:27:07.683
         * CreatTime : 2017-11-09T11:03:18.693
         * creatUser : 曹佳琪
         * ShopName : 台州大超市旗舰店
         * phone : 15867083398
         * address : 浙江省台州市椒江区东环大道568号靠近台州创业服务园·五联园区
         * contact : 曹佳琪
         * contactPhone : 15867083398
         * email :
         * fax :
         * withinType : null
         * serviceTime : null
         * logo : C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopLogo_7.jpg
         * baneer : C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopBanner_7.jpg
         * bankgroud : C://web/HT/eShop.jjsqwg.com/images/eShop/ShopPics/ShopBackGround_7.jpg
         * industry : 20
         * note : 一个十分可爱的商家
         * discountMax : null
         * discountReal : 100
         * IsSendMoney : 1
         * MinSendMoney : 10.0
         * DefaultSendMoney : 11.0
         * PositionX : 121.4269892324
         * PositionY : 28.641665
         * cartimg : C://ApplicationsImg/0.jpeg|
         * otherimg : C://ApplicationsImg/1.jpeg|
         * classid : 20
         * ispass : 2
         * premium : null
         * ispay : 0
         * provincesid : 34
         * cityid : 7
         * regionid : 123
         * adminid : 18
         * provincesname : 浙江
         * cityname : 台州市
         * regionname : 椒江区
         * classname : 生活超市 - 社区超市
         * closingtime : null
         * openingtime : null
         * worktimeBegin : 07:35
         * worktimeEnd : 19:00
         * LogoWeb : images/eShop/ShopPics/ShopLogo_7.jpg
         * baneerWeb : images/eShop/ShopPics/ShopBanner_7.jpg
         * bankgroudWeb : images/eShop/ShopPics/ShopBackGround_7.jpg
         * commissionRatio : 0
         * ServiceType : 0
         * shopstore : null
         * cartimgWeb : null
         * otherimgWeb : null
         * bSelfSendProd : 1
         * EntityKey : {"$id":"2","EntitySetName":"De_Shop","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"id","Type":"System.Int64","Value":"7"}]}
         */

        private String $id;
        private int id;
        private int Isdelete;
        private String deltime;
        private String CreatTime;
        private String creatUser;
        private String ShopName;
        private String phone;
        private String address;
        private String contact;
        private String contactPhone;
        private String email;
        private String fax;
        private Object withinType;
        private Object serviceTime;
        private String logo;
        private String baneer;
        private String bankgroud;
        private int industry;
        private String note;
        private Object discountMax;
        private int discountReal;
        private int IsSendMoney;
        private double MinSendMoney;
        private double DefaultSendMoney;
        private double PositionX;
        private double PositionY;
        private String cartimg;
        private String otherimg;
        private String classid;
        private int ispass;
        private Object premium;
        private int ispay;
        private int provincesid;
        private int cityid;
        private int regionid;
        private int adminid;
        private String provincesname;
        private String cityname;
        private String regionname;
        private String classname;
        private Object closingtime;
        private Object openingtime;
        private String worktimeBegin;
        private String worktimeEnd;
        private String LogoWeb;
        private String baneerWeb;
        private String bankgroudWeb;
        private int commissionRatio;
        private int ServiceType;
        private Object shopstore;
        private Object cartimgWeb;
        private Object otherimgWeb;
        private int bSelfSendProd;
        private EntityKeyBean EntityKey;

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

        public int getIsdelete() {
            return Isdelete;
        }

        public void setIsdelete(int Isdelete) {
            this.Isdelete = Isdelete;
        }

        public String getDeltime() {
            return deltime;
        }

        public void setDeltime(String deltime) {
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

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getBaneer() {
            return baneer;
        }

        public void setBaneer(String baneer) {
            this.baneer = baneer;
        }

        public String getBankgroud() {
            return bankgroud;
        }

        public void setBankgroud(String bankgroud) {
            this.bankgroud = bankgroud;
        }

        public int getIndustry() {
            return industry;
        }

        public void setIndustry(int industry) {
            this.industry = industry;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public Object getDiscountMax() {
            return discountMax;
        }

        public void setDiscountMax(Object discountMax) {
            this.discountMax = discountMax;
        }

        public int getDiscountReal() {
            return discountReal;
        }

        public void setDiscountReal(int discountReal) {
            this.discountReal = discountReal;
        }

        public int getIsSendMoney() {
            return IsSendMoney;
        }

        public void setIsSendMoney(int IsSendMoney) {
            this.IsSendMoney = IsSendMoney;
        }

        public double getMinSendMoney() {
            return MinSendMoney;
        }

        public void setMinSendMoney(double MinSendMoney) {
            this.MinSendMoney = MinSendMoney;
        }

        public double getDefaultSendMoney() {
            return DefaultSendMoney;
        }

        public void setDefaultSendMoney(double DefaultSendMoney) {
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

        public String getClassid() {
            return classid;
        }

        public void setClassid(String classid) {
            this.classid = classid;
        }

        public int getIspass() {
            return ispass;
        }

        public void setIspass(int ispass) {
            this.ispass = ispass;
        }

        public Object getPremium() {
            return premium;
        }

        public void setPremium(Object premium) {
            this.premium = premium;
        }

        public int getIspay() {
            return ispay;
        }

        public void setIspay(int ispay) {
            this.ispay = ispay;
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

        public Object getClosingtime() {
            return closingtime;
        }

        public void setClosingtime(Object closingtime) {
            this.closingtime = closingtime;
        }

        public Object getOpeningtime() {
            return openingtime;
        }

        public void setOpeningtime(Object openingtime) {
            this.openingtime = openingtime;
        }

        public String getWorktimeBegin() {
            return worktimeBegin;
        }

        public void setWorktimeBegin(String worktimeBegin) {
            this.worktimeBegin = worktimeBegin;
        }

        public String getWorktimeEnd() {
            return worktimeEnd;
        }

        public void setWorktimeEnd(String worktimeEnd) {
            this.worktimeEnd = worktimeEnd;
        }

        public String getLogoWeb() {
            return LogoWeb;
        }

        public void setLogoWeb(String LogoWeb) {
            this.LogoWeb = LogoWeb;
        }

        public String getBaneerWeb() {
            return baneerWeb;
        }

        public void setBaneerWeb(String baneerWeb) {
            this.baneerWeb = baneerWeb;
        }

        public String getBankgroudWeb() {
            return bankgroudWeb;
        }

        public void setBankgroudWeb(String bankgroudWeb) {
            this.bankgroudWeb = bankgroudWeb;
        }

        public int getCommissionRatio() {
            return commissionRatio;
        }

        public void setCommissionRatio(int commissionRatio) {
            this.commissionRatio = commissionRatio;
        }

        public int getServiceType() {
            return ServiceType;
        }

        public void setServiceType(int ServiceType) {
            this.ServiceType = ServiceType;
        }

        public Object getShopstore() {
            return shopstore;
        }

        public void setShopstore(Object shopstore) {
            this.shopstore = shopstore;
        }

        public Object getCartimgWeb() {
            return cartimgWeb;
        }

        public void setCartimgWeb(Object cartimgWeb) {
            this.cartimgWeb = cartimgWeb;
        }

        public Object getOtherimgWeb() {
            return otherimgWeb;
        }

        public void setOtherimgWeb(Object otherimgWeb) {
            this.otherimgWeb = otherimgWeb;
        }

        public int getBSelfSendProd() {
            return bSelfSendProd;
        }

        public void setBSelfSendProd(int bSelfSendProd) {
            this.bSelfSendProd = bSelfSendProd;
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
             * EntityKeyValues : [{"Key":"id","Type":"System.Int64","Value":"7"}]
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
                 * Value : 7
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

package com.jitu.shop;

/**
 * 常量工具类
 * Created by dell on 2016/4/5.
 */
public class AppConstant {

//      "1": "手机号码或密码错误",
//      "2": "传入参数异常",
//      "3": "两次密码不同",
//      "4": "不存在此数据",
//      "101": "秘钥错误",
//      "400": "数据库异常"
    public static final String BASE_URL = "http://112.74.172.152:999";//富邦直播

    public static final String DOWNLOAD_URL = "121.43.153.125:92/download/yaoyao.apk";//下载最新app地址

    public static final String USERNAME = "username";
    public static final String USERPIC = "userpic";
    public static final String OBJECT = "onject";
    public static final String USERID = "userid";
    public static final String TOKEN = "token";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String VIDEOID = "videoid";
    public static final String NKNUM = "nknum";
    public static final String APK_DOWN_LOAD_ID = "apk_id";
    public static final String VERSION = "version";
    public static final String COUNT = "count";
    public static final String CONTENT = "content";
    public static final String PAGE = "page";
    public static final String TYPE = "type";
    public static final long NKTIMES = 100;
    public static final String PRIVINCE = "privince";
    public static final String CITY = "city";
    public static final String ADDRDETAIL = "addrdetail";
    public static final String LAT = "lat";
    public static final String LON = "lon";
    public static final String GENDER = "gender";

    public static final String AUTH_STATE ="auth_state" ;
    public static final String UNPAY_STATE ="unpay_state" ;
    public static final String UNDELIVER_STATE ="undeliver_state" ;
    public static final String DELIVERED_STATE ="delivered_state" ;
    public static final String AFTERSALE_STATE ="aftersale_state" ;
    public static final String CALLFROM = "callfrom";
    public static final String CALLTO = "callto";


    public static final String URL_QUERYMENUS = "/api/Admin/QueryMenus";//查询后台管理菜单
    public static final String URL_QUERYSHOPCLASSS = "/api/Admin/QueryShopClasss";//查商品分类

    public static final String URL_ADDSHOPCLASS = "/api/Admin/AddShopClass";//添加分类
    public static final String URL_REVICESHOPCLASS = "/api/Admin/ReviceShopClass";//修改分类
    public static final String URL_DELSHOPCLASS = "/api/Admin/DelShopClass";//删除分类

    public static final String URL_QUERYPRODUCTS = "/api/Admin/QueryProducts";//查询我的商品
    public static final String URL_BATCHRELEASE = "/api/Admin/BatchRelease";//批量上/下架/删除

    public static final String URL_QUERYPRODUCTDETAILS = "/api/Admin/QueryProductDetails";//查询商品详情
    public static final String URL_ADDSHOPCLASSPRODUCTS = "/api/Admin/AddShopClassProducts";//为分类添加商品
    public static final String URL_QUERYORDERS = "/api/Admin/QueryOrders";//查询订单
    public static final String URL_QUERYORDERDETAILS = "/api/Admin/QueryOrderDetails";//查询订单详情
    public static final String URL_SUBMITNOTE = "/api/Admin/SubmitNote";//提交意见
    public static final String URL_QUERYNOTICES = "/api/Admin/QueryNotices";//查询我的消息

    //Home
    public static final String URL_USERREVICEPASSWORD = "/api/Home/UserRevicePassword";//用户修改密码
    public static final String URL_ADMINLOGIN = "/api/Home/AdminLogin";//商家登录
    public static final String URL_ADMINREVICEPASSWORD = "/api/Home/AdminRevicePassword";//用户修改密码

    //认证
    public static final String URL_ADMINAUTHENTICATION = "/api/Admin/Authentication";//提交认证信息
    public static final String URL_ADMINAUTHINFO = "/api/Admin/QueryAuthentication";//获取认证信息

    //地区信息
    public static final String URL_ADMINQUERYALLPATH = "/api/Admin/QueryAllpath";//获取地区信息

    //行业分类
    public static final String URL_ADMINQUERYINDUSTRIES= "/api/Admin/QueryIndustries";//获取地区信息


    //获取图片前缀地址
    public static final String IMAGPATH= BASE_URL+"/api/Tool/GetImg/?path=";//获取地区信息

    public static final String URL_QUERYMYSTATE= BASE_URL+"/api/Admin/QueryMyState"; //首页获取我的状态

}

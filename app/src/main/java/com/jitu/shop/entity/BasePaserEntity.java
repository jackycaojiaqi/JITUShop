package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/8/31.
 */
public class BasePaserEntity {


    /**
     * Token : null
     */

    private String Token;
    private int ErrorCode;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        ErrorCode = errorCode;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

}

package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/8/28.
 */
public class ChangePassEntity {


    /**
     * ErrorCode : 0
     * Token : string
     * Result : {}
     * Count : 0
     */

    private int ErrorCode;
    private String Token;
    private ResultBean Result;
    private int Count;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

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
    }
}

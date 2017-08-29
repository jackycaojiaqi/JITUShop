package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/8/28.
 */
public class LoginEntity {


    /**
     * ErrorCode : 0
     * Token : C3F2DD5430CB9233A66BE0473A414BACCE5B7708667FEF2873192C129EBBF73F1CA0820FC5AE58A5E0B8B53A0EE3B004E1537755336FCC5160C0A5F0C9EE60982986FB6B6F633973
     * Result : null
     * Count : 0
     */

    private int ErrorCode;
    private String Token;
    private Object Result;
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

    public Object getResult() {
        return Result;
    }

    public void setResult(Object Result) {
        this.Result = Result;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }
}

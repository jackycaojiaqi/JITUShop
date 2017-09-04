package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/8/30.
 */
public class FeedBackEntity extends BasePaserEntity {


    /**
     * ErrorCode : 2
     * Token : null
     * Result : null
     * Count : 0
     */

    private Object Result;
    private int Count;



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

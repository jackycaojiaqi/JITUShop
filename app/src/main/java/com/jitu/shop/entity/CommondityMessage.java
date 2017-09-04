package com.jitu.shop.entity;

/**
 * Created by jacky on 2017/9/2.
 */
public class CommondityMessage {
    private int page_num;
    private String action_type;

    public int getPage_num() {
        return page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public CommondityMessage(int page_num, String action_type) {
        this.page_num = page_num;
        this.action_type = action_type;
    }
}

package com.jitu.shop.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jacky on 2017/9/1.
 */
public class ClassifyEntity extends BasePaserEntity {


    /**
     * Token : null
     * Result : [{"id":10,"Name":"平台分类1","parentid":0,"subclass":[]},{"id":11,"Name":"平台分类2","parentid":0,"subclass":[]},{"id":12,"Name":"平台分类3","parentid":0,"subclass":[]},{"id":13,"Name":"店铺分类1","parentid":0,"subclass":[]},{"id":14,"Name":"店铺分类2","parentid":0,"subclass":[]},{"id":15,"Name":"店铺分类2","parentid":0,"subclass":[]},{"id":16,"Name":"平台分类4","parentid":0,"subclass":[]},{"id":17,"Name":"平台分类5","parentid":0,"subclass":[]},{"id":18,"Name":"平台分类6","parentid":0,"subclass":[]}]
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
         * id : 10
         * Name : 平台分类1
         * parentid : 0
         * subclass : []
         */

        private int id;
        private String Name;
        private int parentid;
        private List<?> subclass;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getParentid() {
            return parentid;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }

        public List<?> getSubclass() {
            return subclass;
        }

        public void setSubclass(List<?> subclass) {
            this.subclass = subclass;
        }
    }
}

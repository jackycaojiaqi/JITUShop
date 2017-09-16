package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/16.
 */
public class ShopTypeEntity extends BasePaserEntity {


    /**
     * Result : [{"id":13,"name":"生活服务"}]
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
        public ResultBean(int id, String name, boolean is_show_line) {
            this.id = id;
            this.name = name;
            this.is_show_line = is_show_line;
        }

        /**
         * id : 13
         * name : 生活服务
         */

        private int id;
        private String name;
        private boolean is_show_line = false;

        public boolean is_show_line() {
            return is_show_line;
        }

        public void setIs_show_line(boolean is_show_line) {
            this.is_show_line = is_show_line;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/8/28.
 */
public class MainMenuEntity {


    /**
     * ErrorCode : 0
     * Token : null
     * Result : {"menus":[{"$id":"1","CM_MenuId":1,"CM_MenuName":"订单管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"2","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"1"}]}},{"$id":"3","CM_MenuId":2,"CM_MenuName":"商品管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"4","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"2"}]}},{"$id":"5","CM_MenuId":3,"CM_MenuName":"提现管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"6","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"3"}]}},{"$id":"7","CM_MenuId":4,"CM_MenuName":"商家管理","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"8","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"4"}]}},{"$id":"9","CM_MenuId":5,"CM_MenuName":"经营状况","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"10","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"5"}]}},{"$id":"11","CM_MenuId":6,"CM_MenuName":"消息中心","CM_ImgPath":"","CM_Url":"","CM_Type":0,"CM_State":0,"EntityKey":{"$id":"12","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"6"}]}}],"loops":[{"$id":"13","CM_LoopId":3,"CM_ImgPath":"C://IMG/3.jpg","CM_Url":"www.baidu.com","CM_Type":0,"CM_IsFirst":1,"EntityKey":{"$id":"14","EntitySetName":"TB_Loops","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LoopId","Type":"System.Int32","Value":"3"}]}},{"$id":"15","CM_LoopId":2,"CM_ImgPath":"C://IMG/2.jpg","CM_Url":"www.baidu.com","CM_Type":0,"CM_IsFirst":1,"EntityKey":{"$id":"16","EntitySetName":"TB_Loops","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LoopId","Type":"System.Int32","Value":"2"}]}},{"$id":"17","CM_LoopId":1,"CM_ImgPath":"C://IMG/1.jpg","CM_Url":"www.baidu.com","CM_Type":0,"CM_IsFirst":1,"EntityKey":{"$id":"18","EntitySetName":"TB_Loops","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LoopId","Type":"System.Int32","Value":"1"}]}}]}
     * Count : 0
     */

    private int ErrorCode;
    private Object Token;
    private ResultBean Result;
    private int Count;

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public Object getToken() {
        return Token;
    }

    public void setToken(Object Token) {
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
        private List<MenusBean> menus;
        private List<LoopsBean> loops;

        public List<MenusBean> getMenus() {
            return menus;
        }

        public void setMenus(List<MenusBean> menus) {
            this.menus = menus;
        }

        public List<LoopsBean> getLoops() {
            return loops;
        }

        public void setLoops(List<LoopsBean> loops) {
            this.loops = loops;
        }

        public static class MenusBean {
            /**
             * $id : 1
             * CM_MenuId : 1
             * CM_MenuName : 订单管理
             * CM_ImgPath :
             * CM_Url :
             * CM_Type : 0
             * CM_State : 0
             * EntityKey : {"$id":"2","EntitySetName":"TB_AdminMenu","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_MenuId","Type":"System.Int32","Value":"1"}]}
             */

            private String $id;
            private int CM_MenuId;
            private String CM_MenuName;
            private String CM_ImgPath;
            private String CM_Url;
            private int CM_Type;
            private int CM_State;
            private EntityKeyBean EntityKey;
            private boolean is_show_spot;

            public boolean is_show_spot() {
                return is_show_spot;
            }

            public void setIs_show_spot(boolean is_show_spot) {
                this.is_show_spot = is_show_spot;
            }

            public String get$id() {
                return $id;
            }

            public void set$id(String $id) {
                this.$id = $id;
            }

            public int getCM_MenuId() {
                return CM_MenuId;
            }

            public void setCM_MenuId(int CM_MenuId) {
                this.CM_MenuId = CM_MenuId;
            }

            public String getCM_MenuName() {
                return CM_MenuName;
            }

            public void setCM_MenuName(String CM_MenuName) {
                this.CM_MenuName = CM_MenuName;
            }

            public String getCM_ImgPath() {
                return CM_ImgPath;
            }

            public void setCM_ImgPath(String CM_ImgPath) {
                this.CM_ImgPath = CM_ImgPath;
            }

            public String getCM_Url() {
                return CM_Url;
            }

            public void setCM_Url(String CM_Url) {
                this.CM_Url = CM_Url;
            }

            public int getCM_Type() {
                return CM_Type;
            }

            public void setCM_Type(int CM_Type) {
                this.CM_Type = CM_Type;
            }

            public int getCM_State() {
                return CM_State;
            }

            public void setCM_State(int CM_State) {
                this.CM_State = CM_State;
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
                 * EntitySetName : TB_AdminMenu
                 * EntityContainerName : JJCommunityEntities
                 * EntityKeyValues : [{"Key":"CM_MenuId","Type":"System.Int32","Value":"1"}]
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
                     * Key : CM_MenuId
                     * Type : System.Int32
                     * Value : 1
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

        public static class LoopsBean {
            /**
             * $id : 13
             * CM_LoopId : 3
             * CM_ImgPath : C://IMG/3.jpg
             * CM_Url : www.baidu.com
             * CM_Type : 0
             * CM_IsFirst : 1
             * EntityKey : {"$id":"14","EntitySetName":"TB_Loops","EntityContainerName":"JJCommunityEntities","EntityKeyValues":[{"Key":"CM_LoopId","Type":"System.Int32","Value":"3"}]}
             */

            private String $id;
            private int CM_LoopId;
            private String CM_ImgPath;
            private String CM_Url;
            private int CM_Type;
            private int CM_IsFirst;
            private EntityKeyBeanX EntityKey;

            public String get$id() {
                return $id;
            }

            public void set$id(String $id) {
                this.$id = $id;
            }

            public int getCM_LoopId() {
                return CM_LoopId;
            }

            public void setCM_LoopId(int CM_LoopId) {
                this.CM_LoopId = CM_LoopId;
            }

            public String getCM_ImgPath() {
                return CM_ImgPath;
            }

            public void setCM_ImgPath(String CM_ImgPath) {
                this.CM_ImgPath = CM_ImgPath;
            }

            public String getCM_Url() {
                return CM_Url;
            }

            public void setCM_Url(String CM_Url) {
                this.CM_Url = CM_Url;
            }

            public int getCM_Type() {
                return CM_Type;
            }

            public void setCM_Type(int CM_Type) {
                this.CM_Type = CM_Type;
            }

            public int getCM_IsFirst() {
                return CM_IsFirst;
            }

            public void setCM_IsFirst(int CM_IsFirst) {
                this.CM_IsFirst = CM_IsFirst;
            }

            public EntityKeyBeanX getEntityKey() {
                return EntityKey;
            }

            public void setEntityKey(EntityKeyBeanX EntityKey) {
                this.EntityKey = EntityKey;
            }

            public static class EntityKeyBeanX {
                /**
                 * $id : 14
                 * EntitySetName : TB_Loops
                 * EntityContainerName : JJCommunityEntities
                 * EntityKeyValues : [{"Key":"CM_LoopId","Type":"System.Int32","Value":"3"}]
                 */

                private String $id;
                private String EntitySetName;
                private String EntityContainerName;
                private List<EntityKeyValuesBeanX> EntityKeyValues;

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

                public List<EntityKeyValuesBeanX> getEntityKeyValues() {
                    return EntityKeyValues;
                }

                public void setEntityKeyValues(List<EntityKeyValuesBeanX> EntityKeyValues) {
                    this.EntityKeyValues = EntityKeyValues;
                }

                public static class EntityKeyValuesBeanX {
                    /**
                     * Key : CM_LoopId
                     * Type : System.Int32
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
}

package com.jitu.shop.entity;

import java.util.List;

/**
 * Created by jacky on 2017/9/14.
 */
public class CityEntity extends BasePaserEntity {


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

        private int ProvinceID;
        private String ProvinceName;
        private List<TBCityBean> TB_City;

        public int getProvinceID() {
            return ProvinceID;
        }

        public void setProvinceID(int ProvinceID) {
            this.ProvinceID = ProvinceID;
        }

        public String getProvinceName() {
            return ProvinceName;
        }

        public void setProvinceName(String ProvinceName) {
            this.ProvinceName = ProvinceName;
        }

        public List<TBCityBean> getTB_City() {
            return TB_City;
        }

        public void setTB_City(List<TBCityBean> TB_City) {
            this.TB_City = TB_City;
        }

        public static class TBCityBean {
            /**
             * CityID : 46
             * CityName : 亳州市
             * TB_Region : [{"CountyID":3154,"CountyName":"辖区"},{"CountyID":3155,"CountyName":"谯城区"},{"CountyID":3297,"CountyName":"涡阳县"},{"CountyID":3298,"CountyName":"蒙城县"},{"CountyID":3329,"CountyName":"利辛县"},{"CountyID":3601,"CountyName":"辖区"}]
             */

            private int CityID;
            private String CityName;
            private List<TBRegionBean> TB_Region;

            public int getCityID() {
                return CityID;
            }

            public void setCityID(int CityID) {
                this.CityID = CityID;
            }

            public String getCityName() {
                return CityName;
            }

            public void setCityName(String CityName) {
                this.CityName = CityName;
            }

            public List<TBRegionBean> getTB_Region() {
                return TB_Region;
            }

            public void setTB_Region(List<TBRegionBean> TB_Region) {
                this.TB_Region = TB_Region;
            }

            public static class TBRegionBean {
                /**
                 * CountyID : 3154
                 * CountyName : 辖区
                 */

                private int CountyID;
                private String CountyName;

                public int getCountyID() {
                    return CountyID;
                }

                public void setCountyID(int CountyID) {
                    this.CountyID = CountyID;
                }

                public String getCountyName() {
                    return CountyName;
                }

                public void setCountyName(String CountyName) {
                    this.CountyName = CountyName;
                }
            }
        }
    }
}

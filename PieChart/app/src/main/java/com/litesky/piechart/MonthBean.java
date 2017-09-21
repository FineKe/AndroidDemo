package com.litesky.piechart;

import java.util.ArrayList;

/**
 * Created by finefine.com on 2017/9/19.
 */

public class MonthBean {
    public String date;
    public ArrayList<PieBean> obj;

    class PieBean {
        public String title;
        public String value;

        @Override
        public String toString() {
            return "PieBean{" +
                    "title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<PieBean> getObj() {
        return obj;
    }

    public void setObj(ArrayList<PieBean> obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "MonthBean{" +
                "date='" + date + '\'' +
                ", obj=" + obj.toString() +
                '}';
    }
}

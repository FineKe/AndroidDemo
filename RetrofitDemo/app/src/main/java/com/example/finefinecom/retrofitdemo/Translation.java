package com.example.finefinecom.retrofitdemo;

/**
 * Created by finefine.com on 2017/8/27.
 */

public class Translation {
    private int status;

    private Content content;

    private static class Content
    {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println(status);

        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }
}

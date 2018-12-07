package cn.darkbluestudio.javaandkotlin.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by shaochuanxian on 2018/12/5.
 * ThreadLocal的学习.
 *
 */

public class ThreadLocalTest {

    /**
     * 用SimpleDateFormat的例子来阐述
     * ThreadLocal的详细信息见有道云笔记
     */

    private final ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }

        @Override
        public void set(SimpleDateFormat value) {
            super.set(value);
        }

        @Override
        public void remove() {
            super.remove();
        }
    };



    public void printDate(){
        final String dateTime = "2016-12-30 15:35:34";
        new Thread(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat format = dateFormatter.get();
                System.err.println("---formatter---" + format + ",thread ID:" + Thread.currentThread());
                try {
                    System.err.println("时间格式化为：" + format.parse(dateTime));
                } catch (ParseException e) {
                    System.err.println("parse exception:" + e.getMessage());
                }

                dateFormatter.remove();
            }
        }).start();
    }
}

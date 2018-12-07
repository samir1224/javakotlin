package cn.darkbluestudio.javaandkotlin.java;

import org.junit.Test;

/**
 * Created by shaochuanxian on 2018/12/6.
 */
public class ThreadLocalTestTest {

    @Test
    public void testThreadLocal() {
        for(int i =0; i < 10; i++) {
            System.err.println("--------第" + i + "次调用formatter--------");
            new ThreadLocalTest().printDate();
        }
    }

}
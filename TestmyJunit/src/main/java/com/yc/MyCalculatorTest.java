package com.yc;

import com.yc.biz.Calculator;
import com.yc.junit.*;

/**
 * @program: ReflactionAndAnotation
 * @author: 作者
 * @create: 2021-03-31 20:25
 */
public class MyCalculatorTest {
    private Calculator cal; //待测试的单元
    @MybeforeClass
    public  static  void bc(){
        System.out.println("beforeClass");
    }

    @Mybefore
    public void setUp() throws Exception {
        System.out.println("before");
        cal =new Calculator();
    }

    @Myafter
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @MyTest
    public void add() {
        System.out.println("add测试");


    }

    @MyTest
    public void sub() {
        System.out.println("sub测试");
    }
    @MyafterClass
    public static  void ac(){
        System.out.println("afterClass");
    }
}

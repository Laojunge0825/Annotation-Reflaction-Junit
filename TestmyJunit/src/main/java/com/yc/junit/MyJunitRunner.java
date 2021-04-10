package com.yc.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ReflactionAndAnotation
 * @author: 作者
 * @create: 2021-03-31 20:06
 */
public class MyJunitRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException {
        //因为没有idea插件  只能先做 class加载
        Class cls=Class.forName("com.yc.MyCalculatorTest");
        //TODO: 按照 maven约定的目录来扫描  test/java 下的单元测试类
        //1.获取这个类中的所有方法
        Method [] ms=cls.getDeclaredMethods();
        List <Method> testMethods=new ArrayList<Method>();
        Method beforeMethod =null;
        Method AfterMethod =null;
        Method beforeClassMethod =null;
        Method afterClassMethod=null;
        //2.  循环这些方法  判断  上面加了那个注解
        for (Method m:ms){

            //3. 将这些方法分别存好  @Test对应的方法有多个  存到一个集合中 其他注解对应的方法只有一个人  直接存
            if(m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m);
            }
            if(m.isAnnotationPresent(Mybefore.class)){
                beforeMethod=m;
            }if(m.isAnnotationPresent(Myafter.class)){
               AfterMethod =m;
            }if(m.isAnnotationPresent(MybeforeClass.class)){
                beforeClassMethod =m;
            }if(m.isAnnotationPresent(MyafterClass.class)){
                afterClassMethod =m;
            }


        }

        //4.按junit 的生命周期来调用
        if(testMethods ==null||testMethods.size()<=0){
            throw new RuntimeException("没有要测试的方法");
        }
        Object o=cls.newInstance(); //实例话测试类
        beforeClassMethod.invoke(o,null);
        for(Method m:testMethods){
            if(beforeMethod!=null){
                beforeMethod.invoke(o,null);
            }
            m.invoke(o,null);
            if(AfterMethod!=null){
                AfterMethod.invoke(o,null);
            }
        }
        afterClassMethod.invoke(o,null);
    }
}

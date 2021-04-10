package com.yc;

/**
 * @program: ReflactionAndAnotation
 * @author: 作者
 * @create: 2021-03-29 19:59
 */
public class Person implements Showable {
    private String name;
    private int age;
    public void person(){
        System.out.println("无参构造方法");
    }
    public void person(String name){
        this.name=name;
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void show() {
        System.out.println("show");
    }
}

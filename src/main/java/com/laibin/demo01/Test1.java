package com.laibin.demo01;

public class Test1 {
    public static void main(String[] args) {
        //获取CPU核数
        //CPU密集型 IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

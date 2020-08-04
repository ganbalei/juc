package com.laibin.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum  EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance = EnumSingle.INSTANCE;
        //没有无参构造 命令行使用javap -p *.java 查看 .class文件
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        EnumSingle enumSingle = constructor.newInstance();

        System.out.println(instance);
        System.out.println(enumSingle);
    }
}

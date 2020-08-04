package com.laibin.single;

/**
 * 静态内部类方试创建单例模式
 */
public class StaticSingle {
    private static class Single{
        private static final StaticSingle staticSingle = new StaticSingle();
    }

    public StaticSingle getInstance(){
        return Single.staticSingle;
    }
}

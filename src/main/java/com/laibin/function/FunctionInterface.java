package com.laibin.function;

import java.util.function.Function;

/**
 * 函数式接口 Function
 * public interface Function<T, R> {}
 * R apply(T t);
 */
public class FunctionInterface {
    public static void main(String[] args) {

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        Function<String, String> function1 = str->{return str;};

        System.out.println(function.apply("llll"));
        System.out.println(function1.apply("1111"));
    }
}

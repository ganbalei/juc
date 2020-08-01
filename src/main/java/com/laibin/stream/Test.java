package com.laibin.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 现有5个用户，筛选：
 * 1. id 必须是偶数
 * 2. 年龄大于23岁
 * 3.用户名转为大写字母
 * 4.用户名字母倒序排序
 * 5.只输出一个用户
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "asfd", 12);
        User u2 = new User(2, "assfd", 42);
        User u3 = new User(3, "sasfd", 22);
        User u4 = new User(4, "asfsd", 62);
        User u5 = new User(5, "asfds", 25);

        List<User> userList = Arrays.asList(u1, u2, u3, u4, u5);

        userList.stream()
                .filter(u->{return u.getId()%2 == 0;})
                .filter(u->{return u.getAge() > 23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((uu1, uu2)->uu1.compareTo(uu2))
                .limit(1)
                .forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class User{
    private Integer id;
    private String name;
    private Integer age;
}
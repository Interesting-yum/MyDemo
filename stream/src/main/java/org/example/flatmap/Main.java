package org.example.flatmap;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: org.example.flatmap.Main
 * @title: Main
 * @description: Stream.flatMap
 * @author: LiuYun
 * @datetime: 2022/10/22 23:29
 * @version: 1.0.0
 */
@Slf4j
public class Main {

    private static List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User("张三", "唱歌,跳舞,rap"));
        list.add(new User("李四", "唱歌,篮球,rap"));
        list.add(new User("王五", "跳舞,篮球,练习生"));
        return list;
    }

    public static void main(String[] args) {
        // 例子：求所有人的爱好并去重，返回一个List
        List<User> list = getUsers();
        List<String> collect = list.stream().flatMap(x -> Arrays.stream(x.getHobby().split(","))).distinct()
                .collect(Collectors.toList());
        log.info("结果：{}", collect);
    }
}

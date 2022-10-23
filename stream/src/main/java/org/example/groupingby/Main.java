package org.example.groupingby;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @className: org.example.flatmap.Main
 * @title: Main
 * @description: Collectors.groupingBy
 * @author: LiuYun
 * @datetime: 2022/10/22 23:29
 * @version: 1.0.0
 */
@Slf4j
public class Main {

    private static List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(new User("张三", "唱歌,跳舞,rap", 15, "男"));
        list.add(new User("李四", "唱歌,篮球,rap", 20, "男"));
        list.add(new User("王五", "跳舞,篮球,练习生", 30, "男"));
        list.add(new User("小红", "跳舞,篮球,看书", 25, "女"));
        list.add(new User("小花", "跳舞,篮球,看书", 29, "女"));
        return list;
    }

    public static void main(String[] args) {

        // 例子1：将所有人按年龄奇偶来分组
        List<User> list = getUsers();
        Map<Integer, List<User>> map = list.stream().collect(Collectors.groupingBy(u -> u.getAge() % 2));
        log.info("结果：{}", map);

        // 例子2：按单个属性分组
        Map<String, List<User>> map1 = list.stream().collect(Collectors.groupingBy(User::getName));
        log.info("结果：{}", map1);

        // 例子3：按多个属性分组
        Map<String, Map<Integer, List<User>>> map2 = list.stream().collect(Collectors.groupingBy(User::getName, Collectors.groupingBy(User::getAge)));
        log.info("结果：{}", map2);

        // 例子4：按爱好分组，并计算年龄平均值
        Map<String, Double> map3 = list.stream().collect(Collectors.groupingBy(User::getHobby, Collectors.averagingInt(User::getAge)));
        log.info("结果：{}", map3);

        // 例子4：求每个爱好的数量
        Map<String, Long> map4 = list.stream().collect(Collectors.groupingBy(User::getHobby, Collectors.counting()));
        log.info("结果：{}", map4);

        // 例子5：求每个性别的年龄之和
        Map<String, Integer> map5 = list.stream().collect(Collectors.groupingBy(User::getGender, Collectors.summingInt(User::getAge)));
        log.info("结果：{}", map5);

        // 例子6：对性别分组，再按年龄奇偶分组
        Map<String, Map<Boolean, List<Integer>>> map6 = list.stream()
                .collect(Collectors.groupingBy(User::getGender,
                        Collectors.mapping(User::getAge, Collectors.partitioningBy(x -> x % 2 == 0))));
        log.info("结果：{}", map6);

        // 例子7：从给定句子中返回单词长度大于5的单词列表，按长度倒序输出，最多返回3个
        String str = "The session approved the secretary, deputy secretaries and members of the Standing Committee of the Central Commission for Discipline Inspection (CCDI) elected at the first plenary session of the 20th CCDI";
        List<String> list1 = Arrays.stream(str.replace(",", "").split(" "))
                .filter(x -> x.length() > 5)
                .sorted((x, y) -> y.length() - x.length())
                .limit(3)
                .collect(Collectors.toList());
        log.info("结果：{}", list1);


    }
}

package com.java8onAction;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: javademo
 * @description: 函数编程实战
 * @author: chenp
 * @create: 2019-03-16 15:58
 **/
public class FunctionProgram {

    /**
     * 给定一个列表List<value>，比如{1, 4,
     * 9}，构造一个List<List<Integer>>，它的成员都是类表{1, 4, 9}的子集——我们暂时不考虑
     * 元素的顺序。{1, 4, 9}的子集是{1, 4, 9}、{1, 4}、{1, 9}、{4, 9}、{1}、{4}、{9}以及{}。
     * 包括空子集在内，这样的子集总共有8个。每个子集都使用List<Integer>表示，这就是答
     * 案中期望的List<List<Integer>>类型
     */
    static List<List<Integer>> subsets(List<Integer> lists) {
        if (lists.isEmpty()) {
            List<List<Integer>> listList = new ArrayList<>();
            listList.add(Collections.emptyList());
            return listList;
        }
        Integer first = lists.get(0);
        List<Integer> secLists = lists.subList(1, lists.size());

        List<List<Integer>> subsets = subsets(secLists);

        class ThisMethod {
            //声明式
            public List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
                for (int i = 0; i < lists.size(); i++) {
                    lists.get(0).add(first);
                }
                return lists;
            }

            //函数式 不改变参数
            public List<List<Integer>> insertAll2(Integer first, List<List<Integer>> lists) {
                List<List<Integer>> result = new ArrayList<>();

                for (List<Integer> list : lists) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(first);
                    temp.addAll(list);
                    result.add(temp);
                }
                return result;
            }
        }
        List<List<Integer>>  s = new ThisMethod().insertAll(first, subsets);
        return null;
    }
}
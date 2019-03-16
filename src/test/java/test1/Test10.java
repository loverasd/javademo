package test1;

import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-19 12:34
 * @description:
 **/
public class Test10 {
    @Test
    public void test2(){
        String[] split = "123131.123weq".split("\\.");
        System.out.println(split[0]);

    }
    @Test
    public void test3(){
        Collection<String> collection =  null;
        String s = collection.stream().findFirst().get();
        System.out.println(s);
    }

}
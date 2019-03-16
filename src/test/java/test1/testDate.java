package test1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.DelayQueue;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-10 18:32
 * @description:
 **/
public class testDate {
    @Test
    public void test() {
        String path = "D:\\dev-idea\\tomcat-hx\\webapps\\print\\PrintProduct";
       
        LocalDate localDate = LocalDate.now();
        String dateDir =path+File.separator+localDate.toString();
        System.out.println(localDate.toString());
        File file = new File(dateDir);
        if (!file.exists()){
            file.mkdir();
        }
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        Object[] objects = Arrays.stream(file.listFiles()).parallel().filter(s -> s.isDirectory() && s.getName().contains(dateDir)).toArray();
        if (objects.length>1 && objects instanceof File[]){


        }

    }
    @Test
    public void Test1(){

       DelayQueue delayQueue = new DelayQueue();
//       delayQueue.

    }
}
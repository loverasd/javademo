package test1;

import myreflection.service.DynamicBean;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-10 13:56
 * @description:
 **/
public class TestFile {
    @Test
    public void test(){
        String localhost = "D:\\dev-idea\\tomcat-hx\\webapps\\artifacts\\print\\PrintProduct\\ElecDownFile";
        File file = new File(localhost);
        File[] files = file.listFiles();
        for (File file1: files){
            if (file1.isFile() && file1.getName().contains("P440005202018000210")){
                System.out.println(file1.getName());
                System.out.println(file1);
            }
        }
    }
    @Test
    public void test2(){
        DynamicBean dynamicBean = new DynamicBean();

    }
}
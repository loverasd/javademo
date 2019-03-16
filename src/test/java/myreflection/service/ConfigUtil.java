package myreflection.service;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.validation.constraints.Size;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-19 14:35
 **/
public class ConfigUtil {
    public static void main(String[] args) throws Exception {
        ConfigUtil configUtil = new ConfigUtil();
        configUtil.getPacket("");
    }

    public void getPacket(String xmlPath) throws DocumentException, CannotCompileException, InstantiationException, NotFoundException, IllegalAccessException, NoSuchFieldException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\Workspaces\\idea\\demo-java\\src\\main\\resources\\guangdong.xml"));
        Element root = document.getRootElement();
        String packet = root.getName();
        String body ="Body";
        String head = "Head";

        Element eHead = root.element(head);
        Element eBody = root.element(body);

        List<Element> headChilds = eHead.elements();
        List<Element> bodyChilds = eBody.elements();
        Map<String,Object> packetMap = new HashMap<>();
        Map<String,Object> headMap = new HashMap<>();
        Map<String,Object> bodyMap = new HashMap<>();
        int i=1;
        for (Element h: headChilds){
            headMap.put(h.getName(),"head"+(i++));
        }
        for (Element h: bodyChilds){
            headMap.put(h.getName(),"body"+(i++));
        }

        DynamicCreateObject dynamicCreateObject = new DynamicCreateObject();
        Object hObj = dynamicCreateObject.addField("Head", headMap);
        Object bObj = dynamicCreateObject.addField("Body", bodyMap);


        packetMap.put(head,hObj);
        packetMap.put(body,bObj);

        Object packet1 = dynamicCreateObject.addField("Packet", packetMap);

        System.out.println(packet1.toString());
        System.out.println(packet1.getClass().getName());
        System.out.println(packet1.getClass().getDeclaredField("Head").getName());
        Field head1 = packet1.getClass().getDeclaredField("Head");
        head1.setAccessible(true);
        Object o = head1.get(hObj);
        System.out.println(o.toString());


        Field requestType = head1.getClass().getDeclaredField("RequestType");
        System.out.println("req"+requestType.getName());

        System.out.println("--------");
        Class<?> type = head1.getType();
        head1.setAccessible(true);

    }
}
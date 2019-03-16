package test1;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-07 08:53
 **/
public class App {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println(addStr(10, "<br/>", "as阿萨德dsa阿斯蒂芬fladadasdsjf阿斯蒂芬ljdsljkjlfdsklfd啥地方都是skljdsasfasdfads"));

        String a= addStr(54,"<br>"," 1、保险人将依法报送上述信息到税务机关，根据税收法的有关规定，投保人应当确定此部分信息的真实性，如有信息填写" +
                "错误或虚假，须自行承担由此引起的相关责任！如需保险人开具增值税专用发票，投保人应提供带有统一社会信用代码的营业" +
                "执照或税务登记证证明一般纳税人身份，并应为保险人开具红字发票或作废发票提供必要的支持！2、本保险合同中包含免除保" +
                "险人责任的条款，请投保人认真阅读。3、本保险合同由保险条款、投保单、保险单、批单和特别约定组成。4、根据《保险法》和《反" +
                "洗钱法》相关规定，请投保人如实填写客户信息（包括身份证、手机号码等），保险公司会在投保成功后15日内进行客户回访，请" +
                "予以配合、保险公司将对客户信息严格保密，请放心填写。5、广西保险行业协会提示您，您可以通过广西保险销售从业人员信" +
                "息管理系统（网址http://113.16.194.239/GXLSIP/LSIPWeb_GX_Query_index）或扫描销售人员执业证书二维码查询销售人员信" +
                "息，保障您的知情权。");
        System.out.println(a);
    }

    /**
     * 插入方法
     *
     * @param num
     *            每隔几个字符插入一个字符串
     * @param splitStr
     *            待指定字符串
     * @param str
     *            原字符串
     * @return 插入指定字符串之后的字符串
     * @throws UnsupportedEncodingException
     */
    public static String addStr(int num, String splitStr, String str) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        String temp = str;

        int len = str.length();
        while (len > 0) {
            int idx = getEndIndex(temp, num);
            sb.append(temp.substring(0, idx + 1)).append(splitStr);
            temp = temp.substring(idx + 1);
            len = temp.length();
        }

        return sb.toString();
    }

    /**
     * 两个数字/英文
     *
     * @param str
     *            字符串
     * @param num
     *            每隔几个字符插入一个字符串
     * @return int 最终索引
     * @throws UnsupportedEncodingException
     */
    public static int getEndIndex(String str, double num) throws UnsupportedEncodingException {
        int idx = 0;
        double val = 0.00;
        // 判断是否是英文/中文
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).getBytes("GBK").length >= 2) {
                // 中文字符或符号
                val += 1.00;
            } else {
                // 英文字符或符号
                val += 0.50;
            }
            if (val >= num) {
                idx = i;
                if (val - num == 0.5) {
                    idx = i - 1;
                }
                break;
            }
        }
        if (idx == 0) {
            idx = str.length() - 1;
        }
        return idx;
    }
    @Test
    public void test(){
        Random random = new Random();
        int a = random.nextInt();
        int[] array = new int[100];
        for (int i =0; i<array.length; i++){
            array[i] = random.nextInt(10000);
        }
        for (Integer temp : array){
            System.out.print(temp+" ");
        }

//        System.out.println("------------------s");
        Arrays.stream(array).filter(x ->x>0).sorted().forEach(s -> System.out.print(s+" "));
        System.out.println(a);
    }

    public int[] heapsize(int[] array){
        int heapSize = array.length;
        return null;
    }

}
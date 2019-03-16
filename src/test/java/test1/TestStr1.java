package test1;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-29 20:04
 **/
public class TestStr1 {
    @Test
    public void Test1() throws UnsupportedEncodingException {
        int length = "，".getBytes("GBK").length;
        String s = "1.力蕴汽车咨询服务（上海）有限公司为本保单的第一受益人，未经其事先书面同意，本保单不得被退保／减保或批改（不影响第一受益人权益的批改除外）。2.当一次事故的保险赔款高于人民币5000元时，保险人须征得第一受益人书面同意后方可对保险人支付。";
        String[] s1 = new String[1];

        String s2 = "1.力蕴汽车咨询服务（上海）有限公司为本保单的第一受益人，未经其事先书面同意，本保单不得被退保／减保或批";
        String s3 = "改（不影响第一受益人权益的批改除外）。2.当一次事故的保险赔款高于人民币5000元时，保险人须征得第一受益人";
        System.out.println(s2.length()+"||"+s3.length());
        System.out.println(getEndIndex(s2,55));
        System.out.println(getEndIndex(s3,55));
//        String[] strings = splitRows(s1, 52,"\n");
//        System.out.println(strings[0]);
    }
    /**
     * 分行
     *
     * @param str1
     * @param rowNums
     * @param lineBreak
     * @return
     */

    public String[] splitRows(String[] str1, int rowNums, String lineBreak) throws UnsupportedEncodingException {
        for (int k = 0; k < str1.length; k++) {
            String s = str1[k];
            StringBuilder sb = new StringBuilder();
            int i = s.length();
            while (i > rowNums) {
                int index = getEndIndex(s,rowNums);
                sb.append(s.substring(0, index) + lineBreak);
                System.out.println("index:"+index+"::"+sb.toString());
                s = s.substring(index);
                i = s.length();

            }
            str1[k] = sb.append(s).toString();
//            System.out.println(s);
        }
        return str1;

    }



    /**
     * 插入方法
     *
     * @param num      每隔几个字符插入一个字符串
     * @param splitStr 待指定字符串
     * @param str      原字符串
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
     * @param str 字符串
     * @param num 每隔几个字符插入一个字符串
     * @return int 最终索引
     * @throws UnsupportedEncodingException
     */
    public static int getEndIndex(String str, double num) throws UnsupportedEncodingException {
        int idx = 0;
        double val = 0.00;
        // 判断是否是英文/中文
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).getBytes("gb2312").length >= 2) {
                // 中文字符或符号
                val += 1.00;
            } else {
                // 英文字符或符号
                val += 0.50;
            }


            if (val > num) {
                idx = i;
                if (val - num == 0.5) {
                    idx = i - 1;
                }
                idx = i-1;
                break;
            }
        }
        if (idx == 0) {
            idx = str.length() - 1;
        }
        return idx;
    }
}
package test1;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-06 20:12
 **/
public class TestStr {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String  str ="交强:&nbsp;1、车船税温馨提示:根据车船税征收管理规定，为避免产生车船税滞纳金，此保单请于2019年12月31日前续保。"+
                "\r000shangye000:&nbsp;1、非营业车辆特别约定:保险车辆为非营业用途，如果用于营业运输发生保险事故，保险人不承担赔偿责任。"+
                "\r2、人伤特约：发生保险事故造成人员伤亡的，伤亡人员医疗费用超出《道路交通事故受伤人员临床诊疗指南》和国家基本医疗保险同类医疗费用标准的部分，保险人不负责赔偿。"+
                "\r3、专修厂特别约定：本车未投保指定专修厂特约条款，车辆损失险出险后到专修厂修理的，被保险人自行承担专修厂与非专修厂修理价格的差额部分。"+
                "\r4、VIP特约：尊敬的客户，您已成为我司VIP客户。";

        System.out.println(str.length());

        String[] strs= str.split("000shangye000:&nbsp;");
        String[] str0= strs[0].split("\r");
        String[] str1 = strs[1].split("\r"); //商业险

        System.out.println(str1[1]+":::"+str1[1].length());
        for (int k =0; k<str1.length; k++){
            String s= str1[k];
            StringBuilder sb= new StringBuilder();
            String temp = "";
            int i = s.length();
            int j = 56;
            if (i<=j){
                temp = s;
            }
            while (i > j){
                sb.append(s.substring(0,j)+"\\r");
                temp = s.substring(j);
                i = temp.length();

            }
            str1[k] = sb.append(temp).toString();
            System.out.println(s);
        }
        System.out.println("-----------------");
        for (String s : str1){
            System.out.println(s);
        }
//        String str3 = splitRows(str1,57,"\r");
//        System.out.println(str3);

    }

//    public String  test(String s ){
//        StringBuilder sb = new StringBuilder();
//        int idx=0;
//        for (int i =56 ; i<s.length(); i+=56){
//            sb.append(s.substring(i-56,i+1))
//        }
//
//    }



    public static String[] splitRows(String[] str1,int rowNums,String lineBreak) {
        for (int k =0; k<str1.length; k++){
            String s= str1[k];
            StringBuilder sb= new StringBuilder();
            String temp = "";
            int i = s.length();
            int j = rowNums;
            if (i <= j){
                temp = s;
            }
            while (i > j){
                sb.append(s.substring(0,j)+lineBreak);
                temp = s.substring(j);
                i = temp.length();

            }
            str1[k] = sb.append(temp).toString();
            System.out.println(s);
        }
        return str1;

    }




}
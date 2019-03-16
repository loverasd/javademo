package com.note.myregix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: javademo
 * @description:
 * @author: chenp
 * @create: 2018-09-25 16:11
 **/
public class TestRegex1 {
    public static void main(String[] args) {
        String  str ="交强:&nbsp;1、车船税温馨提示:根据车船税征收管理规定，为避免产生车船税滞纳金，此保单请于2019年12月31日前续保。"+
                "\r000shangye000:&nbsp;1、非营业车辆特别约定:保险车辆为非营业用途，如果用于营业运输发生保险事故，保险人不承担赔偿责任。"+
                "\r2、人伤特约：发生保险事故造成人员伤亡的，伤亡人员医疗费用超出《道路交通事故受伤人员临床诊疗指南》和国家基本医疗保险同类医疗费用标准的部分，保险人不负责赔偿。"+
                "\r3、专修厂特别约定：本车未投保指定专修厂特约条款，车辆损失险出险后到专修厂修理的，被保险人自行承担专修厂与非专修厂修理价格的差额部分。"+
                "\r4、VIP特约：尊敬的客户，您已成为我司VIP客户。";
        String a = str.replace("\r","\n");
        Pattern pattern = Pattern.compile("(、[\\u4e00-\\u9fa5]*[:|：])(?<=\\d、)");

        String s1 = a.replaceAll("、.*[:|：]", "、");
        System.out.println(s1);
    }
}
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
        String str1 ="AA1、车船税温馨提示:根据车船税征收管理规定，为避免产生车船税滞纳金，此保单请于2020年12月31日前续保。\n" +
                "2、投保人特别约定:特别提示:除法律法规另有约定外，投保人拥有保险合同解除权，涉及退（减）保费的，退还给投保人。 本保单投保人为：测试。\n" +
                "000shangye000:&nbsp;1、非营业车辆特别约定:保险车辆为非营业用途，如果用于营业运输发生保险事故，保险人不承担赔偿责任。\n" +
                "2、其他_商业险:此保单第一受益人为中国建设银行股份有限公司张家口分行，保险期间不得变更、不得修改受益人、理赔超过5000元需经第一受益人许可方可支付。\n" +
                "3、人伤特约:发生保险事故造成人员伤亡的，伤亡人员医疗费用超出《道路交通事故受伤人员临床诊疗指南》和国家基本医疗保险同类医疗费用标准的部分，保险人不负责赔偿。\n" +
                "4、专修厂特别约定:本车未投保指定专修厂特约条款，车辆损失险出险后到专修厂修理的，被保险人自行承担专修厂与非专修厂修理价格的差额部分。\n" +
                "5、VIP特约:尊敬的客户，您已成为我司VIP客户。\n" +
                "6、投保人特别约定:特别提示:除法律法规另有约定外，投保人拥有保险合同解除权，涉及退（减）保费的，退还给投保人。";

            String ss="1.监管电话：江苏省保险消费投诉电话：4008012378， 请协助解决，谢谢！";
//        String sx = str1.toString().replaceAll("、[^：:]*[：:]", "、");
        String s = str1.replaceAll("、[^：:]{0,10}[：:]", "、");
        System.out.println(s);
//        String a = str.replace("\r","\n");
//        Pattern pattern = Pattern.compile("(、[\\u4e00-\\u9fa5]*[:|：])(?<=\\d、)");
//
//        String s1 = a.replaceAll("、.*[:|：]", "、");
//        System.out.println(s1);
        String url = "http::8081/";
        String ip = "10.1.4.129";
        String s1 = url.replaceAll(":.*:", "://" + ip + ":");
        System.out.println("s1: "+s1);
        String signPDFPath = "E://lcoa/adsa/asd/print/20190630/adsasda.pdf";
        String print = signPDFPath.substring(signPDFPath.indexOf("print"));
        System.out.println(print);
    }
}
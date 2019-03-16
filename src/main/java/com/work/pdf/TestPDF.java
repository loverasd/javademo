package com.work.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: javademo
 * @description: 测试pdf模板
 * @author: chenp
 * @create: 2018-12-28 14:09
 **/
public class TestPDF {
    final static String SRC = "E:\\work\\Core-Code-Core\\out\\artifacts\\core\\print\\PrintTemplate\\CommercialPolicy.pdf";
    final static String DEST = "E:\\work\\CommercialPolicy1.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        HashMap<String,Object> map = new HashMap<>();
        map.put("Address1","Address1");
        manipulatePdf(SRC,DEST,map);
    }

    public static void manipulatePdf(String src, String dest, Map<String, Object> data) throws IOException, DocumentException {
        try (
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(dest)
        ) {
            PdfReader reader = null;
            AcroFields acroFields = null;
            PdfStamper pdfStamper = null;
            //初始化模板
            reader = new PdfReader(src);
            pdfStamper = new PdfStamper(reader, bos);
             acroFields = pdfStamper.getAcroFields();

            for (String key : data.keySet()) {
                acroFields.setField(key, data.get(key).toString());
            }
            pdfStamper.setFormFlattening(true);
            reader.close();
            pdfStamper.close();

            System.out.println();
            fileOutputStream.write(bos.toByteArray());
            fileOutputStream.flush();
            System.out.println("ok");
        }
    }


}
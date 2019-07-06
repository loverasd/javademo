package com.work.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    final static String SRC = "E:\\work\\需求\\迅捷版pdf\\迅捷压缩\\0613\\jqx_bdmb_hn.pdf";
    final static String DEST = "E:\\work\\testElecPDf.pdf";
    final static String pdfFiledXls = "E:\\work\\需求\\广东电子保单\\接入材料\\附件4-电子保单模板标签说明书20181123(1).xlsx";


    public static void main(String[] args) throws IOException, DocumentException {
        Map<String, String> map = readXlsx(pdfFiledXls);
//        map.put("Address1", "Address1");
        map.forEach((a,b)-> System.out.println(a+":"+b.toString()));
        manipulatePdf(SRC, DEST, map);

    }

    public static void manipulatePdf(String src, String dest, Map<String, String> data) throws IOException, DocumentException {
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
                acroFields.setField(key, data.get(key));
            }
            pdfStamper.setFormFlattening(true);
            System.out.println();
            fileOutputStream.write(bos.toByteArray());
            fileOutputStream.flush();

            System.out.println("ok");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String, String> readXlsx(String path) {
        HashMap<String, String> map = new HashMap<>();
        try (FileInputStream in = new FileInputStream(path)) {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
            XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
            XSSFRow row;
            for (int i = sheetAt.getFirstRowNum(); i < sheetAt.getPhysicalNumberOfRows(); i++) {
                row = sheetAt.getRow(i);

                XSSFCell cell = row.getCell(1); //中文名称
                XSSFCell cell1 = row.getCell(2);//模板标签
                XSSFCell cell3 = row.getCell(6);//传值示例
                if (cell1 ==null || cell3 == null) continue;
                String s1 = cell1.toString();
                if (s1.length() < 4) continue;
                String subS1 = s1.substring(2, s1.length() - 1);
                String s3 = cell3.toString();

                String[] split = s3.split("[\"\"“”]");
                String valS3;
                if (split.length == 0) continue;
                if (split.length > 1) {
                    valS3 = split[1];
                } else {
                    valS3 = split[0];
                }
                System.out.println(subS1 + ":" + valS3 + ":");
                map.put(subS1,valS3);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * xls
     * @param path
     * @return
     */
//    public static Map<String, String> readXls(String path) {
//        try(FileInputStream in = new FileInputStream(path)) {
//            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
//
//            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
//            HSSFRow row ;
//            String cell;
//            for (int i = sheetAt.getFirstRowNum(); i < sheetAt.getPhysicalNumberOfRows(); i++) {
//
//                row = sheetAt.getRow(i);
//                for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells() ; j++) {
//
//                    cell = row.getCell(j).toString();
//                    System.out.print(cell + " \t");
//
//                }
//            }
//
//        } catch (Exception e) {
//
//        }
//        return null;
//    }


}
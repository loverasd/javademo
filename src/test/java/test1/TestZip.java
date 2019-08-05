package test1;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @program: javademo
 * @author: chenp
 * @create: 2018-10-15 17:23
 * @description:
 **/
public class TestZip {

    @Test
    public void test2() {

    }

    /**
     * @param source   原始文件路径
     * @param dest     解压路径
     * @param password 解压文件密码(可以为空)
     */
    private static void unZip(String source, String dest, String password) throws ZipException {
        try {
            File zipFile = new File(source);
            ZipFile zFile = new ZipFile(zipFile); // 首先创建ZipFile指向磁盘上的.zip文件
            zFile.setFileNameCharset("GBK");
            File destDir = new File(dest); // 解压目录
            if (!destDir.exists()) {// 目标目录不存在时，创建该文件夹
                destDir.mkdirs();
            }
            if (zFile.isEncrypted()) {
                zFile.setPassword(password.toCharArray()); // 设置密码
            }
            zFile.extractAll(dest); // 将文件抽出到解压目录(解压)
            List<FileHeader> headerList = zFile
                    .getFileHeaders();
            List<File> extractedFileList = new ArrayList<File>();
            for (FileHeader fileHeader : headerList) {
                if (!fileHeader.isDirectory()) {
                    extractedFileList.add(new File(destDir, fileHeader
                            .getFileName()));
                }
            }
            File[] extractedFiles = new File[extractedFileList.size()];
            extractedFileList.toArray(extractedFiles);
            for (File f : extractedFileList) {
                System.out.println(f.getAbsolutePath() + "文件解压成功!");
            }
        } catch (ZipException e) {

            e.printStackTrace();
        }
    }

    public String unzip2(String source, String password) throws ZipException {
        File zipFile = new File(source);
        ZipFile zFile = new ZipFile(zipFile); // 首先创建ZipFile指向磁盘上的.zip文件
        zFile.setFileNameCharset("GBK");

        return null;
    }

    @Test
    public void Test3() {
        Logger logger = Logger.getLogger("test1.TestZip");
        logger.log(Level.INFO, "nihao");
        int[] a = new int[]{1, 2, 3};
        int i = 0;
        System.out.println(a[i++]);
        System.out.println(a[i]);
    }
}
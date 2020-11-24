package org.zicheng.stu.zip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;


public class UnZip {


    public static String getZipDirName(File file) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String tempName = zipEntry.getName();
            if (tempName.contains("/")) {
                return tempName.substring(0, tempName.indexOf("/"));
            }
        }
        throw new Exception("not found dir in this zip file");
    }

    public static void unZipFiles(File zipFile, String descDir, String topDirName) throws Exception {

        ZipFile zip = new ZipFile(zipFile);

        String oldDirName = null;
        for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();

            String zipEntryName = entry.getName();
            if (oldDirName == null) {
                if (zipEntryName.contains("/")) {
                    oldDirName = zipEntryName.substring(0, zipEntryName.indexOf("/"));
                }
            }
            if (zipEntryName.startsWith(oldDirName + "/")) {
                zipEntryName = "/" + topDirName + zipEntryName.substring(zipEntryName.indexOf("/"));
            }

            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");

            //判断路径是否存在,不存在则创建文件路径
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                file.mkdirs();
            }
            //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }

            OutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String maskZipPath = "C:\\Users\\se0883\\Desktop\\mask.zip";
        String stickerZipPath = "C:\\Users\\se0883\\Desktop\\sticker.zip";
        try {
            unZipFiles(new File(stickerZipPath), "C:\\Users\\se0883\\Desktop", "testUnzip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package org.zicheng.stu.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Author: T.L. QIU
 * Date: 2020-11-24 15:23.
 */
public class ZipTest {
    public static void main(String[] args) throws Exception {

        String maskZipPath = "C:\\Users\\se0883\\Desktop\\mask.zip";
        String stickerZipPath = "C:\\Users\\se0883\\Desktop\\sticker.zip";

        getZipName(new File(maskZipPath));
        getZipName(new File(stickerZipPath));
    }

    public static void getZipName(File file) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String tempName = zipEntry.getName();
            if (tempName.contains("/")) {
                String zipDir = tempName.substring(0, tempName.indexOf("/"));
                if (zipEntry.getName().equals(zipDir + "/")) {

                }
            }

        }
    }
}

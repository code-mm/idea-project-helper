package com.ms.utils;

import java.io.*;
import java.util.List;

public class FileUtils {
    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }


    public static void search(List<String> result, String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(result, it.getPath());
            }
            result.add(it.getPath());
        }
    }


    public static byte[] getBytesByFile(String filePath) {
        try {
            File file = new File(filePath);

            FileInputStream fis = new FileInputStream(file);


            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);

            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();

            byte[] data = bos.toByteArray();

            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void copyFile(File srcFile, File tagFile) {
        try {
            FileInputStream srcFis = new FileInputStream(srcFile);
            FileOutputStream tagFos = new FileOutputStream(tagFile);

            byte[] buf = new byte[1024 * 1024 * 8];
            int len = 0;
            while ((len = srcFis.read(buf)) != -1) {
                tagFos.write(buf, 0, len);
                tagFos.flush();
            }
            srcFis.close();
            tagFos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String tagPath) {
        File srcFile = new File(srcPath);
        File tagFile = new File(tagPath);

        try {
            FileInputStream srcFis = new FileInputStream(srcFile);
            FileOutputStream tagFos = new FileOutputStream(tagFile);

            byte[] buf = new byte[1024 * 1024 * 8];
            int len = 0;
            while ((len = srcFis.read(buf)) != -1) {
                tagFos.write(buf, 0, len);
                tagFos.flush();
            }
            srcFis.close();
            tagFos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 通过字节流实现文件的拷贝
     *
     * @param sourcePath 源文件路径
     * @param targetPath 目标文件路径
     */
    public static void copyFileByStream(String sourcePath, String targetPath) {
        //源文件路径
        File source = new File(sourcePath);
        //目标文件路径
        File target = new File(targetPath);

        //如果源文件不存在则不能拷贝
        if (!source.exists()) {
            return;
        }
        //如果目标文件目录不存在则创建
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        try {
            //实现文件的拷贝
            InputStream inputStream = new FileInputStream(source);
            OutputStream outputStream = new FileOutputStream(target);
            int temp = 0;
            //每次读取1024个字节
            byte[] data = new byte[1024];
            //将每次读取的数据保存到字节数组里面，并且返回读取的个数
            while ((temp = inputStream.read(data)) != -1) {
                //输出数组
                outputStream.write(data, 0, temp);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

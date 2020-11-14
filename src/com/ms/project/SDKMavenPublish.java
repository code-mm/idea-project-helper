package com.ms.project;

import java.io.*;

public class SDKMavenPublish {

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


    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }


            if (it.getName().equals("sdk")) {


                File file1 = new File(it.getPath() + "/maven_publish.gradle");

                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }


            if (it.getName().equals("maven_publish.gradle")) {


                copyFileByStream("maven_publish.gradle",it.getPath());

            }

        }

    }

    public static void main(String[] args) {

//maven_publish.gradle


        search("D:/src/gitee/ms-android/module/internal/");
    }

}

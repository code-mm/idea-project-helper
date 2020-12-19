package com.ms.service.clear;

import com.ms.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 统一gradle 版本
 */
public class GradleVersion {

    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }

            if ("wrapper".equals(it.getName())) {
                File file1 = new File(it.getPath() + "/gradle-wrapper.properties");
                File file2 = new File(it.getPath() + "/gradle-wrapper.jar");

                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            if (it.getName().equals("gradle-wrapper.properties")) {
                FileUtils.copyFileByStream("gradle-wrapper.properties", it.getPath());
            }

            if (it.getName().equals("gradle-wrapper.jar")) {
                FileUtils.copyFileByStream("gradle-wrapper.jar", it.getPath());

            }
        }

    }

    public static void main(String[] args) {
        // 传入项目路径
        search("D:\\src\\aliyun\\shuangyang\\shuangyang-service\\");
    }
}

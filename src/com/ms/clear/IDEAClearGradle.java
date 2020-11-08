package com.ms.clear;

import com.ms.utils.FileUtils;

import java.io.File;


/**
 * 清楚IDEA中的.idea 和 .gradle 以及构建的 build
 */
public class IDEAClearGradle {

    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }

            if (it.getName().equals(".gradle")) {
                FileUtils.deleteDir(it.getPath());
            }

        }

    }

    public static void main(String[] args) {
        // 传入项目路径
        search("D:/src/gitee/ms-android/");
    }

}

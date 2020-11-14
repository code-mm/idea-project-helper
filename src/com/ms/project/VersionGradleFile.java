package com.ms.project;

import com.ms.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class VersionGradleFile {


    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().startsWith("android-module-")) {
                File file1 = new File(it.getParent() + "/version.gradle");
                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (it.getName().equals("version.gradle")) {
                FileUtils.copyFileByStream("version.gradle", it.getPath());
            }
        }
    }

    public static void main(String[] args) {
        search("D:/src/gitee/ms-android/module/internal/");
    }


}

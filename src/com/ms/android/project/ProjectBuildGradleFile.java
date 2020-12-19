package com.ms.android.project;

import com.ms.utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class ProjectBuildGradleFile {


    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().startsWith("android-module-")) {
                File file1 = new File(it.getParent() + "/build.gradle");
                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (it.getName().equals("build.gradle")&&it.getParentFile().getName().startsWith("android-module-")) {
                FileUtils.copyFileByStream("projectbuild/build.gradle", it.getPath());
            }
        }
    }

    public static void main(String[] args) {
        search("D:/src/gitee/ms-android/module/internal/");
    }
}

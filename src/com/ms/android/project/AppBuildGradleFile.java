package com.ms.android.project;

import com.ms.utils.FileUtils;

import java.io.File;

/**
 * app 下的build.gradle
 */
public class AppBuildGradleFile {

    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("build.gradle")&&it.getParentFile().getName().equals("app")) {
                FileUtils.copyFileByStream("appbuild/build.gradle", it.getPath());
            }
        }
    }

    public static void main(String[] args) {

        String path = "D:/src/gitee/ms-android/module/internal/";
        search(path);
    }
}

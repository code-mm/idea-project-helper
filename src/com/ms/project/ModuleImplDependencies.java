package com.ms.project;

import com.ms.utils.FileUtils;

import java.io.File;

public class ModuleImplDependencies {


    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("build.gradle")&&it.getParentFile().getName().equals("sdk")&&it.getParentFile().getParentFile().getName().startsWith("android-module-impl")) {
                FileUtils.copyFileByStream("implbuild/build.gradle", it.getPath());
            }
        }
    }

    public static void main(String[] args) {
        search("D:/src/gitee/ms-android/module/internal/");
    }

}

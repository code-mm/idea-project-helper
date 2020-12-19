package com.ms.android.clear;

import com.ms.utils.FileUtils;

import java.io.File;

public class DeleteGradleCacheModule {


    public static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().contains("shuangyangad")||it.getName().contains("com.shuangyangad")) {
                System.out.println(it.getPath());
                FileUtils.deleteDir(it.getPath());
            }
        }
    }



    public static void main(String[] args) {

        search("C:\\Users\\maohuawei\\.gradle\\caches\\");
        search("C:\\Users\\maohuawei\\.m2\\repository\\");

    }
}

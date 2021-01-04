package com.ms.all;

import com.ms.utils.FileUtils;

import java.io.File;

public class UpdatePublishFile {

    private static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("settings.gradle")) {
                System.out.println(it.getParent());

                File file1 = new File(it.getParent() + "/sdk");
                if (file1.exists()) {

                    if (file1.isDirectory()) {

                        FileUtils.copyFile("publish.bat", it.getParent() + "/publish.bat");
                        FileUtils.copyFile("publish.sh", it.getParent() + "/publish.sh");

                    }
                }


            }
        }
    }

    public static void main(String[] args) {
        search("D:\\src\\shuangyangad\\");
    }
}

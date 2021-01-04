package com.ms.all;

import com.ms.utils.FileUtils;

import java.io.File;

/**
 * gitpush.bat 发布
 */
public class UpdateGitPushFile {
    private static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("settings.gradle")) {
                System.out.println(it.getParent());

                FileUtils.copyFile("gitpush.bat", it.getParent() + "/gitpush.bat");
                FileUtils.copyFile("gitpush.sh", it.getParent() + "/gitpush.sh");


            }
        }
    }

    public static void main(String[] args) {
        search("D:\\src\\shuangyangad\\");
    }
}

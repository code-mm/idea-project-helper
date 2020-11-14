package com.ms.git.gitpush;

import com.ms.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * gitupdate.bat 发布
 */
public class GitPush {
    private static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getParentFile().getName().startsWith("android-module-impl-")) {
                File fileTemp = new File(it.getParent() + "/gitupdate.bat");

                if (fileTemp.exists()) {
                    try {
                        fileTemp.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileUtils.copyFileByStream("gitupdate.bat", fileTemp.getPath());
            }
        }
    }

    public static void main(String[] args) {
        search("D:/src/gitee/ms-android/module/internal/");
    }
}

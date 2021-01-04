package com.ms.android.git.gitpush;

import com.ms.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * gitpush.bat 发布
 */
public class GitPush {
    private static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            System.out.println(it.getPath());




//            if (it.getParentFile().getName().startsWith("android-module-impl-")) {
//                File fileTemp = new File(it.getParent() + "/gitpush.bat");
//
//                if (!fileTemp.exists()) {
//                    try {
//                        fileTemp.createNewFile();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                FileUtils.copyFileByStream("gitpush.bat", fileTemp.getPath());
//            }
        }
    }

    public static void main(String[] args) {
        search("D:/src/shuangyangad/");
    }
}

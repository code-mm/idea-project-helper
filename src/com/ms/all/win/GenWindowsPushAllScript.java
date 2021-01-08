package com.ms.all.win;

import java.io.File;

public class GenWindowsPushAllScript {


    public static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }

            if(it.getName().equals("gitpush.bat")){
                System.out.println("os.system(\"cd " + it.getParent().replace("\\", "/") + " && gitpush.bat\");");
            }


        }
    }


    public static void main(String[] args) {
        System.out.println("import os");
        search("D:\\src\\shuangyangad\\");
    }
}

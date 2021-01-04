package com.ms.all;

import java.io.File;

public class GenWindowsPublishScript {


    public static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("settings.gradle")) {
                //System.out.println(it.getPath());

                File file1 = new File(it.getParent() + "/publish.bat");

                if(file1.exists()){
                    System.out.println("os.system(\"cd " + it.getParent().replace("\\", "/") + " && publish.bat\");");
                }





            }
        }
    }


    public static void main(String[] args) {
        System.out.println("import os");
        search("D:\\src\\shuangyangad\\");
    }
}

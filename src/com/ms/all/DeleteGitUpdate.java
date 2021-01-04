package com.ms.all;

import com.ms.utils.FileUtils;

import java.io.File;

public class DeleteGitUpdate {


    public static void search(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("gitupdate.bat")||it.getName().equals("gitupdate.sh")) {
                System.out.println(it.getPath());
                it.delete();


            }
        }
    }


    public static void main(String[] args) {

        search("D:\\src\\shuangyangad\\");
    }
}

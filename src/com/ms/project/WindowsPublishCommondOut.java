package com.ms.project;

import java.io.File;

public class WindowsPublishCommondOut {

    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }

            if (it.getName().equals("publish.bat")) {
                System.out.println("cd "+ it.getParent() +" && publish.bat");
            }

        }

    }

    public static void main(String[] args) {

        search("D:/src/gitee/ms-android/");

    }
}

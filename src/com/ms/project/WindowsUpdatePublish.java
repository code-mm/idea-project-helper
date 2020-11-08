package com.ms.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WindowsUpdatePublish {

    public static void searchAdd(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                searchAdd(it.getPath());
            }
            if (it.getParentFile().getName().startsWith("android-module-")) {
                System.out.println(it.getParentFile().getPath());

                File file1 = new File(it.getParentFile().getPath() + "/publish.bat");

                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new FileWriter(file1.getPath(), false));
                    out.write("gradlew clean sdk:publishToMavenLocal\n" +
                            "gradlew clean sdk:publish");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void search(String path) {

        File file = new File(path);
        File[] files = file.listFiles();

        for (File it : files) {
            if (it.isDirectory()) {
                search(it.getPath());
            }
            if (it.getName().equals("publish.bat")) {
                System.out.println(it.getPath());
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new FileWriter(it.getPath(), false));
                    out.write("gradlew clean sdk:publishToMavenLocal\n" +
                            "gradlew clean sdk:publish");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {

        searchAdd("D:/src/gitee/ms-android/");
    }

}

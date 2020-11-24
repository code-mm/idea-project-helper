package com.ms.project;

import java.io.*;

/**
 * 生产python发布代码
 */
public class GenPythonAutoPublishCode {

    public static void internal() {

        String path = "D:\\src\\gitee\\shuangyang\\android\\android-modules\\internal\\";


        File[] files = new File(path).listFiles();
        System.out.println("import os");
        for (File it : files) {
            System.out.println("print(\"START==========" + it.getName() + "==========\")");
            System.out.println("os.system( \"cd " + it.getPath().replace("\\", "/") + "  && publish.bat \")");
            System.out.println("print(\"END==========" + it.getName() + "==========\")");
        }
    }

    public static void external() {

        String path = "D:\\src\\gitee\\shuangyang\\android\\android-modules\\external\\";

        File[] files = new File(path).listFiles();
        System.out.println("import os");
        for (File it : files) {
            System.out.println("print(\"START==========" + it.getName() + "==========\")");
            System.out.println("os.system( \"cd " + it.getPath().replace("\\", "/") + "  && publish.bat \")");
            System.out.println("print(\"END==========" + it.getName() + "==========\")");
        }
    }


    public static void main(String[] args) {

        internal();
        System.out.println("\n\n\n");
        external();

    }
}

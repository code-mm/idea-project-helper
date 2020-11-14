package com.ms.project;

import java.io.*;

/**
 * 生产python发布代码
 */
public class GenPythonAutoPublishCode {

    public static void main(String[] args) {

        String path = "D:\\src\\gitee\\ms-android\\module\\internal\\";

        File[] files = new File(path).listFiles();
        System.out.println("import os");
        for (File it : files) {
            System.out.println("print(\"START==========" + it.getName() + "==========\")");
            System.out.println("os.system( \"cd " + it.getPath().replace("\\", "/") + "  && publish.bat \")");
            System.out.println("print(\"END==========" + it.getName() + "==========\")");
        }
    }
}

package com.ms.android.project;

import java.io.File;

/**
 * 生产python发布代码
 */
public class GitInitPythonGitPushCode {


    public static void external() {
        String path = "D:\\src\\aliyun\\shuangyang\\shuangyang-android\\modules\\external\\";

        File[] files = new File(path).listFiles();
        System.out.println("import os");
        for (File it : files) {
            System.out.println("print(\"START==========" + it.getName() + "==========\")");
            System.out.println("os.system( \"cd " + it.getPath().replace("\\", "/") + "  && git init && git remote add origin https://codeup.aliyun.com/5fb74e045dbd287006144d3d/shuangyang-android-module/"+ it.getName()+"    && git add . && git commit -m 'init' &&  git push -u origin master  \")");
            System.out.println("print(\"END==========" + it.getName() + "==========\")");
        }
    }

    public static void internal() {
        String path = "D:\\src\\aliyun\\shuangyang\\shuangyang-android\\modules\\internal\\";
        File[] files = new File(path).listFiles();
        System.out.println("import os");
        for (File it : files) {
            System.out.println("print(\"START==========" + it.getName() + "==========\")");
            System.out.println("os.system( \"cd " + it.getPath().replace("\\", "/") + "  && git init && git remote add origin https://codeup.aliyun.com/5fb74e045dbd287006144d3d/shuangyang-android-module/"+ it.getName()+"    && git add . && git commit -m 'init' &&  git push -u origin master  \")");
            System.out.println("print(\"END==========" + it.getName() + "==========\")");
        }
    }


    public static void main(String[] args) {

        external();

        System.out.println("\n\n\n");

        internal();

    }
}

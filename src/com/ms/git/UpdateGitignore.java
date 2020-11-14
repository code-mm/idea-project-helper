package com.ms.git;

import java.io.*;

public class UpdateGitignore {

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            in.read(filecontent);
            return new String(filecontent, encoding);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
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
            if (it.getName().equals(".gitignore")) {
                System.out.println(it.getPath());
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new FileWriter(it.getPath(), false));
                    out.write("*.iml\n" +
                            ".gradle\n" +
                            "/local.properties\n" +
                            "/.idea/caches\n" +
                            "/.idea/libraries\n" +
                            "/.idea/modules.xml\n" +
                            "/.idea/workspace.xml\n" +
                            "/.idea/navEditor.xml\n" +
                            "/.idea/assetWizardSettings.xml\n" +
                            ".DS_Store\n" +
                            "/build\n" +
                            "/captures\n" +
                            ".externalNativeBuild\n" +
                            ".cxx\n" +
                            ".idea\n");
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 传入项目路径
        search("D:/src/gitee/ms-android/module/internal/");
    }
}

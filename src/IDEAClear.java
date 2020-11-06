import java.io.File;


/**
 * 清楚IDEA中的.idea 和 .gradle 以及构建的 build
 */
public class IDEAClear {


    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
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


            if (it.getName().equals(".idea")) {
                System.out.println(it.getPath());
                deleteDir(it.getPath());
            }

            if (it.getName().equals(".gradle")) {
                System.out.println(it.getPath());
                deleteDir(it.getPath());
            }


            if (it.getName().equals("build")) {
                System.out.println(it.getPath());
                deleteDir(it.getPath());
            }
        }

    }

    public static void main(String[] args) {
        // 传入项目路径
        search("/Users/maohuawei/src/ms-android/");
    }

}

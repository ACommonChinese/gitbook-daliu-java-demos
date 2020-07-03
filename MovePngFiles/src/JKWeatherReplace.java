import java.io.*;

public class JKWeatherReplace {
    public static void main(String[] args) {
        //字符串替换
        //需求1: 把所有的json文件中的img_xxx.png替换成json文件名_img_xxx.png
        //比如: 暴雨_雨.json文件中的字符串 img_2.png --> 暴雨_雨_img_2.png
        File current = new File("/Users/liuweizhen/Desktop/JKWeathers");
        System.out.println(current.getAbsolutePath());
        //遍历目录


        //文件名替换
        //需求2: 把文件夹内名为bg.png的名字替换为上层文件夹名_bg.png
        //比如: 暴雨/bg.png --> 暴雨_bg.png

        //文件名替换
        //需求3: 把目录下名称为 img_xxx.png 的文件, 改名字替换为 目录名_img_xxx.png
        //比如: 暴雨_雨/img_0.png --> 暴雨_雨_img_0.png
    }

    void replaceJson(File file) {
        if (file.getName().endsWith(".DS_Store")) {
            return;
        }
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            for (File subFile : subFiles) {
                replaceJson(subFile);
            }
        } else if (!file.getName().endsWith(".json")) {
            return;
        } else {
            //get the json file
            String fileName = file.getName();

            try (
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            ) {

            } catch (IOException exception) {

            }


            // String afterStr = json.replaceAll("\"img_(\\d+).png\"", "\"xxx_img_$1.png\"");
        }
    }

    String getJson(File file) {
        if (null == file || file.length() == 0 || file.getName().endsWith("json")) {
            return null;
        }
        StringReader
    }
}

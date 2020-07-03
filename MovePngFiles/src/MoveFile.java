import java.io.*;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class MoveFile {
    public static void main(String[] args) {
        MoveFile m = new MoveFile();
        //m.moveLottiePngFiles(); // 移动lottie动画图片
        m.moveLottieBgFiles();  // 移动lottie背景图片
    }

    public void moveLottiePngFiles() {
        //暴雨
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/暴雨素材包/ios/只有雨/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/暴雨/暴雨_雨");
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/暴雨素材包/ios/只有云/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/暴雨/暴雨_云");

        //冰雹
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/冰雹素材包（冬冬无需更改）/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/冰雹");

        //大风
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/大风素材包/ios 更新/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/大风");

        //大雪
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/大雪素材包/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/大雪");

        //多云
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/多云白天素材包/ios/images",
                "Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/多云");
        //多云_夜
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/多云夜晚素材包/ios",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/多云_夜");

        //雷阵雨
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/雷阵雨素材包/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/雷阵雨");

        //轻度雾霾
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/雾霾素材包/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/轻度雾霾");

        //晴
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/晴天白天素材包/云/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/晴/云");
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/晴天白天素材包/sun/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/晴/太阳");

        //晴_夜
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/晴天夜晚素材包/ios/images_2",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/晴_夜");

        //雾
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/雾素材包（冬冬无需更改）/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/雾");

        //小雪
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/小雪素材包/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/小雪");

        //小雨
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/小雨中雨素材包/ios/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/小雨");

        //阴
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/阴天素材包/ios",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/阴");

        //雨夹雪
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/雨夹雪素材包/只有雨/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/雨夹雪/雨夹雪_雨雪");
        moveLottiePngFiles("/Users/liuweizhen/Documents/yi_ke_xin/雨夹雪素材包/只有云/images",
                "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/雨夹雪/雨夹雪_云");
    }

    public void moveLottieBgFiles() {
        Map<String, String> map = new HashMap<>() {
            {
                put("暴雨素材包", "暴雨");
                put("冰雹素材包（冬冬无需更改）", "冰雹");
                put("大风素材包", "大风");
                put("大雪素材包", "大雪");
                put("多云白天素材包", "多云");
                put("多云夜晚素材包", "多云_夜");
                put("雷阵雨素材包", "雷阵雨");
                put("雾霾素材包", "轻度雾霾");
                put("晴天白天素材包", "晴");
                put("晴天夜晚素材包", "晴_夜");
                put("雾素材包（冬冬无需更改）", "雾");
                put("小雪素材包", "小雪");
                put("小雨中雨素材包", "小雨");
                put("阴天素材包", "阴");
                put("雨夹雪素材包", "雨夹雪");
            }
        };
        for (String key : map.keySet()) {
            String srcPath = "/Users/liuweizhen/Documents/yi_ke_xin/";
            String destPath = "/Users/liuweizhen/Desktop/Job/Code/JKWAnimationModule/JKWAnimationModuleProject/JKWAnimationModuleProject/JKAnimationModule/JKWeathers.bundle/";
            srcPath = srcPath + key + "/bg.png";
            String value = map.get(key);
            if (value == null) {
                System.out.println("出现错误: value null for " + key);
                continue;
            }
            destPath = destPath + value + "/bg.png";
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            copy(srcFile, destFile);
        }
    }

    public void moveLottieBgFile(String srcPath, String destPath) {

    }

    public void moveLottiePngFiles(String srcDirPath, String destDirPath) {
        File srcDir = new File(srcDirPath);
        File destDir = new File(destDirPath);
        if (!srcDir.isDirectory()) {
            System.out.println("src不是目录: " + srcDirPath);
            return ;
        }
        if (!destDir.exists()) {
            System.out.println("目标目录不存在");
            boolean createSuccess = destDir.mkdir();
            if (createSuccess) {
                System.out.println("创建目标目录成功: " + destDirPath);
            } else {
                System.out.println("创建目标目录失败");
            }
        }

        File[] files = srcDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }
            String fileName = file.getName();
            if (fileName.endsWith(".png")) {
                String destFilePath = destDirPath;
                destFilePath += destDirPath.endsWith("/") ? fileName : ("/"+fileName);
                File destFile = new File(destFilePath);
                copy(file, destFile);
            }
        }
    }

    private void copy(File source, File dest) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            long size = outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            if (size > 0) {
                System.out.println("From: " + source.getAbsolutePath());
                System.out.println("To: ----> " + dest.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("copy file fail: " + source.getAbsolutePath() + " --> " + dest.getAbsolutePath());
            e.printStackTrace();
        } finally {
            try {
                inputChannel.close();
                outputChannel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

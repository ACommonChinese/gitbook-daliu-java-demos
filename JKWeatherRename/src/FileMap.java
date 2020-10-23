import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileMap {
    public static String UNKNOW = "UNKNOW";
    public static String CLEAR_DAY = "CLEAR_DAY";
    public static String CLEAR_NIGHT = "CLEAR_NIGHT";
    public static String PARTLY_CLOUDY_DAY = "PARTLY_CLOUDY_DAY";
    public static String PARTLY_CLOUDY_NIGHT = "PARTLY_CLOUDY_NIGHT";
    public static String CLOUDY = "CLOUDY";
    public static String WIND = "WIND";
    public static String LIGHT_HAZE = "LIGHT_HAZE";
    public static String MODERATE_HAZE = "MODERATE_HAZE";
    public static String HEAVY_HAZE = "HEAVY_HAZE";
    public static String LIGHT_RAIN = "LIGHT_RAIN";
    public static String MODERATE_RAIN = "MODERATE_RAIN";
    public static String HEAVY_RAIN = "HEAVY_RAIN";
    public static String STORM_RAIN = "STORM_RAIN";
    public static String FOG = "FOG";
    public static String LIGHT_SNOW = "LIGHT_SNOW";
    public static String MODERATE_SNOW = "MODERATE_SNOW";
    public static String HEAVY_SNOW = "HEAVY_SNOW";
    public static String STORM_SNOW = "STORM_SNOW";
    public static String DUST = "DUST";
    public static String SAND = "SAND";
    public static String HAIL = "HAIL";
    public static String SLEET = "SLEET";
    public static String THUNDER_SHOWER = "THUNDER_SHOWER";

    private String oldDirPath = null;
    private String newDirPath = null;
    private File oldFile = null;
    private List<File> newFileList = new ArrayList<>();

    public String getOldDirPath() {
        return oldDirPath;
    }
    public void setOldDirPath(String oldDirPath) {
        this.oldDirPath = oldDirPath;
    }
    public String getNewDirPath() {
        return newDirPath;
    }
    public void setNewDirPath(String newDirPath) {
        this.newDirPath = newDirPath;
    }
    public File getOldFile() {
        return oldFile;
    }
    public void setOldFile(File oldFile) {
        this.oldFile = oldFile;
    }
    public List<File> getNewFileList() {
        return newFileList;
    }
    public void setNewFileList(List<File> newFileList) {
        this.newFileList = newFileList;
    }

    public void process() {
        copy(FileMap.UNKNOW);
    }

    public void copy(String targetName) {
        if (targetName.equals(UNKNOW)) {
            String value = map.get(UNKNOW);
            copy(value + "_small@2x.png", UNKNOW + "_small@2x.png");
            copy(value + "_small@3x.png", UNKNOW + "_small@3x.png");
            copy(value + "_big@2x.png", UNKNOW + "_big@2x.png");
            copy(value + "_big@3x.png", UNKNOW + "_big@3x.png");

//            copy("weizhitianqi_small@2x.png", "UNKNOWN_small@2x.png");
//            copy("weizhitianqi_small@3x.png", "UNKNOWN_small@3x.png");
//            copy("weizhitianqi_big@2x.png", "UNKNOWN_big@2x.png");
//            copy("weizhitianqi_big@3x.png", "UNKNOWN_big@3x.png");
        }
    }

    private Map<String, String> map = new HashMap<>() {
        {
            put(UNKNOW, "weizhitianqi");             // 未知天气
            put(CLEAR_DAY, "qingtian_day");           // 晴天-昼
            put(CLEAR_NIGHT, "qingtian_night");       // 晴天-夜
            put(PARTLY_CLOUDY_DAY, "duoyun_day");     // 多云-昼
            put(PARTLY_CLOUDY_NIGHT, "duoyun_night"); // 多云-夜
            put(CLOUDY, "yin");                       // 阴天
            put(WIND, "dafeng");                      // 大风
            put(LIGHT_HAZE, "wumai");                 // 轻度雾霾
            put(MODERATE_HAZE, "zhongduwumai");       // 中度雾霾 | 重度雾霾
            put(LIGHT_RAIN, "xiaoyu");                // 小雨
            put(MODERATE_RAIN, "zhongyu");            // 中雨
            put(HEAVY_RAIN, "dayu");                  // 大雨
            put(STORM_RAIN, "baoyu");                 // 暴雨
            put(FOG, "wu");                           // 雾
            put(LIGHT_SNOW, "xiaoxue");               // 小雪
            put(MODERATE_SNOW, "zhongxue");           // 中雪
            put(HEAVY_SNOW, "daxue");                 // 大雪
            put(STORM_RAIN, "baoxue");                // 暴雪
            put(DUST, "shachen／fuchen_big.png");     // 浮尘 | 扬沙
            put(SAND, "shachen／fuchen_big.png");     // 扬沙
            put(HAIL, "bingbao");                     // 冰雹
            put(SLEET, "yujiaxue");                   // 雨夹雪
            put(THUNDER_SHOWER, "leizhenyu");         // 雷阵雨

            // From 刘燚
            // 即刻3.0 沙尘浮尘用一个icon：fuchen
            // 中度雾霾和重度雾霾用同一icon: zhongduwumai
        }
    };

    public void copy(String oldName, String newName) {
        String oldFilePath = StringUtils.appendPathComponent(getOldDirPath(), oldName);
        String newFilePath = StringUtils.appendPathComponent(getNewDirPath(), newName);
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        // renameTo有坑
        // https://www.cnblogs.com/mrwangblog/p/3934506.html
        // oldFile2.renameTo(newFile2)
        copy(oldFile, newFile);
    }

    private void copy(File source, File dest) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
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
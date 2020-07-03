import java.io.File;

/**
 * javac Rename.java # 编译
 * jar cvfe rename.jar Rename *.class # 生成rename.jar包
 * 运行 java -jar rename.jar hello world
 * 参数args中为：[hello world]
 */
public class Rename {
    private String oldDirPath = null;
    private String newDirPath = null;

    public static void main(String[] args) throws Exception {
//        for (String command :
//                args) {
//            System.out.println(command);
//        }

        new Rename().process("/Users/liuweizhen/Desktop/Test/天气icon_slices");
    }

    public void process(String dirPath) throws Exception {
        oldDirPath = dirPath;

        // ---- 对输入文件路径校验 ----
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (dir == null || files == null) {
            throw new Exception("目录错误或空目录");
        }

        // ---- 删除非retina图片（.png）----
        removeNotRetinaFiles(files);

        // ---- 创建新文件夹 ----
//        String removeLastPath = StringUtils.removeLastPathComponent(dirPath);
//        newDirPath = StringUtils.appendPathComponent(removeLastPath, "weather_new_copy");
//        if (createDir(newDirPath)) {
//            System.out.println("创建文件夹成功：" + newDirPath);
//        } else {
//            return;
//        }
//
//        FileMap fileMap = new FileMap();
//        fileMap.setOldDirPath(oldDirPath);
//        fileMap.setNewDirPath(newDirPath);
//        fileMap.process();
    }

    // oldFile -> newFile
    // /Users/liuweizhen/Desktop/Test/天气icon_slices/baoxue_big@2x.png > /Users/liuweizhen/Desktop/Test/weather_new_copy/XXX_bg@2x.png
    public File getNewFile(File oldFile) throws Exception {
        if (oldFile == null) {
            return null;
        }
        String oldName = oldFile.getName();
        if (oldName == null || oldName.length() == 0) {
            System.out.println("!!WARNING: oldName is null!");
            return null;
        }

        int i = 0;
        if (oldName.contains("_small@")) {
            i = oldName.indexOf("_small@");
        } else if (oldName.contains("_big@")) {
            i = oldName.indexOf("_big@");
        }
        if (i <= 0) {
            throw new Exception("未清理干净资源: " + oldName);
        }
        return null;
    }

    public static boolean createDir(String dirPath) {
        File file = new File(dirPath);
        if (file.mkdir()) {
            return true;
        } else {
            System.out.println("创建新文件夹 " + dirPath + "失败, 可能存在同名目录");
            return false;
        }
    }

    // 删除不以@2x和@3x结属的图片
    public static void removeNotRetinaFiles(File[] files) {
        System.out.println("--------------------------------------------");
        for (File file : files) {
            String name = file.getName();
            if (!name.contains("_small@") && !name.contains("_big@")) {
                System.out.println("删除文件 ------------- > " + name);
                file.delete();
            }
        }
        System.out.println("--------------------------------------------");
    }
}

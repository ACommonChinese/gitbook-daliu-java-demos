import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    // file, <YTXUtil/YTXUtil.h>, <YTXBusinessUI/YTXBusinessUI.h>
    public static void appendAfterString(File file, String src, String newLine) {
        if (!isValidFile(file)) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                builder.append(str + "\n");
                if (str.contains(src)) {
                    builder.append(newLine + "\n");
                    System.out.println("append in: " + file.getAbsolutePath());
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        String fileText = builder.toString();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(fileText);
            writer.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void deleteLineHasString(File file, String content) {
        if (!isValidFile(file)) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                if (!str.contains(content)) {
                    builder.append(str + "\n");
                } else {
                    System.out.println("delete in: " + file.getAbsolutePath());
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        String fileText = builder.toString();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(fileText);
            writer.flush();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static List<File> getAllFiles(String path) {
        File file = new File(path);
        if (null == file) {
            return null;
        }
        return getAllFiles(file);
    }

    public static List<File> getAllFiles(File file) {
        ArrayList<File> fileList = new ArrayList<File>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File itemFile = files[i];
                if (itemFile == null || itemFile.getName().contains(".DS_Store")) continue;
                if (itemFile.isDirectory()) {
                    List<File> items = getAllFiles(itemFile);
                    if (items != null) {
                        fileList.addAll(getAllFiles(itemFile));
                    }
                } else {
                    fileList.add(itemFile);
                }
            }
        } else {
            fileList.add(file);
        }
        return fileList;
    }

    public static void logLinesContainStr(String filePath, String str) {
        File file = new File(filePath);
        if (file == null) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                if (tmp.contains(str)) {
                    String preStr = tmp.substring(0, tmp.indexOf(":path"));
                    //System.out.println(tmp);
                    System.out.println(preStr);
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static List<File> logAndReturnAllFiles(String dirPath) {
        List<File> allFiles = getAllFiles(dirPath);
        for (File file : allFiles) {
            System.out.println(file.getName());
        }
        return allFiles;
    }

    public static File[] logAndReturnAllFilesInFirstLevel(String dirPath) {
        File file = new File(dirPath);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
        return files;
    }

    public static List<File> logAndReturnFilesContainStr(String dirPath, String str) {
        List<File> targetFiles = new ArrayList<File>();
        List<File> files = FileUtil.getAllFiles(dirPath);
        if (files.size() <= 0) {
            System.out.println("不存在：" + dirPath);
        }
        for (File file : files) {
            if (isValidFile(file)) {
                if (convertFileToString(file).contains(str)) {
                    System.out.println(file.getAbsolutePath() + " contains: " + str);
                    targetFiles.add(file);
                }
            }
        }
        return targetFiles.size() > 0 ? targetFiles : null;
    }

    public static void logFilesContainStr(String dirPath, String str) {
        List<File> files = FileUtil.getAllFiles(dirPath);
        if (files.size() <= 0) {
            System.out.println("不存在：" + dirPath);
        }
        for (File file : files) {
            if (isValidFile(file)) {
                if (convertFileToString(file).contains(str)) {
                    System.out.println(file.getAbsolutePath() + " contains: " + str);
                }
            }
        }
    }

    public static void logFilesWithSuffix(String dirPath, String suffix) {
        List<File> files = FileUtil.getAllFiles(dirPath);
        for (File file : files) {
            if (file.getName().endsWith(suffix)) {
                System.out.println(file.getName());
            }
        }
    }

    // only .h and .m is valid
    public static boolean isValidFile(File file) {
        if (file == null ||
                !file.exists() ||
//                file.getName().endsWith(".xcodeproj") ||
//                file.getName().endsWith(".DS_Store") ||
                !(file.getName().endsWith(".h") || file.getName().endsWith(".m"))) {
            return false;
        }
        return true;
    }

    public static String convertFileToString(File file) {
        if (!isValidFile(file)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                builder.append(str + "\n");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        return builder.toString();
    }

    public static boolean hasStringContent(File file, String targetStr) {
        if (isValidFile(file) || targetStr == null || targetStr.length() <= 0) {
            return false;
        }
        String content = convertFileToString(file);
        return content.contains(targetStr);
    }

    public static boolean isContentStr(File file, String targetStr) {
        return hasStringContent(file, targetStr);
    }

    public static boolean isEqual(String file1, String file2) {
        File f1 = new File(file1);
        File f2 = new File(file2);
        return isEqual(f1, f2);
    }

    public static boolean isEqual(File file1, File file2) {
        if (file1 == null || file2 == null || file1.isFile() == false || file2.isFile() == false) {
            throw new RuntimeException("file invalud");
        }
        return MD5Util.getMD5(file1).equals(MD5Util.getMD5(file2));
    }
}

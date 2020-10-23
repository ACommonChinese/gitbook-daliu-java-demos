package com.yintech.business;

import com.yintech.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//IDEA打JAR包：
// https://www.cnblogs.com/blog5277/p/5920560.html
public class FindCell {

    /**
     : UITableViewCell
     : UITableViewHeaderFooterView
     : UICollectionViewCell
     */
    public static void main(String[] args) {
        // /Users/daliu/Desktop/job/Modules/tcyapp
        if (args.length != 1) {
            System.out.println("输入不合法，示例：java -jar FileDemo.jar YourDirPath");
        }
        String dirPath = args[0];

        System.out.println("Start searching path " + dirPath + "...");

//        File ff1 = new File("/Users/daliu/Desktop/job/Modules/tcyapp/Pods/YTXChat/YTXChat/Classes/EMUI/Helper/3rdParty/MWPhotoBrowser/Classes/MWGridCell.h");
//        File ff2 = FileUtil.getFileWithChangedSuffix(ff1, ".m");
//        if (!ff2.exists()) {
//            // .h..m
//            System.out.println(ff2);
//        }

        // 1. 寻找所有继承于上述三种类的文件
        List<String> stringList = new ArrayList<String>() {
            {
                add(": UITableViewCell");
                add(":UITableViewCell");
                add(": UITableViewHeaderFooterView");
                add(":UITableViewHeaderFooterView");
                add(":UICollectionViewCell");
                add(":UICollectionViewCell");
            }
        };
        List<File> files = FileUtil.getAllFilesContainStrInList(dirPath, stringList, false);
        List<File> changedFiles = new ArrayList<>();
        for (File file : files) {
            if (file.getAbsolutePath().contains("Pods/Headers")) {
                continue;
            }
            //System.out.println(file.getAbsolutePath());
            if (file.getName().endsWith(".h")) {
                // 寻找对应的.m
                File changedFile = FileUtil.getFileWithChangedSuffix(file, ".m");
                if (changedFile.exists()) {
                    //System.out.println(changedFile.getAbsolutePath());
                } else {
                    // /Users/daliu/Desktop/job/Modules/tcyapp/Pods/YTXChat/YTXChat/Classes/EMUI/Helper/3rdParty/MWPhotoBrowser/Classes/MWGridCell.h
                    // .m是存在的
                    //System.out.println("Not found!");
                }
            } else {
                changedFiles.add(file);
            }
        }

        //System.out.println("继承相关cell的清单：");
        //logFileList(changedFiles);
        System.out.println("------------------");
        System.out.println("需要修改的文件清单：");
        for (File changedFile : changedFiles) {
            if (FileUtil.convertFileToString(changedFile).contains("[self addSubview:")) {
                System.out.println(changedFile.getAbsolutePath());
            }
        }
    }

    public static void logFileList(List<File> list) {
        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
    }
}

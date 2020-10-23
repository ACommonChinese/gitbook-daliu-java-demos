// http://c.biancheng.net/view/1206.html
// Box Layout: https://developer.ibm.com/zh/articles/j-lo-boxlayout/
package cn.yintech;

import javax.swing.*;

public class RenameUI extends JFrame {
    public void init() {
        setTitle("Replace tool");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         | ------------------------------------|
         | 路径                                |
         | 有效文件后缀 ______________________  |
         | 进度显示                             |
         |-------------------------------------|
         |            |                        |
         |   ...      |                        |
         |   ...      |                        |
         |   ...      |                        |
         |            |                        |
         |            |                        |
         | ------------------------------------|
         */
        Box box = Box.createVerticalBox(); // 纵向Box容器
        add(box);
        box.add(Box.createVerticalStrut(60)); // VerticalStrut 固高

        setVisible(true);
    }

    public static void main(String[] args) {
        new RenameUI().init();
    }
}

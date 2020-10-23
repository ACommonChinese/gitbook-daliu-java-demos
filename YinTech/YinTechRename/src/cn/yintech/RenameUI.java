// C中文网：http://c.biancheng.net/view/1206.html
// Box Layout: https://developer.ibm.com/zh/articles/j-lo-boxlayout/

package cn.yintech;

import javax.swing.*;
import java.awt.*;

public class RenameUI extends JFrame {
    public void init() {
        setTitle("Replace tool");
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
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(800, 600));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        PanelUtil util = new PanelUtil();

        contentPanel.add(util.getPathPanel()); // 路径
        util.getPathPanel().setDidChoose(file -> {
            util.getInfoPanel().setInfo("Start process ...");

        });

        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(util.getCheckBoxPanel()); // 复选框
        contentPanel.add(util.getInfoPanel()); // 处理信息显示
        contentPanel.add(util.getBottomPanel()); // 底部视图

        contentPanel.add(Box.createVerticalGlue());
        setContentPane(contentPanel);
        setSize(300, 400);
        setContentPane(contentPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new RenameUI().init();
    }
}

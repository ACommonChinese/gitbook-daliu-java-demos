package cn.yintech;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 路径
class PathPanel extends JPanel {
    public JLabel label = new JLabel();
    public JButton button = new JButton();

    public PathPanel() {
        // Component verticalStrut = Box.createVerticalStrut(60);
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);
        this.add(Box.createHorizontalStrut(20));
        this.add(label);
        this.add(Box.createHorizontalGlue());
        this.add(button);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileSystemView systemView = FileSystemView.getFileSystemView();
                fileChooser.setCurrentDirectory(systemView.getHomeDirectory());
                fileChooser.setDialogTitle("选择要更改名字的根目录文件夹");
                fileChooser.setApproveButtonText("确定");
            }
        });
    }
}

// 忽略文件
class IgnorePanel extends JPanel {

}

// 进度
class InfoPanel extends JPanel {}

// 输入替换文件
class ReplaceCandidatePanel extends JPanel {}

// 替换按钮
class ReplaceButton extends JButton {}

class ProgressPanel extends JPanel {

}

public class PanelUtil {
    public PathPanel pathPanel;
    public IgnorePanel ignorePanel;
    public InfoPanel infoPanel;

}

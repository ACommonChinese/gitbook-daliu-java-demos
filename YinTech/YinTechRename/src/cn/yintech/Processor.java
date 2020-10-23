package cn.yintech;

import java.io.BufferedReader;

interface IProcessor {
    /// 处理出现错误
    void onError(String message);
    /// 处理中，多次回调
    void onProcessing(String info);
    /// 处理完成
    void onFinish();
}

class Item {
    private String src;
    private String dest;
}

public class Processor {
    IProcessor delegate;

    public void process(String content) {
        if (content == null || content.trim().length() == 0) {
            if (delegate != null) {
                delegate.onError("过替换的文本输入不合法，请重新输入！");
            }
        } else {
            String text = content.trim();

        }
    }
}

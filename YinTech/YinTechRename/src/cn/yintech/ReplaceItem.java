package cn.yintech;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

public class ReplaceItem {
    private String src;
    private String dest;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public List<ReplaceItem> itemsFromText(String text) {
        if (text == null || text.length() <= 0) {
            return null;
        }
        //ByteArrayInputStream inputStream = new ByteArrayInputStream(text.getBytes());
        //BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        //https://stackoverflow.com/questions/1096621/read-string-line-by-line
        BufferedReader reader = new BufferedReader(new StringReader(text));
        String newline = null;
        while ((newline = reader.readLine()) != null) {

        }
    }
}

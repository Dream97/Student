package studentdata;
import swing.MainFrame;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        TreeMap<String,Student> map = new TreeMap<String,Student>();//使用TreeMap将Student类排序起来
        ReadFile rf = new ReadFile(map);//读取文件中的内容放到map上
        new MainFrame(map);//进入主界面
    }
}

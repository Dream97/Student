package studentdata;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class WriteFile {
    public WriteFile(TreeMap<String,Student> map) throws IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("students.dat")));//打开文件
        output.writeInt(map.size());//首先写入学生个数
        Iterator<String> i = map.keySet().iterator();//使用迭代器访问各个学生key值（学号）
        for(int j =0 ;j<map.size();j++) {
                Student st = map.get(i.next());//顺序访问map中的学生
                output.writeUTF(st.ID);
                output.writeUTF(st.name);
                output.writeDouble(st.classscore[0]);
                output.writeDouble(st.classscore[1]);
                output.writeDouble(st.classscore[2]);

                output.writeDouble(st.classtest[0]);
                output.writeDouble(st.classtest[1]);
                output.writeDouble(st.classtest[2]);

                output.writeDouble(st.homework[0]);
                output.writeDouble(st.homework[1]);
                output.writeDouble(st.homework[2]);

                output.writeDouble(st.Test);
                output.writeDouble(st.total);
        }
            output.close();//关闭文件

    }
}


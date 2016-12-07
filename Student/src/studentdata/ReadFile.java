package studentdata;


import java.io.*;
import java.util.TreeMap;

/**
 *
 * @author hasee
 */
public class ReadFile {
    public ReadFile(TreeMap<String,Student> map) throws IOException {
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("students.dat")));//打开文件
        int k = input.readInt();//文件中的第一个数据是学生的个数
        Student[] st = new Student[k];//创建学生数组
        for(int j = 0;j<k ;j++)//将所有内容读取到数组中
        {
            st[j] = new Student(input.readUTF(), input.readUTF());
            st[j].setclascore(input.readDouble(), input.readDouble(), input.readDouble());
            st[j].setclastest(input.readDouble(), input.readDouble(), input.readDouble());
            st[j].sethomewoek(input.readDouble(), input.readDouble(), input.readDouble());
            st[j].settest(input.readDouble());
            st[j].settotal(input.readDouble());
            map.put(st[j].ID,st[j]);//将学生类存进map
        }
        input.close();
    }
}

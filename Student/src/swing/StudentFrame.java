package swing;

import studentdata.Student;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.util.TreeMap;
/*
学生查询成绩主面板
 */

public class StudentFrame {
    private JFrame jf = new JFrame();
    private JPanel jp = new JPanel();

    public StudentFrame(TreeMap<String,Student> map)
    {
        jf.setTitle("学生查询成绩界面");
        jp = new FindStudent(map);//查询成绩面板

        jf.add(jp);
        jp.setBounds(0,0,600,400);
        jf.setLocation(500,400);
        jf.setMinimumSize(new Dimension(600,400));
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

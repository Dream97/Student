package swing;

import studentdata.Student;
import studentdata.WriteFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

/**
 * Created by super on 2016/12/4.
 */
public class TeacherFrame {
    private JFrame jf = new JFrame();
    private JPanel jp = new JPanel();
    private JPanel jp1 = new JPanel();
    private JSplitPane sl = new JSplitPane();

    private ButtonGroup g = new ButtonGroup();//使用单选按钮

    private JRadioButton jb = new JRadioButton("添加学生成绩");
    private JRadioButton jb1 = new JRadioButton("查看单个学生成绩");
    private JRadioButton jb2 = new JRadioButton("修改学生成绩");
    private JRadioButton jb3 = new JRadioButton("删除学生成绩");
    private JRadioButton jb4 = new JRadioButton("统计学生成绩");

    private JPanel jp2 ;
    private JPanel jp3 ;
    private JPanel jp4 ;
    private JPanel jp5 ;
    private JPanel jp6 ;
    TreeMap<String,Student> map ;

    public TeacherFrame(TreeMap<String, Student> map1)
    {
        this.map = map1;
        jf.setTitle("教师管理界面");

        jp.setLayout(null);
        jp1.setLayout(null);

        /*
        设置单选按钮
         */
        jp.add(jb);
        jb.setBounds(30,30,150,30);

        jp.add(jb1);
        jb1.setBounds(30,80,150,30);

        jp.add(jb2);
        jb2.setBounds(30,130,150,30);

        jp.add(jb3);
        jb3.setBounds(30,180,150,30);

        jp.add(jb4);
        jb4.setBounds(30,230,150,30);

        g.add(jb);
        g.add(jb1);
        g.add(jb2);
        g.add(jb3);
        g.add(jb4);


        JLabel text = new JLabel("学生成绩管理系统");
        text.setFont(new Font("宋体",Font.BOLD,50));
        jp1.add(text);
        text.setBounds(300,300,500,100);

        sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp,jp1);//将主界面分为左右两个面板
        jp.setMinimumSize(new Dimension(200,800));
        jp1.setMinimumSize(new Dimension(1000,800));
        Listener();//对单选按钮进行监听


        jf.add(sl);
        jf.setLocation(400,200);
        jf.setMinimumSize(new Dimension(1300,800));
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void Listener() {
       jb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //将添加学生成绩面板放置在右边
               jp2 = new AddStudentPane(map);
               jp1.removeAll();
               jp1.updateUI();
               jp1.add(jp2);
               jp2.setBounds(10,10,1000,800);
               jp1.repaint();
           }
       });
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将查询学生成绩面板放置右边
                jp3 = new CheckStudentPane(map);
                jp1.removeAll();
                jp1.updateUI();
                jp1.add(jp3);
                jp3.setBounds(10,10,1000,800);
                jp1.repaint();
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将修改学生成绩面板放置右边
                jp4 = new ChangeStudentPane(map);
                jp1.removeAll();
                jp1.updateUI();
                jp1.add(jp4);
                jp4.setBounds(10,10,1000,800);
                jp1.repaint();
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将删除学生面板放置右边
                jp5 = new DeleteStudentsPane(map);
                jp1.removeAll();
                jp1.updateUI();
                jp1.add(jp5);
                jp5.setBounds(10,10,1000,800);
                jp1.repaint();
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将统计学生面板放置右边
                jp6 = new StudentsTablePane(map);
                jp1.add(jp6);
                jp6.setBounds(10,10,1000,800);
            }
        });
        jf.setVisible(true);//刷新整个界面
    }
}

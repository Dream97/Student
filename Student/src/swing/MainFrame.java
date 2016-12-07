package swing;

import studentdata.Student;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
public class MainFrame {
    private JFrame jf = new JFrame();
    private JPanel jp = new JPanel();
    private JLabel title = new JLabel("学生成绩管理系统");
    private JComboBox b = new JComboBox();
    private String[] items ={"Teacher","Student"};
    private String[] sort = {"编号","学号"};
    private JLabel sorttext = new JLabel(sort[0]);
    private JLabel passtext = new JLabel("密码");
    private JTextField tf = new JTextField(10);
    private JPasswordField tf2 = new JPasswordField(10);
    private JButton jb = new JButton("登录");
    private TreeMap<String,Student> map;

    public MainFrame(TreeMap<String, Student> map1)
    {
        this.map = map1;
        jp.setLayout(null);
        title.setFont(new Font("宋体",Font.BOLD,25));
        jp.add(title);
        title.setBounds(90,50,300,50);

        for(int j = 0 ;j<2;j++)
        {
            b.addItem(items[j]);
        }
        jp.add(b);
        b.setBounds(95,120,200,30);

        jp.add(sorttext);
        sorttext.setBounds(95,160,60,30);

        jp.add(tf);
        tf.setBounds(125,160,170,30);

        jp.add(passtext);
        passtext.setBounds(95,180,60,60);

        jp.add(tf2);
        tf2.setBounds(125,200,170,30);

        jp.add(jb);
        jb.setBounds(95,240,80,30);
        Listener();

        jf.pack();
        jf.add(jp);
        jf.setMinimumSize(new Dimension(400,400));
        jf.setLocation(720,400);
        jf.setVisible(true);
        map1 = this.map;
    }

    private void Listener() {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b.getSelectedItem()==items[0])
                {
                    sorttext.setText(sort[0]);
                }
                else
                {
                    //tf.removeAll();
                    tf = new JTextField(10);
                    //jp.add(tf);
                    //tf.setBounds(125,160,170,30);
                    sorttext.setText(sort[1]);
                }
                jf.setVisible(true);
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(b.getSelectedItem()==items[0])
                {
                    if(true)
                    {
                        new TeacherFrame(map);
                        jf.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"密码错误");
                    }
                }
                else
                {
                    new StudentFrame(map);
                    jf.dispose();
                }
            }
        });
    }

}

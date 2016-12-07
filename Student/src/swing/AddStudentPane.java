package swing;
import studentdata.Student;
import studentdata.WriteFile;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.TreeMap;

import javax.swing.*;
/*
添加学生面板:用于添加某一学生成绩
 */

public class AddStudentPane extends JPanel{
   private JPanel jp = new JPanel();
   
   private JLabel title = new JLabel("添加学生成绩");
   
   private JLabel id = new JLabel("学号         ");
   private JTextField it = new JTextField(10);
   
   private JLabel name = new JLabel("学生名字");
   private JTextField nt = new JTextField(10);
   
   private JLabel clasroce = new JLabel("课堂考勤");
   private JTextField cs1 = new JTextField(10);
   private JTextField cs2 = new JTextField(10);
   private JTextField cs3 = new JTextField(10);
   private JLabel zx = new JLabel("(0代表缺席，100代表到场)");
   
   private JLabel clatest = new JLabel("课堂考试");
   private JTextField ts1 = new JTextField(10);
   private JTextField ts2 = new JTextField(10);
   private JTextField ts3 = new JTextField(10);
   
   private JLabel homework = new JLabel("家庭作业");
   private JTextField hw1 = new JTextField(10);
   private JTextField hw2 = new JTextField(10);
   private JTextField hw3 = new JTextField(10);
   
   private JLabel tatol = new JLabel("期末成绩");
   private JTextField tt = new JTextField(10);
    
   private JButton jb = new JButton("确认添加");

	TreeMap<String,Student> map ;
   public AddStudentPane(TreeMap<String, Student> map1)
   {
	   this.map = map1;
	   this.setLayout(null);
	   jp.setLayout(null);

	   //课堂考勤
	   Box b1 = Box.createHorizontalBox();
	   b1.add(clasroce);
	   b1.add(Box.createHorizontalStrut(10));
	   b1.add(cs1);
	   b1.add(cs2);
	   b1.add(cs3);
	   b1.add(zx);

	   //课堂测试
	   Box b2 = Box.createHorizontalBox();
	   b2.add(clatest);
	   b2.add(Box.createHorizontalStrut(10));
	   b2.add(ts1);
	   b2.add(ts2);
	   b2.add(ts3);

	   //课后作业
	   Box b3 = Box.createHorizontalBox();
	   b3.add(homework);
	   b3.add(Box.createHorizontalStrut(10));
	   b3.add(hw1);
	   b3.add(hw2);
	   b3.add(hw3);

	   //期末考试
	   Box b4 = Box.createHorizontalBox();
	   b4.add(tatol);
	   b4.add(Box.createHorizontalStrut(10));
	   b4.add(tt);

	   //学号
	   Box b5 = Box.createHorizontalBox();
	   b5.add(id);
	   b5.add(Box.createHorizontalStrut(10));
	   b5.add(it);

	   //名字
	   Box b6 = Box.createHorizontalBox();
	   b6.add(name);
	   b6.add(Box.createHorizontalStrut(10));
	   b6.add(nt);
	   
	   //为该面板设置title
	   jp.add(title);

	   jp.add(b5);
	   jp.add(b6);
	   
	   jp.add(b1);
	   jp.add(b2);
	   jp.add(b3);
	   jp.add(b4);
	   jp.add(jb);//确定添加按钮

	   //为各个组件设置位置
	   title.setBounds(2, 2, 310, 30);
	   b5.setBounds(2, 35, 310, 30);
	   b6.setBounds(2, 70, 310, 30);
	   b1.setBounds(2, 110, 463, 30);
	   b2.setBounds(2, 145, 310, 30);
	   b3.setBounds(2, 180, 310, 30);
	   b4.setBounds(2, 225, 310, 30);
	   jb.setBounds(65, 260, 100, 30);

	   Listener();//设置监听器

	   this.add(jp);
	   jp.setBounds(0,0,1000,800);
	   this.setMinimumSize(new Dimension(1000,800));
      map1 = map;//更新原来的map
   }

	private void Listener() {
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s =it.getText();
				if(s.length()!=0) {
					/*
					读取输入的学生信息
					 */
					Student student = new Student(it.getText(), nt.getText());
					student.setclascore(Double.valueOf(cs1.getText()), Double.valueOf(cs2.getText()), Double.valueOf(cs3.getText()));
					student.setclastest(Double.valueOf(ts1.getText()), Double.valueOf(ts2.getText()), Double.valueOf(ts3.getText()));
					student.sethomewoek(Double.valueOf(hw1.getText()), Double.valueOf(hw2.getText()), Double.valueOf(hw3.getText()));
					student.settest(Double.valueOf(tt.getText()));
					map.put(student.getID(), student);//将学生添加到map中

					JOptionPane.showMessageDialog(null,"添加成功");//显示添加成功信息
					/*
					将面板内容清空
					 */
					it.setText("");
					nt.setText("");
					cs1.setText("");
					cs2.setText("");
					cs3.setText("");
					ts1.setText("");
					ts2.setText("");
					ts3.setText("");
					hw1.setText("");
					hw2.setText("");
					hw3.setText("");
					tt.setText("");
					/*
					写入文件
					 */
					try {
						WriteFile wf = new WriteFile(map);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else JOptionPane.showMessageDialog(null,"添加失败");//如果学号为空的话就添加失败

			}
		});
	}

}

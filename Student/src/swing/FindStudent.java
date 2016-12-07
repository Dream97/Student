package swing;

import studentdata.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
/*
学生查询成绩面板（学生版）
 */
public class FindStudent extends JPanel {
	private JPanel jp = new JPanel();

	private JLabel title = new JLabel("查找学生成绩");

	private JLabel id = new JLabel("学号        ");
	private JTextField idf = new JTextField(10);

	private JLabel name = new JLabel("名字        ");
	private JTextField namef = new JTextField(10);

	private JButton jb = new JButton("查询");

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

	private JLabel exam = new JLabel("期末成绩");
	private JTextField et = new JTextField(10);

	private JLabel total = new JLabel("总评成绩 ");
	private JTextField tot = new JTextField(10);
	TreeMap<String, Student> map;
	Student stu;

	public FindStudent(TreeMap<String, Student> map1) {
		map = map1;
		this.setLayout(null);
		jp.setLayout(null);

		Box b1 = Box.createHorizontalBox();//学号查询框
		b1.add(id);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(idf);

		Box b6 = Box.createHorizontalBox();//名字输入框
		b6.add(name);
		b6.add(Box.createHorizontalStrut(10));
		b6.add(namef);

		//将各组件添加到面板上
		jp.add(title);
		jp.add(b1);
		jp.add(b6);
		jp.add(jb);

		b6.setBounds(2, 70, 310, 30);
		title.setBounds(2, 2, 300, 30);
		b1.setBounds(2, 35, 310, 30);
		jb.setBounds(63, 110, 100, 30);

		Listener();//设置监听

		this.add(jp);
		jp.setBounds(10, 10, 1000, 800);
		this.setMinimumSize(new Dimension(1000, 800));
	}

	private void Listener() {
		// TODO Auto-generated method stub
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
               //如果输入学号的学生与名字对应
				if (map.get(idf.getText()) != null && map.get(idf.getText()).getName().equals(namef.getText())) {
					stu = map.get(idf.getText());
					//将查询到的学生信息添加到面板上
					Box b1 = Box.createHorizontalBox();//考勤
					b1.add(clasroce);
					b1.add(Box.createHorizontalStrut(10));
					b1.add(cs1);
					b1.add(cs2);
					b1.add(cs3);
					b1.add(zx);
					double[] d = new double[3];
					d = stu.getclascore();
					cs1.setText(String.valueOf(d[0]));
					cs2.setText(String.valueOf(d[1]));
					cs3.setText(String.valueOf(d[2]));

					Box b2 = Box.createHorizontalBox();//课堂测试
					b2.add(clatest);
					b2.add(Box.createHorizontalStrut(10));
					b2.add(ts1);
					b2.add(ts2);
					b2.add(ts3);
					double[] d1 = new double[3];
					d1 = stu.getclatest();
					ts1.setText(String.valueOf(d1[0]));
					ts2.setText(String.valueOf(d1[1]));
					ts3.setText(String.valueOf(d1[2]));

					Box b3 = Box.createHorizontalBox();//课后作业
					b3.add(homework);
					b3.add(Box.createHorizontalStrut(10));
					b3.add(hw1);
					b3.add(hw2);
					b3.add(hw3);
					double[] d2 ;
					d2 = stu.gethomwork();
					hw1.setText(String.valueOf(d2[0]));
					hw2.setText(String.valueOf(d2[1]));
					hw3.setText(String.valueOf(d2[2]));


					Box b4 = Box.createHorizontalBox();//期末考试
					b4.add(exam);
					b4.add(Box.createHorizontalStrut(10));
					b4.add(et);
					et.setText(String.valueOf(stu.gettest()));

					Box b5 = Box.createHorizontalBox();//总评成绩
					b5.add(total);
					b5.add(Box.createHorizontalStrut(8));
					b5.add(tot);
					tot.setText(String.valueOf(stu.gettotal()));

					//各组件添加到面板上
					jp.add(b1);
					jp.add(b2);
					jp.add(b3);
					jp.add(b4);
					jp.add(b5);

					b1.setBounds(2, 155, 463, 30);
					b2.setBounds(2, 190, 310, 30);
					b3.setBounds(2, 225, 310, 30);
					b4.setBounds(2, 260, 310, 30);
					b5.setBounds(2, 295, 310, 30);

					//更新面板
					updateUI();
					repaint();

				} else {
					JOptionPane.showMessageDialog(null, "不存在该学生或名字不对");
				}
			}
		});
	}
}

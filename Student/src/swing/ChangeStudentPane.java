package swing;
import studentdata.Student;
import studentdata.WriteFile;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
修改学生成绩面板
 */
public class ChangeStudentPane extends JPanel {

	private JPanel jp = new JPanel();
    
    private JLabel title  = new JLabel("修改学生成绩");
    
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
    
    private JButton jb2 = new JButton("确认修改");
    
    JDialog  jd = new JDialog();
    
    JButton jb3 = new JButton("Yes");
	JButton jb4 = new JButton("No");
	TreeMap<String,Student> map;
	Student stu ;

    public ChangeStudentPane(TreeMap<String, Student> map1)
    {
		map = map1;
    	jp.setLayout(null);
    	this.setLayout(null);

		//学号框
    	Box b1 = Box.createHorizontalBox();
    	b1.add(id);
		b1.add(Box.createHorizontalStrut(10));
    	b1.add(idf);
    	b1.setMaximumSize(new Dimension(30,300));

		jp.add(title);//一段文字
		jp.add(b1);//学号查询框
		jp.add(jb);//确定修改按钮

		//为各个组件设置位置
		title.setBounds(2,2,300,30);
    	b1.setBounds(2,35,310,30);
    	jb.setBounds(63, 70, 100, 30);
    	
    	Listener();//设置监听

		this.add(jp);
		jp.setBounds(10,10,1000,800);
		this.setMinimumSize(new Dimension(1000,800));

		map1 = map;//更新map
    }
    
    private void Listener() {
		// TODO Auto-generated method stub
    	jb.addActionListener(new ActionListener()
    			{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(map.get(idf.getText())!=null)
							{
								stu = map.get(idf.getText());//获取查询学生信息
								/*
								添加各个组件，并赋值
								 */
								Box b1 = Box.createHorizontalBox();//考勤成绩
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
								double[] d2 = new double[3];
								d2 = stu.gethomwork();
								hw1.setText(String.valueOf(d2[0]));
								hw2.setText(String.valueOf(d2[1]));
								hw3.setText(String.valueOf(d2[2]));

								Box b4 = Box.createHorizontalBox();//期末考试成绩
								b4.add(exam);
								b4.add(Box.createHorizontalStrut(10));
								b4.add(et);
								et.setText(String.valueOf(stu.gettest()));

								Box b5 =Box.createHorizontalBox();//总评成绩
								b5.add(total);
								b5.add(Box.createHorizontalStrut(8));
								b5.add(tot);
								tot.setText(String.valueOf(stu.gettotal()));
								tot.setEditable(false);

								Box b6 = Box.createHorizontalBox();//姓名
								b6.add(name);
								b6.add(Box.createHorizontalStrut(10));
								b6.add(namef);
								namef.setText(stu.getName());

					    	    //添加到面板上
					            jp.add(b6);
						        jp.add(b1);
								jp.add(b2);
								jp.add(b3);
								jp.add(b4);
								jp.add(b5);
								jp.add(jb2);

								//为各个组件设置位置
								b6.setBounds(2,120,310,30);
								b1.setBounds(2, 155, 463, 30);
								b2.setBounds(2, 190, 310, 30);
								b3.setBounds(2, 225, 310, 30);
								b4.setBounds(2, 260, 310, 30);
								b5.setBounds(2,295,310,30);
						        jb2.setBounds(63, 330, 100, 30);
						   
						        Listener2();//对修改按钮监听
								/*
								更新面板
								 */
								updateUI();
								repaint();
						   
							}
						else{
							JOptionPane.showMessageDialog(null,"不存在该学生");
						}
					}
    			});
	}

	protected void Listener2() {
		// TODO Auto-generated method stub
		jb2.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JPanel jp1 = new JPanel();//创建一个类似对话框的东西
						jp1.setLayout(null);

						/*
						添加确定和取消两个按钮
						 */
						JLabel ct = new JLabel("确认修改");
						Box b = Box.createHorizontalBox();
						b.add(jb3);
						b.add(Box.createGlue());
						b.add(jb4);
						
						jp1.add(ct);
						jp1.add(b);
						
						ct.setBounds(70, 50, 100, 30);
						b.setBounds(30, 80, 120, 30);
						
						Listener3();//对两个按钮监听
						
						jd.add(jp1);
						jd.setMinimumSize(new Dimension(200,200));
						jd.setLocation(700, 500);
						jd.show();

					}
			
				});
		
	}

	protected void Listener3() {
		// TODO Auto-generated method stub
		jb3.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						/*
						更改该学生的信息
						 */
						stu.setName(namef.getText());
						stu.setclascore(Double.valueOf(cs1.getText()), Double.valueOf(cs2.getText()), Double.valueOf(cs3.getText()));
						stu.setclastest(Double.valueOf(ts1.getText()), Double.valueOf(ts2.getText()), Double.valueOf(ts3.getText()));
						stu.sethomewoek(Double.valueOf(hw1.getText()), Double.valueOf(hw2.getText()), Double.valueOf(hw3.getText()));
						stu.settest(Double.valueOf(et.getText()));
						jd.dispose();

						/*
						写入文件
						 */
						try {
							WriteFile wf = new WriteFile(map);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			
				});
		jb4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jd.dispose();
			}
	
		});
	}
}

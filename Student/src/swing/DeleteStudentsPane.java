package swing;
import studentdata.Student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteStudentsPane extends JPanel{
    private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
    
    private JLabel title  = new JLabel("删除学生成绩");
    
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
    
    private JButton jb2 = new JButton("确认删除");
    
    JDialog  jd = new JDialog();
    
    JButton jb3 = new JButton("Yes");
	JButton jb4 = new JButton("No");
	TreeMap<String, Student> map;
	Student stu ;
    public DeleteStudentsPane(TreeMap<String,Student> map1)
    {
		map = map1;
    	jp.setLayout(null);
		jp1.setLayout(null);//使用一个组件显示 查询到的信息
		this.setLayout(null);

    	Box b1 = Box.createHorizontalBox();//学号框
    	b1.add(id);
		b1.add(Box.createHorizontalStrut(10));
    	b1.add(idf);
    	b1.setMaximumSize(new Dimension(30,300));
    	
    	jp.add(title);
    	jp.add(b1);//添加学号框
    	jp.add(jb);//添加按钮

		//设置各组件的位置
    	title.setBounds(2,2,300,30);
    	b1.setBounds(2,35,310,30);
    	jb.setBounds(63, 70, 100, 30);
    	
    	Listener();//设置监听

		this.add(jp);
		jp.setBounds(10,10,1000,800);
		this.setMinimumSize(new Dimension(1000,800));
		map1 = map;
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
								stu = map.get(idf.getText());

								/*
								显示查询到的学生信息
								 */
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
								double[] d2 = new double[3];
								d2 = stu.gethomwork();
								hw1.setText(String.valueOf(d2[0]));
								hw2.setText(String.valueOf(d2[1]));
								hw3.setText(String.valueOf(d2[2]));


								Box b4 = Box.createHorizontalBox();//期末考试
								b4.add(exam);
								b4.add(Box.createHorizontalStrut(10));
								b4.add(et);
								et.setText(String.valueOf(stu.gettest()));

								Box b5 =Box.createHorizontalBox();//总评成绩
								b5.add(total);
								b5.add(Box.createHorizontalStrut(8));
								b5.add(tot);
								tot.setText(String.valueOf(stu.gettotal()));

								Box b6 = Box.createHorizontalBox();//名字
								b6.add(name);
								b6.add(Box.createHorizontalStrut(10));
								b6.add(namef);
								namef.setText(stu.getName());

								//将将要显示的组件放到一个新的面板上
								jp1.add(b6);
								jp1.add(b1);
								jp1.add(b2);
								jp1.add(b3);
								jp1.add(b4);
								jp1.add(b5);
								jp1.add(jb2);

								b6.setBounds(2,0,310,30);
								b1.setBounds(2, 35, 463, 30);
								b2.setBounds(2, 70, 310, 30);
								b3.setBounds(2, 105, 310, 30);
								b4.setBounds(2, 140, 310, 30);
								b5.setBounds(2,175,310,30);
						        jb2.setBounds(63, 210, 100, 30);

								jp.add(jp1);//将新的面板放在jp面板上
								jp1.setBounds(0,120,1000,800);

								//更新面板
						        updateUI();
								repaint();
								Listener2();//设置监听
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
						/*
						创建一个类似对话框的面板
						 */
						JPanel jp2 = new JPanel();
						jp2.setLayout(null);
						
						JLabel ct = new JLabel("确认删除");

						Box b = Box.createHorizontalBox();//添加俩个按钮，确定与取消
						b.add(jb3);
						b.add(Box.createGlue());
						b.add(jb4);
						
						jp2.add(ct);
						jp2.add(b);
						
						ct.setBounds(70, 50, 100, 30);
						b.setBounds(30, 80, 120, 30);
						
						Listener3();//设置监听
						
						jd.add(jp2);
						jd.setMinimumSize(new Dimension(200,200));
						jd.setLocation(700, 500);
						jd.setVisible(true);
						
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
						map.remove(stu.getID());//删除对应的学生
						jp.remove(jp1);//将新面板从jp上清除
						//更新面板
						updateUI();
						repaint();
						jd.dispose();
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

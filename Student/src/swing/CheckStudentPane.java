package swing;
import studentdata.Student;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.TreeMap;

import javax.swing.*;
/*
��ѯѧ���ɼ����
 */
public class CheckStudentPane extends JPanel {
    private JPanel jp = new JPanel();
    
    private JLabel title  = new JLabel("����ѧ���ɼ�");
    
    private JLabel id = new JLabel("ѧ��        ");
    private JTextField idf = new JTextField(10);
    
    private JLabel name = new JLabel("����        ");
    private JTextField namef = new JTextField(10);
    
    private JButton jb = new JButton("��ѯ");
    
    private JLabel clasroce = new JLabel("���ÿ���");
    private JTextField cs1 = new JTextField(10);
    private JTextField cs2 = new JTextField(10);
    private JTextField cs3 = new JTextField(10);
    private JLabel zx = new JLabel("(0����ȱϯ��100������)");
    
    private JLabel clatest = new JLabel("���ÿ���");
    private JTextField ts1 = new JTextField(10);
    private JTextField ts2 = new JTextField(10);
    private JTextField ts3 = new JTextField(10);
    
    private JLabel homework = new JLabel("��ͥ��ҵ");
    private JTextField hw1 = new JTextField(10);
    private JTextField hw2 = new JTextField(10);
    private JTextField hw3 = new JTextField(10);
    
    private JLabel exam = new JLabel("��ĩ�ɼ�");
    private JTextField et = new JTextField(10);
    
    private JLabel total = new JLabel("�����ɼ� ");
    private JTextField tot = new JTextField(10);
    TreeMap<String,Student> map ;
    Student stu ;

    public CheckStudentPane(TreeMap<String, Student> map1)
    {
		map = map1;
		this.setLayout(null);
    	jp.setLayout(null);

		//ѧ��
    	Box b1 = Box.createHorizontalBox();
    	b1.add(id);
		b1.add(Box.createHorizontalStrut(10));
    	b1.add(idf);
    	
    	jp.add(title);
    	jp.add(b1);//���ѧ�ſ�
    	jp.add(jb);//��Ӱ�ť

		//����λ��
    	title.setBounds(2,2,300,30);
    	b1.setBounds(2,35,310,30);
    	jb.setBounds(63, 70, 100, 30);
    	
    	Listener();//���ü���

		this.add(jp);
		jp.setBounds(10,10,1000,800);
		this.setMinimumSize(new Dimension(1000,800));
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

								//��ʾ��ѯ����ѧ����Ϣ
								Box b1 = Box.createHorizontalBox();//����
								b1.add(clasroce);
								b1.add(Box.createHorizontalStrut(10));
								b1.add(cs1);
								b1.add(cs2);
								b1.add(cs3);
								b1.add(zx);
								double[] d ;
								d = stu.getclascore();
								cs1.setText(String.valueOf(d[0]));
								cs2.setText(String.valueOf(d[1]));
								cs3.setText(String.valueOf(d[2]));

								Box b2 = Box.createHorizontalBox();//���ò���
								b2.add(clatest);
								b2.add(Box.createHorizontalStrut(10));
								b2.add(ts1);
								b2.add(ts2);
								b2.add(ts3);
								double[] d1 ;
								d1 = stu.getclatest();
								ts1.setText(String.valueOf(d1[0]));
								ts2.setText(String.valueOf(d1[1]));
								ts3.setText(String.valueOf(d1[2]));

								Box b3 = Box.createHorizontalBox();//�κ���ҵ
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


						        Box b4 = Box.createHorizontalBox();//��ĩ����
						        b4.add(exam);
								b4.add(Box.createHorizontalStrut(10));
								b4.add(et);
								et.setText(String.valueOf(stu.gettest()));

						        Box b5 =Box.createHorizontalBox();//����
								b5.add(total);
								b5.add(Box.createHorizontalStrut(8));
								b5.add(tot);
								tot.setText(String.valueOf(stu.gettotal()));

						        Box b6 = Box.createHorizontalBox();//����
								b6.add(name);
								b6.add(Box.createHorizontalStrut(10));
								b6.add(namef);
								namef.setText(stu.getName());

								//��ӵ������
								jp.add(b6);
								jp.add(b1);
								jp.add(b2);
								jp.add(b3);
								jp.add(b4);
								jp.add(b5);

								b6.setBounds(2,120,310,30);
								b1.setBounds(2, 155, 463, 30);
								b2.setBounds(2, 190, 310, 30);
								b3.setBounds(2, 225, 310, 30);
								b4.setBounds(2, 260, 310, 30);
								b5.setBounds(2,295,310,30);

								//�������
								updateUI();
								repaint();
							}
						else{
							JOptionPane.showMessageDialog(null,"�����ڸ�ѧ��");
						}
					}
    			});
	}
}

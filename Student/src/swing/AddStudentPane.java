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
���ѧ�����:�������ĳһѧ���ɼ�
 */

public class AddStudentPane extends JPanel{
   private JPanel jp = new JPanel();
   
   private JLabel title = new JLabel("���ѧ���ɼ�");
   
   private JLabel id = new JLabel("ѧ��         ");
   private JTextField it = new JTextField(10);
   
   private JLabel name = new JLabel("ѧ������");
   private JTextField nt = new JTextField(10);
   
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
   
   private JLabel tatol = new JLabel("��ĩ�ɼ�");
   private JTextField tt = new JTextField(10);
    
   private JButton jb = new JButton("ȷ�����");

	TreeMap<String,Student> map ;
   public AddStudentPane(TreeMap<String, Student> map1)
   {
	   this.map = map1;
	   this.setLayout(null);
	   jp.setLayout(null);

	   //���ÿ���
	   Box b1 = Box.createHorizontalBox();
	   b1.add(clasroce);
	   b1.add(Box.createHorizontalStrut(10));
	   b1.add(cs1);
	   b1.add(cs2);
	   b1.add(cs3);
	   b1.add(zx);

	   //���ò���
	   Box b2 = Box.createHorizontalBox();
	   b2.add(clatest);
	   b2.add(Box.createHorizontalStrut(10));
	   b2.add(ts1);
	   b2.add(ts2);
	   b2.add(ts3);

	   //�κ���ҵ
	   Box b3 = Box.createHorizontalBox();
	   b3.add(homework);
	   b3.add(Box.createHorizontalStrut(10));
	   b3.add(hw1);
	   b3.add(hw2);
	   b3.add(hw3);

	   //��ĩ����
	   Box b4 = Box.createHorizontalBox();
	   b4.add(tatol);
	   b4.add(Box.createHorizontalStrut(10));
	   b4.add(tt);

	   //ѧ��
	   Box b5 = Box.createHorizontalBox();
	   b5.add(id);
	   b5.add(Box.createHorizontalStrut(10));
	   b5.add(it);

	   //����
	   Box b6 = Box.createHorizontalBox();
	   b6.add(name);
	   b6.add(Box.createHorizontalStrut(10));
	   b6.add(nt);
	   
	   //Ϊ���������title
	   jp.add(title);

	   jp.add(b5);
	   jp.add(b6);
	   
	   jp.add(b1);
	   jp.add(b2);
	   jp.add(b3);
	   jp.add(b4);
	   jp.add(jb);//ȷ����Ӱ�ť

	   //Ϊ�����������λ��
	   title.setBounds(2, 2, 310, 30);
	   b5.setBounds(2, 35, 310, 30);
	   b6.setBounds(2, 70, 310, 30);
	   b1.setBounds(2, 110, 463, 30);
	   b2.setBounds(2, 145, 310, 30);
	   b3.setBounds(2, 180, 310, 30);
	   b4.setBounds(2, 225, 310, 30);
	   jb.setBounds(65, 260, 100, 30);

	   Listener();//���ü�����

	   this.add(jp);
	   jp.setBounds(0,0,1000,800);
	   this.setMinimumSize(new Dimension(1000,800));
      map1 = map;//����ԭ����map
   }

	private void Listener() {
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s =it.getText();
				if(s.length()!=0) {
					/*
					��ȡ�����ѧ����Ϣ
					 */
					Student student = new Student(it.getText(), nt.getText());
					student.setclascore(Double.valueOf(cs1.getText()), Double.valueOf(cs2.getText()), Double.valueOf(cs3.getText()));
					student.setclastest(Double.valueOf(ts1.getText()), Double.valueOf(ts2.getText()), Double.valueOf(ts3.getText()));
					student.sethomewoek(Double.valueOf(hw1.getText()), Double.valueOf(hw2.getText()), Double.valueOf(hw3.getText()));
					student.settest(Double.valueOf(tt.getText()));
					map.put(student.getID(), student);//��ѧ����ӵ�map��

					JOptionPane.showMessageDialog(null,"��ӳɹ�");//��ʾ��ӳɹ���Ϣ
					/*
					������������
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
					д���ļ�
					 */
					try {
						WriteFile wf = new WriteFile(map);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else JOptionPane.showMessageDialog(null,"���ʧ��");//���ѧ��Ϊ�յĻ������ʧ��

			}
		});
	}

}

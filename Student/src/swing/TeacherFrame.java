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

    private ButtonGroup g = new ButtonGroup();//ʹ�õ�ѡ��ť

    private JRadioButton jb = new JRadioButton("���ѧ���ɼ�");
    private JRadioButton jb1 = new JRadioButton("�鿴����ѧ���ɼ�");
    private JRadioButton jb2 = new JRadioButton("�޸�ѧ���ɼ�");
    private JRadioButton jb3 = new JRadioButton("ɾ��ѧ���ɼ�");
    private JRadioButton jb4 = new JRadioButton("ͳ��ѧ���ɼ�");

    private JPanel jp2 ;
    private JPanel jp3 ;
    private JPanel jp4 ;
    private JPanel jp5 ;
    private JPanel jp6 ;
    TreeMap<String,Student> map ;

    public TeacherFrame(TreeMap<String, Student> map1)
    {
        this.map = map1;
        jf.setTitle("��ʦ�������");

        jp.setLayout(null);
        jp1.setLayout(null);

        /*
        ���õ�ѡ��ť
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


        JLabel text = new JLabel("ѧ���ɼ�����ϵͳ");
        text.setFont(new Font("����",Font.BOLD,50));
        jp1.add(text);
        text.setBounds(300,300,500,100);

        sl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp,jp1);//���������Ϊ�����������
        jp.setMinimumSize(new Dimension(200,800));
        jp1.setMinimumSize(new Dimension(1000,800));
        Listener();//�Ե�ѡ��ť���м���


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
               //�����ѧ���ɼ����������ұ�
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
                //����ѯѧ���ɼ��������ұ�
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
                //���޸�ѧ���ɼ��������ұ�
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
                //��ɾ��ѧ���������ұ�
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
                //��ͳ��ѧ���������ұ�
                jp6 = new StudentsTablePane(map);
                jp1.add(jp6);
                jp6.setBounds(10,10,1000,800);
            }
        });
        jf.setVisible(true);//ˢ����������
    }
}

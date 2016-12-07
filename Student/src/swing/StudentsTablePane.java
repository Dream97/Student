package swing;
import studentdata.MergeSort;
import studentdata.Student;
import studentdata.WriteFile;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.*;

public class StudentsTablePane extends JPanel{
   private String[] title = {"ѧ��","����","��ĩ�ɼ�","�����ɼ�"};
   private String[] sort = {"ƽ��ֵ","���ֵ","��Сֵ","������","������","��������"};
    private Object[][] students ;
    private Object [][] grade;

   JPanel jp = new JPanel();
   
   private JTable jTable;//ʹ�ñ����ʾѧ���ɼ�
   private JTable jTable2 ;
   
   private JScrollPane js ;
   private JScrollPane js2 ;

   private Student[] stulist ;//ѧ��������

    private double average ;//ƽ����
    private double maxmum ;//�����
    private double minumum ;//��С��
    private double outstanding;//������
    private double stand;//������
    private double fail;//��������

   public StudentsTablePane(TreeMap<String, Student> map)
   {
       int k = map.size();//���ѧ������
       stulist =new Student[k];//����ѧ������
       Iterator<String> i = map.keySet().iterator();//ʹ�õ���������ѧ��keyֵ
       for(int j =0;j<k;j++)
       {
           stulist[j] = map.get(i.next());
       }

       students = new Object[k][4];
       grade = new Object[1][6];

       MergeSort.MergeSort(stulist);//��ѧ�������鰴�������ɼ��Ӵ�С����
       //Ϊ�б�ֵ
       for(int j = 0;j<k;j++)//����������
       {
           students[j][0] = stulist[j].getID();
           students[j][1] = stulist[j].getName();
           students[j][2] = stulist[j].gettest();
           students[j][3] = stulist[j].gettotal();
       }

       ComputeStudent(stulist);//ͳ�Ƹ�������
       /*
      ������������
        */
       grade[0][0] = String.format("%.2f",average);
       grade[0][1] = String.format("%.1f",maxmum);
       grade[0][2] = String.format("%.1f",minumum);
       grade[0][3] = String.format("%.2f",outstanding);
       grade[0][4] = String.format("%.2f",stand);
       grade[0][5] = String.format("%.2f",fail);

       jTable = new JTable(students,title);
       jTable2 =new JTable(grade,sort);

       js = new JScrollPane(jTable);//Ϊ������û���
       js2 = new JScrollPane(jTable2);

       /*
       ����������������
        */
       jp.setLayout(null);
	   this.setLayout(null);
	   jp.add(js);
	   js.setBounds(0, 0, 1000, 500);
	 
	   jp.add( js2);
	   js2.setBounds(0, 520, 1000, 39);
	   this.add(jp);
       jp.setBounds(0,0,1000,800);
       this.setMinimumSize(new Dimension(500,38));
   }

    private void ComputeStudent(Student[] stu) {
        //�����������
        for(int j = 0;j<stu.length;j++)
         {
             average = average+stu[j].gettotal();//����ƽ����
             if(stu[j].gettotal()>=90)
                 outstanding++;//������
             else if(stu[j].gettotal()>=60)
                 stand++;//����
             else fail++;//������
         }

         average = average/stu.length;
        maxmum = stu[0].gettotal();
        minumum = stu[stu.length-1].gettotal();
        outstanding = outstanding/stu.length;
        stand = stand/stu.length;
        fail = fail/stu.length;
    }

}

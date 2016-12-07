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
   private String[] title = {"学号","名字","期末成绩","总评成绩"};
   private String[] sort = {"平均值","最大值","最小值","优秀率","良好率","不及格率"};
    private Object[][] students ;
    private Object [][] grade;

   JPanel jp = new JPanel();
   
   private JTable jTable;//使用表格显示学生成绩
   private JTable jTable2 ;
   
   private JScrollPane js ;
   private JScrollPane js2 ;

   private Student[] stulist ;//学生类数组

    private double average ;//平均数
    private double maxmum ;//最大数
    private double minumum ;//最小数
    private double outstanding;//优秀率
    private double stand;//及格率
    private double fail;//不及格率

   public StudentsTablePane(TreeMap<String, Student> map)
   {
       int k = map.size();//获得学生数量
       stulist =new Student[k];//创建学生数组
       Iterator<String> i = map.keySet().iterator();//使用迭代器访问学生key值
       for(int j =0;j<k;j++)
       {
           stulist[j] = map.get(i.next());
       }

       students = new Object[k][4];
       grade = new Object[1][6];

       MergeSort.MergeSort(stulist);//将学生类数组按照总评成绩从大到小排列
       //为列表赋值
       for(int j = 0;j<k;j++)//内容输入表格
       {
           students[j][0] = stulist[j].getID();
           students[j][1] = stulist[j].getName();
           students[j][2] = stulist[j].gettest();
           students[j][3] = stulist[j].gettotal();
       }

       ComputeStudent(stulist);//统计各种数据
       /*
      将数据输入表格
        */
       grade[0][0] = String.format("%.2f",average);
       grade[0][1] = String.format("%.1f",maxmum);
       grade[0][2] = String.format("%.1f",minumum);
       grade[0][3] = String.format("%.2f",outstanding);
       grade[0][4] = String.format("%.2f",stand);
       grade[0][5] = String.format("%.2f",fail);

       jTable = new JTable(students,title);
       jTable2 =new JTable(grade,sort);

       js = new JScrollPane(jTable);//为表格设置滑框
       js2 = new JScrollPane(jTable2);

       /*
       将个组件放置面板上
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
        //计算各种数据
        for(int j = 0;j<stu.length;j++)
         {
             average = average+stu[j].gettotal();//计算平均数
             if(stu[j].gettotal()>=90)
                 outstanding++;//优秀数
             else if(stu[j].gettotal()>=60)
                 stand++;//及格
             else fail++;//不及格
         }

         average = average/stu.length;
        maxmum = stu[0].gettotal();
        minumum = stu[stu.length-1].gettotal();
        outstanding = outstanding/stu.length;
        stand = stand/stu.length;
        fail = fail/stu.length;
    }

}

package studentdata;
/*
学生类：存取学生各类信息
 */
public class Student {
    String ID;//学号
    String name;//名字
    double classscore[] = new double[3];//课堂考勤
    double classtest[] = new double[3];//课堂测试
	double homework[]  = new double[3];//课后作业
	double Test = 0; //期末考试
    double total = 0;//总评成绩

    public Student(String ID,String name)
    {
        this.ID = ID;
        this.name = name;
    }

    //修改器
    public void setName(String name)//修改名字
    {
        this.name = name;
    }
    public void setclascore(double i,double j,double k)//修改课堂考勤成绩
    {
      	this.classscore[0] = i;
      	this.classscore[1] = j;
      	this.classscore[2] = k;
    }
    public void setclastest(double i,double j,double k)//修改课堂测试
    {
      	this.classtest[0] = i;
      	this.classtest[1] = j;
      	this.classtest[2] = k;
    }
    public void sethomewoek(double i,double j,double k)//修改课后作业
    {
      	this.homework[0] = i;
      	this.homework[1] = j;
      	this.homework[2] = k;
    }
    public void settest(double test)//期末考试
    {
    	this.Test = test;
    }
    public void settotal(double total)//总评成绩
    {
    	this.total = total;
    }


    //访问器

    public String getID()
    {
        return ID;
    }
    public String getName()
    {
        return name;
    }
    public double[] getclascore()
   {
	   return classscore;
   }
    public double[] getclatest()
   {
	   return classtest;
   }
   public double[] gethomwork()
   {
	   return homework;
   }
   public double gettest()
   {
	   return Test;
   }
   public double gettotal()
   {
	   total = classscore[0]*0.01+classscore[1]*0.02+classscore[2]*0.02
			+classtest[0]*0.07+classtest[1]*0.07+classtest[2]*0.06
			+homework[0]*0.08+homework[1]*0.08+homework[2]*0.09
			+Test*0.5;
	   return total;
   }
}

package studentdata;
/*
ѧ���ࣺ��ȡѧ��������Ϣ
 */
public class Student {
    String ID;//ѧ��
    String name;//����
    double classscore[] = new double[3];//���ÿ���
    double classtest[] = new double[3];//���ò���
	double homework[]  = new double[3];//�κ���ҵ
	double Test = 0; //��ĩ����
    double total = 0;//�����ɼ�

    public Student(String ID,String name)
    {
        this.ID = ID;
        this.name = name;
    }

    //�޸���
    public void setName(String name)//�޸�����
    {
        this.name = name;
    }
    public void setclascore(double i,double j,double k)//�޸Ŀ��ÿ��ڳɼ�
    {
      	this.classscore[0] = i;
      	this.classscore[1] = j;
      	this.classscore[2] = k;
    }
    public void setclastest(double i,double j,double k)//�޸Ŀ��ò���
    {
      	this.classtest[0] = i;
      	this.classtest[1] = j;
      	this.classtest[2] = k;
    }
    public void sethomewoek(double i,double j,double k)//�޸Ŀκ���ҵ
    {
      	this.homework[0] = i;
      	this.homework[1] = j;
      	this.homework[2] = k;
    }
    public void settest(double test)//��ĩ����
    {
    	this.Test = test;
    }
    public void settotal(double total)//�����ɼ�
    {
    	this.total = total;
    }


    //������

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

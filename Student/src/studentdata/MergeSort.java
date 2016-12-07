package studentdata;

import swing.MainFrame;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by super on 2016/12/5.
 */
public class MergeSort {
    /*
    归并排序：将学生类的数组按总评成绩的高->低排序
     */
    public static void MergeSort(Student[] stu)
    {
        if(stu.length>1)
        {
            Student[]  firstHalf = new Student[stu.length/2];
            System.arraycopy(stu,0,firstHalf,0,stu.length/2);
            MergeSort(firstHalf);

            int secondHalfLength = stu.length - stu.length/2;
            Student[] secondHalf = new Student[secondHalfLength];
            System.arraycopy(stu,stu.length/2,secondHalf,0,secondHalfLength);
            MergeSort(secondHalf);

            Student[] temp = merge(firstHalf,secondHalf);
            System.arraycopy(temp,0,stu,0,temp.length);
        }
    }

    private static Student[] merge(Student[] firstHalf, Student[] secondHalf) {
        Student[] temp = new Student[firstHalf.length+secondHalf.length];

        int current1 = 0 ;
        int current2 = 0 ;
        int current3 = 0 ;
        while (current1<firstHalf.length&&current2<secondHalf.length)
        {
            if(firstHalf[current1].gettotal()>secondHalf[current2].gettotal())
            {
                temp[current3++] = firstHalf[current1++];
            }
            else
            {
                temp[current3++] = secondHalf[current2++];
            }
        }
        while(current1<firstHalf.length)
            temp[current3++] = firstHalf[current1++];
        while(current2<secondHalf.length)
            temp[current3++] = secondHalf[current2++];
        return temp ;
    }
}

package ����������ϰ;
import java.util.*;

public class ����������ϰ {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		student a[]=new student[4];
		for(int i=0;i<4;i++)
		{
			System.out.println("�������"+(i+1)+"��ѧ����������ѧ�ţ��ÿո����");
			a[i]=new student(input.next(),input.next());
		}
		for(int i=0;i<4;i++)
		{
			System.out.print("��"+(i+1)+"��ѧ����������ѧ��Ϊ��");
			a[i].print();
		}
	}

}

class student
{
	private String name,id;
	student(){}
	student(String name,String id)
	{
		this.name=name;
		this.id=id;
	}
	public void print()
	{
		System.out.println(name+" "+id);
	}
}
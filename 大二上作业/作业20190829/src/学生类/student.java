package ѧ����;
import java.io.*;
import java.util.*;

public class student {
	private int year,math,English,computer;
	private String name,id;
	public void initstu(String a,String b,int c)//aΪѧ��,bΪ����,cΪ��������
	{
		id=a;
		name=b;
		year=c;
	}
	public void stuscore(int a,int b,int c)//aΪ��ѧ,bΪӢ��,cΪ�����
	{
		math=a;
		English=b;
		computer=c;
	}
	int sum()
	{
		return math+English+computer;
	}
	int age()
	{
		return (2019-year);
	}
	public void print()
	{
		System.out.print(name+"��ѧ����"+id+",����"+age()+"�� �ܳɼ���"+sum());
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		student s1=new student() ;
		System.out.println("�������ѧ����ѧ�ţ������ͳ�����ݣ��ÿո������");
		s1.initstu(sc.next(), sc.next(), sc.nextInt());
		System.out.println("�������ѧ������ѧ�ɼ���Ӣ��ɼ��ͼ�����ɼ����ÿո������");
		s1.stuscore(sc.nextInt(), sc.nextInt(), sc.nextInt());
		s1.print();
	}

}

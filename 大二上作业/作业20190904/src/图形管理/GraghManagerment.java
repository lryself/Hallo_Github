package ͼ�ι���;
import java.util.*;
public class GraghManagerment {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��������Ҫ�����ĵ�һ�����γ��Ϳ��ÿո������");
		Rectangle a=new Rectangle(sc.nextInt(),sc.nextInt());
		System.out.println("��������Ҫ�����ĵڶ������γ��Ϳ��ÿո������");
		Rectangle b=new Rectangle(sc.nextInt(),sc.nextInt());
		System.out.println("��������Ҫ�����������α߳�");
		Square c=new Square(sc.nextInt());
		System.out.println("��һ�������ܳ�Ϊ��"+a.perimeter()+" ���Ϊ��"+a.area());
		System.out.println("�ڶ�һ�������ܳ�Ϊ��"+b.perimeter()+" ���Ϊ��"+b.area());
		System.out.println("�������ܳ�Ϊ��"+c.perimeter()+" ���Ϊ��"+c.area());
		System.out.println("���θ���Ϊ��"+Rectangle.num()+" �����θ���Ϊ��"+Square.num());
	}
}
class Rectangle
{
	int longth,wideth;
	static int number;
	Rectangle(){}
	Rectangle(int a,int b)
	{
		longth=a;
		wideth=b;
		number++;
	}
	int perimeter()
	{
		return longth*2+wideth*2;
	}
	int area()
	{
		return longth*wideth;
	}
	static int num()
	{
		return number;
	}
}
class Square extends Rectangle
{
	static int number;
	Square(){}
	Square(int a)
	{
		longth=a;
		number++;
	}
	int perimeter()
	{
		return longth*4;
	}
	int area()
	{
		return longth*longth;
	}
	static int num()
	{
		return number;
	}
}
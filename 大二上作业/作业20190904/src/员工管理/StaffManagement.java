package Ա������;
import java.util.*;

public class StaffManagement {
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("��������Ҫ������Ա������Ϣ��������Ա���ţ����ÿո����");
    	Emploee a=new Emploee(sc.next(),sc.next());
    	System.out.println("��������Ҫ�����Ĳ���������Ϣ��������Ա���ź����ܲ��ţ����ÿո����");
    	Manager b=new Manager(sc.next(),sc.next(),sc.next());
    	a.print();
    	b.print();
    }
}

class Emploee
{
    String id,name;
    Emploee(){}
    Emploee(String b,String a)
    {
        id=a;
        name=b;
    }
    void print()
    {
        System.out.println(name+"��Ա�����ǣ�"+id);
    }
}

class Manager extends Emploee
{
	String industry;
	Manager(){}
	Manager(String a,String b,String c)
	{
		super(a,b);
		industry=c;
	}
	void print()
	{
		System.out.println("����"+industry+"���ŵ�"+name+"��Ա�����ǣ�"+id);
	}
}
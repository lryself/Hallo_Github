package ��������;
import java.util.*;
public class Rent {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int all=0;
		int n=0,m=0;
		truck a;lim b;coach c;
		String yn;
		String[][] list=new String[100][3];
		while(true)
		{
			System.out.println("��������Ҫѡ��ĳ���:\n1.�γ�\n2.�ͳ�\n3.����");
			switch(input.nextInt())
			{
			case 1:
				System.out.println("��������Ҫ���޵ĳ��ͣ������ṩ������CRV������Escape������SUV");
				list[n][0]=input.next();
				list[n][1]="���ƺţ���"+(char)(65+(int)(Math.random()*26))+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10);
				b=new lim(list[n][0]);
				System.out.println("��������Ҫ���޵�����");
				m=input.nextInt();
				list[n][2]="ʱ��:"+m+"��";
				all+=b.sum(m);
				break;
			case 2:
				System.out.println("��������Ҫ���޵Ŀͳ���λ��:");
				list[n][0]="�ͳ�";
				m=input.nextInt();
				list[n][1]=m+"��";
				c=new coach(m);
				System.out.println("��������Ҫ���޵�����;");
				m=input.nextInt();
				list[n][2]=m+"��";
				all+=c.sum(m);
				break;
			case 3:
				System.out.println("��������Ҫ���޵Ŀ�����λ:");
				m=input.nextInt();
				list[n][0]="����";
				list[n][1]=m+"��";
				a=new truck(m);
				System.out.println("��������Ҫ���޵�����;");
				m=input.nextInt();
				list[n][2]=m+"��";
				all+=a.sum(m);
				break;
			}
			n++;
			System.out.println("�Ƿ�������룿��yes/no��");
			yn=input.next();
			if(yn.equals("no"))
			{
				if(all>10000)
					all=(int) (all*0.9);
				else if(all>1000)
					all=(int)(all*0.95);
				System.out.println("�����޵ĳ������£�");
				for(int i=0;i<n;i++)
				{
					System.out.println(list[i][0]+" "+list[i][1]+" "+list[i][2]);
				}
				System.out.println("�ܽ��Ϊ��"+all);
				break;
			}
		}
	}

}
class car
{
	int cost;
	car(){}
	int sum(int day)
	{
		return cost*day;
	}
}

class truck extends car
{
	int weight;
	truck(int a){
		weight=a;
		cost=weight*50;
	}
}
class lim extends car
{
	lim(String a)
	{
		switch(a)
		{
		case "����CRV":
			cost=600;
			break;
		case "����Escape":
			cost=500;
			break;
		case "����SUV":
			cost=400;
			break;
		}
	}
	
}
class coach extends car
{
	coach(int a)
	{
		if(a<=16)
			cost=800;
		else
			cost=1000;
	}
}
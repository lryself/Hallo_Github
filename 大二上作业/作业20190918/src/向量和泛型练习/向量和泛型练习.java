package �����ͷ�����ϰ;
import java.util.*;

public class �����ͷ�����ϰ {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Vector<student> a=new Vector<student>();
		for(int i=0;i<4;i++)
		{
			System.out.println("�������"+(i+1)+"��ѧ����������ѧ�ţ��ÿո����");
			a.add(new student(input.next(),input.next()));
		}
		for(int i=0;i<4;i++)
		{
			System.out.print("��"+(i+1)+"��ѧ����������ѧ��Ϊ��");
			a.get(i).print();
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
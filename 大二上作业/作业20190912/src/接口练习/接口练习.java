package �ӿ���ϰ;
import java.util.*;
public class �ӿ���ϰ {

	public static void main(String[] args) {
		String c;
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ�����ͼ��(Բ�Σ����Σ�������)��");
		c=input.next();
		if(c.equals("Բ��"))
		{
			System.out.println("������Բ�εİ뾶��Ĭ��PIΪ3����");
			Circle d=new Circle(input.nextInt());
			System.out.println("��Բ�����Ϊ"+d.getArea()+" �ܳ�Ϊ"+d.getPerimeter());
		}
		else if(c.equals("����"))
		{
			System.out.println("��������εĳ��Ϳ�");
			Rectangle d=new Rectangle(input.nextInt(),input.nextInt());
			System.out.println("�þ��ε����Ϊ"+d.getArea()+" �ܳ�Ϊ"+d.getPerimeter());
		}
		else if(c.equals("������"))
		{
			System.out.println("�����������εı߳���");
			Square d=new Square(input.nextInt());
			System.out.println("�������ε����Ϊ"+d.getArea()+" �ܳ�Ϊ"+d.getPerimeter());
		}
		else
		{
			System.out.println("���������ټ�");
		}
	}
}

interface shape{
	public abstract int getArea();
	public abstract int getPerimeter();
}

class Circle implements shape{
	final public int PI=3;
	int longth;
	public Circle() {}
	public Circle(int longth) {
		this.longth=longth;
	}
	public int getPerimeter()
	{
		return longth*2*PI;
	}
	public int getArea()
	{
		return longth*longth*PI; 
	}
}
class Rectangle implements shape{
	private int weighth,longth;
	public Rectangle() {}
	public Rectangle(int longth,int weighth)
	{
		this.longth=longth;
		this.weighth=weighth;
	}
	public int getArea()
	{
		return longth*weighth;
	}
	public int getPerimeter()
	{
		return longth*2+weighth*2;
	}
}
class Square extends Rectangle{
	public Square() {}
	public Square(int longth)
	{
		super(longth,longth);
	}
}
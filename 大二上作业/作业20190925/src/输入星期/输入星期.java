package ��������;
import java.util.*;
public class �������� {

	public static void main(String[] args) {
		System.out.println("������һ������(1~7)");
		Scanner input=new Scanner(System.in);
		try
		{
			int week=input.nextInt();
			String weekeen;
			switch(week)
			{
			case 1:weekeen="Monday";break;
			case 2:weekeen="Tuesday";break;
			case 3:weekeen="Wednesday";break;
			case 4:weekeen="Thursday";break;
			case 5:weekeen="Friday";break;
			case 6:weekeen="Saturday";break;
			case 7:weekeen="Sunday";break;
			default:throw new ArgsException();
			}
			System.out.println("������Ӧ��������"+weekeen);
		}
		catch(InputMismatchException ex)
		{
			System.out.println("����������������");
		}
		catch(ArgsException ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			System.out.println("�������");
		}
	}

}
class ArgsException extends Exception
{
	ArgsException()
	{
		super("�������ݷ�Χ����������1-7֮�������");
	}
}

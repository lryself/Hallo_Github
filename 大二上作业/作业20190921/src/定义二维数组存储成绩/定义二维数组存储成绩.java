package 定义二维数组存储成绩;
import java.util.*;

public class 定义二维数组存储成绩 {

	public static void main(String[] args) {
		int m=0,n=0;
		Boolean yn=true;
		System.out.println("请输入您要创建的学生数目和课程数目（用空格隔开）:");
		Scanner input=new Scanner(System.in);
		while(yn)
		{
			try {
				m=input.nextInt();
				n=input.nextInt();
				yn=false;
			}
			catch(InputMismatchException ex) {
				System.out.println("输入有误，请输入整数");
				input.nextLine();
			}
		}
		int score[][]=new int[m][n+1];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.println("请输入第"+(i+1)+"个学生的第"+(1+j)+"门课程的成绩");
				yn=true;
				while(yn)
				{
					try {
						score[i][j]=input.nextInt();
						if(score[i][j]<0||score[i][j]>100)
							throw new ArgsException();
						yn=false;
					}
					catch(InputMismatchException ex) {
						System.out.println("输入有误，请输入整数");
						input.nextLine();
					}
					catch(ArgsException ex)
					{
						System.out.println(ex.getMessage());
					}
				}
				score[i][n]+=score[i][j];
			}
		}
		for(int i=0;i<m;i++)
		{
			try {
				System.out.println("第"+(i+1)+"个同学的平均分为"+(score[i][n]/n));
			}
			catch(ArithmeticException ex)
			{
				System.out.println("第"+(1+i)+"个同学没有成绩。");
			}
		}
	}
}

class ArgsException extends Exception
{
	ArgsException()
	{
		super("数据超出输入范围，请输入0-100之间的数");
	}
}

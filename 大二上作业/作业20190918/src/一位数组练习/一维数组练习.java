package һλ������ϰ;
import java.util.*;

public class һά������ϰ {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ���������������");
		int n=input.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		Arrays.sort(a);
		for(int x:a)
		{
			System.out.print(x+" ");
		}
	}
	
}

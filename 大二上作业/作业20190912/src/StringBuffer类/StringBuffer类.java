package StringBuffer��;
import java.util.*;
public class StringBuffer�� {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�������ַ���S");
		String S=input.nextLine();
		System.out.println("�������ַ���S1");
		String S1=input.nextLine();
		System.out.println("�������ַ���S2");
		String S2=input.nextLine();
		int n=S1.length();
		while(S.contains(S1))
		{
			S=S.substring(0, S.indexOf(S1))+S2+S.substring(S.indexOf(S1)+n);
		}
		System.out.println("���º���ַ���Ϊ��"+S);
	}
}

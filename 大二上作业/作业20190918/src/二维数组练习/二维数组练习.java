package ��ά������ϰ;
import java.util.*;

public class ��ά������ϰ {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int score[][]=new int [4][5];
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.println("�������"+(i+1)+"��ѧ���ĵ�"+(j+1)+"�ſεĳɼ�");
				score[i][j]=input.nextInt();
				score[i][3]+=score[i][j];
			}
			score[i][4]=score[i][3]/3;
		}
		for(int i=0;i<4;i++)
		{
			System.out.println("��"+(i+1)+"��ѧ�����ܷ�Ϊ"+score[i][3]+"ƽ����Ϊ"+score[i][4]);
		}
	}

}

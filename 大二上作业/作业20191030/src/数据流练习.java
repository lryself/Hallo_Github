import java.util.*;
import java.io.*;

public class ��������ϰ {
    public static void main(String arg[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        File file=new File("F:/���/java/������.txt");
        DataOutputStream bf=new DataOutputStream(new FileOutputStream(file));
        String str[]=new String[4];
        char yn='y';
        while(yn=='y')
        {
            System.out.println("��������Ҫ�����ѧ����Ϣ��������Ժϵ�����䣬�ɼ���");
            for(int i=0;i<4;i++)
                str[i]=sc.next();
            System.out.println("�������Ƿ�����������루y/n��");
            yn=sc.next().charAt(0);
            for(int i=0;i<4;i++)
            {
                bf.writeUTF(str[i]);
            }
            bf.writeUTF("\n");
        }
        bf.close();
        DataInputStream br=new DataInputStream(new FileInputStream(file));
        int len;
        String string;
        while((string=br.readUTF())!=null){
            System.out.println(string);
        }
        br.close();
    }
}
import java.io.*;
import java.util.*;

public class �����2 {
    public static void main(String arg[])
    {
        File OUT=new File("F:/���/java/�����.txt");
        Scanner sc=new Scanner(System.in);
        System.out.println("��������Ҫ������ַ���");
        String string=sc.next();
        if(OUT.exists())
        {
            try
            {
                FileOutputStream output=new FileOutputStream(OUT);
                output.write(string.getBytes());
                output.close();
                System.out.println("�ַ����ѱ��浽�ļ�F:/���/java/�����.txt�У�");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
            System.out.println("������ļ������ڣ�");
    }
}
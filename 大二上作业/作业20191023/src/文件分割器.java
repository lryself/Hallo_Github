import java.io.*;
import java.util.*;
import java.nio.channels.FileLockInterruptionException;

public class �ļ��ָ��� {
    public static void main(String arg[])
    {
        System.out.println("��ѡ����Ҫ���еĲ�����\n1.�ϲ�\n2.���");
        Scanner sc=new Scanner(System.in);
        int choose=sc.nextInt();
        if(choose==1)
        {
            File TXT1=new File("F:/���/java/��ҵ20191023/src/�ϲ�����ļ�.txt");
            File TXT2=new File("F:/���/java/������.txt");
            File TXT3=new File("F:/���/java/�����.txt");
            if((TXT1.exists()&&TXT2.exists()&&TXT3.exists())==false)
            {
                System.out.println("�ļ������ڣ�");
                return;
            }
            try
            {
                FileInputStream TXT1in=new FileInputStream(TXT3);
                FileInputStream TXT2in=new FileInputStream(TXT2);
                FileOutputStream TXT3out=new FileOutputStream(TXT1);
                byte byt[]=new byte[1024*1024];
                while(true)
                {
                    int len=TXT1in.read(byt);
                    if(len==0)
                        break;
                    TXT3out.write(byt,0,len);
                    if(len<1024*1024)
                        break;
                }
                while(true)
                {
                    int len=TXT2in.read(byt);
                    if(len==0)
                        break;
                    TXT3out.write(byt,0,len);
                    if(len<1024*1024)
                        break;
                }
                TXT1in.close();
                TXT2in.close();
                TXT3out.close();
                System.out.println("�ļ��ϲ����");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if(choose==2)
        {
            File TXT1=new File("F:/���/java/��ҵ20191023/src/�ϲ�����ļ�.txt");
            File TXT2=new File("F:/���/java/������.txt");
            File TXT3=new File("F:/���/java/�����.txt");
            if((TXT1.exists()&&TXT2.exists()&&TXT3.exists())==false)
            {
                System.out.println("�ļ������ڣ�");
                return;
            }
            try
            {
                FileOutputStream TXT1in=new FileOutputStream(TXT3);
                FileOutputStream TXT2in=new FileOutputStream(TXT2);
                FileInputStream TXT3out=new FileInputStream(TXT1);
                byte byt[]=new byte[1024*1024];
                while(true)
                {
                    int len=TXT3out.read(byt);
                    if(len==0)
                        break;
                    if(len==1)
                    {
                        TXT1in.write(byt,0,len);
                        TXT2in.write("".getBytes(),0,0);
                       break;
                    }
                    TXT1in.write(byt,0,len/2);
                    TXT2in.write(byt,len/2,len/2);
                    if(len<1024*1024)
                        break;
                }
                TXT1in.close();
                TXT2in.close();
                TXT3out.close();
                System.out.println("�ļ�����ָ����");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
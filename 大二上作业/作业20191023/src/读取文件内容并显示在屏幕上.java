import java.io.*;

public class ��ȡ�ļ����ݲ���ʾ����Ļ�� {
    public static void main(String arg[])
    {
        File IN=new File("F:/���/java/������.txt");
        if(IN.exists())
        {
            try
            {
                FileInputStream input=new FileInputStream(IN);
                byte by[]=new byte[1024*1024];
                while(true)
                {
                    int len=input.read(by);
                    System.out.print(new String(by,0,len));
                    if(len<1024*1024)
                        break;
                }
                input.close();
                System.out.println("\n�ļ��е�������ʾ��ɣ�");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
            System.out.println("�������ļ������ڣ�");
    }
}

import java.io.*;

public class �ļ����� {
    public static void main(String arg[])
    {
        File IN=new File("F:/���/java/������.txt");
        File OUT=new File("F:/���/java/�����.txt");
        if(IN.exists())
        {
            if(OUT.exists())
            {
                try
                {
                    FileInputStream input=new FileInputStream(IN);
                    FileOutputStream output=new FileOutputStream(OUT);
                    byte by[]=new byte[1024*1024];
                    while(true)
                    {
                        int len=input.read(by);
                        output.write(by,0,len);
                        if(len<1024*1024)
                            break;
                    }
                    input.close();
                    output.close();
                    System.out.println("������ɣ�");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
                System.out.println("������ļ������ڣ�");
        }
        else
            System.out.println("�������ļ������ڣ�");
    }
}

import java.util.*;
import java.io.*;

public class ��������ϰ {
    public static void main(String arg[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        File file=new File("F:/���/java/������.txt");
        BufferedWriter bf=new BufferedWriter(new FileWriter(file));
        String collage,name,age,score;
        char yn='y';
        while(yn=='y')
        {
            System.out.println("��������Ҫ�����ѧ����Ϣ��������Ժϵ�����䣬�ɼ���");
            collage=sc.next();
            name=sc.next();
            age=sc.next();
            score=sc.next();
            System.out.println("�������Ƿ�����������루y/n��");
            yn=sc.next().charAt(0);
            bf.write(collage+' ');
            bf.write(name+' ');
            bf.write(age+' ');
            bf.write(score+' ');
            bf.newLine();
        }
        bf.close();
        BufferedReader br=new BufferedReader(new FileReader(file));
        int len;
        while((name=br.readLine())!=null){
            System.out.println(name);
        }
        br.close();
    }
}
import java.util.*;
import java.io.*;

public class ��������ϰ {
    public static void main(String arg[]) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        File file=new File("F:/���/java/������.txt");
        ObjectOutputStream bf=new ObjectOutputStream(new FileOutputStream(file));
        student stu=new student();
        char yn='y';
        while(yn=='y')
        {
            System.out.println("��������Ҫ�����ѧ����Ϣ��������Ժϵ�����䣬�ɼ���");
            stu.name=sc.next();
            stu.collage=sc.next();
            stu.age=sc.nextInt();
            stu.score=sc.nextInt();
            System.out.println("�������Ƿ�����������루y/n��");
            yn=sc.next().charAt(0);
            bf.writeObject(stu);
        }
        bf.close();
        ObjectInputStream br=new ObjectInputStream(new FileInputStream(file));
        int len;
        try
        {
            while((stu=(student)br.readObject())!=null){
                System.out.println(stu.name+' '+stu.collage+' '+stu.age+' '+stu.score+"\n");
            }
        }catch (Exception e)
        {
        }
        finally {
            br.close();
        }
    }
}
class student implements Serializable
{
    int age,score;
    String name,collage;
    student(){}
}
import java.sql.*;
import java.util.Scanner;

public class ʹ��prepare {
    public static void main(String arg[])
    {
        try
        {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:Access:///F:/���/java/��ҵ20191108/student.accdb","","");
            ResultSet resultSet;
            PreparedStatement preparedStatement=connection.prepareStatement("insert into student[(����,�Ա�,רҵ,�ɼ�)] values(?,?,?,?)");
            Scanner scanner=new Scanner(System.in);
            System.out.println("��������Ҫ������ѧ����Ϣ���������Ա�רҵ���ɼ����ÿո����");
            String name=scanner.next();
            String sex=scanner.next();
            String pro=scanner.next();
            String score=scanner.next();
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,sex);
            preparedStatement.setString(3,pro);
            preparedStatement.setString(4,score);
            preparedStatement.executeUpdate();
            preparedStatement=connection.prepareStatement("SELECT * from student");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                System.out.print("������"+resultSet.getString("����"));
                System.out.print(" �Ա�"+resultSet.getString("�Ա�"));
                System.out.print(" רҵ��"+resultSet.getString("רҵ"));
                System.out.println(" �ɼ���"+resultSet.getString("�ɼ�"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

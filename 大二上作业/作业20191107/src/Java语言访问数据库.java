import java.sql.*;

public class Java���Է������ݿ� {
    public static void main(String arg[])
    {
        try
        {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:Access:///F:/���/java/��ҵ20191107/student.accdb","","");
            Statement sql=connection.createStatement();
            ResultSet resultSet;
            sql.executeUpdate("insert into student[(����,Ժϵ,�Ա�,��������,ƽ���ɼ�)] values (6,'������','�ؼ�Ժ','��','2000.1.16',90);");
            sql.executeUpdate("insert into student[(����,Ժϵ,�Ա�,��������,ƽ���ɼ�)] values (7,'�����','�ؼ�Ժ','��','2001.6.20',50);");
            resultSet=sql.executeQuery("select * from student where �Ա�='��';");
            while(resultSet.next())
                System.out.println("������" + resultSet.getString("����") + " Ժϵ" + resultSet.getString("Ժϵ") + " ��������" + resultSet.getString("��������") + " ƽ���ɼ�" + resultSet.getString("ƽ���ɼ�"));
            System.out.println();
            sql.executeUpdate("update student[(����,Ժϵ,�Ա�,��������,ƽ���ɼ�)] set ƽ���ɼ� = ƽ���ɼ�*0.7+30 where Ժϵ='�ؼ�Ժ';");
            sql.executeUpdate("delete from student where ƽ���ɼ�<60;");
            resultSet=sql.executeQuery("select  * from student");
            while(resultSet.next())
                System.out.println("������" + resultSet.getString("����") + " Ժϵ" + resultSet.getString("Ժϵ") + " ��������" + resultSet.getString("��������") + " ƽ���ɼ�" + resultSet.getString("ƽ���ɼ�"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

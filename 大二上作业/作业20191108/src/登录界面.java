import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class ��¼����
{
    public static void main(String arg[])
    {
        new ��¼();
    }
}

class ��¼
{
    JFrame jFrame=new JFrame("��¼����");
    JPanel jPanel=new JPanel(new GridLayout(4,1));
    JButton button1=new JButton("��¼");
    JLabel tip=new JLabel("�����������û�������һ�У������루�ڶ��У�");
    TextArea id=new TextArea();
    JPasswordField passwordField=new JPasswordField();
    int i=0;
    ��¼()
    {
        passwordField.setEchoChar('*');
        tip.setEnabled(false);
        jFrame.add(jPanel);
        jPanel.add(tip);
        jPanel.add(id);
        jPanel.add(passwordField);
        jPanel.add(button1);
        jFrame.setVisible(true);
        jFrame.setSize(640,480);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.addActionListener(new ButtonAction());
    }
    class ButtonAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String name,password;
            name=id.getText();
            password=new String(passwordField.getPassword());
            passwordField.setText("");
            if(pass())
            {
                jFrame.setTitle("��¼�ɹ�");
            }
            else
            {
                jFrame.setTitle("��¼ʧ��");
                tip.setText("�û������������\n���������������û�������һ�У������루�ڶ��У�");
            }
        }
    }
    boolean pass()
    {
        try
        {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            Connection connection= DriverManager.getConnection("jdbc:Access:///F:/���/java/��ҵ20191108/user.accdb","","");
            ResultSet resultSet;
            PreparedStatement preparedStatement=connection.prepareStatement("select * from ��1");
            String name=id.getText();
            resultSet=preparedStatement.executeQuery();
            String word=resultSet.getString("password");
            while(resultSet.next())
            {
                if(word.equals(new String(passwordField.getPassword()))&&name.equals(resultSet.getString("name")))
                    return true;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            return false;
        }
    }
}
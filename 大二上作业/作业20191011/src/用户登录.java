import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class �û���¼ {
    public static void main(String args[])
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
            if(name.equals("lry")&&password.equals("123"))
            {
                jFrame.setTitle("��¼�ɹ�");
            }
            else
            {
                jFrame.setTitle("��¼ʧ��");
                tip.setText("�û������������\n���������������û�������һ�У������루�ڶ��У�");
                if(3==++i)
                {
                    JOptionPane.showMessageDialog(null,"�����������,���Ժ�����");
                    System.exit(0);
                }
            }
        }
    }
}
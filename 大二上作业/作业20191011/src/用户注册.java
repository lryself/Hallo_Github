import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class �û�ע�� {
    public static void main(String arg[])
    {
        new app();
    }
}
class app
{
    JFrame jFrame=new JFrame("�û�ע��");
    JPanel jPanel=new JPanel(new BorderLayout());
    JPanel northpanel=new JPanel(new GridLayout(7,2));
    JPanel southpanel=new JPanel(new BorderLayout());
    JTextField id=new JTextField(),name=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JRadioButton man=new JRadioButton("��");
    JRadioButton woman=new JRadioButton("Ů");
    ButtonGroup gender=new ButtonGroup();
    JTextArea result=new JTextArea();
    JButton sign=new JButton("ע��");
    JButton reset=new JButton("����");
    JPanel resultButton=new JPanel(new GridLayout(1,2));
    String[] major={"�������ѧ�뼼��","��Ϣ��ȫ","�������","����������"};
    JList jList=new JList(major);
    JComboBox year;
    JComboBox month;
    JComboBox day;
    JLabel birth[]=new JLabel[3];
    JPanel birthday=new JPanel(new GridLayout(1,6));
    JCheckBox hobbies[]=new JCheckBox[3];
    JLabel jLabel[]=new JLabel[7];
    app()
    {
        inibirthday();
        messageButton();

        jFrame.add(jPanel);
        jFrame.setSize(960,640);
        jPanel.add(BorderLayout.SOUTH,southpanel);
        jPanel.add(BorderLayout.NORTH,northpanel);

        resultButton.add(sign);
        resultButton.add(reset);
        southpanel.add(BorderLayout.NORTH,resultButton);
        southpanel.add(BorderLayout.SOUTH,result);

        gender.add(man);
        gender.add(woman);

        passwordField.setEchoChar('*');

        iniaction();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void messageButton()
    {
        int i=0;
        northpanel.add(jLabel[i++]=new JLabel("ѧ�ţ�"));
        northpanel.add(id);
        northpanel.add(jLabel[i++]=new JLabel("������"));
        northpanel.add(name);
        northpanel.add(jLabel[i++]=new JLabel("���룺"));
        northpanel.add(passwordField);

        northpanel.add(jLabel[i++]=new JLabel("�Ա�"));
        JPanel genderButton=new JPanel(new GridLayout(1,3));
        northpanel.add(genderButton);
        genderButton.add(man);
        genderButton.add(woman);
        man.setSelected(true);

        northpanel.add(jLabel[i++]=new JLabel("רҵ��"));
        northpanel.add(jList);
        jList.setSelectedIndex(0);

        northpanel.add(jLabel[i++]=new JLabel("�������£�"));
        birthday.add(year);
        birthday.add(birth[0]=new JLabel("��"));
        birthday.add(month);
        birthday.add(birth[1]=new JLabel("��"));
        birthday.add(day);
        birthday.add(birth[2]=new JLabel("��"));
        northpanel.add(birthday);

        northpanel.add(jLabel[i++]=new JLabel("���ã�"));
        JPanel hobbiesButton=new JPanel(new GridLayout(1,3));
        hobbiesButton.add(hobbies[0]=new JCheckBox("����"));
        hobbiesButton.add(hobbies[1]=new JCheckBox("�˶�"));
        hobbiesButton.add(hobbies[2]=new JCheckBox("����"));
        northpanel.add(hobbiesButton);
    }
    void inibirthday()
    {
        String years[]=new String[100];
        for(int i=0,j=1949;i<100;i++)
        {
            years[i]=String.valueOf(j++);
        }
        String months[]=new String[100];
        for(int i=0,j=1;i<12;i++)
        {
            months[i]=String.valueOf(j++);
        }
        String days[]=new String[100];
        for(int i=0,j=1;i<31;i++)
        {
            days[i]=String.valueOf(j++);
        }

        year=new JComboBox(years);
        month=new JComboBox(months);
        day=new JComboBox(days);
    }
    void iniaction()
    {
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id.setText("");
                name.setText("");
                passwordField.setText("");
                man.setSelected(true);
                jList.setSelectedIndex(0);
                year.setSelectedIndex(0);
                month.setSelectedIndex(0);
                day.setSelectedIndex(0);
                for(int i=0;i<3;i++)
                {
                    hobbies[i].setSelected(false);
                }
                result.setText("");
            }
        });
        sign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text=" �Ա�";
                if(man.isSelected())
                    text=text+man.getText();
                if(woman.isSelected())
                    text=text+woman.getText();
                text=text+" רҵ��"+(String)(jList.getSelectedValue())+" �������£�"+year.getSelectedItem()+"��"+month.getSelectedItem()+"��"+day.getSelectedItem()+"��"+" ���ã�";
                for(int i=0;i<3;i++)
                {
                    if(hobbies[i].isSelected())
                        text+=hobbies[i].getText();
                }
                result.setText(result.getText()+"ѧ�ţ�"+id.getText()+" ������"+name.getText()+" ���룺"+String.valueOf(passwordField.getPassword())+text+"\n");
            }
        });
    }
}
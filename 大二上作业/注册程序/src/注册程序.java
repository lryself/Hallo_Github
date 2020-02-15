import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class ע����� {
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
    JTextArea result=new JTextArea("ѧ�ţ� ������ ���룺 �Ա��� רҵ���������ѧ�뼼�� �������£�1949��1��1�� ���ã�\n��ע���ѧ����\n");
    app()
    {
        inibirthday();
        messageButton();

        jFrame.add(jPanel);
        jFrame.setSize(960,840);
        jPanel.add(BorderLayout.SOUTH,southpanel);
        jPanel.add(BorderLayout.NORTH,northpanel);

        resultButton.add(sign);
        resultButton.add(reset);
        southpanel.add(BorderLayout.NORTH,resultButton);
        southpanel.add(BorderLayout.SOUTH,result);

        gender.add(man);
        gender.add(woman);
        result.setEnabled(false);

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
                result.setText("ѧ�ţ� ������ ���룺 �Ա��� רҵ���������ѧ�뼼�� �������£�1949��1��1�� ���ã�\n��ע���ѧ����\n");
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
        man.addActionListener(new menAction());
        woman.addActionListener(new menAction());
        for(int i=0;i<3;i++)
        {
            hobbies[i].addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getSource();
                    String text=result.getText();
                    if(checkBox.isSelected())
                    {
                        int a=text.indexOf(checkBox.getText());
                        if(a==-1)
                        {
                            result.setText(print(result.getText(),checkBox.getText()+" ","���ã�"));
                        }
                    }
                    else
                    {
                        int a=text.indexOf(checkBox.getText());
                        if(a==-1)
                            return;
                        int b=a+checkBox.getText().length()+1;
                        if(b==text.length())
                        {
                            result.setText(text.substring(0,a));
                            return;
                        }
                        result.setText(text.substring(0,a)+text.substring((b)));
                    }
                }
            });
        }
        year.addActionListener(new dateAction());
        month.addActionListener(new dateAction());
        day.addActionListener(new dateAction());
        jList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                JList a=(JList)e.getSource();
                String majorstr=" רҵ��";
                int begin=result.getText().indexOf(majorstr)+majorstr.length();
                int end=result.getText().indexOf(" ��������");
                result.setText(result.getText().substring(0,begin)+(String)a.getSelectedValue()+result.getText().substring(end)+" ");
            }
        });
        name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {}
            public void focusLost(FocusEvent e) {
                JTextField a=(JTextField) e.getSource();
                String majorstr="������";
                int begin=result.getText().indexOf(majorstr)+majorstr.length();
                int end=result.getText().indexOf(" ����");
                result.setText(result.getText().substring(0,begin)+(String)a.getText()+result.getText().substring(end)+" ");
            }
        });
        id.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {}
            public void focusLost(FocusEvent e) {
                JTextField a=(JTextField) e.getSource();
                String majorstr="ѧ�ţ�";
                int begin=result.getText().indexOf(majorstr)+majorstr.length();
                int end=result.getText().indexOf(" ����");
                result.setText(result.getText().substring(0,begin)+(String)a.getText()+result.getText().substring(end)+" ");
            }
        });
        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {}
            public void focusLost(FocusEvent e) {
                JPasswordField a=(JPasswordField) e.getSource();
                String majorstr="���룺";
                int begin=result.getText().indexOf(majorstr)+majorstr.length();
                int end=result.getText().indexOf(" �Ա�");
                result.setText(result.getText().substring(0,begin)+String.valueOf(passwordField.getPassword())+result.getText().substring(end)+" ");
            }
        });
    }
    class menAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            JRadioButton a=(JRadioButton) e.getSource();
            String majorstr=" �Ա�";
            int begin=result.getText().indexOf(majorstr)+majorstr.length();
            int end=result.getText().indexOf(" רҵ��");
            result.setText(result.getText().substring(0,begin)+a.getText()+result.getText().substring(end)+" ");
        }
    }
    class dateAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String majorstr="�������£�";
            int begin=result.getText().indexOf(majorstr)+majorstr.length();
            int end=result.getText().indexOf(" ���ã�");
            result.setText(result.getText().substring(0,begin)+year.getSelectedItem()+"��"+month.getSelectedItem()+"��"+day.getSelectedItem()+"��"+result.getText().substring(end)+" ");
        }
    }
    String print(String txt,String instr,String kind)
    {
        int begin;
        begin=txt.indexOf(kind)+kind.length()-1;
        String before,after;
        before=txt.substring(0,begin+1);
        if((begin+1)<=txt.length())
            after=txt.substring(begin+1);
        else
            after="";
        return before+instr+after;
    }
}
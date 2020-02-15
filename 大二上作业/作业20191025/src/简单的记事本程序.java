import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class �򵥵ļ��±����� {
    public static void main(String arg[])
    {
        new show();
    }
}

class show
{
    JFrame jFrame=new JFrame("�򵥵ļ��±�����");
    JTextArea jTextArea=new JTextArea();
    JScrollPane jScrollPane=new JScrollPane(jTextArea);
    JMenuBar jMenuBar=new JMenuBar();
    JMenu jMenu=new JMenu("�ļ�");
    JMenuItem jMenuItem[]=new JMenuItem[4];
    JFileChooser jFileChooser=new JFileChooser();
    File file=null;
    FileReader fileReader;
    FileWriter fileWriter;
    show()
    {
        jFrame.setSize(640,480);
        jFrame.add(jScrollPane);
        jFrame.setJMenuBar(jMenuBar);
        initjMenuBar();
        initAction();

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    void initjMenuBar()
    {
        jMenuItem[0]=new JMenuItem("��");
        jMenuItem[1]=new JMenuItem("����");
        jMenuItem[2]=new JMenuItem("�˳�");
        jMenuItem[3]=new JMenuItem("�ر�");
        for(int i=0;i<4;i++)
        {
            jMenu.add(jMenuItem[i]);
        }
        jMenuBar.add(jMenu);
    }
    void initjFileChooser()
    {
        jFileChooser.setFileFilter(new FileNameExtensionFilter("txt","TXT"));
    }
    void initAction()
    {
        jMenuItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=jFileChooser.showOpenDialog(null);
                if(i==JFileChooser.APPROVE_OPTION)
                {
                    file=jFileChooser.getSelectedFile();
                    jFrame.setTitle(file.getName());
                    try
                    {
                        fileReader=new FileReader(file);
                        char ch[]=new char[1024*1024];
                        int len;
                        do
                        {
                            len=fileReader.read(ch);
                            jTextArea.setText(jTextArea.getText()+new String(ch,0,len));
                        }while(len>=1024*1024);
                        fileReader.close();
                    }
                    catch (Exception q)
                    {
                        q.printStackTrace();
                    }
                }
            }
        });
        jMenuItem[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        jMenuItem[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenuItem[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="����Ҫ���޸ı��浽 "+jFrame.getTitle()+" ��";
                String option[]={"����","������","ȡ��"};
                int i=JOptionPane.showOptionDialog(null,message,"���±�",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
                if(i==0)
                {
                    save();
                }
                if(i==1)
                {
                    System.exit(0);
                }
            }
        });
    }
    void save()
    {
        if(file==null)
        {
            int i=jFileChooser.showSaveDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                file=jFileChooser.getSelectedFile();
            }
        }
        try
        {
            fileWriter=new FileWriter(file);
            String string=jTextArea.getText();
            fileWriter.write(string);
            fileWriter.close();
        }
        catch (Exception q)
        {
            q.printStackTrace();
        }
    }
}
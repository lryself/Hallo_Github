import javax.swing.*;
import java.awt.*;

public class �����ļ��˵��ͱ༭�˵� {
    public static void main(String arg[])
    {
        new app1();
    }
}

class app1
{
    JFrame jFrame=new JFrame("�����ļ��˵��ͱ༭�˵�");
    JMenuBar jMenuBar=new JMenuBar();
    JMenu file=new JMenu("�ļ�");
    JMenu report=new JMenu("�༭");
    app1()
    {
        jFrame.setSize(640,480);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setJMenuBar(jMenuBar);

        jMenuBar.add(file);
        jMenuBar.add(report);

        JMenuItem jMenuItem[]=new JMenuItem[4];
        jMenuItem[0]=new JMenuItem("���ļ�");
        jMenuItem[1]=new JMenuItem("�����ļ�");
        jMenuItem[2]=new JMenuItem("����");
        jMenuItem[3]=new JMenuItem("����");
        file.add(jMenuItem[0]);
        file.add(jMenuItem[1]);
        report.add(jMenuItem[2]);
        report.add(jMenuItem[3]);

        jFrame.setVisible(true);
    }
}
package �ڲ�����������;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class �ڲ����������� {
    public static void main(String arg[])
    {
        OC oc=new OC();
    }
}

class OC{
    JButton ok,cancel;
    JFrame jFrame;
    JPanel jPanel;
    OC()
    {
        jFrame=new JFrame("�ȴ�����");
        jPanel=new JPanel(new GridLayout(2,1));
        ok=new JButton("ȷ��");
        ok.addActionListener(new kbAction(

        ));
        cancel=new JButton("ȡ��");
        cancel.addActionListener(new kbAction());
        jPanel.add(ok);
        jPanel.add(cancel);
        jFrame.add(jPanel);
        jFrame.setSize(640,480);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    class kbAction implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==ok)
            {
                if(ok.getText().equals("ȷ��"))
                    ok.setText("OK");
                else
                    ok.setText("ȷ��");
                jFrame.setTitle("��������ȷ����ť");
            }
            if(e.getSource()==cancel)
            {
                if(cancel.getText().equals("ȡ��"))
                    cancel.setText("Cancel");
                else
                    cancel.setText("ȡ��");
                jFrame.setTitle("��������ȡ����ť");
            }
        }
    }
}
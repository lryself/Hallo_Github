package ��������������;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class �������������� {
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
        ok.addActionListener(new kbAction(this));
        cancel=new JButton("ȡ��");
        cancel.addActionListener(new kbAction(this));
        jPanel.add(ok);
        jPanel.add(cancel);
        jFrame.add(jPanel);
        jFrame.setSize(640,480);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

class kbAction implements ActionListener {
    OC oc;
    kbAction(OC oc)
    {
        this.oc=oc;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==oc.ok)
        {
            if(oc.ok.getText().equals("ȷ��"))
                oc.ok.setText("OK");
            else
                oc.ok.setText("ȷ��");
            oc.jFrame.setTitle("��������ȷ����ť");
        }
        if(e.getSource()==oc.cancel)
        {
            if(oc.cancel.getText().equals("ȡ��"))
                oc.cancel.setText("Cancel");
            else
                oc.cancel.setText("ȡ��");
            oc.jFrame.setTitle("��������ȡ����ť");
        }
    }
}
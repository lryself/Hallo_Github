import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ���������Ի��� {
    public static void main(String arg[])
    {
        new show();
    }
}

class show
{
    JFrame jFrame=new JFrame("�����Ի�����");
    JButton jButton[]=new JButton[3];

    show()
    {
        jFrame.setSize(640,480);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(3,1));
        jButton[0]=new JButton("JDialog����");
        jButton[1]=new JButton("��Ϣ�Ի���");
        jButton[2]=new JButton("ȷ�϶Ի���");
        for(int i=0;i<3;i++)
        {
            jFrame.add(jButton[i]);
        }

        jButton[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showJDialog(jFrame);
            }
        });
        jButton[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame,"���ȷ����ť�ر�","��Ϣ�Ի���",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jButton[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(jFrame,"��Ҫ�˳�","ȷ�϶Ի���",JOptionPane.YES_NO_CANCEL_OPTION);
            }
        });
        jFrame.setVisible(true);
    }

    void showJDialog(JFrame jFrame) {
        JDialog dialog = new JDialog(jFrame, "JDialog����", true);
        dialog.setSize(250, 150);
        dialog.setResizable(false);
        dialog.setLayout(new GridLayout(2,1));
        dialog.setLocationRelativeTo(jFrame);
        JLabel jLabel = new JLabel("���ȷ����ť�˳�");
        JButton jButton = new JButton("ȷ��");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // �رնԻ���
                dialog.dispose();
            }
        });
        dialog.add(jLabel);
        dialog.add(jButton);
        dialog.setVisible(true);
    }
}
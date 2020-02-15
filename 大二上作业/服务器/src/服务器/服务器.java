package ������;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ������ {

	public static void main(String[] args) {
		View2 view2=new View2("��������");
		view2.SetNetwork();
	}

}
class View2
{
	int duankou=9999;
	
	JFrame jFrame=new JFrame();
	JPanel jPanel=new JPanel(new BorderLayout());
	JTextField jTextField=new JTextField();
	JTextArea jTextArea=new JTextArea();
	JPanel jPanel2=new JPanel(new BorderLayout());
	JButton jButton=new JButton("����");
	JLabel jLabel=new JLabel();
	JLabel jLabel2=new JLabel();
	JPanel jPanel3=new JPanel(new GridLayout(2,1));
	
	
	View2(String name) {
		jFrame.setSize(960,360);
		jFrame.setTitle(name);
		jFrame.add(jPanel);
		jPanel.add(jPanel3,BorderLayout.NORTH);
		jPanel3.add(jLabel);
		jPanel3.add(jLabel2);
		jPanel.add(jTextArea,BorderLayout.CENTER);
		jPanel.add(jPanel2,BorderLayout.SOUTH);
		jPanel2.add(jTextField,BorderLayout.CENTER);
		jPanel2.add(jButton,BorderLayout.EAST);
		
		jTextArea.setEnabled(false);
		
		SetAction();
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
		SetNetwork();
	}
	void SetAction()
	{
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					writer.println(jTextField.getText());
					jTextArea.append("������"+jTextField.getText()+"\n");
					jTextField.setText("");
				}
				catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		jTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					writer.println(jTextField.getText());
					jTextArea.append("������"+jTextField.getText()+"\n");
					jTextField.setText("");
				}
				catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
	}
	
	InetAddress ipAddress;
	BufferedReader reader;
	PrintWriter writer;
	ServerSocket serverSocket;
	Socket socket;
	void SetNetwork() {
		while(true)
		{
			try {
				ipAddress=InetAddress.getLocalHost();
				String locolip=ipAddress.getHostAddress();
				jLabel.setText("����ip��"+locolip+" �˿�Ϊ��"+duankou);

				serverSocket=new ServerSocket(duankou);
				jLabel2.setText("�ȴ��ͻ��˵�����");
				socket=serverSocket.accept();
				jLabel2.setText("������");
				ipAddress=socket.getInetAddress();
				jLabel2.setText("�Ѿ����ӵ��ͻ��ˣ�ipΪ��"+ipAddress.getHostAddress());
				writer=new PrintWriter(socket.getOutputStream(),true);
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true)
				{
					if(socket!=null)
					{
						jTextArea.append("�ͻ��ˣ�"+reader.readLine()+"\n");
					}
					else {
						serverSocket.close();
						break;
					}
				}
			} catch (Exception e) {
				try {
					serverSocket.close();
				} catch (Exception e2) {
					
				}
			}
		}
	}
}
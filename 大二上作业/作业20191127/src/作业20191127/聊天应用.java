package ��ҵ20191127;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import java.math.*;

public class ����Ӧ�� {

	public static void main(String[] args) {
		View view=new View("����Ӧ��");
	}
}

class View
{
	final int duankou=9999;
	
	JFrame jFrame=new JFrame();
	JPanel jPanel=new JPanel(new BorderLayout());
	JTextField jTextField=new JTextField();
	JTextArea jTextArea=new JTextArea();
	JPanel jPanel2=new JPanel(new BorderLayout());
	JButton jButton=new JButton("����");
	JLabel jLabel=new JLabel();
	JLabel jLabel2=new JLabel();
	JPanel jPanel3=new JPanel(new GridLayout(3,1));
	JPanel jPanel4=new JPanel(new GridLayout(1,7));
	JLabel jLabel3[]=new JLabel[2];
	JRadioButton jRadioButton[]=new JRadioButton[2];
	ButtonGroup buttonGroup=new ButtonGroup();
	JTextField jTextField2=new JTextField("127.0.0.1");
	JTextField jTextField3=new JTextField(String.valueOf(duankou));
	JButton jButton2=new JButton("����");
	String flag;
	Gopro gopro=new Gopro(this);
	
	View(String name) {
		jFrame.setSize(960,360);
		jFrame.setTitle(name);
		jFrame.add(jPanel);
		jPanel.add(jPanel3,BorderLayout.NORTH);
		jPanel3.add(jLabel);
		jPanel3.add(jLabel2);
		jPanel3.add(jPanel4);
		jPanel.add(jTextArea,BorderLayout.CENTER);
		jPanel.add(jPanel2,BorderLayout.SOUTH);
		jPanel2.add(jTextField,BorderLayout.CENTER);
		jPanel2.add(jButton,BorderLayout.EAST);
		
		jTextArea.setEnabled(false);
		jLabel3[0]=new JLabel("���ͣ�");
		jLabel3[1]=new JLabel("ip�Ͷ˿�");
		jRadioButton[0]=new JRadioButton("�ͻ���");
		jRadioButton[1]=new JRadioButton("��������");
		jPanel4.add(jLabel3[0]);
		jPanel4.add(jRadioButton[0]);
		jPanel4.add(jRadioButton[1]);
		buttonGroup.add(jRadioButton[0]);
		buttonGroup.add(jRadioButton[1]);
		jPanel4.add(jLabel3[1]);
		jPanel4.add(jTextField2);
		jPanel4.add(jTextField3);
		jTextField2.setEnabled(false);
		jTextField3.setEnabled(false);
		jButton2.setEnabled(false);
		jPanel4.add(jButton2);
		
		SetAction();
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	void SetAction()
	{
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					writer.write(jTextField.getText());
					jTextArea.append("������"+jTextField.getText()+"\n");
					jTextField.setText("");
				}
				catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		jRadioButton[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField2.setEnabled(false);
				jTextField3.setEnabled(false);
				jButton2.setText("��ʼ");
				flag="clien";
				jRadioButton[0].setEnabled(false);
				jRadioButton[1].setEnabled(false);
				
			}
		});
		jRadioButton[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ipAddress=InetAddress.getLocalHost();
					String locolip=ipAddress.getHostAddress();
					jLabel.setText("����ip��"+locolip);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				jLabel2.setText("��������Ҫ���ӵ�ip�Ͷ˿�");
				jTextField2.setEnabled(true);
				jTextField3.setEnabled(true);
				jButton2.setEnabled(true);
				jRadioButton[0].setEnabled(false);
				jRadioButton[1].setEnabled(false);
				flag="tcp";
			}
		});
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField2.setEnabled(false);
				jTextField3.setEnabled(false);
				jButton2.setEnabled(false);
				gopro.start();
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
		try {
			ipAddress=InetAddress.getLocalHost();
			String locolip=ipAddress.getHostAddress();
			jLabel.setText(jLabel.getText()+"����ip��"+locolip+" �˿�Ϊ��"+duankou);
			
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void Connect()
	{
		try {
				jLabel2.setText("����������");
				socket=new Socket(jTextField2.getText(),Integer.valueOf(jTextField3.getText()));
				ipAddress=socket.getInetAddress();
				jLabel2.setText("�Ѿ����ӵ�������");
				writer=new PrintWriter(socket.getOutputStream(),true);
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true)
				{
					if(socket!=null)
					{
						jTextArea.append("��������"+reader.readLine()+"\n");
					}
				}
		} catch (Exception e) {}
	}
}

class Gopro extends Thread
{
	View view;
	Gopro(View v) {
		view=v;
	}
	
	public void run()
	{
		if(view.flag.equals("clien"))
		{
			view.SetNetwork();
		}
		if(view.flag.equals("tcl"));
		{
			view.Connect();
		}
	}
}

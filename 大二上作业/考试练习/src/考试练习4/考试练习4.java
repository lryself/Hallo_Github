package ������ϰ4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class ������ϰ4 {

	public static void main(String[] args) {
		new view();
	}
}
class view
{
	JFrame jframe=new JFrame();
	JPanel jPanelmain;
	JPanel jPanelnorth;
	JPanel jPanelSouth;
	JButton jButton[]=new JButton[5];
	JLabel jLabel[]=new JLabel[3];
	JTextField jTextFieldid=new JTextField();
	JTextField jTextFieldmoney=new JTextField();
	JComboBox<String> jComboBox=new JComboBox<String>();
	
	JScrollPane jScrollPane;
	JTable jTable;
	DefaultTableModel jTableModel;
	
	Connection connection;
	
	view() {
		initConnect();
		initTable();
		init();
		initAction();
		update();
	}
	void init()
	{
		jframe.setSize(960,640);
		jPanelmain=new JPanel(new BorderLayout());
		jPanelnorth=new JPanel(new GridLayout(1,6));
		jPanelSouth=new JPanel(new GridLayout(1,5));
		jPanelmain.add(jScrollPane,BorderLayout.CENTER);
		jPanelmain.add(jPanelSouth,BorderLayout.SOUTH);
		jPanelmain.add(jPanelnorth,BorderLayout.NORTH);
		jPanelnorth.add(jLabel[0]=new JLabel("�˺�"));
		jPanelnorth.add(jTextFieldid);
		jPanelnorth.add(jLabel[1]=new JLabel("����"));
		jPanelnorth.add(jComboBox);
		jPanelnorth.add(jLabel[2]=new JLabel("���"));
		jPanelnorth.add(jTextFieldmoney);
		jPanelSouth.add(jButton[0]=new JButton("���"));
		jPanelSouth.add(jButton[1]=new JButton("����"));
		jPanelSouth.add(jButton[2]=new JButton("��ʾȫ��"));
		jPanelSouth.add(jButton[3]=new JButton("ɾ��"));
		jPanelSouth.add(jButton[4]=new JButton("���浽�ļ�"));
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jframe.add(jPanelmain);
		
		jComboBox.addItem("����");
		jComboBox.addItem("ȡ��");
		
	}
	void initTable()
	{
		Vector<String>vectorcolum=new Vector<String>();
		Vector vectorrows=new Vector();
		vectorcolum.add("�˺�");
		vectorcolum.add("����");
		vectorcolum.add("���");
		vectorcolum.add("���");
		
		jTableModel=new DefaultTableModel(vectorrows,vectorcolum);
		jTable=new JTable(jTableModel);
		jScrollPane=new JScrollPane(jTable);
		jTable.setSelectionMode(0);
	}
	void initAction()
	{
		for(int i=0;i<5;i++)
		{
			jButton[i].addActionListener(new ButtonAction());
		}
		jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectint=jTable.getSelectedRow();
				jTextFieldid.setText((String)jTable.getValueAt(selectint, 0));
				jComboBox.setSelectedItem((String)jTable.getValueAt(selectint, 1));
				jTextFieldmoney.setText((String)jTable.getValueAt(selectint, 2));
				
			}
		});
	}
	class ButtonAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			try {				
				if(e.getSource()==jButton[0])
				{
					PreparedStatement preparedStatement=connection.prepareStatement("insert into num values(?,?,?)");
					preparedStatement.setString(1, jTextFieldid.getText());
					preparedStatement.setString(2, jComboBox.getItemAt(jComboBox.getSelectedIndex()));
					preparedStatement.setString(3, jTextFieldmoney.getText());
					preparedStatement.executeUpdate();
					update();
				}
				if(e.getSource()==jButton[1])
				{
					update((String)JOptionPane.showInputDialog(jframe, "��������Ҫ��ѯ���˺�", "��ѯ", JOptionPane.OK_CANCEL_OPTION));
				}
				if(e.getSource()==jButton[2])
				{
					update();
				}
				if(e.getSource()==jButton[3])
				{
					PreparedStatement preparedStatement=connection.prepareStatement("delete from num where �˺� =?  AND ����=?  AND ���=?");
					preparedStatement.setString(1, jTextFieldid.getText());
					preparedStatement.setString(2, jComboBox.getItemAt(jComboBox.getSelectedIndex()));
					preparedStatement.setString(3, jTextFieldmoney.getText());
					preparedStatement.executeUpdate();
					update();
				}
				if(e.getSource()==jButton[4])
				{
					JFileChooser jFileChooser=new JFileChooser();
					if(jFileChooser.showOpenDialog(jframe)!=JFileChooser.APPROVE_OPTION)
						return;
					File file=jFileChooser.getSelectedFile();
					FileWriter fileWriter=new FileWriter(file);

					String str=jTable.getColumnName(0)+" "+jTable.getColumnName(1)+" "+jTable.getColumnName(2)+" "+jTable.getColumnName(3)+"\n";
					fileWriter.write(str);
					for(int i=0;i<jTable.getRowCount();i++)
					{
						String string=jTable.getValueAt(i, 0)+" "+jTable.getValueAt(i, 1)+" "+jTable.getValueAt(i, 2)+" "+jTable.getValueAt(i, 3)+"\n";
						fileWriter.write(string);
					}
					JOptionPane.showMessageDialog(jframe, "����ɹ�","��ʾ",JOptionPane.CANCEL_OPTION);
					fileWriter.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
	void update()
	{
		while(jTable.getRowCount()>0)
		{
			jTableModel.removeRow(0);
		}
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from num");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Vector<String> vector=new Vector<String>();
				for(int i=1;i<=3;i++)
				{
					vector.add(resultSet.getString(i));
				}
				int sum=0;
				if(vector.get(1).equals("����"))
					sum+=Integer.valueOf(vector.get(2));
				if(vector.get(1).equals("ȡ��"))
					sum-=Integer.valueOf(vector.get(2));
				for(int i=0;i<jTable.getRowCount();i++)
				{
					if(jTable.getValueAt(i, 0).equals(vector.get(0)))
					{
						sum=Integer.valueOf((String)jTable.getValueAt(i, 2));
					}
				}
				vector.add(String.valueOf(sum));
				jTableModel.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	void update(String string)
	{
		while(jTable.getRowCount()>0)
		{
			jTableModel.removeRow(0);
		}
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from num where �˺�=?");
			preparedStatement.setString(1, string);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Vector<String> vector=new Vector<String>();
				for(int i=1;i<=3;i++)
				{
					vector.add(resultSet.getString(i));
				}
				int sum=0;
				if(vector.get(1).equals("����"))
					sum+=Integer.valueOf(vector.get(2));
				if(vector.get(1).equals("ȡ��"))
					sum-=Integer.valueOf(vector.get(2));
				for(int i=0;i<jTable.getRowCount();i++)
				{
					if(jTable.getValueAt(i, 0).equals(vector.get(0)))
					{
						sum=Integer.valueOf((String)jTable.getValueAt(i, 2));
					}
				}
				vector.add(String.valueOf(sum));
				jTableModel.addRow(vector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	void initConnect()
	{
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			connection=DriverManager.getConnection("jdbc:Access:///F:/���/java/������ϰ/src/������ϰ4/money.accdb");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
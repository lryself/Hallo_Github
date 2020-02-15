import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.*;
import java.sql.*;
import java.io.*;

public class ������ϰ3 {

	public static void main(String[] args) {
		new view();
	}
}

class view
{
	JFrame jFrame;
	JPanel jPanelmain;
	JPanel jPanelNorth;
	JPanel jPanelSouth;
	
	JRadioButton jRadioButton[]=new JRadioButton[3];
	JButtonGroup jButtonGroup=new JButtonGroup(jRadioButton);
	JLabel jLabel[]=new JLabel[5];
	JTextField jTextField[]=new JTextField[4];
	
	JTable jTable;
	DefaultTableModel jTableModel;
	JScrollPane jScrollPane;
	
	JOptionPane roadJOptionPane;
	Connection connection;
	view() {
		initConnection();
		initTable();

		init();
		initAction();
	}
	void init()
	{
		jFrame=new JFrame("27th�㲥̨ͨѶ¼");
		jPanelmain=new JPanel(new BorderLayout());
		jPanelNorth=new JPanel(new GridLayout(1,12));
		jPanelSouth=new JPanel(new GridLayout(1,5));
		jPanelmain.add(jPanelNorth,BorderLayout.NORTH);
		jPanelmain.add(jPanelSouth,BorderLayout.SOUTH);
		jPanelmain.add(jScrollPane,BorderLayout.CENTER);
		
		jFrame.setSize(960, 640);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
	void initConnection() {
		String urlString=(String)JOptionPane.showInputDialog(jFrame,"���������ӵ����ݿ��ַ","���ӽ���" ,JOptionPane.PLAIN_MESSAGE);
		
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			connection=DriverManager.getConnection("jdbc:Access///"+urlString,"","");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void initTable()
	{
		jTableModel=new DefaultTableModel();
		jTable=new JTable(jTableModel);
		jScrollPane=new JScrollPane(jTable);
		
		Vector<String>columVector=new Vector<String>();
		columVector.add("����");
		columVector.add("ѧ��");
		columVector.add("����");
		columVector.add("����");
		columVector.add("����");
		
	}
	void initAction()
	{
		
	}
}

class JButtonGroup extends ButtonGroup
{
	JRadioButton jRadioButtons[];
	int num;
	JButtonGroup(JRadioButton buttons[]) {
		super();
		jRadioButtons=buttons;
		for(int i=0;i<jRadioButtons.length;i++)
		{
			add(jRadioButtons[i]);
		}
		num=getButtonCount();
	}
	JRadioButton getSelected()
	{
		for(int i=0;i<num;i++)
		{
			if(jRadioButtons[i].isSelected())
			{
				return jRadioButtons[i];
			}
		}
		return null;
	}
}
import com.sun.security.auth.module.JndiLoginModule;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ͨѶ¼���� {
    public static void main(String arg[])
    {
        new view();
    }
}

class view
{
    JFrame jFrame=new JFrame("ͨѶ¼����");
    tableScrollPane jStable=new tableScrollPane();
    treeScrollPane jStree=new treeScrollPane(jStable.jTable);
    JPanel jPanelup=new JPanel();
    Container container=new Container();

    JLabel jnameLabel=new JLabel("����");
    JTextArea jtname=new JTextArea();
    JLabel jsexLabel=new JLabel("�Ա�");
    JRadioButton jmanRadioButton=new JRadioButton("��");
    JRadioButton jwomanRadioButton=new JRadioButton("Ů");
    ButtonGroup buttonsexGroup=new ButtonGroup();
    JLabel jtelLabel=new JLabel("�绰����");
    JTextArea jtelTextArea=new JTextArea();
    JLabel jLabelgroup=new JLabel("����");
    JTextArea jTextAreagroup=new JTextArea();

    view()
    {
        initjpanelup();
        setaction();
        initjframe();
    }
    private void initjframe()
    {
        jFrame.setSize(1280,540);
        jFrame.setLayout(new BorderLayout());
        jFrame.add(jPanelup,BorderLayout.NORTH);
        jFrame.add(jStable.jtablePanel,BorderLayout.CENTER);
        jFrame.add(jStree.jStree,BorderLayout.WEST);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void initjpanelup()
    {
        jPanelup.setLayout(new GridLayout(1,9));
        jPanelup.add(jnameLabel);
        jPanelup.add(jtname);
        jPanelup.add(jsexLabel);
        jPanelup.add(jmanRadioButton);
        jPanelup.add(jwomanRadioButton);
        jPanelup.add(jtelLabel);
        jPanelup.add(jtelTextArea);
        jPanelup.add(jLabelgroup);
        jPanelup.add(jTextAreagroup);

        buttonsexGroup.add(jmanRadioButton);
        buttonsexGroup.add(jwomanRadioButton);
        jmanRadioButton.setSelected(true);
    }
    private void setaction()
    {
        jStable.jButtonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    PreparedStatement preparedStatement=jStable.connection.prepareStatement("insert into ��1 values (?,?,?,?)");
                    preparedStatement.setString(1,jtname.getText());
                    if(jmanRadioButton.isSelected())
                        preparedStatement.setString(2,"��");
                    else
                        preparedStatement.setString(2,"Ů");
                    preparedStatement.setString(3,jtelTextArea.getText());
                    preparedStatement.setString(4,jTextAreagroup.getText());
                    preparedStatement.executeUpdate();
                    jStable.reloadtable();
                    jStree.reloadtree();
                }
                catch (Exception q)
                {
                    q.printStackTrace();
                }

            }
        });
        jStable.jButtondelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow=jStable.jTable.getSelectedRow();
                int n=JOptionPane.showConfirmDialog(jFrame,"ȷ��ɾ����","",JOptionPane.YES_NO_OPTION);
                if(n==1)
                {
                    return;
                }
                if(selectedRow!=-1)
                {
                    try
                    {
                        PreparedStatement preparedStatement = jStable.connection.prepareStatement("delete from ��1 where �绰����=?");
                        preparedStatement.setString(1,jStable.jTable.getValueAt(selectedRow, 2).toString());
                        preparedStatement.executeUpdate();
                        jStable.reloadtable();
                        jStree.reloadtree();
                    }
                catch (Exception q)
                {
                    q.printStackTrace();
                }
                }
            }
        });
        jStree.jTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                if(!jStree.jTree.isSelectionEmpty())
                {
                    TreePath treePath=jStree.jTree.getSelectionPath();
                    try
                    {
                        jStable.reloadtable(treePath.getLastPathComponent().toString());
                    }
                    catch (Exception q)
                    {
                        q.printStackTrace();
                    }
                }
            }
        });
        jStable.jTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow=jStable.jTable.getSelectedRow();
                jtname.setText(jStable.defaultTableModel.getValueAt(selectedRow,0).toString());
                String string=jStable.defaultTableModel.getValueAt(selectedRow,1).toString();
                if(string.equals("��"))
                    jmanRadioButton.setSelected(true);
                else
                    jwomanRadioButton.setSelected(true);
                jtelTextArea.setText(jStable.defaultTableModel.getValueAt(selectedRow,2).toString());
                jTextAreagroup.setText(jStable.defaultTableModel.getValueAt(selectedRow,3).toString());
            }
        });
    }
}

class tableScrollPane
{
    private JScrollPane jStable;
    DefaultTableModel defaultTableModel;
    JTable jTable;
    JPanel jtablePanel=new JPanel();
    JButton jButtonadd=new JButton("���");
    JButton jButtondelete=new JButton("ɾ��");
    Connection connection;

    tableScrollPane()
    {
        Vector<String> colum=new Vector<String>();
        Vector vrows=new Vector();
        Vector vrow=new Vector();

        colum.add("����");
        colum.add("�Ա�");
        colum.add("�绰����");
        colum.add("����");

        vrows.add(vrow);

        defaultTableModel=new DefaultTableModel(vrows,colum);
        jTable=new JTable(defaultTableModel);
        jStable=new JScrollPane(jTable);
        jtablePanel.setLayout(new BorderLayout());
        JPanel jPanel=new JPanel(new GridLayout(1,2));
        jPanel.add(jButtonadd);
        jPanel.add(jButtondelete);
        jtablePanel.add(jStable,BorderLayout.CENTER);
        jtablePanel.add(jPanel,BorderLayout.SOUTH);
        defaultTableModel.removeRow(0);

        try
        {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            connection= DriverManager.getConnection("jdbc:Access:///F:/���/java/��ҵ20191113/src/ͨѶ¼.accdb","","");
            reloadtable();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void reloadtable()throws Exception
    {
        PreparedStatement preparedStatement=connection.prepareStatement("select * from ��1");
        ResultSet resultSet=preparedStatement.executeQuery();
        int rownum=defaultTableModel.getRowCount();
        for(int i=0;i<rownum;i++)
            defaultTableModel.removeRow(0);
        String string;
        while(resultSet.next())
        {
            Vector vector=new Vector();
            vector.add(resultSet.getString("����"));
            vector.add(resultSet.getString("�Ա�"));
            vector.add(resultSet.getString("�绰����"));
            string=resultSet.getString("����");
            vector.add(string);
            defaultTableModel.addRow(vector);
        }
    }
    void reloadtable(String key)throws Exception
    {
        PreparedStatement preparedStatement;
        if(key.equals("ͨѶ¼"))
            preparedStatement=connection.prepareStatement("select * from ��1");
        else
        {
            preparedStatement=connection.prepareStatement("select * from ��1 where ����=?");
            preparedStatement.setString(1,key);
        }
        ResultSet resultSet=preparedStatement.executeQuery();
        int rownum=defaultTableModel.getRowCount();
        for(int i=0;i<rownum;i++)
            defaultTableModel.removeRow(0);
        while(resultSet.next())
        {
            Vector vector=new Vector();
            vector.add(resultSet.getString("����"));
            vector.add(resultSet.getString("�Ա�"));
            vector.add(resultSet.getString("�绰����"));
            vector.add(resultSet.getString("����"));
            defaultTableModel.addRow(vector);
        }
    }
}

class treeScrollPane
{
    JScrollPane jStree;
    DefaultMutableTreeNode root=new DefaultMutableTreeNode("ͨѶ¼");
    DefaultTreeModel defaultTreeModel=new DefaultTreeModel(root);
    JTree jTree=new JTree(defaultTreeModel);
    JTable jTable;
    treeScrollPane(JTable jTable)
    {
        this.jTable=jTable;
        jStree=new JScrollPane(jTree);
        jTree.setSelectionPath(new TreePath(root.getPath()));
        TreeSelectionModel treeSelectionModel=jTree.getSelectionModel();
        treeSelectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        reloadtree();
    }

    void reloadtree()
    {
        while(root.getChildCount()!=0)
            root.remove(0);
        for(int i=0;i<jTable.getRowCount();i++)
        {
            boolean yn=true;
            Enumeration enumeration=root.children();
            while(enumeration.hasMoreElements())
            {
                DefaultMutableTreeNode node=(DefaultMutableTreeNode)enumeration.nextElement();
                String treename=node.toString();
                if(treename.equals(jTable.getValueAt(i,3)))
                {
                    yn=false;
                    break;
                }
            }
            if(yn==true)
            {
                DefaultMutableTreeNode defaultMutableTreeNode=new DefaultMutableTreeNode(jTable.getValueAt(i,3),false);
                root.add(defaultMutableTreeNode);
            }
        }
        jTree.repaint();
    }
}
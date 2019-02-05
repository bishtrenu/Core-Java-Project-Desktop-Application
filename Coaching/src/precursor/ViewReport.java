package precursor;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Frame;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class ViewReport extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	String[]colNames={"Studentid","Name","PhoneNo.","Email_Id ","Submitted","CourseID"};
	String[]colName={"Studentid","Name","PhoneNo.","Email_Id ","Submitted","ProjectID"};
	Object[][]data;
	Object[][]project;
	JTable jt,jt1;
	JScrollPane jsp,jsp1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JComboBox combocategory,combocourse ;
	private Connection con;
	private PreparedStatement ps,ps1,ps2,ps3,psproject,pscourse;
	private ResultSet rs,rs1,rs2,rs3,rsproject,rscourse;
	private JButton btnproject ,btncourse;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewReport frame = new ViewReport();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewReport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewReport.class.getResource("/images/pppp.jpg")));
		setTitle("View Report");
		con=CrudOperation.createConnection();
		 CreateGUI();
		 
	}
public void CreateGUI()
{
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 863, 531);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	label = new JLabel("PRECURSOR");
	label.setForeground(Color.BLACK);
	label.setFont(new Font("Algerian", Font.BOLD, 45));
	label.setBackground(Color.BLACK);
	label.setBounds(295, 11, 272, 46);
	contentPane.add(label);
	
	label_1 = new JLabel("INFO SOLUTIONS");
	label_1.setForeground(Color.BLACK);
	label_1.setFont(new Font("Aldhabi", Font.BOLD, 50));
	label_1.setBounds(278, 51, 299, 41);
	contentPane.add(label_1);
	
	lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(ViewReport.class.getResource("/images/u.png")));
	lblNewLabel.setBounds(245, 11, 363, 102);
	contentPane.add(lblNewLabel);
	
	combocategory = new JComboBox();
	 combocategory.setModel(new DefaultComboBoxModel(new String[]{"Choose ProjectId"}));
	 combocategory.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	combocategory.setBounds(20, 162, 150, 35);
	
	
	 combocourse = new JComboBox();
	 combocourse.setModel(new DefaultComboBoxModel(new String[]{"Choose CourseId"}));
	 combocourse.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	 combocourse.setBounds(676, 164, 151, 31);

	fillcombo();
	contentPane.add(combocategory);
	contentPane.add(combocourse);
	
	JLabel lblNewLabel_1 = new JLabel("Report Course Wise");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel_1.setBounds(666, 119, 161, 37);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Report Project Wise");
	lblNewLabel_2.setForeground(Color.BLACK);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
	lblNewLabel_2.setBounds(21, 124, 186, 27);
	contentPane.add(lblNewLabel_2);
	
	btnproject = new JButton("View report Project wise");
	btnproject.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnproject.addActionListener(this);
	btnproject.setBounds(20, 436, 214, 34);
	contentPane.add(btnproject);
	
	btncourse = new JButton("View Report Course wise");
	btncourse.setFont(new Font("Tahoma", Font.BOLD, 14));
	btncourse.addActionListener(this); 
	btncourse.setBounds(601, 436, 224, 34);
	contentPane.add(btncourse);
	
	lblNewLabel_3 = new JLabel("");
	lblNewLabel_3.setIcon(new ImageIcon(ViewReport.class.getResource("/images/v.jpg")));
	lblNewLabel_3.setBounds(0, 0, 861, 492);
	contentPane.add(lblNewLabel_3);
	
}
private void fillcombo()
{
	
	try
	{String strsql="select * from project ";
		ps=con.prepareStatement(strsql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			String projectid=rs.getString("Projectid");
			combocategory.addItem(projectid);
		}
		String str="select * from course ";
		ps1=con.prepareStatement(str);
		rs1=ps1.executeQuery();
		while(rs1.next())
		{
			String course=rs1.getString("Cid");
			combocourse.addItem(course);
		}
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	finally
	{
		try
		{	rs1.close();
			ps1.close();
			rs.close();
			ps.close();
			
		}
		catch(SQLException sq)
		{
		System.out.println(sq);	
		}
	}
}



@Override
public void actionPerformed(ActionEvent ap) {
String Coursewise=(String)combocourse.getSelectedItem();
String Projectwise=(String)combocategory.getSelectedItem();
String Caption=ap.getActionCommand();
if(Coursewise.equals("Choose CourseId")&&Projectwise.equals("Choose ProjectId"))
{
	JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
}
else
{
if(Caption.equalsIgnoreCase("View Report Course wise"))
{
	try{
		
		String strcount="select count(*) from student where cid=? ";
		
		ps2=con.prepareStatement(strcount);
		ps2.setString(1, Coursewise);
		rs2=ps2.executeQuery();
			rs2.next();
			int cnt=rs2.getInt(1);
			
			data=new Object[cnt][6];
	String strdata="select * from student where cid=?";
	
	pscourse=con.prepareStatement(strdata);
	pscourse.setString(1, Coursewise);
	System.out.println(pscourse);
	rscourse=pscourse.executeQuery();
	int row=0;
		while(rscourse.next())
		{
			data[row][0]=rscourse.getString("Studentid");
			data[row][1]=rscourse.getString("Name");
			data[row][2]=rscourse.getString("Phno");
			data[row][3]=rscourse.getString("Emailid");
			data[row][4]=rscourse.getString("Submitted");
			data[row][5]=rscourse.getString("Cid");
			row++;
			
		}
		jt=new JTable(new DefaultTableModel(data, colNames));
		jsp=new JScrollPane(jt);
		jsp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		jsp.setBounds(180,236,550,186);
		contentPane.add(jsp);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}finally
		{
			try
			{	rscourse.close();
				pscourse.close();
				rs2.close();
				ps2.close();
				
			}
			catch(SQLException sq)
			{
			System.out.println(sq);	
			}
		}
	combocourse.removeAllItems();
	combocourse.addItem("Choose CourseId");
	fillcombo();
	
}
if(Caption.equalsIgnoreCase("View report Project wise"))
{
try{
		
		String strproject="select count(*) from student where Pid=? ";
		
		ps3=con.prepareStatement(strproject);
		ps3.setString(1, Projectwise);
		rs3=ps3.executeQuery();
			rs3.next();
			int cnt=rs3.getInt(1);
			
			project=new Object[cnt][6];
	String strdata="select * from student where Pid=?";
	
	psproject=con.prepareStatement(strdata);
	psproject.setString(1, Projectwise);
	rsproject=psproject.executeQuery();
	int row=0;
		while(rsproject.next())
		{
			project[row][0]=rsproject.getString("Studentid");
			project[row][1]=rsproject.getString("Name");
			project[row][2]=rsproject.getString("Phno");
			project[row][3]=rsproject .getString("Emailid");
			project[row][4]=rsproject.getString("Submitted");
			project[row][5]=rsproject.getString("Pid");
			row++;
			
		}
		jt1=new JTable(new DefaultTableModel(project, colName));
		jsp1=new JScrollPane(jt1);
		jsp1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		jsp1.setBounds(180,236,550,186);
		contentPane.add(jsp1);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	finally
		{
			try
			{
				rs.close();
				ps.close();
				
			}
			catch(SQLException sq)
			{
			System.out.println(sq);	
			}
		}
combocategory.removeAllItems();
combocategory.addItem("Choose ProjectId");
fillcombo();
}}
	}
}


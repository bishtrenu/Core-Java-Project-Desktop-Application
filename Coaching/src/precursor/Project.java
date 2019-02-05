package precursor;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class Project extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtpid;
	private JTextField txtpname;
	private Connection con;
	private PreparedStatement ps,ps1,ps2;
	private ResultSet rs1,rs2;
	private 	JComboBox combocid ;
	private JTextArea txtdetails;
	private JButton btnaddproject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project frame = new Project();
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
	public Project() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Project.class.getResource("/images/pppp.jpg")));
	 con=CrudOperation.createConnection();
		CreateGUI();
		
		
	}
public void CreateGUI()
{
	setTitle("Add Project");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 735, 492);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel label = new JLabel("PRECURSOR");
	label.setForeground(Color.BLACK);
	label.setFont(new Font("Algerian", Font.BOLD, 50));
	label.setBackground(Color.BLACK);
	label.setBounds(238, 0, 341, 46);
	contentPane.add(label);
	
	JLabel label_1 = new JLabel("INFO SOLUTIONS");
	label_1.setForeground(Color.BLACK);
	label_1.setFont(new Font("Aldhabi", Font.BOLD, 60));
	label_1.setBounds(194, 41, 347, 46);
	contentPane.add(label_1);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(Project.class.getResource("/images/o.jpg")));
	lblNewLabel.setBounds(194, 0, 355, 97);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Project ID");
	lblNewLabel_1.setOpaque(true);
	lblNewLabel_1.setBackground(new Color(240, 240, 240));
	lblNewLabel_1.setForeground(new Color(0, 0, 128));
	lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
	lblNewLabel_1.setBounds(43, 153, 105, 32);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Project Name");
	lblNewLabel_2.setOpaque(true);
	lblNewLabel_2.setForeground(new Color(0, 0, 128));
	lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
	lblNewLabel_2.setBounds(43, 190, 140, 32);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Category ID");
	lblNewLabel_3.setOpaque(true);
	lblNewLabel_3.setForeground(new Color(0, 0, 128));
	lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
	lblNewLabel_3.setBounds(43, 233, 124, 26);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("Details");
	lblNewLabel_4.setOpaque(true);
	lblNewLabel_4.setForeground(new Color(0, 0, 128));
	lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 18));
	lblNewLabel_4.setBounds(43, 336, 117, 32);
	contentPane.add(lblNewLabel_4);
	
	txtpid = new JTextField();
	txtpid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	txtpid.setBounds(262, 159, 230, 26);
	contentPane.add(txtpid);
	txtpid.setColumns(10);
	
	txtpname = new JTextField();
	txtpname.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	txtpname.setBounds(262, 196, 230, 26);
	contentPane.add(txtpname);
	
	txtpname.setColumns(10);
	
	combocid = new JComboBox();
	
	combocid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	combocid.setBounds(262, 238, 230, 23);
	combocid.addItem("Select CategoryID");
	fillCombo();
	
	contentPane.add(combocid);
	
	 txtdetails = new JTextArea();
	 txtdetails.setLineWrap(true);
	txtdetails.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
	txtdetails.setBounds(220, 302, 300, 97);
	contentPane.add(txtdetails);
	
	btnaddproject = new JButton("Add Project");
	btnaddproject.addActionListener(this);
	btnaddproject.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnaddproject.setBounds(292, 410, 163, 32);
	contentPane.add(btnaddproject);
	
	JLabel lblNewLabel_5 = new JLabel("");
	lblNewLabel_5.setIcon(new ImageIcon(Project.class.getResource("/images/p.jpg")));
	lblNewLabel_5.setBounds(0, 0, 719, 453);
	contentPane.add(lblNewLabel_5);	
}
public void fillCombo()
{
	try{
		
		String strinsert="Select * from projectcategory";
		ps1=con.prepareStatement(strinsert);
		rs1=ps1.executeQuery();
		while(rs1.next())
		{
			String id=rs1.getString("Categoryid");
			combocid.addItem(id);
		}
	}
	catch(SQLException sq)
	{
		System.out.println(sq);
	}	
	finally
	{
		try
		{
			rs1.close();
			ps1.close();
			
		}
		catch(SQLException sq)
		{
		System.out.println(sq);	
		}
	}
}

@Override
public void actionPerformed(ActionEvent arg0) {
	String pid=txtpid.getText();
	String pname=txtpname.getText();
	String categoryid=(String)combocid.getSelectedItem();
	
	String details=txtdetails.getText();
	if(pid.isEmpty()||pname.isEmpty()||details.isEmpty()||categoryid.equals("Select CategoryID"))
	{
		JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
	}
	else{
		String str="Select * from project where projectid=?";
		try
			{
				ps2=con.prepareStatement(str);
				ps2.setString(1, pid);
				rs2=ps2.executeQuery();
				if(rs2.next())
				{
					

					JOptionPane.showMessageDialog(this,"Project is already created","", JOptionPane.QUESTION_MESSAGE);
					txtpid.setText("");
					txtpname.setText("");
					txtdetails.setText("");
					combocid.removeAllItems();
					combocid.addItem("Select CategoryID");
					fillCombo();
				}
				else{
		
	try{
		
		String strinsert="Insert into project values(?,?,?,?)";
		ps=con.prepareStatement(strinsert);
		ps.setString(1, pid);
		ps.setString(2, pname);
		ps.setString(3, categoryid);
		ps.setString(4, details);
		int rw=ps.executeUpdate();
		if(rw>0)
		{
			JOptionPane.showMessageDialog(this,"Data Added", "Insert", JOptionPane.INFORMATION_MESSAGE);
			txtpid.setText("");
			txtpname.setText("");
			
			txtdetails.setText("");
		}
	}
	catch(SQLException sq)
	{
		System.out.println(sq);
	}
	finally
	{
		try
		{
			
			ps.close();
			
		}
		catch(SQLException sq)
		{
		System.out.println(sq);	
		}
	}
	combocid.removeAllItems();
	combocid.addItem("Select CategoryID");
	fillCombo();
	}	
}
		catch(SQLException sq)
		{
			System.out.println(sq);
		}
		}
}
}


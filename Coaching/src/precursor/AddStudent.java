package precursor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class AddStudent extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtstdid;
	private JTextField txtName;
	private JTextField txtphno;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JTextArea txtAddress;
	private Connection con;
	private PreparedStatement ps,ps1,ps2;
	private ResultSet rs,rs1,rs2;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudent()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudent.class.getResource("/images/pppp.jpg")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudent.class.getResource("/images/crop.jpg")));
		setTitle("AddStudent");
		setResizable(false);
		con=CrudOperation.createConnection();
		createGUI();
	}
	public void createGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 10, 722, 684);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblstdid = new JLabel("StudentID");
		lblstdid.setOpaque(true);
		lblstdid.setForeground(Color.WHITE);
		lblstdid.setBackground(new Color(0, 0, 139));
		lblstdid.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblstdid.setBounds(120, 158, 171, 26);
		contentPane.add(lblstdid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setOpaque(true);
		lblName.setBackground(new Color(0, 0, 139));
		lblName.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblName.setBounds(120, 232, 171, 26);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBackground(new Color(0, 0, 139));
		lblAddress.setOpaque(true);
		lblAddress.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblAddress.setBounds(120, 306, 171, 26);
		contentPane.add(lblAddress);
		
		JLabel lblphno = new JLabel("Phone Number");
		lblphno.setForeground(Color.WHITE);
		lblphno.setOpaque(true);
		lblphno.setBackground(new Color(0, 0, 139));
		lblphno.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblphno.setBounds(118, 378, 173, 26);
		contentPane.add(lblphno);
		
		txtstdid = new JTextField();
		txtstdid.setBorder(new LineBorder(Color.BLACK));
		txtstdid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtstdid.setBounds(359, 158, 232, 32);
		contentPane.add(txtstdid);
		txtstdid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBorder(new LineBorder(Color.BLACK));
		txtName.setFont(new Font("Arial", Font.PLAIN, 13));
		txtName.setBounds(359, 226, 232, 32);
		contentPane.add(txtName);
		txtName.setColumns(20);
		
		txtphno = new JTextField();
		txtphno.setBorder(new LineBorder(Color.BLACK));
		txtphno.setFont(new Font("Arial", Font.PLAIN, 13));
		txtphno.setBounds(364, 378, 227, 32);
		contentPane.add(txtphno);
		txtphno.setColumns(10);
		
		JLabel lblCid = new JLabel("Cid");
		lblCid.setBackground(new Color(0, 0, 139));
		lblCid.setOpaque(true);
		lblCid.setForeground(Color.WHITE);
		lblCid.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblCid.setBounds(120, 488, 171, 24);
		contentPane.add(lblCid);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(Color.BLACK));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select CourseID"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setBounds(364, 488, 227, 32);
		comboBox.addItem("Select CourseID");
		fillCombo();
		contentPane.add(comboBox);
		
		btnAdd = new JButton("Add Student");
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(255, 0, 0));
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnAdd.setBounds(283, 578, 193, 46);
		contentPane.add(btnAdd);
		
		JLabel lblemail = new JLabel("EMail ID");
		lblemail.setForeground(Color.WHITE);
		lblemail.setBackground(new Color(0, 0, 139));
		lblemail.setOpaque(true);
		lblemail.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblemail.setBounds(120, 434, 171, 26);
		contentPane.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setBorder(new LineBorder(Color.BLACK));
		txtemail.setBounds(364, 428, 227, 32);
		contentPane.add(txtemail);
		txtemail.setColumns(20);
		
		JLabel label = new JLabel("Precursor");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(244, 11, 279, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(167, 56, 344, 49);
		contentPane.add(label_1);
		txtAddress = new JTextArea();
		txtAddress.setLineWrap(true);
		txtAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAddress.setBounds(359, 277, 232, 79);
		contentPane.add(txtAddress);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(AddStudent.class.getResource("/images/ii.jpg")));
		lblNewLabel.setBounds(0, 0, 716, 655);
		contentPane.add(lblNewLabel);
	}
	public void fillCombo()
	{
		String strsql="select * from course";
		try
		{
			ps1=con.prepareStatement(strsql);
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				String acid=rs1.getString("cid");
				comboBox.addItem(acid);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		finally
		{
			try
			{
				ps1.close();
				rs1.close();
			}
			catch(SQLException sq)
			{
			System.out.println(sq);	
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{ long phone;
		String lbl1=txtstdid.getText();
		String lbl2=txtName.getText();
		String lbl3=txtAddress.getText();
		String lbl4=txtphno.getText();
		if(lbl4.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{
		 phone=Long.parseLong(lbl4);
		
		String lbl5=txtemail.getText();
		String data=(String)comboBox.getSelectedItem();
		if(lbl1.isEmpty()||lbl2.isEmpty()||data.isEmpty()||lbl4.isEmpty()||lbl5.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{   String str="Select * from student where studentid=?";
			try
				{
					ps2=con.prepareStatement(str);
					ps2.setString(1, lbl1);
					rs2=ps2.executeQuery();
					if(rs2.next())
					{
						

						JOptionPane.showMessageDialog(this,"Student Account Exists","", JOptionPane.QUESTION_MESSAGE);
						txtAddress.setText("");
						txtemail.setText("");
						txtName.setText("");
						txtphno.setText("");
						txtstdid.setText("");
						comboBox.removeAllItems();
						comboBox.addItem("Select CourseID");
						fillCombo();
					}
					else{
						try
						{
							String strinsert="insert into student(Studentid,Name,Address,Phno,Emailid,Cid) values(?,?,?,?,?,?)";
							ps=con.prepareStatement(strinsert);
							ps.setString(1, lbl1);
							ps.setString(2, lbl2);
							ps.setString(3, lbl3);
							ps.setLong(4, phone);
							ps.setString(5, lbl5);
							ps.setString(6, data);
						/*	ps.setString(7, "null");
							ps.setString(8, "not submitted");*/
							int rw=ps.executeUpdate();
							if(rw>0)
							{
								
								JOptionPane.showMessageDialog(this,"Student Added" , "Student Info", JOptionPane.INFORMATION_MESSAGE);
								txtAddress.setText("");
								txtemail.setText("");
								txtName.setText("");
								txtphno.setText("");
								txtstdid.setText("");
							
							}
							
						}
						catch(SQLException se)
						{
							System.out.println(se);
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
						comboBox.removeAllItems();
						comboBox.addItem("Select CourseID");
						fillCombo();
					}
					
				}
		catch(SQLException sq)
		{
			System.out.println(sq);
		}
		
					
		}
		// TODO Auto-generated method stub
		}
	}
}

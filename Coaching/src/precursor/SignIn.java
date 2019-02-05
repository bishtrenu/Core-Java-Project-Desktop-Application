package precursor;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class SignIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnfeedback, btnhomepage,btnsignin;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JButton btnsign ;
	private JTextField txtuserid;
	private JPasswordField txtuserpass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignIn.class.getResource("/images/pppp.jpg")));
		setTitle("LOGIN");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
	CreateGUI();	
		
	}
public void CreateGUI()
{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1439, 744);
	contentPane = new JPanel();
	contentPane.setBackground(Color.RED);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	 btnhomepage = new JButton("HOME PAGE");
	 btnhomepage.addActionListener(this);
	btnhomepage.setBounds(0, 0, 420, 36);
	contentPane.add(btnhomepage);
	
	btnsignin = new JButton("SIGN IN");
	 btnsignin.addActionListener(this);
	btnsignin.setBounds(419, 0, 432, 36);
	contentPane.add(btnsignin);
	
	 btnfeedback = new JButton("FEEDBACK");
	 btnfeedback.addActionListener(this);
	btnfeedback.setBounds(846, 0, 516, 36);
	contentPane.add(btnfeedback);
	
	JLabel lblNewLabel = new JLabel("User ID");
	lblNewLabel.setForeground(Color.BLACK);
	lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
	lblNewLabel.setBounds(329, 369, 148, 36);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("User Password");
	lblNewLabel_1.setForeground(Color.BLACK);
	lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 24));
	lblNewLabel_1.setBounds(321, 476, 237, 42);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_3 = new JLabel("");
	lblNewLabel_3.setIcon(new ImageIcon(SignIn.class.getResource("/images/new_precursor[1].jpg")));
	lblNewLabel_3.setBounds(384, 57, 605, 214);
	contentPane.add(lblNewLabel_3);
	
	 btnsign = new JButton("LOGIN");
	 btnsign.setForeground(Color.WHITE);
	 btnsign.addActionListener(this);
	btnsign.setFont(new Font("Arial Black", Font.BOLD, 18));
	btnsign.setBackground(Color.BLACK);
	btnsign.setBounds(632, 593, 163, 36);
	contentPane.add(btnsign);
	
	txtuserid = new JTextField();
	txtuserid.setFont(new Font("Tahoma", Font.PLAIN, 14));
	txtuserid.setForeground(Color.BLACK);
	txtuserid.setBackground(Color.WHITE);
	txtuserid.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
	txtuserid.setBounds(659, 376, 181, 34);
	contentPane.add(txtuserid);
	txtuserid.setColumns(10);
	
	txtuserpass = new JPasswordField();
	txtuserpass.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
	txtuserpass.setForeground(Color.BLACK);
	txtuserpass.setBackground(Color.WHITE);
	txtuserpass.setBounds(659, 476, 181, 37);
	contentPane.add(txtuserpass);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setIcon(new ImageIcon(SignIn.class.getResource("/images/l.png")));
	lblNewLabel_2.setBounds(0, 35, 1362, 670);
	contentPane.add(lblNewLabel_2);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String caption=e.getActionCommand();
	if(caption.equals("HOME PAGE"))
	{
		HomePage hp=new HomePage();
		hp.setVisible(true);
	}			
		
		
	if(caption.equals("SIGN IN"))
	{
		SignIn si=new SignIn();
		si.setVisible(true);
		
	}			
			
	if(caption.equals("FEEDBACK"))
	{
		Feedback fb=new Feedback();
		fb.setVisible(true);
	}	
if(caption.equals("LOGIN")){
String userid=txtuserid.getText();

char pwd[]=txtuserpass.getPassword();
String userpass=new String(pwd).trim();

	
if(userid.isEmpty()||userpass.isEmpty())
{
	JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
}
else{

		
		try{
			String strsql="Select * from account where Userid=? and Userpass=?"	;
		ps=con.prepareStatement(strsql);
		ps.setString(1, userid);
		ps.setString(2, userpass);
		rs=ps.executeQuery();
		if(rs.next())
		{
			String actType=rs.getString("Usertype");
			if(actType.equalsIgnoreCase("academichead"))
			{
				 AcademicHead ah=new AcademicHead();
				ah.setVisible(true);
				this.dispose();
			}
			if(actType.equalsIgnoreCase("admin"))
			{
				Admin am=new Admin();
				am.setVisible(true);
				this.dispose();
			}
			if(actType.equalsIgnoreCase("counseller"))
			{
				Counsellor am=new Counsellor();
				am.setVisible(true);
				this.dispose();
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(this, "Account not found", "WARNING", JOptionPane.ERROR_MESSAGE);
		
		txtuserid.setText("");
		txtuserpass.setText("");
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
				rs.close();
				ps.close();
				
			}
			catch(SQLException sq)
			{
			System.out.println(sq);	
			}
		}
}
}}
}

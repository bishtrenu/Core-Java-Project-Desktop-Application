package precursor;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Admin extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JTextField txtaccpass;
	private JTextField txtaccid;
	private JComboBox comboBox;
	private JButton btnSubmit, btnNewButton;
	private Connection con;
	private PreparedStatement ps,ps2;
	private ResultSet rs2;
	private JButton btnupdate;
	private JButton btndelete;
	private JButton btnfeedback;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/images/pppp.jpg")));
		setTitle("ADMIN");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
		addWindowListener(this);
		CreateGUI();
		
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRECURSOR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 56));
		lblNewLabel.setBounds(632, 11, 343, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFO SOLUTIONS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Aldhabi", Font.BOLD, 70));
		lblNewLabel_1.setBounds(565, 56, 410, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account ID");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_2.setBounds(365, 200, 179, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account Password");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_3.setBounds(365, 341, 279, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("User Type");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(365, 500, 195, 34);
		contentPane.add(lblNewLabel_4);
		
		txtaccpass = new JTextField();
		txtaccpass.setBounds(805, 347, 218, 34);
		contentPane.add(txtaccpass);
		txtaccpass.setColumns(10);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(805, 500, 218, 34);
		fillcombo();
		contentPane.add(comboBox);
		
		txtaccid = new JTextField();
		txtaccid.setBounds(805, 206, 218, 34);
		contentPane.add(txtaccid);
		txtaccid.setColumns(10);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnSubmit.setBounds(644, 590, 119, 34);
		contentPane.add(btnSubmit);
		
		btnNewButton = new JButton("View Student Report");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(1082, 631, 256, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Admin.class.getResource("/images/g.jpg")));
		lblNewLabel_5.setBounds(254, 0, 1108, 705);
		contentPane.add(lblNewLabel_5);
		
		btnupdate = new JButton("Update Account");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnupdate.setBounds(66, 532, 178, 34);
		contentPane.add(btnupdate);
		
		btndelete = new JButton("Delete Account");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btndelete.setBounds(66, 615, 178, 34);
		contentPane.add(btndelete);
		
		btnfeedback = new JButton("View Feedback");
		btnfeedback.addActionListener(this);
		btnfeedback.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnfeedback.setBounds(66, 454, 178, 34);
		contentPane.add(btnfeedback);
	}
	public void fillcombo()
	{
		comboBox.addItem("Select UserType");
		comboBox.addItem("Trainer");
		comboBox.addItem("Academichead");
		comboBox.addItem("Counseller");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String Caption=e.getActionCommand();
		if(Caption.equals("View Student Report"))
		{
			ViewReport vr=new ViewReport();
			vr.setVisible(true);
		}
		if(Caption.equals("Update Account"))
		{
			UpdateAccount ua=new UpdateAccount();
			ua.setVisible(true);
		}
		if(Caption.equals("Delete Account"))
		{
			DeleteAccount da=new DeleteAccount();
			da.setVisible(true);
		}
		if(Caption.equals("View Feedback"))
		{
			ViewFeedback da=new ViewFeedback();
			da.setVisible(true);
		}
		if(Caption.equals("SUBMIT"))
			{
		String accid=txtaccid.getText();
		String accpass=txtaccpass.getText();
		String acctype=(String)comboBox.getSelectedItem();
		if(accid.isEmpty()||accpass.isEmpty()||acctype.equals("Select UserType"))
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else{
			String str="Select * from account where userid=?";
			try
				{
					ps2=con.prepareStatement(str);
					ps2.setString(1, accid);
					rs2=ps2.executeQuery();
					if(rs2.next())
					{
						

						JOptionPane.showMessageDialog(this,"Account is already created","", JOptionPane.QUESTION_MESSAGE);
						txtaccid.setText("");
						txtaccpass.setText("");

					}
					else{
						try
		{
			String strsql="Insert into account values(?,?,?)";

			ps=con.prepareStatement(strsql);
			ps.setString(1, accid);
			ps.setString(2, accpass);
			ps.setString(3, acctype);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				JOptionPane.showMessageDialog(this,"Account Added" , "Account ", JOptionPane.INFORMATION_MESSAGE);
				
				txtaccid.setText("");
				txtaccpass.setText("");
				
				
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
					}}
		
		
					catch(SQLException sq)
					{
						System.out.println(sq);
					}
					
		
		}
		
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.dispose();
		SignIn si=new SignIn();
		si.setVisible(true);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

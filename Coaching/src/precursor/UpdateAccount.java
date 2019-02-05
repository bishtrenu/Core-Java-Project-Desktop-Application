package precursor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class UpdateAccount extends JFrame implements Runnable,ActionListener{
	Thread t;
	Color c1,c2,c3,c4;
	private JPanel contentPane;
	 private Connection con;
		private PreparedStatement ps,ps1,ps2;
		private ResultSet rs,rs1;
		private JTextField txtpass;
		JButton btnpass,btnupdate;
		private JComboBox comboID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAccount frame = new UpdateAccount();
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
	public UpdateAccount() {
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateAccount.class.getResource("/images/pppp.jpg")));
		setTitle("UpdateAccount");
		t=new Thread(this);
		CreateGUI();
		t.start();
	}
	
	public void fillCombo()
	{
		String strsql="select * from account";
		try
		{
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String acid=rs.getString("Userid");
				comboID.addItem(acid);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public void CreateGUI()
	{    c1=new Color(0,0,0);
		c2=new Color(250,0,0);
		c3=new Color(0,0,250);
		c4=new Color(0,200,0);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Precursor");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 50));
		label.setBounds(180, 11, 347, 50);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(138, 53, 344, 49);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Select UserID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setBounds(106, 151, 173, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(106, 232, 173, 31);
		contentPane.add(lblNewLabel_1);
		
		 btnpass = new JButton("Show password");
		 btnpass.addActionListener(this);
		btnpass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnpass.setBounds(63, 339, 195, 39);
		contentPane.add(btnpass);
		
		 btnupdate = new JButton("Update Password");
		 btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnupdate.setBounds(416, 341, 201, 34);
		contentPane.add(btnupdate);
		
		txtpass = new JTextField();
		txtpass.setBounds(359, 235, 168, 31);
		contentPane.add(txtpass);
		txtpass.setColumns(10);
		
		comboID = new JComboBox();
		comboID.setModel(new DefaultComboBoxModel(new String[] {"Select UserID"}));
		comboID.setBounds(356, 151, 171, 28);
		fillCombo();
		contentPane.add(comboID);
	}

public void run() {

	while(true)	{
		try {
			contentPane.setBackground(c1);
			Thread.sleep(1000);
			contentPane.setBackground(c2);
			Thread.sleep(1000);
			contentPane.setBackground(c3);
			Thread.sleep(1000);
			contentPane.setBackground(c4);
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}

@Override
public void actionPerformed(ActionEvent e) {
	String caption=e.getActionCommand();
	String uid=(String)comboID.getSelectedItem();
	if(uid.equals("Select UserID"))
	{
		JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
	}
	else
	{
		if(caption.equals("Show password"))
		{try{
			String strselect="select * from account where Userid=? ";
			ps1=con.prepareStatement(strselect);
			ps1.setString(1, uid);
			rs1=ps1.executeQuery();
			rs1.next();
						
			String userid=rs1.getString("Userpass");
			txtpass.setText(userid);
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		
		}
		if(caption.equals("Update Password"))
		{
			try
			{
			String strinsert="Update account set Userpass=? where Userid=?";
			ps2=con.prepareStatement(strinsert);
			
			String upass=txtpass.getText();
			ps2.setString(1, upass);
			ps2.setString(2, uid);
						int rw=ps2.executeUpdate();
			if(rw>0)
			{
				JOptionPane.showMessageDialog(this,"Account Password is Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
			}
			
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			finally
			{
				try
				{   ps2.close();
					rs1.close();
					ps1.close();
					
				}
				catch(SQLException sq)
				{
				System.out.println(sq);	
				}
			}
			
			txtpass.setText("");
			comboID.removeAllItems();
			comboID.addItem("Select UserID");
			fillCombo();
			
		}
	}
	
}
}

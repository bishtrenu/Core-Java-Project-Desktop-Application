package precursor;
import java.sql.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class UpdateStudent extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphone;
	private JTextField txtemail;
	private JButton btnshow,btnupdate;
	private JComboBox comboid;
	private Connection con;
	private PreparedStatement ps,ps1,ps2;
	private ResultSet rs,rs1;
	private JTextArea txtadd;
	private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
	public UpdateStudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateStudent.class.getResource("/images/pppp.jpg")));
		setTitle("UpdateStudent");
		con=CrudOperation.createConnection();
		 CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Precursor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(200, 11, 318, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INFO SOLUTIONS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setBounds(174, 56, 344, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Student ID");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(222, 184, 135));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_2.setBounds(89, 127, 222, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBackground(new Color(222, 184, 135));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_3.setBounds(89, 179, 222, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(222, 184, 135));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_4.setBounds(89, 229, 222, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email ID");
		lblNewLabel_5.setBackground(new Color(222, 184, 135));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_5.setBounds(87, 289, 224, 30);
		contentPane.add(lblNewLabel_5);
		
		btnshow = new JButton("Show Details");
		btnshow.setForeground(new Color(255, 255, 255));
		btnshow.setBackground(new Color(0, 0, 139));
		btnshow.addActionListener(this);
		btnshow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnshow.setBounds(45, 376, 182, 36);
		contentPane.add(btnshow);
		
		btnupdate = new JButton("Update Details ");
		btnupdate.setBackground(new Color(0, 0, 139));
		btnupdate.setForeground(new Color(255, 255, 255));
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnupdate.setBounds(448, 376, 202, 36);
		contentPane.add(btnupdate);
		
		txtphone = new JTextField();
		txtphone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtphone.setBounds(383, 179, 208, 27);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtemail.setBounds(383, 294, 208, 27);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		 comboid = new JComboBox();
		 comboid.setModel(new DefaultComboBoxModel(new String[]{"Choose Student ID"}));
		comboid.setBounds(383, 131, 208, 31);
		fillCombo();
		contentPane.add(comboid);
		
		txtadd = new JTextArea();
		txtadd.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtadd.setLineWrap(true);
		txtadd.setBounds(380, 217, 211, 60);
		contentPane.add(txtadd);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(UpdateStudent.class.getResource("/images/new-Knowledge-Center.jpg")));
		lblNewLabel_6.setBounds(0, 0, 757, 439);
		contentPane.add(lblNewLabel_6);
	}
	public void fillCombo()
	{

		try
		{String strsql="select * from student ";
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String studentid=rs.getString("Studentid");
				comboid.addItem(studentid);
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
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		String sid=(String)comboid.getSelectedItem();
		if(sid.equals("Choose Student ID"))
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
		}
		else
		{
			if(caption.equals("Show Details"))
			{try{
				String strselect="select * from student where Studentid=? ";
				ps1=con.prepareStatement(strselect);
				ps1.setString(1, sid);
				rs1=ps1.executeQuery();
				rs1.next();
				Long phone=rs1.getLong("Phno");
				txtphone.setText(String.valueOf(phone));
				String address=rs1.getString("Address");
				txtadd.setText(address);
				String email=rs1.getString("Emailid");
				txtemail.setText(email);
				
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			
			}
			if(caption.equals("Update Details "))
			{
				try
				{
				String strinsert="Update student set Phno=?,Address=?,Emailid=? where Studentid=?";
				ps2=con.prepareStatement(strinsert);
				String pno=txtphone.getText();
				long phoneno=Long.parseLong(pno);
				String add=txtadd.getText();
				String emiail=txtemail.getText();
				ps2.setLong(1, phoneno);
				ps2.setString(2, add);
				ps2.setString(3, emiail);
				ps2.setString(4, sid);
				int rw=ps2.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this,"Student Details are Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
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
				txtadd.setText("");
				txtemail.setText("");
				txtphone.setText("");
				comboid.removeAllItems();
				comboid.addItem("Choose Student ID");
				fillCombo();
				
			}
		}
	}
}

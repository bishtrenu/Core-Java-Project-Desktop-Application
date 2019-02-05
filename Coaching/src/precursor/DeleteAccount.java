package precursor;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class DeleteAccount extends JFrame implements Runnable,ActionListener{
	Thread t;
	Color c1,c2,c3;
	private JPanel contentPane;
	private JButton btndelete;
    private JComboBox comboid;
    private Connection con;
	private PreparedStatement ps,ps1;
	private ResultSet rs1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
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
	public DeleteAccount() {
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteAccount.class.getResource("/images/pppp.jpg")));
			t=new Thread(this);
			CreateGUI();
			t.start();
	}
	public void CreateGUI()
	{
		c1=new Color(0,0,0);
		c2=new Color(250,0,0);
		c3=new Color(0,0,250);
		setTitle("DELETE  ACCOUNT");
		setBounds(new Rectangle(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 538, 407);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(5, 5, 5, 5));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboid = new JComboBox();
		comboid.setModel(new DefaultComboBoxModel(new String[] {"Select UserID"}));
		comboid.setBounds(292, 130, 157, 33);
		fillCombo();
		contentPane.add(comboid);
		
		btndelete = new JButton("Delete account");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btndelete.setBounds(325, 307, 187, 33);
		contentPane.add(btndelete);
		
		JLabel label = new JLabel("Precursor");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(129, 11, 279, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(91, 52, 344, 49);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Select Account ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(47, 128, 166, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DeleteAccount.class.getResource("/images/images(71).jpg")));
		lblNewLabel_1.setBounds(47, 181, 181, 176);
		contentPane.add(lblNewLabel_1);
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
			} 
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			}
		}
	public void fillCombo()
	{
		String strsql="select * from account";
		try
		{
			ps1=con.prepareStatement(strsql);
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				String acid=rs1.getString("Userid");
				comboid.addItem(acid);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
			String data=(String)comboid.getSelectedItem();
			
			if(data.equals("Select UserID"))
			{
				JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
			}
			else{int option=JOptionPane.showConfirmDialog(this,"Are You Sure");
			if(option==0)
			{
				String strdelete="Delete from account where Userid=?";
				try
				{
					ps=con.prepareStatement(strdelete);
					ps.setString(1, data);
					int rw=ps.executeUpdate();
					if(rw>0)
					{

						JOptionPane.showMessageDialog(this,"Account Deleted Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE);
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
				comboid.removeAllItems();
				comboid.addItem("Select StudentID");
				fillCombo();
			}	}
		}
		
	
}

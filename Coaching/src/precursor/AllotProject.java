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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class AllotProject extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox comboprojectid,combostudentid;
	private JButton btnsubmit;
	private JDateChooser date ;
	private Connection con;
	private PreparedStatement ps,ps1,ps2,ps3;
	private ResultSet rs,rs2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllotProject frame = new AllotProject();
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
	public AllotProject() {
		setTitle("ALLOT PROJECT");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AllotProject.class.getResource("/images/pppp.jpg")));
		con=CrudOperation.createConnection();
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllotProject.class.getResource("/images/M.jpg")));
		lblNewLabel.setBounds(0, 11, 247, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AllotProject.class.getResource("/images/R.jpg")));
		lblNewLabel_1.setBounds(338, 29, 215, 146);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Project ID");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(30, 133, 111, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Student ID");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 240, 130, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dateassigned");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(30, 340, 144, 23);
		contentPane.add(lblNewLabel_4);
		
		comboprojectid = new JComboBox();
		comboprojectid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		comboprojectid.setBounds(184, 129, 130, 30);
		comboprojectid.addItem("Select Project ID");
		fillComboPid();
		contentPane.add(comboprojectid);
		
		 combostudentid = new JComboBox();
		combostudentid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		combostudentid.setBounds(184, 236, 133, 30);
		combostudentid.addItem("Select Student ID");
		fillComboSid();
		contentPane.add(combostudentid);
		
		 btnsubmit = new JButton("Submit");
		 btnsubmit.addActionListener(this);
		btnsubmit.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnsubmit.setBounds(414, 371, 129, 35);
		contentPane.add(btnsubmit);
		
		 date = new JDateChooser();
		date.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		date.setBounds(184, 340, 130, 30);
		contentPane.add(date);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AllotProject.class.getResource("/images/s.jpg")));
		lblNewLabel_5.setBounds(-12, 0, 578, 426);
		contentPane.add(lblNewLabel_5);
	}
public void fillComboPid()
{
	String strsql="select * from project";
	try
	{
		ps=con.prepareStatement(strsql);
		rs=ps.executeQuery();
		while(rs.next())
		{
			String pid=rs.getString("Projectid");
			comboprojectid.addItem(pid);
		}
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	finally
	{
		try
		{rs.close();
			ps.close();
			
		}
		catch(SQLException sq)
		{
		System.out.println(sq);	
		}
	}
}
public void fillComboSid()
{
	String strsql="select * from student ";
	try
	{
		ps2=con.prepareStatement(strsql);
		rs2=ps2.executeQuery();
		
		while(rs2.next())
		{
			String sid=rs2.getString("Studentid");
			String pid=rs2.getString("Pid");
			if(pid==null)
			{
			combostudentid.addItem(sid);
			}
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
			rs2.close();
			ps2.close();
			
		}
		catch(SQLException sq)
		{
		System.out.println(sq);	
		}
	}
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String projectid=(String)comboprojectid.getSelectedItem();
		String studentid=(String)combostudentid.getSelectedItem();
		java.util.Date d=date.getDate();
		
		java.sql.Date assigneddate=new java.sql.Date(d.getTime());
		if(projectid.equals("Select Project ID")||studentid.equals("Select student ID"))
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{
			
			try{
				
				String strinsert="Insert into assignproject (Projectid,studentid,Dateassigned)values(?,?,?)";
				ps3=con.prepareStatement(strinsert);
				ps3.setString(1, projectid);
				ps3.setString(2, studentid);
				ps3.setDate(3, assigneddate);
				
				int rw=ps3.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this,"Data Added", "Insert", JOptionPane.INFORMATION_MESSAGE);
					
				}
				String strupdate="Update student set Pid=? where Studentid=?";
				
				ps1=con.prepareStatement(strupdate);
				ps1.setString(1, projectid);
				ps1.setString(2, studentid);
				
				
				int rw1=ps1.executeUpdate();
				if(rw1>0)
				{
					JOptionPane.showMessageDialog(this,"Data Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
					
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
					ps1.close();
					ps3.close();
					
				}
				catch(SQLException sq)
				{
				System.out.println(sq);	
				}
			}

			comboprojectid.removeAllItems();
			comboprojectid.addItem("Select Project ID");
			fillComboPid();
			combostudentid.removeAllItems();
			combostudentid.addItem("Select Student ID");
			fillComboSid();
					}
			
		
	}
}

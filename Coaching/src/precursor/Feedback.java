package precursor;

import java.awt.BorderLayout;

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
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import java.sql.*;
import java.awt.Toolkit;
public class Feedback extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnfeedback, btnhomepage,btnsignin,btnsfeedback ;
	private JLabel label;
	private JLabel lblNewLabel;
	private JTextField txtsname;
	private JLabel lblNewLabel_1;
	private JTextField txtsid;
	private Connection con;
	private PreparedStatement ps,ps2;
	private ResultSet rs,rs2;
	private JTextArea txtfeedback;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		setTitle("STUDENT FEEDBACK");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Feedback.class.getResource("/images/pppp.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		con=CrudOperation.createConnection();
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnhomepage = new JButton("HOME PAGE");
		 btnhomepage.addActionListener(this);
		btnhomepage.setBounds(0, 0, 420, 36);
		contentPane.add(btnhomepage);
		
		 btnsignin = new JButton("SIGN IN");
		 btnsignin.addActionListener(this);
		btnsignin.setBounds(417, 0, 426, 36);
		contentPane.add(btnsignin);
		
		 btnfeedback = new JButton("FEEDBACK");
		 btnfeedback.addActionListener(this);
		btnfeedback.setBounds(838, 0, 514, 36);
		contentPane.add(btnfeedback);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Feedback.class.getResource("/images/bbbbbb.jpg")));
		label.setBounds(457, 41, 478, 161);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(308, 274, 209, 36);
		contentPane.add(lblNewLabel);
		
		txtsname = new JTextField();
		txtsname.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtsname.setBounds(722, 274, 204, 36);
		contentPane.add(txtsname);
		txtsname.setColumns(10);
		
		lblNewLabel_1 = new JLabel("FeedBack");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1.setBounds(308, 419, 165, 26);
		contentPane.add(lblNewLabel_1);
		
		txtfeedback = new JTextArea();
		txtfeedback.setLineWrap(true);
		txtfeedback.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtfeedback.setBounds(722, 367, 216, 138);
		contentPane.add(txtfeedback);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_2.setBounds(308, 561, 165, 26);
		contentPane.add(lblNewLabel_2);
		
		txtsid = new JTextField();
		txtsid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtsid.setBounds(722, 561, 204, 26);
		contentPane.add(txtsid);
		txtsid.setColumns(10);
		
		btnsfeedback = new JButton("Student FeedBack");
		btnsfeedback.addActionListener(this);
		btnsfeedback.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnsfeedback.setBounds(479, 633, 204, 45);
		contentPane.add(btnsfeedback);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Feedback.class.getResource("/images/b7cc75ddcef63ae6c40bb50163012c3c.jpg")));
		lblNewLabel_3.setBounds(0, 35, 1373, 682);
		contentPane.add(lblNewLabel_3);
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
		if(caption.equals("Student FeedBack"))
		{
			String sname=txtsname.getText();
			String feedback=txtfeedback.getText();
			String sid=txtsid.getText();
			if(sname.isEmpty()||feedback.isEmpty()||sid.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
				
			}
			else
			{       String str="Select * from student where studentid=?";
			try
			{
				ps2=con.prepareStatement(str);
				ps2.setString(1, sid);
				rs2=ps2.executeQuery();
				if(rs2.next())
				{
					

					JOptionPane.showMessageDialog(this,"Feedback is already given","", JOptionPane.QUESTION_MESSAGE);
					txtfeedback.setText("");
					txtsid.setText("");
					txtsname.setText("");
				}
				else
				{
				try{
					String strinsert="insert into feedback(Studentname,Feedback,Studentid)values(?,?,?)";
					ps=con.prepareStatement(strinsert);
					ps.setString(1,sname );
					ps.setString(2, feedback);
					ps.setString(3, sid);
					int rw=ps.executeUpdate();
					
					if(rw>0)
					{
						JOptionPane.showMessageDialog(this,"Feedback Added Successfully", "Feedback", JOptionPane.INFORMATION_MESSAGE);
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
				txtfeedback.setText("");
				txtsid.setText("");
				txtsname.setText("");
			}}
			catch(SQLException sq)
			{
				System.out.println(sq);
			}
			
			
		}	
		
	}
}}

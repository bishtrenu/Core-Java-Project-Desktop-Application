
package precursor;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Toolkit;
public class CreateCourses extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtcid;
	private JTextField txtcname;
	private JTextField txtfee;
	private JTextField txtduration;
	private JButton btnaddcourse;
private Connection con;
private PreparedStatement ps,ps2;
private ResultSet rs2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCourses frame = new CreateCourses();
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
	public CreateCourses() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateCourses.class.getResource("/images/pppp.jpg")));
		setTitle("Courses");
		con=CrudOperation.createConnection();
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PRECURSOR");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Algerian", Font.BOLD, 56));
		label.setBackground(Color.BLACK);
		label.setBounds(203, 11, 341, 58);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Aldhabi", Font.BOLD, 70));
		label_1.setBounds(137, 63, 410, 51);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Course ID");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setBounds(125, 182, 105, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Coursename\r\n");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(125, 233, 141, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fee\r\n");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(133, 289, 97, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Duration\r\n");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(125, 347, 105, 23);
		contentPane.add(lblNewLabel_3);
		
		 btnaddcourse = new JButton("Add Course");
		 btnaddcourse.addActionListener(this);
		btnaddcourse.setFont(new Font("Bell MT", Font.BOLD, 18));
		btnaddcourse.setBounds(281, 422, 149, 30);
		contentPane.add(btnaddcourse);
		
		txtcid = new JTextField();
		txtcid.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtcid.setBounds(322, 182, 164, 30);
		contentPane.add(txtcid);
		txtcid.setColumns(10);
		
		txtcname = new JTextField();
		txtcname.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.BLACK));
		txtcname.setBounds(322, 233, 164, 28);
		contentPane.add(txtcname);
		txtcname.setColumns(10);
		
		txtfee = new JTextField();
		txtfee.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtfee.setBounds(322, 288, 164, 30);
		contentPane.add(txtfee);
		txtfee.setColumns(10);
		
		txtduration = new JTextField();
		txtduration.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.BLACK));
		txtduration.setBounds(322, 346, 164, 30);
		contentPane.add(txtduration);
		txtduration.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(CreateCourses.class.getResource("/images/k.jpg")));
		lblNewLabel_4.setBounds(0, 0, 691, 516);
		contentPane.add(lblNewLabel_4);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cid=txtcid.getText();
		String cname=txtcname.getText();
		String f=txtfee.getText();
		if(f.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{
		int fee=Integer.parseInt(f);
		String duration=txtduration.getText();
		if(cid.isEmpty()||cname.isEmpty()||duration.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else{
			String str="Select * from course where Cid=?";
			try
				{
					ps2=con.prepareStatement(str);
					ps2.setString(1, cid);
					rs2=ps2.executeQuery();
					if(rs2.next())
					{
						

						JOptionPane.showMessageDialog(this,"Course is already created","", JOptionPane.QUESTION_MESSAGE);
						txtcid.setText("");
						txtcname.setText("");
						txtfee.setText("");
						txtduration.setText("");
					}
					else{

		try{
			
			String strinsert="Insert into course values(?,?,?,?)";
			ps=con.prepareStatement(strinsert);
			ps.setString(1, cid);
			ps.setString(2, cname);
			ps.setInt(3, fee);
			ps.setString(4, duration);
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				JOptionPane.showMessageDialog(this,"Data Added", "Insert", JOptionPane.INFORMATION_MESSAGE);
				txtcid.setText("");
				txtcname.setText("");
				txtfee.setText("");
				txtduration.setText("");
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
		}}
		}
			catch(SQLException sq)
			{
				System.out.println(sq);
			}
		}
	}}
}

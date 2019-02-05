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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class DeleteStudent extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JComboBox comboBox;
	private Connection con;
	private PreparedStatement ps,ps1;
	private ResultSet rs1;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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
	public void fillCombo()
	{
		String strsql="select * from student";
		try
		{
			ps1=con.prepareStatement(strsql);
			rs1=ps1.executeQuery();
			while(rs1.next())
			{
				String acid=rs1.getString("Studentid");
				comboBox.addItem(acid);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}
	public DeleteStudent()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteStudent.class.getResource("/images/pppp.jpg")));

		con=CrudOperation.createConnection();
		setTitle("DeleteStudent");
		createGUI();
	}
	public void createGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		comboBox.setFont(new Font("Arial", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select StudentID"}));
		comboBox.setBounds(169, 151, 138, 32);
		fillCombo();
		contentPane.add(comboBox);
		
		btnDelete = new JButton("Delete Account");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		btnDelete.addActionListener(this);
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnDelete.setBounds(255, 282, 211, 35);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("Precursor");
		label.setForeground(new Color(255, 255, 255));
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(129, 11, 279, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(64, 51, 344, 49);
		contentPane.add(label_1);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(new Color(255, 255, 255));
		lblStudentId.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblStudentId.setBounds(21, 148, 138, 35);
		contentPane.add(lblStudentId);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeleteStudent.class.getResource("/images/jj.jpg")));
		lblNewLabel.setBounds(0, 0, 546, 350);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String data=(String)comboBox.getSelectedItem();
		
		if(data.equals("Select StudentID"))
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
		}
		else{int option=JOptionPane.showConfirmDialog(this,"Are You Sure");
		if(option==0)
		{
			String strdelete="Delete from student where Studentid=?";
			try
			{
				ps=con.prepareStatement(strdelete);
				ps.setString(1, data);
				int rw=ps.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this,"Data Deleted Successfully", "Delete", JOptionPane.INFORMATION_MESSAGE);
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
			comboBox.addItem("Select StudentID");
			fillCombo();
		}	}
	}
}
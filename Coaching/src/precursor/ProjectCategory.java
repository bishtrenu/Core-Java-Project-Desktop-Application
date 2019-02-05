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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class ProjectCategory extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtcategoryid;
	private JTextField txtcategoryname;
	private JButton txtsubmit;
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
					ProjectCategory frame = new ProjectCategory();
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
	public ProjectCategory() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectCategory.class.getResource("/images/pppp.jpg")));
		con=CrudOperation.createConnection();
		CreateGUI();
	}
	public void CreateGUI()
	{
		setTitle("ProjectCategory");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProjectCategory.class.getResource("/images/M.jpg")));
		lblNewLabel.setBounds(134, 11, 246, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category ID\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(61, 126, 134, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Category Name");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(61, 167, 156, 20);
		contentPane.add(lblNewLabel_2);
		
		txtcategoryid = new JTextField();
		txtcategoryid.setBounds(271, 126, 109, 23);
		contentPane.add(txtcategoryid);
		txtcategoryid.setColumns(10);
		
		txtcategoryname = new JTextField();
		txtcategoryname.setBounds(271, 167, 109, 23);
		contentPane.add(txtcategoryname);
		txtcategoryname.setColumns(10);
		
		 txtsubmit = new JButton("Submit");
		 txtsubmit.addActionListener(this);
		txtsubmit.setForeground(Color.WHITE);
		txtsubmit.setBackground(Color.BLACK);
		txtsubmit.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		txtsubmit.setBounds(166, 225, 134, 35);
		contentPane.add(txtsubmit);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ProjectCategory.class.getResource("/images/images(20).jpg")));
		lblNewLabel_3.setBounds(0, 0, 512, 300);
		contentPane.add(lblNewLabel_3);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String categoryid=txtcategoryid.getText();
		String categoryname=txtcategoryname.getText();
		if(categoryid.isEmpty()||categoryname.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{
			String str="Select * from projectcategory where categoryid=?";
			try
				{
					ps2=con.prepareStatement(str);
					ps2.setString(1, categoryid);
					rs2=ps2.executeQuery();
					if(rs2.next())
					{
						

						JOptionPane.showMessageDialog(this,"Projectcategory is already created","", JOptionPane.QUESTION_MESSAGE);
						txtcategoryid.setText("");
						txtcategoryname.setText("");
					}
					else{
		try
		{
			String strinsert="Insert into projectcategory values(?,?)";
			ps=con.prepareStatement(strinsert);
			ps.setString(1, categoryid);
			ps.setString(2, categoryname);
			
			int rw=ps.executeUpdate();
			if(rw>0)
			{
				JOptionPane.showMessageDialog(this,"Data Added", "Insert", JOptionPane.INFORMATION_MESSAGE);
				txtcategoryid.setText("");
				txtcategoryname.setText("");
				
		}}
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

}
}
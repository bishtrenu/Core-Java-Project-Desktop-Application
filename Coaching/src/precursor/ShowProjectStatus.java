package precursor;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class ShowProjectStatus extends JFrame {
	private Connection con;
	private PreparedStatement psdata,pscount;
	private ResultSet rsdata,rscount;
		String[]colNames={"StudentID","Studentname","Project Status"};
	Object[][]data;

	JTable jt;
	JScrollPane jsp;
		
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowProjectStatus frame = new ShowProjectStatus();
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
	public ShowProjectStatus() {
		setTitle("Show Project Status");
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteAccount.class.getResource("/images/pppp.jpg")));
			
		createGUI();
	}
	public void createGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        fillData();
		
		jt=new JTable(new DefaultTableModel(data, colNames));
		jsp=new JScrollPane(jt);
		jsp.setBounds(31,161,500,175);
		contentPane.add(jsp);
		
		JLabel label = new JLabel("Precursor");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(170, 11, 279, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(105, 57, 344, 49);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShowProjectStatus.class.getResource("/images/images(74).jpg")));
		lblNewLabel.setBounds(0, 0, 566, 411);
		contentPane.add(lblNewLabel);
	}
	public void fillData()
	{
		
		try{
			
		String strcount="select count(*) from student where Submitted=?";
		
		pscount=con.prepareStatement(strcount);
		pscount.setString(1,"Project Submitted");
		rscount=pscount.executeQuery();
			rscount.next();
			int cnt=rscount.getInt(1);
			data=new Object[cnt][3];
	String strdata="select * from student where Submitted=?";
	psdata=con.prepareStatement(strdata);
	psdata.setString(1,"Project Submitted");
	rsdata=psdata.executeQuery();
	int row=0;
		while(rsdata.next())
		{
			data[row][0]=rsdata.getString("Studentid");
			data[row][1]=rsdata.getString("Name");
			data[row][2]=rsdata.getString("Submitted");
			
			row++;
			
		}
		
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}	
	}
}

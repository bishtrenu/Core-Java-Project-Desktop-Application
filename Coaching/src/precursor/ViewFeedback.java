package precursor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.ImageIcon;

public class ViewFeedback extends JFrame 
{
	private Connection con;
private PreparedStatement psdata,pscount;
private ResultSet rsdata,rscount;
	String[]colNames={"Studentname","Feedback"};
Object[][]data;

JTable jt;
JScrollPane jsp;
	

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFeedback frame = new ViewFeedback();
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
	public ViewFeedback() {
		setTitle("View Feedback");
		
		con=CrudOperation.createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteAccount.class.getResource("/images/pppp.jpg")));
			
		createGUI();
	}
	public void createGUI()
	{

		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fillData();
		
		jt=new JTable(new DefaultTableModel(data, colNames));
		jsp=new JScrollPane(jt);
		jsp.setBounds(201,267,500,175);
		contentPane.add(jsp);
		
		JLabel label = new JLabel("Precursor");
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 45));
		label.setBounds(10, 0, 279, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(10, 49, 344, 49);
		contentPane.add(label_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewFeedback.class.getResource("/images/feedback.jpg")));
		lblNewLabel.setBounds(10, -16, 713, 481);
		contentPane.add(lblNewLabel);
	}
	
	public void fillData()
	{
		
		try{
			
		String strcount="select count(*) from feedback";
		
		pscount=con.prepareStatement(strcount);
		rscount=pscount.executeQuery();
			rscount.next();
			int cnt=rscount.getInt(1);
			data=new Object[cnt][2];
	String strdata="select * from feedback";
	psdata=con.prepareStatement(strdata);
	rsdata=psdata.executeQuery();
	int row=0;
		while(rsdata.next())
		{
			data[row][0]=rsdata.getString("Studentname");
			data[row][1]=rsdata.getString("Feedback");
			
			row++;
			
		}
		
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}	
	}
}

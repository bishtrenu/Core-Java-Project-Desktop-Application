package precursor;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class UpdateProjectStatus extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JComboBox combosid;
	private JButton btnupdatestatus,btnshowstatus;
	private PreparedStatement ps,ps1;
	private ResultSet rs;
	private Connection con;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProjectStatus frame = new UpdateProjectStatus();
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
	public UpdateProjectStatus()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateProjectStatus.class.getResource("/images/pppp.jpg")));
		setTitle("UpdateProjectStatus");
		con=CrudOperation.createConnection();
		createGUI();
	}
	public void createGUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 combosid = new JComboBox();
		combosid.setFont(new Font("Arial", Font.BOLD, 13));
		combosid.setModel(new DefaultComboBoxModel(new String[] {"Select StudentID"}));
		combosid.setBounds(262, 169, 181, 32);
		fillCombo();
		contentPane.add(combosid);
		
		 btnupdatestatus = new JButton("Update Project Status");
		 btnupdatestatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)));
		 btnupdatestatus.addActionListener(this);
		btnupdatestatus.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnupdatestatus.setBounds(250, 273, 229, 32);
		contentPane.add(btnupdatestatus);
		
		label = new JLabel("Precursor");
		label.setBackground(new Color(255, 0, 0));
		label.setForeground(new Color(0, 0, 0));
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 50));
		label.setBounds(125, 11, 318, 49);
		contentPane.add(label);
		
		label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setVerticalTextPosition(SwingConstants.TOP);
		label_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 41));
		label_1.setBounds(78, 53, 344, 49);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Student ID");
		label_2.setBackground(new Color(240, 240, 240));
		label_2.setFont(new Font("Arial Black", Font.BOLD, 22));
		label_2.setBounds(81, 161, 155, 41);
		contentPane.add(label_2);
		
		btnshowstatus = new JButton("Show Project Status");
		btnshowstatus.addActionListener(this);
		btnshowstatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnshowstatus.setBounds(10, 309, 202, 32);
		contentPane.add(btnshowstatus);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UpdateProjectStatus.class.getResource("/images/images (29).jpg")));
		lblNewLabel.setBounds(0, 0, 489, 352);
		contentPane.add(lblNewLabel);
	}
	public void fillCombo()
	{
		String strsql="select * from student";
		try
		{
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String acid=rs.getString("Studentid");
				String projectid=rs.getString("Pid");
				String status=rs.getString("Submitted");
				if(projectid!=null&& status.equalsIgnoreCase("notsubmitted") )
				{
				combosid.addItem(acid);
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
		if(caption.equals("Update Project Status"))
		{
		String sid=(String)combosid.getSelectedItem();
		if(sid.equals("Choose Student ID"))
		{
			JOptionPane.showMessageDialog(this,"Data Required","", JOptionPane.QUESTION_MESSAGE);	
		}
		else
		{
				try
				{
				String strinsert="Update student set Submitted=? where Studentid=?";
				ps1=con.prepareStatement(strinsert);
				
				ps1.setString(1, "Project Submitted");
				ps1.setString(2, sid);
				
				int rw=ps1.executeUpdate();
				if(rw>0)
				{
					JOptionPane.showMessageDialog(this,"Project status is updated as Submitted", "Update", JOptionPane.INFORMATION_MESSAGE);
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
						
						ps1.close();
						
					}
					catch(SQLException sq)
					{
					System.out.println(sq);	
					}
				}
				combosid.removeAllItems();
				combosid.addItem("Select StudentID");
				fillCombo();
				
			}
		}
		if(caption.equals("Show Project Status"))
		{
			ShowProjectStatus sps=new ShowProjectStatus();
			sps.setVisible(true);
		}
		}
}

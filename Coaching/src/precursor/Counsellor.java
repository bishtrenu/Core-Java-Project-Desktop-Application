package precursor;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Counsellor extends JFrame implements ActionListener,WindowListener
{

	private JPanel contentPane;
	private JButton btnadd,btndelete,btnupdate,btnupdatestatus,btnview ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counsellor frame = new Counsellor();
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
	public Counsellor() {
		setTitle("COUNSELLOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Counsellor.class.getResource("/images/pppp.jpg")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(this);
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PRECURSOR");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Algerian", Font.BOLD, 56));
		label.setBackground(Color.BLACK);
		label.setBounds(444, 24, 341, 69);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Aldhabi", Font.BOLD, 50));
		label_1.setBounds(444, 74, 326, 54);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Counsellor.class.getResource("/images/aa.png")));
		lblNewLabel.setBounds(71, 199, 209, 171);
		contentPane.add(lblNewLabel);
		
		 btnadd = new JButton("Add Student");
		btnadd.addActionListener(this);
		btnadd.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnadd.setBounds(299, 265, 176, 35);
		contentPane.add(btnadd);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Counsellor.class.getResource("/images/bb.png")));
		lblNewLabel_1.setBounds(71, 468, 185, 186);
		contentPane.add(lblNewLabel_1);
		
		btndelete = new JButton("Delete  Account");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Arial Black", Font.BOLD, 18));
		btndelete.setBounds(266, 574, 209, 35);
		contentPane.add(btndelete);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Counsellor.class.getResource("/images/cc.jpg")));
		lblNewLabel_2.setBounds(842, 199, 214, 165);
		contentPane.add(lblNewLabel_2);
		
		btnupdate = new JButton("Update Account");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnupdate.setBounds(1078, 265, 209, 35);
		contentPane.add(btnupdate);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Counsellor.class.getResource("/images/dd (2).jpg")));
		lblNewLabel_3.setBounds(842, 468, 185, 171);
		contentPane.add(lblNewLabel_3);
		
		btnupdatestatus = new JButton("Update Project Status");
		btnupdatestatus.addActionListener(this);
		btnupdatestatus.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnupdatestatus.setBounds(1027, 539, 288, 35);
		contentPane.add(btnupdatestatus);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Counsellor.class.getResource("/images/coffee-bean-backgrounds-powerpoint.jpg")));
		lblNewLabel_5.setBounds(444, 25, 400, 121);
		contentPane.add(lblNewLabel_5);
		
		btnview = new JButton("View Student Report");
		btnview.addActionListener(this);
		btnview.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		btnview.setBounds(444, 421, 303, 43);
		contentPane.add(btnview);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Counsellor.class.getResource("/images/8807031-dark-wood-background.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1362, 716);
		contentPane.add(lblNewLabel_4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Caption=e.getActionCommand();
		if(Caption.equals("Add Student"))
		{
			AddStudent as=new AddStudent();
			as.setVisible(true);
		}if(Caption.equals("View Student Report"))
		{
			ViewReport as=new ViewReport();
			as.setVisible(true);
		}
		if(Caption.equals("Delete  Account"))
		{
			DeleteStudent da=new DeleteStudent();
			da.setVisible(true);
		}
		if(Caption.equals("Update Account"))
		{
			UpdateStudent us=new UpdateStudent();
			us.setVisible(true);
		}
		if(Caption.equals("Update Project Status"))
		{
			UpdateProjectStatus ups=new UpdateProjectStatus();
			ups.setVisible(true);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.dispose();
		SignIn si=new SignIn();
		si.setVisible(true);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

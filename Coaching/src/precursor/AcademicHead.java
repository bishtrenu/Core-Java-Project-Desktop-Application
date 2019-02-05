package precursor;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AcademicHead extends JFrame implements ActionListener,WindowListener{

	private JPanel contentPane;
	private JButton btncreateacc,btncreatecategory,btnallotproject,btnaddproject,btnview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcademicHead frame = new AcademicHead();
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
	public AcademicHead() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AcademicHead.class.getResource("/images/pppp.jpg")));
		setTitle("Academic Head");
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		addWindowListener(this);
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 767, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PRECURSOR");
		label.setBackground(new Color(0, 0, 0));
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Algerian", Font.BOLD, 56));
		label.setBounds(530, 11, 341, 69);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("INFO SOLUTIONS");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Aldhabi", Font.BOLD, 70));
		label_1.setBounds(461, 71, 410, 54);
		contentPane.add(label_1);
		
		 btncreateacc = new JButton("Create Courses");
		 btncreateacc.addActionListener(this);
		btncreateacc.setFont(new Font("Arial Black", Font.BOLD, 18));
		btncreateacc.setBounds(307, 265, 205, 47);
		contentPane.add(btncreateacc);
		
		 btncreatecategory = new JButton("Create Project Category");
		 btncreatecategory.addActionListener(this);
		btncreatecategory.setFont(new Font("Arial Black", Font.BOLD, 16));
		btncreatecategory.setBounds(1068, 265, 284, 47);
		contentPane.add(btncreatecategory);
		
		 btnallotproject = new JButton("Allot Project");
		 btnallotproject.addActionListener(this);
		btnallotproject.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnallotproject.setBounds(1081, 540, 205, 47);
		contentPane.add(btnallotproject);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AcademicHead.class.getResource("/images/c.jpg")));
		lblNewLabel.setBounds(47, 179, 250, 177);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AcademicHead.class.getResource("/images/b (2).jpg")));
		lblNewLabel_1.setBounds(826, 198, 232, 160);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(AcademicHead.class.getResource("/images/d.jpg")));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(34, 482, 267, 169);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(AcademicHead.class.getResource("/images/t.jpg")));
		lblNewLabel_5.setBounds(826, 482, 245, 169);
		contentPane.add(lblNewLabel_5);
		
		 btnaddproject = new JButton("Add Project");
		 btnaddproject.addActionListener(this);
		btnaddproject.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnaddproject.setBounds(311, 542, 167, 42);
		contentPane.add(btnaddproject);
		
		 btnview = new JButton("View Student Report");
		 btnview.addActionListener(this);
		btnview.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnview.setBounds(461, 395, 308, 54);
		contentPane.add(btnview);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AcademicHead.class.getResource("/images/h.jpg")));
		lblNewLabel_3.setBounds(0, 0, 1362, 705);
		contentPane.add(lblNewLabel_3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String caption=e.getActionCommand();
		if(caption.equals("Create Courses"))
		{
			CreateCourses cc=new CreateCourses();
			cc.setVisible(true);
		}
		if(caption.equals("Create Project Category"))
		{
			ProjectCategory pc=new ProjectCategory();
			pc.setVisible(true);
		}
		if(caption.equals("Allot Project"))
		{
			AllotProject ap=new AllotProject();
			ap.setVisible(true);
		}
		if(caption.equals("Add Project"))
		{
			Project p=new Project();
			p.setVisible(true);
		}
		if(caption.equals("View Report"))
		{
			ViewReport vr=new ViewReport();
			vr.setVisible(true);
		}
		if(caption.equals("View Student Report"))
		{
			ViewReport as=new ViewReport();
			as.setVisible(true);
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

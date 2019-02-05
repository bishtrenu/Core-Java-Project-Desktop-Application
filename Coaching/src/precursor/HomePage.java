package precursor;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import gui.CreateAccount;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
public class HomePage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnfeedback, btnHomePage,btnsignin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/images/pppp.jpg")));
		setTitle("HOME PAGE");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		CreateGUI();
	}
	public void CreateGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnHomePage = new JButton("HOME PAGE");
		btnHomePage.addActionListener(this);
		
		btnHomePage.setBounds(0, 0, 420, 35);
		contentPane.add(btnHomePage);
		
		btnsignin = new JButton("SIGN IN");
		btnsignin.addActionListener(this);
		btnsignin.setBounds(418, 0, 420, 35);
		contentPane.add(btnsignin);
		
		 btnfeedback = new JButton("FEEDBACK");
		 btnfeedback.addActionListener(this);
		btnfeedback.setBounds(837, 0, 525, 35);
		contentPane.add(btnfeedback);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/images/precursor.png")));
		lblNewLabel.setBounds(466, 46, 451, 155);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HomePage.class.getResource("/images/3ppeRJdMUOug2LqiE7WY1uJhHI0j-PSC97_Gabwi-RmXspO3iATcRd--YFHJtF6_QAzuDIrkKzEdzB4jtC87BThSWCmdimJ7HVoTUSJ7iV_CM2aGS5umdrAFAvslXXukgZwR5do=w350-h350-nc.jpg")));
		lblNewLabel_1.setBounds(10, 214, 401, 402);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Job Oriented Cources for B-Tech CS/IT & EC/EN");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 191, 255));
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(558, 232, 543, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HomePage.class.getResource("/images/android-training-lucknow.png")));
		lblNewLabel_3.setBounds(536, 305, 156, 99);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Android");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(577, 426, 89, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(HomePage.class.getResource("/images/asp-net-training-lucknow.png")));
		lblNewLabel_5.setBounds(837, 304, 124, 100);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Asp.Net");
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(857, 426, 89, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(HomePage.class.getResource("/images/java-training-lucknow.png")));
		lblNewLabel_7.setBounds(1143, 305, 108, 99);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Java/J2EE");
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(1143, 426, 114, 26);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(HomePage.class.getResource("/images/php-training-lucknow.png")));
		lblNewLabel_9.setBounds(558, 512, 108, 104);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblPhp = new JLabel("PHP");
		lblPhp.setOpaque(true);
		lblPhp.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblPhp.setBounds(577, 640, 63, 26);
		contentPane.add(lblPhp);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(HomePage.class.getResource("/images/c-coaching-lucknow.png")));
		lblNewLabel_10.setBounds(837, 499, 124, 120);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("C-Language");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(823, 637, 130, 33);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(HomePage.class.getResource("/images/cpp-coaching-lucknow.png")));
		lblNewLabel_12.setBounds(1157, 512, 114, 104);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblC = new JLabel("C++");
		lblC.setOpaque(true);
		lblC.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblC.setBounds(1157, 640, 94, 28);
		contentPane.add(lblC);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(HomePage.class.getResource("/images/f.jpg")));
		lblNewLabel_13.setBounds(-13, -253, 1449, 971);
		contentPane.add(lblNewLabel_13);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
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
	}
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Home extends JFrame implements MouseListener {
	ImageIcon icon;
	JLabel centerJLabel,loginJLabel,registerJLabel,adminloginJLabel,exitJLabel;
	JPanel manuPanel;
	JLabel groupDetailjLabel;
	public Home() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		icon=new ImageIcon(getClass().getResource("/picture/title_icon.png"));	//set image title
		this.setIconImage(icon.getImage());
	
		//=============================================================set image JFrame
		icon=new ImageIcon(getClass().getResource("/picture/home_image.jpg"));
		centerJLabel=new JLabel(icon);
		centerJLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		centerJLabel.setLayout(null);
		this.add(centerJLabel);

		//===============================================================manu panel
		manuPanel=new JPanel();
		manuPanel.setBounds(0,0,750,40);
		manuPanel.setBackground(Color.decode("#2E67F8"));
		manuPanel.setLayout(null);
		centerJLabel.add(manuPanel);

		// ======================================================group details label
		groupDetailjLabel = new JLabel("Details....");
		groupDetailjLabel.setFocusable(false);
		groupDetailjLabel.setBounds(10, 40, 100, 35);
		groupDetailjLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		groupDetailjLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		groupDetailjLabel.setForeground(Color.white);
		centerJLabel.add(groupDetailjLabel);

		//=============================================================login label
		loginJLabel=new JLabel("Login");
		loginJLabel.setBounds(250,0,90,40);
		loginJLabel.setForeground(Color.white);
		loginJLabel.setBackground(Color.decode("#2E67F8"));
		loginJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		loginJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/user_login.png")));
		loginJLabel.setOpaque(true);
		manuPanel.add(loginJLabel);
		
		//=============================================================register label
		registerJLabel=new JLabel("Register");
		registerJLabel.setBounds(352,0,110,40);
		registerJLabel.setForeground(Color.white);
		registerJLabel.setBackground(Color.decode("#2E67F8"));
		registerJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		registerJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		registerJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/home_register.png")));
		registerJLabel.setOpaque(true);
		manuPanel.add(registerJLabel);

		//=============================================================admin login
		adminloginJLabel=new JLabel("Admin Login");
		adminloginJLabel.setBounds(477,0,150,40);
		adminloginJLabel.setForeground(Color.white);
		adminloginJLabel.setBackground(Color.decode("#2E67F8"));
		adminloginJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adminloginJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		adminloginJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/admin_login.png")));
		adminloginJLabel.setOpaque(true);
		manuPanel.add(adminloginJLabel);
		
		//=============================================================exit label
		exitJLabel=new JLabel("Exit");
		exitJLabel.setBounds(640,0,80,40);
		exitJLabel.setForeground(Color.white);
		exitJLabel.setBackground(Color.decode("#2E67F8"));
		exitJLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		exitJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/home_exit.png")));
		exitJLabel.setOpaque(true);
		manuPanel.add(exitJLabel);

		loginJLabel.addMouseListener(this);
		registerJLabel.addMouseListener(this);
		adminloginJLabel.addMouseListener(this);
		exitJLabel.addMouseListener(this);
		groupDetailjLabel.addMouseListener(this);
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==loginJLabel){
			dispose();
			userLogin user=new userLogin();
			user.setVisible(true);
		}
		if(e.getSource()==registerJLabel){
			dispose();
			register r=new register();
			r.setVisible(true);
		}
		if(e.getSource()==adminloginJLabel){
			dispose();
			adminLogin user=new adminLogin();
			user.setVisible(true);
			JOptionPane.showMessageDialog(null,"Deafult username 'admin' & password 'admin'");
		}
		if(e.getSource()==exitJLabel){
			int a=JOptionPane.showConfirmDialog(null,"Do you want to exit now?\n","Message",JOptionPane.YES_NO_OPTION);
			if (a==0) {
				System.exit(0);
			}
		}
		// ===================================================group details add MouseListener
		if(e.getSource()==groupDetailjLabel){
			dispose();
			Details details = new Details();
			details.setVisible(true);
		}
		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setBackground(Color.RED);
	}
	public void mouseExited(MouseEvent e) {
		e.getComponent().setBackground(null);	
	} 
	
	public static void main(String[] args) {
		Home home=new Home();
		home.setVisible(true);
	}
}

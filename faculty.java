import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class faculty extends JFrame{
	JLabel titleJLabel,nameJLabel,contactJLabel,jLabel,picJLabel,backLabel;
	ImageIcon icon;
	public faculty() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,350);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setUndecorated(true);
		this.getContentPane().setBackground(Color.decode("#2E67F8"));
		
		//=============================================================title label
		titleJLabel=new JLabel("FACULTY--");
		titleJLabel.setBounds(30,10,150,50);
		titleJLabel.setFont(new Font("Segoe UI",Font.ITALIC,30));
		titleJLabel.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.white));
		titleJLabel.setForeground(Color.white);
		this.add(titleJLabel);
		//=============================================================name label
		nameJLabel=new JLabel("Name : Zahiduddin Ahmed");
		nameJLabel.setBounds(20,100,350,30);
		nameJLabel.setForeground(Color.white);
		nameJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		this.add(nameJLabel);
		
		//=============================================================JLabel
		jLabel=new JLabel("Lecturer : CS");
		jLabel.setBounds(20,140,200,30);
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		this.add(jLabel);
		
		//=============================================================contact label
		contactJLabel=new JLabel("Email : zahid@aiub.edu");
		contactJLabel.setBounds(20,180,300,30);
		contactJLabel.setForeground(Color.white);
		contactJLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		this.add(contactJLabel);
		
		//=============================================================picture label
		icon=new ImageIcon(getClass().getResource("/picture/faculty.jpg"));
		picJLabel=new JLabel(icon);
		picJLabel.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
		picJLabel.setBounds(290,95,icon.getIconWidth(),icon.getIconHeight());
		this.add(picJLabel);
		
		
		//=============================================================back label
		backLabel=new JLabel("Back");
		backLabel.setForeground(Color.white);
		backLabel.setBounds(160,270,150,40);
		backLabel.setFont(new Font("Arial",Font.ITALIC,20));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		this.add(backLabel);
		
		//=============================================================backLabel MouseListener
		backLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			dispose();	
			Home h=new Home();
			h.setVisible(true);
			}
		});
		
	}

	public static void main(String[] args) {
		faculty f=new faculty();
		f.setVisible(true);
	}
	

}

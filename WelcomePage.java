import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class WelcomePage extends JFrame {
	JLabel centerJLabel, welcomeJLabel, libraryJLabel, groupDetailjLabel,percentLabel,lodingLabel;
	JTextField jTextField;
	ImageIcon icon;
	JButton exitButton, nextButton;
    JProgressBar jProgressBar;
	public WelcomePage() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setUndecorated(true);
		icon=new ImageIcon(getClass().getResource("/picture/title_icon.png"));	//set image title
		this.setIconImage(icon.getImage());

		// =============================================================set image JFrame
		icon = new ImageIcon(getClass().getResource("/picture/welcome_icon.gif"));
		centerJLabel = new JLabel(icon);
		centerJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		centerJLabel.setLayout(null);
		this.add(centerJLabel);
		// =============================================================welcome label
		welcomeJLabel = new JLabel("Welcome to the");
		welcomeJLabel.setBounds(10, 30, 500, 70);
		welcomeJLabel.setForeground(Color.white);
		welcomeJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 60));
		welcomeJLabel.setForeground(Color.black);
		centerJLabel.add(welcomeJLabel);
		// =============================================================library label
		libraryJLabel = new JLabel("LIBRARY");
		libraryJLabel.setBounds(10, 100, 350, 70);
		libraryJLabel.setForeground(Color.white);
		libraryJLabel.setFont(new Font("Segoe UI", Font.BOLD, 70));
		libraryJLabel.setForeground(Color.black);
		centerJLabel.add(libraryJLabel);

		jProgressBar = new JProgressBar();
		jProgressBar.setBounds(0,390,652,10);
		jProgressBar.setBackground(Color.white);
		jProgressBar.setForeground(Color.black);
		jProgressBar.setBorder(BorderFactory.createEmptyBorder());
		centerJLabel.add(jProgressBar);
		
		percentLabel = new JLabel();
		percentLabel.setBounds(310,350,40,30);
		percentLabel.setForeground(Color.black);
		percentLabel.setFont(new Font("Arial",Font.BOLD,20));
		centerJLabel.add(percentLabel); 

		lodingLabel = new JLabel("Loading Please Wait.....");
        lodingLabel.setBounds(5,368,200,20);
		lodingLabel.setForeground(Color.BLACK);
		lodingLabel.setFont(new Font("Arial",Font.ITALIC,15));
		centerJLabel.add(lodingLabel); 

		
       
	}
	public void progressBar() {
		int process = 0;
		try {
			
			while(process<=100){
				jProgressBar.setValue(process);

				try {
					Thread.sleep(100);
					percentLabel.setText(process+"%");

				} catch (Exception e) {
					System.out.println(e);
				}
				process++;
				if(process>=10 && process <=30){
					welcomeJLabel.setForeground(Color.decode("#4169E1"));
					libraryJLabel.setForeground(Color.decode("#4169E1"));
				}else if(process>=31 && process <=50){
					welcomeJLabel.setForeground(Color.decode("#006E33"));
					libraryJLabel.setForeground(Color.decode("#006E33"));
				}else if(process>=51 && process <=70){
					welcomeJLabel.setForeground(Color.decode("#43464B"));
					libraryJLabel.setForeground(Color.decode("#43464B"));
				}else if(process>=71 && process <=90){
					welcomeJLabel.setForeground(Color.decode("#E0A526"));
					libraryJLabel.setForeground(Color.decode("#E0A526"));
				}
				if(process>=40 && process <=85){
					lodingLabel.setText("Connecting....");
				}
				if(process>=86 && process <=98){
					lodingLabel.setText("Connecting Successful....");
				}
				
				if(process==100){
					dispose();
					Home h =new Home();
					h.setVisible(true);
				}
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.setVisible(true);
		welcomePage.progressBar();
	}

}

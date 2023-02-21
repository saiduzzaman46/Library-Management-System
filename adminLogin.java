import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class adminLogin extends JFrame implements ActionListener {
	ImageIcon icon;
	JPanel jPanel, singinPanel,loginPanel;
	JLabel loginLabel, iconJLabel, userNameLabel, passwordLabel, createLabel;
	JLabel userNameLabel2, passwordLabel2;
	JTextField userNameField, userNameField2;
	JButton backButton,backButton2 ,loginButton,loginButton2, exitButton, signUpButton;
	JPasswordField passwordField, passwordField2;

	public adminLogin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);

		jPanel = new JPanel();
		jPanel.setBackground(Color.white);
		jPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
		jPanel.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);

		// =============================================================set picture
		icon = new ImageIcon(getClass().getResource("/picture/admin_login.jpg"));
		// ======================================================set picture jLabel
		iconJLabel = new JLabel(icon);
		iconJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		iconJLabel.setLayout(null);
		jPanel.add(iconJLabel);

		// =============================================================login label
		loginLabel = new JLabel("Login");
		loginLabel.setBounds(400, 40, 200, 30);
		loginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		loginLabel.setForeground(Color.decode("#0827F5"));
		iconJLabel.add(loginLabel);

		
		//======================================================login panel
		loginPanel = new JPanel();
		loginPanel.setBounds(390,70,245,180);
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.white);
		iconJLabel.add(loginPanel); 

		// =============================================================user name label
		userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(10, 5, 100, 20);
		userNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		loginPanel.add(userNameLabel);
		// ==============================================user name text field
		userNameField = new JTextField();
		userNameField.setBounds(10, 30, 230, 30);
		userNameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		loginPanel.add(userNameField);
		
		// =============================================================password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 65, 100, 20);
		passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		loginPanel.add(passwordLabel);
		// ============================================user name tex field
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 90, 230, 30);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		loginPanel.add(passwordField);

		//  =============================================================login button
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 140, 230, 30);
		loginButton.setBackground(Color.decode("#2E67F8"));
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginPanel.add(loginButton);


		// =============================================================back button
		backButton = new JButton("<<Back");
		backButton.setBounds(410, 300, 100, 30);
		backButton.setBackground(Color.decode("#2E67F8"));
		backButton.setFocusable(false);
		backButton.setFont(new Font("Arial", Font.PLAIN, 15));
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(backButton);

		
		// =============================================================exit button
		exitButton = new JButton("Exit");
		exitButton.setBounds(520, 300, 100, 30);
		exitButton.setBackground(Color.decode("#2E67F8"));
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Arial", Font.PLAIN, 15));
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(exitButton);

		loginButton.addActionListener(this);
		backButton.addActionListener(this);
		//backButton2.addActionListener(this);
		exitButton.addActionListener(this);
		//singUpButton.addActionListener(this);
	}

	public boolean validateAdmin() {
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		// ================================================Login button listener
		
		if (e.getSource() == loginButton) {

			loginLabel.setText("Login");
			String file = ".\\Data\\admin_data.txt";

			String userName = userNameField.getText();
			String password = passwordField.getText();
				try {
					String name = "User Name : " + userName;
					String pass = "Password : " + password;

					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					int totalLines = 0;

					while (bufferedReader.readLine() != null)
						totalLines++;
					bufferedReader.close();

					for (int i = 0; i < totalLines; i++) {
						String line2 = Files.readAllLines(Paths.get(file)).get((i));
						if (line2.equals(name)) {
							String line3 = Files.readAllLines(Paths.get(file)).get((i + 1));
							if (line3.equals(pass)) {
								dispose();
								HomePage h = new HomePage();
								h.adminLabel.setText("Welcome "+userName );
								h.setVisible(true);
								break;
							}else{
								JOptionPane.showMessageDialog(null, "Invalid Password");
								break;
							}
						}else{
							JOptionPane.showMessageDialog(null, "Invalid User Name "); 
							break;
						}
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid User Name And Password");
				}
		}
		// ===============================================back button Listener
		if (e.getSource() == backButton) {
			dispose();
			Home home = new Home();
			home.setVisible(true);
		}
		// ===============================================exit button listener
		if (e.getSource() == exitButton) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit now?\n", "Message",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		adminLogin a = new adminLogin();
		a.setVisible(true);
	}

}

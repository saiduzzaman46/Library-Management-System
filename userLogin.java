import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class userLogin extends JFrame implements ActionListener {
	ImageIcon icon;
	JPanel jPanel;
	JLabel loginLabel, iconJLabel, userNameLabel, passwordLabel, createLabel;
	JTextField userNameField;
	JButton backButton, loginButton, exitButton;
	JPasswordField passwordField;

	public userLogin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 450);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);

		jPanel = new JPanel();
		jPanel.setBackground(Color.white);
		jPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.green));
		jPanel.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);

		// =============================================================set picture
		icon = new ImageIcon(getClass().getResource("/picture/student_login.png"));
		// =============================================================set picture
		// jLabel
		iconJLabel = new JLabel(icon);
		iconJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		iconJLabel.setLayout(null);
		jPanel.add(iconJLabel);

		// =============================================================welcome label
		loginLabel = new JLabel("Welcome");
		loginLabel.setBounds(520, 30, 90, 30);
		loginLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#0827F5")));
		loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		loginLabel.setForeground(Color.decode("#0827F5"));
		iconJLabel.add(loginLabel);

		// =============================================================login label
		loginLabel = new JLabel("Login To Your Account");
		loginLabel.setBounds(490, 100, 150, 20);
		loginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		loginLabel.setForeground(Color.decode("#0827F5"));
		iconJLabel.add(loginLabel);

		// =============================================================user name label
		userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(450, 130, 100, 20);
		userNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		iconJLabel.add(userNameLabel);
		// =============================================================user name text
		// field
		userNameField = new JTextField();
		userNameField.setBounds(450, 155, 230, 30);
		userNameField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		iconJLabel.add(userNameField);

		// =============================================================password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(450, 190, 100, 20);
		passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		iconJLabel.add(passwordLabel);
		// =============================================================user name text
		// field
		passwordField = new JPasswordField();
		passwordField.setBounds(450, 215, 230, 30);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		iconJLabel.add(passwordField);

		// =============================================================login button
		loginButton = new JButton("Login");
		loginButton.setBounds(450, 265, 230, 30);
		loginButton.setBackground(Color.decode("#2E67F8"));
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(loginButton);

		// ===============================================create a new account label
		createLabel = new JLabel("Create Your New Account?");
		createLabel.setBounds(483, 310, 170, 20);
		createLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		createLabel.setForeground(Color.decode("#0827F5"));
		createLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(createLabel);
		// =============================================================createLabel
		// MouseListener
		createLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				register r = new register();
				r.setVisible(true);
			}
		});

		// =============================================================back button
		backButton = new JButton("<<Back");
		backButton.setBounds(0, 0, 100, 30);
		backButton.setBackground(Color.decode("#2E67F8"));
		backButton.setFocusable(false);
		backButton.setFont(new Font("Arial", Font.PLAIN, 15));
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(backButton);
		// =============================================================exit button
		exitButton = new JButton("Exit");
		exitButton.setBounds(640, 0, 100, 30);
		exitButton.setBackground(Color.decode("#2E67F8"));
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Arial", Font.PLAIN, 15));
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(exitButton);

		loginButton.addActionListener(this);
		backButton.addActionListener(this);
		exitButton.addActionListener(this);
	}
// 
	public boolean validateAdmin() {
		if (userNameField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter UserName.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (passwordField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Your Password.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;

	}
  //method set user data to userDashboard profile 
  //call userDashboard class crate a class variable
	public void profile(String name, userDashboard u) {
		String file = ".\\Data\\register_data.txt";
		// =====================================================add data student details
		try {
			BufferedReader reader2 = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader2.readLine() != null)
				totalLines++;
			reader2.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file)).get(i);
				String a = line.substring(0, 10);
				if (a.equals("First Name")) {
					String b = Files.readAllLines(Paths.get(file)).get(i + 2);
					if (b.equals(name)) {
						u.firstNameLabel.setText(Files.readAllLines(Paths.get(file)).get(i).substring(13));
						u.lastNameLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 1).substring(12));
						u.userNameLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 2).substring(12));
						u.passwordLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 3).substring(11));
						u.emailLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 4).substring(8));
						u.phoneLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 5).substring(10));
						u.userLabel.setText("Welcome, " +Files.readAllLines(Paths.get(file)).get(i).substring(13));
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// =============================================================login button
		if (e.getSource() == loginButton) {
			String file = ".\\Data\\register_data.txt";
			String uname = userNameField.getText();
			String pass = passwordField.getText();
			if (validateAdmin() == true) {
				try {
					String username = "User Name : " + uname;
					String password = "Password : " + pass;

					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					int totalLines = 0;

					while (bufferedReader.readLine() != null)
						totalLines++;
					bufferedReader.close();

					for (int i = 0; i < totalLines; i++) {
						String line2 = Files.readAllLines(Paths.get(file)).get((i + 2));
						if (line2.equals(username)) {
							String line3 = Files.readAllLines(Paths.get(file)).get((i + 3));
							if (line3.equals(password)) {
								dispose();
								userDashboard user = new userDashboard();
								user.setVisible(true);
								profile(username, user);
								break;
							}
						}
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid User Name And Password");
				}
			}
		}

		// =============================================================back button
		// Listener
		if (e.getSource() == backButton) {
			dispose();
			Home home = new Home();
			home.setVisible(true);
		}
		// =============================================================exit button
		// listener
		if (e.getSource() == exitButton) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit now?\n", "Message",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		}

	}

	public static void main(String[] args) {
		userLogin user = new userLogin();
		user.setVisible(true);
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class register extends JFrame implements ActionListener, MouseListener {
	ImageIcon icon;
	JPanel jPanel;
	JLabel loginLabel, iconJLabel, jLabel, captchaLabel, backLabel, closeLabel;
	JTextField userNameField, nameField, nameField2, emailField, contactField, captchaField;
	JButton backButton, signupButton, exitButton, captchaButton, signinButton;
	JPasswordField passwordField;
	int x, y, result = 0;
	Random random;

	public register() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 470);
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
		loginLabel = new JLabel("Create New Account Here");
		loginLabel.setBounds(470, 15, 180, 30);
		loginLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		loginLabel.setForeground(Color.decode("#0827F5"));
		iconJLabel.add(loginLabel);

		// =============================================================name label
		jLabel = new JLabel("First Name");
		jLabel.setBounds(440, 80, 100, 17);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);

		jLabel = new JLabel("Last Name");
		jLabel.setBounds(567, 80, 100, 17);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);

		// =============================================================name text field
		nameField = new JTextField();
		nameField.setBounds(440, 97, 115, 25);
		nameField.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(nameField);

		nameField2 = new JTextField();
		nameField2.setBounds(567, 97, 115, 25);
		nameField2.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(nameField2);

		// =============================================================user name label
		jLabel = new JLabel("Username");
		jLabel.setBounds(440, 127, 100, 15);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);
		// =============================================================user name text
		// field
		userNameField = new JTextField();
		userNameField.setBounds(440, 144, 240, 25);
		userNameField.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(userNameField);

		// =============================================================password label
		jLabel = new JLabel("Password");
		jLabel.setBounds(440, 176, 100, 15);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);
		// =============================================================password text
		// field
		passwordField = new JPasswordField();
		passwordField.setBounds(440, 193, 240, 25);
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("Enter upper and lower case alphabet and number");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		iconJLabel.add(passwordField);

		// =============================================================email label
		jLabel = new JLabel("Email");
		jLabel.setBounds(440, 225, 100, 15);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);
		// =============================================================email text field
		emailField = new JTextField();
		emailField.setBounds(440, 242, 240, 25);
		emailField.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(emailField);

		// =============================================================contact label
		jLabel = new JLabel("Contact");
		jLabel.setBounds(440, 274, 100, 15);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);
		// =============================================================contact text
		// field
		contactField = new JTextField();
		contactField.setBounds(440, 291, 240, 25);
		contactField.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(contactField);

		// =============================================================captcha title
		// label
		jLabel = new JLabel("Captcha");
		jLabel.setBounds(440, 322, 100, 15);
		jLabel.setFont(new Font("Arial", Font.ITALIC, 13));
		iconJLabel.add(jLabel);

		// =============================================================random number
		// for captcha
		random = new Random();
		x = random.nextInt(15);
		y = random.nextInt(15);

		// =============================================================captcha label
		captchaLabel = new JLabel("  " + x + " + " + y + " ");
		captchaLabel.setBounds(440, 342, 70, 25);
		captchaLabel.setOpaque(true);
		captchaLabel.setBackground(Color.decode("#FFD3D3"));
		captchaLabel.setFont(new Font("Arial", Font.BOLD, 15));
		iconJLabel.add(captchaLabel);

		// =============================================================captcha text
		// field
		captchaField = new JTextField();
		captchaField.setBounds(520, 342, 110, 25);
		captchaField.setFont(new Font("Arial", Font.PLAIN, 13));
		iconJLabel.add(captchaField);

		// =============================================================captcha button
		captchaButton = new JButton(new ImageIcon(getClass().getResource("/picture/captcha.png")));
		captchaButton.setBounds(635, 340, 50, 28);
		captchaButton.setBorder(BorderFactory.createEmptyBorder());
		captchaButton.setBackground(Color.white);
		captchaButton.setFocusable(false);
		iconJLabel.add(captchaButton);

		// =============================================================sing up button
		signupButton = new JButton("Sign Up");
		signupButton.setBounds(440, 381, 110, 30);
		signupButton.setBackground(Color.decode("#2E67F8"));
		signupButton.setFocusable(false);
		signupButton.setFont(new Font("Arial", Font.PLAIN, 15));
		signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconJLabel.add(signupButton);

		// =============================================================sing in button
		signinButton = new JButton("Log In");
		signinButton.setBounds(560, 381, 110, 30);
		signinButton.setBackground(Color.decode("#2E67F8"));
		signinButton.setFocusable(false);
		signinButton.setFont(new Font("Arial", Font.PLAIN, 15));
		signinButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signinButton.setOpaque(true);
		iconJLabel.add(signinButton);

		// =============================================================back label
		backLabel = new JLabel("Back");
		backLabel.setForeground(Color.white);
		backLabel.setBackground(Color.decode("#2E67F8"));
		backLabel.setBounds(0, -2, 100, 30);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backLabel.setOpaque(true);
		iconJLabel.add(backLabel);

		// =============================================================close label
		closeLabel = new JLabel("Exit");
		closeLabel.setBounds(690, -2, 50, 30);
		closeLabel.setFont(new Font("Arial", Font.BOLD, 15));
		closeLabel.setForeground(Color.decode("#2E67F8"));
		closeLabel.setBackground(Color.white);
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeLabel.setOpaque(true);
		iconJLabel.add(closeLabel);

		backLabel.addMouseListener(this);
		closeLabel.addMouseListener(this);
		captchaButton.addActionListener(this);
		signupButton.addActionListener(this);
		signinButton.addActionListener(this);
	}

	public boolean validateRegister() {
		String name = nameField.getText();
		String name2 = nameField2.getText();
		String usrname = userNameField.getText();
		String password = passwordField.getText();
		String email = emailField.getText();
		String contact = contactField.getText();
		String cap = captchaField.getText();
		// (?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])

		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter first name.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (name2.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter last name.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (usrname.equals("") ) {
			JOptionPane.showMessageDialog(null, "please enter user name .", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter your password.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (email.equals("") || !email.matches("^.+@.+\\..+$")) {
			JOptionPane.showMessageDialog(null, "please enter email id.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (contact.equals("") || !contact.matches("-?\\d+(\\.\\d+)?")) {
			JOptionPane.showMessageDialog(null, "please enter contact number.", "Messages",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (cap.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter captcha.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;

	}

	public void actionPerformed(ActionEvent e) {
		// =============================================================sing up button
		// ActionListener
		String name = nameField.getText();
		String name2 = nameField2.getText();
		String usrname = userNameField.getText();
		String password = passwordField.getText();
		String email = emailField.getText();
		String contact = contactField.getText();
		String cap = captchaField.getText();
		if (e.getSource() == signupButton) {
			if (validateRegister() == true) {
				result = Integer.parseInt(captchaField.getText());
				if (result == (x + y)) {
					try {
						File file = new File(".\\Data\\register_data.txt");
						if (!file.exists()) {
							file.createNewFile();
						}
						FileWriter fileWriter = new FileWriter(file, true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						PrintWriter printWriter = new PrintWriter(bufferedWriter);

						LocalDateTime localDateTime = LocalDateTime.now();
						DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
						String timeAndDate = localDateTime.format(dateFormatter);

						printWriter.println("First Name : "+name);
						printWriter.println("Last Name : "+name2);
						printWriter.println("User Name : " + usrname);
						printWriter.println("Password : " + password);
						printWriter.println("Email : " + email);
						printWriter.println("Contact : " + contact);
						printWriter.println("Time and Date : " + timeAndDate);
						printWriter.println("===========================================");
						printWriter.close();

					} catch (Exception ex) {
						System.out.println(ex);
					}
					JOptionPane.showMessageDialog(null, "Sing Up Success");
					dispose();
					register r = new register();
					r.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Wrong captcha.", "Messages", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		// =============================================================sing in button
		// ActionListener
		if (e.getSource() == signinButton) {
			dispose();
			userLogin login = new userLogin();
			login.setVisible(true);
		}

		// =============================================================captcha button
		// ActionListener
		if (e.getSource() == captchaButton) {
			random = new Random();
			x = random.nextInt(15);
			y = random.nextInt(15);
			captchaLabel.setText("  " + x + " + " + y + " ");
		}

	}

	public static void main(String[] args) {
		register r = new register();
		r.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == closeLabel) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit now?\n", "Message",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		}
		if (e.getSource() == backLabel) {
			dispose();
			Home home = new Home();
			home.setVisible(true);
		}

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setBackground(Color.red);
	}

	public void mouseExited(MouseEvent e) {
		closeLabel.setBackground(Color.decode("#FFFFFF"));
		backLabel.setBackground(Color.decode("#2E67F8"));
	}

}

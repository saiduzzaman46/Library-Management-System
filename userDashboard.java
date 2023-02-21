import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class userDashboard extends JFrame implements MouseListener {
	JPanel titlePanel, menuPanel, bookPanel, profiPanel;
	JLabel titleJLabel, userLabel, bookTitle, homeIconLabel,noteLabel;
	JLabel viewBookLabel, profilLabel, menuLabel, logoutLabel;
	JLabel jLabel, firstNameLabel, lastNameLabel, emailLabel, userNameLabel, passwordLabel, phoneLabel;
	ImageIcon icon;
	JTextField field;

	JTable table;
	DefaultTableModel model;
	JScrollPane pane;

	String[] column = new String[] { "Book Id", "Name", "Author", "Quantity" };
	String[] row = new String[4];
	int rowCount, columnCount;

	public userDashboard() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		icon=new ImageIcon(getClass().getResource("/picture/title_icon.png"));	//set image title
		this.setIconImage(icon.getImage());
		// =============================================================title panel
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 840, 50);
		titlePanel.setBackground(Color.decode("#2E67F8"));
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 20, Color.decode("#2E67F8")));
		this.add(titlePanel);

		// ===============================================set title with title panel
		titleJLabel = new JLabel("Manu");
		titleJLabel.setSize(100, 30);
		titleJLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleJLabel.setForeground(Color.white);
		titleJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/menu.png")));
		titleJLabel.setIconTextGap(10);
		titlePanel.add(titleJLabel, BorderLayout.WEST);

		// =======================================================user label
		userLabel = new JLabel("Welcome");
		userLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		userLabel.setIcon(new ImageIcon(getClass().getResource("/picture/user.png")));
		userLabel.setForeground(Color.WHITE);
		userLabel.setIconTextGap(10);
		titlePanel.add(userLabel, BorderLayout.EAST);

		icon = new ImageIcon(getClass().getResource("/picture/userDashboard.png"));
		homeIconLabel = new JLabel(icon);
		homeIconLabel.setBounds(0, 50, 850, 520);
		homeIconLabel.setLayout(null);
		this.add(homeIconLabel);

		// menu panel
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 170, 520);
		menuPanel.setBackground(new Color(51, 51, 51));
		menuPanel.setVisible(false);
		menuPanel.setLayout(null);
		homeIconLabel.add(menuPanel);

		menuLabel = new JLabel("Menu");
		menuLabel.setBounds(5, 30, 100, 30);
		menuLabel.setFont(new Font("Arial", Font.BOLD, 25));
		menuLabel.setForeground(Color.white);
		menuPanel.add(menuLabel);

		viewBookLabel = new JLabel("Book");
		viewBookLabel.setBounds(00, 75, 170, 40);
		viewBookLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		viewBookLabel.setForeground(Color.white);
		viewBookLabel.setIcon(new ImageIcon(getClass().getResource("/picture/mange_book2.png")));
		viewBookLabel.setIconTextGap(5);
		viewBookLabel.setBackground(null);
		viewBookLabel.setOpaque(true);
		menuPanel.add(viewBookLabel);

		profilLabel = new JLabel("Profile");
		profilLabel.setBounds(00, 130, 170, 40);
		profilLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		profilLabel.setForeground(Color.white);
		profilLabel.setIcon(new ImageIcon(getClass().getResource("/picture/user.png")));
		profilLabel.setIconTextGap(5);
		profilLabel.setBackground(null);
		profilLabel.setOpaque(true);
		menuPanel.add(profilLabel);

		logoutLabel = new JLabel("Logout");
		logoutLabel.setBounds(00, 180, 180, 40);
		logoutLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		logoutLabel.setForeground(Color.white);
		logoutLabel.setIcon(new ImageIcon(getClass().getResource("/picture/logout.png")));
		logoutLabel.setIconTextGap(5);
		logoutLabel.setBackground(null);
		logoutLabel.setOpaque(true);
		menuPanel.add(logoutLabel);

		bookDetaisTable();
		viewProfile();

		titleJLabel.addMouseListener(this);
		viewBookLabel.addMouseListener(this);
		profilLabel.addMouseListener(this);
		logoutLabel.addMouseListener(this);

	}

	public void bookDetaisTable() {
		bookPanel = new JPanel();
		bookPanel.setBounds(0, 0, 850, 520);
		bookPanel.setBackground(Color.darkGray);
		bookPanel.setLayout(null);
		bookPanel.setVisible(false);
		homeIconLabel.add(bookPanel, BorderLayout.CENTER);

		// =============================================================title Label
		bookTitle = new JLabel("Book Details");
		bookTitle.setBounds(400, 10, 210, 50);
		bookTitle.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		bookTitle.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		bookTitle.setForeground(Color.white);
		bookTitle.setBorder(BorderFactory.createEmptyBorder());
		bookTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		bookPanel.add(bookTitle);

		// =============================================================set table east
		// Panel

		model = new DefaultTableModel(rowCount, columnCount) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setFont(new Font("Segoe UI", Font.BOLD, 10));
		table.setSelectionBackground(Color.cyan);
		table.setRowHeight(30);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.decode("#2E67F8"));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		pane = new JScrollPane(table);
		pane.setBounds(200, 140, 600, 300);
		bookPanel.add(pane);

		//note label
		noteLabel = new JLabel("Note : Issue A Book Please Contact Library");
		noteLabel.setBounds(200,440,300,30);
		noteLabel.setForeground(Color.white);
		bookPanel.add(noteLabel);

		String file1 = ".\\Data\\book_data.txt";
		// ==================================================================add data
		// book table
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file1));
			int totalLines = 0;

			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file1)).get(i);
				String a = line.substring(0, 7);
				if (a.equals("Book ID")) {
					row[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(10);
					row[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(12);
					row[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14);
					row[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(16);
					model.addRow(row);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		jLabel = new JLabel("Scarch : ");
		jLabel.setBounds(200, 85, 70, 30);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		jLabel.setForeground(Color.white);
		bookPanel.add(jLabel);

		// scarch field
		field = new JTextField();
		field.setBounds(270, 87, 200, 30);
		field.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		bookPanel.add(field);

		TableRowSorter sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);


		field.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				model.fireTableDataChanged();
			}

			public void removeUpdate(DocumentEvent e) {
				model.fireTableDataChanged();
			}

			public void changedUpdate(DocumentEvent e) {
				model.fireTableDataChanged();
			}
		});

		// scarch table data
		sorter.setRowFilter(new RowFilter() {
			public boolean include(Entry entry) {
				String name = entry.getValue(1).toString().toUpperCase().toLowerCase();
				String scarch = field.getText();
				return name.startsWith(scarch);
			}

		});

	}

	public void viewProfile() {
		profiPanel = new JPanel();
		profiPanel.setBounds(0, 0, 850, 520);
		profiPanel.setBackground(Color.darkGray);
		profiPanel.setLayout(null);
		profiPanel.setVisible(false);
		homeIconLabel.add(profiPanel);

		// informaton label
		jLabel = new JLabel("INFORMATION");
		jLabel.setBounds(200, 20, 180, 30);
		jLabel.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		jLabel.setForeground(Color.GREEN);
		jLabel.setBorder(BorderFactory.createEmptyBorder());
		jLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.green));
		profiPanel.add(jLabel);

		// acount information label
		jLabel = new JLabel("Account Information");
		jLabel.setBounds(230, 60, 180, 30);
		jLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		jLabel.setForeground(Color.white);
		jLabel.setBorder(BorderFactory.createEmptyBorder());
		jLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		profiPanel.add(jLabel);

		// first name label
		jLabel = new JLabel("First Name : ");
		jLabel.setBounds(230, 110, 100, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		firstNameLabel = new JLabel();
		firstNameLabel.setBounds(330, 112, 160, 30);
		firstNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		firstNameLabel.setForeground(Color.white);
		profiPanel.add(firstNameLabel);

		// last name label
		jLabel = new JLabel("Last Name : ");
		jLabel.setBounds(510, 110, 100, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		lastNameLabel = new JLabel();
		lastNameLabel.setBounds(610, 112, 160, 30);
		lastNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lastNameLabel.setForeground(Color.white);
		profiPanel.add(lastNameLabel);

		// email label
		jLabel = new JLabel("Email : ");
		jLabel.setBounds(230, 160, 60, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		emailLabel = new JLabel();
		emailLabel.setBounds(290, 162, 250, 30);
		emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		emailLabel.setForeground(Color.white);
		profiPanel.add(emailLabel);

		// phone label
		jLabel = new JLabel("Phone : ");
		jLabel.setBounds(230, 215, 70, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		phoneLabel = new JLabel();
		phoneLabel.setBounds(300, 217, 250, 30);
		phoneLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		phoneLabel.setForeground(Color.white);
		profiPanel.add(phoneLabel);

		// password title label
		jLabel = new JLabel("Password ");
		jLabel.setBounds(230, 275, 90, 30);
		jLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		jLabel.setForeground(Color.white);
		jLabel.setBorder(BorderFactory.createEmptyBorder());
		jLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		profiPanel.add(jLabel);

		// user name label
		jLabel = new JLabel("User Name : ");
		jLabel.setBounds(230, 325, 100, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		userNameLabel = new JLabel();
		userNameLabel.setBounds(330, 327, 250, 30);
		userNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		userNameLabel.setForeground(Color.white);
		profiPanel.add(userNameLabel);

		// password label
		jLabel = new JLabel("Password : ");
		jLabel.setBounds(230, 375, 100, 30);
		jLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		jLabel.setForeground(Color.white);
		profiPanel.add(jLabel);

		passwordLabel = new JLabel();
		passwordLabel.setBounds(320, 377, 250, 30);
		passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		passwordLabel.setForeground(Color.white);
		profiPanel.add(passwordLabel);

	}

	public static void main(String[] args) {
		userDashboard user = new userDashboard();
		user.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		// viewbook button
		if (e.getSource() == viewBookLabel) {
			bookPanel.setVisible(true);
			profiPanel.setVisible(false);
		}
		// profile button
		if (e.getSource() == profilLabel) {
			profiPanel.setVisible(true);
			bookPanel.setVisible(false);
		}
		// logout button
		if (e.getSource() == logoutLabel) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to logout now?", "Logout",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				dispose();
				userLogin u = new userLogin();
				u.setVisible(true);
			}
		}

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == titleJLabel) {
			menuPanel.setVisible(true);
		}
		if (e.getSource() == viewBookLabel) {
			viewBookLabel.setBackground(Color.red);
		}
		if (e.getSource() == profilLabel) {
			profilLabel.setBackground(Color.red);
		}
		if (e.getSource() == logoutLabel) {
			logoutLabel.setBackground(Color.red);
		}

	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == viewBookLabel) {
			viewBookLabel.setBackground(null);
		}
		if (e.getSource() == profilLabel) {
			profilLabel.setBackground(null);
		}
		if (e.getSource() == logoutLabel) {
			logoutLabel.setBackground(null);
		}
	}
}
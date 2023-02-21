import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class HomePage extends JFrame implements ActionListener {
	Container container;
	JLabel titleJLabel, adminLabel, bookTableTitle, studentTableTitle, iconLabel;
	JPanel titleJPanel, menuPanel, adminPanel, centerPanel, iconPanel;
	JButton[] jButtons;
	JTable bookDatlisTable, studentDetailsTable;
	DefaultTableModel homeDefaultTableModel, homeDefaultTableModel2;
	JScrollPane homeTableScrollPane;
	//adminLogin adminName;
	ImageIcon icon;

	public String[] mangeBookcolumn = new String[] { "Book Id", "Name", "Author", "Quantity", "Date and Time" };
	public String[] manageBookrow = new String[5];

	public String[] manageStudentcolumn = new String[] { "Student Id", "Name", "Course", "Branch", "Date and Time" };
	public String[] manageStudentrow = new String[5];
	int rowCount, columnCount;

	public HomePage() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 650);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		icon=new ImageIcon(getClass().getResource("/picture/title_icon.png"));	//set image title
		this.setIconImage(icon.getImage());
       
      
		TitlePanel();
		MenuPanel();
		HomeBookTable();

		jButtons[0].addActionListener(this);
		jButtons[1].addActionListener(this);
		jButtons[2].addActionListener(this);
		jButtons[3].addActionListener(this);
		jButtons[4].addActionListener(this);
		jButtons[5].addActionListener(this);
		jButtons[6].addActionListener(this);
		jButtons[7].addActionListener(this);
		jButtons[8].addActionListener(this);
       
	}
	

	public void TitlePanel() {
		// =============================================================title Panel
		titleJPanel = new JPanel();
		titleJPanel.setBackground(new Color(102, 102, 255));
		titleJPanel.setPreferredSize(new Dimension(50, 50));
		titleJPanel.setLayout(new BorderLayout());
		titleJPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 20, new Color(102, 102, 255)));
		this.add(titleJPanel, BorderLayout.NORTH);

		// ===================================================set title with title panel
		titleJLabel = new JLabel("Manu");
		titleJLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		titleJLabel.setForeground(Color.white);
		titleJLabel.setIcon(new ImageIcon(getClass().getResource("/picture/menu.png")));
		titleJLabel.setIconTextGap(10);
		titleJPanel.add(titleJLabel);

		// =============================================================admin label
		adminLabel = new JLabel();
		adminLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		adminLabel.setIcon(new ImageIcon(getClass().getResource("/picture/user.png")));
		adminLabel.setForeground(Color.WHITE);
		adminLabel.setIconTextGap(10);
		titleJPanel.add(adminLabel, BorderLayout.EAST);
	}

	public void MenuPanel() {

		// =============================================================Menu panel
		menuPanel = new JPanel();
		menuPanel.setBackground(new Color(51, 51, 51));
		menuPanel.setPreferredSize(new Dimension(200, 50));
		menuPanel.setBorder(BorderFactory.createMatteBorder(0, 17, 0, 0, new Color(51, 51, 51)));
		this.add(menuPanel, BorderLayout.WEST);

		// =============================================================set MenuItem
		// boxLayout
		BoxLayout box = new BoxLayout(menuPanel, BoxLayout.Y_AXIS);
		menuPanel.setLayout(box);

		// =============================================================MenuItem \\
		jButtons = new JButton[9];
		menuPanel.add(Box.createVerticalStrut(20));

		try {
			// home page button
			jButtons[0] = new JButton("Home Page",
					new ImageIcon(getClass().getResource("/picture/homepage.png")));	
			// manage book button
			jButtons[1] = new JButton("Manage Book",
					new ImageIcon(getClass().getResource("/picture/mange_book2.png")));
			// manage student button
			jButtons[2] = new JButton("Manage Student",
					new ImageIcon(getClass().getResource("/picture/student1_icon.png")));
			// issue book button
			jButtons[3] = new JButton("Issue Book",
					new ImageIcon(getClass().getResource("/picture/issue.png")));
			// return book button
			jButtons[4] = new JButton("Return Book",
					new ImageIcon(getClass().getResource("/picture/return.png")));
			// view record button
			jButtons[5] = new JButton("View Record",
					new ImageIcon(getClass().getResource("/picture/file.png")));
			// view issue book button
			jButtons[6] = new JButton("User Details",
					new ImageIcon(getClass().getResource("/picture/users.png")));
			//cahange password		
			jButtons[7] = new JButton("Change Password",
					new ImageIcon(getClass().getResource("/picture/key.png")));
			/// logout button
			jButtons[8] = new JButton("Logout",
					new ImageIcon(getClass().getResource("/picture/logout.png")));
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < jButtons.length; i++) {
			menuPanel.add(jButtons[i]);
			menuPanel.add(Box.createVerticalStrut(30));
			jButtons[i].setFocusable(false);
			jButtons[i].setForeground(Color.white);
			jButtons[i].setBackground(new Color(51, 51, 51));
			jButtons[i].setFont(new Font("Arial", Font.PLAIN, 15));
			jButtons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButtons[i].setIconTextGap(7);
			jButtons[i].setBorder(BorderFactory.createEmptyBorder());
		}
	}

	public void HomeBookTable() {
		// iconPanel = new JPanel();
        // iconPanel.setLayout(new BorderLayout());
		// this.add(iconPanel, BorderLayout.CENTER);

		icon = new ImageIcon(getClass().getResource("/picture/homePage_icon.jpg"));
		iconLabel = new JLabel(icon);
		iconLabel.setLayout(new BorderLayout());
		this.add(iconLabel,BorderLayout.CENTER);

		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(102, 153, 255));
		centerPanel.setLayout(null);
		centerPanel.setVisible(false);
		iconLabel.add(centerPanel, BorderLayout.CENTER);

		// =============================================================book details
		// table
		bookTableTitle = new JLabel("Book Details");
		bookTableTitle.setBounds(20, 20, 100, 30);
		bookTableTitle.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		bookTableTitle.setBackground(Color.red);
		bookTableTitle.setForeground(Color.white);
		centerPanel.add(bookTableTitle);

		bookDatlisTable = new JTable();
		homeDefaultTableModel = new DefaultTableModel(rowCount, columnCount) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		homeDefaultTableModel.setColumnIdentifiers(mangeBookcolumn);
		bookDatlisTable.setModel(homeDefaultTableModel);
		bookDatlisTable.setSelectionBackground(Color.LIGHT_GRAY);
		bookDatlisTable.setRowHeight(30);

		bookDatlisTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		bookDatlisTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		bookDatlisTable.getColumnModel().getColumn(1).setPreferredWidth(160);
		bookDatlisTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		bookDatlisTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		bookDatlisTable.getColumnModel().getColumn(4).setPreferredWidth(200);

		JTableHeader bookTableHeader = bookDatlisTable.getTableHeader();
		bookTableHeader.setBackground(Color.darkGray);
		bookTableHeader.setForeground(Color.white);
		bookTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));

		homeTableScrollPane = new JScrollPane(bookDatlisTable);
		homeTableScrollPane.setBounds(20, 50, 650, 220);
		centerPanel.add(homeTableScrollPane);

		String file1 = ".\\Data\\book_data.txt";
		// ==================================================================add data
		// book details table
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
					manageBookrow[0] = Files.readAllLines(Paths.get(file1)).get(i).substring(10);
					manageBookrow[1] = Files.readAllLines(Paths.get(file1)).get(i + 1).substring(12);
					manageBookrow[2] = Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14);
					manageBookrow[3] = Files.readAllLines(Paths.get(file1)).get(i + 3).substring(16);
					manageBookrow[4] = Files.readAllLines(Paths.get(file1)).get(i + 4).substring(16);
					homeDefaultTableModel.addRow(manageBookrow);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		// ==============================================student details table
		studentTableTitle = new JLabel("Student Details");
		studentTableTitle.setBounds(20, 290, 150, 30);
		studentTableTitle.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		studentTableTitle.setBackground(Color.red);
		studentTableTitle.setForeground(Color.white);
		centerPanel.add(studentTableTitle);

		studentDetailsTable = new JTable();
		homeDefaultTableModel2 = new DefaultTableModel(rowCount, columnCount) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		homeDefaultTableModel2.setColumnIdentifiers(manageStudentcolumn);
		studentDetailsTable.setModel(homeDefaultTableModel2);
		studentDetailsTable.setSelectionBackground(Color.lightGray);
		studentDetailsTable.setRowHeight(30);

		studentDetailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		studentDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(160);
		studentDetailsTable.getColumnModel().getColumn(2).setPreferredWidth(120);
		studentDetailsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		studentDetailsTable.getColumnModel().getColumn(4).setPreferredWidth(200);

		JTableHeader studentTableHeader = studentDetailsTable.getTableHeader();
		studentTableHeader.setBackground(Color.darkGray);
		studentTableHeader.setForeground(Color.white);
		studentTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));

		homeTableScrollPane = new JScrollPane(studentDetailsTable);
		homeTableScrollPane.setBounds(20, 320, 650, 220);
		centerPanel.add(homeTableScrollPane);

		String file2 = ".\\Data\\strudent_data.txt";

		// =====================================================add data student details
		// table
		try {
			BufferedReader reader2 = new BufferedReader(new FileReader(file2));
			int totalLines = 0;
			while (reader2.readLine() != null)
				totalLines++;
			reader2.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file2)).get(i);
				String a = line.substring(0, 10);
				if (a.equals("Student Id")) {
					manageStudentrow[0] = Files.readAllLines(Paths.get(file2)).get(i).substring(13);
					manageStudentrow[1] = Files.readAllLines(Paths.get(file2)).get(i + 1).substring(15);
					manageStudentrow[2] = Files.readAllLines(Paths.get(file2)).get(i + 2).substring(9);
					manageStudentrow[3] = Files.readAllLines(Paths.get(file2)).get(i + 3).substring(12);
					manageStudentrow[4] = Files.readAllLines(Paths.get(file2)).get(i + 4).substring(16);
					homeDefaultTableModel2.addRow(manageStudentrow);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void actionPerformed(ActionEvent e) {
		// ======================================home page button
		if (e.getSource() == jButtons[0]) {
			centerPanel.setVisible(true);
		}
		// ================================================manage book button listener
		if (e.getSource() == jButtons[1]) {
			dispose();
			ManageBook book = new ManageBook();
			book.setVisible(true);
		}
		// ================================================manage stude button listener
		if (e.getSource() == jButtons[2]) {
			dispose();
			ManageStudent student = new ManageStudent();
			student.setVisible(true);
		}
		// ================================================issue book button listener
		if (e.getSource() == jButtons[3]) {
			dispose();
			IssueBook issueBook = new IssueBook();
			issueBook.setVisible(true);
		}
		// return book button listener
		if (e.getSource() == jButtons[4]) {
			dispose();
			ReturnBook returnBook = new ReturnBook();
			returnBook.setVisible(true);
		}
		// ================================================view record button listener
		if (e.getSource() == jButtons[5]) {
			dispose();
			ViewRecord viewRecord = new ViewRecord();
			viewRecord.setVisible(true);
		}
		// ================================================view issue book button listener
		if (e.getSource() == jButtons[6]) {
			dispose();
			userDetails user = new userDetails();
		    user.setVisible(true);
		}
		//====================================================change password button listener
		if (e.getSource() == jButtons[7]) {
			dispose();
			adminLogin aLogin = new adminLogin();
			aLogin.setVisible(true);
			aLogin.loginPanel.setVisible(false);
			aLogin.backButton.setVisible(false);
			aLogin.backButton2.setVisible(true);
			aLogin.singinPanel.setVisible(true);
			aLogin.loginLabel.setText("Create New Account Here");
			
		}

		// ================================================logout button
		if (e.getSource() == jButtons[8]) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to logout now?", "Logout",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				dispose();
				adminLogin admin = new adminLogin();
				admin.setVisible(true);
			}
		}
	}
	public static void main(String[] arga) {
		HomePage homePage =new HomePage();
		homePage.setVisible(true);
	}

}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IssueBook extends JFrame implements ActionListener, FocusListener {
	JPanel bookPanel, studentPanel, issuePanel, p;
	JLabel closeLabel, backLabel, StudentId, BookId, issuedate, duedate;
	JLabel bookDetailsLabel, studentDetailsLabel, issutitleLabel;
	JLabel bookLabel, bookIdLabel2, bookNameLabel2, authorLabel2, quantityLabel2;
	JLabel studentLabel, studentIdLabel2, studentNameLabel2, courseLabel2, branchLabel2;
	JTextField studentIdField, bookIdField, issueDateField, dueDataField, issueidField;
	JButton issueButton, fildbButton;

	public IssueBook() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(850, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		

		// ===================================================================book panal
		bookPanel = new JPanel();
		bookPanel.setBackground(new Color(0, 150, 255));
		bookPanel.setPreferredSize(new Dimension(240, 200));
		bookPanel.setLayout(null);
		this.add(bookPanel, BorderLayout.WEST);

		backLabel = new JLabel("Back");
		backLabel.setForeground(Color.white);
		backLabel.setBounds(0, 0, 100, 30);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		bookPanel.add(backLabel);

		// =============================================================backLabel
		// MouseListener
		backLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
			}
		});

		// =============================================================book title label
		bookDetailsLabel = new JLabel("Book Details");
		bookDetailsLabel.setBounds(30, 50, 160, 50);
		bookDetailsLabel.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		bookDetailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		bookDetailsLabel.setForeground(Color.white);
		bookDetailsLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		bookPanel.add(bookDetailsLabel);

		// =============================================================book id label
		backLabel = new JLabel("Id : ");
		backLabel.setForeground(Color.white);
		backLabel.setFont(new Font("Arieal", Font.BOLD, 16));
		backLabel.setBounds(10, 150, 33, 20);
		bookPanel.add(backLabel);
		// =============================================================show book id
		// label
		bookIdLabel2 = new JLabel();
		bookIdLabel2.setForeground(Color.white);
		bookIdLabel2.setFont(new Font("Arieal", Font.ITALIC, 17));
		bookIdLabel2.setBounds(42, 149, 130, 25);
		bookIdLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		bookPanel.add(bookIdLabel2);

		// =============================================================book name label
		bookLabel = new JLabel("Name : ");
		bookLabel.setForeground(Color.white);
		bookLabel.setFont(new Font("Arieal", Font.BOLD, 16));
		bookLabel.setBounds(10, 210, 65, 20);
		bookPanel.add(bookLabel);
		// =============================================================show book name
		// label
		bookNameLabel2 = new JLabel();
		bookNameLabel2.setForeground(Color.white);
		bookNameLabel2.setFont(new Font("Arieal", Font.ITALIC, 17));
		bookNameLabel2.setBounds(70, 209, 150, 25);
		bookNameLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		bookPanel.add(bookNameLabel2);

		// =============================================================book author
		// label
		bookLabel = new JLabel("Author : ");
		bookLabel.setForeground(Color.white);
		bookLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		bookLabel.setBounds(10, 269, 75, 25);
		bookPanel.add(bookLabel);
		// =============================================================show book author
		// label
		authorLabel2 = new JLabel();
		authorLabel2.setForeground(Color.white);
		authorLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		authorLabel2.setBounds(83, 269, 130, 25);
		authorLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		bookPanel.add(authorLabel2);

		// =============================================================book quantity
		// label
		bookLabel = new JLabel("Quantity : ");
		bookLabel.setForeground(Color.white);
		bookLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		bookLabel.setBounds(10, 329, 85, 25);
		bookPanel.add(bookLabel);
		// =============================================================show book
		// quantity label
		quantityLabel2 = new JLabel();
		quantityLabel2.setForeground(Color.white);
		quantityLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		quantityLabel2.setBounds(95, 329, 130, 25);
		quantityLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		bookPanel.add(quantityLabel2);

		// =====================================================student panal
		p = new JPanel();
		p.setLayout(new BorderLayout());
		this.add(p, BorderLayout.CENTER);

		studentPanel = new JPanel();
		studentPanel.setBackground(Color.red);
		studentPanel.setPreferredSize(new Dimension(260, 200));
		studentPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, Color.white));
		studentPanel.setLayout(null);
		p.add(studentPanel, BorderLayout.WEST);

		studentDetailsLabel = new JLabel("Student Details");
		studentDetailsLabel.setBounds(35, 35, 190, 65);
		studentDetailsLabel.setIcon(new ImageIcon(getClass().getResource("/picture/graduation.png")));
		studentDetailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		studentDetailsLabel.setForeground(Color.orange);
		studentDetailsLabel.setBorder(BorderFactory.createEmptyBorder());
		studentDetailsLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		studentPanel.add(studentDetailsLabel);

		// =============================================================student id label
		studentLabel = new JLabel("Id : ");
		studentLabel.setForeground(Color.white);
		studentLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		studentLabel.setBounds(15, 150, 33, 20);
		studentPanel.add(studentLabel);
		// =============================================================show student id
		// label
		studentIdLabel2 = new JLabel();
		studentIdLabel2.setForeground(Color.white);
		studentIdLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		studentIdLabel2.setBounds(47, 149, 140, 25);
		studentIdLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		studentPanel.add(studentIdLabel2);

		// =============================================================student name
		// label
		studentLabel = new JLabel("Name : ");
		studentLabel.setForeground(Color.white);
		studentLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		studentLabel.setBounds(15, 210, 65, 20);
		studentPanel.add(studentLabel);
		// =============================================================show student
		// name label
		studentNameLabel2 = new JLabel();
		studentNameLabel2.setForeground(Color.white);
		studentNameLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		studentNameLabel2.setBounds(77, 209, 170, 25);
		studentNameLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		studentPanel.add(studentNameLabel2);

		// =============================================================student course
		// label
		studentLabel = new JLabel("Course : ");
		studentLabel.setForeground(Color.white);
		studentLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		studentLabel.setBounds(15, 270, 70, 20);
		studentPanel.add(studentLabel);
		// =============================================================show show
		// student course label
		courseLabel2 = new JLabel();
		courseLabel2.setForeground(Color.white);
		courseLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		courseLabel2.setBounds(87, 269, 130, 25);
		courseLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		studentPanel.add(courseLabel2);

		// =============================================================student branch
		// label
		studentLabel = new JLabel("Branch : ");
		studentLabel.setForeground(Color.white);
		studentLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		studentLabel.setBounds(15, 330, 70, 20);
		studentPanel.add(studentLabel);
		// =============================================================show student
		// branch label
		branchLabel2 = new JLabel();
		branchLabel2.setForeground(Color.white);
		branchLabel2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		branchLabel2.setBounds(87, 329, 130, 25);
		branchLabel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		studentPanel.add(branchLabel2);
		// ================================================================issue panal
		issuePanel = new JPanel();
		issuePanel.setLayout(null);
		p.add(issuePanel, BorderLayout.CENTER);

		// =============================================================close label
		closeLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/close_icon.png")));
		closeLabel.setBounds(330, 5, 17, 17);
		issuePanel.add(closeLabel);

		// =============================================================set closeLabel
		// MouseListener
		closeLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int a = JOptionPane.showConfirmDialog(null, "Do you want to close now?\n", "Message",
						JOptionPane.YES_NO_OPTION);
				if (a == 0) {
					System.exit(0);
				}
			}
		});

		// =============================================================issue book title
		issutitleLabel = new JLabel("Issue Book");
		issutitleLabel.setBounds(90, 50, 160, 50);
		issutitleLabel.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		issutitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		issutitleLabel.setForeground(Color.blue);
		issutitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.blue));
		issuePanel.add(issutitleLabel);

		// =============================================================student id label
		StudentId = new JLabel("Student Id : ");
		StudentId.setForeground(Color.black);
		StudentId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		StudentId.setBounds(20, 140, 90, 20);
		issuePanel.add(StudentId);
		// =====================================================student id text field
		studentIdField = new JTextField();
		studentIdField.setBounds(110, 138, 150, 25);
		issuePanel.add(studentIdField);

		// =============================================================book id label
		BookId = new JLabel("Book Id : ");
		BookId.setForeground(Color.black);
		BookId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		BookId.setBounds(20, 190, 90, 20);
		issuePanel.add(BookId);
		// ========================================================book id text field
		bookIdField = new JTextField();
		bookIdField.setBounds(110, 188, 150, 25);
		issuePanel.add(bookIdField);

		// ===========================================================issue id label
		BookId = new JLabel("Issue Id : ");
		BookId.setForeground(Color.black);
		BookId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		BookId.setBounds(20, 240, 90, 20);
		issuePanel.add(BookId);

		// ============================================================issue id fild
		issueidField = new JTextField();
		issueidField.setBounds(110, 238, 150, 25);
		issuePanel.add(issueidField);

		// =============================================================issue date label
		issuedate = new JLabel("Issue Date : ");
		issuedate.setForeground(Color.black);
		issuedate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		issuedate.setBounds(20, 290, 90, 20);
		issuePanel.add(issuedate);
		// ========================================================issue date text field
		issueDateField = new JTextField();
		issueDateField.setBounds(110, 288, 150, 25);
		issuePanel.add(issueDateField);

		// =============================================================due date label
		duedate = new JLabel("Due Date : ");
		duedate.setForeground(Color.black);
		duedate.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		duedate.setBounds(20, 340, 90, 20);
		issuePanel.add(duedate);
		// =============================================================due date text
		// field
		dueDataField = new JTextField();
		dueDataField.setBounds(110, 338, 150, 25);
		issuePanel.add(dueDataField);

		// ===========================================================issue button
		issueButton = new JButton("Issue Book");
		issueButton.setBounds(110, 400, 150, 30);
		issueButton.setBackground(Color.decode("#2E67F8"));
		issueButton.setFocusable(false);
		issuePanel.add(issueButton);

		issueButton.addActionListener(this);
		studentIdField.addFocusListener(this);
		bookIdField.addFocusListener(this);
		issueidField.addFocusListener(this);
		issueDateField.addFocusListener(this);
		dueDataField.addFocusListener(this);

	}

	public boolean validateIssuFrame() {
		if (studentIdField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Id.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (bookIdField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Name.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (issueDateField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Issue Date.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (dueDataField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Enter Due Date.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			String file1 = ".\\Data\\Issue_data.txt";
			String s = studentIdField.getText();
			String b = bookIdField.getText();
			try {
				String Sid = "Student ID : " + s;
				String Bid = "Book ID : " + b;

				BufferedReader reader = new BufferedReader(new FileReader(file1));
				int totalLines = 0;
				while (reader.readLine() != null)
					totalLines++;
				reader.close();

				for (int i = 0; i < totalLines; i++) {
					String line = Files.readAllLines(Paths.get(file1)).get(i);
					if (line.equals(Sid)) {
						String line2 = Files.readAllLines(Paths.get(file1)).get(i + 1);
						if (line2.equals(Bid)) {
							JOptionPane.showMessageDialog(null, "This student already issue same book  ");
							return false;
						}
					}

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		return true;

	}

	public static void main(String[] args) {
		IssueBook book = new IssueBook();
		book.setVisible(true);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == issueidField) {
			Random random = new Random();
			int x = random.nextInt(300);
			int y = random.nextInt(200);
			int z = random.nextInt(11, 100);
			int a = (x + y) * z;

			issueidField.setText("" + a + "");

		}
		if (e.getSource() == issueDateField) {
			LocalDate localDate = LocalDate.now();
			issueDateField.setText("" + localDate);
		}
		if (e.getSource() == dueDataField) {
			LocalDate localDate = LocalDate.now();
			dueDataField.setText("" + localDate.plusDays(15));
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		String file2 = ".\\Data\\strudent_data.txt";
		String getid = studentIdField.getText();
		// =====================================================add data student details
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
					String b = line.substring(13);
					if (b.equals(getid)) {
						studentIdLabel2.setText(Files.readAllLines(Paths.get(file2)).get(i).substring(13));
						studentNameLabel2.setText(Files.readAllLines(Paths.get(file2)).get(i + 1).substring(15));
						courseLabel2.setText(Files.readAllLines(Paths.get(file2)).get(i + 2).substring(9));
						branchLabel2.setText(Files.readAllLines(Paths.get(file2)).get(i + 3).substring(12));
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		String file1 = ".\\Data\\book_data.txt";
		String bkId = bookIdField.getText();
		// ==================================================================add data
		// book details
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
					String b = line.substring(10);
					if (b.equals(bkId)) {
						// bookIdLabel2,bookNameLabel2,authorLabel2,quantityLabel2;
						bookIdLabel2.setText(Files.readAllLines(Paths.get(file1)).get(i).substring(10));
						bookNameLabel2.setText(Files.readAllLines(Paths.get(file1)).get(i + 1).substring(12));
						authorLabel2.setText(Files.readAllLines(Paths.get(file1)).get(i + 2).substring(14));
						quantityLabel2.setText(Files.readAllLines(Paths.get(file1)).get(i + 3).substring(16));
					}
				}
			}
		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == issueButton) {
			if (validateIssuFrame() == true) {
				try {
					File file = new File(".\\Data\\Issue_data.txt");
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fileWriter = new FileWriter(file, true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					PrintWriter printWriter = new PrintWriter(bufferedWriter);

					printWriter.println("Student ID : " + studentIdField.getText());
					printWriter.println("Book ID : " + bookIdField.getText());
					printWriter.println("Issue Id : " + issueidField.getText());
					printWriter.println("Book Name : " + bookNameLabel2.getText());
					printWriter.println("Student Name : " + studentNameLabel2.getText());
					printWriter.println("Issue Date : " + issueDateField.getText());
					printWriter.println("Due Date : " + dueDataField.getText());
					printWriter.println("==========================================");
					printWriter.close();
				} catch (Exception exp) {
					System.out.println(exp);
				}
				JOptionPane.showMessageDialog(null, "Issue Successful");
				dispose();
				IssueBook i = new IssueBook();
				i.setVisible(true);
			}
		}
	}
}
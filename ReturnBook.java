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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnBook extends JFrame implements FocusListener, ActionListener {
	JPanel bookPanel, studentPanel, issuePanel, p;
	JLabel closeLabel, backLabel, StudentId, bookIdLabel;
	JLabel bookDetailsLabel, returnBookLabel;
	JLabel jLabel, issueIdLabel2, rbookNameLabel2, sNameLabel2, issueDateLabel2, dueDateLabel;
	JTextField studentIdField, bookIdField;
	JButton findButton, returnButton;

	public ReturnBook() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(750, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		bookDetails();
		returnbook();

		findButton.addFocusListener(this);
		returnButton.addActionListener(this);

	}

	public void bookDetails() {
		bookPanel = new JPanel();
		bookPanel.setBackground(new Color(0, 150, 255));
		bookPanel.setPreferredSize(new Dimension(400, 200));
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
		bookDetailsLabel.setBounds(90, 50, 160, 50);
		bookDetailsLabel.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		bookDetailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		bookDetailsLabel.setForeground(Color.white);
		bookDetailsLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		bookPanel.add(bookDetailsLabel);

		// =============================================================issue id label
		jLabel = new JLabel("Issue Id : ");
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabel.setBounds(15, 150, 70, 20);
		bookPanel.add(jLabel);
		// =============================================================show issue id
		// label
		issueIdLabel2 = new JLabel();
		issueIdLabel2.setForeground(Color.white);
		issueIdLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		issueIdLabel2.setBounds(85, 149, 160, 25);
		// issueIdLabel2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
		bookPanel.add(issueIdLabel2);

		// =============================================================book name label
		jLabel = new JLabel("Book name : ");
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabel.setBounds(15, 210, 100, 20);
		bookPanel.add(jLabel);
		// =============================================================show book name
		// label
		rbookNameLabel2 = new JLabel();
		rbookNameLabel2.setForeground(Color.white);
		rbookNameLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		rbookNameLabel2.setBounds(110, 209, 160, 25);
		// rbookNameLabel2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
		bookPanel.add(rbookNameLabel2);

		// =============================================================student name
		// label
		jLabel = new JLabel("Student Name : ");
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabel.setBounds(15, 270, 120, 20);
		bookPanel.add(jLabel);
		// =============================================================show student
		// name author label
		sNameLabel2 = new JLabel();
		sNameLabel2.setForeground(Color.white);
		sNameLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		sNameLabel2.setBounds(135, 267, 250, 25);
		// sNameLabel2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
		bookPanel.add(sNameLabel2);

		// =============================================================book issue date
		// label
		jLabel = new JLabel("Issue Date : ");
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabel.setBounds(15, 330, 90, 20);
		bookPanel.add(jLabel);
		// =============================================================show book issue
		// date label
		issueDateLabel2 = new JLabel();
		issueDateLabel2.setForeground(Color.white);
		issueDateLabel2.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		issueDateLabel2.setBounds(105, 327, 160, 25);
		// issueDateLabel2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
		bookPanel.add(issueDateLabel2);

		// =============================================================book due date
		// label
		jLabel = new JLabel("Due Date : ");
		jLabel.setForeground(Color.white);
		jLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		jLabel.setBounds(15, 390, 100, 20);
		bookPanel.add(jLabel);
		// =============================================================show book due
		// date label
		dueDateLabel = new JLabel();
		dueDateLabel.setForeground(Color.white);
		dueDateLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		dueDateLabel.setBounds(100, 387, 160, 25);
		// issueDateLabel2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.white));
		bookPanel.add(dueDateLabel);

	}

	public void returnbook() {
		issuePanel = new JPanel();
		issuePanel.setLayout(null);
		this.add(issuePanel, BorderLayout.CENTER);

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
		returnBookLabel = new JLabel("Return Book");
		returnBookLabel.setBounds(90, 50, 180, 50);
		returnBookLabel.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		returnBookLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		returnBookLabel.setForeground(Color.blue);
		returnBookLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.blue));
		issuePanel.add(returnBookLabel);

		// =============================================================student id label
		StudentId = new JLabel("Student Id : ");
		StudentId.setForeground(Color.black);
		StudentId.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		StudentId.setBounds(20, 150, 90, 20);
		issuePanel.add(StudentId);
		// =================================================student id text field
		studentIdField = new JTextField();
		studentIdField.setBounds(110, 148, 150, 25);
		issuePanel.add(studentIdField);

		// =============================================================book id label
		bookIdLabel = new JLabel("Book Id : ");
		bookIdLabel.setForeground(Color.black);
		bookIdLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bookIdLabel.setBounds(20, 210, 90, 20);
		issuePanel.add(bookIdLabel);
		// =============================================================book id text
		// field
		bookIdField = new JTextField();
		bookIdField.setBounds(110, 208, 150, 25);
		issuePanel.add(bookIdField);

		// =============================================================find button
		findButton = new JButton("FIND");
		findButton.setBackground(Color.blue);
		findButton.setBounds(100, 350, 170, 30);
		findButton.setForeground(Color.white);
		// findButton.setFocusable(false);
		issuePanel.add(findButton);
		// =============================================================return book
		// button
		returnButton = new JButton("RETURN BOOK");
		returnButton.setBackground(Color.blue);
		returnButton.setBounds(100, 400, 170, 30);
		returnButton.setForeground(Color.white);
		returnButton.setFocusable(false);
		issuePanel.add(returnButton);

	}

	public static void main(String[] args) {
		ReturnBook book = new ReturnBook();
		book.setVisible(true);
	}

	@Override
	public void focusGained(FocusEvent e) {
		String file = ".\\Data\\Issue_data.txt";
		String s = studentIdField.getText();
		String b = bookIdField.getText();
		if (e.getSource() == findButton) {
			try {
				String Sid = "Student ID : " + s;
				String Bid = "Book ID : " + b;

				BufferedReader reader = new BufferedReader(new FileReader(file));
				int totalLines = 0;
				while (reader.readLine() != null)
					totalLines++;
				reader.close();

				for (int i = 0; i < totalLines; i++) {
					String lines = Files.readAllLines(Paths.get(file)).get(i);
					String a = lines.substring(0, 10);
					if (a.equals("Student ID")) {
						String line = Files.readAllLines(Paths.get(file)).get(i);
						if (line.equals(Sid)) {
							String line2 = Files.readAllLines(Paths.get(file)).get(i + 1);
							if (line2.equals(Bid)) {
								issueIdLabel2.setText(Files.readAllLines(Paths.get(file)).get(i + 2).substring(11));
								rbookNameLabel2.setText(Files.readAllLines(Paths.get(file)).get(i + 3).substring(12));
								sNameLabel2.setText(Files.readAllLines(Paths.get(file)).get(i + 4).substring(15));
								issueDateLabel2.setText(Files.readAllLines(Paths.get(file)).get(i + 5).substring(13));
								dueDateLabel.setText(Files.readAllLines(Paths.get(file)).get(i + 6).substring(11));

							}
						}
					}

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

		}

	}

	public void focusLost(FocusEvent e) {

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnButton) {
			String remove = issueIdLabel2.getText();
			String file = ".//Data//Issue_data.txt";
			String temp = ".//Data//issueTemp.txt";
			if (issueIdLabel2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter student Id and book Id", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				File oldFile = new File(file);
				File newFile = new File(temp);

				int q = 0;

				try {

					BufferedReader reader = new BufferedReader(new FileReader(file));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int i = 0; i < totalLines; i++) {
						String line = Files.readAllLines(Paths.get(file)).get(i);
						String x = line.substring(0, 10);
						if (x.equals("Student ID")) {
							String issueID = Files.readAllLines(Paths.get(file)).get(i + 2);
							if (issueID.substring(11).equals(remove)) {
								q = i;
							}
						}
					}
				} catch (Exception ex) {
					return;
				}
				try {

					FileWriter fw = new FileWriter(temp, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);

					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);

					BufferedReader reader = new BufferedReader(new FileReader(file));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int j = 0; j < totalLines; j++) {
						if ((j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4)
								|| j == (q + 5) || j == (q + 6))) {
							String issueId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println("#Return! " + issueId);
						} else {
							String issueId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println(issueId);
						}
					}
					pw.flush();
					pw.close();
					fr.close();
					br.close();
					bw.close();
					fw.close();

				} catch (Exception ex) {
					System.out.print(ex);
				}

				oldFile.delete();
				File dump = new File(file);
				newFile.renameTo(dump);

				dispose();
				ReturnBook book = new ReturnBook();
				book.setVisible(true);
				JOptionPane.showMessageDialog(null, "Return Sussessfull");
			}
		}

	}

}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManageStudent extends JFrame implements ActionListener {
	JPanel westPanel, eastPanel;
	JLabel closeLabel, backLabel, titleLabel;
	JLabel idJLabel, nameJLabel, courseJLabel, branchJLabel;
	JLabel idiconlLabel, nameiconlLabel, courseIconlLabel, branchIconlLabel;
	JTextField idField, nameField, authorField, quantityField;
	JButton addButton, updateButton, deleteButton;
	JComboBox<String> courseBox, depermentBox;
	JTable table;
	DefaultTableModel model;
	JScrollPane pane;

	String[] column = new String[] { "Student Id", "Name", "Course", "Branch" };
	String[] row = new String[4];

	public ManageStudent() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		WestJPanel();
		EastPanal();

		addButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}

	public void WestJPanel() {
		// =============================================================west panel
		// JFrame
		westPanel = new JPanel();
		westPanel.setBackground(new Color(102, 102, 255));
		westPanel.setPreferredSize(new Dimension(330, 200));
		westPanel.setLayout(null);
		this.add(westPanel, BorderLayout.WEST);
		// back JLabel
		backLabel = new JLabel("Back");
		backLabel.setForeground(Color.white);
		backLabel.setBounds(0, 0, 100, 30);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		westPanel.add(backLabel);

		// =============================================================backLabel
		// MouseListener
		backLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
			}
		});

		// add JLabel west panel
		// =============================================================Book id frame
		idJLabel = new JLabel("Enter Student ID : ");
		idJLabel.setBounds(50, 85, 140, 20);
		idJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		idJLabel.setForeground(Color.white);
		westPanel.add(idJLabel);

		idField = new JTextField();
		idField.setBounds(50, 113, 200, 20);
		idField.setBackground(new Color(102, 102, 255));
		idField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		westPanel.add(idField);

		idiconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/id.png")));
		idiconlLabel.setBounds(17, 112, 20, 20);
		westPanel.add(idiconlLabel);
		// =============================================================Book name frame
		nameJLabel = new JLabel("Enter Your Name : ");
		nameJLabel.setBounds(50, 165, 140, 20);
		nameJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		nameJLabel.setForeground(Color.white);
		westPanel.add(nameJLabel);

		nameField = new JTextField();
		nameField.setBounds(50, 193, 200, 20);
		nameField.setBackground(new Color(102, 102, 255));
		nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		westPanel.add(nameField);

		nameiconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/name.png")));
		nameiconlLabel.setBounds(17, 192, 20, 20);
		westPanel.add(nameiconlLabel);

		// =============================================================Course name
		// Frame
		courseJLabel = new JLabel("Course : ");
		courseJLabel.setBounds(50, 248, 140, 20);
		courseJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		courseJLabel.setForeground(Color.white);
		westPanel.add(courseJLabel);

		String[] course = { "Choose a Course...", "BSC", "MSC", "PSD" };
		courseBox = new JComboBox<>(course);
		courseBox.setBounds(50, 276, 200, 30);
		westPanel.add(courseBox);

		courseIconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/course.png")));
		courseIconlLabel.setBounds(17, 280, 20, 20);
		westPanel.add(courseIconlLabel);

		// =============================================================Branch frame
		branchJLabel = new JLabel("Branch : ");
		branchJLabel.setBounds(50, 331, 140, 20);
		branchJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		branchJLabel.setForeground(Color.white);
		westPanel.add(branchJLabel);

		String[] deperment = { "Choose a Branch...", "CS", "IT" };
		depermentBox = new JComboBox<>(deperment);
		depermentBox.setBounds(50, 358, 200, 30);
		westPanel.add(depermentBox);

		branchIconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/course.png")));
		branchIconlLabel.setBounds(17, 363, 20, 20);
		westPanel.add(branchIconlLabel);

		// =============================================================add button
		addButton = new JButton("ADD");
		addButton.setBorderPainted(rootPaneCheckingEnabled);
		addButton.setBounds(30, 410, 70, 30);
		addButton.setFocusable(false);
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		addButton.setBackground(Color.red);
		addButton.setForeground(Color.white);
		westPanel.add(addButton);

		// =============================================================Update button
		updateButton = new JButton("UPDATE");
		updateButton.setBorderPainted(rootPaneCheckingEnabled);
		updateButton.setBounds(115, 410, 82, 30);
		updateButton.setFocusable(false);
		updateButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateButton.setBackground(Color.red);
		updateButton.setForeground(Color.white);
		//updateButton.setEnabled(false);
		westPanel.add(updateButton);

		// =============================================================delete Button
		deleteButton = new JButton("DELETE");
		deleteButton.setBorderPainted(rootPaneCheckingEnabled);
		deleteButton.setBounds(213, 410, 80, 30);
		deleteButton.setFocusable(false);
		deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setBackground(Color.red);
		deleteButton.setForeground(Color.white);
		westPanel.add(deleteButton);

	}

	public void EastPanal() {

		eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setPreferredSize(new Dimension(470, 200));
		eastPanel.setLayout(null);
		this.add(eastPanel, BorderLayout.EAST);
		// ==============================================================================close
		// label
		closeLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/close_icon.png")));
		closeLabel.setBounds(445, 5, 17, 17);
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eastPanel.add(closeLabel);

		// ===============================================================set closeLabel
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

		// ==============================================================================title
		// Label
		titleLabel = new JLabel("Manage Student");
		titleLabel.setBounds(120, 10, 220, 50);
		titleLabel.setIcon(new ImageIcon(getClass().getResource("/picture/graduation.png")));
		titleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 23));
		titleLabel.setForeground(Color.orange);
		titleLabel.setBorder(BorderFactory.createEmptyBorder());
		titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		eastPanel.add(titleLabel);

		// ========================================================================set
		// table east Panel
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setFont(new Font("Segoe UI", Font.BOLD, 10));
		table.setSelectionBackground(Color.pink);
		table.setRowHeight(30);

		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		pane = new JScrollPane(table);
		pane.setBounds(10, 100, 450, 260);
		eastPanel.add(pane);

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
					row[0] = Files.readAllLines(Paths.get(file2)).get(i).substring(13);
					row[1] = Files.readAllLines(Paths.get(file2)).get(i + 1).substring(15);
					row[2] = Files.readAllLines(Paths.get(file2)).get(i + 2).substring(9);
					row[3] = Files.readAllLines(Paths.get(file2)).get(i + 3).substring(12);
					model.addRow(row);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				int rowNumber = table.getSelectedRow();

				String id = model.getValueAt(rowNumber, 0).toString();
				String name = model.getValueAt(rowNumber, 1).toString();
				

				idField.setText(id);
				nameField.setText(name);
			}

		});

		
	}

	public boolean validateStudent() {
		String id = idField.getText();
		String name = nameField.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter id.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter name.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (courseBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "please select a course.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (depermentBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "please select a  branch.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;

	}

	public void actionPerformed(ActionEvent e) {
		// ========================================================================add
		// button actionListener
		if (e.getSource() == addButton) {
			String id = idField.getText();
			String name = nameField.getText();
			String course = String.valueOf(courseBox.getSelectedItem());
			String branch = String.valueOf(depermentBox.getSelectedItem());
			if (validateStudent() == true) {

				try {
					File file = new File(".\\Data\\strudent_data.txt");

					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fileWriter = new FileWriter(file, true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					PrintWriter printWriter = new PrintWriter(bufferedWriter);

					LocalDateTime localDateTime = LocalDateTime.now();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
					String timeAndDate = localDateTime.format(dateFormatter);

					printWriter.println("Student Id : " + id);
					printWriter.println("Student Name : " + name);
					printWriter.println("Course : " + course);
					printWriter.println("Deperment : " + branch);
					printWriter.println("Time and Date : " + timeAndDate);
					printWriter.println("=================================");
					printWriter.close();

				} catch (Exception ex) {
					System.out.println(ex);
				}

				row[0] = idField.getText();
				row[1] = nameField.getText();
				row[2] = courseBox.getSelectedItem().toString();
				row[3] = depermentBox.getSelectedItem().toString();
				model.addRow(row);

				JOptionPane.showMessageDialog(null, "Add Success");

				idField.setText("");
				nameField.setText("");
				courseBox.setSelectedIndex(0);
				depermentBox.setSelectedIndex(0);
			}

		}
		// ===============================================delete button actionListener
		if (e.getSource() == deleteButton) {

			String file = ".//Data//strudent_data.txt";
			String temp = ".//Data//studentTemp.txt";
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

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
						if (x.equals("Student Id")) {
							String studentId = Files.readAllLines(Paths.get(file)).get(i);
							if (studentId.substring(13).equals(removeUser)) {
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

					BufferedReader reader = new BufferedReader(new FileReader(file));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int j = 0; j < totalLines; j++) {
						if ((j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4))) {
							String studentId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println("#Removed! " + studentId);
						} else {
							String studentId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println(studentId);
						}
					}
					pw.flush();
					pw.close();
					bw.close();
					fw.close();

				} catch (Exception ex) {
					System.out.print(ex);
				}

				oldFile.delete();
				File dump = new File(file);
				newFile.renameTo(dump);

				dispose();
				ManageStudent m = new ManageStudent();
				m.setVisible(true);
			}
		}
		// =======================================================update button action listener
		else if (e.getSource()==updateButton) {
			String id = idField.getText();
			String name = nameField.getText();
			String course = String.valueOf(courseBox.getSelectedItem());
			String branch = String.valueOf(depermentBox.getSelectedItem());
			if (validateStudent() == true) {
			String file = ".//Data//strudent_data.txt";
			String temp = ".//Data//studentTemp.txt";
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a user to update", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String updateUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

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
						if (x.equals("Student Id")) {
							String studentId = Files.readAllLines(Paths.get(file)).get(i);
							if (studentId.substring(13).equals(updateUser)) {
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

					LocalDateTime localDateTime = LocalDateTime.now();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
					String timeAndDate = localDateTime.format(dateFormatter);

					BufferedReader reader = new BufferedReader(new FileReader(file));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int j = 0; j < totalLines; j++) {
						if ((j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4))) {
							pw.println("Student Id : " + id);
							pw.println("Student Name : " + name);
							pw.println("Course : " + course);
							pw.println("Deperment : " + branch);
							pw.println("Time and Date : " + timeAndDate);
							pw.println("=================================");
							pw.close();
						} else {
							String studentId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println(studentId);
						}
					}
					pw.flush();
					pw.close();
					bw.close();
					fw.close();

				} catch (Exception ex) {
					System.out.print(ex);
				}

				oldFile.delete();
				File dump = new File(file);
				newFile.renameTo(dump);

				dispose();
				ManageStudent m = new ManageStudent();
				m.setVisible(true);
			}
			}
		}
	}

	public static void main(String[] args) {
		ManageStudent book = new ManageStudent();
		book.setVisible(true);
	}

}

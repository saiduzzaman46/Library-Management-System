import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManageBook extends JFrame implements ActionListener {
	JPanel westPanel, eastPanel;
	JLabel closeLabel, backLabel, titleLabel;
	JLabel idJLabel, nameJLabel, authorJLabel, quantityJLabel;
	JLabel idiconlLabel, nameiconlLabel, authoriconlLabel, quantityiconlLabel;
	JTextField idField, nameField, authorField, quantityField;
	JButton addButton, updateButton, deleteButton;
	JTable table;
	DefaultTableModel model;
	JScrollPane pane;

	String[] column = new String[] { "Book Id", "Name", "Author", "Quantity" };
	String[] row = new String[4];
	int rowCount, columnCount;

	public ManageBook() {
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
		// =============================================================back JLabel
		backLabel = new JLabel("Back");
		backLabel.setForeground(Color.white);
		backLabel.setBounds(0, 0, 100, 30);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		westPanel.add(backLabel);

		// =============================================================backLabel
		// MouseListener
		backLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage h = new HomePage();
				h.setVisible(true);
			}
		});

		// =============================================================add JLabel west
		// panel
		// =============================================================Book id frame
		idJLabel = new JLabel("Enter Book ID : ");
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
		nameJLabel = new JLabel("Enter Book Name : ");
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

		// =============================================================Book Author name
		// Frame
		authorJLabel = new JLabel("Enter Book Author : ");
		authorJLabel.setBounds(50, 248, 140, 20);
		authorJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		authorJLabel.setForeground(Color.white);
		westPanel.add(authorJLabel);

		authorField = new JTextField();
		authorField.setBounds(50, 276, 200, 20);
		authorField.setBackground(new Color(102, 102, 255));
		authorField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		westPanel.add(authorField);

		authoriconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/author.png")));
		authoriconlLabel.setBounds(17, 275, 20, 20);
		westPanel.add(authoriconlLabel);

		// =============================================================price frame
		quantityJLabel = new JLabel("Enter Book Quantity : ");
		quantityJLabel.setBounds(50, 331, 140, 20);
		quantityJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		quantityJLabel.setForeground(Color.white);
		westPanel.add(quantityJLabel);

		quantityField = new JTextField();
		quantityField.setBounds(50, 359, 200, 20);
		quantityField.setBackground(new Color(102, 102, 255));
		quantityField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
		westPanel.add(quantityField);

		quantityiconlLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/quantity.png")));
		quantityiconlLabel.setBounds(17, 358, 20, 20);
		westPanel.add(quantityiconlLabel);

		// =============================================================add button
		addButton = new JButton("ADD");
		addButton.setBorderPainted(rootPaneCheckingEnabled);
		addButton.setBounds(30, 410, 70, 30);
		addButton.setFocusable(false);
		addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		// =============================================================close label
		closeLabel = new JLabel(new ImageIcon(getClass().getResource("/picture/close_icon.png")));
		closeLabel.setBounds(445, 5, 17, 17);
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		eastPanel.add(closeLabel);

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
		// =============================================================title Label
		titleLabel = new JLabel("Manage Book");
		titleLabel.setBounds(120, 10, 210, 50);
		titleLabel.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		titleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		titleLabel.setForeground(Color.orange);
		titleLabel.setBorder(BorderFactory.createEmptyBorder());
		titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		eastPanel.add(titleLabel);

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
		tableHeader.setBackground(Color.gray);
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Segoe UI", Font.ITALIC, 15));

		pane = new JScrollPane(table);
		pane.setBounds(10, 100, 450, 260);
		eastPanel.add(pane);

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

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent m) {
				int rowNumber = table.getSelectedRow();

				String id = model.getValueAt(rowNumber, 0).toString();
				String name = model.getValueAt(rowNumber, 1).toString();
				String author = model.getValueAt(rowNumber, 2).toString();
				String quantity = model.getValueAt(rowNumber, 3).toString();

				idField.setText(id);
				nameField.setText(name);
				authorField.setText(author);
				quantityField.setText(quantity);
			}

		});

		
	}

	public boolean validateBook() {
		String id = idField.getText();
		String name = nameField.getText();
		String author = authorField.getText();
		String quantity = quantityField.getText();

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter book id.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter book name.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (author.equals("")) {
			JOptionPane.showMessageDialog(null, "please enter book author name.", "Messages",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (quantity.equals("") || !quantity.matches("-?\\d+(\\.\\d+)?")) {
			JOptionPane.showMessageDialog(null, "please enter book quantity.", "Messages", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		return true;

	}

	public void actionPerformed(ActionEvent e) {
		// =============================================================add button
		// actionListener
		if (e.getSource() == addButton) {
			if (validateBook() == true) {
				try {
					File file = new File(".\\Data\\book_data.txt");
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fileWriter = new FileWriter(file, true);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					PrintWriter printWriter = new PrintWriter(bufferedWriter);

					LocalDateTime localDateTime = LocalDateTime.now();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
					String timeAndDate = localDateTime.format(dateFormatter);

					printWriter.println("Book ID : " + idField.getText());
					printWriter.println("Book Name : " + nameField.getText());
					printWriter.println("Book Author : " + authorField.getText());
					printWriter.println("Book Quantity : " + quantityField.getText());
					printWriter.println("Time And date : " + timeAndDate);
					printWriter.println("==========================================");
					printWriter.close();
				} catch (Exception exp) {
					System.out.println(exp);
				}
				row[0] = idField.getText();
				row[1] = nameField.getText();
				row[2] = authorField.getText();
				row[3] = quantityField.getText();
				model.addRow(row);

				idField.setText("");
				nameField.setText("");
				authorField.setText("");
				quantityField.setText("");

				JOptionPane.showMessageDialog(null, "Add Success");
			}
		}
		// =============================================================delete button
		if (e.getSource() == deleteButton) {
			
			String file = ".//Data//book_data.txt";
			String temp = ".//Data//bookTemp.txt";
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a book to delete", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String removeBook = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

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
						if (x.equals("Book ID : ")) {
							String bookId = Files.readAllLines(Paths.get(file)).get(i);
							if (bookId.substring(10).equals(removeBook)) {
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
							String bookId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println("#Removed! " + bookId);
						} else {
							String bookId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println(bookId);
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
				ManageBook book = new ManageBook();
				book.setVisible(true);
			}
		}
		// =============================================================update button
		else if (e.getSource()==updateButton) {		
			String file = ".//Data//book_data.txt";
			String temp = ".//Data//bookTemp.txt";
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a book to update", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String updateBook = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

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
						if (x.equals("Book ID : ")) {
							String bookId = Files.readAllLines(Paths.get(file)).get(i);
							if (bookId.substring(10).equals(updateBook)) {
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
								pw.println("Book ID : " + idField.getText());
								pw.println("Book Name : " + nameField.getText());
								pw.println("Book Author : " + authorField.getText());
								pw.println("Book Quantity : " + quantityField.getText());
								pw.println("Time And date : " + timeAndDate);
								pw.println("==========================================");
								break;
						} else {
							String bookId = Files.readAllLines(Paths.get(file)).get(j);
							pw.println(bookId);
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
				ManageBook book = new ManageBook();
				book.setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		ManageBook book = new ManageBook();
		book.setVisible(true);
	}

}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class userDetails extends JFrame implements ActionListener {
	JPanel titlePanel;
	JLabel closeLabel, backLabel, detailLabel,scarchLabel;
	JButton addButton, deleteButton, exiButton;
	JTextField scarchField;
	JTable table;
	DefaultTableModel model;
	JScrollPane pane;

	String[] column = new String[] { "First Name", "Last Name", "Username", "Password", "Email", "Phone" };
	String[] row = new String[6];

	public userDetails() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(700, 540);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F4F1E6"));
		// =============================================================title panel
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(204, 204, 255));
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 700, 30);
		this.add(titlePanel);
		// set back label
		backLabel = new JLabel("Back");
		backLabel.setForeground(Color.red);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		titlePanel.add(backLabel, BorderLayout.WEST);
		// backLabel MouseListener
		backLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage page = new HomePage();
				page.setVisible(true);
			}
		});

		detailLabel = new JLabel("User Details");
		detailLabel.setBounds(270, 40, 140, 30);
		detailLabel.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		detailLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		detailLabel.setForeground(Color.black);
		this.add(detailLabel);

		table = new JTable();
		model = new DefaultTableModel(0, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		table.setSelectionBackground(Color.lightGray);
		table.setRowHeight(30);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);

		JTableHeader studentTableHeader = table.getTableHeader();
		studentTableHeader.setBackground(Color.darkGray);
		studentTableHeader.setForeground(Color.white);
		studentTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));

		// add table frame
		pane = new JScrollPane(table);
		pane.setBounds(20, 140, 650, 280);
		this.add(pane);

		// ========================================add user data Jtable
		String file = ".//Data//register_data.txt";

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
					row[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13);
					row[1] = Files.readAllLines(Paths.get(file)).get(i + 1).substring(12);
					row[2] = Files.readAllLines(Paths.get(file)).get(i + 2).substring(12);
					row[3] = Files.readAllLines(Paths.get(file)).get(i + 3).substring(11);
					row[4] = Files.readAllLines(Paths.get(file)).get(i + 4).substring(8);
					row[5] = Files.readAllLines(Paths.get(file)).get(i + 5).substring(10);
					model.addRow(row);

				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		// issue date label
		scarchLabel = new JLabel("Scarch Name : ");
		scarchLabel.setForeground(Color.white);
		scarchLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		scarchLabel.setBounds(120, 100, 130, 15);
		scarchLabel.setForeground(Color.black);
		this.add(scarchLabel);
		// issue date text fild
		scarchField = new JTextField();
		scarchField.setBounds(240, 95, 200, 30);
		scarchField.setFont(new Font("Arial", Font.ITALIC, 17));
		this.add(scarchField);

		scarchField.getDocument().addDocumentListener(new DocumentListener() {
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

		TableRowSorter sorter = new TableRowSorter<>(model);
		table.setRowSorter(sorter);

		// scarch table data
		sorter.setRowFilter(new RowFilter() {
			public boolean include(Entry entry) {
				String name =entry.getValue(2).toString().toUpperCase().toLowerCase();
				String scarch = scarchField.getText();
				return name.startsWith(scarch);
			}
		});


		// // add button
		// addButton = new JButton("ADD");
		// addButton.setBounds(150, 390, 100, 30);
		// addButton.setFocusable(false);
		// addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// addButton.setBackground(Color.decode("#2E67F8"));
		// addButton.setForeground(Color.white);
		// this.add(addButton);

		// delete button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(200, 450, 130, 30);
		deleteButton.setFocusable(false);
		deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		deleteButton.setBackground(Color.decode("#2E67F8"));
		deleteButton.setForeground(Color.white);
		this.add(deleteButton);

		// exit button
		exiButton = new JButton("Exit");
		exiButton.setBounds(350, 450, 130, 30);
		exiButton.setFocusable(false);
		exiButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exiButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		exiButton.setBackground(Color.decode("#2E67F8"));
		exiButton.setForeground(Color.white);
		this.add(exiButton);

		deleteButton.addActionListener(this);
		exiButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteButton) {
			String file1 = ".//Data//register_data.txt";
			String temp1 = ".//Data//temp.txt";
			if (table.getSelectionModel().isSelectionEmpty()) {
				JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

				File oldFile = new File(file1);
				File newFile = new File(temp1);

				int q = 0;

				try {

					BufferedReader reader = new BufferedReader(new FileReader(file1));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int i = 0; i < totalLines; i++) {
						String line = Files.readAllLines(Paths.get(file1)).get(i);
						String x = line.substring(0, 10);
						if (x.equals("First Name")) {
							String firstName = Files.readAllLines(Paths.get(file1)).get(i);
							if (firstName.substring(13).equals(removeUser)) {
								q = i;

							}
						}
					}
				} catch (Exception ex) {
					return;
				}
				try {

					FileWriter fw = new FileWriter(temp1, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);

					BufferedReader reader = new BufferedReader(new FileReader(file1));
					int totalLines = 0;
					while (reader.readLine() != null)
						totalLines++;
					reader.close();

					for (int j = 0; j < totalLines; j++) {
						if ((j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4)
								|| j == (q + 5) || j == (q + 6))) {
							String firstName = Files.readAllLines(Paths.get(file1)).get(j);
							pw.println("#Removed! " + firstName);
						} else {
							String firstName = Files.readAllLines(Paths.get(file1)).get(j);
							pw.println(firstName);
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
				File dump = new File(file1);
				newFile.renameTo(dump);

				dispose();
				userDetails user = new userDetails();
				user.setVisible(true);
			}
		}
		if (e.getSource() == exiButton) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to close now?\n", "Message",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		userDetails user = new userDetails();
		user.setVisible(true);
	}

}
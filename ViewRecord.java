import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;

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

public class ViewRecord extends JFrame implements MouseListener {
	JPanel titlePanel, centerPanel;
	JLabel closeLabel, backLabel, issueBookDetails, scarchLabel;
	JTextField scarchField;
	JButton searchButton;
	JTable issueDetailsTable;
	DefaultTableModel defaultTableModel;
	JScrollPane jScrollPane;
	public String[] column = new String[] { "Issue Id", "Book Name", "Student Name", "Issue Date", "Due Date" };
	public String[] row = new String[5];
	int rowCount, columnCount;

	public ViewRecord() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(700, 550);
		this.setLocationRelativeTo(null);
		Container c = new Container();
		c = this.getContentPane();
		c.setLayout(new BorderLayout());
		// title panel
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.decode("#2E67F8"));
		titlePanel.setPreferredSize(new Dimension(50, 150));
		titlePanel.setLayout(null);
		c.add(titlePanel, BorderLayout.NORTH);
		// set close label
		closeLabel = new JLabel();
		closeLabel.setBounds(670, 0, 100, 20);
		closeLabel.setIcon(new ImageIcon(getClass().getResource("/picture/close_icon.png")));
		closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		titlePanel.add(closeLabel);
		// set back label
		backLabel = new JLabel("Back");
		backLabel.setBounds(0, 0, 100, 20);
		backLabel.setForeground(Color.red);
		backLabel.setFont(new Font("Arial", Font.BOLD, 15));
		backLabel.setIcon(new ImageIcon(getClass().getResource("/picture/back.png")));
		backLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		titlePanel.add(backLabel, BorderLayout.WEST);

		// issu book title
		issueBookDetails = new JLabel("Issue Book Details");
		issueBookDetails.setBounds(260, 10, 220, 50);
		issueBookDetails.setIcon(new ImageIcon(getClass().getResource("/picture/Mbooktitle.png")));
		issueBookDetails.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		issueBookDetails.setForeground(Color.white);
		issueBookDetails.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		titlePanel.add(issueBookDetails);

		// issue date label
		scarchLabel = new JLabel("Scarch Name : ");
		scarchLabel.setForeground(Color.white);
		scarchLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		scarchLabel.setBounds(180, 100, 130, 15);
		titlePanel.add(scarchLabel);
		// issue date text fild
		scarchField = new JTextField();
		scarchField.setBounds(300, 95, 200, 30);
		scarchField.setFont(new Font("Arial", Font.ITALIC, 17));
		titlePanel.add(scarchField);

		// // due date label
		// dateLabel = new JLabel("Due Date : ");
		// dateLabel.setForeground(Color.white);
		// dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		// dateLabel.setBounds(280, 110, 105, 15);
		// titlePanel.add(dateLabel);
		// // due date text fild
		// issuDatField = new JTextField();
		// issuDatField.setBounds(360, 108, 150, 25);
		// issuDatField.setFont(new Font("Arial", Font.ITALIC, 17));
		// titlePanel.add(issuDatField);

		// searchButton = new JButton("Search");
		// searchButton.setBounds(540, 105, 100, 30);
		// searchButton.setBackground(Color.red);
		// searchButton.setForeground(Color.white);
		// titlePanel.add(searchButton);

		// center panel
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBackground(Color.white);
		c.add(centerPanel, BorderLayout.CENTER);

		issueDetailsTable = new JTable();
		defaultTableModel = new DefaultTableModel(rowCount, columnCount) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		defaultTableModel.setColumnIdentifiers(column);
		issueDetailsTable.setModel(defaultTableModel);
		issueDetailsTable.setSelectionBackground(Color.CYAN);
		issueDetailsTable.setRowHeight(30);

		issueDetailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		issueDetailsTable.getColumnModel().getColumn(0).setPreferredWidth(115);
		issueDetailsTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		issueDetailsTable.getColumnModel().getColumn(2).setPreferredWidth(170);
		issueDetailsTable.getColumnModel().getColumn(3).setPreferredWidth(115);
		issueDetailsTable.getColumnModel().getColumn(4).setPreferredWidth(117);

		JTableHeader bookTableHeader = issueDetailsTable.getTableHeader();
		bookTableHeader.setBackground(Color.decode("#2E67F8"));
		bookTableHeader.setForeground(Color.white);
		bookTableHeader.setFont(new Font("Segoe UI", Font.BOLD, 14));

		jScrollPane = new JScrollPane(issueDetailsTable);
		jScrollPane.setBounds(15, 50, 670, 300);
		centerPanel.add(jScrollPane);

		String file = ".\\Data\\Issue_data.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader.readLine() != null)
				totalLines++;
			reader.close();
			for (int i = 0; i < totalLines; i++) {
				String lines = Files.readAllLines(Paths.get(file)).get(i);
				String a = lines.substring(0, 10);
				if (a.equals("Student ID")) {
					row[0] = Files.readAllLines(Paths.get(file)).get(i + 2).substring(11);
					row[1] = Files.readAllLines(Paths.get(file)).get(i + 3).substring(12);
					row[2] = Files.readAllLines(Paths.get(file)).get(i + 4).substring(15);
					row[3] = Files.readAllLines(Paths.get(file)).get(i + 5).substring(13);
					row[4] = Files.readAllLines(Paths.get(file)).get(i + 6).substring(11);
					defaultTableModel.addRow(row);

				}

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		//====================================scarch issue user name

		scarchField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				defaultTableModel.fireTableDataChanged();
			}

			public void removeUpdate(DocumentEvent e) {
				defaultTableModel.fireTableDataChanged();
			}

			public void changedUpdate(DocumentEvent e) {
				defaultTableModel.fireTableDataChanged();
			}
		});

		TableRowSorter sorter = new TableRowSorter<>(defaultTableModel);
		issueDetailsTable.setRowSorter(sorter);

		// scarch table data
		sorter.setRowFilter(new RowFilter() {
			public boolean include(Entry entry) {
				String name =entry.getValue(2).toString().toUpperCase().toLowerCase();
				String scarch = scarchField.getText();
				return name.startsWith(scarch);
			}
		});

		//add mouselistener
		backLabel.addMouseListener(this);
		closeLabel.addMouseListener(this);

	}

	public static void main(String[] args) {
		ViewRecord book = new ViewRecord();
		book.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == backLabel) {
			dispose();
			HomePage h = new HomePage();
			h.setVisible(true);
		}
		if (e.getSource() == closeLabel) {
			int a = JOptionPane.showConfirmDialog(null, "Do you want to close now?\n", "Message",
					JOptionPane.YES_NO_OPTION);
			if (a == 0) {
				System.exit(0);
			}
		}

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
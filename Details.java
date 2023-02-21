import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Details extends JFrame {
	JLabel titleJLabel, nameJLabel, idJLabel, batchJLabel, picJLabel;
	JLabel headerJLabel, contactJLabel, otherMemberJLabel;
	ImageIcon icon;

	public Details() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(570, 450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setUndecorated(true);
		this.getContentPane().setBackground(Color.decode("#2E67F8"));

		// =============================================================title label
		titleJLabel = new JLabel("OOP-1 FINAL PROJECT");
		titleJLabel.setBounds(70, 10, 420, 50);
		titleJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 40));
		titleJLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		titleJLabel.setForeground(Color.white);
		this.add(titleJLabel);

		// =============================================================header label
		headerJLabel = new JLabel("Project Head-");
		headerJLabel.setBounds(20, 80, 130, 35);
		headerJLabel.setForeground(Color.white);
		headerJLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		headerJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		this.add(headerJLabel);
		// =============================================================name label
		nameJLabel = new JLabel("Name : Md.Saiduzzaman Sohag");
		nameJLabel.setBounds(10, 130, 350, 30);
		nameJLabel.setForeground(Color.white);
		nameJLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		this.add(nameJLabel);

		// =============================================================id label
		idJLabel = new JLabel("Id : 22-46006-1");
		idJLabel.setBounds(10, 170, 200, 30);
		idJLabel.setForeground(Color.white);
		idJLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		this.add(idJLabel);

		// =============================================================batch label
		batchJLabel = new JLabel("Batch : 2021-2022 Spring");
		batchJLabel.setBounds(10, 210, 300, 30);
		batchJLabel.setForeground(Color.white);
		batchJLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		this.add(batchJLabel);

		// =============================================================contact label
		contactJLabel = new JLabel("Contact : saiduzzamansohag0@gmail.com");
		contactJLabel.setBounds(10, 250, 400, 30);
		contactJLabel.setForeground(Color.white);
		contactJLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		this.add(contactJLabel);
		// =============================================================picture label
		icon = new ImageIcon(getClass().getResource("/picture/22-46006-1.png"));
		picJLabel = new JLabel(icon);
		picJLabel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
		picJLabel.setBounds(400, 140, icon.getIconWidth(), icon.getIconHeight());
		this.add(picJLabel);

		// =============================================================other member
		// label
		otherMemberJLabel = new JLabel("Faculty...");
		otherMemberJLabel.setBounds(180, 340, 200, 30);
		otherMemberJLabel.setForeground(Color.white);
		otherMemberJLabel.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		this.add(otherMemberJLabel);

		// =============================================================other member
		// MouseListener
		otherMemberJLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				faculty f = new faculty();
				f.setVisible(true);
			}
		});

	}

	public static void main(String[] args) {
		Details details = new Details();
		details.setVisible(true);
	}

}

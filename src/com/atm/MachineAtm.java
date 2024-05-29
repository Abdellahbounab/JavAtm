package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MachineAtm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginField;
	private JButton signUp;
	private JPasswordField passwordField;
	private UserInterface  userMenu = null;
	private Admin me = new Admin("A000000");
	private AdminInterface adminMenu = new AdminInterface(me);
	private JLabel passwordNotif;
	private JPanel panel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MachineAtm frame = new MachineAtm();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MachineAtm() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginField = new JTextField();
		loginField.setFont(new Font("Arial", Font.PLAIN, 15));
		loginField.setBounds(96, 116, 259, 32);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(96, 96, 259, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblMotDePasse.setBounds(96, 169, 259, 19);
		contentPane.add(lblMotDePasse);
		
		signUp = new JButton("Sign up");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginField.getText().equals("admin") && passwordField.getText().equals("admin")) {
					adminMenu.setLocationRelativeTo(null);
					adminMenu.setVisible(true);
					setVisible(false);
					dispose();
				}
				else if (me.getSql().checkUser(loginField.getText(), passwordField.getText()) == 1){
					User prs = me.getSql().getUser(loginField.getText());
					prs.setAccount(me.getSql().getAccount(prs));
					userMenu = new UserInterface(prs);
					userMenu.setLocationRelativeTo(MachineAtm.this);
					userMenu.setVisible(true);
					setVisible(false);
					dispose();
				}
				else
					passwordNotif.setText("Wrong Login or Password");
			}
		});
		signUp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		signUp.setBounds(163, 257, 131, 41);
		contentPane.add(signUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 189, 259, 32);
		contentPane.add(passwordField);
		
		passwordNotif = new JLabel("");
		passwordNotif.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		passwordNotif.setBounds(96, 232, 259, 14);
		contentPane.add(passwordNotif);
		
		panel = new JPanel();
		panel.setBounds(150, 11, 162, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Abdellah Bounab\\Desktop\\JavAtm\\atm2-removebg-preview.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 162, 88);
		panel.add(lblNewLabel_1);
	}
}

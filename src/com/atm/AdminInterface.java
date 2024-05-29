package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem createClient;
	private JMenuItem updateClient;
	private JMenuItem deleteClient;
	private JMenuItem printerClient;
	private JMenuItem printerAll;
	private JPanel panel;
	private JPanel panel_1;
	private JMenuItem historyClient_1;
	private JLabel lblNewLabel;
	private JLabel lblBankBalance;
	private JLabel userCounter;
	private JLabel bankCounter;
	private JMenuItem configureAdmin;
	private JMenuItem logOutAdmin;
	private JMenu adminMenu;
	private JMenu clientMenu;
	private JMenu historyMenu;
	private JMenu mnNewMenu;
	private JMenu helpMenu;
	private JLabel dateUpdater;
	private JInternalFrame configPanel;
	private JPasswordField newPassword;
	private JPasswordField confirmPassword;
	private JPasswordField passwordField_2;
	private JButton btnReturn;
	private JButton changePassword;
	private Admin me = new Admin("A000000");
	
	private clientConfiguration clientConf = null;
	private JButton refreshBtn;
	private JLabel lblNewLabel_1;
	private JLabel timeUpdater;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminInterface frame = new AdminInterface();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminInterface(Admin adm) {
		setTitle("Admin Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 353);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		adminMenu = new JMenu("Admin");
		menuBar.add(adminMenu);
		
		configureAdmin = new JMenuItem("configuration");
		configureAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configPanel.setVisible(true);
			}
		});
		adminMenu.add(configureAdmin);
		
		logOutAdmin = new JMenuItem("Logout");
		logOutAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MachineAtm reload = new MachineAtm();
				reload.setLocationRelativeTo(AdminInterface.this);
				setVisible(false);
				reload.setVisible(true);
				dispose();
			}
		});
		adminMenu.add(logOutAdmin);
		
		clientMenu = new JMenu("Clients");
		menuBar.add(clientMenu);
		
		createClient = new JMenuItem("Create Client");
		createClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientConf = new clientConfiguration(null, "Creation");
				clientConf.setLocationRelativeTo(null);
				clientConf.setVisible(true);
			}
		});
		clientMenu.add(createClient);
		
		updateClient = new JMenuItem("Update Client");
		updateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = JOptionPane.showInputDialog("Enter Client's login:");
				if (adm.getSql().checkUser(login) != 0)
				{
					clientConf = new clientConfiguration(adm.getSql().getUser(login), "Update");
					clientConf.setLocationRelativeTo(null);
					clientConf.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Login not found...");
					
			}
		});
		clientMenu.add(updateClient);
		
		deleteClient = new JMenuItem("Delete Client");
		deleteClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = JOptionPane.showInputDialog("Enter Client's login:");
				if (adm.getSql().checkUser(login) != 0)
				{
					clientConf = new clientConfiguration(adm.getSql().getUser(login), "Delete");
					clientConf.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "Login not found...");
			}
		});
		clientMenu.add(deleteClient);
		
		historyMenu = new JMenu("Tables");
		menuBar.add(historyMenu);
		
		historyClient_1 = new JMenuItem("by Client");
		historyClient_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablesInterface table = new tablesInterface("Accounts", adm);
				table.setVisible(true);
				table.setLocationRelativeTo(AdminInterface.this);
			}
		});
		historyMenu.add(historyClient_1);
		
		mnNewMenu = new JMenu("Printer");
		menuBar.add(mnNewMenu);
		
		printerClient = new JMenuItem("Client");
		mnNewMenu.add(printerClient);
		
		printerAll = new JMenuItem("ALL");
		mnNewMenu.add(printerAll);
		
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem aboutUs = new JMenuItem("About Us");
		helpMenu.add(aboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		configPanel = new JInternalFrame("Configuration");
		configPanel.setBounds(285, 16, 204, 265);
		contentPane.add(configPanel);
		configPanel.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		configPanel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("New Password :");
		lblNewLabel_3_2_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_2_1.setBounds(10, 75, 127, 20);
		configPanel.getContentPane().add(lblNewLabel_3_2_2_1);
		
		newPassword = new JPasswordField();
		newPassword.setFont(new Font("Courier New", Font.PLAIN, 10));
		newPassword.setColumns(10);
		newPassword.setBounds(30, 92, 141, 21);
		configPanel.getContentPane().add(newPassword);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setFont(new Font("Courier New", Font.PLAIN, 10));
		confirmPassword.setColumns(10);
		confirmPassword.setBounds(30, 119, 141, 21);
		configPanel.getContentPane().add(confirmPassword);
		
		JLabel oldPassword = new JLabel("Old Password :");
		oldPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		oldPassword.setBounds(10, 26, 127, 20);
		configPanel.getContentPane().add(oldPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Courier New", Font.PLAIN, 10));
		passwordField_2.setColumns(10);
		passwordField_2.setBounds(30, 43, 141, 21);
		configPanel.getContentPane().add(passwordField_2);
		
		changePassword = new JButton("Confirm");
		changePassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		changePassword.setBounds(50, 161, 97, 30);
		configPanel.getContentPane().add(changePassword);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configPanel.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnReturn.setBounds(50, 195, 97, 30);
		configPanel.getContentPane().add(btnReturn);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(56, 87, 153, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Users");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(15, 7, 123, 20);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		userCounter = new JLabel(String.valueOf(me.getSql().userCounter()));
		userCounter.setHorizontalAlignment(SwingConstants.CENTER);
		userCounter.setBounds(15, 38, 123, 88);
		userCounter.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panel.add(userCounter);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.info);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(230, 87, 250, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblBankBalance = new JLabel("Bank Balance");
		lblBankBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankBalance.setBounds(10, 7, 230, 20);
		lblBankBalance.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		panel_1.add(lblBankBalance);
		
		bankCounter = new JLabel(NumberFormat.getCurrencyInstance(new Locale("fr", "MA")).format(me.getSql().soldeCounter()));
		bankCounter.setHorizontalAlignment(SwingConstants.CENTER);
		bankCounter.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		bankCounter.setBounds(10, 38, 230, 88);
		panel_1.add(bankCounter);
		
		dateUpdater = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
		dateUpdater.setHorizontalAlignment(SwingConstants.CENTER);
		dateUpdater.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		dateUpdater.setBounds(262, 11, 256, 20);
		contentPane.add(dateUpdater);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminInterface newwindow = new AdminInterface(new Admin("M000000"));
				newwindow.setVisible(true);
				newwindow.setLocationRelativeTo(AdminInterface.this);
				setVisible(false);
				dispose();
			}
		});
		refreshBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		refreshBtn.setBounds(10, 251, 97, 30);
		contentPane.add(refreshBtn);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Abdellah Bounab\\Desktop\\JavAtm\\atm2-removebg-preview.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 0, 175, 70);
		contentPane.add(lblNewLabel_1);
		
		timeUpdater = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
		timeUpdater.setHorizontalAlignment(SwingConstants.CENTER);
		timeUpdater.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		timeUpdater.setBounds(327, 30, 129, 20);
		contentPane.add(timeUpdater);
	}
}

package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem createClient;
	private JMenuItem updateClient;
	private JMenuItem listClient;
	private JMenuItem deleteClient;
	private JMenuItem printerClient;
	private JMenuItem printerAll;
	private JPanel panel;
	private JPanel panel_1;
	private JMenuItem historyClient_1;
	private JMenuItem historyOperations_1;
	private JMenuItem historyAll_1;
	private JLabel lblNewLabel;
	private JLabel lblBankBalance;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JMenuItem configureAdmin;
	private JMenuItem logOutAdmin;
	private JMenu adminMenu;
	private JMenu clientMenu;
	private JMenu historyMenu;
	private JMenu mnNewMenu;
	private JMenu helpMenu;
	private JLabel dateTimeUpdater;
	private JInternalFrame crudClient;
	private JLabel lblNewLabel_3;
	private JTextField cinField;
	private JLabel lblNewLabel_4;
	private JTextField nomField;
	private JLabel lblNewLabel_5;
	private JTextField prenomField;
	private JTextField birthCity;
	private JTextField nationality;
	private JTextField textField;
	private JPasswordField passwordNew;
	private JPasswordField passwodConfirm;
	private JLabel lblNewLabel_3_2_3;
	private JLabel lblNewLabel_3_2_4;
	private JLabel lblNewLabel_5_3;
	private JComboBox gendreChoice_1;
	private JLabel lblNewLabel_6;
	private JSpinner textField_1;
	private JLabel lblNewLabel_3_2_5;
	private JButton btnCreateClient;
	private JInternalFrame accountNew;
	private JSpinner textField_1_1;
	private JTextArea textArea;
	private JComboBox gendreChoice;
	private JButton btnNext;
	private JButton btnReturn;
	private JButton btnReturn_1;

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
					AdminInterface frame = new AdminInterface();
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
	public AdminInterface() {
		setTitle("Admin Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		adminMenu = new JMenu("Admin");
		menuBar.add(adminMenu);
		
		configureAdmin = new JMenuItem("configuration");
		adminMenu.add(configureAdmin);
		
		logOutAdmin = new JMenuItem("Logout");
		adminMenu.add(logOutAdmin);
		
		clientMenu = new JMenu("Clients");
		menuBar.add(clientMenu);
		
		createClient = new JMenuItem("Create Client");
		createClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudClient.setVisible(true);
			}
		});
		clientMenu.add(createClient);
		
		updateClient = new JMenuItem("Update Client");
		clientMenu.add(updateClient);
		
		listClient = new JMenuItem("List of Clients");
		clientMenu.add(listClient);
		
		deleteClient = new JMenuItem("Delete Client");
		clientMenu.add(deleteClient);
		
		historyMenu = new JMenu("History");
		menuBar.add(historyMenu);
		
		historyClient_1 = new JMenuItem("by Client");
		historyMenu.add(historyClient_1);
		
		historyOperations_1 = new JMenuItem("by Operations");
		historyMenu.add(historyOperations_1);
		
		historyAll_1 = new JMenuItem("All");
		historyMenu.add(historyAll_1);
		
		mnNewMenu = new JMenu("Printer");
		menuBar.add(mnNewMenu);
		
		printerClient = new JMenuItem("Client");
		mnNewMenu.add(printerClient);
		
		printerAll = new JMenuItem("ALL");
		mnNewMenu.add(printerAll);
		
		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		crudClient = new JInternalFrame("Client");
		crudClient.setBounds(10, 0, 485, 434);
		contentPane.add(crudClient);
		crudClient.getContentPane().setLayout(null);
		
		accountNew = new JInternalFrame("New Account");
		accountNew.setBounds(120, 11, 237, 321);
		crudClient.getContentPane().add(accountNew);
		accountNew.getContentPane().setLayout(null);
		
		lblNewLabel_3_2_3 = new JLabel("Login :");
		lblNewLabel_3_2_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3_2_3.setBounds(20, 11, 127, 20);
		accountNew.getContentPane().add(lblNewLabel_3_2_3);
		
		lblNewLabel_3_2_4 = new JLabel("userName");
		lblNewLabel_3_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3_2_4.setBounds(41, 31, 127, 20);
		accountNew.getContentPane().add(lblNewLabel_3_2_4);
		
		lblNewLabel_5_3 = new JLabel("Gender :");
		lblNewLabel_5_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_3.setBounds(20, 68, 79, 23);
		accountNew.getContentPane().add(lblNewLabel_5_3);
		
		gendreChoice_1 = new JComboBox();
		gendreChoice_1.setModel(new DefaultComboBoxModel(new String[] {"Current account", "Savings account"}));
		gendreChoice_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		gendreChoice_1.setBounds(20, 90, 177, 26);
		accountNew.getContentPane().add(gendreChoice_1);
		
		lblNewLabel_6 = new JLabel("Solde :");
		lblNewLabel_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(20, 127, 79, 23);
		accountNew.getContentPane().add(lblNewLabel_6);
		
		textField_1 = new JSpinner();
		textField_1.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(100)));
		textField_1.setFont(new Font("Courier New", Font.PLAIN, 13));
		textField_1.setBounds(20, 151, 148, 23);
		accountNew.getContentPane().add(textField_1);
		
		lblNewLabel_3_2_5 = new JLabel("MAD");
		lblNewLabel_3_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3_2_5.setBounds(168, 150, 53, 20);
		accountNew.getContentPane().add(lblNewLabel_3_2_5);
		
		btnCreateClient = new JButton("Create");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountNew.setVisible(false);
				crudClient.setVisible(false);
			}
		});
		btnCreateClient.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnCreateClient.setBounds(52, 201, 127, 27);
		accountNew.getContentPane().add(btnCreateClient);
		
		btnReturn_1 = new JButton("Return");
		btnReturn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountNew.setVisible(false);
			}
		});
		btnReturn_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnReturn_1.setBounds(52, 239, 127, 27);
		accountNew.getContentPane().add(btnReturn_1);
		
		lblNewLabel_3 = new JLabel("CIN :");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(31, 26, 79, 23);
		crudClient.getContentPane().add(lblNewLabel_3);
		
		cinField = new JTextField();
		cinField.setFont(new Font("Courier New", Font.PLAIN, 13));
		cinField.setBounds(31, 50, 145, 23);
		crudClient.getContentPane().add(cinField);
		cinField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Nom :");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(31, 76, 79, 23);
		crudClient.getContentPane().add(lblNewLabel_4);
		
		nomField = new JTextField();
		nomField.setFont(new Font("Courier New", Font.PLAIN, 13));
		nomField.setColumns(10);
		nomField.setBounds(31, 100, 145, 23);
		crudClient.getContentPane().add(nomField);
		
		lblNewLabel_5 = new JLabel("Prenom :");
		lblNewLabel_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(31, 123, 79, 23);
		crudClient.getContentPane().add(lblNewLabel_5);
		
		prenomField = new JTextField();
		prenomField.setFont(new Font("Courier New", Font.PLAIN, 13));
		prenomField.setColumns(10);
		prenomField.setBounds(31, 147, 145, 23);
		crudClient.getContentPane().add(prenomField);
		
		JLabel lblNewLabel_5_1 = new JLabel("Date de Naissance :");
		lblNewLabel_5_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(31, 174, 145, 23);
		crudClient.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Gender :");
		lblNewLabel_5_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(241, 123, 79, 23);
		crudClient.getContentPane().add(lblNewLabel_5_2);
		
		gendreChoice = new JComboBox();
		gendreChoice.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gendreChoice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		gendreChoice.setBounds(241, 145, 177, 26);
		crudClient.getContentPane().add(gendreChoice);
		
		JLabel lblNewLabel_3_1 = new JLabel("Addresse  :");
		lblNewLabel_3_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(241, 26, 145, 23);
		crudClient.getContentPane().add(lblNewLabel_3_1);
		
		textArea = new JTextArea();
		textArea.setBounds(241, 49, 177, 74);
		crudClient.getContentPane().add(textArea);
		
		JLabel lblNewLabel_3_2 = new JLabel("Birth City :");
		lblNewLabel_3_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(31, 221, 79, 23);
		crudClient.getContentPane().add(lblNewLabel_3_2);
		
		birthCity = new JTextField();
		birthCity.setFont(new Font("Courier New", Font.PLAIN, 13));
		birthCity.setColumns(10);
		birthCity.setBounds(31, 245, 145, 23);
		crudClient.getContentPane().add(birthCity);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Nationality :");
		lblNewLabel_3_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(31, 274, 145, 23);
		crudClient.getContentPane().add(lblNewLabel_3_2_1);
		
		nationality = new JTextField();
		nationality.setFont(new Font("Courier New", Font.PLAIN, 13));
		nationality.setColumns(10);
		nationality.setBounds(31, 298, 145, 23);
		crudClient.getContentPane().add(nationality);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setForeground(SystemColor.info);
		panel_2.setBounds(241, 174, 177, 147);
		crudClient.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("New Login :");
		lblNewLabel_3_2_2.setBounds(6, 6, 127, 20);
		lblNewLabel_3_2_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_3_2_2);
		
		textField = new JTextField();
		textField.setBounds(26, 23, 141, 21);
		textField.setFont(new Font("Courier New", Font.PLAIN, 12));
		textField.setColumns(10);
		panel_2.add(textField);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("New Password :");
		lblNewLabel_3_2_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_2_1.setBounds(6, 49, 127, 20);
		panel_2.add(lblNewLabel_3_2_2_1);
		
		passwordNew = new JPasswordField();
		passwordNew.setFont(new Font("Courier New", Font.PLAIN, 10));
		passwordNew.setColumns(10);
		passwordNew.setBounds(26, 66, 141, 21);
		panel_2.add(passwordNew);
		
		passwodConfirm = new JPasswordField();
		passwodConfirm.setFont(new Font("Courier New", Font.PLAIN, 10));
		passwodConfirm.setColumns(10);
		passwodConfirm.setBounds(26, 93, 141, 21);
		panel_2.add(passwodConfirm);
		
		textField_1_1 = new JSpinner();
		textField_1_1.setModel(new SpinnerDateModel(new java.util.Date(1716505200000L), new java.util.Date(1716505200000L), null, Calendar.DAY_OF_YEAR));
		textField_1_1.setFont(new Font("Courier New", Font.PLAIN, 12));
		textField_1_1.setBounds(31, 199, 145, 23);
		crudClient.getContentPane().add(textField_1_1);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountNew.setVisible(true);;
			}
		});
		btnNext.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNext.setBounds(241, 336, 127, 27);
		crudClient.getContentPane().add(btnNext);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crudClient.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnReturn.setBounds(85, 336, 127, 27);
		crudClient.getContentPane().add(btnReturn);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(90, 87, 153, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Users");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(15, 7, 123, 20);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 38, 123, 88);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.info);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(327, 87, 153, 153);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblBankBalance = new JLabel("Bank Balance");
		lblBankBalance.setBounds(30, 7, 93, 20);
		lblBankBalance.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		panel_1.add(lblBankBalance);
		
		lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 38, 133, 88);
		panel_1.add(lblNewLabel_2);
		
		dateTimeUpdater = new JLabel("5/23/2024 11:47 PM");
		dateTimeUpdater.setHorizontalAlignment(SwingConstants.CENTER);
		dateTimeUpdater.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		dateTimeUpdater.setBounds(207, 11, 163, 20);
		contentPane.add(dateTimeUpdater);
	}
}

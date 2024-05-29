package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class clientConfiguration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cinField;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField cityBirthField;
	private JTextField nationalityField;
	private JTextField newLoginField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JInternalFrame accountNew;
	private JComboBox typeChoice;
	private JLabel loginLabel;
	private JSpinner soldeField;
	private JButton btnCreateClient;
	private JButton btnReturn_1;
	private Admin me = new Admin("A000000");
	private JComboBox gendreChoice;
	private JTextArea addressField;
	private JSpinner dateField;
	private JPanel newCreationPanel;
	private JButton btnNext;
	private JButton btnReturn;
	private JLabel loginExist;

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
//					clientConfiguration frame = new clientConfiguration();
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
	public clientConfiguration(User prs, String operation) {
		setTitle(operation);
		setBounds(100, 100, 495, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		accountNew = new JInternalFrame("New Account");
		accountNew.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		accountNew.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Login :");
		lblNewLabel_3_2_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3_2_3.setBounds(20, 11, 127, 20);
		accountNew.getContentPane().add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_5_3 = new JLabel("Account type :");
		lblNewLabel_5_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_3.setBounds(20, 68, 116, 23);
		accountNew.getContentPane().add(lblNewLabel_5_3);
		
		typeChoice = new JComboBox();
		typeChoice.setModel(new DefaultComboBoxModel(new String[] {"Current", "Savings"}));
		typeChoice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		typeChoice.setBounds(20, 90, 177, 26);
		accountNew.getContentPane().add(typeChoice);
		
		JLabel lblNewLabel_6 = new JLabel("Solde :");
		lblNewLabel_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(20, 127, 79, 23);
		accountNew.getContentPane().add(lblNewLabel_6);
		
		soldeField = new JSpinner();
		soldeField.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(100)));
		soldeField.setFont(new Font("Courier New", Font.PLAIN, 13));
		soldeField.setBounds(20, 151, 148, 23);
		accountNew.getContentPane().add(soldeField);
		
		JLabel lblNewLabel_3_2_5 = new JLabel("MAD");
		lblNewLabel_3_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_3_2_5.setBounds(168, 150, 53, 20);
		accountNew.getContentPane().add(lblNewLabel_3_2_5);
		
		btnCreateClient = new JButton("Create");
		btnCreateClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person pr = new Person(cinField.getText(), nomField.getText(), prenomField.getText(), gendreChoice.getSelectedItem().toString(), nationalityField.getText());
				if (me.getSql().insertPerson(pr) == 1) {
					if (me.getSql().insertUser(new User(pr, newLoginField.getText(), newPasswordField.getText())) == 1) {
						me.getSql().insertAccount(new Account(newLoginField.getText(), (double)soldeField.getValue(), typeChoice.getSelectedItem().toString()));
						setVisible(false); //you can't see me!
						dispose(); 
					}
//					a condition where it does shows that person exist already
//					System.out.println(pr.ToString());
//					System.out.println(us.ToString());
				}
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
		accountNew.setBounds(70, 26, 237, 321);
		contentPane.add(accountNew);
		
		JLabel lblNewLabel_3 = new JLabel("CIN :");
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(32, 26, 79, 23);
		contentPane.add(lblNewLabel_3);
		
		cinField = new JTextField();
		cinField.setEditable(false);
		if (operation.equals("Creation"))
			cinField.setEditable(true);
		else
			cinField.setText(prs.getCIN());
		cinField.setFont(new Font("Courier New", Font.PLAIN, 13));
		cinField.setColumns(10);
		cinField.setBounds(32, 50, 145, 23);
		contentPane.add(cinField);
		
		JLabel lblNewLabel_4 = new JLabel("Nom :");
		lblNewLabel_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(32, 76, 79, 23);
		contentPane.add(lblNewLabel_4);
		
		nomField = new JTextField();
		nomField.setEditable(false);
		if (operation.equals("Creation"))
			nomField.setEditable(true);
		else
			nomField.setText(prs.getName());
		nomField.setFont(new Font("Courier New", Font.PLAIN, 13));
		nomField.setColumns(10);
		nomField.setBounds(32, 100, 145, 23);
		contentPane.add(nomField);
		
		JLabel lblNewLabel_5 = new JLabel("Prenom :");
		lblNewLabel_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(32, 123, 79, 23);
		contentPane.add(lblNewLabel_5);
		
		prenomField = new JTextField();
		prenomField.setEditable(false);
		if (operation.equals("Creation"))
			prenomField.setEditable(true);
		else
			prenomField.setText(prs.getPrenom());
		prenomField.setFont(new Font("Courier New", Font.PLAIN, 13));
		prenomField.setColumns(10);
		prenomField.setBounds(32, 147, 145, 23);
		contentPane.add(prenomField);
		
		JLabel lblNewLabel_5_1 = new JLabel("Date de Naissance :");
		lblNewLabel_5_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_1.setBounds(32, 174, 145, 23);
		contentPane.add(lblNewLabel_5_1);
		
		dateField = new JSpinner();
		dateField.setModel(new SpinnerDateModel(new Date(1716505200000L), new Date(1716505200000L), null, Calendar.DAY_OF_YEAR));
		dateField.setFont(new Font("Courier New", Font.PLAIN, 12));
		dateField.setBounds(32, 199, 145, 23);
		contentPane.add(dateField);
		
		JLabel lblNewLabel_3_2 = new JLabel("Birth City :");
		lblNewLabel_3_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(32, 221, 79, 23);
		contentPane.add(lblNewLabel_3_2);
		
		cityBirthField = new JTextField();
		cityBirthField.setFont(new Font("Courier New", Font.PLAIN, 13));
		cityBirthField.setColumns(10);
		cityBirthField.setBounds(32, 245, 145, 23);
		contentPane.add(cityBirthField);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Nationality :");
		lblNewLabel_3_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(32, 274, 145, 23);
		contentPane.add(lblNewLabel_3_2_1);
		
		nationalityField = new JTextField();
		nationalityField.setEditable(false);
		if (operation.equals("Creation"))
			nationalityField.setEditable(true);
		else
			nationalityField.setText(prs.getNationality());
		nationalityField.setFont(new Font("Courier New", Font.PLAIN, 13));
		nationalityField.setColumns(10);
		nationalityField.setBounds(32, 298, 145, 23);
		contentPane.add(nationalityField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Addresse  :");
		lblNewLabel_3_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(224, 36, 145, 23);
		contentPane.add(lblNewLabel_3_1);
		
		addressField = new JTextArea();
		addressField.setBounds(242, 49, 177, 74);
		contentPane.add(addressField);
		
		JLabel lblNewLabel_5_2 = new JLabel("Gender :");
		lblNewLabel_5_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel_5_2.setBounds(242, 123, 79, 23);
		contentPane.add(lblNewLabel_5_2);
		
		gendreChoice = new JComboBox();			
		gendreChoice.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		if (operation.equals("Creation") == false)
			gendreChoice.setSelectedIndex(prs.getGendre().equals("Male") ? 0 : 1);
		gendreChoice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		gendreChoice.setBounds(242, 145, 177, 26);
		contentPane.add(gendreChoice);
		
		newCreationPanel = new JPanel();
		newCreationPanel.setLayout(null);
		newCreationPanel.setForeground(SystemColor.info);
		newCreationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		newCreationPanel.setBounds(242, 174, 177, 147);
		contentPane.add(newCreationPanel);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("New Login :");
		lblNewLabel_3_2_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_2.setBounds(6, 6, 127, 20);
		newCreationPanel.add(lblNewLabel_3_2_2);
		
		newLoginField = new JTextField();
		if (operation.equals("Creation") == false)
			newLoginField.setText(prs.getLogin());
		newLoginField.setFont(new Font("Courier New", Font.PLAIN, 12));
		newLoginField.setColumns(10);
		newLoginField.setBounds(26, 23, 141, 21);
		newCreationPanel.add(newLoginField);
		
		loginLabel = new JLabel("");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		loginLabel.setBounds(41, 31, 127, 20);
		accountNew.getContentPane().add(loginLabel);
		
		JLabel lblNewLabel_3_2_2_1 = new JLabel("New Password :");
		lblNewLabel_3_2_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_2_1.setBounds(6, 49, 127, 20);
		newCreationPanel.add(lblNewLabel_3_2_2_1);
		
		newPasswordField = new JPasswordField();
		if (operation.equals("Creation") == false)
			newPasswordField.setText(prs.getMotDePasse());
		newPasswordField.setFont(new Font("Courier New", Font.PLAIN, 10));
		newPasswordField.setColumns(10);
		newPasswordField.setBounds(26, 66, 141, 21);
		newCreationPanel.add(newPasswordField);
		
		confirmPasswordField = new JPasswordField();
		if (operation.equals("Creation") == false)
			confirmPasswordField.setText(prs.getMotDePasse());
		confirmPasswordField.setFont(new Font("Courier New", Font.PLAIN, 10));
		confirmPasswordField.setColumns(10);
		confirmPasswordField.setBounds(26, 93, 141, 21);
		newCreationPanel.add(confirmPasswordField);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operation.equals("Creation") && newPasswordField.getText().equals(confirmPasswordField.getText()) && newLoginField.getText().isEmpty() == false) {
					if (me.getSql().checkUser(newLoginField.getText()) == 0) {
						loginLabel.setText(newLoginField.getText());
						accountNew.setVisible(true);						
					} else loginExist.setVisible(true);
				}  else if (operation.equals("Update") && newPasswordField.getText().equals(confirmPasswordField.getText())) {
					if (me.getSql().checkUser(newLoginField.getText()) == 0) {
						me.getSql().updateUser(new User(prs.getPerson(), newLoginField.getText(), newPasswordField.getText()));
						setVisible(false); //you can't see me!
						dispose();						
					} else	loginExist.setVisible(true);
				} else if (operation.equals("Delete")) {
					me.getSql().deleteUser(prs.getCIN());
					setVisible(false); //you can't see me!
					dispose();
				} else if (newPasswordField.getText().equals(confirmPasswordField.getText()) == false) {
					loginExist.setVisible(true);
				}
			}
		});
		btnNext.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnNext.setBounds(242, 336, 127, 27);
		contentPane.add(btnNext);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //you can't see me!
				dispose(); 
			}
		});
		btnReturn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		btnReturn.setBounds(86, 336, 127, 27);
		contentPane.add(btnReturn);
		
		loginExist = new JLabel("Login exist...");
		loginExist.setVisible(false);
		loginExist.setBounds(242, 363, 127, 20);
		contentPane.add(loginExist);
		loginExist.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		loginExist.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
	}
}

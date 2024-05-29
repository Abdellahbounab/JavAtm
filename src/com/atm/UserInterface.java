package com.atm;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.Cursor;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton withdrawMoney;
	private JButton bankState;
	private JButton deposeMoney;
	private JButton transferMoney;
	private JLabel logOut;
	private JButton accountInfo;
	private JLabel loginAccount;
	private JLabel showBalance;
	private JInternalFrame operationsPanel;
	private JTextField toField;
	private JLabel lblNewLabel;
	private JSpinner amountSpinner;
	private JLabel lblAmount;
	private JButton confirmOperation;
	private JButton btnReturn;
	private JInternalFrame configPanel;
	private JLabel lblNewLabel_3_2_2;
	private JPasswordField userNewPassword;
	private JPasswordField userConfirmPassword;
	private JLabel oldPassword;
	private JPasswordField userOldPassword;
	private JButton changePassword;
	private JButton btnReturn_1;
	private JLabel lowBalance;
	private JLabel imagePlacement;

	/**
	 * Create the frame.
	 */
	public UserInterface(User prs) {
		setTitle("User Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		operationsPanel = new JInternalFrame("Operations");
		operationsPanel.setBounds(86, 69, 393, 232);
		contentPane.add(operationsPanel);
		operationsPanel.getContentPane().setLayout(null);
		
		toField = new JTextField();
		toField.setEditable(false);
		toField.setFont(new Font("Century", Font.PLAIN, 14));
		toField.setBounds(86, 32, 235, 23);
		operationsPanel.getContentPane().add(toField);
		toField.setColumns(10);
		
		lblNewLabel = new JLabel("to :");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(54, 36, 21, 14);
		operationsPanel.getContentPane().add(lblNewLabel);
		
		amountSpinner = new JSpinner();
		amountSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(100)));
		amountSpinner.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		amountSpinner.setBounds(86, 76, 235, 23);
		operationsPanel.getContentPane().add(amountSpinner);
		
		lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblAmount.setBounds(13, 80, 62, 14);
		operationsPanel.getContentPane().add(lblAmount);
		
		confirmOperation = new JButton("Confirm");
		confirmOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInterface reload = null;
				System.out.println(amountSpinner.getValue().toString());
				if (operationsPanel.getTitle().equals("Withdraw Money") && (double) amountSpinner.getValue() >= 0) {
					if ((double) amountSpinner.getValue() > 0) {
						prs.getAccount().retireSolde((double) amountSpinner.getValue());
						prs.getSql().updateAccount(prs.getAccount());
						operationsPanel.setVisible(false);
						reload = new UserInterface(prs);
						reload.setLocationRelativeTo(UserInterface.this);
						reload.setVisible(true);
						setVisible(false);
						dispose();
					}
					else {
						lowBalance.setText("Low Balance..");
						lowBalance.setVisible(true);
					}
				}
				else if (operationsPanel.getTitle().equals("Deposit Money") && (double) amountSpinner.getValue() >= 0) {
						prs.getAccount().deposeMoney((double) amountSpinner.getValue());
						prs.getSql().updateAccount(prs.getAccount());
						operationsPanel.setVisible(false);
						reload = new UserInterface(prs);
						reload.setLocationRelativeTo(UserInterface.this);
						reload.setVisible(true);
						setVisible(false);
						dispose();
				}
				else if (operationsPanel.getTitle().equals("Transfer Money") && (double) amountSpinner.getValue() >= 0) {
					if (prs.getSql().checkUser(toField.getText()) != 0 && prs.getAccount().getSolde() >= (double) amountSpinner.getValue()) {
						prs.getAccount().retireSolde((double) amountSpinner.getValue());
						prs.getSql().updateAccount(prs.getAccount());
						prs.getSql().updateAccount(toField.getText(), (double) amountSpinner.getValue());
						reload = new UserInterface(prs);
						reload.setLocationRelativeTo(UserInterface.this);
						reload.setVisible(true);
						setVisible(false);
						dispose();
					}
					else {
						lowBalance.setText("Low Balance or Wrong reciever..");
						lowBalance.setVisible(true);
					}
						
				}else {
					lowBalance.setText("impossible under 0 MAD");
					lowBalance.setVisible(true);
				}
			}
		});
		confirmOperation.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		confirmOperation.setBounds(120, 110, 161, 29);
		operationsPanel.getContentPane().add(confirmOperation);
		
		btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationsPanel.setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnReturn.setBounds(120, 148, 161, 29);
		operationsPanel.getContentPane().add(btnReturn);
		
		lowBalance = new JLabel("Low balance");
		lowBalance.setVisible(false);
		lowBalance.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		lowBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lowBalance.setBounds(86, 62, 235, 14);
		operationsPanel.getContentPane().add(lowBalance);
		
		configPanel = new JInternalFrame("Configuration");
		configPanel.getContentPane().setLayout(null);
		
		lblNewLabel_3_2_2 = new JLabel("New Password :");
		lblNewLabel_3_2_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblNewLabel_3_2_2.setBounds(10, 75, 127, 20);
		configPanel.getContentPane().add(lblNewLabel_3_2_2);
		
		userNewPassword = new JPasswordField();
		userNewPassword.setFont(new Font("Courier New", Font.PLAIN, 10));
		userNewPassword.setColumns(10);
		userNewPassword.setBounds(30, 92, 141, 21);
		configPanel.getContentPane().add(userNewPassword);
		
		userConfirmPassword = new JPasswordField();
		userConfirmPassword.setFont(new Font("Courier New", Font.PLAIN, 10));
		userConfirmPassword.setColumns(10);
		userConfirmPassword.setBounds(30, 119, 141, 21);
		configPanel.getContentPane().add(userConfirmPassword);
		
		oldPassword = new JLabel("Old Password :");
		oldPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		oldPassword.setBounds(10, 26, 127, 20);
		configPanel.getContentPane().add(oldPassword);
		
		userOldPassword = new JPasswordField();
		userOldPassword.setFont(new Font("Courier New", Font.PLAIN, 10));
		userOldPassword.setColumns(10);
		userOldPassword.setBounds(30, 43, 141, 21);
		configPanel.getContentPane().add(userOldPassword);
		
		changePassword = new JButton("Confirm");
		changePassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		changePassword.setBounds(50, 161, 97, 30);
		configPanel.getContentPane().add(changePassword);
		
		btnReturn_1 = new JButton("Return");
		btnReturn_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		btnReturn_1.setBounds(50, 195, 97, 30);
		configPanel.getContentPane().add(btnReturn_1);
		configPanel.setBounds(333, 11, 204, 265);
		contentPane.add(configPanel);
		
		deposeMoney = new JButton("Deposit money");
		deposeMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationsPanel.setTitle("Deposit Money");
				toField.setText(prs.getLogin());
				amountSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(100)));
				operationsPanel.setVisible(true);
			}
		});
		deposeMoney.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		deposeMoney.setBounds(373, 174, 164, 36);
		contentPane.add(deposeMoney);
		
		withdrawMoney = new JButton("Withdraw money");
		withdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationsPanel.setTitle("Withdraw Money");
				toField.setText("Withdraw");
				amountSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), (Double)prs.getAccount().getSolde(), Double.valueOf(100)));
				operationsPanel.setVisible(true);
			}
		});
		withdrawMoney.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		withdrawMoney.setBounds(25, 174, 164, 36);
		contentPane.add(withdrawMoney);
		
		transferMoney = new JButton("Transfer money");
		transferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operationsPanel.setTitle("Transfer Money");
				toField.setEditable(true);
				amountSpinner.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), (Double)prs.getAccount().getSolde(), Double.valueOf(100)));
				operationsPanel.setVisible(true);
			}
		});
		transferMoney.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		transferMoney.setBounds(199, 174, 164, 36);
		contentPane.add(transferMoney);
		
		bankState = new JButton("Bank statement");
		bankState.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		bankState.setBounds(113, 221, 164, 36);
		contentPane.add(bankState);
		
		accountInfo = new JButton("Configurations");
		accountInfo.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		accountInfo.setBounds(287, 221, 164, 36);
		contentPane.add(accountInfo);
		
		loginAccount = new JLabel(prs.getLogin());
		loginAccount.setHorizontalAlignment(SwingConstants.CENTER);
		loginAccount.setFont(new Font("Old English Text MT", Font.PLAIN, 30));
		loginAccount.setBounds(108, 25, 343, 33);
		contentPane.add(loginAccount);
		
		logOut = new JLabel("Logout");
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MachineAtm reload = new MachineAtm();
				reload.setLocationRelativeTo(UserInterface.this);
				reload.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		logOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOut.setForeground(SystemColor.textHighlight);
		logOut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		logOut.setBounds(487, 281, 62, 20);
		contentPane.add(logOut);
		
		showBalance = new JLabel(NumberFormat.getCurrencyInstance(new Locale("fr", "MA")).format(prs.getAccount().getSolde()));
		showBalance.setHorizontalAlignment(SwingConstants.CENTER);
		showBalance.setFont(new Font("Century Gothic", Font.BOLD, 30));
		showBalance.setBounds(110, 65, 328, 98);
		contentPane.add(showBalance);
		
		imagePlacement = new JLabel(new ImageIcon("C:\\Users\\Abdellah Bounab\\Desktop\\JavAtm\\atm2-removebg-preview.png"));
		imagePlacement.setBounds(10, 11, 175, 70);
		contentPane.add(imagePlacement);
	}

}

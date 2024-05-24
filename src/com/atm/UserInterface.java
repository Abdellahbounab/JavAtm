package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Canvas;
import java.awt.Color;

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
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setTitle("User Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		deposeMoney = new JButton("Deposit money");
		deposeMoney.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		deposeMoney.setBounds(373, 174, 164, 36);
		contentPane.add(deposeMoney);
		
		withdrawMoney = new JButton("Withdraw money");
		withdrawMoney.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		withdrawMoney.setBounds(25, 174, 164, 36);
		contentPane.add(withdrawMoney);
		
		transferMoney = new JButton("Transfer money");
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
		
		loginAccount = new JLabel("name");
		loginAccount.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		loginAccount.setBounds(199, 25, 164, 20);
		contentPane.add(loginAccount);
		
		logOut = new JLabel("Logout");
		logOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logOut.setForeground(SystemColor.textHighlight);
		logOut.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		logOut.setBounds(487, 281, 62, 20);
		contentPane.add(logOut);
		
		showBalance = new JLabel("0 DHs");
		showBalance.setHorizontalAlignment(SwingConstants.CENTER);
		showBalance.setFont(new Font("Century Gothic", Font.BOLD, 30));
		showBalance.setBounds(110, 65, 328, 98);
		contentPane.add(showBalance);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.GRAY);
		canvas.setBounds(10, 11, 100, 54);
		contentPane.add(canvas);
	}

}

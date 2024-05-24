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

public class MachineAtm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JPasswordField passwordField;

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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(96, 116, 259, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login :");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(96, 96, 259, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblMotDePasse.setBounds(96, 169, 259, 19);
		contentPane.add(lblMotDePasse);
		
		btnNewButton = new JButton("Sign up");
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		btnNewButton.setBounds(159, 232, 131, 41);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 189, 259, 32);
		contentPane.add(passwordField);
		
		Canvas logo = new Canvas();
		logo.setBackground(Color.GRAY);
		logo.setBounds(167, 10, 100, 100);
		contentPane.add(logo);
	}
}

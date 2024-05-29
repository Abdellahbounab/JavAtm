package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class tablesInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton printTable;
	private JButton returnBtn;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					tablesInterface frame = new tablesInterface("Accounts", new Admin("M000000"));
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
	public tablesInterface(String operation,Admin prs) {
		setTitle(operation);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setEnabled(false);
		if (operation.equals(operation)) {
			table.setModel(new DefaultTableModel(prs.getSql().getTableAccounts(), prs.getSql().getTableAccountHeaders()));			
		} else if (operation.equals("Operations")) {
			
		}
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		table.setBounds(10, 48, 604, 317);
		contentPane.add(table);
		
		returnBtn = new JButton("Return");
		returnBtn.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		returnBtn.setBounds(493, 376, 121, 33);
		contentPane.add(returnBtn);
		
		printTable = new JButton("Print");
		printTable.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		printTable.setBounds(362, 376, 121, 33);
		contentPane.add(printTable);
		
		lblNewLabel = new JLabel("Accounts");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(221, 11, 202, 26);
		contentPane.add(lblNewLabel);
	}
}

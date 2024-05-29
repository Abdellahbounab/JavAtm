package com.atm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;

public class printerInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox clientChoice;
	private JComboBox operationChoice;
	private JCheckBox operationCheck;
	private JSpinner dateBeforePrinter;
	private JCheckBox dateCheck;
	private JSpinner dateBeforePrinter_1;
	private JButton printBtn;

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
					printerInterface frame = new printerInterface();
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
	public printerInterface() {
		setTitle("Printer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateCheck = new JCheckBox("Date");
		dateCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		dateCheck.setBounds(284, 197, 70, 23);
		contentPane.add(dateCheck);
		
		dateBeforePrinter = new JSpinner();
		dateBeforePrinter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateBeforePrinter.setModel(new SpinnerDateModel(new Date(1716505200000L), new Date(1716505200000L), null, Calendar.DAY_OF_YEAR));
		dateBeforePrinter.setBounds(119, 177, 143, 23);
		contentPane.add(dateBeforePrinter);
		
		JLabel lblNewLabel = new JLabel("Start :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(68, 181, 41, 14);
		contentPane.add(lblNewLabel);
		
		dateBeforePrinter_1 = new JSpinner();
		dateBeforePrinter_1.setModel(new SpinnerDateModel(new Date(1716505200000L), new Date(1716505200000L), null, Calendar.DAY_OF_YEAR));
		dateBeforePrinter_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateBeforePrinter_1.setBounds(119, 213, 143, 23);
		contentPane.add(dateBeforePrinter_1);
		
		JLabel lblEnd = new JLabel("End :");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnd.setBounds(75, 217, 34, 14);
		contentPane.add(lblEnd);
		
		clientChoice = new JComboBox();
		clientChoice.setModel(new DefaultComboBoxModel(new String[] {"All Clients", "1", "2"}));
		clientChoice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		clientChoice.setBounds(119, 29, 143, 30);
		contentPane.add(clientChoice);
		
		JLabel lblClients = new JLabel("Clients :");
		lblClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClients.setBounds(58, 37, 51, 14);
		contentPane.add(lblClients);
		
		JLabel lblOperations = new JLabel("Operations :");
		lblOperations.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOperations.setBounds(26, 105, 83, 22);
		contentPane.add(lblOperations);
		
		operationChoice = new JComboBox();
		operationChoice.setModel(new DefaultComboBoxModel(new String[] {"Both", "Active", "Passive"}));
		operationChoice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		operationChoice.setBounds(119, 101, 143, 30);
		contentPane.add(operationChoice);
		
		operationCheck = new JCheckBox("Type");
		operationCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		operationCheck.setBounds(284, 107, 70, 23);
		contentPane.add(operationCheck);
		
		printBtn = new JButton("Print");
		printBtn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		printBtn.setBounds(139, 281, 112, 37);
		contentPane.add(printBtn);
	}
}

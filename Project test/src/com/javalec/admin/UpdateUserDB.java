package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class UpdateUserDB {

	private JFrame frame;
	private JTextField textField;
	private JTable Inner_Table_mb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUserDB window = new UpdateUserDB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateUserDB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblmember = new JLabel("회원관리");
		lblmember.setHorizontalAlignment(SwingConstants.CENTER);
		lblmember.setBounds(6, 6, 104, 36);
		frame.getContentPane().add(lblmember);
		
		JScrollPane scrollPane_mb = new JScrollPane();
		scrollPane_mb.setBounds(6, 54, 913, 477);
		frame.getContentPane().add(scrollPane_mb);
		
		Inner_Table_mb = new JTable();
		scrollPane_mb.setViewportView(Inner_Table_mb);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(642, 6, 208, 26);
		frame.getContentPane().add(textField);
		
		JButton btnLoad_mb = new JButton("조회");
		btnLoad_mb.setBounds(854, 6, 65, 29);
		frame.getContentPane().add(btnLoad_mb);
		
		JComboBox cbselection_mb = new JComboBox();
		cbselection_mb.setModel(new DefaultComboBoxModel(new String[] {"이름", "아이디", "이메일"}));
		cbselection_mb.setBounds(532, 6, 98, 27);
		frame.getContentPane().add(cbselection_mb);
	}

}

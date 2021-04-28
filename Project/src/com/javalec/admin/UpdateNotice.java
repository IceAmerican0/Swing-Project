package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateNotice {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateNotice window = new UpdateNotice();
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
	public UpdateNotice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("제목 :");
		lblTitle.setBounds(6, 11, 61, 16);
		frame.getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(43, 6, 203, 26);
		frame.getContentPane().add(textField);
		
		JLabel lblDate = new JLabel("date :");
		lblDate.setBounds(247, 11, 49, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblPost = new JLabel("내용 :");
		lblPost.setBounds(6, 44, 61, 16);
		frame.getContentPane().add(lblPost);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 44, 424, 225);
		frame.getContentPane().add(panel);
		
		JTextArea textArea = new JTextArea(20, 30);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		panel.add(textArea);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(132, 281, 92, 29);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(225, 281, 92, 29);
		frame.getContentPane().add(btnDelete);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(282, 6, 151, 26);
		frame.getContentPane().add(textField_1);
	}
}

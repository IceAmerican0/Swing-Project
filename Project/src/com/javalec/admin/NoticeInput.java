package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

public class NoticeInput {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNoticeTitle;
	private JTextArea textArea;
	private JPanel panel;
	private JLabel lblNoticePost;
	private JButton btnInsertDB;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeInput window = new NoticeInput();
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
	public NoticeInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNoticeTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblNoticePost());
		frame.getContentPane().add(getBtnInsertDB());
		frame.getContentPane().add(getBtnCancel());
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(48, 6, 233, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNoticeTitle() {
		if (lblNoticeTitle == null) {
			lblNoticeTitle = new JLabel("제목 :");
			lblNoticeTitle.setBounds(11, 11, 61, 16);
		}
		return lblNoticeTitle;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 30);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(11, 61, 424, 248);
			panel.add(getTextArea());
		}
		return panel;
	}
	private JLabel getLblNoticePost() {
		if (lblNoticePost == null) {
			lblNoticePost = new JLabel("내용 :");
			lblNoticePost.setBounds(11, 39, 61, 16);
		}
		return lblNoticePost;
	}
	private JButton getBtnInsertDB() {
		if (btnInsertDB == null) {
			btnInsertDB = new JButton("확인");
			btnInsertDB.setBounds(133, 321, 81, 29);
		}
		return btnInsertDB;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.setBounds(226, 321, 81, 29);
		}
		return btnCancel;
	}
}

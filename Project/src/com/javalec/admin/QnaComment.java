package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class QnaComment {

	private JFrame frame;
	private JTextField titleF;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel lblPost;
	private JButton btnInsertDB;
	private JButton btnCancel;
	private JLabel lblUserName;
	private JTextField userF;
	private JTextField dateF;
	private JLabel lblDate;
	private JLabel Answer;
	private JPanel paneladmin;
	private JTextArea textAreaAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QnaComment window = new QnaComment();
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
	public QnaComment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTitleF());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblPost());
		frame.getContentPane().add(getBtnInsertDB());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getUserF());
		frame.getContentPane().add(getDateF());
		frame.getContentPane().add(getLblDate());
		frame.getContentPane().add(getAnswer());
		frame.getContentPane().add(getPaneladmin());
	}

	private JTextField getTitleF() {
		if (titleF == null) {
			titleF = new JTextField();
			titleF.setColumns(10);
			titleF.setBounds(43, 6, 233, 26);
		}
		return titleF;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목 :");
			lblTitle.setBounds(6, 11, 61, 16);
		}
		return lblTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 82, 424, 187);
			panel.add(getTextArea());
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 30);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JLabel getLblPost() {
		if (lblPost == null) {
			lblPost = new JLabel("내용 :");
			lblPost.setBounds(6, 64, 61, 16);
		}
		return lblPost;
	}
	private JButton getBtnInsertDB() {
		if (btnInsertDB == null) {
			btnInsertDB = new JButton("확인");
			btnInsertDB.setBounds(126, 395, 81, 29);
		}
		return btnInsertDB;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.setBounds(219, 395, 81, 29);
		}
		return btnCancel;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("작성자 :");
			lblUserName.setBounds(6, 40, 61, 16);
		}
		return lblUserName;
	}
	private JTextField getUserF() {
		if (userF == null) {
			userF = new JTextField();
			userF.setBounds(55, 35, 88, 26);
			userF.setColumns(10);
		}
		return userF;
	}
	private JTextField getDateF() {
		if (dateF == null) {
			dateF = new JTextField();
			dateF.setBounds(269, 35, 158, 26);
			dateF.setColumns(10);
		}
		return dateF;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("date :");
			lblDate.setBounds(230, 40, 197, 16);
		}
		return lblDate;
	}
	private JLabel getAnswer() {
		if (Answer == null) {
			Answer = new JLabel("답변 :");
			Answer.setBounds(6, 281, 61, 16);
		}
		return Answer;
	}
	private JPanel getPaneladmin() {
		if (paneladmin == null) {
			paneladmin = new JPanel();
			paneladmin.setBounds(6, 298, 424, 85);
			paneladmin.add(getTextAreaAdmin());
		}
		return paneladmin;
	}
	private JTextArea getTextAreaAdmin() {
		if (textAreaAdmin == null) {
			textAreaAdmin = new JTextArea(20, 30);
			textAreaAdmin.setLineWrap(true);
		}
		return textAreaAdmin;
	}
}

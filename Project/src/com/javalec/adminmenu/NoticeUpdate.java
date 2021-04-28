package com.javalec.adminmenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoticeUpdate {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNoticeTitle;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel lblNoticePost;
	private JButton btnBlindNotice;
	private JButton btnCancel;
	private JButton btnUpdateNotice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeUpdate window = new NoticeUpdate();
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
	public NoticeUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 438, 396);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNoticeTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblNoticePost());
		frame.getContentPane().add(getBtnBlindNotice());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getBtnUpdateNotice());
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(43, 6, 233, 26);
		}
		return textField;
	}
	private JLabel getLblNoticeTitle() {
		if (lblNoticeTitle == null) {
			lblNoticeTitle = new JLabel("제목 :");
			lblNoticeTitle.setBounds(6, 11, 61, 16);
		}
		return lblNoticeTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 61, 424, 248);
			panel.add(getTextArea());
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 30);
			textArea.setEditable(false);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JLabel getLblNoticePost() {
		if (lblNoticePost == null) {
			lblNoticePost = new JLabel("내용 :");
			lblNoticePost.setBounds(6, 39, 61, 16);
		}
		return lblNoticePost;
	}
	private JButton getBtnBlindNotice() {
		if (btnBlindNotice == null) {
			btnBlindNotice = new JButton("삭제");
			btnBlindNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnBlindNotice.setBounds(175, 321, 81, 29);
		}
		return btnBlindNotice;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancel.setBounds(268, 321, 81, 29);
		}
		return btnCancel;
	}
	private JButton getBtnUpdateNotice() {
		if (btnUpdateNotice == null) {
			btnUpdateNotice = new JButton("수정");
			btnUpdateNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setEditable(true);
					textField.setEditable(true);
					btnUpdateNotice.setText("확인");
				}
			});
			btnUpdateNotice.setBounds(82, 321, 81, 29);
		}
		return btnUpdateNotice;
	}
}

package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//----------------------------------------Notice 테이블없음!!-----------------------------------------
public class InsertNotice {

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
					InsertNotice window = new InsertNotice();
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
	public InsertNotice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 390);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			btnInsertDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnInsertDB.setBounds(133, 321, 81, 29);
		}
		return btnInsertDB;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnCancel.setBounds(226, 321, 81, 29);
		}
		return btnCancel;
	}
	private void check() {
		// 공백 확인 메소드
		if (textArea.getText().trim().length() == 0 || textField.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "내용을 채워주세요!");
		}else {
			InsertAction();
		}

	}
	private void InsertAction() {
		//
		String title = textField.getText();
		String post = textArea.getText();
		AdminAction adminaction = new AdminAction();
		boolean aaa = adminaction.InsertDocument(title, post);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "공지사항이 등록 되었습니다.!");
	          frame.dispose();
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
}

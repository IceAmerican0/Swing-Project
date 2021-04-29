package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UpdateQuery {

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
					UpdateQuery window = new UpdateQuery();
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
	public UpdateQuery() {
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
				SelectAction();
			}
		});
		frame.setBounds(100, 100, 450, 411);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			textField.setBounds(43, 18, 233, 26);
		}
		return textField;
	}
	private JLabel getLblNoticeTitle() {
		if (lblNoticeTitle == null) {
			lblNoticeTitle = new JLabel("제목 :");
			lblNoticeTitle.setBounds(6, 23, 61, 16);
		}
		return lblNoticeTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 73, 424, 248);
			panel.add(getTextArea());
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 30);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
		}
		return textArea;
	}
	private JLabel getLblNoticePost() {
		if (lblNoticePost == null) {
			lblNoticePost = new JLabel("내용 :");
			lblNoticePost.setBounds(6, 51, 61, 16);
		}
		return lblNoticePost;
	}
	private JButton getBtnBlindNotice() {
		if (btnBlindNotice == null) {
			btnBlindNotice = new JButton("삭제");
			btnBlindNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteAction();
				}
			});
			btnBlindNotice.setBounds(175, 333, 81, 29);
		}
		return btnBlindNotice;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnCancel.setBounds(268, 333, 81, 29);
		}
		return btnCancel;
	}
	private JButton getBtnUpdateNotice() {
		if (btnUpdateNotice == null) {
			btnUpdateNotice = new JButton("수정");
			btnUpdateNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnUpdateNotice.setBounds(82, 333, 81, 29);
		}
		return btnUpdateNotice;
	}
	private void check() {
		if (btnUpdateNotice.getText() == "수정") {
			textArea.setEditable(true);
			textField.setEditable(true);
			btnUpdateNotice.setText("확인");
		}
		if (btnUpdateNotice.getText() == "확인") {
			textArea.setEditable(false);
			textField.setEditable(false);
			btnUpdateNotice.setText("수정");
			if (textArea.getText().trim().length() == 0 || textField.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "수정 사항을 확인해주세요!");
			}else {
				UpdateAction();
			}
		}
	}
		private void SelectAction() {
			//seq를 받아서 텍스트창에 입력하여 수정이 가능하게 해
	
		}
		private void UpdateAction() {
			//AdminAction에서 업데이트 쿼리

		}
		private void DeleteAction() {
			// TODO Auto-generated method stub

		}
}

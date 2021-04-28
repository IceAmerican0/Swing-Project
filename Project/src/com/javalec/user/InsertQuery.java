package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertQuery {

	private JFrame frame;
	private JLabel lbltitle;
	private JTextField titleF;
	private JButton btnOK;
	private JButton btnCancel;
	private JLabel lbltitle_1;
	private JPanel panel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertQuery window = new InsertQuery();
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
	public InsertQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLbltitle());
		frame.getContentPane().add(getTitleF());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLbltitle_1());
		frame.getContentPane().add(getPanel());
	}

	private JLabel getLbltitle() {
		if (lbltitle == null) {
			lbltitle = new JLabel("제목 :");
			lbltitle.setBounds(6, 6, 61, 16);
		}
		return lbltitle;
	}
	private JTextField getTitleF() {
		if (titleF == null) {
			titleF = new JTextField();
			titleF.setBounds(76, 1, 130, 26);
			titleF.setColumns(10);
		}
		return titleF;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("등록");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnOK.setBounds(115, 237, 91, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnCancel.setBounds(218, 237, 91, 29);
		}
		return btnCancel;
	}
	private JLabel getLbltitle_1() {
		if (lbltitle_1 == null) {
			lbltitle_1 = new JLabel("내용 :");
			lbltitle_1.setBounds(6, 34, 61, 16);
		}
		return lbltitle_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(16, 34, 415, 191);
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
	private void check() {
		String text = "";
		if (textArea.getText().trim().length() == 0) {
			text = "내용을";
		}
		if (titleF.getText().trim().length() == 0) {
			text = "제목을";
		}
		else {
			insertAction();
		}
		JOptionPane.showMessageDialog(null, text+" 입력해주세요!");

	}
	private void insertAction() {
		// TODO Auto-generated method stub
		String title = titleF.getText();
		String content = textArea.getText();
		//작성자 정보 가져오기
		
		UserAction useraction = new UserAction();
		boolean aaa = useraction.InsertQuery(title, content);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, " 님의 질문이 입력 되었습니다.!");
	          frame.dispose();

		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}

	}
}

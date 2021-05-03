package com.javalec.profile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.xml.stream.events.Characters;

import com.javalec.function.ShareVar;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword {

	private JFrame frame;
	private JLabel lblNewLabel_6_1_1_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_6_1_1_1_1;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_6_1_1_1_1_1;
	private JPasswordField passwordField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
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
	public ChangePassword() {
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
		frame.getContentPane().add(getLblNewLabel_6_1_1_1());
		frame.getContentPane().add(getPasswordField());
		frame.getContentPane().add(getLblNewLabel_6_1_1_1_1());
		frame.getContentPane().add(getPasswordField_1());
		frame.getContentPane().add(getLblNewLabel_6_1_1_1_1_1());
		frame.getContentPane().add(getPasswordField_2());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.setLocationRelativeTo(null);
	}

	private JLabel getLblNewLabel_6_1_1_1() {
		if (lblNewLabel_6_1_1_1 == null) {
			lblNewLabel_6_1_1_1 = new JLabel("기존 비밀번호 :");
			lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6_1_1_1.setBounds(71, 62, 79, 16);
		}
		return lblNewLabel_6_1_1_1;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(161, 57, 208, 26);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_6_1_1_1_1() {
		if (lblNewLabel_6_1_1_1_1 == null) {
			lblNewLabel_6_1_1_1_1 = new JLabel("새 비밀번호 :");
			lblNewLabel_6_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6_1_1_1_1.setBounds(60, 93, 90, 16);
		}
		return lblNewLabel_6_1_1_1_1;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(161, 88, 208, 26);
		}
		return passwordField_1;
	}
	private JLabel getLblNewLabel_6_1_1_1_1_1() {
		if (lblNewLabel_6_1_1_1_1_1 == null) {
			lblNewLabel_6_1_1_1_1_1 = new JLabel("새 비밀번호 확인:");
			lblNewLabel_6_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_6_1_1_1_1_1.setBounds(45, 124, 105, 16);
		}
		return lblNewLabel_6_1_1_1_1_1;
	}
	private JPasswordField getPasswordField_2() {
		if (passwordField_2 == null) {
			passwordField_2 = new JPasswordField();
			passwordField_2.setBounds(161, 119, 208, 26);
		}
		return passwordField_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("확인");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String pw = new String(passwordField.getPassword());
					String newpw = new String(passwordField_1.getPassword());
					String newpwcheck = new String(passwordField_2.getPassword());
					if(pw.equals(ShareVar.nowPw) && !newpw.isEmpty() && newpw.equals(newpwcheck)) {
						
						ChangePasswordAction changePasswordAction = new ChangePasswordAction(ShareVar.nowId, newpw);
						boolean aaa = changePasswordAction.pwchangeaction();
						if(aaa == true){
					          JOptionPane.showMessageDialog(null, "비밀번호가 변경 되었습니다.");
					          frame.dispose();
						}else{
					          JOptionPane.showMessageDialog(null, "DB 처리중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
						}
						
					}else JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요!", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
					
					
				}
			});
			btnNewButton.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton.setBounds(110, 187, 91, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("취소");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_1.setBounds(245, 187, 91, 23);
		}
		return btnNewButton_1;
	}
}

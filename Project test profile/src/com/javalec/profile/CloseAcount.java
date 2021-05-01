package com.javalec.profile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.function.ShareVar;
import com.javalec.login.Login;
import com.javalec.tab.user_tab;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CloseAcount {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblpassword;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloseAcount window = new CloseAcount();
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
	public CloseAcount() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getLblpassword());
		frame.getContentPane().add(getPasswordField());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("님아 정녕 절 두고 가시렵니까? OTL");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(26, 10, 383, 78);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("취소");
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnNewButton.setBounds(91, 170, 91, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("탈퇴");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pw = new String(passwordField.getPassword());
					if(pw.equals(ShareVar.nowPw)) {
						
						CloseAcountAction closeAcountAction = new CloseAcountAction(ShareVar.nowId);
						boolean aaa = closeAcountAction.blindaction();
						if(aaa == true){
					          JOptionPane.showMessageDialog(null, "탈퇴처리 되었습니다.\n재가입시 기존아이디는 사용할 수 없습니다.");
					          ShareVar.closeIndex=1;
					          frame.dispose();
						}else{
					          JOptionPane.showMessageDialog(null, "DB 처리중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
						}
						
					}else JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요!", "ErrorMessage", JOptionPane.ERROR_MESSAGE);
					
				}
			});
			btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 12));
			btnNewButton_1.setBounds(226, 170, 91, 23);
		}
		return btnNewButton_1;
	}
	private JLabel getLblpassword() {
		if (lblpassword == null) {
			lblpassword = new JLabel("비밀번호 :");
			lblpassword.setHorizontalAlignment(SwingConstants.RIGHT);
			lblpassword.setBounds(52, 115, 61, 16);
		}
		return lblpassword;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(124, 110, 208, 26);
		}
		return passwordField;
	}
	
	static public int passcheck() {
		
		return 1;
	}
	
	
	
	
} // ----

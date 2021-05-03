package com.javalec.login;

import java.awt.EventQueue;	

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.base.MainMenu;
import com.javalec.find.FindId;
import com.javalec.find.FindPassword;
import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.profile.CloseAcountAction;
import com.javalec.tab.admin_tab;
import com.javalec.tab.user_tab;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField tfId;
	private JButton btnLogin;
	private JButton btnFindid;
	private JButton btnFindpw;
	private JButton btnNewuser;
	
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
    private final String id_mysql = "root";
    private final String pw_mysql = "qwer1234";
    private JPasswordField Password;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnFindid());
		frame.getContentPane().add(getBtnFindpw());
		frame.getContentPane().add(getBtnNewuser());
		frame.getContentPane().add(getPassword());
		frame.getContentPane().add(getLblNewLabel());
		frame.setLocationRelativeTo(null);
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(88, 105, 145, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginMethod();
				}				
			});
			btnLogin.setBounds(245, 105, 104, 64);
		}
		return btnLogin;
	}
	private JButton getBtnFindid() {
		if (btnFindid == null) {
			btnFindid = new JButton("아이디찾기");
			btnFindid.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					FindId.main(null);
				}
			});
			btnFindid.setBounds(156, 181, 92, 29);
		}
		return btnFindid;
	}
	private JButton getBtnFindpw() {
		if (btnFindpw == null) {
			btnFindpw = new JButton("비밀번호찾기");
			btnFindpw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					FindPassword.main(null);
				}
			});
			btnFindpw.setBounds(255, 181, 121, 29);
		}
		return btnFindpw;
	}
	private JButton getBtnNewuser() {
		if (btnNewuser == null) {
			btnNewuser = new JButton("회원가입");
			btnNewuser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					UserRegister.main(null);
				}
			});
			btnNewuser.setBounds(56, 181, 88, 29);
		}
		return btnNewuser;
	}
	
	private JPasswordField getPassword() {
		if (Password == null) {
			Password = new JPasswordField();
			Password.setBounds(88, 148, 145, 21);
		}
		return Password;
	}
	
	private void LoginMethod() {
		String id=tfId.getText().trim();
		String pw=new String(Password.getPassword());
		
		LoginAction loginAction=new LoginAction(id,pw);
		int msg=loginAction.Login();
		
		// jy : 추가 start, 탈퇴처리 취소를 위한 기능 코드, 프로그램 오픈 시 주석처리 예정
//		CloseAcountAction closeAcountAction2 = new CloseAcountAction(ShareVar.blindTime);
//		boolean bbb = closeAcountAction2.blindcancelaction(id);
//		if(bbb == true){
//			JOptionPane.showMessageDialog(null, "탈퇴처리가 취소 되었습니다.\n(임시기능)");
//			ShareVar.closeIndex=0;
//			frame.dispose();
//		}else{
//			JOptionPane.showMessageDialog(null, "DB 처리중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
//		}
		// jy : 추가 end
		
		
		if(ShareVar.blindTime==null) {
			if(msg==1) {
				if(ShareVar.admincheck==0) {
					frame.dispose();
					user_tab.main(null);
				}
				if(ShareVar.admincheck==1) {
					frame.dispose();
					admin_tab.main(null);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "아이디 및 비밀번호를 입력해주세요!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
				tfId.grabFocus();
			}
		}else JOptionPane.showMessageDialog(null, "정지된 아이디 입니다.","ErrorMessage",JOptionPane.ERROR_MESSAGE);
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("오늘 뭐 입지?");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel.setBounds(98, 22, 231, 71);
		}
		return lblNewLabel;
	}
}

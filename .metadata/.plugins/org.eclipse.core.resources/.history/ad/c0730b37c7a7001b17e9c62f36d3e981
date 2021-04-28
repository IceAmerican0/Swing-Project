package com.javalec.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.base.MainMenu;
import com.javalec.function.LoginAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnLogin;
	private JButton btnFindid;
	private JButton btnFindpw;
	private JButton btnNewuser;
	
	private final String url_mysql = "jdbc:mysql://127.0.0.1/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
    private final String id_mysql = "root";
    private final String pw_mysql = "qwer1234";

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
		frame.getContentPane().add(getTfPw());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnFindid());
		frame.getContentPane().add(getBtnFindpw());
		frame.getContentPane().add(getBtnNewuser());
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(103, 65, 130, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(103, 103, 130, 26);
		}
		return tfPw;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login();
				}				
			});
			btnLogin.setBounds(245, 65, 104, 64);
		}
		return btnLogin;
	}
	private JButton getBtnFindid() {
		if (btnFindid == null) {
			btnFindid = new JButton("아이디찾기");
			btnFindid.setBounds(167, 141, 92, 29);
		}
		return btnFindid;
	}
	private JButton getBtnFindpw() {
		if (btnFindpw == null) {
			btnFindpw = new JButton("비밀번호찾기");
			btnFindpw.setBounds(255, 141, 92, 29);
		}
		return btnFindpw;
	}
	private JButton getBtnNewuser() {
		if (btnNewuser == null) {
			btnNewuser = new JButton("회원가입");
			btnNewuser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserRegister userregister=new UserRegister();
					frame.dispose();
					userregister.main(null);
				}
			});
			btnNewuser.setBounds(95, 141, 75, 29);
		}
		return btnNewuser;
	}
	
	
	
	
	private void Login() {
		String id=tfId.getText().trim().toString();
		String pw=tfId.getText().trim().toString();
		
		LoginAction loginAction=new LoginAction(id,pw);
		int msg=loginAction.Login();
		
		if(msg==1) {
			MainMenu main=new MainMenu();
			frame.dispose();
			main.main(null);
		}
		if(msg==2)	JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
		if(msg==3)	JOptionPane.showMessageDialog(null, "아이디가 틀립니다!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
		
	}
	
	
}

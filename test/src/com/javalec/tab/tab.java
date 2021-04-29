package com.javalec.tab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.base.MainMenu;
import com.javalec.community.WritePost;
import com.javalec.login.UserRegister;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class tab {

	private JFrame frame;
	private JPanel signup;
	private JPanel signin;
	private JLayeredPane layeredPane;
	private JTextField tfId;
	private JTextField tfPw;
	private JButton btnLogin;
	private JButton btnFindid;
	private JButton btnFindpw;
	private JButton btnNewuser;
	private JTextField tfId_1;
	private JTextField tfEmail;
	private JTextField tfPw1;
	private JTextField tfPw2;
	private JTextField tfName;
	private JPanel findid;
	private JTextField textField;
	private JButton btnTestid_2;
	private JTextField textField_1;
	private JButton btnTestid_3;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lbCheckpw_1;
	private JTextField textField_4;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JPanel findpw;
	private JTextField textField_5;
	private JButton btnTestid_4;
	private JTextField textField_6;
	private JButton btnTestid_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lbCheckpw_2;
	private JTextField textField_9;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_2;
	
	
	//탭 전환하기 (2021.04.27 김민규)
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tab window = new tab();
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
	public tab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(151, 56, 925, 537);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		signin = new JPanel();
		layeredPane.add(signin, "name_10014477907462");
		signin.setLayout(null);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(355, 200, 130, 26);
		signin.add(tfId);
		
		tfPw = new JTextField();
		tfPw.setColumns(10);
		tfPw.setBounds(355, 238, 130, 26);
		signin.add(tfPw);
		
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_tab.main(null);
			}
		});
		btnLogin.setBounds(497, 200, 104, 64);
		signin.add(btnLogin);
		
		btnFindid = new JButton("아이디찾기");
		btnFindid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(findid);
			}
		});
		btnFindid.setBounds(419, 276, 92, 29);
		signin.add(btnFindid);
		
		btnFindpw = new JButton("비밀번호찾기");
		btnFindpw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(findpw);
			}
		});
		btnFindpw.setBounds(507, 276, 92, 29);
		signin.add(btnFindpw);
		
		btnNewuser = new JButton("회원가입");
		btnNewuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(signup);
			}
		});
		btnNewuser.setBounds(347, 276, 75, 29);
		signin.add(btnNewuser);
		
		// 탭 전환
		
		signup = new JPanel();
		layeredPane.add(signup, "name_10025409858196");
		signup.setLayout(null);
		
		tfId_1 = new JTextField();
		tfId_1.setText("아이디를 입력해주세요");
		tfId_1.setColumns(10);
		tfId_1.setBounds(275, 146, 220, 26);
		signup.add(tfId_1);
		
		JButton btnTestid = new JButton("중복확인");
		btnTestid.setBounds(507, 146, 117, 29);
		signup.add(btnTestid);
		
		tfEmail = new JTextField();
		tfEmail.setText("이메일 주소를 입력해주세요");
		tfEmail.setColumns(10);
		tfEmail.setBounds(275, 184, 220, 26);
		signup.add(tfEmail);
		
		JButton btnTestid_1 = new JButton("중복확인");
		btnTestid_1.setBounds(507, 184, 117, 29);
		signup.add(btnTestid_1);
		
		tfPw1 = new JTextField();
		tfPw1.setText("비밀번호를 입력해주세요");
		tfPw1.setColumns(10);
		tfPw1.setBounds(275, 222, 349, 26);
		signup.add(tfPw1);
		
		tfPw2 = new JTextField();
		tfPw2.setText("비밀번호를 한번 더 입력해주세요");
		tfPw2.setColumns(10);
		tfPw2.setBounds(275, 260, 349, 26);
		signup.add(tfPw2);
		
		JLabel lbCheckpw = new JLabel("비밀번호가 일치하지 않습니다!");
		lbCheckpw.setBounds(285, 287, 276, 16);
		signup.add(lbCheckpw);
		
		tfName = new JTextField();
		tfName.setText("이름을 입력해 주세요");
		tfName.setColumns(10);
		tfName.setBounds(275, 315, 173, 26);
		signup.add(tfName);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user_tab.main(null);

			}
		});
		btnNewButton.setBounds(301, 366, 117, 29);
		signup.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("가입취소");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(signin);
			}
		});
		btnNewButton_1.setBounds(444, 366, 117, 29);
		signup.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("회원가입");
		lblNewLabel_1.setBounds(406, 92, 89, 42);
		signup.add(lblNewLabel_1);
		
		findid = new JPanel();
		findid.setLayout(null);
		layeredPane.add(findid, "name_22925041623601");
		
		textField = new JTextField();
		textField.setText("아이디를 입력해주세요");
		textField.setColumns(10);
		textField.setBounds(275, 146, 220, 26);
		findid.add(textField);
		
		btnTestid_2 = new JButton("중복확인");
		btnTestid_2.setBounds(507, 146, 117, 29);
		findid.add(btnTestid_2);
		
		textField_1 = new JTextField();
		textField_1.setText("이메일 주소를 입력해주세요");
		textField_1.setColumns(10);
		textField_1.setBounds(275, 184, 220, 26);
		findid.add(textField_1);
		
		btnTestid_3 = new JButton("중복확인");
		btnTestid_3.setBounds(507, 184, 117, 29);
		findid.add(btnTestid_3);
		
		textField_2 = new JTextField();
		textField_2.setText("비밀번호를 입력해주세요");
		textField_2.setColumns(10);
		textField_2.setBounds(275, 222, 349, 26);
		findid.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("비밀번호를 한번 더 입력해주세요");
		textField_3.setColumns(10);
		textField_3.setBounds(275, 260, 349, 26);
		findid.add(textField_3);
		
		lbCheckpw_1 = new JLabel("비밀번호가 일치하지 않습니다!");
		lbCheckpw_1.setBounds(285, 287, 276, 16);
		findid.add(lbCheckpw_1);
		
		textField_4 = new JTextField();
		textField_4.setText("이름을 입력해 주세요");
		textField_4.setColumns(10);
		textField_4.setBounds(275, 315, 173, 26);
		findid.add(textField_4);
		
		btnNewButton_2 = new JButton("찾기");
		btnNewButton_2.setBounds(301, 366, 117, 29);
		findid.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("취소");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(signin);
			}
		});
		btnNewButton_3.setBounds(444, 366, 117, 29);
		findid.add(btnNewButton_3);
		
		lblNewLabel = new JLabel("아이디 찾기");
		lblNewLabel.setBounds(406, 92, 89, 42);
		findid.add(lblNewLabel);
		
		findpw = new JPanel();
		layeredPane.add(findpw, "name_22942926386178");
		findpw.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setText("아이디를 입력해주세요");
		textField_5.setColumns(10);
		textField_5.setBounds(275, 146, 220, 26);
		findpw.add(textField_5);
		
		btnTestid_4 = new JButton("중복확인");
		btnTestid_4.setBounds(507, 146, 117, 29);
		findpw.add(btnTestid_4);
		
		textField_6 = new JTextField();
		textField_6.setText("이메일 주소를 입력해주세요");
		textField_6.setColumns(10);
		textField_6.setBounds(275, 184, 220, 26);
		findpw.add(textField_6);
		
		btnTestid_5 = new JButton("중복확인");
		btnTestid_5.setBounds(507, 184, 117, 29);
		findpw.add(btnTestid_5);
		
		textField_7 = new JTextField();
		textField_7.setText("비밀번호를 입력해주세요");
		textField_7.setColumns(10);
		textField_7.setBounds(275, 222, 349, 26);
		findpw.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("비밀번호를 한번 더 입력해주세요");
		textField_8.setColumns(10);
		textField_8.setBounds(275, 260, 349, 26);
		findpw.add(textField_8);
		
		lbCheckpw_2 = new JLabel("비밀번호가 일치하지 않습니다!");
		lbCheckpw_2.setBounds(285, 287, 276, 16);
		findpw.add(lbCheckpw_2);
		
		textField_9 = new JTextField();
		textField_9.setText("이름을 입력해 주세요");
		textField_9.setColumns(10);
		textField_9.setBounds(275, 315, 173, 26);
		findpw.add(textField_9);
		
		btnNewButton_4 = new JButton("찾기");
		btnNewButton_4.setBounds(301, 366, 117, 29);
		findpw.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("취소");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(signin);
			}
		});
		btnNewButton_5.setBounds(444, 366, 117, 29);
		findpw.add(btnNewButton_5);
		
		lblNewLabel_2 = new JLabel("비밀번호 찾기");
		lblNewLabel_2.setBounds(406, 92, 89, 42);
		findpw.add(lblNewLabel_2);


	}
	
}//--------------------------
package com.javalec.tab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class user_tab {

	private JFrame frame;
	private JPanel inquiry;
	private JPanel notice;
	private JPanel mycloset;
	private JPanel allcloset;
	private JPanel bestitem;
	private JPanel myprofile;
	private JLayeredPane layeredPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

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
					user_tab window = new user_tab();
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
	public user_tab() {
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
		layeredPane.setBounds(250, 63, 925, 537);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		myprofile = new JPanel();
		layeredPane.add(myprofile, "name_10014477907462");
		myprofile.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("내 프로필");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 97, 26);
		myprofile.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이미지 파일을 등록해주세요");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(43, 43, 199, 170);
		myprofile.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("이름 :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(522, 86, 61, 16);
		myprofile.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("아이디 :");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(522, 120, 61, 16);
		myprofile.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("이메일 :");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1.setBounds(522, 154, 61, 16);
		myprofile.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("비밀번호 :");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1_1.setBounds(522, 187, 61, 16);
		myprofile.add(lblNewLabel_6_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(594, 82, 208, 26);
		myprofile.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(595, 115, 207, 26);
		myprofile.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(595, 149, 207, 26);
		myprofile.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(594, 182, 208, 26);
		myprofile.add(passwordField);
		
		JLabel lblNewLabel_7 = new JLabel("비밀번호를 다시 확인해 주세요!");
		lblNewLabel_7.setBounds(594, 220, 208, 16);
		myprofile.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("비밀번호 변경");
		btnNewButton.setBounds(594, 248, 117, 29);
		myprofile.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("탈퇴하기");
		btnNewButton_1.setBounds(723, 248, 117, 29);
		myprofile.add(btnNewButton_1);
		
		bestitem = new JPanel();
		layeredPane.add(bestitem, "name_10025409858196");
		bestitem.setLayout(null);
		
		JLabel lblBest = new JLabel("Best");
		lblBest.setHorizontalAlignment(SwingConstants.CENTER);
		lblBest.setBounds(237, 176, 424, 138);
		bestitem.add(lblBest);
		
		allcloset = new JPanel();
		layeredPane.add(allcloset, "name_10028148525053");
		allcloset.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("모두의 옷장");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(242, 171, 424, 138);
		allcloset.add(lblNewLabel_2);
		
		mycloset = new JPanel();
		layeredPane.add(mycloset, "name_10030972904756");
		mycloset.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("나의 옷장");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(238, 175, 424, 138);
		mycloset.add(lblNewLabel_3);
		
		notice = new JPanel();
		layeredPane.add(notice, "name_10033259740421");
		notice.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("공지사항");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(252, 188, 424, 138);
		notice.add(lblNewLabel_4);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10036677548749");
		inquiry.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("1:1 문의");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(246, 185, 424, 138);
		inquiry.add(lblNewLabel_5);
		
		JButton btnmyProfile = new JButton("내 프로필");
		btnmyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(myprofile);
			}
		});
		btnmyProfile.setBounds(52, 63, 151, 50);
		frame.getContentPane().add(btnmyProfile);
		
		JButton btnBest = new JButton("Best");
		btnBest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(bestitem);
			}
		});
		btnBest.setBounds(52, 125, 151, 50);
		frame.getContentPane().add(btnBest);
		
		JButton btnallCloset = new JButton("모두의 옷장");
		btnallCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(allcloset);
			}
		});
		btnallCloset.setBounds(52, 187, 151, 50);
		frame.getContentPane().add(btnallCloset);
		
		JButton btnmyCloset = new JButton("나의 옷장");
		btnmyCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(mycloset);
			}
		});
		btnmyCloset.setBounds(52, 249, 151, 50);
		frame.getContentPane().add(btnmyCloset);
		
		JButton btnNotice = new JButton("공지사항");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(notice);
			}
		});
		btnNotice.setBounds(52, 311, 151, 50);
		frame.getContentPane().add(btnNotice);
		
		JButton btnInquiry = new JButton("1:1 문의");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inquiry);
			}
		});
		btnInquiry.setBounds(52, 373, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnlogOut = new JButton("로그아웃");
		btnlogOut.setBounds(86, 435, 117, 29);
		frame.getContentPane().add(btnlogOut);
		
		JLabel lblNewLabel_8 = new JLabel("김민규 님 환영합니다");
		lblNewLabel_8.setBounds(52, 36, 151, 16);
		frame.getContentPane().add(lblNewLabel_8);
	}
}

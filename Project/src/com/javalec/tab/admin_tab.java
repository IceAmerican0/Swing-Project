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

public class admin_tab {

	private JFrame frame;
	private JPanel authority;
	private JPanel inquiry;
	private JPanel board;
	private JPanel closet;
	private JPanel member;
	private JPanel admin;
	private JLayeredPane layeredPane;

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
					admin_tab window = new admin_tab();
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
	public admin_tab() {
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
		
		admin = new JPanel();
		layeredPane.add(admin, "name_10014477907462");
		admin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("관리자 프로필");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(248, 167, 424, 138);
		admin.add(lblNewLabel);
		
		member = new JPanel();
		layeredPane.add(member, "name_10025409858196");
		member.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("회원관리");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(237, 176, 424, 138);
		member.add(lblNewLabel1);
		
		closet = new JPanel();
		layeredPane.add(closet, "name_10028148525053");
		closet.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("옷장관리");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(242, 171, 424, 138);
		closet.add(lblNewLabel_2);
		
		board = new JPanel();
		layeredPane.add(board, "name_10030972904756");
		board.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("게시글관리");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(238, 175, 424, 138);
		board.add(lblNewLabel_3);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10033259740421");
		inquiry.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("문의관리");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(252, 188, 424, 138);
		inquiry.add(lblNewLabel_4);
		
		authority = new JPanel();
		layeredPane.add(authority, "name_10036677548749");
		authority.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("권한설정");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(246, 185, 424, 138);
		authority.add(lblNewLabel_5);
		
		JButton btnAdmin = new JButton("관리자 프로필");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(admin);
			}
		});
		btnAdmin.setBounds(52, 63, 151, 50);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnMember = new JButton("회원관리");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(member);
			}
		});
		btnMember.setBounds(52, 125, 151, 50);
		frame.getContentPane().add(btnMember);
		
		JButton btnCloset = new JButton("옷장관리");
		btnCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(closet);
			}
		});
		btnCloset.setBounds(52, 187, 151, 50);
		frame.getContentPane().add(btnCloset);
		
		JButton btnBoard = new JButton("게시글관리");
		btnBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(board);
			}
		});
		btnBoard.setBounds(52, 249, 151, 50);
		frame.getContentPane().add(btnBoard);
		
		JButton btnInquiry = new JButton("문의관리");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inquiry);
			}
		});
		btnInquiry.setBounds(52, 311, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnAuthority = new JButton("권한설정");
		btnAuthority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(authority);
			}
		});
		btnAuthority.setBounds(52, 373, 151, 50);
		frame.getContentPane().add(btnAuthority);
	}
}

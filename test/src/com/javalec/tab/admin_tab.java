package com.javalec.tab;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class admin_tab {

	private JFrame frame;
	private JPanel notice;
	private JPanel inquiry;
	private JPanel board;
	private JPanel closet;
	private JPanel member;
	private JPanel admin;
	private JLayeredPane layeredPane;
	private JTable table;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;

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
		lblNewLabel.setBounds(6, 6, 97, 26);
		admin.add(lblNewLabel);
		
		JLabel lblImage = new JLabel("이미지 파일을 등록해주세요");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(81, 52, 199, 170);
		admin.add(lblImage);
		
		JLabel lblNewLabel_6 = new JLabel("이름 :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(560, 95, 61, 16);
		admin.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("아이디 :");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(560, 129, 61, 16);
		admin.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("이메일 :");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1.setBounds(560, 163, 61, 16);
		admin.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("비밀번호 :");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1_1.setBounds(560, 196, 61, 16);
		admin.add(lblNewLabel_6_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(632, 91, 208, 26);
		admin.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(633, 124, 207, 26);
		admin.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(633, 158, 207, 26);
		admin.add(textField_6);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(632, 191, 208, 26);
		admin.add(passwordField);
		
		JLabel lblNewLabel_7 = new JLabel("비밀번호를 다시 확인해 주세요!");
		lblNewLabel_7.setBounds(632, 229, 208, 16);
		admin.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("비밀번호 변경");
		btnNewButton.setBounds(632, 257, 117, 29);
		admin.add(btnNewButton);
		
		JButton btnBrowse = new JButton("이미지등록");
		btnBrowse.addActionListener(new ActionListener() {
			//이미지 사진 등록하기 2021.04.28 김민규
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
					
					lblImage.setIcon(new ImageIcon(image));
				}
			}
		});
		btnBrowse.setBounds(123, 234, 117, 29);
		admin.add(btnBrowse);
		
		member = new JPanel();
		layeredPane.add(member, "name_10025409858196");
		member.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("회원관리");
		lblNewLabel1.setBounds(6, 6, 104, 36);
		member.add(lblNewLabel1);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLoad = new JButton("조회");
		btnLoad.setBounds(623, 48, 117, 29);
		member.add(btnLoad);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(752, 48, 117, 29);
		member.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 89, 829, 427);
		member.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		closet = new JPanel();
		layeredPane.add(closet, "name_10028148525053");
		closet.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("옷장관리");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 142, 41);
		closet.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(163, 13, 117, 29);
		closet.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(285, 13, 117, 29);
		closet.add(btnNewButton_2);
		
		board = new JPanel();
		layeredPane.add(board, "name_10030972904756");
		board.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("게시글관리");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 108, 34);
		board.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 52, 913, 479);
		board.add(scrollPane_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(518, 6, 208, 26);
		board.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		comboBox_1_1.setBounds(390, 7, 116, 27);
		board.add(comboBox_1_1);
		
		JButton btnDelete_1 = new JButton("삭제");
		btnDelete_1.setBounds(854, 6, 65, 29);
		board.add(btnDelete_1);
		
		JButton btnWrite = new JButton("글쓰기");
		btnWrite.setBounds(794, 6, 65, 29);
		board.add(btnWrite);
		
		JButton btnLoad_1 = new JButton("조회");
		btnLoad_1.setBounds(730, 6, 65, 29);
		board.add(btnLoad_1);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10033259740421");
		inquiry.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("문의관리");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(6, 6, 116, 31);
		inquiry.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(6, 49, 913, 482);
		inquiry.add(scrollPane_1_1);
		
		JComboBox comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		comboBox_1_1_1_1.setBounds(390, 7, 116, 27);
		inquiry.add(comboBox_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(518, 6, 208, 26);
		inquiry.add(textField_1);
		
		JButton btnLoad_1_2_1 = new JButton("조회");
		btnLoad_1_2_1.setBounds(730, 6, 65, 29);
		inquiry.add(btnLoad_1_2_1);
		
		JButton btnWrite_1_1 = new JButton("글쓰기");
		btnWrite_1_1.setBounds(794, 6, 65, 29);
		inquiry.add(btnWrite_1_1);
		
		JButton btnDelete_1_2_1 = new JButton("삭제");
		btnDelete_1_2_1.setBounds(854, 6, 65, 29);
		inquiry.add(btnDelete_1_2_1);
		
		notice = new JPanel();
		layeredPane.add(notice, "name_10036677548749");
		notice.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("공지관리");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(6, 6, 107, 36);
		notice.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(6, 54, 913, 477);
		notice.add(scrollPane_1_2);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		comboBox_1_1_1.setBounds(390, 7, 116, 27);
		notice.add(comboBox_1_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(518, 6, 208, 26);
		notice.add(textField);
		
		JButton btnLoad_1_2 = new JButton("조회");
		btnLoad_1_2.setBounds(730, 6, 65, 29);
		notice.add(btnLoad_1_2);
		
		JButton btnWrite_1 = new JButton("글쓰기");
		btnWrite_1.setBounds(794, 6, 65, 29);
		notice.add(btnWrite_1);
		
		JButton btnDelete_1_2 = new JButton("삭제");
		btnDelete_1_2.setBounds(854, 6, 65, 29);
		notice.add(btnDelete_1_2);
		
		JButton btnAdmin = new JButton("관리자 프로필");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(admin);//탭전환
			}
		});
		btnAdmin.setBounds(52, 63, 151, 50);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnMember = new JButton("회원관리");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(member);//탭전환
			}
		});
		btnMember.setBounds(52, 125, 151, 50);
		frame.getContentPane().add(btnMember);
		
		JButton btnCloset = new JButton("옷장관리");
		btnCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(closet);//탭전환
			}
		});
		btnCloset.setBounds(52, 187, 151, 50);
		frame.getContentPane().add(btnCloset);
		
		JButton btnBoard = new JButton("게시글관리");
		btnBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(board);//탭전환
			}
		});
		btnBoard.setBounds(52, 249, 151, 50);
		frame.getContentPane().add(btnBoard);
		
		JButton btnInquiry = new JButton("문의관리");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inquiry);//탭전환
			}
		});
		btnInquiry.setBounds(52, 311, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnNotice = new JButton("공지관리");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(notice);//탭전환
			}
		});
		btnNotice.setBounds(52, 373, 151, 50);
		frame.getContentPane().add(btnNotice);
		
		JButton btnlogOut = new JButton("로그아웃");
		btnlogOut.setBounds(86, 435, 117, 29);
		frame.getContentPane().add(btnlogOut);
	}
}

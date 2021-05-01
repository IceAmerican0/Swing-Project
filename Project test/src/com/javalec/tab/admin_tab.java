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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.AnswerQueryInsert;
import com.javalec.admin.InsertNotice;
import com.javalec.function.ShareVar;
import com.javalec.login.Login;
import com.javalec.login.RegisterAction;
import com.javalec.user.InsertCloth;
import com.javalec.function.Bean;


import java.awt.event.ActionListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	private JTable table_mb;
	private JTextField tfresult_bd;
	private JTextField tfname;
	private JTextField tfid;
	private JTextField tfemail;
	private JPasswordField pfpassword;
	private JTextField txresult_nt;
	private JTextField tfresult_iq;
	private JTextField tfresult_cs;
	
	//--------------------------------------------
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnWrite_nt;
	private JScrollPane scrollPane;
	private JTable table_nt;
	private JTable table_iq;
	private JTable table_cs;
	private JTable table_bd;
	private JTextField tfresult_mb;
	//--------------------------------------------
	
	

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(250, 63, 925, 537);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		admin = new JPanel();
		layeredPane.add(admin, "name_10014477907462");
		admin.setLayout(null);
		
		JLabel lblprofile = new JLabel("관리자 프로필");
		lblprofile.setHorizontalAlignment(SwingConstants.CENTER);
		lblprofile.setBounds(6, 6, 97, 26);
		admin.add(lblprofile);
		
		JLabel lblImage = new JLabel("이미지 파일을 등록해주세요");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(81, 52, 199, 170);
		admin.add(lblImage);
		
		JLabel lblname = new JLabel("이름 :");
		lblname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname.setBounds(560, 95, 61, 16);
		admin.add(lblname);
		
		JLabel lblid = new JLabel("아이디 :");
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(560, 129, 61, 16);
		admin.add(lblid);
		
		JLabel lblemail = new JLabel("이메일 :");
		lblemail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemail.setBounds(560, 163, 61, 16);
		admin.add(lblemail);
		
		JLabel lblpassword = new JLabel("비밀번호 :");
		lblpassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpassword.setBounds(560, 196, 61, 16);
		admin.add(lblpassword);
		
		tfname = new JTextField();
		tfname.setEditable(false);
		tfname.setColumns(10);
		tfname.setBounds(632, 91, 208, 26);
		admin.add(tfname);
		
		tfid = new JTextField();
		tfid.setEditable(false);
		tfid.setColumns(10);
		tfid.setBounds(633, 124, 207, 26);
		admin.add(tfid);
		
		tfemail = new JTextField();
		tfemail.setEditable(false);
		tfemail.setColumns(10);
		tfemail.setBounds(633, 158, 207, 26);
		admin.add(tfemail);
		
		pfpassword = new JPasswordField();
		pfpassword.setEditable(false);
		pfpassword.setBounds(632, 191, 208, 26);
		admin.add(pfpassword);
		
		JButton btnchangepw = new JButton("비밀번호 변경");
		btnchangepw.setBounds(632, 234, 117, 29);
		admin.add(btnchangepw);
		
		JButton btnbrowse = new JButton("이미지등록");
		btnbrowse.addActionListener(new ActionListener() {
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
		btnbrowse.setBounds(123, 234, 117, 29);
		admin.add(btnbrowse);
		
		member = new JPanel();
		layeredPane.add(member, "name_10025409858196");
		member.setLayout(null);
		
		JLabel lblmember = new JLabel("회원관리");
		lblmember.setBounds(6, 6, 104, 36);
		member.add(lblmember);
		lblmember.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane_mb = new JScrollPane();
		scrollPane_mb.setBounds(6, 54, 913, 477);
		member.add(scrollPane_mb);
		
		
		table_mb = new JTable();
		scrollPane_mb.setViewportView(table_mb);
		
		tfresult_mb = new JTextField();
		tfresult_mb.setColumns(10);
		tfresult_mb.setBounds(642, 6, 208, 26);
		member.add(tfresult_mb);
		
		JButton btnLoad_mb = new JButton("조회");
		btnLoad_mb.setBounds(854, 6, 65, 29);
		member.add(btnLoad_mb);
		
		
		JComboBox cbtitle_mb = new JComboBox();
		cbtitle_mb.setModel(new DefaultComboBoxModel(new String[] {"이름", "아이디", "연락처"}));
		cbtitle_mb.setBounds(532, 6, 98, 27);
		member.add(cbtitle_mb);
		
		closet = new JPanel();
		layeredPane.add(closet, "name_10028148525053");
		closet.setLayout(null);
		
		JLabel lblcloset = new JLabel("옷장관리");
		lblcloset.setHorizontalAlignment(SwingConstants.CENTER);
		lblcloset.setBounds(6, 6, 142, 41);
		closet.add(lblcloset);
		
		JScrollPane scrollPane_cs = new JScrollPane();
		scrollPane_cs.setBounds(7, 53, 913, 479);
		closet.add(scrollPane_cs);
		
		table_cs = new JTable();
		scrollPane_cs.setViewportView(table_cs);
		
		tfresult_cs = new JTextField();
		tfresult_cs.setColumns(10);
		tfresult_cs.setBounds(519, 7, 208, 26);
		closet.add(tfresult_cs);
		
		JComboBox cbtitle_cb = new JComboBox();
		cbtitle_cb.setModel(new DefaultComboBoxModel(new String[] {"상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
		cbtitle_cb.setBounds(418, 8, 89, 27);
		closet.add(cbtitle_cb);
		
		JButton btnDelete_cs = new JButton("삭제");
		btnDelete_cs.setBounds(855, 7, 65, 29);
		closet.add(btnDelete_cs);
		
		JButton btnLoad_cs = new JButton("조회");
		btnLoad_cs.setBounds(731, 7, 65, 29);
		closet.add(btnLoad_cs);
		
		board = new JPanel();
		layeredPane.add(board, "name_10030972904756");
		board.setLayout(null);
		
		JLabel lblboard = new JLabel("게시글관리");
		lblboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblboard.setBounds(6, 6, 108, 34);
		board.add(lblboard);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 52, 913, 479);
		board.add(scrollPane_1);
		
		table_bd = new JTable();
		scrollPane_1.setViewportView(table_bd);
		
		tfresult_bd = new JTextField();
		tfresult_bd.setBounds(578, 6, 208, 26);
		board.add(tfresult_bd);
		tfresult_bd.setColumns(10);
		
		JComboBox cbtitle_bd = new JComboBox();
		cbtitle_bd.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_bd.setBounds(450, 7, 116, 27);
		board.add(cbtitle_bd);
		
		JButton btnDelete_bd = new JButton("삭제");
		btnDelete_bd.setBounds(854, 6, 65, 29);
		board.add(btnDelete_bd);
		
		JButton btnLoad_bd = new JButton("조회");
		btnLoad_bd.setBounds(790, 6, 65, 29);
		board.add(btnLoad_bd);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10033259740421");
		inquiry.setLayout(null);
		
		JLabel lblinquiry = new JLabel("문의관리");
		lblinquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblinquiry.setBounds(6, 6, 116, 31);
		inquiry.add(lblinquiry);
		
		JScrollPane scrollPane_iq = new JScrollPane();
		scrollPane_iq.setBounds(6, 49, 913, 482);
		inquiry.add(scrollPane_iq);
		
		table_iq = new JTable();
		scrollPane_iq.setViewportView(table_iq);
		
		JComboBox cbtitle_iq = new JComboBox();
		cbtitle_iq.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_iq.setBounds(366, 7, 116, 27);
		inquiry.add(cbtitle_iq);
		
		tfresult_iq = new JTextField();
		tfresult_iq.setColumns(10);
		tfresult_iq.setBounds(494, 6, 208, 26);
		inquiry.add(tfresult_iq);
		
		JButton btnLoad_iq = new JButton("조회");
		btnLoad_iq.setBounds(706, 6, 65, 29);
		inquiry.add(btnLoad_iq);
		
		JButton btnDelete_iq = new JButton("삭제");
		btnDelete_iq.setBounds(854, 6, 65, 29);
		inquiry.add(btnDelete_iq);
		
		JButton btnWrite_iq1 = new JButton("답변하기");
		btnWrite_iq1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnswerQueryInsert.main(null);
			}
		});
		btnWrite_iq1.setBounds(768, 6, 94, 29);
		inquiry.add(btnWrite_iq1);
		
		notice = new JPanel();
		layeredPane.add(notice, "name_10036677548749");
		notice.setLayout(null);
		
		JLabel lblnotice = new JLabel("공지관리");
		lblnotice.setHorizontalAlignment(SwingConstants.CENTER);
		lblnotice.setBounds(6, 6, 107, 36);
		notice.add(lblnotice);
		
		JScrollPane scrollPane_nt = new JScrollPane();
		scrollPane_nt.setBounds(6, 54, 913, 477);
		notice.add(scrollPane_nt);
		
		table_nt = new JTable();
		scrollPane_nt.setViewportView(table_nt);
		
		JComboBox cbtitle_nt = new JComboBox();
		cbtitle_nt.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_nt.setBounds(390, 7, 116, 27);
		notice.add(cbtitle_nt);
		
		txresult_nt = new JTextField();
		txresult_nt.setColumns(10);
		txresult_nt.setBounds(518, 6, 208, 26);
		notice.add(txresult_nt);
		
		JButton btnLoad_nt = new JButton("조회");
		btnLoad_nt.setBounds(730, 6, 65, 29);
		notice.add(btnLoad_nt);
		
		JButton btnWrite_nt = new JButton("글쓰기");
		btnWrite_nt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNotice.main(null);
			}
		});
		btnWrite_nt.setBounds(794, 6, 65, 29);
		notice.add(btnWrite_nt);

		
		JButton btnDelete_nt = new JButton("삭제");
		btnDelete_nt.setBounds(854, 6, 65, 29);
		notice.add(btnDelete_nt);
		
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
				// 탭 전환 하면서 회원정보 출력 또는 조회버튼 클릭시 회원정보 출력
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
		btnlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.nowId="";
				ShareVar.nowPw="";
				ShareVar.userName="";
				frame.dispose();
				Login.main(null);
			}
		});
		btnlogOut.setBounds(86, 435, 117, 29);
		frame.getContentPane().add(btnlogOut);
	}


}  //-------------



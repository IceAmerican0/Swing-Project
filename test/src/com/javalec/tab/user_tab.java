package com.javalec.tab;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.admin.InsertNotice;
import com.javalec.community.InsertClothes;
import com.javalec.community.InsertQnA;
import com.javalec.community.WritePost;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.Canvas;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDesktopPane;

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
	private JPanel in_mypreset;
	private JPanel in_mycloset;
	private JLayeredPane inmycloset;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_nt;
	private JTable table_iq;
	private JTextField textField_5;
	private JTextField textField_6;

	//탭 전환하기 (2021.04.27 김민규)
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	//탭 전환하기 (2021.04.27 김민규)
	public void switchPanels2(JPanel panel2) {
		inmycloset.removeAll();
		inmycloset.add(panel2);
		inmycloset.repaint();
		inmycloset.revalidate();
		
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
		
		JLabel lblImage = new JLabel("이미지 파일을 등록해주세요");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(43, 43, 199, 170);
		myprofile.add(lblImage);
		
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
		btnBrowse.setBounds(85, 225, 117, 29);
		myprofile.add(btnBrowse);
		
		bestitem = new JPanel();
		layeredPane.add(bestitem, "name_10025409858196");
		bestitem.setLayout(null);
		
		JLabel lblBest = new JLabel("Best");
		lblBest.setHorizontalAlignment(SwingConstants.CENTER);
		lblBest.setBounds(6, 6, 116, 31);
		bestitem.add(lblBest);
		
		JScrollPane scrollPane_ac_1 = new JScrollPane();
		scrollPane_ac_1.setBounds(6, 49, 913, 482);
		bestitem.add(scrollPane_ac_1);
		
		JComboBox cbtitle_nt_1_1 = new JComboBox();
		cbtitle_nt_1_1.setBounds(514, 7, 116, 27);
		bestitem.add(cbtitle_nt_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(642, 6, 208, 26);
		bestitem.add(textField_6);
		
		JButton btnLoad_nt_1_1 = new JButton("검색");
		btnLoad_nt_1_1.setBounds(854, 6, 65, 29);
		bestitem.add(btnLoad_nt_1_1);
		
		allcloset = new JPanel();
		layeredPane.add(allcloset, "name_10028148525053");
		allcloset.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("모두의 옷장");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 104, 27);
		allcloset.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("작성하기");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WritePost.main(null);
			}
		});
		btnNewButton_4.setBounds(802, 6, 117, 29);
		allcloset.add(btnNewButton_4);
		
		JComboBox cbtitle_nt_1 = new JComboBox();
		cbtitle_nt_1.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용", "작성자"}));
		cbtitle_nt_1.setBounds(397, 7, 116, 27);
		allcloset.add(cbtitle_nt_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(525, 6, 208, 26);
		allcloset.add(textField_5);
		
		JButton btnLoad_nt_1 = new JButton("검색");
		btnLoad_nt_1.setBounds(737, 6, 65, 29);
		allcloset.add(btnLoad_nt_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 45, 913, 486);
		allcloset.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		
		
		
		
		mycloset = new JPanel();
		layeredPane.add(mycloset, "name_10030972904756");
		mycloset.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("나의 옷장");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 126, 37);
		mycloset.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("옷장");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels2(in_mycloset);
			}
		});
		btnNewButton_2.setBounds(144, 11, 75, 29);
		mycloset.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("프리셋");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels2(in_mypreset);
			}
		});
		btnNewButton_3.setBounds(218, 11, 75, 29);
		mycloset.add(btnNewButton_3);
		
		inmycloset = new JLayeredPane();
		inmycloset.setBounds(48, 79, 751, 428);
		mycloset.add(inmycloset);
		inmycloset.setLayout(new CardLayout(0, 0));
		
		in_mycloset = new JPanel();
		inmycloset.add(in_mycloset, "name_83815068808318");
		in_mycloset.setLayout(null);
		
		JButton btnNewButton_2_1 = new JButton("옷 등록");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertClothes.main(null);
			}
		});
		btnNewButton_2_1.setBounds(6, 6, 98, 29);
		in_mycloset.add(btnNewButton_2_1);
		
		in_mypreset = new JPanel();
		inmycloset.add(in_mypreset, "name_83833397636156");
		in_mypreset.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("프리셋");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(6, 6, 87, 39);
		in_mypreset.add(lblNewLabel_9);
		
		JLabel lblhat = new JLabel("모자 등록하기");
		lblhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblhat.getWidth(), lblhat.getHeight(), Image.SCALE_SMOOTH);//이미지 저장 위치 수정 필수
					
					lblhat.setIcon(new ImageIcon(image));//이미지저장위치 수정 필수
				}
			}
		});
		lblhat.setForeground(Color.BLACK);
		lblhat.setBackground(Color.LIGHT_GRAY);
		lblhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblhat.setBounds(324, 6, 100, 100);
		lblhat.setOpaque(true);
		in_mypreset.add(lblhat);
		
		JLabel lbltop = new JLabel("상의 등록하기");
		lbltop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lbltop.getWidth(), lbltop.getHeight(), Image.SCALE_SMOOTH);//이미지 저장 위치 수정 필수
					
					lbltop.setIcon(new ImageIcon(image));//이미지저장위치 수정 필수
				}
			}
		});
		lbltop.setBackground(Color.LIGHT_GRAY);
		lbltop.setForeground(Color.BLACK);
		lbltop.setHorizontalAlignment(SwingConstants.CENTER);
		lbltop.setBounds(324, 111, 100, 100);
		lbltop.setOpaque(true);
		in_mypreset.add(lbltop);
		
		JLabel lblpants = new JLabel("하의 등록하기");
		lblpants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblpants.getWidth(), lblpants.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
					
					lblpants.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
				}
			}
		});
		lblpants.setBackground(Color.LIGHT_GRAY);
		lblpants.setHorizontalAlignment(SwingConstants.CENTER);
		lblpants.setBounds(324, 216, 100, 100);
		lblpants.setOpaque(true);
		in_mypreset.add(lblpants);
		
		JLabel lblshoes = new JLabel("신발 등록하기");
		lblshoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblshoes.getWidth(), lblshoes.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
					
					lblshoes.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
				}
			}
		});
		lblshoes.setBackground(Color.LIGHT_GRAY);
		lblshoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblshoes.setBounds(324, 322, 100, 100);
		lblshoes.setOpaque(true);
		in_mypreset.add(lblshoes);
		
		JLabel lblonepiece = new JLabel("상하의 등록하기");
		lblonepiece.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblonepiece.getWidth(), lblonepiece.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
					
					lblonepiece.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
				}
			}
		});
		lblonepiece.setOpaque(true);
		lblonepiece.setHorizontalAlignment(SwingConstants.CENTER);
		lblonepiece.setBackground(Color.LIGHT_GRAY);
		lblonepiece.setBounds(212, 111, 100, 205);
		in_mypreset.add(lblonepiece);
		
		JLabel lblouter = new JLabel("아우터 등록하기");
		lblouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblouter.getWidth(), lblouter.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
					
					lblouter.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
				}
			}
		});
		lblouter.setOpaque(true);
		lblouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblouter.setBackground(Color.LIGHT_GRAY);
		lblouter.setBounds(436, 111, 100, 205);
		in_mypreset.add(lblouter);
		
		JLabel lblbag = new JLabel("가방 등록하기");
		lblbag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser browseImageFile = new JFileChooser();
				//Filter image extensions
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","PNG","JPG","JPEG");
				browseImageFile.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImageFile.showOpenDialog(null);
				
				if(showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = browseImageFile.getSelectedFile();
					String selectedImagePath = selectedImageFile.getAbsolutePath();
					//JOptionPane.showMessageDialog(null, selectedImagePath);
					//Display image on label
					ImageIcon ii = new ImageIcon(selectedImagePath);
					//Resize image to fit label
					Image image = ii.getImage().getScaledInstance(lblbag.getWidth(), lblbag.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
					
					lblbag.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
				}
			}
		});
		lblbag.setOpaque(true);
		lblbag.setHorizontalAlignment(SwingConstants.CENTER);
		lblbag.setBackground(Color.LIGHT_GRAY);
		lblbag.setBounds(543, 170, 100, 100);
		in_mypreset.add(lblbag);
		
		notice = new JPanel();
		layeredPane.add(notice, "name_10033259740421");
		notice.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("공지사항");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(6, 6, 86, 35);
		notice.add(lblNewLabel_4);
		
		JScrollPane scrollPane_iq_1 = new JScrollPane();
		scrollPane_iq_1.setBounds(6, 49, 913, 482);
		notice.add(scrollPane_iq_1);
		
		table_nt = new JTable();
		scrollPane_iq_1.setViewportView(table_nt);
		
		JComboBox cbtitle_nt = new JComboBox();
		cbtitle_nt.setModel(new DefaultComboBoxModel(new String[] {"제목", "제목+내용"}));
		cbtitle_nt.setBounds(514, 7, 116, 27);
		notice.add(cbtitle_nt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(642, 6, 208, 26);
		notice.add(textField_4);
		
		JButton btnLoad_nt = new JButton("검색");
		btnLoad_nt.setBounds(854, 6, 65, 29);
		notice.add(btnLoad_nt);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10036677548749");
		inquiry.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("1:1 문의");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(6, 6, 81, 27);
		inquiry.add(lblNewLabel_5);
		
		JScrollPane scrollPane_iq = new JScrollPane();
		scrollPane_iq.setBounds(6, 49, 913, 482);
		inquiry.add(scrollPane_iq);
		
		table_iq = new JTable();
		scrollPane_iq.setViewportView(table_iq);
		
		JComboBox cbtitle_iq = new JComboBox();
		cbtitle_iq.setBounds(450, 5, 116, 27);
		inquiry.add(cbtitle_iq);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(578, 4, 208, 26);
		inquiry.add(textField_3);
		
		JButton btnLoad_iq = new JButton("조회");
		btnLoad_iq.setBounds(790, 4, 65, 29);
		inquiry.add(btnLoad_iq);
		
		JButton btnWrite_iq = new JButton("글쓰기");
		btnWrite_iq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertQnA.main(null);
			}
		});
		btnWrite_iq.setBounds(854, 4, 65, 29);
		inquiry.add(btnWrite_iq);
		
		JButton btnmyProfile = new JButton("내 프로필");
		btnmyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(myprofile);//탭전환
			}
		});
		btnmyProfile.setBounds(52, 63, 151, 50);
		frame.getContentPane().add(btnmyProfile);
		
		JButton btnBest = new JButton("Best");
		btnBest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(bestitem);//탭전환
			}
		});
		btnBest.setBounds(52, 125, 151, 50);
		frame.getContentPane().add(btnBest);
		
		JButton btnallCloset = new JButton("모두의 옷장");
		btnallCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(allcloset);//탭전환
			}
		});
		btnallCloset.setBounds(52, 187, 151, 50);
		frame.getContentPane().add(btnallCloset);
		
		JButton btnmyCloset = new JButton("나의 옷장");
		btnmyCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(mycloset);//탭전환
			}
		});
		btnmyCloset.setBounds(52, 249, 151, 50);
		frame.getContentPane().add(btnmyCloset);
		
		JButton btnNotice = new JButton("공지사항");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(notice);//탭전환
			}
		});
		btnNotice.setBounds(52, 311, 151, 50);
		frame.getContentPane().add(btnNotice);
		
		JButton btnInquiry = new JButton("1:1 문의");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(inquiry);//탭전환
			}
		});
		btnInquiry.setBounds(52, 373, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnlogOut = new JButton("로그아웃");
		btnlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tab.main(null);
			}
		});
		btnlogOut.setBounds(86, 435, 117, 29);
		frame.getContentPane().add(btnlogOut);
		
		JLabel lblNewLabel_8 = new JLabel("김민규 님 환영합니다");
		lblNewLabel_8.setBounds(52, 36, 151, 16);
		frame.getContentPane().add(lblNewLabel_8);
	}
}

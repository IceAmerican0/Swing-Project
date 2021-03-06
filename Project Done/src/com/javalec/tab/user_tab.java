package com.javalec.tab;

import java.awt.EventQueue	;			
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

import com.javalec.function.ShareVar;
import com.javalec.login.Login;
import com.javalec.profile.ChangeImageAction;
import com.javalec.profile.ChangePassword;
import com.javalec.profile.CloseAcount;
import com.javalec.profile.CloseAcountAction;
import com.javalec.user.ClothList;
import com.javalec.user.ClothMain;
import com.javalec.user.DocumentForAll;
import com.javalec.user.InsertCloth;
import com.javalec.user.InsertDocument;
import com.javalec.user.MyClothList;
import com.javalec.user.UpdateCloth;
import com.javalec.user.UserPreset;
import com.javalec.with.InsertQuery;
import com.javalec.with.NoticeMain;
import com.javalec.with.QueryMain;
import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.Font;

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
	private JPanel in_mypreset;
	private JPanel in_mycloset;
	private JLayeredPane inmycloset;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_nt;
	private JTable table_iq;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	
	//??? ???????????? (2021.04.27 ?????????)
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	//??? ???????????? (2021.04.27 ?????????)
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
		
		// jy : ?????? start
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				if(ShareVar.closeIndex==1) {
					ShareVar.nowId="";
					ShareVar.nowPw="";
					ShareVar.userEmail="";
					ShareVar.userName="";
					ShareVar.blindTime=null;
					frame.dispose();
					ShareVar.closeIndex=0;
					Login.main(null);
				}
				
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		// jy : ?????? end 
		
		frame.setBounds(100, 100, 930, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(250, 63, 600, 400);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		myprofile = new JPanel();
		layeredPane.add(myprofile, "name_10014477907462");
		myprofile.setLayout(null);
		
		JLabel lblImage = new JLabel("????????? ????????? ??????????????????");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(25, 23, 280, 280);
		myprofile.add(lblImage);
		
		
		// jy : ?????? start
		String filePath = Integer.toString(ShareVar.ProfileImg);
		ImageIcon ii = new ImageIcon(filePath);
		Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
		
		lblImage.setIcon(new ImageIcon(image));
//		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		
		
//		File selectedImageFile = browseImageFile.getSelectedFile();
//		String selectedImagePath = selectedImageFile.getAbsolutePath();
//		JOptionPane.showMessageDialog(null, selectedImagePath);
//		//Display image on label
//		ImageIcon ii = new ImageIcon(selectedImagePath);
//		//Resize image to fit label
//		Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//		
//		lblImage.setIcon(new ImageIcon(image));
		
		// jy : ?????? end
		
		JLabel lblNewLabel_6 = new JLabel("?????? :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(314, 80, 61, 16);
		myprofile.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("????????? :");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setBounds(314, 114, 61, 16);
		myprofile.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("????????? :");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1.setBounds(314, 148, 61, 16);
		myprofile.add(lblNewLabel_6_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(386, 76, 100, 26);
		myprofile.add(textField);
		textField.setColumns(10);
		textField.setText(ShareVar.userName); // jy : ??????
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(387, 109, 99, 26);
		myprofile.add(textField_1); 
		textField_1.setText(ShareVar.nowId); // jy : ??????
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(387, 143, 179, 26);
		myprofile.add(textField_2);
		textField_2.setText(ShareVar.userEmail);
		
		JButton btnNewButton = new JButton("???????????? ??????");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.main(null); // jy : ??????
			}
		});
		btnNewButton.setBounds(329, 336, 117, 29);
		myprofile.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("????????????");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAcount.main(null); // jy : ??????
			}
		});
		btnNewButton_1.setBounds(449, 336, 117, 29);
		myprofile.add(btnNewButton_1);
		
		JButton btnBrowse = new JButton("???????????????");
		btnBrowse.addActionListener(new ActionListener() {
			//????????? ?????? ???????????? 2021.04.28 ?????????
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
					
					// jy : ?????? start
					FileInputStream input = null;
					File file = new File(selectedImagePath);
					try {
						input = new FileInputStream(file);
					} catch (FileNotFoundException error) {
						// TODO Auto-generated catch block
						error.printStackTrace();
					}
					
					ChangeImageAction changeImageAction = new ChangeImageAction(ShareVar.nowId, input);
					boolean aaa = changeImageAction.UpdateImageAction();
					if(aaa == true){
						JOptionPane.showMessageDialog(null, ShareVar.userName +" ?????? ????????? ?????? ???????????????.!");                    
					}else{
						JOptionPane.showMessageDialog(null, "DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!");                    
					}
					// jy : ?????? end
				}
				
			}
		});
		btnBrowse.setBounds(100, 336, 117, 29);
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
		
		JButton btnLoad_nt_1_1 = new JButton("??????");
		btnLoad_nt_1_1.setBounds(854, 6, 65, 29);
		bestitem.add(btnLoad_nt_1_1);
		
		allcloset = new JPanel();
		layeredPane.add(allcloset, "name_10028148525053");
		allcloset.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("????????? ??????");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 104, 27);
		allcloset.add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("????????????");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertDocument.main(null);
			}
		});
		btnNewButton_4.setBounds(802, 6, 117, 29);
		allcloset.add(btnNewButton_4);
		
		JComboBox cbtitle_nt_1 = new JComboBox();
		cbtitle_nt_1.setModel(new DefaultComboBoxModel(new String[] {"??????", "??????+??????", "?????????"}));
		cbtitle_nt_1.setBounds(397, 7, 116, 27);
		allcloset.add(cbtitle_nt_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(525, 6, 208, 26);
		allcloset.add(textField_5);
		
		JButton btnLoad_nt_1 = new JButton("??????");
		btnLoad_nt_1.setBounds(737, 6, 65, 29);
		allcloset.add(btnLoad_nt_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 45, 913, 486);
		allcloset.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		mycloset = new JPanel();
		layeredPane.add(mycloset, "name_10030972904756");
		mycloset.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("?????? ??????");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(6, 6, 126, 37);
		mycloset.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("??????");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels2(in_mycloset);
				ClothMain.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(144, 11, 75, 29);
		mycloset.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("?????????");
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
		
		JButton btnNewButton_2_1 = new JButton("??? ??????");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCloth.main(null);
				UpdateCloth.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1.setBounds(6, 6, 98, 29);
		in_mycloset.add(btnNewButton_2_1);
		
		in_mypreset = new JPanel();
		inmycloset.add(in_mypreset, "name_83833397636156");
		in_mypreset.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("?????????");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(6, 6, 87, 39);
		in_mypreset.add(lblNewLabel_9);
		
		JLabel lblhat = new JLabel("?????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblhat.getWidth(), lblhat.getHeight(), Image.SCALE_SMOOTH);//????????? ?????? ?????? ?????? ??????
					
					lblhat.setIcon(new ImageIcon(image));//????????????????????? ?????? ??????
				}
			}
		});
		lblhat.setForeground(Color.BLACK);
		lblhat.setBackground(Color.LIGHT_GRAY);
		lblhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblhat.setBounds(324, 6, 100, 100);
		lblhat.setOpaque(true);
		in_mypreset.add(lblhat);
		
		JLabel lbltop = new JLabel("?????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lbltop.getWidth(), lbltop.getHeight(), Image.SCALE_SMOOTH);//????????? ?????? ?????? ?????? ??????
					
					lbltop.setIcon(new ImageIcon(image));//????????????????????? ?????? ??????
				}
			}
		});
		lbltop.setBackground(Color.LIGHT_GRAY);
		lbltop.setForeground(Color.BLACK);
		lbltop.setHorizontalAlignment(SwingConstants.CENTER);
		lbltop.setBounds(324, 111, 100, 100);
		lbltop.setOpaque(true);
		in_mypreset.add(lbltop);
		
		JLabel lblpants = new JLabel("?????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblpants.getWidth(), lblpants.getHeight(), Image.SCALE_SMOOTH);//????????? ???????????? ?????? ??????
					
					lblpants.setIcon(new ImageIcon(image));//????????? ???????????? ?????? ??????
				}
			}
		});
		lblpants.setBackground(Color.LIGHT_GRAY);
		lblpants.setHorizontalAlignment(SwingConstants.CENTER);
		lblpants.setBounds(324, 216, 100, 100);
		lblpants.setOpaque(true);
		in_mypreset.add(lblpants);
		
		JLabel lblshoes = new JLabel("?????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblshoes.getWidth(), lblshoes.getHeight(), Image.SCALE_SMOOTH);//????????? ???????????? ?????? ??????
					
					lblshoes.setIcon(new ImageIcon(image));//????????? ???????????? ?????? ??????
				}
			}
		});
		lblshoes.setBackground(Color.LIGHT_GRAY);
		lblshoes.setHorizontalAlignment(SwingConstants.CENTER);
		lblshoes.setBounds(324, 322, 100, 100);
		lblshoes.setOpaque(true);
		in_mypreset.add(lblshoes);
		
		JLabel lblonepiece = new JLabel("????????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblonepiece.getWidth(), lblonepiece.getHeight(), Image.SCALE_SMOOTH);//????????? ???????????? ?????? ??????
					
					lblonepiece.setIcon(new ImageIcon(image));//????????? ???????????? ?????? ??????
				}
			}
		});
		lblonepiece.setOpaque(true);
		lblonepiece.setHorizontalAlignment(SwingConstants.CENTER);
		lblonepiece.setBackground(Color.LIGHT_GRAY);
		lblonepiece.setBounds(212, 111, 100, 205);
		in_mypreset.add(lblonepiece);
		
		JLabel lblouter = new JLabel("????????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblouter.getWidth(), lblouter.getHeight(), Image.SCALE_SMOOTH);//????????? ???????????? ?????? ??????
					
					lblouter.setIcon(new ImageIcon(image));//????????? ???????????? ?????? ??????
				}
			}
		});
		lblouter.setOpaque(true);
		lblouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblouter.setBackground(Color.LIGHT_GRAY);
		lblouter.setBounds(436, 111, 100, 205);
		in_mypreset.add(lblouter);
		
		JLabel lblbag = new JLabel("?????? ????????????");
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
					Image image = ii.getImage().getScaledInstance(lblbag.getWidth(), lblbag.getHeight(), Image.SCALE_SMOOTH);//????????? ???????????? ?????? ??????
					
					lblbag.setIcon(new ImageIcon(image));//????????? ???????????? ?????? ??????
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
		
		JLabel lblNewLabel_4 = new JLabel("????????????");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(6, 6, 86, 35);
		notice.add(lblNewLabel_4);
		
		JScrollPane scrollPane_iq_1 = new JScrollPane();
		scrollPane_iq_1.setBounds(6, 49, 913, 482);
		notice.add(scrollPane_iq_1);
		
		table_nt = new JTable();
		scrollPane_iq_1.setViewportView(table_nt);
		
		JComboBox cbtitle_nt = new JComboBox();
		cbtitle_nt.setModel(new DefaultComboBoxModel(new String[] {"??????", "??????+??????"}));
		cbtitle_nt.setBounds(514, 7, 116, 27);
		notice.add(cbtitle_nt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(642, 6, 208, 26);
		notice.add(textField_4);
		
		JButton btnLoad_nt = new JButton("??????");
		btnLoad_nt.setBounds(854, 6, 65, 29);
		notice.add(btnLoad_nt);
		
		inquiry = new JPanel();
		layeredPane.add(inquiry, "name_10036677548749");
		inquiry.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("1:1 ??????");
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
		
		JButton btnLoad_iq = new JButton("??????");
		btnLoad_iq.setBounds(790, 4, 65, 29);
		inquiry.add(btnLoad_iq);
		
		JButton btnWrite_iq = new JButton("?????????");
		btnWrite_iq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertQuery.main(null);
			}
		});
		btnWrite_iq.setBounds(854, 4, 65, 29);
		inquiry.add(btnWrite_iq);
		
		JButton btnmyProfile = new JButton("??? ?????????");
		btnmyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(myprofile);//?????????
			}
		});
		btnmyProfile.setBounds(52, 113, 151, 50);
		frame.getContentPane().add(btnmyProfile);
		
		JButton btnallCloset = new JButton("????????? ??????");
		btnallCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(allcloset);//?????????
				DocumentForAll.main(null);
				frame.dispose();
			}
		});
		btnallCloset.setBounds(52, 173, 151, 50);
		frame.getContentPane().add(btnallCloset);
		
		JButton btnmyCloset = new JButton("?????? ??????");
		btnmyCloset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyClothList.main(null);
				frame.dispose();
			}
		});
		btnmyCloset.setBounds(52, 233, 151, 50);
		frame.getContentPane().add(btnmyCloset);
		
		JButton btnNotice = new JButton("????????????");
		btnNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NoticeMain.main(null);
				frame.dispose();
			}
		});
		btnNotice.setBounds(52, 353, 151, 50);
		frame.getContentPane().add(btnNotice);
		
		JButton btnInquiry = new JButton("1:1 ??????");
		btnInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryMain.main(null);
				frame.dispose();
			}
		});
		btnInquiry.setBounds(52, 413, 151, 50);
		frame.getContentPane().add(btnInquiry);
		
		JButton btnlogOut = new JButton("????????????");
		btnlogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.nowId="";
				ShareVar.nowPw="";
				ShareVar.userEmail=""; // jy : ??????
				ShareVar.userName="";
				ShareVar.blindTime=""; // jy : ??????
				frame.dispose();
				Login.main(null);
			}
		});
		btnlogOut.setBounds(86, 72, 117, 29);
		frame.getContentPane().add(btnlogOut);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setText(ShareVar.userName+" ??? ???????????????!");
		lblUsername.setBounds(52, 50, 151, 16);
		frame.getContentPane().add(lblUsername);
		
		JButton btnPreset = new JButton("????????????");
		btnPreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPreset.main(null);
				frame.dispose();
			}
		});
		btnPreset.setBounds(52, 293, 151, 50);
		frame.getContentPane().add(btnPreset);
		
		JLabel lblNewLabel = new JLabel("??? ?????????");
		lblNewLabel.setBounds(247, 29, 97, 26);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}
}

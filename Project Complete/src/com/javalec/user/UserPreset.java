package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.function.ShareVar;
import com.javalec.tab.user_tab;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserPreset {

	private JFrame frame;
	private JLabel lblNewLabel_9;
	private JLabel lblhat;
	private JLabel lbltop;
	private JLabel lblpants;
	private JLabel lblshoes;
	private JLabel lblonepiece;
	private JLabel lblouter;
	private JLabel lblbag;
	private JButton btnMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPreset window = new UserPreset();
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
	public UserPreset() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel_9());
		frame.getContentPane().add(getLblhat());
		frame.getContentPane().add(getLbltop());
		frame.getContentPane().add(getLblpants());
		frame.getContentPane().add(getLblshoes());
		frame.getContentPane().add(getLblonepiece());
		frame.getContentPane().add(getLblouter());
		frame.getContentPane().add(getLblbag());
		frame.getContentPane().add(getBtnMain());
		frame.setLocationRelativeTo(null);
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("프리셋");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setBounds(29, 26, 87, 39);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblhat() {
		if (lblhat == null) {
			lblhat = new JLabel("모자 등록하기");
			lblhat.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="모자";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblhat.setOpaque(true);
			lblhat.setHorizontalAlignment(SwingConstants.CENTER);
			lblhat.setForeground(Color.BLACK);
			lblhat.setBackground(Color.LIGHT_GRAY);
			lblhat.setBounds(328, 26, 132, 100);
			
		}
		return lblhat;
	}
	private JLabel getLbltop() {
		if (lbltop == null) {
			lbltop = new JLabel("상의 등록하기");
			lbltop.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="상의";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lbltop.setOpaque(true);
			lbltop.setHorizontalAlignment(SwingConstants.CENTER);
			lbltop.setForeground(Color.BLACK);
			lbltop.setBackground(Color.LIGHT_GRAY);
			lbltop.setBounds(318, 136, 162, 140);
			
		}
		return lbltop;
	}
	private JLabel getLblpants() {
		if (lblpants == null) {
			lblpants = new JLabel("하의 등록하기");
			lblpants.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="하의";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblpants.setOpaque(true);
			lblpants.setHorizontalAlignment(SwingConstants.CENTER);
			lblpants.setBackground(Color.LIGHT_GRAY);
			lblpants.setBounds(328, 286, 132, 157);
			
		}
		return lblpants;
	}
	private JLabel getLblshoes() {
		if (lblshoes == null) {
			lblshoes = new JLabel("신발 등록하기");
			lblshoes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="신발";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblshoes.setOpaque(true);
			lblshoes.setHorizontalAlignment(SwingConstants.CENTER);
			lblshoes.setBackground(Color.LIGHT_GRAY);
			lblshoes.setBounds(328, 453, 132, 68);
		}
		return lblshoes;
	}
	private JLabel getLblonepiece() {
		if (lblonepiece == null) {
			lblonepiece = new JLabel("원피스 등록하기");
			lblonepiece.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="원피스";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblonepiece.setOpaque(true);
			lblonepiece.setHorizontalAlignment(SwingConstants.CENTER);
			lblonepiece.setBackground(Color.LIGHT_GRAY);
			lblonepiece.setBounds(181, 136, 125, 307);
		}
		return lblonepiece;
	}
	private JLabel getLblouter() {
		if (lblouter == null) {
			lblouter = new JLabel("아우터 등록하기");
			lblouter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="아우터";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblouter.setOpaque(true);
			lblouter.setHorizontalAlignment(SwingConstants.CENTER);
			lblouter.setBackground(Color.LIGHT_GRAY);
			lblouter.setBounds(492, 136, 141, 250);
		}
		return lblouter;
	}
	private JLabel getLblbag() {
		if (lblbag == null) {
			lblbag = new JLabel("가방 등록하기");
			lblbag.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="가방";
					MyPresetList.main(null);
					ImgChk();
				}
			});
			lblbag.setOpaque(true);
			lblbag.setHorizontalAlignment(SwingConstants.CENTER);
			lblbag.setBackground(Color.LIGHT_GRAY);
			lblbag.setBounds(645, 136, 125, 120);
		}
		return lblbag;
	}
	private JButton getBtnMain() {
		if (btnMain == null) {
			btnMain = new JButton("메인으로");
			btnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					user_tab.main(null);
					frame.dispose();
				}
			});
			btnMain.setBounds(128, 34, 97, 23);
		}
		return btnMain;
	}
	
	private void ImgChk() {
//		if(!(ShareVar.HatImg==0))
//		lblhat.setIcon(new ImageIcon(Integer.toString(ShareVar.HatImg)));
//		if(!(ShareVar.TopImg==0))
//			lbltop.setIcon(new ImageIcon(Integer.toString(ShareVar.TopImg)));
//		if(!(ShareVar.BottomImg==0))
//			lblpants.setIcon(new ImageIcon(Integer.toString(ShareVar.BottomImg)));
//		if(!(ShareVar.OuterImg==0))
//			lblouter.setIcon(new ImageIcon(Integer.toString(ShareVar.OuterImg)));
//		if(!(ShareVar.OnepieceImg==0))
//			lblonepiece.setIcon(new ImageIcon(Integer.toString(ShareVar.OnepieceImg)));
//		if(!(ShareVar.ShoesImg==0))
//			lblshoes.setIcon(new ImageIcon(Integer.toString(ShareVar.ShoesImg)));
//		if(!(ShareVar.BagImg==0))
//			lblbag.setIcon(new ImageIcon(Integer.toString(ShareVar.BagImg)));
		
	

		if(!(ShareVar.HatImg==0)) {
			String filePath = Integer.toString(ShareVar.HatImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblhat.getWidth(), lblhat.getHeight(), Image.SCALE_SMOOTH);
			
			lblhat.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.OuterImg==0)) {
			String filePath = Integer.toString(ShareVar.OuterImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblouter.getWidth(), lblouter.getHeight(), Image.SCALE_SMOOTH);
			
			lblouter.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.TopImg==0)) {
			String filePath = Integer.toString(ShareVar.TopImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lbltop.getWidth(), lbltop.getHeight(), Image.SCALE_SMOOTH);
			
			lbltop.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.BottomImg==0)) {
			String filePath = Integer.toString(ShareVar.BottomImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblpants.getWidth(), lblpants.getHeight(), Image.SCALE_SMOOTH);
			
			lblpants.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.BagImg==0)) {
			String filePath = Integer.toString(ShareVar.BagImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblbag.getWidth(), lblbag.getHeight(), Image.SCALE_SMOOTH);
			
			lblbag.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.ShoesImg==0)) {
			String filePath = Integer.toString(ShareVar.ShoesImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblshoes.getWidth(), lblshoes.getHeight(), Image.SCALE_SMOOTH);
			
			lblshoes.setIcon(new ImageIcon(image));
			
		}
		if(!(ShareVar.OnepieceImg==0)) {
			String filePath = Integer.toString(ShareVar.OnepieceImg);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblonepiece.getWidth(), lblonepiece.getHeight(), Image.SCALE_SMOOTH);
			
			lblonepiece.setIcon(new ImageIcon(image));
			
		}
	}
}

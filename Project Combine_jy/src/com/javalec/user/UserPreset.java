package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javalec.function.ShareVar;
import com.javalec.tab.user_tab;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("프리셋");
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setBounds(109, 54, 87, 39);
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
				}
			});
			lblhat.setOpaque(true);
			lblhat.setHorizontalAlignment(SwingConstants.CENTER);
			lblhat.setForeground(Color.BLACK);
			lblhat.setBackground(Color.LIGHT_GRAY);
			lblhat.setBounds(427, 54, 100, 100);
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
				}
			});
			lbltop.setOpaque(true);
			lbltop.setHorizontalAlignment(SwingConstants.CENTER);
			lbltop.setForeground(Color.BLACK);
			lbltop.setBackground(Color.LIGHT_GRAY);
			lbltop.setBounds(427, 159, 100, 100);
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
				}
			});
			lblpants.setOpaque(true);
			lblpants.setHorizontalAlignment(SwingConstants.CENTER);
			lblpants.setBackground(Color.LIGHT_GRAY);
			lblpants.setBounds(427, 264, 100, 100);
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
				}
			});
			lblshoes.setOpaque(true);
			lblshoes.setHorizontalAlignment(SwingConstants.CENTER);
			lblshoes.setBackground(Color.LIGHT_GRAY);
			lblshoes.setBounds(427, 370, 100, 100);
		}
		return lblshoes;
	}
	private JLabel getLblonepiece() {
		if (lblonepiece == null) {
			lblonepiece = new JLabel("상하의 등록하기");
			lblonepiece.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ShareVar.cloth="원피스";
					MyPresetList.main(null);
				}
			});
			lblonepiece.setOpaque(true);
			lblonepiece.setHorizontalAlignment(SwingConstants.CENTER);
			lblonepiece.setBackground(Color.LIGHT_GRAY);
			lblonepiece.setBounds(315, 159, 100, 205);
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
				}
			});
			lblouter.setOpaque(true);
			lblouter.setHorizontalAlignment(SwingConstants.CENTER);
			lblouter.setBackground(Color.LIGHT_GRAY);
			lblouter.setBounds(539, 159, 100, 205);
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
				}
			});
			lblbag.setOpaque(true);
			lblbag.setHorizontalAlignment(SwingConstants.CENTER);
			lblbag.setBackground(Color.LIGHT_GRAY);
			lblbag.setBounds(646, 218, 100, 100);
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
			btnMain.setBounds(208, 62, 97, 23);
		}
		return btnMain;
	}
}

package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class ClothMain {

	private JFrame frame;

	
	 private Connection conn;
	 private PreparedStatement stmt;
	 private ResultSet rs;
	 
	 BufferedImage bi;
	 String filename =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothMain window = new ClothMain();
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
	public ClothMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("옷장");
		frame.setBounds(100, 100, 368, 427);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getClothname());
}	

	
	 //Images 
    FileInputStream fis;
    private JComboBox comboBox;
    private JLabel lblNewLabel;
    private JButton btnUpdate;
    private JButton btnNewButton_1;
    private JLabel lblImage;
    private JButton btnCancel;
    private JPanel panel;
    private JLabel lblNewLabel_1;
    private JTextField clothname;
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"모자", "상의", "하의", "원피스", "아우터", "신발"}));
			comboBox.setBounds(86, 284, 138, 27);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("종류 :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(24, 288, 50, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					change();
				}
			});
			btnUpdate.setBounds(91, 362, 89, 29);
		}
		return btnUpdate;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("취소");
			btnNewButton_1.setBounds(182, 334, 89, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/tj/Documents/Kenny/Temp/null.png"));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(22, 484, 215, 112);
		}
		return lblImage;
	}
	private JLabel getLblImage_1() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBackground(Color.WHITE);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblImage;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancel.setBounds(178, 362, 89, 29);
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(22, 6, 317, 226);
			panel.add(getLblImage_1());
		}
		return panel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setBounds(22, 247, 50, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getClothname() {
		if (clothname == null) {
			clothname = new JTextField();
			clothname.setEditable(false);
			clothname.setBounds(89, 244, 130, 26);
			clothname.setColumns(10);
		}
		return clothname;
	}
	private void change() {
		//수정으로 이동

	}

	
}
package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.tab.user_tab;

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

public class ClothList {

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
					ClothList window = new ClothList();
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
	public ClothList() {
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
		frame.getContentPane().add(getBtnSelect());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getClothname());
		frame.setLocationRelativeTo(null);
}	

	
	 //Images 
    FileInputStream fis;
    private JComboBox comboBox;
    private JLabel lblNewLabel;
    private JButton btnSelect;
    private JButton btnNewButton_1;
    private JButton btnCancel;
    private JPanel panel;
    private JLabel lblNewLabel_1;
    private JTextField clothname;
    private JLabel lblImage;
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"모자", "상의", "하의", "원피스", "아우터", "신발"}));
			comboBox.setBounds(76, 11, 138, 27);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("종류 :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(14, 15, 50, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnSelect() {
		if (btnSelect == null) {
			btnSelect = new JButton("선택");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					change();
				}
			});
			btnSelect.setBounds(91, 362, 89, 29);
		}
		return btnSelect;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("취소");
			btnNewButton_1.setBounds(182, 334, 89, 29);
		}
		return btnNewButton_1;
	}
	
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					user_tab.main(null);
				}
			});
			btnCancel.setBounds(178, 362, 89, 29);
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(23, 46, 317, 276);
			panel.add(getLblImage());
		}
		return panel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setBounds(19, 334, 50, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getClothname() {
		if (clothname == null) {
			clothname = new JTextField();
			clothname.setEditable(false);
			clothname.setBounds(86, 331, 130, 26);
			clothname.setColumns(10);
		}
		return clothname;
	}
	private void change() {
		//수정으로 이동

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
}
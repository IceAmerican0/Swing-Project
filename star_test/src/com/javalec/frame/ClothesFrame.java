package com.javalec.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ClothesFrame {

	private JFrame frame;
	private JLabel ClothesData;
	private JLabel ClothesName;
	private JLabel likeImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothesFrame window = new ClothesFrame();
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
	public ClothesFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 225, 290);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getClothesData());
		frame.getContentPane().add(getClothesName());
		frame.getContentPane().add(getLikeImage());
	}

	private JLabel getClothesData() {
		if (ClothesData == null) {
			ImageIcon icon = new ImageIcon("/Users/biso/Downloads/clothes.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			ClothesData = new JLabel(changeIcon);
			ClothesData.setBounds(24, 6, 177, 197);
			ClothesData.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return ClothesData;
	}
	private JLabel getClothesName() {
		if (ClothesName == null) {
			ClothesName = new JLabel("Title");
			ClothesName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			ClothesName.setBounds(24, 215, 61, 16);
		}
		return ClothesName;
	}
	private JLabel getLikeImage() {
		if (likeImage == null) {
			ImageIcon icon = new ImageIcon("/Users/biso/Downloads/1.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			likeImage = new JLabel(changeIcon);
			likeImage.setBounds(159, 209, 30, 29);
			likeImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return likeImage;
	}
}

package com.javalec.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PostFrame {

	private JFrame frame;
	private JLabel ClothesData;
	private JLabel userName;
	private JLabel PostTitle;
	private JLabel userImage;
	private JLabel likeImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostFrame window = new PostFrame();
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
	public PostFrame() {
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
		frame.getContentPane().add(getUserName());
		frame.getContentPane().add(getPostTitle());
		frame.getContentPane().add(getUserImage());
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
	private JLabel getUserName() {
		if (userName == null) {
			userName = new JLabel("name");
			userName.setBounds(42, 215, 61, 16);
			userName.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		}
		return userName;
	}
	private JLabel getPostTitle() {
		if (PostTitle == null) {
			PostTitle = new JLabel("Title");
			PostTitle.setBounds(42, 237, 61, 16);
			PostTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		}
		return PostTitle;
	}
	private JLabel getUserImage() {
		if (userImage == null) {
			ImageIcon icon = new ImageIcon("/Users/biso/Downloads/user.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			userImage = new JLabel(changeIcon);
			userImage.setBounds(6, 219, 35, 34);
			userImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return userImage;
	}
	private JLabel getLikeImage() {
		if (likeImage == null) {
			ImageIcon icon = new ImageIcon("/Users/biso/Downloads/1.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(28, 28, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			likeImage = new JLabel(changeIcon);
			likeImage.setBounds(167, 224, 30, 29);
			likeImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return likeImage;
	}
}

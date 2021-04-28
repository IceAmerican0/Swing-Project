package com.javalec.with;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class DocumentMain {

	private JFrame frame;
	private JLabel ClothesData;
	private JLabel userImage;
	private JLabel userName;
	private JLabel PostTitle;
	private JLabel lblDatetime;
	private JPanel postpanel;
	private JTextArea documentArea;
	private JButton btnNewButton;
	private JPanel commentpanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnUpdate;
	private JButton btndelete;
	private JButton btnheart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentMain window = new DocumentMain();
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
	public DocumentMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 343, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getClothesData());
		frame.getContentPane().add(getUserImage());
		frame.getContentPane().add(getUserName());
		frame.getContentPane().add(getPostTitle());
		frame.getContentPane().add(getLblDatetime());
		frame.getContentPane().add(getPostpanel());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getCommentpanel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtndelete());
		frame.getContentPane().add(getBtnheart());
	}

	private JLabel getClothesData() {
		if (ClothesData == null) {
			ClothesData = new JLabel((Icon) null);
			ClothesData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothesData.setBounds(28, 8, 281, 253);
		}
		return ClothesData;
	}
	private JLabel getUserImage() {
		if (userImage == null) {
			userImage = new JLabel((Icon) null);
			userImage.setHorizontalAlignment(SwingConstants.CENTER);
			userImage.setBounds(28, 277, 35, 34);
		}
		return userImage;
	}
	private JLabel getUserName() {
		if (userName == null) {
			userName = new JLabel("name");
			userName.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			userName.setBounds(64, 273, 61, 16);
		}
		return userName;
	}
	private JLabel getPostTitle() {
		if (PostTitle == null) {
			PostTitle = new JLabel("Title");
			PostTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			PostTitle.setBounds(64, 295, 61, 16);
		}
		return PostTitle;
	}
	private JLabel getLblDatetime() {
		if (lblDatetime == null) {
			lblDatetime = new JLabel("datetime");
			lblDatetime.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblDatetime.setBounds(183, 273, 61, 16);
		}
		return lblDatetime;
	}
	private JPanel getPostpanel() {
		if (postpanel == null) {
			postpanel = new JPanel();
			postpanel.setBounds(28, 323, 286, 199);
			postpanel.add(getDocumentArea());
		}
		return postpanel;
	}
	private JTextArea getDocumentArea() {
		if (documentArea == null) {
			documentArea = new JTextArea();
		}
		return documentArea;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(197, 529, 117, 29);
		}
		return btnNewButton;
	}
	private JPanel getCommentpanel() {
		if (commentpanel == null) {
			commentpanel = new JPanel();
			commentpanel.setBounds(28, 560, 286, 39);
			commentpanel.add(getTextArea());
		}
		return commentpanel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 611, 286, 93);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/pencil.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			btnUpdate = new JButton(changeIcon);
			btnUpdate.setHorizontalAlignment(SwingConstants.CENTER);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnUpdate.setBounds(247, 282, 24, 29);
		}
		return btnUpdate;
	}
	private JButton getBtndelete() {
		if (btndelete == null) {
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/cancel.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			btndelete = new JButton(changeIcon);
			btndelete.setHorizontalAlignment(SwingConstants.CENTER);
			btndelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btndelete.setBounds(247, 282, 24, 29);
		}
		return btndelete;
	}
	private JButton getBtnheart() {
		if (btnheart == null) {
			btnheart = new JButton("New button");
			btnheart.setIcon(new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/1.png"));
			btnheart.setBounds(298, 282, 24, 29);
		}
		return btnheart;
	}
}

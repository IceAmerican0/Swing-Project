package com.javalec.with;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.DbAction;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DocumentMain {

	private JFrame frame;
	private JLabel ClothesData;
	private JLabel userImage;
	private JLabel userName;
	private JLabel PostTitle;
	private JLabel lblDatetime;
	private JPanel postpanel;
	private JTextArea documentArea;
	private JPanel commentpanel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JButton btnUpdate;
	private JButton btndelete;
	private JButton btnheart;
	private JLabel lblComment;
	private JButton btnComment;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
				UserCheck();
			}
		});
		frame.setBounds(100, 100, 343, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getClothesData());
		frame.getContentPane().add(getUserImage());
		frame.getContentPane().add(getUserName());
		frame.getContentPane().add(getPostTitle());
		frame.getContentPane().add(getLblDatetime());
		frame.getContentPane().add(getPostpanel());
		frame.getContentPane().add(getCommentpanel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtndelete());
		frame.getContentPane().add(getBtnheart());
		frame.getContentPane().add(getLblComment());
		frame.getContentPane().add(getBtnComment());
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
			documentArea = new JTextArea(20,30);
			documentArea.setLineWrap(true);
		}
		return documentArea;
	}
	private JPanel getCommentpanel() {
		if (commentpanel == null) {
			commentpanel = new JPanel();
			commentpanel.setBounds(28, 549, 286, 39);
			commentpanel.add(getTextArea());
		}
		return commentpanel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20,30);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 600, 286, 124);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/pencil.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			btnUpdate = new JButton(changeIcon);
			btnUpdate.setHorizontalAlignment(SwingConstants.CENTER);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnUpdate.setBounds(251, 282, 24, 29);
		}
		return btnUpdate;
	}
	private JButton getBtndelete() {
		if (btndelete == null) {
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/cancel.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			btndelete = new JButton(changeIcon);
			btndelete.setHorizontalAlignment(SwingConstants.CENTER);
			btndelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btndelete.setBounds(274, 282, 24, 29);
		}
		return btndelete;
	}
	private JButton getBtnheart() {
		if (btnheart == null) {
			
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/1.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			btnheart = new JButton(changeIcon);
			btnheart.setHorizontalAlignment(SwingConstants.CENTER);
			btnheart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnheart.setBounds(298, 282, 24, 29);
		}
		return btnheart;
	}
	private JLabel getLblComment() {
		if (lblComment == null) {
			lblComment = new JLabel("댓글 작성하기");
			lblComment.setBounds(23, 534, 299, 16);
		}
		return lblComment;
	}
	private JButton getBtnComment() {
		if (btnComment == null) {
			btnComment = new JButton("등록");
			btnComment.setBounds(261, 529, 46, 16);
		}
		return btnComment;
	}
	private void TableInit() {
		 int i = Outer_Table.getRowCount();
	        
	        Outer_Table.addColumn("Seq.");
	        Outer_Table.addColumn("내용");
	        Outer_Table.addColumn("작성자");
	        Outer_Table.addColumn("작성시간");
	        Outer_Table.setColumnCount(4);

	        for(int j = 0 ; j < i ; j++){
	            Outer_Table.removeRow(0);
	        }

	        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
	        

	        int vColIndex = 0;
	        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        int width = 30;
	        col.setPreferredWidth(width);

	        vColIndex = 1;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 150;
	        col.setPreferredWidth(width);

	        vColIndex = 2;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 80;
	        col.setPreferredWidth(width);

	        vColIndex = 3;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 100;
	        col.setPreferredWidth(width);

	}
	private void SearchAction() {
		DbAction dbAction = new DbAction();
		ArrayList<Bean> beanList = dbAction.DocumentList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getSeqno());
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getName(),beanList.get(index).getTime()};
			Outer_Table.addRow(qTxt);
		}


	}
	private void UserCheck() {
		// TODO Auto-generated method stub

	}
}

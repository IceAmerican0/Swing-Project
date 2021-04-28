package com.javalec.user;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.javalec.function.Bean;
import com.javalec.with.WithAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReadNotice {

	private JFrame frame;
	private JTextField titleF;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel lblPost;
	private JButton btnInsertDB;
	private JLabel lblUserName;
	private JTextField userF;
	private JTextField dateF;
	private JLabel lblDate;
	private JLabel lblSeq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadNotice window = new ReadNotice();
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
	public ReadNotice() {
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
				SearchAction();
			}
		});
		frame.setBounds(100, 100, 454, 458);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTitleF());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblPost());
		frame.getContentPane().add(getBtnInsertDB());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getUserF());
		frame.getContentPane().add(getDateF());
		frame.getContentPane().add(getLblDate());
		frame.getContentPane().add(getLblSeq());
	}

	public JTextField getTitleF() {
		if (titleF == null) {
			titleF = new JTextField();
			titleF.setEditable(false);
			titleF.setColumns(10);
			titleF.setBounds(43, 6, 197, 26);
		}
		return titleF;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목 :");
			lblTitle.setBounds(6, 11, 61, 16);
		}
		return lblTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 82, 424, 297);
			panel.add(getTextArea());
		}
		return panel;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20, 30);
			textArea.setEditable(false);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JLabel getLblPost() {
		if (lblPost == null) {
			lblPost = new JLabel("내용 :");
			lblPost.setBounds(6, 64, 61, 16);
		}
		return lblPost;
	}
	private JButton getBtnInsertDB() {
		if (btnInsertDB == null) {
			btnInsertDB = new JButton("확인");
			btnInsertDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				frame.dispose();
				}
			});
			btnInsertDB.setBounds(187, 395, 81, 29);
		}
		return btnInsertDB;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("작성자 :");
			lblUserName.setBounds(6, 40, 61, 16);
		}
		return lblUserName;
	}
	public JTextField getUserF() {
		if (userF == null) {
			userF = new JTextField();
			userF.setEditable(false);
			userF.setBounds(55, 35, 88, 26);
			userF.setColumns(10);
		}
		return userF;
	}
	public JTextField getDateF() {
		if (dateF == null) {
			dateF = new JTextField();
			dateF.setEditable(false);
			dateF.setBounds(283, 8, 158, 26);
			dateF.setColumns(10);
		}
		return dateF;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("date :");
			lblDate.setBounds(244, 13, 197, 16);
		}
		return lblDate;
	}
	private JLabel getLblSeq() {
		if (lblSeq == null) {
			lblSeq = new JLabel("");
			lblSeq.setBounds(157, 40, 61, 16);
		}
		return lblSeq;
	}
	private void SearchAction() {
		System.out.println(Bean.seqIndex);
		WithAction WithAction = new WithAction(Bean.seqIndex);
        Bean bean = WithAction.QueryTableClick();
        
       lblSeq.setText(Integer.toString(bean.getSeqno()));
       titleF.setText(bean.getTitle());
       textArea.setText(bean.getContent());
       dateF.setText(bean.getTime());
//       qnaComment.getDateF().setText(bean.getTime());
	}
	


		
	
}

package com.javalec.community;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.javalec.function.DbAction;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Panel;
import javax.swing.JTextArea;

public class WriteReply {

	private JFrame frame;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WriteReply window = new WriteReply();
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
	public WriteReply() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 145);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getPanel());
		
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnOK.setBounds(106, 88, 117, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			});
			btnCancel.setBounds(224, 88, 117, 29);
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 6, 438, 73);
			panel.add(getTextArea());
			
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20,30);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private void check() {
		if (textArea.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "내용을 입력해주세요!");
		}
		if (textArea.getText().length()>=140) {
			JOptionPane.showMessageDialog(null, "140자 이하로 입력해주세요!");
		}
		else {
			//database input
			insertAction();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	private void insertAction() {
		String text = textArea.getText();
		String userid = "null";
		//작성자 정보 가져오기
		
		com.javalec.function.DbAction dbaction = new com.javalec.function.DbAction();
		boolean aaa = dbaction.InsertReply(userid, text);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, userid+" 님의 댓글이 입력 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}

	}
}

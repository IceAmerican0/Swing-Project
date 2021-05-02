package com.javalec.find;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.login.Login;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindId {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JTextField tfEmail;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindId window = new FindId();
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
	public FindId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.setLocationRelativeTo(null);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(115, 103, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setToolTipText("이름을 입력하세요");
			tfName.setBounds(188, 98, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이메일");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(115, 136, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setHorizontalAlignment(SwingConstants.LEFT);
			tfEmail.setToolTipText("이메일을 입력하세요");
			tfEmail.setColumns(10);
			tfEmail.setBounds(188, 131, 130, 26);
		}
		return tfEmail;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("찾기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Findid();
				}
			});
			btnNewButton.setBounds(115, 176, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("아이디 찾기");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(124, 31, 194, 60);
		}
		return lblNewLabel_2;
	}
	
	private void Findid() {
		String name=tfName.getText().trim();
		String email=tfEmail.getText().trim();
		
		if(name.equals(""))  {
			JOptionPane.showMessageDialog(null,"이름을 입력해주세요!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
			tfName.grabFocus();
		}else if(email.equals("")) {
			JOptionPane.showMessageDialog(null,"이메일을 입력해주세요!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
			tfEmail.grabFocus();
		}else{
			FindIdAction findAction=new FindIdAction(name,email);
			String id=findAction.IdfindAction();
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null,name+" 님의 정보가 존재하지 않습니다!","ErrorMessage",JOptionPane.ERROR_MESSAGE);
				tfName.setText("");
				tfEmail.setText("");
				tfName.grabFocus();
			}
			else {
				JOptionPane.showMessageDialog(null, name+" 님의 아이디\n"+id);
				frame.dispose();
				Login.main(null);
			}
		}
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("취소");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					Login.main(null);
				}
			});
			btnNewButton_1.setBounds(232, 176, 117, 29);
		}
		return btnNewButton_1;
	}
}

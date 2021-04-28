package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PullImage {

	private JFrame frame;
	private JLabel lblImage0;
	private JLabel lblImage1;
	private JLabel lblImage2;
	private JLabel lblImage3;
	private JButton btnOK;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PullImage window = new PullImage();
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
	public PullImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("옷장 가져오기");
		frame.setBounds(100, 100, 332, 380);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblImage0());
		frame.getContentPane().add(getLblImage1());
		frame.getContentPane().add(getLblImage2());
		frame.getContentPane().add(getLblImage3());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
	}

	private JLabel getLblImage0() {
		if (lblImage0 == null) {
			lblImage0 = new JLabel("");
			lblImage0.setIcon(new ImageIcon());
			lblImage0.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage0.setBounds(16, 24, 123, 112);
		}
		return lblImage0;
	}
	private JLabel getLblImage1() {
		if (lblImage1 == null) {
			lblImage1 = new JLabel("");
			lblImage1.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage1.setBounds(178, 24, 123, 112);
		}
		return lblImage1;
	}
	private JLabel getLblImage2() {
		if (lblImage2 == null) {
			lblImage2 = new JLabel("");
			lblImage2.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage2.setBounds(16, 165, 123, 112);
		}
		return lblImage2;
	}
	private JLabel getLblImage3() {
		if (lblImage3 == null) {
			lblImage3 = new JLabel("");
			lblImage3.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage3.setBounds(178, 165, 123, 112);
		}
		return lblImage3;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//WritePost로 전송
				}
			});
			btnOK.setBounds(88, 303, 78, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
			});
			btnCancel.setBounds(160, 303, 78, 29);
		}
		return btnCancel;
	}
}

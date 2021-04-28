package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import com.javalec.function.Bean;
import com.javalec.login.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu {

	private JFrame frame;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("메인");
		frame.setBounds(100, 100, 581, 623);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnLogout());
		frame.setLocationRelativeTo(null);
		
		JLabel userName = new JLabel("user");
		userName.setText(Bean.nowId);
		userName.setBounds(39, 53, 61, 16);
		frame.getContentPane().add(userName);
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logout();
				}
			});
			btnLogout.setBounds(97, 48, 88, 29);
		}
		return btnLogout;
	}
	
	private void Logout() {
		Bean.nowId="";
		frame.dispose();
		Login.main(null);
	}
}

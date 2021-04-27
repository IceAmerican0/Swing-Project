package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class AdminMain {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain window = new AdminMain();
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
	public AdminMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTabbedPane());
		
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.VERTICAL);
			tabbedPane.setBounds(6, 6, 90, 260);
			tabbedPane.add("User",new JPanel());
			tabbedPane.add("User",new JPanel());
			tabbedPane.add("User",new JPanel());
			tabbedPane.add("User",new JPanel());
			tabbedPane.add("User",new JPanel());
		}
		return tabbedPane;
	}
}

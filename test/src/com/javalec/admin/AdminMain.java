package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminMain {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane_1;

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
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(6, 6, 90, 103);
			tabbedPane.addTab("New tab", null, getLblNewLabel(), null);
			tabbedPane.addTab("New tab", null, getTabbedPane_1(), null);
		}
		return tabbedPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			JPanel panel = new JPanel();
			tabbedPane.add(panel, 0);
		}
		return lblNewLabel;
	}
	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane_1 == null) {
			tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		}
		return tabbedPane_1;
	}
}

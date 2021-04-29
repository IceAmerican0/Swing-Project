package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;

public class NoticeMain {
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JFrame frame;
	private JButton btnWrite_nt;
	private JScrollPane scrollPane;
	private JTable table_nt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeMain window = new NoticeMain();
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
	public NoticeMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(getBtnWrite_nt());
		frame.getContentPane().add(getScrollPane());
	}
	private JButton getBtnWrite_nt() {
		if (btnWrite_nt == null) {
			btnWrite_nt = new JButton("작성하기");
			btnWrite_nt.setBounds(337, 6, 96, 29);
		}
		return btnWrite_nt;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 60, 400, 182);
			scrollPane.setViewportView(getTable_nt());
		}
		return scrollPane;
	}
	private JTable getTable_nt() {
		if (table_nt == null) {
			table_nt = new JTable();
			table_nt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_nt.setModel(Outer_Table);
		}
		return table_nt;
	}
}

package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class NoticeMain {
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JFrame frame;
	private JButton btnNewNotice;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNewNotice());
		frame.getContentPane().add(getScrollPane());
	}
	private JButton getBtnNewNotice() {
		if (btnNewNotice == null) {
			btnNewNotice = new JButton("작성하기");
			btnNewNotice.setBounds(337, 6, 96, 29);
		}
		return btnNewNotice;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 60, 400, 182);
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
	//이너테이블과 아우터테이블 연결까ㅣㅈ 완료, 데이터 가져오는 쿼리문 작성 안함
}

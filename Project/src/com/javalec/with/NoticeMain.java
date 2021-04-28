package com.javalec.with;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.InsertNotice;
import com.javalec.function.Bean;
import com.javalec.function.DbAction;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NoticeMain {
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JFrame frame;
	private JButton btnNotice;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblrefresh;
	
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
				UserorAdmin();
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnNotice());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblrefresh());
	}
	private JButton getBtnNotice() {
		if (btnNotice == null) {
			btnNotice = new JButton("공지작성");
			btnNotice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					OpenAction();
				}
			});
			btnNotice.setBounds(336, 19, 96, 29);
		}
		return btnNotice;
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
	private JLabel getLblrefresh() {
		if (lblrefresh == null) {
			ImageIcon icon = new ImageIcon("/Volumes/Data/AI/yangseolin/Swing-Project/Project/icons-refresh.png");
			Image img = icon.getImage();
			Image changeImage = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon changeIcon = new ImageIcon(changeImage);
			lblrefresh = new JLabel(changeIcon);
			lblrefresh.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					refresh();
				}
			});
			lblrefresh.setBackground(Color.WHITE);
			lblrefresh.setBounds(297, 20, 30, 28);
			lblrefresh.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblrefresh;
	}
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
        Outer_Table.addColumn("Seq.");
        Outer_Table.addColumn("제목");
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
	private void SearchAction(){
		DbAction dbAction = new DbAction();
		ArrayList<Bean> beanList = dbAction.DocumentList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getSeqno());
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getName(),beanList.get(index).getTime()};
			Outer_Table.addRow(qTxt);
		}

	}
	private void UserorAdmin() {
		int i = 1; //user
		if (i == 1) {
			//어드민일경우
			btnNotice.setVisible(true);
		}
		if (i == 0) {
			//유저일경우
			btnNotice.setVisible(false);
			
		}
	}
	private void OpenAction() {
		InsertNotice insertNotice = new InsertNotice();
		insertNotice.main(null);

	}
	private void refresh() {
	TableInit();
	SearchAction();

	}
}

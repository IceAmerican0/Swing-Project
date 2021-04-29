package com.javalec.with;

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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.QueryAnswerInsert;
import com.javalec.admin.UpdateNotice;
import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.user.ReadNotice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class QueryAnswerMain {

	private JFrame frame;
	private JTextField titleF;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel lblPost;
	private JButton btnInsertDB;
	private JButton btnCancel;
	private JLabel lblUserName;
	private JTextField userF;
	private JTextField dateF;
	private JLabel lblDate;
	private JLabel Answer;
	private JLabel lblSeq;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable Inner_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryAnswerMain window = new QueryAnswerMain();
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
	public QueryAnswerMain() {
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
			}
		});
		frame.setBounds(100, 100, 454, 523);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTitleF());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblPost());
		frame.getContentPane().add(getBtnInsertDB());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getUserF());
		frame.getContentPane().add(getDateF());
		frame.getContentPane().add(getLblDate());
		frame.getContentPane().add(getAnswer());
		frame.getContentPane().add(getLblSeq());
		frame.getContentPane().add(getScrollPane());
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
			panel.setBounds(6, 82, 424, 187);
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
			btnInsertDB = new JButton("등록");
			btnInsertDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnInsertDB.setBounds(125, 442, 81, 29);
		}
		return btnInsertDB;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnCancel.setBounds(213, 442, 81, 29);
		}
		return btnCancel;
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
	private JLabel getAnswer() {
		if (Answer == null) {
			Answer = new JLabel("답변 :");
			Answer.setBounds(6, 281, 61, 16);
		}
		return Answer;
	}
	private JLabel getLblSeq() {
		if (lblSeq == null) {
			lblSeq = new JLabel("");
			lblSeq.setBounds(157, 40, 61, 16);
		}
		return lblSeq;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 309, 424, 128);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
			Inner_Table.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return Inner_Table;
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
	private void SearchAction() {
		WithAction withAction = new WithAction();
		ArrayList<Bean> beanList = withAction.QueryList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getQuery_queryid());
			String[] qTxt = {temp, beanList.get(index).getQuerytitle(),beanList.get(index).getUsername(),beanList.get(index).getAddtime()};
			Outer_Table.addRow(qTxt);
		}
	}
	private void TableClick() {
		  int i = Inner_Table.getSelectedRow();
	        String tkSeq = (String)Inner_Table.getValueAt(i, 0);
	        ShareVar.seqIndex = Integer.parseInt(tkSeq);
//	        System.out.println(ShareVar.seqIndex);
	        //답변표현 어케 할건지?
		
	}
}

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

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class AnswerQueryMain {

	private JFrame frame;
	private JTextField tfTitle;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea taQuery;
	private JLabel lblContent;
	private JButton btnUpdate;
	private JButton btnOK;
	private JLabel lblUserName;
	private JTextField tfUsername;
	private JTextField tfAddtime;
	private JLabel lblDate;
	private JLabel lblAnswerlist;
	private JLabel lblSeq;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblAnswer;
	private JPanel commentpanel;
	private JTextArea taAnswer;
	private JButton btnDelete;
	private JTextField tfTablePK;
	private JLabel lblseq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerQueryMain window = new AnswerQueryMain();
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
	public AnswerQueryMain() {
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
		frame.setBounds(100, 100, 454, 550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblContent());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getTfUsername());
		frame.getContentPane().add(getTfAddtime());
		frame.getContentPane().add(getLblDate());
		frame.getContentPane().add(getLblAnswerlist());
		frame.getContentPane().add(getLblSeq());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblAnswer());
		frame.getContentPane().add(getCommentpanel());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getTfTablePK());
		frame.getContentPane().add(getLblseq());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setColumns(10);
			tfTitle.setBounds(61, 10, 197, 26);
		}
		return tfTitle;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목 :");
			lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
			lblTitle.setBounds(6, 11, 47, 16);
		}
		return lblTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 82, 424, 187);
			panel.add(getTaQuery());
		}
		return panel;
	}
	public JTextArea getTaQuery() {
		if (taQuery == null) {
			taQuery = new JTextArea(30,20);
			taQuery.setEditable(false);
			taQuery.setLineWrap(true);
		}
		return taQuery;
	}
	private JLabel getLblContent() {
		if (lblContent == null) {
			lblContent = new JLabel("내용 :");
			lblContent.setHorizontalAlignment(SwingConstants.TRAILING);
			lblContent.setBounds(6, 64, 47, 16);
		}
		return lblContent;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.setVisible(false);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BtnAction();
				}
			});
			btnUpdate.setBounds(349, 276, 81, 29);
		}
		return btnUpdate;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setVisible(false);
			btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "EVENT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						DeleteAction();
					}
				}
			});
			btnDelete.setBounds(268, 276, 81, 29);
		}
		return btnDelete;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnOK.setBounds(174, 476, 81, 29);
		}
		return btnOK;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("작성자 :");
			lblUserName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUserName.setBounds(6, 41, 47, 16);
		}
		return lblUserName;
	}
	public JTextField getTfUsername() {
		if (tfUsername == null) {
			tfUsername = new JTextField();
			tfUsername.setEditable(false);
			tfUsername.setBounds(61, 40, 88, 26);
			tfUsername.setColumns(10);
		}
		return tfUsername;
	}
	public JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setBounds(254, 41, 176, 26);
			tfAddtime.setColumns(10);
		}
		return tfAddtime;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("date :");
			lblDate.setBounds(206, 46, 55, 16);
		}
		return lblDate;
	}
	private JLabel getLblAnswerlist() {
		if (lblAnswerlist == null) {
			lblAnswerlist = new JLabel("답변 :");
			lblAnswerlist.setBounds(6, 362, 61, 16);
		}
		return lblAnswerlist;
	}
	private JLabel getLblSeq() {
		if (lblSeq == null) {
			lblSeq = new JLabel("");
			lblSeq.setBounds(157, 40, 61, 16);
		}
		return lblSeq;
	}
	private JLabel getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new JLabel("답변 작성하기");
			lblAnswer.setBounds(6, 286, 82, 16);
		}
		return lblAnswer;
	}
	private JPanel getCommentpanel() {
		if (commentpanel == null) {
			commentpanel = new JPanel();
			commentpanel.setBounds(11, 301, 419, 58);
			commentpanel.add(getTaAnswer());
		}
		return commentpanel;
	}
	private JTextArea getTaAnswer() {
		if (taAnswer == null) {
			taAnswer = new JTextArea(10, 23);
			taAnswer.setEditable(false);
			taAnswer.setLineWrap(true);
		}
		return taAnswer;
	}
	private JTextField getTfTablePK() {
		if (tfTablePK == null) {
			tfTablePK = new JTextField();
			tfTablePK.setEditable(false);
			tfTablePK.setColumns(10);
			tfTablePK.setBounds(388, 10, 42, 26);
		}
		return tfTablePK;
	}
	private JLabel getLblseq() {
		if (lblseq == null) {
			lblseq = new JLabel("seq.");
			lblseq.setHorizontalAlignment(SwingConstants.TRAILING);
			lblseq.setBounds(327, 15, 61, 16);
		}
		return lblseq;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 379, 424, 85);
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
        Outer_Table.addColumn("내용");
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
		WithAction withAction = new WithAction(ShareVar.seqIndex);
        Bean bean = withAction.QueryTableClick();
        
        tfTablePK.setText(Integer.toString(bean.getTablePK()));
        tfTitle.setText(bean.getTitle());
        taQuery.setText(bean.getContent());
        tfAddtime.setText(bean.getAddtime());
        tfUsername.setText(bean.getUsername());
//        System.out.println(bean.getUserid()+ bean.getAdmin());
        AdminCheck(bean.getUserid(), bean.getAdmin());
	//---------------------------------------------
		ArrayList<Bean> beanList = withAction.AnswerList(ShareVar.seqIndex);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getUsername(),beanList.get(index).getAddtime()};
			Outer_Table.addRow(qTxt);
		}
	}
	private void TableClick() {
		  int i = Inner_Table.getSelectedRow();
	        String tkSeq = (String)Inner_Table.getValueAt(i, 0);
	        ShareVar.commentIndex = Integer.parseInt(tkSeq);
	        WithAction withAction = new WithAction();
	        Bean bean = withAction.AnswerClick(ShareVar.commentIndex);
	        if (ShareVar.admincheck == 1) {
	        	System.out.println(ShareVar.nowId + bean.getUser_userid());
	        	if(ShareVar.nowId.equals(bean.getUser_userid())) {	
	        		//관리자
	        		btnUpdate.setText("댓글수정");
	        		btnDelete.setText("댓글삭제");
	        		btnDelete.setVisible(true);
	        		taAnswer.setText(bean.getContent());
	        	}else {
	        		btnDelete.setVisible(false);
	        	}
	        }
	        taAnswer.setText(bean.getContent());
	}

	private void AdminCheck(String userid, int admin) {
//		System.out.println(userid+admin+ShareVar.nowId);
		if (ShareVar.admincheck == 0 || admin == 0) {
			if(ShareVar.nowId.equals(userid)) {
				//작성유저
				btnUpdate.setVisible(true);
				btnDelete.setVisible(false);
				taAnswer.setEditable(false);
				taQuery.setEditable(false);
				tfTitle.setEditable(false);
				tfTablePK.setEditable(false);
				tfAddtime.setEditable(false);
				tfUsername.setEditable(false);
				btnDelete.setText("문의삭제");
				btnUpdate.setText("문의수정");
			}
		}if(ShareVar.admincheck == 1 || admin == 1) {
			//관리자
			btnUpdate.setVisible(true);
			btnDelete.setVisible(false);
			taAnswer.setEditable(true);
			taQuery.setEditable(false);
			tfTitle.setEditable(false);
			tfTablePK.setEditable(false);
			tfAddtime.setEditable(false);
			tfUsername.setEditable(false);
			btnDelete.setText("댓글삭제");
			btnUpdate.setText("댓글작성");
			}
		
	
	}
	private void FieldCheck() {
		if (ShareVar.admincheck == 1) {
			//관리자
			if(taAnswer.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "입력하신 답변을 다시 확인해주세요!");
					//answer Insert or update
			}else {
				UpdateAction(taAnswer.getText());
			}
		}if (ShareVar.admincheck == 0) {
			//유저
			if(taQuery.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "입력하신 질문을 다시 확인해주세요!");
			}else {
				UpdateAction(tfTitle.getText() ,taQuery.getText());
			}
		}

	}
	private void UpdateAction(String Answer) {
		//답변수정
		boolean aaa=null != null;
		WithAction withAction = new WithAction();
		
		switch (btnUpdate.getText()) {
		case "댓글작성":
			aaa = withAction.InsertAnswer(Answer ,Integer.parseInt(tfTablePK.getText()));
			break;
		case "수정완료":
			aaa = withAction.UpdateAnswer(Answer, ShareVar.seqIndex);
			break;	
		default:
			break;
		}
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "입력 되었습니다!");
	          TableInit();
	          SearchAction();
	          taAnswer.setText("");

		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	private void UpdateAction(String Title, String query) {
		//질문수정
		WithAction withAction = new WithAction();
		int seqno = Integer.parseInt(tfTablePK.getText());
		boolean aaa = withAction.UpdateQuery(Title,query, seqno);
		if(aaa == true) {
	          JOptionPane.showMessageDialog(null, "문의 내용이 수정 되었습니다!");  
	          TableInit();
	          SearchAction();
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
		
	}
	private void BtnAction() {
		switch (btnUpdate.getText()) {
		case "댓글작성":
		case "등록":
			FieldCheck();
			break;
		case "댓글수정":
			btnUpdate.setText("수정완료");
			taAnswer.setEditable(true);
			break;
		case "수정완료":
			FieldCheck();
			break;
		case "문의수정":
			btnDelete.setVisible(true);
			taQuery.setEditable(true);
			tfTitle.setEditable(true);
			btnUpdate.setText("수정완료");
			btnDelete.setText("문의삭제");
			break;
		default:
			break;
		}
	}
	private void DeleteAction() {
		
		
		boolean aaa=null != null;
		WithAction withAction = new WithAction();
		switch (btnDelete.getText()) {
		case "댓글삭제" :
			aaa = withAction.DeleteAnswer(ShareVar.commentIndex);
			break;
		case "문의삭제" :
			aaa = withAction.DeleteQuery(Integer.parseInt(tfTablePK.getText()));
			break;	
		default:
			break;
		}
			if(aaa == true){
				JOptionPane.showMessageDialog(null, "삭제 되었습니다!");
//				SearchAction();
				if(btnDelete.getText()== "댓글삭제" ) {
					TableInit();
			          SearchAction();
			          taAnswer.setText("");
			          AdminCheck(null, 0);
				}else {
					frame.dispose();
				}
			}else{
				JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
			}
		}

	

}

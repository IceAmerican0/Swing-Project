package com.javalec.admin;

import java.awt.BorderLayout;
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
import javax.swing.Icon;

public class SelectDocumentDB {

	private JFrame frame;
	private JTextField tfTitle;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea taContent;
	private JLabel lblContent;
	private JButton btnOK;
	private JLabel lblUserName;
	private JTextField tfUserID;
	private JTextField tfAddtime;
	private JLabel lbladdtime;
	private JLabel lblAnswerlist;
	private JLabel lblSeq;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JTextField tfTablePK;
	private JLabel lblseq;
	int answerIndex;
	private JLabel ClothesData;
	private JLabel lblBlind;
	private JTextField tfBlindtime;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDocumentDB window = new SelectDocumentDB();
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
	public SelectDocumentDB() {
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
		frame.setBounds(100, 100, 460, 700);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblContent());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getTfUserID());
		frame.getContentPane().add(getTfAddtime());
		frame.getContentPane().add(getLbladdtime());
		frame.getContentPane().add(getLblAnswerlist());
		frame.getContentPane().add(getLblSeq());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfTablePK());
		frame.getContentPane().add(getLblseq());
		frame.getContentPane().add(getClothesData());
		frame.getContentPane().add(getLblBlind());
		frame.getContentPane().add(getTfBlindtime());
		frame.getContentPane().add(getBtnDelete());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setColumns(10);
			tfTitle.setBounds(40, 10, 197, 26);
		}
		return tfTitle;
	}
	private JLabel getClothesData() {
		if (ClothesData == null) {
			ClothesData = new JLabel((Icon) null);
			ClothesData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothesData.setBounds(16, 74, 430, 211);
		}
		return ClothesData;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목 :");
			lblTitle.setBounds(6, 15, 47, 16);
		}
		return lblTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBounds(6, 325, 445, 182);
			panel.add(getTaContent());
		}
		return panel;
	}
	public JTextArea getTaContent() {
		if (taContent == null) {
			taContent = new JTextArea(30,20);
			taContent.setEditable(false);
			taContent.setLineWrap(true);
		}
		return taContent;
	}
	private JLabel getLblContent() {
		if (lblContent == null) {
			lblContent = new JLabel("내용 :");
			lblContent.setBounds(6, 297, 47, 16);
		}
		return lblContent;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnOK.setBounds(174, 637, 81, 29);
		}
		return btnOK;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("ID :");
			lblUserName.setBounds(245, 15, 29, 16);
		}
		return lblUserName;
	}
	public JTextField getTfUserID() {
		if (tfUserID == null) {
			tfUserID = new JTextField();
			tfUserID.setEditable(false);
			tfUserID.setBounds(275, 10, 96, 26);
			tfUserID.setColumns(10);
		}
		return tfUserID;
	}
	public JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setBounds(40, 36, 178, 26);
			tfAddtime.setColumns(10);
		}
		return tfAddtime;
	}
	private JLabel getLbladdtime() {
		if (lbladdtime == null) {
			lbladdtime = new JLabel("add :");
			lbladdtime.setBounds(6, 41, 61, 16);
		}
		return lbladdtime;
	}
	private JLabel getLblAnswerlist() {
		if (lblAnswerlist == null) {
			lblAnswerlist = new JLabel("댓글list :");
			lblAnswerlist.setBounds(6, 519, 61, 16);
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
	private JTextField getTfTablePK() {
		if (tfTablePK == null) {
			tfTablePK = new JTextField();
			tfTablePK.setEditable(false);
			tfTablePK.setColumns(10);
			tfTablePK.setBounds(405, 10, 42, 26);
		}
		return tfTablePK;
	}
	private JLabel getLblseq() {
		if (lblseq == null) {
			lblseq = new JLabel("seq.");
			lblseq.setHorizontalAlignment(SwingConstants.TRAILING);
			lblseq.setBounds(373, 15, 29, 16);
		}
		return lblseq;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 543, 445, 90);
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
		AdminAction adminAction = new AdminAction();
        Bean bean = adminAction.DocumentDBTableClick();
        
        tfTablePK.setText(Integer.toString(bean.getTablePK()));
        tfTitle.setText(bean.getTitle());
        taContent.setText(bean.getContent());
        tfAddtime.setText(bean.getAddtime());
        tfBlindtime.setText(bean.getBlindtime());
        tfUserID.setText(bean.getUserid());
        
        if(bean.getBlindtime() != null) {
        	btnDelete.setText("차단해제");
        }
//----------------------------------------댓글 불러오기--------------------------------------
		ArrayList<Bean> beanList = adminAction.DBCommentList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp, beanList.get(index).getContent(),beanList.get(index).getUserid(),beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table.addRow(qTxt);
		}
	}
	private void TableClick() {
//		  int i = Inner_Table.getSelectedRow();
//	        String tkSeq = (String)Inner_Table.getValueAt(i, 0);
//	        ShareVar.commentIndex = Integer.parseInt(tkSeq);
//	        WithAction withAction = new WithAction();
//	        Bean bean = withAction.AnswerClick(ShareVar.commentIndex);
//	        if (ShareVar.admincheck == 1 && ShareVar.nowId.equals(bean.getUser_userid())) {
//	        	System.out.println(ShareVar.nowId + bean.getUser_userid());
//	        		//관리자
//	        		btnUpdate.setText("댓글수정");
//	        		btnDelete.setText("댓글삭제");
//	        		btnDelete.setVisible(true);
//	        		taAnswer.setText(bean.getContent());
//	        	}else {
//	        		btnUpdate.setText("댓글작성");
//	        		btnDelete.setVisible(false);
//	        	}
//	        taAnswer.setText(bean.getContent());
	        
	}

	private void AdminCheck(String userid, int admin) {
//		System.out.println(userid+admin+ShareVar.nowId);
//		if (ShareVar.admincheck == 0 || admin == 0) {
//			btnUpdate.setVisible(true);
//			btnDelete.setVisible(false);
//			taAnswer.setEditable(false);
//			taContent.setEditable(false);
//			tfTitle.setEditable(false);
//			tfTablePK.setEditable(false);
//			tfAddtime.setEditable(false);
//			tfUserID.setEditable(false);
//			lblAnswer.setText("답변보기");
//			btnDelete.setText("문의삭제");
//			btnUpdate.setText("문의수정");
//			
//		}if(ShareVar.admincheck == 1 || admin == 1) {
//			//관리자
//			btnUpdate.setVisible(true);
//			btnDelete.setVisible(false);
//			taAnswer.setEditable(true);
//			taContent.setEditable(false);
//			tfTitle.setEditable(false);
//			tfTablePK.setEditable(false);
//			tfAddtime.setEditable(false);
//			tfUserID.setEditable(false);
//			btnDelete.setText("댓글삭제");
//			btnUpdate.setText("댓글작성");
//			}
		
	
	}
	private void FieldCheck() {
//		if (ShareVar.admincheck == 1) {
//			//관리자
//			if(taAnswer.getText().trim().length() == 0) {
//				JOptionPane.showMessageDialog(null, "입력하신 답변을 다시 확인해주세요!");
//					//answer Insert or update
//			}else {
//				UpdateAction(taAnswer.getText());
//			}
//		}if (ShareVar.admincheck == 0) {
//			//유저
//			if(taContent.getText().trim().length() == 0) {
//				JOptionPane.showMessageDialog(null, "입력하신 질문을 다시 확인해주세요!");
//			}else {
//				UpdateAction(tfTitle.getText() ,taContent.getText());
//			}
//		}

	}
	private void UpdateAction(String Answer) {
		//답변수정
//		boolean aaa=null != null;
//		WithAction withAction = new WithAction();
//		
//		switch (btnUpdate.getText()) {
//		case "댓글작성":
//			aaa = withAction.InsertAnswer(Answer ,Integer.parseInt(tfTablePK.getText()));
//			break;
//		case "수정완료":
//			aaa = withAction.UpdateAnswer(Answer, answerIndex);
//			break;	
//		default:
//			break;
//		}
//		if(aaa == true){
//	          JOptionPane.showMessageDialog(null, "입력 되었습니다!");
//	          TableInit();
//	          SearchAction();
//	          taAnswer.setText("");
//
//		}else{
//	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
//		}
	}
	private void UpdateAction(String Title, String query) {
		//질문수정
//		WithAction withAction = new WithAction();
//		int seqno = Integer.parseInt(tfTablePK.getText());
//		boolean aaa = withAction.UpdateQuery(Title,query, seqno);
//		if(aaa == true){
//	          JOptionPane.showMessageDialog(null, "문의 내용이 수정 되었습니다!");  
//	          TableInit();
//	          SearchAction();
//		}else{
//	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
//		}
		
	}
//	private void DeleteAction() {
//		boolean aaa=null != null;
//		WithAction withAction = new WithAction();
//		switch (btnDelete.getText()) {
//		case "댓글삭제" :
//			aaa = withAction.DeleteAnswer(ShareVar.commentIndex);
//			break;
//		case "문의삭제" :
//			aaa = withAction.DeleteQuery(Integer.parseInt(tfTablePK.getText()));
//			break;	
//		default:
//			break;
//		}
//		if(aaa == true){
//			JOptionPane.showMessageDialog(null, "삭제 되었습니다!");
////			SearchAction();
//			if(btnDelete.getText()== "댓글삭제" ) {
//				TableInit();
//		          SearchAction();
//		          taAnswer.setText("");
//		          AdminCheck(null, 0);
//			}else {
//				frame.dispose();
//			}
//		}else{
//			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
//		}
//		}
	private JLabel getLblBlind() {
		if (lblBlind == null) {
			lblBlind = new JLabel("blind :");
			lblBlind.setBounds(224, 41, 47, 16);
		}
		return lblBlind;
	}
	private JTextField getTfBlindtime() {
		if (tfBlindtime == null) {
			tfBlindtime = new JTextField();
			tfBlindtime.setEditable(false);
			tfBlindtime.setColumns(10);
			tfBlindtime.setBounds(275, 36, 176, 26);
		}
		return tfBlindtime;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("차단하기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteAction();
				}
			});
			btnDelete.setBounds(334, 284, 117, 29);
		}
		return btnDelete;
	}
	private void DeleteAction() {
		AdminAction adminAction = new AdminAction();
		if (btnDelete.getText() == "차단해제") {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateDocumentBlindtime(1);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "차단이 해제되었습니다!");    
			          TableInit();
			          SearchAction();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
			
			}
		}if (btnDelete.getText() == "차단하기") {
			int result = JOptionPane.showConfirmDialog(null, "해당 게시글을 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateDocumentBlindtime(0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "게시글이 차단되었습니다!");
			          TableInit();
			          SearchAction();
			          
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}
	}
}

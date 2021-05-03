package com.javalec.user;

import java.awt.BorderLayout;	
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import com.javalec.with.WithAction;

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
import javax.swing.ImageIcon;

public class SelectDocument {

	private JFrame frame;
	private JTextField tfTitle;
	private JLabel lblTitle;
	private JPanel panel;
	private JTextArea taDocument;
	private JLabel lblContent;
	private JButton btnOK;
	private JLabel lblUserName;
	private JTextField tfUserID;
	private JTextField tfAddtime;
	private JLabel lbladdtime;
	private JLabel lblSeq;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JTextField tfTablePK;
	private JLabel lblseq;
	int answerIndex;
	private JLabel ClothData;
//	private JButton btnUpdate;
	private JLabel lblAnswer;
	private JPanel commentpanel;
	private JTextArea taComment;
	private JButton btnCommentInsert;
	private JButton btnCommentDelete;
	private JButton btnDocumentUpdate;
	private JButton btnDocumentDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDocument window = new SelectDocument();
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
	public SelectDocument() {
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
				UserCheck();
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
		frame.getContentPane().add(getLblSeq());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfTablePK());
		frame.getContentPane().add(getLblseq());
		frame.getContentPane().add(getClothData());
		frame.getContentPane().add(getLblAnswer());
		frame.getContentPane().add(getCommentpanel());
		frame.getContentPane().add(getBtnCommentInsert());
		frame.getContentPane().add(getBtnCommentDelete());
		frame.getContentPane().add(getBtnDocumentUpdate());
		frame.getContentPane().add(getBtnDocumentDelete());
//		frame.getContentPane().add(getBtnUpdate());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setColumns(10);
			tfTitle.setBounds(58, 10, 197, 26);
		}
		return tfTitle;
	}
	private JLabel getClothData() {
		if (ClothData == null) {
			ClothData = new JLabel((Icon) null);
			ClothData.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					ClothList.main(null);
				}
			});
			ClothData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothData.setBounds(16, 74, 430, 211);
		}
		return ClothData;
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
			panel.setBounds(6, 325, 445, 90);
			panel.add(getTaDocument());
		}
		return panel;
	}
	public JTextArea getTaDocument() {
		if (taDocument == null) {
			taDocument = new JTextArea(30,20);
			taDocument.setEditable(false);
			taDocument.setLineWrap(true);
		}
		return taDocument;
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
			lblUserName = new JLabel("작성자 :");
			lblUserName.setBounds(6, 41, 47, 16);
		}
		return lblUserName;
	}
	public JTextField getTfUserID() {
		if (tfUserID == null) {
			tfUserID = new JTextField();
			tfUserID.setEditable(false);
			tfUserID.setBounds(58, 36, 117, 26);
			tfUserID.setColumns(10);
		}
		return tfUserID;
	}
	public JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setBounds(269, 36, 178, 26);
			tfAddtime.setColumns(10);
		}
		return tfAddtime;
	}
	private JLabel getLbladdtime() {
		if (lbladdtime == null) {
			lbladdtime = new JLabel("작성 날짜 :");
			lbladdtime.setBounds(198, 41, 61, 16);
		}
		return lbladdtime;
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
	private JLabel getLblAnswer() {
		if (lblAnswer == null) {
			lblAnswer = new JLabel("댓글 :");
			lblAnswer.setBounds(6, 427, 82, 16);
		}
		return lblAnswer;
	}
	private JPanel getCommentpanel() {
		if (commentpanel == null) {
			commentpanel = new JPanel();
			commentpanel.setBounds(6, 450, 445, 60);
			commentpanel.setLayout(new BorderLayout());
			commentpanel.add(getTaComment(), BorderLayout.CENTER);
		}
		return commentpanel;
	}
	private JTextArea getTaComment() {
		if (taComment == null) {
			taComment = new JTextArea();
		}
		return taComment;
	}
	private JButton getBtnCommentInsert() {
		if (btnCommentInsert == null) {
			btnCommentInsert = new JButton("댓글등록");
			btnCommentInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (btnCommentInsert.getText()) {
					case "댓글등록":
						CommentFieldCheck();
						break;
					case "댓글수정":
						btnCommentInsert.setText("수정완료");
						taComment.setEditable(true);
						break;
					case "수정완료":
						CommentFieldCheck();
						break;
					default:
						break;
					}
				}
			});
			btnCommentInsert.setBounds(370, 422, 81, 29);
		}
		return btnCommentInsert;
	}
	private JButton getBtnCommentDelete() {
		if (btnCommentDelete == null) {
			btnCommentDelete = new JButton("삭제하기");
			btnCommentDelete.setVisible(false);
			btnCommentDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "EVENT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						DeleteCommentAction();
					}
				}
			});
			btnCommentDelete.setBounds(291, 422, 81, 29);
		}
		return btnCommentDelete;
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
		UserAction userAction = new UserAction();
        Bean bean = userAction.DocumentForAllTableClick();
        
        tfTablePK.setText(Integer.toString(bean.getTablePK()));
        tfTitle.setText(bean.getTitle());
        taDocument.setText(bean.getContent());
        tfUserID.setText(bean.getUsername());
        tfAddtime.setText(bean.getAddtime());
        ShareVar.IDIndex= bean.getUserid();

//---------------------------------------파일 데이터 불러오기--------------------------------------
        String filePath = Integer.toString(ShareVar.filename);
		ClothData.setIcon(new ImageIcon(filePath));
		ClothData.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filePath);
		file.delete();
//----------------------------------------댓글 불러오기--------------------------------------
		ArrayList<Bean> beanList = userAction.DocumentForAllCommentList();
		
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
	        UserAction userAction = new UserAction();
	        Bean bean = userAction.CommentClick(ShareVar.commentIndex);
	        
	        	taComment.setText(bean.getContent());
	        
	        if (ShareVar.nowId.equals(bean.getUser_userid()) == false) {
				//작성자 본인이 아닐때
	        	btnCommentDelete.setVisible(false);
	        	btnCommentInsert.setText("댓글등록");
				
			}if (ShareVar.nowId.equals(bean.getUser_userid())) {
				//작성자 본인일때
        		btnCommentDelete.setText("댓글삭제");
        		btnCommentDelete.setVisible(true);
			}
	        
	}

	private void CommentFieldCheck() {
			if(taComment.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "입력하신 댓글을 다시 확인해주세요!");
					//answer Insert or update
			}else {
				UpdateCommentAction(taComment.getText());
//				System.out.println("test1");
			}
//			
	}
	private void UpdateCommentAction(String Answer) {
		//답변수정
		boolean aaa=null != null;
		UserAction userAction = new UserAction();
		
		switch (btnCommentInsert.getText()) {
		case "댓글등록":
			aaa = userAction.InsertComment(Answer ,Integer.parseInt(tfTablePK.getText()));
			break;
		case "수정완료":
			aaa = userAction.UpdateComment(Answer);
			break;	
		default:
			break;
		}
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "입력 되었습니다!");
	          TableInit();
	          SearchAction();
	          taComment.setText("");

		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	private void DeleteCommentAction() {
		boolean aaa=null != null;
		UserAction userAction = new UserAction();
		aaa = userAction.DeleteComment(ShareVar.commentIndex);
	
		if(aaa == true){
			JOptionPane.showMessageDialog(null, "삭제 되었습니다!");
				TableInit();
		        SearchAction();
		        taComment.setText("");
		}else{
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}

	private JButton getBtnDocumentUpdate() {
		if (btnDocumentUpdate == null) {
			btnDocumentUpdate = new JButton("수정하기");
			btnDocumentUpdate.setVisible(false);
			btnDocumentUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (btnDocumentUpdate.getText()) {
					case "수정하기":
						taDocument.setEditable(true);
						tfTitle.setEditable(true);
						btnDocumentUpdate.setText("수정완료");
						break;
					case "수정완료":
						DocumentFieldCheck();
						break;
					default:
						break;
					}
				}
			});
			btnDocumentUpdate.setBounds(370, 292, 81, 29);
		}
		return btnDocumentUpdate;
	}
	private JButton getBtnDocumentDelete() {
		if (btnDocumentDelete == null) {
			btnDocumentDelete = new JButton("글 삭제");
			btnDocumentDelete.setVisible(false);
			btnDocumentDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "EVENT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						DeleteDocumentAction();
					}
				}
			});
			btnDocumentDelete.setBounds(291, 292, 81, 29);
		}
		return btnDocumentDelete;
	}
	private void UserCheck() {
		UserAction userAction = new UserAction();
		String user_userid = userAction.WriterCheck();
		if(ShareVar.nowId.equals(user_userid)) {
			btnDocumentUpdate.setVisible(true);
			btnDocumentDelete.setVisible(true);
		}else {
			
		}

	}
	private void DocumentFieldCheck() {
		if(taDocument.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "수정하신 내용을 다시 확인해주세요!");
		}else {
			UpdateDocumentAction(tfTitle.getText() ,taDocument.getText());
		}

	}
	private void UpdateDocumentAction(String title, String document) {
		//글 수정
		UserAction userAction = new UserAction();
		boolean aaa = userAction.UpdateDocument(title , document);

		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "글이 수정 되었습니다!");
	          TableInit();
	          SearchAction();
	          tfTitle.setEditable(false);
	          taDocument.setEditable(false);
	          btnDocumentUpdate.setText("수정하기");

		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	private void DeleteDocumentAction() {
		
		UserAction userAction = new UserAction();
		boolean aaa = userAction.DeleteDocument();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "글이 삭제 되었습니다!");
	          frame.dispose();
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
		
	}
	
}

package com.javalec.admin;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SelectClothDB {

	private JFrame frame;
	private JTextField tfTitle;
	private JLabel lblTitle;
	private JButton btnOK;
	private JLabel lblUserName;
	private JTextField tfUserID;
	private JTextField tfAddtime;
	private JLabel lbladdtime;
	private JLabel lblDocumentlist;
	private JLabel lblSeq;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JTextField tfTablePK;
	private JLabel lblseq;
	int answerIndex;
	private JLabel ClothData;
	private JLabel lblBlind;
	private JTextField tfBlindtime;
	private JButton btnDelete;
	private JLabel lbltype;
	private JComboBox comboBox;
	private String combopre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectClothDB window = new SelectClothDB();
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
	public SelectClothDB() {
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
		frame.setBounds(100, 100, 460, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getLblUserName());
		frame.getContentPane().add(getTfUserID());
		frame.getContentPane().add(getTfAddtime());
		frame.getContentPane().add(getLbladdtime());
		frame.getContentPane().add(getLblDocumentlist());
		frame.getContentPane().add(getLblSeq());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfTablePK());
		frame.getContentPane().add(getLblseq());
		frame.getContentPane().add(getClothData());
		frame.getContentPane().add(getLblBlind());
		frame.getContentPane().add(getTfBlindtime());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getLbltype());
		frame.getContentPane().add(getComboBox());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setColumns(10);
			tfTitle.setBounds(40, 10, 215, 26);
		}
		return tfTitle;
	}
	private JLabel getClothData() {
		if (ClothData == null) {
			ClothData = new JLabel((Icon) null);
			ClothData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothData.setBounds(6, 103, 445, 254);
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
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnOK.setBounds(174, 495, 81, 29);
		}
		return btnOK;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("ID :");
			lblUserName.setBounds(6, 41, 29, 16);
		}
		return lblUserName;
	}
	public JTextField getTfUserID() {
		if (tfUserID == null) {
			tfUserID = new JTextField();
			tfUserID.setEditable(false);
			tfUserID.setBounds(40, 36, 96, 26);
			tfUserID.setColumns(10);
		}
		return tfUserID;
	}
	public JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setBounds(40, 65, 178, 26);
			tfAddtime.setColumns(10);
		}
		return tfAddtime;
	}
	private JLabel getLbladdtime() {
		if (lbladdtime == null) {
			lbladdtime = new JLabel("add :");
			lbladdtime.setBounds(6, 70, 61, 16);
		}
		return lbladdtime;
	}
	private JLabel getLblDocumentlist() {
		if (lblDocumentlist == null) {
			lblDocumentlist = new JLabel("Document list :");
			lblDocumentlist.setBounds(6, 369, 117, 16);
		}
		return lblDocumentlist;
	}
	private JLabel getLblSeq() {
		if (lblSeq == null) {
			lblSeq = new JLabel("");
			lblSeq.setBounds(161, 40, 61, 16);
		}
		return lblSeq;
	}
	private JTextField getTfTablePK() {
		if (tfTablePK == null) {
			tfTablePK = new JTextField();
			tfTablePK.setEditable(false);
			tfTablePK.setColumns(10);
			tfTablePK.setBounds(166, 36, 42, 26);
		}
		return tfTablePK;
	}
	private JLabel getLblseq() {
		if (lblseq == null) {
			lblseq = new JLabel("seq.");
			lblseq.setHorizontalAlignment(SwingConstants.TRAILING);
			lblseq.setBounds(138, 41, 29, 16);
		}
		return lblseq;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 393, 445, 90);
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
        Outer_Table.addColumn("차단시간");
        Outer_Table.setColumnCount(5);

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
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 80;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);

	}
	private void SearchAction() {
		AdminAction adminAction = new AdminAction();
        Bean bean = adminAction.ClothDBTableClick();
        
        tfTablePK.setText(Integer.toString(bean.getTablePK()));
        tfTitle.setText(bean.getContent());
        tfAddtime.setText(bean.getAddtime());
        tfBlindtime.setText(bean.getBlindtime());
        tfUserID.setText(bean.getUserid());
//---------------------------------------combo값 지정하기--------------------------------------
        comboBox.setSelectedItem(bean.getTitle());
        combopre = bean.getTitle();
   
//----------------------------------------파일 불러오기--------------------------------------
        String filePath = Integer.toString(ShareVar.filename);
		ClothData.setIcon(new ImageIcon(filePath));
		ClothData.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filePath);
		file.delete();

//----------------------------------------파일 불러오기--------------------------------------
        
        
        if(bean.getBlindtime() != null) {
        	btnDelete.setText("차단해제");
        }
//----------------------------------------댓글 불러오기--------------------------------------
		ArrayList<Bean> beanList = adminAction.DBDocumentList();
		
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


	private JLabel getLblBlind() {
		if (lblBlind == null) {
			lblBlind = new JLabel("blind :");
			lblBlind.setBounds(224, 70, 47, 16);
		}
		return lblBlind;
	}
	private JTextField getTfBlindtime() {
		if (tfBlindtime == null) {
			tfBlindtime = new JTextField();
			tfBlindtime.setEditable(false);
			tfBlindtime.setColumns(10);
			tfBlindtime.setBounds(275, 65, 176, 26);
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
			btnDelete.setBounds(337, 364, 117, 29);
		}
		return btnDelete;
	}
	private void DeleteAction() {
		AdminAction adminAction = new AdminAction();
		if (btnDelete.getText() == "차단해제") {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(1);
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
			int result = JOptionPane.showConfirmDialog(null, "해당 옷 데이터를 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "데이터가 차단되었습니다!");
			          TableInit();
			          SearchAction();
			          
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}
	}
	private JLabel getLbltype() {
		if (lbltype == null) {
			lbltype = new JLabel("type :");
			lbltype.setHorizontalAlignment(SwingConstants.TRAILING);
			lbltype.setBounds(249, 15, 61, 16);
		}
		return lbltype;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						UpdateAction();
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"ALL", "상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
			comboBox.setBounds(322, 9, 124, 27);
		}
		return comboBox;
	}
	private void UpdateAction() {
		if (combopre != comboBox.getSelectedItem()) {
			int result = JOptionPane.showConfirmDialog(null, "데이터의 목록을 변경하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			AdminAction adminAction = new AdminAction();
			boolean aaa = adminAction.UpdateClothType(comboBox.getSelectedItem());
			if(aaa == true){
			          JOptionPane.showMessageDialog(null, "목록이 변경되었습니다!");    
			          TableInit();
			          SearchAction();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}
		}
	}
}

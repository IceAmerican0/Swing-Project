package com.khankong.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.khankong.function.Bean;
import com.khankong.function.DbAction;
import com.khankong.function.ShareVar;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	// --- Table
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
    // -----
    private JLabel lblSequenceNo;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JTextField tfSeqno;
    private JTextField tfName;
    private JTextField tfTelno;
    private JTextField tfAddress;
    private JTextField tfEmail;
    private JTextField tfRelation;
    private JButton btnOK;
    private JRadioButton rbInsert;
    private JRadioButton rbUpdate;
    private JRadioButton rbDelete;
    private JRadioButton rbQuery;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JLabel label_5;
    private JTextField tfFilePath;
    private JButton btnFilePath;
    private JLabel lblImage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
				ScreenPartition();
				
			}
		});
		setTitle(">>>> 주소록 <<<<");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getCbSelection());
		contentPane.add(getTfSelection());
		contentPane.add(getBtnQuery());
		contentPane.add(getScrollPane());
		
		lblSequenceNo = new JLabel("Sequence No :");
		lblSequenceNo.setBounds(29, 229, 101, 16);
		contentPane.add(lblSequenceNo);
		
		label = new JLabel("이름 :");
		label.setBounds(29, 267, 61, 16);
		contentPane.add(label);
		
		label_1 = new JLabel("전화번호 :");
		label_1.setBounds(29, 306, 61, 16);
		contentPane.add(label_1);
		
		label_2 = new JLabel("주소 :");
		label_2.setBounds(29, 343, 61, 16);
		contentPane.add(label_2);
		
		label_3 = new JLabel("전자우편");
		label_3.setBounds(29, 381, 61, 16);
		contentPane.add(label_3);
		
		label_4 = new JLabel("관계 :");
		label_4.setBounds(29, 418, 61, 16);
		contentPane.add(label_4);
		
		tfSeqno = new JTextField();
		tfSeqno.setEditable(false);
		tfSeqno.setBounds(129, 224, 67, 26);
		contentPane.add(tfSeqno);
		tfSeqno.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(129, 262, 95, 26);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfTelno = new JTextField();
		tfTelno.setBounds(129, 301, 130, 26);
		contentPane.add(tfTelno);
		tfTelno.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(129, 338, 301, 26);
		contentPane.add(tfAddress);
		tfAddress.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(129, 376, 207, 26);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfRelation = new JTextField();
		tfRelation.setBounds(129, 413, 301, 26);
		contentPane.add(tfRelation);
		tfRelation.setColumns(10);
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPartition();
			}
		});
		btnOK.setBounds(315, 549, 117, 29);
		contentPane.add(btnOK);
		
		rbInsert = new JRadioButton("입력");
		rbInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenPartition();
			}
		});
		buttonGroup.add(rbInsert);
		rbInsert.setBounds(22, 19, 61, 23);
		contentPane.add(rbInsert);
		
		rbUpdate = new JRadioButton("수정");
		rbUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenPartition();
			}
		});
		buttonGroup.add(rbUpdate);
		rbUpdate.setBounds(83, 19, 61, 23);
		contentPane.add(rbUpdate);
		
		rbDelete = new JRadioButton("삭제");
		rbDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenPartition();
			}
		});
		buttonGroup.add(rbDelete);
		rbDelete.setBounds(147, 19, 61, 23);
		contentPane.add(rbDelete);
		
		rbQuery = new JRadioButton("검색");
		rbQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScreenPartition();
			}
		});
		buttonGroup.add(rbQuery);
		rbQuery.setSelected(true);
		rbQuery.setBounds(206, 18, 67, 23);
		contentPane.add(rbQuery);
		contentPane.add(getLabel_5());
		contentPane.add(getTfFilePath());
		contentPane.add(getBtnFilePath());
		contentPane.add(getLblImage());
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(29, 54, 88, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(129, 53, 188, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.setToolTipText("조건 검색 입니다");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnQuery.setBounds(329, 53, 101, 29);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 93, 401, 124);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
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
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table); // <--***************************************************
		}
		return Inner_Table;
	}
	
// -------------------
	// Table 초기화
	@SuppressWarnings("static-access")
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
        Outer_Table.addColumn("Seq.");
        Outer_Table.addColumn("이름");
        Outer_Table.addColumn("전화번호");
        Outer_Table.addColumn("관계");
        Outer_Table.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 40;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 200;
        col.setPreferredWidth(width);

	}
	
	//전체 검색결과를 Table로 
	private void SearchAction(){
		DbAction dbAction = new DbAction();
		ArrayList<Bean> beanList = dbAction.SelectList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getSeqno());
			String[] qTxt = {temp, beanList.get(index).getName(), beanList.get(index).getTelno(), beanList.get(index).getRelation()};
			Outer_Table.addRow(qTxt);
		}

	}
	
	// Table에서 Row를 Click후 검색 
	private void TableClick() {
        int i = Inner_Table.getSelectedRow();
        String tkSequence = (String)Inner_Table.getValueAt(i, 0);
        int wkSequence = Integer.parseInt(tkSequence);
        
        DbAction dbAction = new DbAction(wkSequence);
        Bean bean = dbAction.TableClick();
        
        tfSeqno.setText(Integer.toString(bean.getSeqno()));
        tfName.setText(bean.getName());
        tfTelno.setText(bean.getTelno());
        tfAddress.setText(bean.getAddress());
        tfEmail.setText(bean.getEmail());
        tfRelation.setText(bean.getRelation());
        
        // Image처리
        // File name이 틀려야 즉각 보여주기가 가능하여   
        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
        
		String filePath = Integer.toString(ShareVar.filename);
		tfFilePath.setText(filePath);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		file.delete();
		
		tfFilePath.setText("");

        
	}
	
	// 조건 검색 항목 결정 
	private void ConditionQuery() {
		int i = cbSelection.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "name";
			break;
		case 1:
			ConditionQueryColumn = "address";
			break;
		case 2:
			ConditionQueryColumn = "relation";
			break;
		default:
			break;
		}
		
		TableInit();
		ClearColumn();
		ConditionQueryAction(ConditionQueryColumn);

	}
	
	// DataField 정리
	private void ClearColumn() {
		tfSeqno.setText("");
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfFilePath.setText("");
		
	}
	
	// 조건검색 실행 
	private void ConditionQueryAction(String ConditionQueryColumn) {
		DbAction dbAction = new DbAction(ConditionQueryColumn, tfSelection.getText());
		ArrayList<Bean> beanList = dbAction.ConditionList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getSeqno());
			String[] qTxt = {temp, beanList.get(index).getName(), beanList.get(index).getTelno(), beanList.get(index).getRelation()};
			Outer_Table.addRow(qTxt);
		}
	}
	
	// Data 수정
	private void UpdateAction() {
		int seqno = Integer.parseInt(tfSeqno.getText());
		String name = tfName.getText();
		String telno = tfTelno.getText();
		String address = tfAddress.getText();
		String email = tfEmail.getText();
		String relation = tfRelation.getText();
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DbAction dbaction = new DbAction(seqno, name, telno, address, email, relation, input);
		boolean aaa = dbaction.UpdateAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, tfName.getText()+" 님의 정보가 수정 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}

	}
	
	// Data 삭제
	private void DeleteAction() {
		int seqno = Integer.parseInt(tfSeqno.getText());
		
		DbAction dbaction = new DbAction(seqno);
		boolean aaa = dbaction.DeleteAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, tfName.getText()+" 님의 정보가 삭제 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	
	}
	
	// 화면 정리 
	private void ScreenPartition() {
		// 검색일 경우 
		if(rbQuery.isSelected() == true) {
			btnOK.setVisible(false);
			btnFilePath.setVisible(false);
			tfName.setEditable(false);
			tfTelno.setEditable(false);
			tfAddress.setEditable(false);
			tfEmail.setEditable(false);
			tfRelation.setEditable(false);
		}
		
		// 입력일 경우
		if(rbInsert.isSelected() == true) {
			btnOK.setVisible(true);
			btnFilePath.setVisible(true);
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);			
		}
		
		// 수정일 경우
		if(rbUpdate.isSelected() == true) {
			btnOK.setVisible(true);
			btnFilePath.setVisible(true);
			tfName.setEditable(true);
			tfTelno.setEditable(true);
			tfAddress.setEditable(true);
			tfEmail.setEditable(true);
			tfRelation.setEditable(true);						
		}
		
		// 삭제일 경우 
		if(rbDelete.isSelected() == true) {
			btnOK.setVisible(true);
			btnFilePath.setVisible(true);
			tfName.setEditable(false);
			tfTelno.setEditable(false);
			tfAddress.setEditable(false);
			tfEmail.setEditable(false);
			tfRelation.setEditable(false);
		}
		ClearColumn();
	}
	
	// Action 구분 
	private void ActionPartition() {
		// 검색인 경우
		if(rbQuery.isSelected() == true) {
			ScreenPartition();			
		}
		
		// 입력일 경우 
		if(rbInsert.isSelected() == true) {
			int i_chk = insertFieldCheck();
			if(i_chk == 0){
				insertAction();
				TableInit();
				SearchAction();
				ClearColumn();
			}else {
				JOptionPane.showMessageDialog(null, "주소록 정보 입력! ");        			
				
			}			
			ScreenPartition();
		}
		
		// 수정일 경우
		if(rbUpdate.isSelected() == true) {
			int i_chk = insertFieldCheck();
			if(i_chk == 0){
				UpdateAction();
				TableInit();
				SearchAction();
				ClearColumn();
			}else {
				JOptionPane.showMessageDialog(null, "주소록 정보 수정 ! ");        			
				
			}			
			ScreenPartition();
		}
		
		// 삭제일 경우
		if(rbDelete.isSelected() == true) {
			DeleteAction();
			TableInit();
			SearchAction();
			ClearColumn();			
			ScreenPartition();
		}
	}
	
	
	private int insertFieldCheck(){
		int i = 0;
		if(tfName.getText().length() == 0){
			i++;
			tfName.requestFocus();
		}
		if(tfTelno.getText().length() == 0){
			i++;
			tfTelno.requestFocus();
		}
		if(tfAddress.getText().length() == 0){
			i++;
			tfAddress.requestFocus();
		}
		if(tfEmail.getText().length() == 0){
			i++;
			tfEmail.requestFocus();
		}
		if(tfRelation.getText().length() == 0){
			i++;
			tfRelation.requestFocus();
		}
				
		return i;
	}
	
	private void insertAction(){
		String name = tfName.getText();
		String telno = tfTelno.getText();
		String address = tfAddress.getText();
		String email = tfEmail.getText();
		String relation = tfRelation.getText();
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DbAction dbaction = new DbAction(name, telno, address, email, relation, input);
		boolean aaa = dbaction.InsertAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, tfName.getText()+" 님의 정보가 입력 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("이미지 파일경로 :lblImage.setIcon(new ImageIcon(\"/Users/tj/Documents/Kenny/Temp/null.png");
			label_5.setBounds(29, 456, 101, 16);
		}
		return label_5;
	}
	
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setEditable(false);
			tfFilePath.setColumns(10);
			tfFilePath.setBounds(129, 451, 301, 26);
		}
		return tfFilePath;
	}
	
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("파일 경로");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(315, 478, 117, 29);
		}
		return btnFilePath;
	}
	
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/tj/Documents/Kenny/Temp/null.png"));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(22, 484, 215, 112);
		}
		return lblImage;
	}
	
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
	
} // -------------------

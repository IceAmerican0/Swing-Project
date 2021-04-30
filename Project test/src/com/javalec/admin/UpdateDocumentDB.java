package com.javalec.admin;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.with.WithAction;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public  class UpdateDocumentDB {

	private final DefaultTableModel Outer_Table_dcm = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblDocument;
	private JScrollPane scrollPane_dcm;
	private JTextField textField;
	private JButton btnLoad_dcm;
	private JComboBox cbtitle_dcm;
	private JTable Inner_Table_dcm;
	private JRadioButton rdbtnAll;
	private JRadioButton rdbtnBlocked;
	private JRadioButton rdbtnCommon;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDocumentDB window = new UpdateDocumentDB();
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
	public UpdateDocumentDB() {
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
				ScreenPartition();
			}
		});
		frame.setBounds(100, 100, 928, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblDocument());
		frame.getContentPane().add(getScrollPane_dcm());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_dcm());
		frame.getContentPane().add(getCbtitle_dcm());
		frame.getContentPane().add(getRdbtnAll());
		frame.getContentPane().add(getRdbtnBlocked());
		frame.getContentPane().add(getRdbtnNormal());
	}

	private JLabel getLblDocument() {
		if (lblDocument == null) {
			lblDocument = new JLabel("옷 데이터 관리");
			lblDocument.setHorizontalAlignment(SwingConstants.CENTER);
			lblDocument.setBounds(6, 6, 104, 36);
		}
		return lblDocument;
	}
	private JScrollPane getScrollPane_dcm() {
		if (scrollPane_dcm == null) {
			scrollPane_dcm = new JScrollPane();
			scrollPane_dcm.setBounds(6, 54, 913, 477);
			scrollPane_dcm.setViewportView(getInner_Table_dcm());
		}
		return scrollPane_dcm;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(641, 16, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_dcm() {
		if (btnLoad_dcm == null) {
			btnLoad_dcm = new JButton("조회");
			btnLoad_dcm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_dcm.setBounds(853, 15, 65, 29);
		}
		return btnLoad_dcm;
	}
	private JComboBox getCbtitle_dcm() {
		if (cbtitle_dcm == null) {
			cbtitle_dcm = new JComboBox();
			cbtitle_dcm.setModel(new DefaultComboBoxModel(new String[] {"상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
			cbtitle_dcm.setBounds(531, 16, 98, 27);
		}
		return cbtitle_dcm;
	}
	private JTable getInner_Table_dcm() {
		if (Inner_Table_dcm == null) {
			Inner_Table_dcm = new JTable();
			Inner_Table_dcm.setModel(Outer_Table_dcm);
			Inner_Table_dcm.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			Inner_Table_dcm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return Inner_Table_dcm;
	}
	private JRadioButton getRdbtnAll() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("ALL");
			rdbtnAll.setSelected(true);
			rdbtnAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnAll);
			rdbtnAll.setBounds(286, 18, 55, 23);
		}
		return rdbtnAll;
	}
	private JRadioButton getRdbtnBlocked() {
		if (rdbtnBlocked == null) {
			rdbtnBlocked = new JRadioButton("Blocked");
			rdbtnBlocked.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnBlocked);
			rdbtnBlocked.setBounds(353, 18, 86, 23);
		}
		return rdbtnBlocked;
	}
	private JRadioButton getRdbtnNormal() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("Normal");
			rdbtnCommon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(440, 18, 79, 23);
		}
		return rdbtnCommon;
	}
	private void TableInit(){
        int i = Outer_Table_dcm.getRowCount();
        
        Outer_Table_dcm.addColumn("seq");
        Outer_Table_dcm.addColumn("제목");
        Outer_Table_dcm.addColumn("내용");
        Outer_Table_dcm.addColumn("ImageData");
        Outer_Table_dcm.addColumn("등록날짜");
        Outer_Table_dcm.addColumn("삭제날짜");
        Outer_Table_dcm.addColumn("등록User");
        Outer_Table_dcm.setColumnCount(7);

        for(int j = 0 ; j < i ; j++){
            Outer_Table_dcm.removeRow(0);
        }

        Inner_Table_dcm.setAutoResizeMode(Inner_Table_dcm.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        int width = 50;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 500;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table_dcm.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

	}
	private void SearchAction(String WhereCheck){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.DocumentList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp, beanList.get(index).getTitle(), beanList.get(index).getContent(),beanList.get(index).getClothimage(),beanList.get(index).getAddtime(),beanList.get(index).getBlindtime(),beanList.get(index).getUser_userid()
			Outer_Table_dcm.addRow(qTxt);
		}

	}
	private void OpenAction() {
		InsertNotice.main(null);

	}
	private void TableClick() {
		//선택한 번호
		int i = Inner_Table_dcm.getSelectedRow();
		String tkSequence = (String)Inner_Table_dcm.getValueAt(i, 0);
		
		AdminAction adminAction = new AdminAction();
		String Documentid = adminAction.blindcheck(tkSequence);
		if (Documentid == null) {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateBlindtime(tkSequence, 1);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "차단이 해제되었습니다!");      
			          TableInit();
						ScreenPartition();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}if (Documentid != null) {
			int result = JOptionPane.showConfirmDialog(null, "해당 데이터를 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateBlindtime(tkSequence, 0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "데이터가 차단되었습니다!");
			          TableInit();
						ScreenPartition();
			          
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}
		
		

	}
	
	private void ScreenPartition() {
		String WhereCheck = "";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " where not blindtime is null ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " where blindtime is null ";
		}
		TableInit();
		SearchAction(WhereCheck);
	}
	private void ConditionQuery() {
		int i = cbtitle_dcm.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "상의";
			break;
		case 1:
			ConditionQueryColumn = "하의";
			break;
		case 2:
			ConditionQueryColumn = "모자";
			break;
		case 3:
			ConditionQueryColumn = "신발";
			break;
		case 4:
			ConditionQueryColumn = "가방";
			break;
		case 5:
			ConditionQueryColumn = "원피스";
			break;
		case 6:
			ConditionQueryColumn = "아우터";
			break;
		default:
			break;
		}
		String WhereCheck = " where ";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " where not blindtime is null and ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " where blindtime is null and ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);

	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.ConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp+beanList.get(index).getDocumenttype(), beanList.get(index).getDocumentname(), beanList.get(index).getDocumentimage(),beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table_dcm.addRow(qTxt);
		}

	}
	
}

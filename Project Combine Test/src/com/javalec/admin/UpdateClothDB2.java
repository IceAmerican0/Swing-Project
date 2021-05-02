package com.javalec.admin;

import java.awt.Component;
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
import com.javalec.tab.admin_tab;
import com.javalec.tab.user_tab;
import com.javalec.with.InsertNotice;
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

public  class UpdateClothDB2 {

	private final DefaultTableModel Outer_Table_cth = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblcloth;
	private JScrollPane scrollPane_cth;
	private JTextField textField;
	private JButton btnLoad_cth;
	private JComboBox cbtitle_cth;
	private JTable Inner_Table_cth;
	private JRadioButton rdbtnAll;
	private JRadioButton rdbtnBlocked;
	private JRadioButton rdbtnCommon;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClothDB2 window = new UpdateClothDB2();
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
	public UpdateClothDB2() {
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
				ConditionQuery();
			}
		});
		frame.setBounds(100, 100, 928, 568);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblcloth());
		frame.getContentPane().add(getScrollPane_cth());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_cth());
		frame.getContentPane().add(getCbtitle_cth());
		frame.getContentPane().add(getRdbtnAll());
		frame.getContentPane().add(getRdbtnBlocked());
		frame.getContentPane().add(getRdbtnNormal());
		frame.getContentPane().add(getBtnMain());
		frame.setLocationRelativeTo(null);
	}

	private JLabel getLblcloth() {
		if (lblcloth == null) {
			lblcloth = new JLabel("옷 데이터 관리");
			lblcloth.setHorizontalAlignment(SwingConstants.CENTER);
			lblcloth.setBounds(12, 10, 104, 36);
		}
		return lblcloth;
	}
	private JScrollPane getScrollPane_cth() {
		if (scrollPane_cth == null) {
			scrollPane_cth = new JScrollPane();
			scrollPane_cth.setBounds(6, 54, 913, 477);
			scrollPane_cth.setViewportView(getInner_Table_cth());
		}
		return scrollPane_cth;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(641, 16, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_cth() {
		if (btnLoad_cth == null) {
			btnLoad_cth = new JButton("조회");
			btnLoad_cth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_cth.setBounds(853, 15, 65, 29);
		}
		return btnLoad_cth;
	}
	private JComboBox getCbtitle_cth() {
		if (cbtitle_cth == null) {
			cbtitle_cth = new JComboBox();
			cbtitle_cth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			cbtitle_cth.setModel(new DefaultComboBoxModel(new String[] {"ALL", "상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
			cbtitle_cth.setBounds(531, 16, 98, 27);
		}
		return cbtitle_cth;
	}
	private JTable getInner_Table_cth() {
		if (Inner_Table_cth == null) {
			Inner_Table_cth = new JTable();
			Inner_Table_cth.setModel(Outer_Table_cth);
			Inner_Table_cth.isCellEditable(0, 100);
			Inner_Table_cth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			Inner_Table_cth.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return Inner_Table_cth;
	}
	private JRadioButton getRdbtnAll() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("ALL");
			rdbtnAll.setSelected(true);
			rdbtnAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
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
					ConditionQuery();
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
//					ScreenPartition();
					ConditionQuery();
				}
			});
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(440, 18, 79, 23);
		}
		return rdbtnCommon;
	}
	private void TableInit(){
        int i = Outer_Table_cth.getRowCount();
        
        Outer_Table_cth.addColumn("seq");
        Outer_Table_cth.addColumn("분류");
        Outer_Table_cth.addColumn("이름");
        Outer_Table_cth.addColumn("ImageData");
        Outer_Table_cth.addColumn("등록날짜");
        Outer_Table_cth.addColumn("삭제날짜");
        Outer_Table_cth.addColumn("등록User");
        Outer_Table_cth.setColumnCount(7);

        for(int j = 0 ; j < i ; j++){
            Outer_Table_cth.removeRow(0);
        }

        Inner_Table_cth.setAutoResizeMode(Inner_Table_cth.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        int width = 60;
        col.setPreferredWidth(width);
        vColIndex = 1;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 2;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);
        vColIndex = 3;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 60;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

	}
	private void SearchAction(String WhereCheck){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.ClothList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); //imageid
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}

	private void TableClick() {
		//선택한 번호
		int i = Inner_Table_cth.getSelectedRow();
		String tkSequence = (String)Inner_Table_cth.getValueAt(i, 0);
		
		AdminAction adminAction = new AdminAction();
		String Clothid = adminAction.ClothBlindCheck(tkSequence);
		if (Clothid == null) {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(tkSequence, 1);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "차단이 해제되었습니다!");      
			          TableInit();
//						ScreenPartition();
			          ConditionQuery();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
				
			}
		}if (Clothid != null) {
			int result = JOptionPane.showConfirmDialog(null, "해당 데이터를 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(tkSequence, 0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "데이터가 차단되었습니다!");
			          TableInit();
//						ScreenPartition();
			          ConditionQuery();
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
			WhereCheck = " and not blindtime is null ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " and blindtime is null ";
		}
		TableInit();
		SearchAction(WhereCheck);
	}
	
	private void ConditionQuery() {
		int i = cbtitle_cth.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "";
			break;
		case 1:
			ConditionQueryColumn = " clothtype = '상의' and";
			break;
		case 2:
			ConditionQueryColumn = " clothtype = '하의' and";
			break;
		case 3:
			ConditionQueryColumn = " clothtype = '모자' and";
			break;
		case 4:
			ConditionQueryColumn = " clothtype = '신발' and";
			break;
		case 5:
			ConditionQueryColumn = " clothtype = '가방'and";
			break;
		case 6:
			ConditionQueryColumn = " clothtype = '원피스' and";
			break;
		case 7:
			ConditionQueryColumn = " clothtype = '아우터' and";
			break;
		default:
			break;
		}
		String WhereCheck = "";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " where not blindtime is null and";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " where blindtime is null and";
		}if (rdbtnAll.isSelected()) {
			WhereCheck = "where";
		}
		if (rdbtnAll.isSelected() && ConditionQueryColumn == "") {
			WhereCheck = "";
			ConditionQueryColumn = "where ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);

	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.ClothConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); 
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}
	
	private JButton getBtnMain() {
		if (btnMain == null) {
			btnMain = new JButton("메인으로");
			btnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ShareVar.admincheck==1) {
						admin_tab.main(null);
						frame.dispose();
					}
					if(ShareVar.admincheck==0) {
						user_tab.main(null);
						frame.dispose();
					}
				}
			});
			btnMain.setBounds(145, 17, 97, 23);
		}
		return btnMain;
	}
}

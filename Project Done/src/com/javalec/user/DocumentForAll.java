package com.javalec.user;

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

import com.javalec.admin.SelectDocumentDB;
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
import java.awt.Font;

public  class DocumentForAll extends JFrame {

	private final DefaultTableModel Outer_Table_dc = new DefaultTableModel();
	private JFrame frame;
	private JScrollPane scrollPane_dc;
	private JTextField textField;
	private JButton btnLoad_dc;
	private JComboBox cbtitle_dc;
	private JTable Inner_Table_dc;
	private JRadioButton rdbtnAll;
	private JRadioButton rdbtnMine;
	private JRadioButton rdbtnLiked;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnMain;
	private JLabel lblmember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DocumentForAll window = new DocumentForAll();
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
	public DocumentForAll() {
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
		frame.setBounds(100, 100, 930, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane_dc());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_dc());
		frame.getContentPane().add(getCbtitle_dc());
		frame.getContentPane().add(getRdbtnAll());
		frame.getContentPane().add(getRdbtnMine());
		frame.getContentPane().add(getRdbtnNormal());
		frame.getContentPane().add(getBtnMain());
		
		JButton btnMain_1 = new JButton("?????? ??????");
		btnMain_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertDocument.main(null);
			}
		});
		btnMain_1.setBounds(265, 27, 97, 23);
		frame.getContentPane().add(btnMain_1);
		frame.getContentPane().add(getLblmember());
		
//		JButton btnMain_2 = new JButton("??? ??????");
//		btnMain_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				UpdateDocument.main(null);
//			}
//		});
//		btnMain_2.setBounds(351, 17, 97, 23);
//		frame.getContentPane().add(btnMain_2);
		frame.setLocationRelativeTo(null);
	}
	private JScrollPane getScrollPane_dc() {
		if (scrollPane_dc == null) {
			scrollPane_dc = new JScrollPane();
			scrollPane_dc.setBounds(6, 54, 913, 477);
			scrollPane_dc.setViewportView(getInner_Table_dc());
		}
		return scrollPane_dc;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(638, 25, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_dc() {
		if (btnLoad_dc == null) {
			btnLoad_dc = new JButton("??????");
			btnLoad_dc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_dc.setBounds(850, 24, 65, 29);
		}
		return btnLoad_dc;
	}
	private JComboBox getCbtitle_dc() {
		if (cbtitle_dc == null) {
			cbtitle_dc = new JComboBox();
			cbtitle_dc.setModel(new DefaultComboBoxModel(new String[] {"??????", "?????????", "??????+??????"}));
			cbtitle_dc.setBounds(528, 25, 98, 27);
		}
		return cbtitle_dc;
	}
	private JTable getInner_Table_dc() {
		if (Inner_Table_dc == null) {
			Inner_Table_dc = new JTable();
			Inner_Table_dc.setModel(Outer_Table_dc);
			Inner_Table_dc.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			Inner_Table_dc.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return Inner_Table_dc;
	}
	private JRadioButton getRdbtnAll() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("ALL");
			rdbtnAll.setEnabled(false);
			rdbtnAll.setSelected(true);
			rdbtnAll.setVisible(false);
			rdbtnAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnAll);
			rdbtnAll.setBounds(450, 17, 55, 23);
		}
		return rdbtnAll;
	}
	private JRadioButton getRdbtnMine() {
		if (rdbtnMine == null) {
			rdbtnMine = new JRadioButton("Mine");
			rdbtnMine.setEnabled(false);
			rdbtnMine.setVisible(false);
			rdbtnMine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnMine);
			rdbtnMine.setBounds(437, 17, 86, 23);
		}
		return rdbtnMine;
	}
	private JRadioButton getRdbtnNormal() {
		if (rdbtnLiked == null) {
			rdbtnLiked = new JRadioButton("Liked");
			rdbtnLiked.setEnabled(false);
			rdbtnLiked.setVisible(false);
			rdbtnLiked.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScreenPartition();
				}
			});
			buttonGroup.add(rdbtnLiked);
			rdbtnLiked.setBounds(440, 18, 79, 23);
		}
		return rdbtnLiked;
	}
	private void TableInit(){
        int i = Outer_Table_dc.getRowCount();
        
        Outer_Table_dc.addColumn("seq");
        Outer_Table_dc.addColumn("??????");
        Outer_Table_dc.addColumn("??????");
        Outer_Table_dc.addColumn("Imageid");
        Outer_Table_dc.addColumn("?????????");
        Outer_Table_dc.addColumn("????????????");
//        Outer_Table_dc.addColumn("????????????");
        Outer_Table_dc.setColumnCount(6);

        for(int j = 0 ; j < i ; j++){
            Outer_Table_dc.removeRow(0);
        }

        Inner_Table_dc.setAutoResizeMode(Inner_Table_dc.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        int width = 60;
        col.setPreferredWidth(width);
        vColIndex = 1;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 2;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);
        vColIndex = 3;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 60;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
//        vColIndex = 6;
//        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
//        width = 150;
//        col.setPreferredWidth(width);
//       


	}
	private void SearchAction(String WhereCheck){
		DocumentForAllAction documentForAllAction = new DocumentForAllAction();
		ArrayList<Bean> beanList = documentForAllAction.DocumentList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); //imageid
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime()};
			Outer_Table_dc.addRow(qTxt);
		}

	}
	private void OpenAction() {
		InsertNotice.main(null);

	}
	private void TableClick() {
		int i = Inner_Table_dc.getSelectedRow();
		String tkSequence = (String)Inner_Table_dc.getValueAt(i, 0);
		ShareVar.seqIndex = Integer.parseInt(tkSequence);
//		System.out.println(ShareVar.seqIndex);
		SelectDocument.main(null);

	}
		
		
		
		
		
//		if (documentid == null) {
//			//????????? ?????????
//			int result = JOptionPane.showConfirmDialog(null, "????????? ?????????????????????????", "EVENT", JOptionPane.YES_NO_OPTION);
//			if (result == JOptionPane.YES_OPTION) {
//				boolean aaa = adminAction.UpdateDocumentBlindtime(tkSequence, 1);
//				if(aaa == true){
//			          JOptionPane.showMessageDialog(null, "????????? ?????????????????????!");      
//			          TableInit();
//			          ScreenPartition();
//				}else{
//			          JOptionPane.showMessageDialog(null, "DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!");                    
//				}
//			}else {
//			
//			}
//		}if (documentid != null) {
//			int result = JOptionPane.showConfirmDialog(null, "?????? ???????????? ?????????????????????????", "EVENT", JOptionPane.YES_NO_OPTION);
//			if (result == JOptionPane.YES_OPTION) {
//				boolean aaa = adminAction.UpdateDocumentBlindtime(tkSequence, 0);
//				if(aaa == true){
//			          JOptionPane.showMessageDialog(null, "???????????? ?????????????????????!");
//			          TableInit();
//			          ScreenPartition();
//			          
//				}else{
//			          JOptionPane.showMessageDialog(null, "DB??? ?????? ????????? ????????? ??????????????????! \n ????????????????????? ???????????????!");                    
//				}
//			}else {
//				
//			}
//		}
		
		

	
	private void ScreenPartition() {
		String WhereCheck = " where documenttype = 0 and blindtime is null ";
//		if (rdbtnMine.isSelected()) {
//			WhereCheck += " and User_userid = '" + ShareVar.nowId + "'";
//			
//		}else if (rdbtnLiked.isSelected()) {
//			WhereCheck = " d and likedocument ld where d.blindtime is null and d.User_userid = ld.User_userid and d.documentid = ld.Document_documentid";
//		}
		TableInit();
		SearchAction(WhereCheck);
		System.out.println(WhereCheck);
	}
	private void ConditionQuery() {
		int i = cbtitle_dc.getSelectedIndex();
		String ConditionQueryColumn1 = "";
		String ConditionQueryColumn2 = "";
		String WhereCheck = " and blindtime is null ";
		TableInit();
		switch (i) {
		case 0:
			ConditionQueryColumn1 = " documenttitle";
			ConditionQueryAction(ConditionQueryColumn1, WhereCheck);
			break;
		case 1:
			ConditionQueryColumn1 = " User_userid";
			ConditionQueryAction(ConditionQueryColumn1, WhereCheck);
			break;
		case 2:
			ConditionQueryColumn1 = " documentcontent ";
			ConditionQueryColumn2 = " documenttitle ";
			ConditionQueryAction(ConditionQueryColumn1, ConditionQueryColumn2, WhereCheck);
			break;
		default:
			break;
		}
//		if (rdbtnMine.isSelected()) {
//			WhereCheck = " and not blindtime is null ";
//			
//		}if (rdbtnLiked.isSelected()) {
//			WhereCheck = " and blindtime is null ";
//		}
		

	}
	private void ConditionQueryAction(String ConditionQueryColumn1, String ConditionQueryColumn2, String WhereCheck) {
		DocumentForAllAction documentForAllAction = new DocumentForAllAction();
		ArrayList<Bean> beanList = documentForAllAction.DocumentConditionList(ConditionQueryColumn1, ConditionQueryColumn2, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); 
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime()};			
			Outer_Table_dc.addRow(qTxt);
		}

	}
	private void ConditionQueryAction(String ConditionQueryColumn1, String WhereCheck) {
		DocumentForAllAction documentForAllAction = new DocumentForAllAction();
		ArrayList<Bean> beanList = documentForAllAction.DocumentConditionList(ConditionQueryColumn1, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); 
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime()};			
			Outer_Table_dc.addRow(qTxt);
		}

	}
	
	private JButton getBtnMain() {
		if (btnMain == null) {
			btnMain = new JButton("????????????");
			btnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose(); // jy2 : ??????
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
			btnMain.setBounds(170, 27, 97, 23);
		}
		return btnMain;
	}
	private JLabel getLblmember() {
		if (lblmember == null) {
			lblmember = new JLabel("????????? ??????");
			lblmember.setHorizontalAlignment(SwingConstants.CENTER);
			lblmember.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblmember.setBounds(19, 21, 130, 26);
		}
		return lblmember;
	}
}

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
import java.io.InputStream;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;

public  class UpdateClothDB extends JFrame {

	private final DefaultTableModel Outer_Table_cth = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblmember;
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
					UpdateClothDB window = new UpdateClothDB();
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
	public UpdateClothDB() {
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblmember());
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

	private JLabel getLblmember() {
		if (lblmember == null) {
			lblmember = new JLabel("????????? ??????");
			lblmember.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblmember.setHorizontalAlignment(SwingConstants.CENTER);
			lblmember.setBounds(18, 25, 130, 26);
		}
		return lblmember;
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
			textField.setBounds(633, 27, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_cth() {
		if (btnLoad_cth == null) {
			btnLoad_cth = new JButton("??????");
			btnLoad_cth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_cth.setBounds(854, 26, 65, 29);
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
			cbtitle_cth.setModel(new DefaultComboBoxModel(new String[] {"ALL", "??????", "??????", "??????", "??????", "??????", "?????????", "?????????"}));
			cbtitle_cth.setBounds(531, 27, 98, 27);
		}
		return cbtitle_cth;
	}
	private JTable getInner_Table_cth() {
		if (Inner_Table_cth == null) {
			Inner_Table_cth = new JTable();
			Inner_Table_cth.setModel(Outer_Table_cth);
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
			rdbtnAll.setBounds(286, 29, 55, 23);
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
			rdbtnBlocked.setBounds(353, 29, 86, 23);
		}
		return rdbtnBlocked;
	}
	private JRadioButton getRdbtnNormal() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("Normal");
			rdbtnCommon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(440, 29, 79, 23);
		}
		return rdbtnCommon;
	}
	private void TableInit(){
        int i = Outer_Table_cth.getRowCount();
        
        Outer_Table_cth.addColumn("seq");
        Outer_Table_cth.addColumn("??????");
        Outer_Table_cth.addColumn("??????");
        Outer_Table_cth.addColumn("??????User");
        Outer_Table_cth.addColumn("????????????");
        Outer_Table_cth.addColumn("????????????");
        Outer_Table_cth.setColumnCount(6);

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
        width = 70;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_cth.getColumnModel().getColumn(vColIndex);
        width = 150;
        col.setPreferredWidth(width);
       


	}
	private void SearchAction(String WhereCheck){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.ClothList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
//			System.out.println(beanList.get(index).getUser_userid());
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}
	private void TableClick() {
		int i = Inner_Table_cth.getSelectedRow();
		String tkSequence = (String)Inner_Table_cth.getValueAt(i, 0);
		ShareVar.seqIndex = Integer.parseInt(tkSequence);
		SelectClothDB.main(null);
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
		int i = cbtitle_cth.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "";
			break;
		case 1:
			ConditionQueryColumn = " clothtype = '??????' and";
			break;
		case 2:
			ConditionQueryColumn = " clothtype = '??????' and";
			break;
		case 3:
			ConditionQueryColumn = " clothtype = '??????' and";
			break;
		case 4:
			ConditionQueryColumn = " clothtype = '??????' and";
			break;
		case 5:
			ConditionQueryColumn = " clothtype = '??????'and";
			break;
		case 6:
			ConditionQueryColumn = " clothtype = '?????????' and";
			break;
		case 7:
			ConditionQueryColumn = " clothtype = '?????????' and";
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
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}
	
	private JButton getBtnMain() {
		if (btnMain == null) {
			btnMain = new JButton("????????????");
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
			btnMain.setBounds(160, 29, 97, 23);
		}
		return btnMain;
	}
}

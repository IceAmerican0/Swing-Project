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

public  class MyPresetList extends JFrame {

	private final DefaultTableModel Outer_Table_cth = new DefaultTableModel();
	private JFrame frame;
	private JScrollPane scrollPane_cth;
	private JTextField textField;
	private JButton btnLoad_cth;
	private JTable Inner_Table_cth;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnBack;
	private JLabel lblmember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPresetList window = new MyPresetList();
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
	public MyPresetList() {
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
		frame.getContentPane().add(getScrollPane_cth());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_cth());
		frame.getContentPane().add(getBtnBack());
		frame.getContentPane().add(getLblmember_1());
		frame.setLocationRelativeTo(null);
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
			textField.setBounds(641, 26, 208, 26);
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
			btnLoad_cth.setBounds(853, 25, 65, 29);
		}
		return btnLoad_cth;
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
	private void TableInit(){
        int i = Outer_Table_cth.getRowCount();
        
        Outer_Table_cth.addColumn("seq");
        Outer_Table_cth.addColumn("분류");
        Outer_Table_cth.addColumn("이름");
        Outer_Table_cth.addColumn("등록날짜");
        Outer_Table_cth.setColumnCount(4);

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
        width = 200;
        col.setPreferredWidth(width);
       


	}
	private void SearchAction(){
		UserAction userAction=new UserAction();
		ArrayList<Bean> beanList = userAction.UserPresetList();
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
//			System.out.println(beanList.get(index).getUser_userid());
			String[] qTxt = {temp,beanList.get(index).getTitle(),beanList.get(index).getContent(), beanList.get(index).getAddtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}
	private void TableClick() {
		int i = Inner_Table_cth.getSelectedRow();
		String tkSequence = (String)Inner_Table_cth.getValueAt(i, 0);
		ShareVar.seqIndex = Integer.parseInt(tkSequence);
		ShareVar.imageIndex = Integer.parseInt(tkSequence);
		UserPresetSelectedCloth.main(null);
	}
	
	private void ScreenPartition() {
		TableInit();
		SearchAction();
	}
	private void ConditionQuery() {
		String ConditionQueryColumn = "";
		
		String WhereCheck = " where ";
		if (ConditionQueryColumn == "") {
			WhereCheck = "";
			ConditionQueryColumn = "where ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);
	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		UserAction userAction=new UserAction();
		ArrayList<Bean> beanList = userAction.UserPresetConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp,beanList.get(index).getTitle(),beanList.get(index).getContent(), beanList.get(index).getAddtime()};
			Outer_Table_cth.addRow(qTxt);
		}

	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("뒤로가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnBack.setBounds(133, 28, 97, 23);
		}
		return btnBack;
	}
	private JLabel getLblmember_1() {
		if (lblmember == null) {
			lblmember = new JLabel("스타일링");
			lblmember.setHorizontalAlignment(SwingConstants.CENTER);
			lblmember.setFont(new Font("Lucida Grande", Font.BOLD, 18));
			lblmember.setBounds(6, 24, 130, 26);
		}
		return lblmember;
	}
}

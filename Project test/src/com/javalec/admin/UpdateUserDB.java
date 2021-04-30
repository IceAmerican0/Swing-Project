package com.javalec.admin;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public  class UpdateUserDB {

	private final DefaultTableModel Outer_Table_mb = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblmember;
	private JScrollPane scrollPane_mb;
	private JTextField textField;
	private JButton btnLoad_mb;
	private JComboBox cbtitle_mb;
	private JTable Inner_Table_mb;
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
					UpdateUserDB window = new UpdateUserDB();
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
	public UpdateUserDB() {
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
		frame.setBounds(100, 100, 928, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblmember());
		frame.getContentPane().add(getScrollPane_mb());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_mb());
		frame.getContentPane().add(getCbtitle_mb());
		frame.getContentPane().add(getRdbtnAll());
		frame.getContentPane().add(getRdbtnBlocked());
		frame.getContentPane().add(getRdbtnNormal());
	}

	private JLabel getLblmember() {
		if (lblmember == null) {
			lblmember = new JLabel("회원관리");
			lblmember.setHorizontalAlignment(SwingConstants.CENTER);
			lblmember.setBounds(6, 6, 104, 36);
		}
		return lblmember;
	}
	private JScrollPane getScrollPane_mb() {
		if (scrollPane_mb == null) {
			scrollPane_mb = new JScrollPane();
			scrollPane_mb.setBounds(6, 54, 913, 477);
			scrollPane_mb.setViewportView(getInner_Table_mb());
		}
		return scrollPane_mb;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(641, 16, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_mb() {
		if (btnLoad_mb == null) {
			btnLoad_mb = new JButton("조회");
			btnLoad_mb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_mb.setBounds(853, 15, 65, 29);
		}
		return btnLoad_mb;
	}
	private JComboBox getCbtitle_mb() {
		if (cbtitle_mb == null) {
			cbtitle_mb = new JComboBox();
			cbtitle_mb.setModel(new DefaultComboBoxModel(new String[] {"ID", "NAME", "E-MAIL"}));
			cbtitle_mb.setBounds(531, 16, 98, 27);
		}
		return cbtitle_mb;
	}
	private JTable getInner_Table_mb() {
		if (Inner_Table_mb == null) {
			Inner_Table_mb = new JTable();
			Inner_Table_mb.setModel(Outer_Table_mb);
			Inner_Table_mb.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					TableClick();
				}
			});
			Inner_Table_mb.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1){
						TableClick();
					}
				}
			});
		}
		return Inner_Table_mb;
	}
	private JRadioButton getRdbtnAll() {
		if (rdbtnAll == null) {
			rdbtnAll = new JRadioButton("ALL");
			buttonGroup.add(rdbtnAll);
			rdbtnAll.setBounds(286, 18, 55, 23);
		}
		return rdbtnAll;
	}
	private JRadioButton getRdbtnBlocked() {
		if (rdbtnBlocked == null) {
			rdbtnBlocked = new JRadioButton("Blocked");
			buttonGroup.add(rdbtnBlocked);
			rdbtnBlocked.setBounds(353, 18, 86, 23);
		}
		return rdbtnBlocked;
	}
	private JRadioButton getRdbtnNormal() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("Normal");
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(440, 18, 79, 23);
		}
		return rdbtnCommon;
	}
	private void TableInit(){
        int i = Outer_Table_mb.getRowCount();
        
        Outer_Table_mb.addColumn("UserID");
        Outer_Table_mb.addColumn("UserName");
        Outer_Table_mb.addColumn("UserE-mail");
        Outer_Table_mb.addColumn("가입날짜");
        Outer_Table_mb.addColumn("정지날짜");
        Outer_Table_mb.addColumn("Admin");
        Outer_Table_mb.addColumn("");
        Outer_Table_mb.setColumnCount(7);

        for(int j = 0 ; j < i ; j++){
            Outer_Table_mb.removeRow(0);
        }

        Inner_Table_mb.setAutoResizeMode(Inner_Table_mb.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);

        vColIndex = 3;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table_mb.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);

	}
	private void SearchAction(){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.UserList();
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getAdmin());
			String[] qTxt = {beanList.get(index).getUserid(), beanList.get(index).getUsername(),beanList.get(index).getUseremail(),beanList.get(index).getUseraddtime(),beanList.get(index).getUserblindtime(), temp};
			Outer_Table_mb.addRow(qTxt);
		}

	}
	private void OpenAction() {
		InsertNotice.main(null);

	}
	private void TableClick() {
		//선택한 번호
		int i = Inner_Table_mb.getSelectedRow();
        String tkSequence = (String)Inner_Table_mb.getValueAt(i, 0);
        ShareVar.seqIndex = Integer.parseInt(tkSequence);
		

	}
	private void ConditionQuery() {
		int i = cbtitle_mb.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "userid";
			break;
		case 1:
			ConditionQueryColumn = "username";
			break;
		case 2:
			ConditionQueryColumn = "useremail";
			break;
		default:
			break;
		}
		String WhereCheck = "";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " not userblindtime is null and ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " userblindtime is null and ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);

	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.ConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getAdmin());
			String[] qTxt = {beanList.get(index).getUserid(), beanList.get(index).getUsername(), beanList.get(index).getUseremail(),beanList.get(index).getUseraddtime(),beanList.get(index).getUserblindtime(), temp};
			Outer_Table_mb.addRow(qTxt);
		}

	}
	
}

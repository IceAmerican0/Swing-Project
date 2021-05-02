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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public  class UpdateDocumentDB extends JFrame {

	private final DefaultTableModel Outer_Table_dc = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblmember;
	private JScrollPane scrollPane_dc;
	private JTextField textField;
	private JButton btnLoad_dc;
	private JComboBox cbtitle_dc;
	private JTable Inner_Table_dc;
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
				ScreenPartition();
			}
		});
		frame.setBounds(100, 100, 930, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblmember());
		frame.getContentPane().add(getScrollPane_dc());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_dc());
		frame.getContentPane().add(getCbtitle_dc());
		frame.getContentPane().add(getRdbtnAll());
		frame.getContentPane().add(getRdbtnBlocked());
		frame.getContentPane().add(getRdbtnNormal());
		frame.getContentPane().add(getBtnMain());
		frame.setLocationRelativeTo(null);
	}

	private JLabel getLblmember() {
		if (lblmember == null) {
			lblmember = new JLabel("게시글 관리");
			lblmember.setHorizontalAlignment(SwingConstants.CENTER);
			lblmember.setBounds(6, 10, 104, 36);
		}
		return lblmember;
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
			textField.setBounds(641, 16, 208, 26);
		}
		return textField;
	}
	private JButton getBtnLoad_dc() {
		if (btnLoad_dc == null) {
			btnLoad_dc = new JButton("조회");
			btnLoad_dc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ConditionQuery();
				}
			});
			btnLoad_dc.setBounds(853, 15, 65, 29);
		}
		return btnLoad_dc;
	}
	private JComboBox getCbtitle_dc() {
		if (cbtitle_dc == null) {
			cbtitle_dc = new JComboBox();
			cbtitle_dc.setModel(new DefaultComboBoxModel(new String[] {"제목", "작성자", "제목+내용"}));
			cbtitle_dc.setBounds(531, 16, 98, 27);
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
        int i = Outer_Table_dc.getRowCount();
        
        Outer_Table_dc.addColumn("seq");
        Outer_Table_dc.addColumn("제목");
        Outer_Table_dc.addColumn("내용");
        Outer_Table_dc.addColumn("Imageid");
        Outer_Table_dc.addColumn("작성자");
        Outer_Table_dc.addColumn("작성날짜");
        Outer_Table_dc.addColumn("정지날짜");
        Outer_Table_dc.setColumnCount(7);

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
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table_dc.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
       


	}
	private void SearchAction(String WhereCheck){
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.DocumentList(WhereCheck);
		
		int listCount = beanList.size();
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); //imageid
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};
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
		SelectDocumentDB.main(null);
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
		int i = cbtitle_dc.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = " and documenttitle";
			break;
		case 1:
			ConditionQueryColumn = " and User_userid";
			break;
		case 2:
			ConditionQueryColumn = "and documentcontent or documenttitle";
			break;
		default:
			break;
		}
		String WhereCheck = "";
		if (rdbtnBlocked.isSelected()) {
			WhereCheck = " and not blindtime is null ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " and blindtime is null ";
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn, WhereCheck);

	}
	private void ConditionQueryAction(String ConditionQueryColumn, String WhereCheck) {
		AdminAction adminAction = new AdminAction();
		ArrayList<Bean> beanList = adminAction.DocumentConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); 
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};			Outer_Table_dc.addRow(qTxt);
			Outer_Table_dc.addRow(qTxt);
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
			btnMain.setBounds(133, 17, 97, 23);
		}
		return btnMain;
	}
}

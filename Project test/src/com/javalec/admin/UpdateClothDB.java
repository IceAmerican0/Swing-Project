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

public  class UpdateClothDB extends JFrame {

	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JFrame frame;
	private JLabel lblmember;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JButton btnLoad_dc;
	private JComboBox cbtitle;
	private JTable Inner_Table;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblmember());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnLoad_dc());
		frame.getContentPane().add(getCbtitle());
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
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 54, 913, 477);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
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
	private JComboBox getCbtitle() {
		if (cbtitle == null) {
			cbtitle = new JComboBox();
			cbtitle.setModel(new DefaultComboBoxModel(new String[] {"제목", "작성자", "제목+내용"}));
			cbtitle.setBounds(531, 16, 98, 27);
		}
		return cbtitle;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
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
        int i = Outer_Table.getRowCount();
        
        Outer_Table.addColumn("seq");
        Outer_Table.addColumn("분류");
        Outer_Table.addColumn("이름");
        Outer_Table.addColumn("ImageData");
        Outer_Table.addColumn("등록User");
        Outer_Table.addColumn("등록날짜");
        Outer_Table.addColumn("삭제날짜");
        Outer_Table.setColumnCount(7);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 60;
        col.setPreferredWidth(width);
        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 300;
        col.setPreferredWidth(width);
        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 60;
        col.setPreferredWidth(width);
        vColIndex = 4;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 5;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 6;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
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
			Outer_Table.addRow(qTxt);
		}

	}
	private void OpenAction() {
		InsertNotice.main(null);

	}
	private void TableClick() {
		//선택한 번호
		int i = Inner_Table.getSelectedRow();
		String tkSequence = (String)Inner_Table.getValueAt(i, 0);
		
		AdminAction adminAction = new AdminAction();
		String clothid = adminAction.ClothBlindCheck(tkSequence);
		if (clothid == null) {
			//차단된 사용자
			int result = JOptionPane.showConfirmDialog(null, "차단을 해제하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(tkSequence, 1);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "차단이 해제되었습니다!");      
			          TableInit();
						ScreenPartition();
				}else{
			          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
				}
			}else {
			
			}
		}if (clothid != null) {
			int result = JOptionPane.showConfirmDialog(null, "해당 게시글을 차단하시겠습니까?", "EVENT", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				boolean aaa = adminAction.UpdateClothBlindtime(tkSequence, 0);
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "게시글이 차단되었습니다!");
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
			WhereCheck = " and not blindtime is null ";
			
		}if (rdbtnCommon.isSelected()) {
			WhereCheck = " and blindtime is null ";
		}
		TableInit();
		SearchAction(WhereCheck);
	}
	private void ConditionQuery() {
		int i = cbtitle.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = " and clothtitle";
			break;
		case 1:
			ConditionQueryColumn = " and User_userid";
			break;
		case 2:
			ConditionQueryColumn = "and clothcontent or clothtitle";
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
		ArrayList<Bean> beanList = adminAction.ClothConditionList(ConditionQueryColumn, textField.getText().trim(), WhereCheck);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String temp2 = Integer.toString(beanList.get(index).getAdmin()); 
			String[] qTxt = {temp, beanList.get(index).getTitle(),beanList.get(index).getContent(),temp2,beanList.get(index).getUserid(), beanList.get(index).getAddtime(),beanList.get(index).getBlindtime()};			Outer_Table.addRow(qTxt);
			Outer_Table.addRow(qTxt);
		}

	}
	
}

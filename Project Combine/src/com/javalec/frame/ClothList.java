package com.javalec.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.admin.AdminAction;
import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.user.UserAction;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClothList {

	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JFrame frame;
	private JScrollPane scrollPane;
	private JLabel ClothData;
	private JComboBox comboBox;
	private JButton btnOK;
	private JButton btnCancel;
	private JTable Inner_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothList window = new ClothList();
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
	public ClothList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 299);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInit();
				SearchAction();
			}
		});
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getClothData());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 208, 259);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getClothData() {
		if (ClothData == null) {
			ClothData = new JLabel((Icon) null);
			ClothData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothData.setBounds(256, 30, 177, 197);
		}
		return ClothData;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableInit();
					SearchAction();
				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"ALL", "상의", "하의", "모자", "신발", "가방", "원피스", "아우터"}));
			comboBox.setBounds(358, 6, 97, 27);
		}
		return comboBox;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("선택");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TossAction();
				}
			});
			btnOK.setBounds(266, 236, 75, 29);
		}
		return btnOK;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnCancel.setBounds(347, 236, 75, 29);
		}
		return btnCancel;
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
        Outer_Table.addColumn("분류");
        Outer_Table.addColumn("이름");
        Outer_Table.addColumn("등록자");
        Outer_Table.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 20;
        col.setPreferredWidth(width);
        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width =100;
        col.setPreferredWidth(width);
        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 80;
	}
	
	private void SearchAction() {
		
		int i = comboBox.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "";
			break;
		case 1:
			ConditionQueryColumn = " and clothtype = '상의'";
			break;
		case 2:
			ConditionQueryColumn = " and clothtype = '하의'";
			break;
		case 3:
			ConditionQueryColumn = " and clothtype = '모자'";
			break;
		case 4:
			ConditionQueryColumn = " and clothtype = '신발'";
			break;
		case 5:
			ConditionQueryColumn = " and clothtype = '가방'";
			break;
		case 6:
			ConditionQueryColumn = " and clothtype = '원피스'";
			break;
		case 7:
			ConditionQueryColumn = " and clothtype = '아우터'";
			break;
		default:
			break;
		}
		
		
		UserAction userAction = new UserAction();
		ArrayList<Bean> beanList = userAction.ClothList(ConditionQueryColumn);
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getTablePK());
			String[] qTxt = {temp,beanList.get(index).getTitle(), beanList.get(index).getAddtime(),beanList.get(index).getUsername()};
			Outer_Table.addRow(qTxt);
		}
		

	}
	private void TableClick() {
		int i = Inner_Table.getSelectedRow();
		String tkSequence = (String)Inner_Table.getValueAt(i, 0);
		int imageseq = Integer.parseInt(tkSequence);
		
		UserAction userAction = new UserAction();
		InputStream input = userAction.ClothListClick(imageseq);
//----------------------------------------파일 불러오기--------------------------------------
        String filePath = Integer.toString(ShareVar.filename);
		ClothData.setIcon(new ImageIcon(filePath));
		ClothData.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filePath);
		file.delete();
//----------------------------------------파일 불러오기--------------------------------------
	}
	private void TossAction() {
		// TODO Auto-generated method stub
		frame.dispose();
	}
}

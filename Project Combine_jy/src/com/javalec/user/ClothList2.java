package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Image;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClothList2 {

	private JFrame frame;
	private JTable table;
	private JComboBox cbclothtype;
	private JLabel lblClothImage;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClothList2 window = new ClothList2();
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
	public ClothList2() {
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
		frame.setBounds(100, 100, 366, 539);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 241, 328, 182);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox cbclothtype = new JComboBox();
		cbclothtype.setModel(new DefaultComboBoxModel(new String[] {"모자", "상의", "하의", "원피스", "아우터", "신발"}));
		cbclothtype.setBounds(87, 10, 138, 27);
		frame.getContentPane().add(cbclothtype);
		
		JLabel lblNewLabel = new JLabel("종류 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(25, 14, 50, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSelect = new JButton("선택");
		btnSelect.setBounds(87, 448, 89, 29);
		frame.getContentPane().add(btnSelect);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.setBounds(174, 448, 89, 29);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblClothImage = new JLabel("clothimage");
		lblClothImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblClothImage.setBounds(81, 58, 182, 173);
		frame.getContentPane().add(lblClothImage);
		
		
		String filePath = Integer.toString(ShareVar.filename);
		ImageIcon ii = new ImageIcon(filePath);
		Image image = ii.getImage().getScaledInstance(lblClothImage.getWidth(), lblClothImage.getHeight(), Image.SCALE_SMOOTH);
		
		lblClothImage.setIcon(new ImageIcon(image));
		
		JButton btnImageSearch = new JButton("검색");
		btnImageSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableInit();
				ConditionQuery();
			}
		});
		btnImageSearch.setBounds(237, 12, 91, 23);
		frame.getContentPane().add(btnImageSearch);
		
		
	}
	
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        System.out.println(i);
        Outer_Table.addColumn("clothid");
        Outer_Table.addColumn("clothtype");
        Outer_Table.addColumn("clothname");
        Outer_Table.setColumnCount(3);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }

        table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = table.getColumnModel().getColumn(vColIndex);
        int width = 30;
        col.setPreferredWidth(width);

        vColIndex = 1;
        col = table.getColumnModel().getColumn(vColIndex);
        width = 30;
        col.setPreferredWidth(width);

        vColIndex = 2;
        col = table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);

	}
	
	// Table에서 Row를 Click후 검색 
		private void TableClick() {
	        int i = table.getSelectedRow();
	        String tkSequence = (String)table.getValueAt(i, 0);
	        int wkSequence = Integer.parseInt(tkSequence);
	        
	        ClothList2Action clothList2Action = new ClothList2Action(wkSequence);
	        clothList2Action.TableClick();
	        
	        // Image처리
	        // File name이 틀려야 즉각 보여주기가 가능하여   
	        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
	        
			String filePath = Integer.toString(ShareVar.filename);
			ImageIcon ii = new ImageIcon(filePath);
			Image image = ii.getImage().getScaledInstance(lblClothImage.getWidth(), lblClothImage.getHeight(), Image.SCALE_SMOOTH);
			
			lblClothImage.setIcon(new ImageIcon(image));
			lblClothImage.setHorizontalAlignment(SwingConstants.CENTER);
			File file = new File(filePath);
			file.delete();

	        
		}
	
	// 조건 검색 항목 결정 
	private void ConditionQuery() {
		int i = cbclothtype.getSelectedIndex();
		String ConditionQueryColumn = "";
		switch (i) {
		case 0:
			ConditionQueryColumn = "모자";
			break;
		case 1:
			ConditionQueryColumn = "상의";
			break;
		case 2:
			ConditionQueryColumn = "하의";
			break;
		case 3:
			ConditionQueryColumn = "원피스";
			break;
		case 4:
			ConditionQueryColumn = "아우터";
			break;
		case 5:
			ConditionQueryColumn = "신발";
			break;
		default:
			break;
		}
		
		TableInit();
		ConditionQueryAction(ConditionQueryColumn);

	}
	
	
	// 조건검색 실행 
	private void ConditionQueryAction(String ConditionQueryColumn) {
		ClothList2Action clothList2Action = new ClothList2Action();
		ArrayList<Bean> beanList = clothList2Action.ConditionList(ConditionQueryColumn);
				
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getClothid());
			String[] qTxt = {temp, beanList.get(index).getClothtype2(), beanList.get(index).getClothname()};
			Outer_Table.addRow(qTxt);
		}
	}
	
	//전체 검색결과를 Table로 
	private void SearchAction(){
		ClothList2Action clothList2Action = new ClothList2Action();
		ArrayList<Bean> beanList = clothList2Action.SelectList();
		
		int listCount = beanList.size();
		
		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(beanList.get(index).getClothid());
			String[] qTxt = {temp, beanList.get(index).getClothtype2(), beanList.get(index).getClothname()};
			Outer_Table.addRow(qTxt);
		}

	}
}

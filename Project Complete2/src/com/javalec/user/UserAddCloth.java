package com.javalec.user;

import java.awt.BorderLayout;		
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.profile.ChangeImageAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class UserAddCloth {

	private JFrame frame;
	private JTextField tfClothname;
	private JLabel lblTitle;
	private JButton btnOK;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	int answerIndex;
	private JLabel ClothData;
	private JButton btnCancel;
	private JLabel lbltype;
	private JComboBox cbClothtype;
	private JButton btnLoadImage;
	private JTextField tfFilePath;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddCloth window = new UserAddCloth();
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
	public UserAddCloth() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 569);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfClothname());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getClothData());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getLbltype());
		frame.getContentPane().add(getCbClothtype());
		frame.getContentPane().add(getBtnLoadImage());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getLblNewLabel());
		frame.setLocationRelativeTo(null);
	}

	public JTextField getTfClothname() {
		if (tfClothname == null) {
			tfClothname = new JTextField();
			tfClothname.setColumns(10);
			tfClothname.setBounds(40, 10, 215, 26);
		}
		return tfClothname;
	}
	private JLabel getClothData() {
		if (ClothData == null) {
			ClothData = new JLabel((Icon) null);
			ClothData.setHorizontalAlignment(SwingConstants.CENTER);
			ClothData.setBounds(6, 90, 426, 298);
		}
		return ClothData;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("이름 :");
			lblTitle.setBounds(6, 15, 47, 16);
		}
		return lblTitle;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClothAdd();
					frame.dispose();
					MyClothList.main(null);
				}
			});
			btnOK.setBounds(136, 465, 81, 29);
		}
		return btnOK;
	}
	
	
	
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyClothList.main(null);
					frame.dispose();
				}
			});
			btnCancel.setBounds(235, 465, 81, 29);
		}
		return btnCancel;
	}
	
	private JLabel getLbltype() {
		if (lbltype == null) {
			lbltype = new JLabel("type :");
			lbltype.setHorizontalAlignment(SwingConstants.CENTER);
			lbltype.setBounds(0, 53, 47, 16);
		}
		return lbltype;
	}

	private JComboBox getCbClothtype() {
		if (cbClothtype == null) {
			cbClothtype = new JComboBox();
			cbClothtype.setModel(new DefaultComboBoxModel(new String[] {"모자", "상의", "하의", "원피스", "아우터", "가방", "신발"}));
			cbClothtype.setBounds(40, 49, 98, 25);
		}
		return cbClothtype;
	}
	private JButton getBtnLoadImage() {
		if (btnLoadImage == null) {
			btnLoadImage = new JButton("이미지 불러오기");
			btnLoadImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnLoadImage.setBounds(160, 428, 121, 23);
		}
		return btnLoadImage;
	}
	
	private void ClothAdd() {
		String clothName=tfClothname.getText().trim();
		String clothType=cbClothtype.getSelectedItem().toString();
		
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserAction userAction=new UserAction();
		boolean aaa=userAction.InsertCloth(clothType, clothName, input);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, tfClothname+" 의 정보가 입력 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
	}
	
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		ClothData.setIcon(new ImageIcon(filePath));
		ClothData.setHorizontalAlignment(SwingConstants.CENTER);
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setEditable(false);
			tfFilePath.setBounds(62, 397, 370, 21);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("파일 경로");
			lblNewLabel.setBounds(6, 400, 57, 15);
		}
		return lblNewLabel;
	}
}

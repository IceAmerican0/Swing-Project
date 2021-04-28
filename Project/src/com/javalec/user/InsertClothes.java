package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javalec.function.DbAction;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class InsertClothes {

	private JFrame frame;

	
	 private Connection conn;
	 private PreparedStatement stmt;
	 private ResultSet rs;
	 
	 BufferedImage bi;
	 String filename =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertClothes window = new InsertClothes();
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
	public InsertClothes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("옷장 등록하기");
		frame.setBounds(100, 100, 368, 427);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getBtnUpload());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getClothname());
}	

	
	 //Images 
    FileInputStream fis;
    private JComboBox comboBox;
    private JLabel lblNewLabel;
    private JTextField tfFilePath;
    private JButton btnOK;
    private JButton btnNewButton_1;
    private JLabel lblImage;
    private JButton btnCancel;
    private JPanel panel;
    private JButton btnUpload;
    private JLabel lblNewLabel_1;
    private JTextField clothname;
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"모자", "상의", "하의", "원피스", "아우터", "신발"}));
			comboBox.setBounds(102, 330, 138, 27);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("종류 :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel.setBounds(40, 334, 50, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setEditable(false);
			tfFilePath.setBounds(37, 244, 182, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("작성");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnOK.setBounds(91, 362, 89, 29);
		}
		return btnOK;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("취소");
			btnNewButton_1.setBounds(182, 334, 89, 29);
		}
		return btnNewButton_1;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setIcon(new ImageIcon("/Users/tj/Documents/Kenny/Temp/null.png"));
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(22, 484, 215, 112);
		}
		return lblImage;
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
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	private JLabel getLblImage_1() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBackground(Color.WHITE);
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblImage;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancel.setBounds(178, 362, 89, 29);
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(22, 6, 317, 226);
			panel.add(getLblImage_1());
		}
		return panel;
	}
	private JButton getBtnUpload() {
		if (btnUpload == null) {
			btnUpload = new JButton("Upload");
			btnUpload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnUpload.setBounds(231, 244, 89, 29);
		}
		return btnUpload;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setBounds(38, 293, 50, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getClothname() {
		if (clothname == null) {
			clothname = new JTextField();
			clothname.setBounds(105, 290, 130, 26);
			clothname.setColumns(10);
		}
		return clothname;
	}
	private void check() {
		String text = "";
		if (tfFilePath.getText().length() == 0) {
			text = "파일을";
		}
		if (clothname.getText().trim().length()==0) {
			text = "이름을";
		} else {
			ConditionQuery();			
		}
		JOptionPane.showMessageDialog(null, text+" 등록해주세요!");
	}
	private void ConditionQuery() {
		int i = comboBox.getSelectedIndex();
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
		ConditionQueryAction(ConditionQueryColumn);
	}
	private void ConditionQueryAction(String selection) {
		DbAction dbaction = new DbAction();
		// Image File
				FileInputStream input = null;
				File file = new File(tfFilePath.getText());
				try {
					input = new FileInputStream(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		boolean aaa = dbaction.InsertCloth(selection, clothname.getText(), input);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "옷 데이터 등록 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
		

	}
}
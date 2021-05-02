package com.javalec.user;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InsertDocument {

	private JFrame frame;
	private JLabel lblImage;
	private JLabel lblTitle;
	private JTextField textField;
	private JLabel lblClothes;
	private JLabel lblTitle_2;
	private JButton btnPull;
	private JButton btnOK;
	private JButton btnCancel;
	private JPanel panel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertDocument window = new InsertDocument();
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
	public InsertDocument() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 511);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblClothes());
		frame.getContentPane().add(getLblTitle_2());
		frame.getContentPane().add(getBtnPull());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getPanel());
		frame.setLocationRelativeTo(null);
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(34, 19, 340, 197);
			// jy3 : 추가 start
			String filePath = Integer.toString(ShareVar.filename); 
			
			ImageIcon ii = new ImageIcon(filePath);
			//Resize image to fit label
			Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);//이미지 저장위치 수정 필수
			
			lblImage.setIcon(new ImageIcon(image));//이미지 저장위치 수정 필수
			File file = new File(filePath);
			file.delete();
			// jy3 : 추가 end
		}
		return lblImage;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("제목");
			lblTitle.setBounds(35, 282, 61, 16);
		}
		return lblTitle;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(34, 300, 185, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblClothes() {
		if (lblClothes == null) {
			lblClothes = new JLabel("내 옷장 가져오기");
			lblClothes.setBounds(34, 228, 126, 16);
		}
		return lblClothes;
	}
	private JLabel getLblTitle_2() {
		if (lblTitle_2 == null) {
			lblTitle_2 = new JLabel("내용");
			lblTitle_2.setBounds(34, 338, 61, 16);
		}
		return lblTitle_2;
	}
	private JButton getBtnPull() {
		if (btnPull == null) {
			btnPull = new JButton("불러오기");
			btnPull.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				MyClothList2.main(null);
				frame.dispose();
				}
			});
			btnPull.setBounds(34, 256, 117, 29);
		}
		return btnPull;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("작성하기");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnOK.setBounds(116, 440, 83, 29);
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
			btnCancel.setBounds(199, 440, 83, 29);
		}
		return btnCancel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(34, 366, 340, 62);
			panel.add(getTextArea());
		}
		return panel;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(20,30);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private void check() {
		if (textArea.getText().trim().length() == 0 || textField.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "빈칸에 정보를 입력해주세요!");
		}
		if (lblImage.getIcon()==null) {
			JOptionPane.showMessageDialog(null, "불러올 사진을 선택해주세요!");
		}else {
			InsertAction();
		}

	}
	private void InsertAction() {
		//정보 입력하기
		
		String title = textField.getText();
		String content = textArea.getText();
		// Image File
		FileInputStream input = null;
		File file = new File(Integer.toString(ShareVar.filename));
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserAction userAction = new UserAction(title, content, 0, ShareVar.nowId, ShareVar.clothid);
		boolean aaa = userAction.InsertAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, ShareVar.nowId+" 님의 정보가 입력 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}
		
	}
	
}

package com.javalec.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UpdateDocument {

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
	private JButton btnDelete;

	/**
	 * 클릭된 값 가져와서 데이터 불러오기
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDocument window = new UpdateDocument();
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
	public UpdateDocument() {
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
		frame.getContentPane().add(getBtnDelete());
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(34, 19, 340, 197);
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
				ReadImage pullImage = new ReadImage();
				pullImage.main(null);
				}
			});
			btnPull.setBounds(34, 256, 117, 29);
		}
		return btnPull;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("수정하기");
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
		//정보 입력하
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.setBounds(284, 440, 69, 29);
		}
		return btnDelete;
	}
}

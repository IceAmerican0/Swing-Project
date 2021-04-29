package com.javalec.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.javalec.function.Bean;
import com.javalec.function.ShareVar;
import com.javalec.with.WithAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.SwingConstants;

public class UpdateNotice {

	private JFrame frame;
	private JTextField tfTitle;
	private JLabel lblNoticeTitle;
	private JPanel panel;
	private JTextArea taContent;
	private JLabel lblNoticePost;
	private JButton btnDelete;
	private JButton btnOK;
	private JButton btnUpdate;
	/**
	 * @wbp.nonvisual location=250,-19
	 */
	private final JLabel label = new JLabel("New label");
	private JLabel lblusername;
	private JTextField tfUsername;
	private JTextField tfAddtime;
	private JLabel lbladdtime;
	private JTextField tfTablePK;
	private JLabel lblseq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateNotice window = new UpdateNotice();
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
	public UpdateNotice() {
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
				SearchAction();
				AdiminCheck();
			}
		});
		frame.setBounds(100, 100, 438, 396);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getLblNoticeTitle());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblNoticePost());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getLblusername());
		frame.getContentPane().add(getTfUsername());
		frame.getContentPane().add(getTfAddtime());
		frame.getContentPane().add(getLbladdtime());
		frame.getContentPane().add(getTfTablePK());
		frame.getContentPane().add(getLblseq());
	}

	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEditable(false);
			tfTitle.setColumns(10);
			tfTitle.setBounds(62, 52, 232, 26);
		}
		return tfTitle;
	}
	private JLabel getLblNoticeTitle() {
		if (lblNoticeTitle == null) {
			lblNoticeTitle = new JLabel("제목 :");
			lblNoticeTitle.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNoticeTitle.setBounds(6, 57, 49, 16);
		}
		return lblNoticeTitle;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 105, 424, 204);
			panel.add(getTaContent());
		}
		return panel;
	}
	private JTextArea getTaContent() {
		if (taContent == null) {
			taContent = new JTextArea(20, 30);
			taContent.setEditable(false);
			taContent.setLineWrap(true);
		}
		return taContent;
	}
	private JLabel getLblNoticePost() {
		if (lblNoticePost == null) {
			lblNoticePost = new JLabel("내용 :");
			lblNoticePost.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNoticePost.setBounds(6, 91, 49, 16);
		}
		return lblNoticePost;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.setVisible(false);
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제할까요?", "EVENT", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						DeleteAction();
					}
				}
			});
			btnDelete.setBounds(257, 321, 81, 29);
		}
		return btnDelete;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnOK.setBounds(177, 321, 81, 29);
		}
		return btnOK;
	}
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정");
			btnUpdate.setVisible(false);
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					check();
				}
			});
			btnUpdate.setBounds(95, 321, 81, 29);
		}
		return btnUpdate;
	}
	private JLabel getLblusername() {
		if (lblusername == null) {
			lblusername = new JLabel("작성자 :");
			lblusername.setHorizontalAlignment(SwingConstants.TRAILING);
			lblusername.setBounds(6, 22, 49, 16);
		}
		return lblusername;
	}
	private JTextField getTfUsername() {
		if (tfUsername == null) {
			tfUsername = new JTextField();
			tfUsername.setEditable(false);
			tfUsername.setColumns(10);
			tfUsername.setBounds(62, 17, 93, 26);
		}
		return tfUsername;
	}
	private JTextField getTfAddtime() {
		if (tfAddtime == null) {
			tfAddtime = new JTextField();
			tfAddtime.setEditable(false);
			tfAddtime.setColumns(10);
			tfAddtime.setBounds(264, 17, 144, 26);
		}
		return tfAddtime;
	}
	private JLabel getLbladdtime() {
		if (lbladdtime == null) {
			lbladdtime = new JLabel("작성날짜 :");
			lbladdtime.setHorizontalAlignment(SwingConstants.TRAILING);
			lbladdtime.setBounds(197, 21, 61, 16);
		}
		return lbladdtime;
	}
	private JTextField getTfTablePK() {
		if (tfTablePK == null) {
			tfTablePK = new JTextField();
			tfTablePK.setEditable(false);
			tfTablePK.setColumns(10);
			tfTablePK.setBounds(367, 52, 42, 26);
		}
		return tfTablePK;
	}
	private JLabel getLblseq() {
		if (lblseq == null) {
			lblseq = new JLabel("seq.");
			lblseq.setHorizontalAlignment(SwingConstants.TRAILING);
			lblseq.setBounds(306, 57, 61, 16);
		}
		return lblseq;
	}
	private void check() {
		if (btnUpdate.getText() == "수정") {
			taContent.setEditable(true);
			tfTitle.setEditable(true);
			btnUpdate.setText("수정완료");
		}else if (btnUpdate.getText() == "수정완료") {
			if (taContent.getText().trim().length() == 0 || tfTitle.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "수정 사항을 다시 확인해주세요!");
			}else {
				int result = JOptionPane.showConfirmDialog(null, "이대로 수정할까요?", "EVENT", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					UpdateAction();
					taContent.setEditable(false);
					tfTitle.setEditable(false);
					btnUpdate.setText("수정");
				
				}
			}
		}

	}
	private void UpdateAction() {
		ShareVar.seqIndex = Integer.parseInt(tfTablePK.getText());
		String title = tfTitle.getText();
		String content = taContent.getText();
		
		AdminAction adminaction = new AdminAction();
		boolean aaa = adminaction.UpdateNotice(title, content);
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "공지사항이 수정 되었습니다!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}

	}
	private void DeleteAction() {
		ShareVar.seqIndex = Integer.parseInt(tfTablePK.getText());
		
		AdminAction adminaction = new AdminAction();
		boolean aaa = adminaction.DeleteDocument();
		if(aaa == true){
			JOptionPane.showMessageDialog(null, "공지사항이 삭제 처리 되었습니다!");                    
		}else{
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}

	}
	private void SearchAction() {
		WithAction withAction = new WithAction(ShareVar.seqIndex);
        Bean bean = withAction.NoticeTableClick();
        
        tfTablePK.setText(Integer.toString(bean.getTablePK()));
        tfUsername.setText(bean.getUsername());
        tfTitle.setText(bean.getTitle());
        taContent.setText(bean.getContent());
        tfAddtime.setText(bean.getAddtime());
       
	}
	private void AdiminCheck() {
		if (ShareVar.admincheck == 1) {
			btnDelete.setVisible(true);
			btnUpdate.setVisible(true);
		}
		if (ShareVar.admincheck == 2) {
		}

	}
	
}

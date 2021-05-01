package test3;

import java.awt.HeadlessException;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void JTableDemo(String title) throws HeadlessException {
		JTable table = new JTable();	
		//DAO를 통해 파일에서 데이터를 불러와 리스트에 저장하였음
		MemberService mbs = new MemberService();
		Object[][] data = mbs.getData();
		//불러온 리스트를 MemberService를 통해 처리하여 Object로 반환하기 
			
		MyTableModel md = new MyTableModel(mbs.returnList());

		table.setModel(md);
		table.setRowHeight(80);
		table.getColumnModel().getColumn(5).setWidth(200);

		md.addTableModelListener(new TableModelListener() {
			@Override
				public void tableChanged(TableModelEvent e) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					String value = (String)table.getValueAt(row,col);
					md.setValueAt(value, row, col);
					System.out.println("변경된 내용 :" + md.getValueAt(row, col));
				}
			});
		
		
		

		
		
		
	}

}

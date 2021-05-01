package test3;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MyTableModel {

	public MyTableModel(List<Member> returnList) {
		// TODO Auto-generated constructor stub
	}

	public void addTableModelListener(TableModelListener tableModelListener) {
		// TODO Auto-generated method stub
		
	}

	public String getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return null;
	}






	public class MyTableModel extends AbstractTableModel {

//   	      이 모델 객체를 JTable에 전달했을 때 
//
//	          이 모델에 포함된 데이터를 JTable 이 잘 이해하여야 한다. 
//
//	          Abstract모델로 테이블을 생성시 자동으로 호출되는 함수들을
//
//	          오버라이딩해서 사용한다.

		List<Member> list;



		public List<Member> getList() {

			return list;

		}



		public void setList(List<Member> list) {

			this.list = list;

		}



		@Override

		public int getColumnCount() {

			return 6;

		}



		@Override

		public int getRowCount() {

			// TODO Auto-generated method stub

			return list.size();

		}



		@Override

		public Object getValueAt(int rowIndex, int columnIndex) {

			Object value = null;

			Member m = list.get(rowIndex);

			if(columnIndex==0) value = m.getNo();

			//기본형이 참조형으로 캐스팅 되는 autoBoxing 현상

			//Wrapper클래스에 의해 가능해짐. 

			else if(columnIndex==1) value = m.getName();

			else if(columnIndex==2) value = m.getId();

			else if(columnIndex==3) value = m.getPassWord();

			else if(columnIndex==4) value = m.getEmail();

			else if(columnIndex==5) value = m.getIco();

			return value;

		}



		@Override

		public Class<?> getColumnClass(int columnIndex) {

			System.out.println(getValueAt(0, columnIndex));

			return this.getValueAt(0, columnIndex).getClass();

			//getClass는 어떤 Object에서나 쓸수있음.

			//String이 반환됨 ㅎ.ㅎ

			//클래스 인스턴스 반환 . 클래스에대한 정보를 가진 클래스 반환 

		}

	//여기는 매개변수 갯수가 하나인 이유가 하나의 컬럼 데이터는 모두 자료형이 같기때문에...

	//Class<instance>를 호출..셀에 체크박스 숫자 이미지 등 다양한 것이 들어갈 수 있다

		

		@Override

		public String getColumnName(int column) {

		String[] arr = new String[]{"번호","이름","아이디","비밀번호","이메일","사진"};

		//0이면정수 1이면 이름 2면 ID 3이면 이메일 

			return arr[column];

		}



		@Override

		public boolean isCellEditable(int rowIndex, int columnIndex) {

			if(columnIndex==0||columnIndex==1||columnIndex==2){

				return false;

				//아이디값은 수정하지 못하게 함. 

			}

			return true;

		}



		@Override

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

			Member m = list.get(rowIndex);

			if(columnIndex==0) m.setNo((String)aValue);

			else if(columnIndex==1) m.setName((String)aValue);

			else if(columnIndex==2) m.setId((String)aValue);

			else if(columnIndex==3) m.setPassWord((String)aValue);

			else if(columnIndex==4) m.setEmail((String)aValue);

		}

	}






	public void setValueAt(String value, int row, int col) {
		// TODO Auto-generated method stub
		
	}




	
	
}

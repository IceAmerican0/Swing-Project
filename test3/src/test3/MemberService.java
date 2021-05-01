package test3;

import java.util.ArrayList;

import java.util.List;

public class MemberService {

	static List<Member> list = new ArrayList<>();

	Object[][] getData(){

		MemberDAO dao = new MemberDAO();

		list = dao.getMember();

		Object[][] arrObj = new Object[list.size()][];

		for(int i=0;i<list.size();i++){

			arrObj[i]= new Object[6];

			arrObj[i][0] = list.get(i).getNo();

			arrObj[i][1] = list.get(i).getName();

			arrObj[i][2] = list.get(i).getId();

			arrObj[i][3] = list.get(i).getPassWord();

			arrObj[i][4] = list.get(i).getEmail();

			arrObj[i][5] = list.get(i).getIco();

		}

		return arrObj;

	}

	List<Member> returnList(){

		return list;

	}


}



package test3;
import javax.swing.ImageIcon;

public class Member {




		private String no;

		private String name;

		private String id;

		private String passWord;

		private String email;

		private ImageIcon ico;
		public Member(String no, String name, String id, String passWord, String email, ImageIcon ico) {

			super();

			this.no = no;

			this.name = name;

			this.id = id;

			this.passWord = passWord;

			this.email = email;

			this.ico = ico;

		}

		public Member() {

			// TODO Auto-generated constructor stub

		}

		public String getNo() {

			return no;

		}

		public void setNo(String no) {

			this.no = no;

		}

		public String getName() {

			return name;

		}

		public void setName(String name) {

			this.name = name;

		}

		public String getId() {

			return id;

		}

		public void setId(String id) {

			this.id = id;

		}

		public String getEmail() {

			return email;

		}

		public void setEmail(String email) {

			this.email = email;

		}

		public String getPassWord() {

			return passWord;

		}

		public void setPassWord(String passWord) {

			this.passWord = passWord;

		}

		public ImageIcon getIco() {

			return ico;

		}

		public void setIco(ImageIcon ico) {

			this.ico = ico;

		}

	}

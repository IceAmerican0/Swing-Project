package test3;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

//public ImageIcon(Image image)
//public ImageIcon(byte[] imageData,
//        String description)
//public ImageIcon(byte[] imageData)


public class MemberDAO {

	
	while((line=br.readLine())!=null) {

		Member m = new Member();

		String[] arr = new String[5];

		String line;
		arr = line.split(" ");

		m.setNo(arr[0]);

		m.setName(arr[1]);

		m.setId(arr[2]);

		m.setPassWord(arr[3]);

		m.setEmail(arr[4]);

		arr[5]="img.png";

		

		BufferedImage bing = ImageIO.read(getClass().getResourceAsStream(arr[5]));

		m.setIco((new ImageIcon((Image)bing)));

		List<Member> mem;
		mem.add(m);
	}



	public List<Member> getMember() {
		// TODO Auto-generated method stub
		return null;
	}

}



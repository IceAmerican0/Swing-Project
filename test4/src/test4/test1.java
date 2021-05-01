package test4;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class test1 extends JFrame {
  static final long serialVersionUID = 0;
  // 1. 라벨, 박스, 패널 등을 private으로 선언    
  private JPanel innerPanel;
  private List<?>[] list;
  private int maxSize; 
  // 2. 초기 설정을 생성자 또는 적당한 위치에서 선언
  public void init(List<?>... list)    {
    // 1칸당 80px
//    System.out.println(list.length); // 숫자 출
    maxSize = list[0].size();
    for(List<?> i : list) {
      if(i.size() > maxSize)  maxSize = i.size();
    }
    this.setSize(848, 341);
    this.setTitle("갤러리로 만들어 보는데 잘 안되네");
    this.setLocationRelativeTo(null);  // 정중앙 위치에 배치
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    innerPanel = new JPanel();
    innerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    innerPanel.setBackground(Color.WHITE);
    getContentPane().add(innerPanel);
    innerPanel.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(6, 6, 836, 307);
    innerPanel.add(scrollPane);
    
    this.list = list;
    this.initComp();
    this.setVisible(true);  // setVisible을 이곳에서 실행              
  }
  /**
   * @wbp.parser.constructor
   */
  public test1(int[] intArr) {
    // To boxed list (int -> Integer)
    List<Integer> tempList =  Arrays.stream( intArr ).boxed().collect( Collectors.toList() );
    init(tempList);
  }
  public test1(int[][] intArr) {
    List<?>[] tempArr = new List<?>[intArr.length];
//    System.out.println(intArr.length); // 숫자 출력
    for(int i = 0; i < tempArr.length; i++) {
      tempArr[i] = Arrays.stream( intArr[i] ).boxed().collect( Collectors.toList() );
    }    
    init(tempArr);
  }
  // Character는 위와 같은 stream을 쓰는 방법이 불가능
  public test1(char[] charArr) {
    List<Character> tempList = new ArrayList<>();
    for(char c : charArr) {
      tempList.add((Character) c);
    }
    init(tempList);
  }
  public test1(char[][] charArr) {
    List<?>[] tempArr = new List<?>[charArr.length];
    for(int i = 0; i < tempArr.length; i++) {
      List<Character> tempList = new ArrayList<>();
      for(char c : charArr[i]) {
        tempList.add((Character) c);
      }
      tempArr[i] = tempList;
    }    
    init(tempArr);
  }
  // 3. 실제 요소들을 배치하는 메소드를 작성
  public void initComp() {
    for(int i = 0; i < list.length; i++) {
      List<?> tempList = (List<?>) list[i];
      /* 요소들을 for문으로 배치하기 */
      for(int j = 0; j < maxSize; j++) {
        JLabel lbl = new JLabel("");
        try {
          lbl.setOpaque(true);  // 이 코드가 있어야 레이블에 색 서식 적용됨
          // 0인 경우엔 공백 처리. 아니면 색칠
          if(tempList.get(j) instanceof Integer 
              && (Integer)tempList.get(j) == 0) {
            lbl.setBackground(Color.WHITE);
          } else {
            lbl.setText("" + tempList.get(j)  + "");
            lbl.setBackground(Color.ORANGE);
          }
          // 가운데 정렬
          lbl.setHorizontalAlignment(JLabel.CENTER);
          lbl.setFont(new Font("Impact", Font.PLAIN, 22));
          lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
          innerPanel.add(lbl);
        } catch(Exception e) {
          // 이 메소드는 다차원 배열의 각 행의 
          // 길이가 뒤죽박죽일 때 예외가 나는 점을 이용해
          // 예외가 났다면 빈 공간으로 간주하고 빈칸을 그리는 부분
          lbl.setOpaque(true);
          lbl.setBackground(Color.LIGHT_GRAY);
          lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
          innerPanel.add(lbl);
          continue;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[][] example = {{1, 2, 3, 4, 5},
        {10, 20, 30, 40},
        {1, 10, 100,1000,10000},
        {1},
        {2},
        {3}};
    new test1(example);
  }
}
package com.javalec.tab;


import java.awt.*;
import javax.swing.*;

import com.javalec.user.ReadImage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test2 {
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JPanel container = new ScrollablePanel();
                container.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
//                container.setBounds(50,100,300,200);
                for( int i = 0; i < 30; ++i )   // i만큼 라벨 생성 - 해당 부분을 이미지 데이터 수 만큼으로 변환하여야 함
                {
                    JPanel panel = new JPanel();
                    panel.setBorder(BorderFactory.createLineBorder(Color.RED));
                    panel.setPreferredSize(new Dimension(200, 200));//panel 사이즈 = label 사이즈를 항상 맞출것
                    panel.setLayout(null);
                    
                    JLabel Label = new JLabel("" + i); 
                    Label.addMouseListener(new MouseAdapter() {
                    	@Override
                    	public void mouseClicked(MouseEvent e) {
            				ReadImage.main(null);
                    	}
                    });
                    Label.setHorizontalAlignment(SwingConstants.CENTER);
                    Label.setBounds(0, 0, 200, 200); //panel 사이즈 = label 사이즈를 항상 맞출것
                    panel.add(Label);

                    container.add(panel);
                }

                JScrollPane scroll = new JScrollPane(container);
                scroll.setBounds(0, 0, 500, 478);

                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                JFrame frame = new JFrame("왜 안되는거지?");
                frame.setMinimumSize(new Dimension(900, 500)); // 갤러리 화면 사이즈 
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    
//                f.getContentPane().setLayout(null);
                frame.getContentPane().add(scroll);
                frame.pack();
                frame.setSize(257, 26);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

class ScrollablePanel extends JPanel implements Scrollable
{
    public Dimension getPreferredSize()
    {
        return getPreferredScrollableViewportSize();
    }

    public Dimension getPreferredScrollableViewportSize()
    {
        if( getParent() == null )
            return getSize();
        Dimension d = getParent().getSize();
        int c = (int)Math.floor((d.width - getInsets().left - getInsets().right) / 100.0);
        if( c == 0 )
            return d;
        int r = 20 / c;             // 이건 무슨뜻인지잘 모르겠음.
        if( r * c < 20 )			// 이건 무슨뜻인지잘 모르겠음.
            ++r;
        return new Dimension(c * 50, r * 600);//r 은 사이즈 500이상 할것
    }

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 50;
    }

    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return 10;
    }

    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }

    public boolean getScrollableTracksViewportWidth()
    {
        return getParent() != null ? getParent().getSize().width > getPreferredSize().width : true;
    }
}
package test4;

import java.awt.*;
import javax.swing.*;
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
                container.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
//                container.setLayout(null);
                container.setBounds(50,100,300,200);
                for( int i = 0; i < 30; ++i )
                {
                    JPanel p = new JPanel();
                    p.setBorder(BorderFactory.createLineBorder(Color.RED));
                    p.setPreferredSize(new Dimension(50, 50));
                    p.setLayout(null);
//                    p.setLayout(null);
//                    p.setBounds(50,100,300,200);
                    
                    
//                    JLabel label = new JLabel("" + i);
//                    label.setBounds(21, 6, 8, 16);
//                    p.add(label);
                    
                    
                    JLabel lblLabel = new JLabel("" + i);
                    lblLabel.addMouseListener(new MouseAdapter() {
                    	@Override
                    	public void mouseClicked(MouseEvent e) {
                    		
                    	}
                    });
                    lblLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    lblLabel.setBounds(0, 0, 50, 50);
                    p.add(lblLabel);

                    container.add(p);
                }

                JScrollPane scroll = new JScrollPane(container);
                scroll.setBounds(0, 0, 500, 478);
//                scroll.setMinimumSize(new Dimension(500, 500));
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                JFrame f = new JFrame("Test");
                f.setMinimumSize(new Dimension(500, 500));
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    
//                f.getContentPane().setLayout(null);
                f.getContentPane().add(scroll);                    
                f.pack();
                f.setSize(257, 26);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
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
        int c = (int)Math.floor((d.width - getInsets().left - getInsets().right) / 50.0);
        if( c == 0 )
            return d;
        int r = 20 / c;
        if( r * c < 20 )
            ++r;
        return new Dimension(c * 50, r * 50);
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
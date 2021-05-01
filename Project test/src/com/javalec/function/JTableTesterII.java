package com.javalec.function;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableTesterII extends JFrame {
 private final Object [] colNames = {"ChkBox","이름","나이","성별"};
 private Object [][] datas = {{false,"홍길동","20","남"},{true,"김말자","18","여"}};
 public JTableTesterII(){
  super("JTable Tester");  
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JPanel panel = new JPanel(new BorderLayout());
   DefaultTableModel dtm = new DefaultTableModel(datas, colNames);
   JTable table = new JTable(dtm);
   table.getColumn("ChkBox").setCellRenderer(dcr);
   JCheckBox box = new JCheckBox();
   box.setHorizontalAlignment(JLabel.CENTER);
   table.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
   JScrollPane jsp = new JScrollPane(table);
   panel.add(jsp,"Center");
  setContentPane(panel);
  pack();
  setVisible(true);
 }
 
 public static void main(String[] args) {  
  new JTableTesterII();
 }
 DefaultTableCellRenderer dcr = new DefaultTableCellRenderer()
 {
  public Component getTableCellRendererComponent  // 셀렌더러
   (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
  {
   JCheckBox box= new JCheckBox();
   box.setSelected(((Boolean)value).booleanValue());  
   box.setHorizontalAlignment(JLabel.CENTER);
   return box;
  }
 };
}

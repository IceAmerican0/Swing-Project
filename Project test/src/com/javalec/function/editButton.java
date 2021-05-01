package com.javalec.function;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class editButton extends DefaultCellEditor 
{

    protected JButton btn;
    private String label;
    private boolean isPushed;

    public editButton(JCheckBox checkBox)
    {
        super(checkBox);
        btn = new JButton();
        btn.setOpaque(true);
        btn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
        	btn.setForeground(table.getSelectionForeground());
        	btn.setBackground(table.getSelectionBackground());
        } 
        else 
        {
        	btn.setForeground(table.getForeground());
        	btn.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        btn.setText(label);
        isPushed = true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(btn, label + " > Berhasil <");
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

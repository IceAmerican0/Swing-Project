package com.javalec.function;
import java.awt.EventQueue;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;;

@SuppressWarnings("serial")
public class frameButtonJTable extends JFrame 
{

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel tabelModel;
	private JLabel lblWall;
	private JLabel lblIcon;
	private JLabel lblIcon2;
	
	/**
	 * Create the frame.
	 */
	public frameButtonJTable() 
	{
		super("JButton Inside JTable");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 36, 428, 212);
		contentPane.add(scrollPane);
		
		tabelModel = new DefaultTableModel();
		tabelModel.setDataVector(new Object[][] { {"Resa","Yogya","Simpan" },{"Ayu","Jakarta","Simpan" },{"Candra","Yogya","Simpan" },{"Dita","Jakarta","Simpan" } }, new Object[] { "Nama", "Alamat", "Tambah Data" });
		table = new JTable(tabelModel);
		table.getColumn("Tambah Data").setCellRenderer(new ButtonRender());
		table.getColumn("Tambah Data").setCellEditor(new editButton(new JCheckBox()));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());

        table.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		lblIcon = new JLabel("New label");
		lblIcon.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/ButtonJTable Img/icon.png"));
		lblIcon.setBounds(490, 89, 138, 138);
		contentPane.add(lblIcon);
		
		lblIcon2 = new JLabel("");
		lblIcon2.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/ButtonJTable Img/pencil.png"));
		lblIcon2.setBounds(12, 260, 108, 85);
		contentPane.add(lblIcon2);
		
		lblWall = new JLabel("");
		lblWall.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/ButtonJTable Img/wall.png"));
		lblWall.setBounds(0, -11, 645, 368);
		contentPane.add(lblWall);
		setLocationRelativeTo(null);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
					frameButtonJTable frame = new frameButtonJTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


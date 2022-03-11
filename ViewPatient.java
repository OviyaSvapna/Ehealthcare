package administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

public class ViewPatient extends JFrame {
	JFrame f1;
	JTable t1;
	JButton b1,book;
	Font f;

	public ViewPatient() 
    {
		f = new Font("Serif",Font.BOLD, 20);
		
		t1 = new JTable();
		b1 = new JButton("Back");
	
		t1.setForeground(Color.WHITE);
		b1.setForeground(Color.WHITE);
		
		b1.setBackground(new Color(160, 182, 45));
		
		b1.setBounds(100,630,100,40);
        t1.setBounds(200,100,1000,500);
 
		b1.setFont(f);
		
		setTitle("View Hospital");
		
		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminInterface();

			}

		});

		Object[] column = { "Patient_name","Age","Gender","Address","phno","blood_grp","E_mail"};
		DefaultTableModel model = new DefaultTableModel();
		JScrollPane sp = new JScrollPane(t1);

		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.add(t1);
		background.add(b1);
		this.add(background);
		this.setSize(1980, 1080);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		model.setColumnIdentifiers(column);
		t1.setModel(model);

		t1.setBackground(new Color(0, 0, 0, 80));
		t1.setOpaque(true);
		t1.setRowHeight(30);
		t1.setEnabled(false);

		t1.setAutoCreateRowSorter(true);
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		TableColumn col6=t1.getColumnModel().getColumn(6);
		col6.setPreferredWidth(200);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
			String sql = "select Patient_name,Age,Gender,Address,phno,blood_grp,E_mail from Patient_Details";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			t1.setModel(DbUtils.resultSetToTableModel(rs));
			t1.repaint();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String arg[]) {
		new ViewPatient();
	}
}


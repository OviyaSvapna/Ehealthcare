package doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ViewAppointment extends JFrame  {
	JFrame f1;
	JTable t1;
	JButton b1,book,show;
	Font f;
	JLabel lemail;
	JTextField email;

	public ViewAppointment() 
    {
		f = new Font("Serif",Font.BOLD, 20);
		
		t1 = new JTable();
		b1 = new JButton("Back");
		show = new JButton("show");
		email=new JTextField(); 
	    lemail= new JLabel("E-mail");
	    book= new JButton("Confirm");
	
		t1.setForeground(Color.WHITE);
		b1.setForeground(Color.WHITE);
		show.setForeground(Color.WHITE);
		book.setForeground(Color.WHITE);
		
		b1.setBackground(new Color(160, 182, 45));
		show.setBackground(new Color(160, 182, 45));
		book.setBackground(new Color(160, 182, 45));
		
		email.setBounds(200,50,100,40);
		show.setBounds(350,50,100,40);
	    lemail.setBounds(100,50,200,40);
		b1.setBounds(100,630,100,40);
        t1.setBounds(200,100,1000,500);
    	book.setBounds(1100,650,140,40);
 
		b1.setFont(f);
		email.setFont(f);
	    lemail.setFont(f);
	    show.setFont(f);
	    book.setFont(f);
	   
		setTitle("View Appointment");

		b1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				new AfterLogin();
				dispose();

			}

		});
		book.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				new DocAppointment();
				dispose();
			}

		});
		
	    Object[] column = { "Name", "Specialist", "Fees", "Timing", "E-mail", "phone", "Qualification",book };
		DefaultTableModel model = new DefaultTableModel();
		JScrollPane sp = new JScrollPane(t1);

		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.add(t1);
		background.add(b1);
		background.add(email);
		background.add(lemail);
		background.add(show);
		background.add(book);
		background.repaint();
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
		
		
		show.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String Email=email.getText();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
					String sql = "select * from Appointment_Details where  docmail='" + Email +"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					t1.setModel(DbUtils.resultSetToTableModel(rs));
					repaint();

				} catch (Exception exp) {
					System.out.println(exp);
				}


			}

		});
		
		
	}

	public static void main(String arg[]) {
		new ViewAppointment();
	}


	
}

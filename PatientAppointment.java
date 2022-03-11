package patient;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import doctor.MailRegistration2;
import administrator.*;

public class PatientAppointment extends JFrame implements ActionListener {
	JLabel Reason, Time, head, Patient_name, docmail, patmail, emailerror,emailerror1;
	JTextField txtpatient, txtdocmail, txtpatmail;
	JComboBox Slottime;
	Font f1, headfont, f2, font;
	JButton book,back;
	JTextArea txtreason;

	PatientAppointment() {

		f1 = new Font("Serif", Font.BOLD, 25);
		f2 = new Font("Serif", Font.BOLD, 20);
		headfont = new Font("Serif", Font.BOLD, 30);

		JPanel heading = new JPanel();
		heading.setLayout(null);
		heading.setBackground(new Color(0, 0, 0, 80));
		heading.setBounds(0, 0, 1920, 100);

		head = new JLabel("BOOK APPOINTMENT");
		head.setBounds(550, 50, 400, 50);
		head.setForeground(Color.WHITE);
		head.setFont(headfont);
		heading.add(head);

		JPanel BookAppointment = new JPanel();
		BookAppointment.setLayout(null);
		BookAppointment.setBounds(400, 200, 570, 400);
		BookAppointment.setBackground(new Color(0, 0, 0, 80));

		head = new JLabel("Book Appointment");
		Reason = new JLabel("Reason");
		Time = new JLabel("Time");
		Patient_name = new JLabel("Name");
		docmail = new JLabel("Doctor's email");
		patmail = new JLabel("Patient's email");

		txtreason = new JTextArea();
		txtpatient = new JTextField();
		txtdocmail = new JTextField();
		txtpatmail = new JTextField();

		book = new JButton("Book");
		back = new JButton("Back");

		Slottime = new JComboBox();

		Slottime.addItem("");
		Slottime.addItem("09:00AM");
		Slottime.addItem("10:00AM");
		Slottime.addItem("11:00AM");
		Slottime.addItem("12:00PM");
		Slottime.addItem("04:00PM");
		Slottime.addItem("05:00PM");
		Slottime.addItem("06:00PM");
		Slottime.addItem("08:00PM");
		Slottime.addItem("09:00PM");

		Reason.setFont(f1);
		Time.setFont(f1);
		Slottime.setFont(f2);
		txtreason.setFont(f1);
		book.setFont(f1);
		back.setFont(f2);
		txtpatient.setFont(f2);
		Patient_name.setFont(f1);
		docmail.setFont(f1);
		patmail.setFont(f1);
		txtdocmail.setFont(f2);
		txtpatmail.setFont(f2);

		emailerror = new JLabel();
		font = new Font("Serif", Font.BOLD, 14);
		emailerror.setFont(font);
		emailerror.setForeground(Color.RED);
		
		//back.setBackground(new Color(160, 182, 45));
		
		emailerror1 = new JLabel();
		font = new Font("Serif", Font.BOLD, 14);
		emailerror1.setFont(font);
		emailerror1.setForeground(Color.RED);

		docmail.setBounds(50, 50, 200, 30);
		patmail.setBounds(50, 100, 200, 30);
		Patient_name.setBounds(50, 150, 200, 30);
		Reason.setBounds(50, 200, 200, 30);
		Time.setBounds(50, 280, 200, 30);

		txtdocmail.setBounds(275, 50, 250, 30);
		emailerror.setBounds(275, 70, 250, 30);
		txtpatmail.setBounds(275, 100, 250, 30);
		emailerror1.setBounds(275, 120, 250, 30);
		txtpatient.setBounds(275, 150, 250, 30);
		txtreason.setBounds(275, 200, 250, 70);
		Slottime.setBounds(275, 280, 250, 30);

		book.setBounds(350, 350, 100, 30);
		back.setBounds(100,630,100,40);

		book.setBackground(new Color(20, 110, 180));
		back.setBackground(new Color(20, 110, 180));

		docmail.setForeground(Color.WHITE);
		patmail.setForeground(Color.WHITE);
		Reason.setForeground(Color.WHITE);
		Time.setForeground(Color.WHITE);
		book.setForeground(Color.WHITE);
		back.setForeground(Color.WHITE);
		Patient_name.setForeground(Color.WHITE);

		book.addActionListener(this);
		back.addActionListener(this);
		

		txtdocmail.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String mail = txtdocmail.getText();
				if (Pattern.matches("^(.+)@(.+)$", mail)) {
					emailerror.setVisible(false);

				} else {
					emailerror.setText("Enter the valid email id");
					emailerror.setVisible(true);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});
		txtpatmail.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String mail = txtpatmail.getText();
				if (Pattern.matches("^(.+)@(.+)$", mail)) {
					emailerror1.setVisible(false);

				} else {
					emailerror1.setText("Enter the valid email id");
					emailerror1.setVisible(true);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});


		ImageIcon background_image2 = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg3.jpg");
		Image img = background_image2.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image2 = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image2, JLabel.CENTER);

		BookAppointment.add(Reason);
		BookAppointment.add(Time);
		BookAppointment.add(Slottime);
		BookAppointment.add(txtreason);
		BookAppointment.add(Patient_name);
		BookAppointment.add(txtpatient);
		BookAppointment.add(docmail);
		BookAppointment.add(patmail);
		BookAppointment.add(txtdocmail);
		BookAppointment.add(txtpatmail);
		BookAppointment.add(book);
		BookAppointment.add(emailerror);

		background.add(heading);
		background.add(BookAppointment);
		background.add(back);
		background.setBounds(0, 0, 1920, 1080);
		add(background);

		setTitle("Appointment Booking");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj_source = e.getSource();
		if (obj_source == book) {
			String name = txtpatient.getText();
			String docmail = txtdocmail.getText();
			String patmail = txtpatmail.getText();
			String reason = txtreason.getText();
			String time = Slottime.getSelectedItem().toString();
			
	
			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dbproject",
						"skcet");
				Statement stmt = con.createStatement();
				String query = "insert into Appointment_Details values('" + name + "','" + docmail + "','" + patmail
						+ "','" + reason + "','" + time + "')";

				stmt.executeUpdate(query);
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "Registration Success!");
			
				new PatientInterface();
				// dispose();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.toString());
			}
			MailRegistration2 mr = new MailRegistration2();
			mr.Patmsg(docmail, patmail, reason, name, time);
			new PatientInterface();
			dispose();

		}
		if(obj_source == back){
			new PatientInterface();
			dispose();
		}
	}

	public static void main(String arg[]) {
		new PatientAppointment();
	}

}
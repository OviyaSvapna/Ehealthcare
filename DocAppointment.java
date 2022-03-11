
package doctor;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import administrator.*;

public class DocAppointment extends JFrame implements ActionListener {
	JLabel Patient_mail, head, Time,emailerror;
	JTextField txtpatient, txttime;

	Font f1, headfont,font,f2;
	JButton accept, reject,back;

	DocAppointment() {
		f1 = new Font("Serif", Font.BOLD, 25);
		f2 = new Font("Serif", Font.BOLD, 20);
		headfont = new Font("Serif", Font.BOLD, 30);
		font= new Font("Serif", Font.BOLD, 14);

		JPanel heading = new JPanel();
		heading.setLayout(null);
		heading.setBackground(new Color(0, 0, 0, 80));
		heading.setBounds(0, 0, 1920, 100);

		head = new JLabel("CONFIRM APPOINTMENT");
		head.setBounds(540, 50, 400, 50);
		head.setForeground(Color.WHITE);
		head.setFont(headfont);

		heading.add(head);

		JPanel BookAppointment = new JPanel();
		BookAppointment.setLayout(null);
		BookAppointment.setBounds(450, 250, 500, 300);
		BookAppointment.setBackground(new Color(0, 0, 0, 80));

		accept = new JButton("Accept");
		accept.setFont(f1);
		reject = new JButton("Reject");
		reject.setFont(f1);

		txtpatient = new JTextField();
		txtpatient.setFont(f2);
		txttime = new JTextField();
		txttime.setFont(f2);

		Patient_mail = new JLabel("Patient email");
		emailerror= new JLabel();
		Patient_mail.setFont(f1);
		Time = new JLabel("Appointment Time");
		Time.setFont(f1);
		emailerror.setFont(font);
		
		back = new JButton("Back");
		back.setBounds(100,630,100,40);
		back.setBackground(new Color(20, 110, 180));
		back.addActionListener(this);
		back.setFont(f1);
		
		Patient_mail.setForeground(Color.WHITE);
		Time.setForeground(Color.WHITE); 
		back.setForeground(Color.WHITE);
		emailerror.setForeground(Color.RED);

		txtpatient.setBounds(250, 50, 200, 30);
		emailerror.setBounds(250, 70, 200, 30);
		txttime.setBounds(250, 100, 200, 30);
		Patient_mail.setBounds(90, 50, 200, 30);
		Time.setBounds(25, 100, 220, 30);
		accept.setBounds(90, 200, 130, 30);
		reject.setBounds(300, 200, 130, 30);

		accept.setBackground(new Color(20, 110, 180));
		reject.setBackground(new Color(20, 110, 180));

		accept.setForeground(Color.WHITE);
		reject.setForeground(Color.WHITE);

		accept.addActionListener(this);
		
		txtpatient.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String mail = txtpatient.getText();
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

		ImageIcon background_image2 = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg3.jpg");
		Image img = background_image2.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image2 = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image2, JLabel.CENTER);

		BookAppointment.add(txtpatient);
		BookAppointment.add(emailerror);
		BookAppointment.add(accept);
		BookAppointment.add(reject);
		BookAppointment.add(Patient_mail);
		BookAppointment.add(Time);
		BookAppointment.add(txttime);

		background.add(heading);
		background.add(BookAppointment);
		background.add(back);
		background.setBounds(0, 0, 1920, 1080);
		this.add(background);

		this.setTitle("Appointment Confirmation");
		this.setSize(1920, 1080);
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		reject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mail;
				mail = txtpatient.getText();
				MailRegistration2 b = new MailRegistration2();
				b.Reject(mail);
				dispose();

			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		Object obj_source = e.getSource();
		String mail, s1;

		mail = txtpatient.getText();
		s1 = txttime.getText();

		if (obj_source == accept) {
			MailRegistration2 a = new MailRegistration2();
			a.Appointment(mail, s1);
			//new ViewAppointment();
			dispose();
		} else {
			MailRegistration2 b = new MailRegistration2();
			b.Reject(mail);
			//new ViewAppointment();
			dispose();
		}
		if(obj_source == back)
		{
			//new ViewAppointment();
			dispose();
		}
	}

	public static void main(String arg[]) {
		new DocAppointment();
	}
}
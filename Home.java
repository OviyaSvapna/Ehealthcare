package administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import doctor.DoctorSignin;
import hospital.HospitalSignin;
import patient.PatientSignin;

/*public class Home extends JFrame implements ActionListener 
{
	JButton Admin, Hospital, Doctor, Patient;
	Font font, font1;
    JLabel abth, abt, abt1, abt2, abt3, abt4, abt5;

	public Home() 
	{
		font = new Font("Serif", Font.BOLD, 20);
		font1 = new Font("Serif", Font.BOLD, 30);
				
		JPanel MainPage = new JPanel();
		MainPage.setLayout(null);
		MainPage.setBackground(new Color(0, 0, 0,0));
		MainPage.setBounds(0, 0, 1920, 1080);

		Admin = new JButton("Admin");
		Admin.setFont(font);
		Admin.setBounds(300, 50, 200, 50);
		Admin.setForeground(Color.WHITE);
		Admin.setBackground(new Color(20, 110, 180));
		MainPage.add(Admin);

		Hospital = new JButton("Hospital");
		Hospital.setFont(font);
		Hospital.setBounds(550, 50, 200, 50);
		Hospital.setForeground(Color.WHITE);
		Hospital.setBackground(new Color(20, 110, 180));
		MainPage.add(Hospital);

		Doctor = new JButton("Doctor");
		Doctor.setFont(font);
		Doctor.setBounds(800, 50, 200, 50);
		Doctor.setForeground(Color.WHITE);
		Doctor.setBackground(new Color(20, 110, 180));
		MainPage.add(Doctor);

		Patient = new JButton("Patient");
		Patient.setFont(font);
		Patient.setBounds(1050, 50, 200, 50);
		Patient.setForeground(Color.WHITE);
		Patient.setBackground(new Color(20, 110, 180));
		MainPage.add(Patient);

		Patient.addActionListener(this);
		Hospital.addActionListener(this);
		Admin.addActionListener(this);
		Doctor.addActionListener(this);
		
		JPanel about = new JPanel();
		about.setLayout(null);
		about.setBounds(330,200,700,400);
		about.setBackground(new Color(0,0,0,40));

		// heading
		abth = new JLabel("About:");
		abt = new JLabel("eHealth management consists of using different tools and principles in");
		abt1 = new JLabel("information and communication. Technology to improve health care in");
		abt2 = new JLabel("the local and regional areas in the terms of a electrical health care tools.");
		abt3 = new JLabel("It has features like getting vital information of patients so that a doctor");
		abt4 = new JLabel("can help a patient remotely,feature of booking online appointments and");
		abt5 = new JLabel("avlability of bed from the hospital and will be handeled by Admin.");
		
		abth.setBounds(50,50,550, 40);
		abt.setBounds(50,75, 650,200);
		abt1.setBounds(50,100, 650, 200);
		abt2.setBounds(50,125, 650, 200);
		abt3.setBounds(50,150, 650, 200);
		abt4.setBounds(50,175, 650, 200);
		abt5.setBounds(50,200, 650, 200);

		abth.setForeground(Color.white);
		abth.setFont(font1);
		abt.setFont(font);
		abt1.setFont(font);
		abt2.setFont(font);
		abt3.setFont(font);
		abt4.setFont(font);
		abt5.setFont(font);
		
		about.add(abth);
		about.add(abt);
		about.add(abt1);
		about.add(abt2);
		about.add(abt3);
		about.add(abt4);
		about.add(abt5);
	
		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg4.jfif");
        Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

     	background.add(MainPage);
		background.add(about);
		background.setBounds(0, 0, 1920, 1080);
		add(background);
		
		setTitle("Home");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	

	}

	public void actionPerformed(ActionEvent e) {
	
		Object obj_source = e.getSource();

		if (obj_source == Hospital) {
			dispose();
			HospitalSignin obj = new HospitalSignin();

		}
		if (obj_source == Admin) {
			dispose();
			AdminLogin obj = new AdminLogin();

		}
		if (obj_source == Patient) {
			dispose();
			PatientSignin obj = new PatientSignin();

		}
		if (obj_source == Doctor) {
			dispose();
			DoctorSignin obj = new DoctorSignin();

		}

	}

	public static void main(String[] args) 
	{
		new Home();
	}

}*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import doctor.DoctorSignin;
//import hospital.HospitalSignin;
import patient.PatientSignin;

public class Home extends JFrame implements ActionListener 
{
	JButton Admin, Hospital, Doctor, Patient;
	Font font, font1, font2;
	JLabel abth, abt, abt1, abt2, abt3, abt4, abt5;

	public Home() {

		font = new Font("Serif", Font.BOLD, 20);
		font1 = new Font("Serif", Font.BOLD, 30);
		font2 = new Font("Serif", Font.BOLD, 50);

		JPanel MainPage = new JPanel();
		MainPage.setLayout(null);
		MainPage.setBounds(0, 0, 1920, 200);
		MainPage.setBackground(new Color(0, 0, 0, 60));

		JLabel Heading = new JLabel("E-Healthcare Management");
		Heading.setFont(font2);
		Heading.setForeground(Color.WHITE);
		Heading.setBounds(80, 0, 750, 180);
		MainPage.add(Heading);

		Admin = new JButton("Admin");
		Admin.setFont(font);
		Admin.setBounds(750, 80,120, 50);
		Admin.setForeground(Color.WHITE);
		Admin.setBackground(new Color(20, 110, 180));
		MainPage.add(Admin);

		Hospital = new JButton("Hospital");
		Hospital.setFont(font);
		Hospital.setBounds(900, 80, 120, 50);
		Hospital.setForeground(Color.WHITE);
		Hospital.setBackground(new Color(20, 110, 180));
		MainPage.add(Hospital);

		Doctor = new JButton("Doctor");
		Doctor.setFont(font);
		Doctor.setBounds(1050, 80, 120, 50);
		Doctor.setForeground(Color.WHITE);
		Doctor.setBackground(new Color(20, 110, 180));
		MainPage.add(Doctor);

		Patient = new JButton("Patient");
		Patient.setFont(font);
		Patient.setBounds(1200, 80, 120, 50);
		Patient.setForeground(Color.WHITE);
		Patient.setBackground(new Color(20, 110, 180));
		MainPage.add(Patient);

		Patient.addActionListener(this);
		Hospital.addActionListener(this);
		Admin.addActionListener(this);
		Doctor.addActionListener(this);

		JPanel about = new JPanel();
		about.setLayout(null);
		about.setBounds(300, 250,700, 400);
		about.setBackground(new Color(0, 0, 0, 60));

        // heading
		abth = new JLabel("About:");
		abt = new JLabel("E-Health management consists of using different tools and principles in");
		abt1 = new JLabel("information and communication. Technology to improve health care in");
		abt2 = new JLabel("the local and regional areas in the terms of a electrical health care tools.");
		abt3 = new JLabel("It has features like getting vital information of patients so that a doctor");
		abt4 = new JLabel("can help a patient remotely,feature of booking online appointments and");
		abt5 = new JLabel("avlability of bed from the hospital and will be handeled by Admin.");

		abth.setBounds(50, 50, 550, 40);
		abt.setBounds(50, 75, 650, 200);
		abt1.setBounds(50, 100, 650, 200);
		abt2.setBounds(50, 125, 650, 200);
		abt3.setBounds(50, 150, 650, 200);
		abt4.setBounds(50, 175, 650, 200);
		abt5.setBounds(50, 200, 650, 200);

		abth.setForeground(Color.white);
		abt.setForeground(Color.BLACK);
		abt1.setForeground(Color.BLACK);
		abt2.setForeground(Color.BLACK);
		abt3.setForeground(Color.BLACK);
		abt4.setForeground(Color.BLACK);
		abt5.setForeground(Color.BLACK);
		
		
		abth.setFont(font1);
		abt.setFont(font);
		abt1.setFont(font);
		abt2.setFont(font);
		abt3.setFont(font);
		abt4.setFont(font);
		abt5.setFont(font);

		about.add(abth);
		about.add(abt);
		about.add(abt1);
		about.add(abt2);
		about.add(abt3);
		about.add(abt4);
		about.add(abt5);


		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg4.jfif");

		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.setBounds(0, 0, 1920, 1080);

		background.add(Patient);
		background.add(Hospital);
		background.add(Admin);
		background.add(Doctor);
		background.add(Heading);
		

		background.add(about);
		background.add(MainPage);
		
		add(background);
		

		setTitle("Home");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {

		Object obj_source = e.getSource();

		if (obj_source == Hospital) {
			HospitalSignin obj = new HospitalSignin();
			dispose();

		}
		if (obj_source == Admin) {
			AdminLogin obj = new AdminLogin();
			dispose();
		}
		if (obj_source == Patient) {
			PatientSignin obj = new PatientSignin();
			dispose();
		}
		if (obj_source == Doctor) {
			DoctorSignin obj = new DoctorSignin();
			dispose();
		}

	}

	public static void main(String[] args) {
		new Home();
	}

}

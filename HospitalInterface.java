package hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import administrator.Home;


public class HospitalInterface extends JFrame implements ActionListener {
	JButton AddHospital, UpdateHospital, ViewHospital, logout;
	Font font, font1;
	JPanel heading, MainPage;
	JLabel Welcome_msg;
	ImageIcon img;

	HospitalInterface() {
		font = new Font("Serif", Font.BOLD, 20);
		font1 = new Font("Serif", Font.BOLD, 30);

		heading = new JPanel();
		heading.setLayout(null);
		heading.setBackground(new Color(0, 0, 0, 80));
		heading.setBounds(0, 0, 1920, 100);

		Welcome_msg = new JLabel("HOSPITAL HOME");
		Welcome_msg.setBounds(600, 50, 400, 50);
		Welcome_msg.setForeground(Color.WHITE);
		Welcome_msg.setFont(font1);
		heading.add(Welcome_msg);

		logout = new JButton("Log out");
		logout.setFont(font);
		logout.setBounds(1200, 30, 100, 50);
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(20, 110, 180));
		heading.add(logout);

		MainPage = new JPanel();
		MainPage.setLayout(null);
		MainPage.setSize(400, 350);
		MainPage.setBounds(450, 250, 550, 400);
		MainPage.setBackground(new Color(0, 0, 0,80));

		AddHospital = new JButton("Add Hospital");
		AddHospital.setFont(font);
		AddHospital.setBounds(50, 50, 450, 50);
		AddHospital.setForeground(Color.WHITE);
		AddHospital.setBackground(new Color(20, 110, 180));
		MainPage.add(AddHospital);

		UpdateHospital = new JButton("Update Hospital");
		UpdateHospital.setFont(font);
		UpdateHospital.setBounds(50, 150, 450, 50);
		UpdateHospital.setForeground(Color.WHITE);
		UpdateHospital.setBackground(new Color(20, 110, 180));
		MainPage.add(UpdateHospital);

		ViewHospital = new JButton("View Hospital");
		ViewHospital.setFont(font);
		ViewHospital.setBounds(50, 250, 450, 50);
		ViewHospital.setForeground(Color.WHITE);
		ViewHospital.setBackground(new Color(20, 110, 180));
		MainPage.add(ViewHospital);

		AddHospital.addActionListener(this);
		UpdateHospital.addActionListener(this);
		ViewHospital.addActionListener(this);
		logout.addActionListener(this);

		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg2.jpg");

		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.add(MainPage);
		background.add(heading);
		background.setBounds(0, 0, 1920, 1080);

		setTitle("Hospital Home page");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(background);
	}

	public void actionPerformed(ActionEvent e) {

		Object obj_source = e.getSource();

		if (obj_source == AddHospital) {
			new AddHospital();
			dispose();

		}
		if (obj_source == ViewHospital) {
			new ViewHospital();
			dispose();

		}
		if (obj_source == UpdateHospital) {
			 new UpdateHospital();
			 dispose();

		}
		if (obj_source == logout) {
			new Home();
			dispose();

		}

	}
	public static void main(String[] args) {
		new HospitalInterface();
	}

}

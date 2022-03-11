package administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AdminInterface extends JFrame implements ActionListener {
	JButton viewHospital, viewPatient, viewDoctor, logout;
	Font font, font1;
	JPanel heading, MainPage;
	JLabel Welcome_msg;
	ImageIcon img;

	AdminInterface() {
		font = new Font("Serif", Font.BOLD, 20);
		font1 = new Font("Serif", Font.BOLD, 30);

		heading = new JPanel();
		heading.setBackground(new Color(0, 0, 0, 80));

		// heading
		heading.setBounds(500, 0, 550, 100);
		Welcome_msg = new JLabel("Administration");
		Welcome_msg.setBounds(630, 100, 400, 50);
		Welcome_msg.setForeground(Color.WHITE);
		Welcome_msg.setFont(font1);
		heading.add(Welcome_msg);
		add(Welcome_msg);

		logout = new JButton("Log out");
		logout.setFont(font);
		logout.setBounds(1200, 30, 100, 50);
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(20, 110, 180));
		add(logout);

		MainPage = new JPanel();
		MainPage.setLayout(null);
		MainPage.setSize(400, 350);
		MainPage.setBounds(450, 200, 550, 400);// panel
		MainPage.setBackground(new Color(0, 0, 0, 60));

		viewHospital = new JButton("View Hospital");
		viewHospital.setFont(font);
		viewHospital.setBounds(50, 50, 450, 50);
		viewHospital.setForeground(Color.WHITE);
		viewHospital.setBackground(new Color(20, 110, 180));
		MainPage.add(viewHospital);

		viewPatient = new JButton("View Patient");
		viewPatient.setFont(font);
		viewPatient.setBounds(50, 150, 450, 50);
		viewPatient.setForeground(Color.WHITE);
		viewPatient.setBackground(new Color(20, 110, 180));
		MainPage.add(viewPatient);

		viewDoctor = new JButton("View Doctor");
		viewDoctor.setFont(font);
		viewDoctor.setBounds(50, 250, 450, 50);
		viewDoctor.setForeground(Color.WHITE);
		viewDoctor.setBackground(new Color(20, 110, 180));
		MainPage.add(viewDoctor);

		viewHospital.addActionListener(this);
		viewDoctor.addActionListener(this);
		viewPatient.addActionListener(this);
		logout.addActionListener(this);

		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");

		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.add(MainPage);
		background.setBounds(0, 0, 1920, 1080);

		setTitle("Administration Home page");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(background);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj_source = e.getSource();

		if (obj_source == viewHospital) {
			ViewHospital obj = new ViewHospital();
			dispose();
		}

		if (obj_source == viewPatient) {
			ViewPatient obj = new ViewPatient();
			dispose();
		}

		if (obj_source == viewDoctor) {
			ViewDoctor obj = new ViewDoctor();
			dispose();
		}
		if(obj_source == logout)
		{
			new Home();
			dispose();
		}

	}

	public static void main(String[] args) {
		new AdminInterface();
	}

}

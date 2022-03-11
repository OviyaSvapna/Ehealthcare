package patient;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;
import patient.PatientSignin;

public class AddPatient extends JFrame implements ItemListener, ActionListener {
	JLabel Patient_username, Patient_name, Age, Gender, P_Address, P_phone_nmber, Blood_group, E_mail, heading;
	JLabel errPname, errAge, erradd, errph_no, erremail;
	JTextField txtpatuser, txtpatname, txtage, txtadd, txtphno, txtemail;
	Font f1, headf, f2;
	ButtonGroup bg;
	JButton add, cancel;
	JComboBox txtbg;
	JRadioButton rm, rf;
	String fgender = "";
	ImageIcon img;

	AddPatient() {

		JPanel Addpatient = new JPanel();
		Addpatient.setLayout(null);
		Addpatient.setBounds(400, 100, 550, 560);
		Addpatient.setBackground(new Color(0, 0, 0, 130));

		Patient_username = new JLabel("Username");
		Patient_name = new JLabel("Patient_name");
		Age = new JLabel("Age");
		Gender = new JLabel("Gender");
		P_Address = new JLabel("Address");
		P_phone_nmber = new JLabel("Phone Number");
		Blood_group = new JLabel("Blood Group");
		E_mail = new JLabel("E-mail");
		heading = new JLabel("Patient Details");

		errPname = new JLabel();
		errAge = new JLabel();
		erradd = new JLabel();
		errph_no = new JLabel();
		erremail = new JLabel();

		txtpatuser = new JTextField();
		txtpatname = new JTextField();
		txtage = new JTextField();
		txtadd = new JTextField();
		txtphno = new JTextField();
		txtbg = new JComboBox();
		txtemail = new JTextField();

		txtbg.addItem("");
		txtbg.addItem("O+ ve");
		txtbg.addItem("O- ve");
		txtbg.addItem("A+ ve");
		txtbg.addItem("A- ve");
		txtbg.addItem("B+ ve");
		txtbg.addItem("B- ve");
		txtbg.addItem("AB+ ve");
		txtbg.addItem("AB- ve");

		bg = new ButtonGroup();
		rm = new JRadioButton("male");
		rf = new JRadioButton("female");
		bg.add(rm);
		bg.add(rf);
		
		add = new JButton("Add");
		cancel = new JButton("Cancel");

		rm.addItemListener(this);
		rf.addItemListener(this);
		
		f1 = new Font("Serif", Font.BOLD, 20);
		f2 = new Font("Serif", Font.BOLD, 14);
		headf = new Font("Serif", Font.BOLD, 30);

		heading.setFont(headf);
		Patient_username.setFont(f1);
		Patient_name.setFont(f1);
		Age.setFont(f1);
		Gender.setFont(f1);
		P_Address.setFont(f1);
		P_phone_nmber.setFont(f1);
		Blood_group.setFont(f1);
		E_mail.setFont(f1);

		txtpatuser.setFont(f1);
		txtpatname.setFont(f1);
		txtage.setFont(f1);
		txtadd.setFont(f1);
		txtphno.setFont(f1);
		txtbg.setFont(f1);
		txtemail.setFont(f1);
		add.setFont(f1);
		cancel.setFont(f1);
		rm.setFont(f1);
		rf.setFont(f1);

		heading.setBounds(200, 20, 200, 30);
		Patient_username.setBounds(50, 100, 200, 30);
		Patient_name.setBounds(50, 150, 200, 30);
		Age.setBounds(50, 200, 200, 30);
		Gender.setBounds(50, 250, 200, 30);
		P_Address.setBounds(50, 300, 200, 30);
		P_phone_nmber.setBounds(50, 350, 200, 30);
		Blood_group.setBounds(50, 400, 200, 30);
		E_mail.setBounds(50, 450, 200, 30);

		txtpatuser.setBounds(250, 100, 200, 30);
		txtpatname.setBounds(250, 150, 200, 30);
		txtage.setBounds(250, 200, 200, 30);
		rm.setBounds(250, 250, 100, 30);
		rf.setBounds(350, 250, 100, 30);
		txtadd.setBounds(250, 300, 200, 30);
		txtphno.setBounds(250, 350, 200, 30);
		txtbg.setBounds(250, 400, 200, 30);
		txtemail.setBounds(250, 450, 200, 30);

		errPname.setBounds(250, 180, 200, 20);
		errAge.setBounds(250, 230, 200, 20);
		erradd.setBounds(250, 330, 200, 20);
		errph_no.setBounds(250, 380, 200, 20);
		erremail.setBounds(250, 480, 200, 20);

		cancel.setBounds(100, 500, 100, 40);
		add.setBounds(300, 500, 100, 40);

		Patient_username.setForeground(Color.WHITE);
		Patient_name.setForeground(Color.WHITE);
		Age.setForeground(Color.WHITE);
		Gender.setForeground(Color.WHITE);
		P_Address.setForeground(Color.WHITE);
		P_phone_nmber.setForeground(Color.WHITE);
		Blood_group.setForeground(Color.WHITE);
		E_mail.setForeground(Color.WHITE);
		heading.setForeground(Color.WHITE);
		rm.setForeground(Color.WHITE);
		rf.setForeground(Color.WHITE);
		add.setForeground(Color.WHITE);
		cancel.setForeground(Color.WHITE);

		errAge.setForeground(Color.red);
		errPname.setForeground(Color.red);
		erradd.setForeground(Color.red);
		erremail.setForeground(Color.red);
		errph_no.setForeground(Color.red);

		cancel.setBackground(new Color(160, 182, 45));
		add.setBackground(new Color(160, 182, 45));
		rm.setBackground(new Color(0, 0, 0, 40));
		rf.setBackground(new Color(0, 0, 0, 40));

		add.addActionListener(this);
		cancel.addActionListener(this);

		ImageIcon background_image2 = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg2.jpg");
		Image img = background_image2.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image2 = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image2, JLabel.CENTER);

		Addpatient.add(heading);
		Addpatient.add(Patient_username);
		Addpatient.add(Patient_name);
		Addpatient.add(Age);
		Addpatient.add(Gender);
		Addpatient.add(P_Address);
		Addpatient.add(P_phone_nmber);
		Addpatient.add(Blood_group);
		Addpatient.add(E_mail);

		Addpatient.add(txtpatuser);
		Addpatient.add(txtpatname);
		Addpatient.add(txtage);
		Addpatient.add(rm);
		Addpatient.add(rf);
		Addpatient.add(txtadd);
		Addpatient.add(txtphno);
		Addpatient.add(txtbg);
		Addpatient.add(txtemail);

		Addpatient.add(errPname);
		Addpatient.add(errAge);
		Addpatient.add(erradd);
		Addpatient.add(erremail);
		Addpatient.add(errph_no);

		Addpatient.add(add);
		Addpatient.add(cancel);

		background.add(Addpatient);
		background.setBounds(0, 0, 1920, 1080);
		add(background);

		txtpatname.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				String fname = txtpatname.getText();
				if (Pattern.matches("^[a-zA-Z\\s]*$", fname)) {

					errPname.setVisible(false);
				} else {

					errPname.setText("Enter the valid First name");
					errPname.setVisible(true);

				}
				repaint();
			}
		});
		txtage.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				String ag = txtage.getText();
				if (Pattern.matches("[1-9][0-9]{1}", ag)) {
					errAge.setVisible(false);
				} else {

					errAge.setText("Enter the valid First name");
					errAge.setVisible(true);

				}
				repaint();
			}

		});
		txtphno.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				Boolean mob = Pattern.matches("[6789]{1}[0-9]{9}", txtphno.getText());
				if (mob == true) {
					errph_no.setVisible(false);
				} else {
					errph_no.setText("Enter valid number");
					errph_no.setVisible(true);
				}
				repaint();
			}
		});
		txtemail.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

				String mail = txtemail.getText();
				if (Pattern.matches("^(.+)@(.+)$", mail)) {

					erremail.setVisible(false);
				} else {
					erremail.setText("Enter the valid email id");
					erremail.setVisible(true);

				}
				repaint();
			}
		});

		setTitle("Patient Details");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void itemStateChanged(ItemEvent e) {
		ItemSelectable itemselected = e.getItemSelectable();

		if (itemselected == rm) {
			fgender = "male";
		
			
		} else if (itemselected == rf) {
			fgender = "female";

			
		}

	}
	

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == add) {

			String User_name = txtpatuser.getText();
			String Patient_name = txtpatname.getText();
			int Age = Integer.parseInt(txtage.getText());
			String Address = txtadd.getText();
			String phno = txtphno.getText();
			String blood_grp = txtbg.getSelectedItem().toString();
			String E_mail = txtemail.getText();

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dbproject",
						"skcet");
				Statement stmt = con.createStatement();
				String query = "insert into Patient_Details values('" + User_name + "','" + Patient_name + "','" + Age
						+ "','" + fgender + "','" + Address + "','" + phno + "','" + blood_grp + "','" + E_mail + "')";

				stmt.executeUpdate(query);
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "Registration Success!");
			
				new PatientInterface();
				// dispose();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.toString());
			}

		}
		if (o == cancel) {
			new PatientInterface();
			dispose();
		}

	}

	public static void main(String arg[]) {

		new AddPatient();
	}
}

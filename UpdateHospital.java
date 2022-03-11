package hospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.ItemSelectable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateHospital extends JFrame implements ActionListener {
	JLabel l_addh, l_hospitalname, l_address, l_bedavailability, l_category, l_city, l_phno, l_email,
			l_pass, l_ehn, l_ef, l_ba, l_epn, l_eem, l_epass, l_hun, l_hpass;
	JTextField t_facility, t_hospitalname, t_phno, t_email, t_pass, t_bedavailability, t_address, t_hun;
	ButtonGroup bgroup;
	JComboBox jcb_city;
	JComboBox jcb_category;
	JButton update, showdetails, back;
	JPasswordField t_hpass;
	Font f1, headf, f2;
	ImageIcon img;
	

	UpdateHospital() {
		JPanel container = new JPanel();
		container.setLayout(null);
		container.setBounds(700, 100, 550, 560);
		container.setBackground(new Color(0, 0, 0, 130));

		JPanel cont = new JPanel();
		cont.setLayout(null);
		cont.setBounds(150, 200, 450, 300);
		cont.setBackground(new Color(0, 0, 0, 130));

		//l_hospitalid = new JLabel("Hospital Id");
		l_hospitalname = new JLabel("Name");
		l_ehn = new JLabel();
		l_ba = new JLabel();
		l_eem = new JLabel();
		l_epass = new JLabel();
		l_epn = new JLabel();
		l_category = new JLabel("Category");
		l_bedavailability = new JLabel("Bed Available");
		l_city = new JLabel("City");
		l_phno = new JLabel("Phone");
		l_email = new JLabel("Email");
		l_hun = new JLabel("Hospital id");
		l_hpass = new JLabel("Password");

		l_address = new JLabel("Address");
		l_addh = new JLabel("Update");

		//t_hospitalid = new JTextField();
		t_facility = new JTextField();
		t_hospitalname = new JTextField();
		t_bedavailability = new JTextField();
		t_phno = new JTextField();
		t_email = new JTextField();
		t_hun = new JTextField();
		t_hpass = new JPasswordField();
		t_address = new JTextField();
		
		update = new JButton("Update");
		showdetails = new JButton("Show");
		back = new JButton("Back");

		bgroup = new ButtonGroup();
		jcb_city = new JComboBox();
		jcb_category = new JComboBox();

		f1 = new Font("Serif", Font.BOLD, 20);
		f2 = new Font("Serif", Font.BOLD, 14);
		headf = new Font("Serif", Font.BOLD, 30);

		// fontlable
		//l_hospitalid.setFont(f1);
		l_hospitalname.setFont(f1);
		l_category.setFont(f1);
		l_bedavailability.setFont(f1);
		l_city.setFont(f1);
		l_phno.setFont(f1);
		l_email.setFont(f1);
		jcb_city.setFont(f1);
		jcb_category.setFont(f1);
		l_hun.setFont(f1);
		l_hpass.setFont(f1);
		t_hun.setFont(f1);
		t_hpass.setFont(f1);
		l_address.setFont(f1);
		l_addh.setFont(headf);

		// fonttext
		//t_hospitalid.setFont(f1);
		t_facility.setFont(f1);
		t_hospitalname.setFont(f1);
		t_bedavailability.setFont(f1);
		t_phno.setFont(f1);
		t_email.setFont(f1);
		t_address.setFont(f1);

		update.setFont(f1);
		back.setFont(f1);
		showdetails.setFont(f1);

		jcb_city.addItem("");
		jcb_city.addItem("Ariyalur");
		jcb_city.addItem("Chennai");
		jcb_city.addItem("Coimbatore");
		jcb_city.addItem("Cuddalore");
		jcb_city.addItem("Dharmapuri");
		jcb_city.addItem("Dindigul");
		jcb_city.addItem("Erode");
		jcb_city.addItem("Kanchipuram");
		jcb_city.addItem("Knniyakumari");
		jcb_city.addItem("Karur");
		jcb_city.addItem("Mdurai");
		jcb_city.addItem("Namakkal");
		jcb_city.addItem("Nilgiris");
		jcb_city.addItem("Pudukkoti");
		jcb_city.addItem("Ramanathapuram");
		jcb_city.addItem("Salem");
		jcb_city.addItem("Trichirappali");
		jcb_city.addItem("Thoothukudi");
		jcb_city.addItem("Vellor");
		jcb_city.addItem("Others");

		jcb_category.addItem("");
		jcb_category.addItem("General Hospital");
		jcb_category.addItem("Speciality Hospital");
		jcb_category.addItem("Surgical Hospital");
		jcb_category.addItem("Womencare");
		jcb_category.addItem("Pediatrician");
		jcb_category.addItem("Orthopaedic");
		jcb_category.addItem("Cardiac Hospital");



		l_addh.setBounds(200, 20, 250, 30);
		//l_hospitalid.setBounds(50, 100, 200, 30);
		l_hospitalname.setBounds(50, 100, 200, 30);
		l_category.setBounds(50, 150, 200, 30);
		l_city.setBounds(50, 200, 200, 30);
		l_address.setBounds(50, 250, 200, 30);
		l_bedavailability.setBounds(50, 300, 200, 30);
		l_phno.setBounds(50, 350, 200, 30);
		l_email.setBounds(50, 400, 200, 30);

		l_hun.setBounds(30, 100, 200, 30);
		l_hpass.setBounds(30, 150, 200, 30);

		//t_hospitalid.setBounds(250, 100, 200, 30);
		t_hospitalname.setBounds(250, 100, 200, 30);
		jcb_category.setBounds(250, 150, 200, 30);
		jcb_city.setBounds(250, 200, 200, 30);
		t_address.setBounds(250, 250, 200, 30);
		t_bedavailability.setBounds(250, 300, 200, 30);
		t_phno.setBounds(250, 350, 200, 30);
		t_email.setBounds(250, 400, 200, 30);

		update.setBounds(280, 450, 100, 40);

		t_hun.setBounds(200, 100, 170, 30);
		t_hpass.setBounds(200, 150, 170, 30);

		showdetails.setBounds(250, 200, 100, 40);
		back.setBounds(100, 600, 100, 40);

		//l_hospitalid.setForeground(Color.WHITE);
		l_hospitalname.setForeground(Color.WHITE);
		l_category.setForeground(Color.WHITE);
		l_bedavailability.setForeground(Color.WHITE);
		l_city.setForeground(Color.WHITE);
		l_phno.setForeground(Color.WHITE);
		l_email.setForeground(Color.WHITE);
		l_addh.setForeground(Color.WHITE);
		l_address.setForeground(Color.WHITE);

		jcb_city.setForeground(Color.BLACK);
		jcb_category.setForeground(Color.BLACK);

		l_hun.setForeground(Color.WHITE);
		l_hpass.setForeground(Color.WHITE);

		update.setForeground(Color.WHITE);
		showdetails.setForeground(Color.WHITE);
		back.setForeground(Color.WHITE);

		update.setBackground(new Color(160, 182, 45));
		showdetails.setBackground(new Color(160, 182, 45));
		back.setBackground(new Color(160, 182, 45));

		update.addActionListener(this);
		showdetails.addActionListener(this);
		back.addActionListener(this);

		ImageIcon background_image2 = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg2.jpg");
		Image img = background_image2.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image2 = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image2, JLabel.CENTER);

		//container.add(l_hospitalid);
		container.add(l_bedavailability);
		container.add(l_hospitalname);
		container.add(l_category);
		container.add(l_address);
		container.add(l_city);
		container.add(l_phno);
		container.add(l_email);

		container.add(l_ehn);
		container.add(l_ba);
		container.add(l_epn);
		container.add(l_eem);
		cont.add(l_hun);

		cont.add(t_hun);
		cont.add(t_hpass);

		container.add(l_addh);

		container.add(update);
		cont.add(showdetails);
		cont.add(back);

		//container.add(t_hospitalid);
		container.add(t_hospitalname);
		container.add(t_bedavailability);
		container.add(jcb_category);
		container.add(t_address);
		container.add(jcb_city);
		container.add(t_phno);
		container.add(t_email);

		cont.add(l_hpass);
		cont.add(t_hun);

		background.add(cont);
		background.setBounds(0, 0, 1920, 1080);
		add(back);
		add(background);
		background.add(container);
		background.setBounds(0, 0, 1920, 1080);
		add(background);

		setTitle("Update Hospital");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == update) {
			String hospitalid =  t_hun.getText();
			String hospitalname = t_hospitalname.getText();
			String address = t_address.getText();
			String category = jcb_category.getSelectedItem().toString();
			String bedavailability = t_bedavailability.getText();
			String city = jcb_city.getSelectedItem().toString();
			String phno = t_phno.getText();
			String email = t_email.getText();

			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dbproject",
						"skcet");
				String query = "update Hospital_Details set hname=?,hcat=?,hcity=?,haddress=?,havailability=?,hphno=?,hemail=? where hid=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, hospitalname);
				stmt.setString(2, category);
				stmt.setString(3, city);
				stmt.setString(4, address);
				stmt.setString(5, bedavailability);
				stmt.setString(6, phno);
				stmt.setString(7, email);
				stmt.setString(8, hospitalid);

				stmt.executeUpdate();
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "Updation Success!");

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.toString());
			}

		}
		if (o == showdetails) {

			String h_username = t_hun.getText();
			String h_password = t_hpass.getText();

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject",
						"skcet");
				String query = "select * from Hospital_AccDetails where hid='" + h_username + "' AND Password='"
						+ h_password + "'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Now you can Update your details");

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				}

			} catch (Exception ex) {
				System.out.println(ex.toString());
			}

			try {
				String User_name = t_hun.getText();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject",
						"skcet");
				String query = "select hname,hcat,hcity,haddress,havailability,hphno,hemail from Hospital_Details where hid =?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, User_name);

				ResultSet rst = pstmt.executeQuery();

				if (rst.next()) {
					
					t_hospitalname.setText(rst.getString("hname"));
					jcb_category.setName("hcat");
					jcb_city.setName("hcity");
					t_address.setText(rst.getString("haddress"));
					t_phno.setText(rst.getString("havailability"));
					t_bedavailability.setText(rst.getString("hphno"));
					t_email.setText(rst.getString("hemail"));
				}
			}

			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "" + ex.toString());
			}
		}
		if (o == back) {

			new HospitalInterface();
			dispose();
		}

	}

	public static void main(String arg[]) {
		new UpdateHospital();
	}

}
package doctor;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DoctorSignin extends JFrame implements ActionListener 
{
	JLabel Welcome_msg, lpatient_username, lpatient_password;
	JLabel usererror,passerror;
	JTextField TDoctor_username;
	JPasswordField TDoctor_password;
	JButton Login_Button, SignUp;
	Font font, font1;
	String patient_username = "";
	String patient_password = "";
	String mail;

	public DoctorSignin() 
	{
		font = new Font("Serif", Font.BOLD, 30);
		font1 = new Font("Serif", Font.BOLD, 20);

		JPanel heading=new JPanel();
		heading.setLayout(null);
		heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0,0,1920, 100);
     
		Welcome_msg = new JLabel("Login");
		Welcome_msg.setBounds(670,50,400,50);
		Welcome_msg.setForeground(Color.WHITE);
		Welcome_msg.setFont(font);
		heading.add(Welcome_msg);

		JPanel login = new JPanel();
		login.setLayout(null);
		login.setBounds(450,100,550,550);
		login.setBackground(new Color(0, 0, 0, 60));

		lpatient_username = new JLabel("User Name");
		lpatient_username.setBounds(50, 50, 450, 50);
		lpatient_username.setBackground(new Color(210, 180, 140));
		lpatient_username.setForeground(Color.WHITE);
		lpatient_username.setFont(font);
		login.add(lpatient_username);

		TDoctor_username = new JTextField();
		usererror=new JLabel();
		TDoctor_username.setBounds(50, 150, 450, 50);
		usererror.setBounds(50,200, 450, 50);
		TDoctor_username.setBackground(Color.WHITE);
		usererror.setForeground(Color.RED);
		TDoctor_username.setFont(font);
		usererror.setFont(font1);
		login.add(TDoctor_username);
		login.add(usererror);

		lpatient_password = new JLabel("Password");
		lpatient_password.setBounds(50, 250, 450, 50);
		lpatient_password.setBackground(new Color(210, 180, 140));
		lpatient_password.setForeground(Color.WHITE);
		lpatient_password.setFont(font);
		login.add(lpatient_password);

		TDoctor_password = new JPasswordField();
		passerror=new JLabel();
		TDoctor_password.setBackground(Color.WHITE);
		passerror.setForeground(Color.RED);
		TDoctor_password.setBounds(50, 350, 450, 50);
		passerror.setBounds(50,400, 450, 50);
		TDoctor_password.setFont(font);
		passerror.setFont(font1);
		login.add(TDoctor_password);
		login.add(passerror);

		SignUp = new JButton("Sign Up");
		SignUp.setBounds(50, 450, 150, 50);
		SignUp.setBackground(new Color(160, 182, 45));
		SignUp.setFont(font1);
		SignUp.setForeground(Color.WHITE);
		login.add(SignUp);

		Login_Button = new JButton("Login");
		Login_Button.setBounds(350, 450, 150, 50);
		Login_Button.setBackground(new Color(160, 182, 45));
		Login_Button.setFont(font1);
		Login_Button.setForeground(Color.WHITE);
		login.add(Login_Button);
		Login_Button.addActionListener(this);
		SignUp.addActionListener(this);
		
		TDoctor_username.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}
    	
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    	String uname=TDoctor_username.getText();
    		if(Pattern.matches("^[A-Za-z]\\w{5,29}$",uname))
    		{
    			usererror.setText(null);   			
    		}
    		else
    		{
    			usererror.setText("Enter the valid Username name");
    		}
    		repaint();
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) 
    	{
    		
    	}
    	});


		TDoctor_password.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    	String pass=TDoctor_password.getText();
    		if(Pattern.matches("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+*=])"+"(?=\\S+$).{8,20}$",pass))
    		{
    			passerror.setText(null);		
    		}
    		else
    		{
    			passerror.setText("Enter the valid Valid password");
    		}
    		repaint();
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) 
    	{
    		
    	}
    	});



		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");
        Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.add(login);
		background.add(heading);
		background.setBounds(0, 0, 1920, 1080);
		add(background);
		
		setTitle("Doctor Login");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		Object obj_source = e.getSource();
        if (obj_source == Login_Button) 
        {

			try {
				patient_username = TDoctor_username.getText();
				patient_password = TDoctor_password.getText();
				database(patient_username, patient_password);

			} catch (Exception ae) {

			}
		}
		if (obj_source == SignUp)
		{
			try 
			{
				dispose();
				DocCreateAccount signup = new DocCreateAccount();
			} catch (Exception ae) 
			{
				System.out.print(ae);
			}
		}

	}

	public void database(String patient_username, String patient_password) 
	{

		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
		    String query = "select * from Doctor_AccDetails where User_name='" + patient_username + "' AND password='"+ patient_password + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

            if (rs.next())
            {
				JOptionPane.showMessageDialog(null, "Login Succesfully");
				dispose();
				AfterLogin obj = new AfterLogin();
			}
            else 
            {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			}

			con.close();

		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new DoctorSignin();
	}

}


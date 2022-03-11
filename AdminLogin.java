package administrator;
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

public class AdminLogin extends JFrame implements ActionListener 
{
	JLabel Welcome_msg, ladmin_username, ladmin_password;
	JLabel usererror,passerror;
	JTextField Tadmin_username;
	JPasswordField Tadmin_password;
	JButton Login_Button;
	Font font, font1,font2;
	String patient_username = "";
	String patient_password = "";

	AdminLogin() 
	{
		font = new Font("Serif", Font.BOLD, 30);
		font1 = new Font("Serif", Font.BOLD, 20);
		font2= new Font("Serif", Font.BOLD,15);

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

		ladmin_username = new JLabel("User Name");
		ladmin_username.setBounds(50, 50, 450, 50);
		ladmin_username.setBackground(new Color(210, 180, 140));
		ladmin_username.setForeground(Color.WHITE);
		ladmin_username.setFont(font);
		login.add(ladmin_username);

		Tadmin_username = new JTextField();
		usererror=new JLabel();
		Tadmin_username.setBounds(50, 150, 450, 50);
		usererror.setBounds(50,200, 450, 50);
		Tadmin_username.setBackground(Color.WHITE);
		usererror.setForeground(Color.RED);
		Tadmin_username.setFont(font);
		usererror.setFont(font1);
		login.add(Tadmin_username);
		login.add(usererror);

		ladmin_password = new JLabel("Password");
		ladmin_password.setBounds(50, 250, 450, 50);
		ladmin_password.setBackground(new Color(210, 180, 140));
		ladmin_password.setForeground(Color.WHITE);
		ladmin_password.setFont(font);
		login.add(ladmin_password);

		Tadmin_password = new JPasswordField();
		passerror=new JLabel();
		Tadmin_password.setBackground(Color.WHITE);
		passerror.setForeground(Color.RED);
		Tadmin_password.setBounds(50, 350, 450, 50);
		passerror.setBounds(50,400, 450, 50);
		Tadmin_password.setFont(font);
		passerror.setFont(font1);
		login.add(Tadmin_password);
		login.add(passerror);

		Tadmin_username.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}
    	
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    	String uname=Tadmin_username.getText();
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


		Tadmin_password.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    	String pass=Tadmin_password.getText();
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


		/*SignUp = new JButton("Sign Up");
		SignUp.setBounds(50, 450, 150, 50);
		SignUp.setBackground(new Color(160, 182, 45));
		SignUp.setFont(font1);
		SignUp.setForeground(Color.WHITE);
		login.add(SignUp);*/

		Login_Button = new JButton("Login");
		Login_Button.setBounds(200, 450, 150, 50);
		Login_Button.setBackground(new Color(160, 182, 45));
		Login_Button.setFont(font1);
		Login_Button.setForeground(Color.WHITE);
		login.add(Login_Button);
		Login_Button.addActionListener(this);
		//SignUp.addActionListener(this);

		ImageIcon background_image = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");

		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);

		background.add(login);
		background.add(heading);
		background.setBounds(0, 0, 1920, 1080);
		add(background);
		
		setTitle("Admin Login");
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
				patient_username = Tadmin_username.getText();
				patient_password = Tadmin_password.getText();
				database(patient_username, patient_password);
				new AdminInterface();
				dispose();

			} catch (Exception ae) {

			}
		}
		/*if (obj_source == SignUp)
		{
			try 
			{
				dispose();
				AdminCreateAccount signup = new AdminCreateAccount();
			} catch (Exception ae) 
			{
				System.out.print(ae);
			}
		}*/

	}

	public void database(String patient_username, String patient_password) 
	{

		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
		    String query = "select * from Admin_AccDetails where User_name='" + patient_username + "' AND password='"+ patient_password + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

            if (rs.next())
            {
				JOptionPane.showMessageDialog(null, "Login Succesfully");
				dispose();
				AdminInterface obj = new AdminInterface();
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
		new AdminLogin();
	}

}


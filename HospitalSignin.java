package hospital;

import java.awt.Color;
import java.awt.Font;
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

public class HospitalSignin extends JFrame implements ActionListener 
{
	JLabel Welcome_msg, lhospital_username, lhospital_password;
	JLabel usererror,passerror;
	JTextField THospital_username;
	JPasswordField THospital_password;
	JButton Login_Button, SignUp;
	Font font, font1,font2;
	String patient_username = "";
	String patient_password = "";

	public HospitalSignin() 
	{
		font = new Font("Serif", Font.BOLD, 30);
		font1 = new Font("Serif", Font.BOLD, 20);
		font2=new Font("Serif", Font.BOLD, 15);

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

		lhospital_username = new JLabel("User Name");
		lhospital_username.setBounds(50, 50, 450, 50);
		lhospital_username.setBackground(new Color(210, 180, 140));
		lhospital_username.setForeground(Color.WHITE);
		lhospital_username.setFont(font);
		login.add(lhospital_username);

		THospital_username = new JTextField();
		usererror= new JLabel();
		THospital_username.setBounds(50, 150, 450, 50);
		usererror.setBounds(50,200, 450, 50);
		THospital_username.setBackground(Color.WHITE);
		usererror.setForeground(Color.RED);
		THospital_username.setFont(font);
		usererror.setFont(font1);
		login.add(THospital_username);
		login.add(usererror);

		lhospital_password = new JLabel("Password");
		lhospital_password.setBounds(50, 250, 450, 50);
		lhospital_password.setBackground(new Color(210, 180, 140));
		lhospital_password.setForeground(Color.WHITE);
		lhospital_password.setFont(font);
		login.add(lhospital_password);

		THospital_password = new JPasswordField();
		passerror=new JLabel();
		THospital_password.setBackground(Color.WHITE);
		passerror.setForeground(Color.RED);
		THospital_password.setBounds(50, 350, 450, 50);
		passerror.setBounds(50,400, 450, 50);
		THospital_password.setFont(font);
		passerror.setFont(font1);
		login.add(THospital_password);
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
		
		THospital_username.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}
    	
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String uname=THospital_username.getText();
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


		THospital_password.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String pass=THospital_password.getText();
    		if(Pattern.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+*=])" +"(?=\\S+$).{8,20}$",pass))
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
		
		setTitle("Hospital Login");
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

			try 
			{
				patient_username = THospital_username.getText();
				patient_password = THospital_password.getText();
				database(patient_username, patient_password);

			} catch (Exception ae)
			{
				System.out.print(ae);
			}
		}
		if (obj_source == SignUp)
		{
			try 
			{
				HospCreateAccount signup = new HospCreateAccount();
				dispose();
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
		    String query = "select * from Hospital_AccDetails where User_name='" + patient_username + "' AND password='"+ patient_password + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

            if (rs.next())
            {
				JOptionPane.showMessageDialog(null, "Login Succesfully");
				
			}
            else 
            {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			}
             
            new HospitalInterface();
            dispose();
			con.close();

		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new HospitalSignin();
	}

}

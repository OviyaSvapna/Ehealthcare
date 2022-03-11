package hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;
import java.io.*;
import patient.Data;
import patient.PatientSignin;
public class HospCreateAccount extends JFrame implements ActionListener
{
	JLabel background,username,password,Confirm_password,Email,Firstname,Lastname,usererror,passerror,confirmerror,emailerror,firsterror,lasterror,heading;
	JTextField txtuser,txtemail,txtfname,txtlname;
	JPasswordField txtpass,txtconfirm;
    JButton create,cancel;
    Font font1,hfont,font;
    ImageIcon img;
    String psch,ps;
	
	HospCreateAccount()
	{
	    JPanel CreateAcc=new JPanel();
	    CreateAcc.setLayout(null);
	    CreateAcc.setBounds(450,100,550,500);
	    CreateAcc.setBackground(new Color(0,0,0,80));
	   
	    Firstname=new JLabel("First name");
	    Lastname=new JLabel("Last name");
	    username=new JLabel("User name");
	    password=new JLabel("Password");
	    Confirm_password=new JLabel("Confirm password");
	    Email=new JLabel("E-mail");
	    heading=new JLabel("Create Account");
	    
	
	    txtfname=new JTextField();
	    txtlname=new JTextField();
	    txtuser=new JTextField();
	    txtpass=new  JPasswordField();
	    txtconfirm=new  JPasswordField();
	    txtemail=new JTextField();
	    
	    
	    usererror=new JLabel();
	    passerror=new JLabel();
	    confirmerror=new JLabel();
	    emailerror=new JLabel();
	    firsterror=new JLabel();
	    lasterror=new JLabel();

	    create=new JButton("Create");
		cancel=new JButton("Sign in");
		
		txtfname.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String fname = txtfname.getText();
				if (Pattern.matches("^[a-zA-Z\\s]*$", fname)) {
					firsterror.setVisible(false);

				} else {
					firsterror.setText("Enter the valid First name");
					firsterror.setVisible(true);
				}
				repaint();

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});

		txtlname.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String lname = txtlname.getText();
				if (Pattern.matches("^[a-zA-Z\\s]*$", lname)) {
					lasterror.setVisible(false);
				} else {
					lasterror.setText("Enter the valid Last name");
					lasterror.setVisible(true);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});

		txtuser.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String uname = txtuser.getText();
				if (Pattern.matches("^[A-Za-z]\\w{5,29}$", uname)) {
					usererror.setVisible(false);

				} else {
					usererror.setText("Enter the valid username");
					usererror.setVisible(true);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});

		txtpass.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String pwd = txtpass.getText();
				ps = txtpass.getText();

				if (Pattern.matches(
						"^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+*=])" + "(?=\\S+$).{8,20}$", pwd)) {
					passerror.setVisible(false);
				} else {
					passerror.setText("Enter the valid password");
					passerror.setVisible(true);
				}
				repaint();

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});

		txtconfirm.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String cpwd = txtconfirm.getText();
				if (Pattern.matches(
						"^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&*+=])" + "(?=\\S+$).{8,20}$", cpwd)
						&& cpwd.equals(ps)) {
					confirmerror.setVisible(false);

				} else {
					confirmerror.setText("Enter the correct password");
					confirmerror.setVisible(true);
				}
				repaint();
			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}
		});

		txtemail.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String mail = txtemail.getText();
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

		
		create.addActionListener(this);
		cancel.addActionListener(this);

		heading.setBounds(200,20,200 ,30);
		Firstname.setBounds(50,100,200,30);
		Lastname.setBounds(50,150,200,30);
		username.setBounds(50,200,200,30);
		password.setBounds(50,250,200,30);
		Confirm_password.setBounds(50,300,200,30);
		Email.setBounds(50,350,200,30);
		
		txtfname.setBounds(250,100,200,30);
		firsterror.setBounds(250,120,200,30);
		txtlname.setBounds(250,150,200,30);
		lasterror.setBounds(250,170,200,30);	
		txtuser.setBounds(250,200,200,30);
		usererror.setBounds(250,220,200,30);
		txtpass.setBounds(250,250,200,30);
		passerror.setBounds(250,270,200,30);
		txtconfirm.setBounds(250,300,200,30);
		confirmerror.setBounds(250,320,200,30);
		txtemail.setBounds(250,350,200,30);
		emailerror.setBounds(250,370,200,30);
		
		cancel.setBounds(70,430,100,30);
		create.setBounds(300,430,100,30);
		
		font1=new Font("Serif",Font.BOLD,20);
		font=new Font("Serif",Font.BOLD,14);
		hfont=new Font("Serif",Font.BOLD,30);
		
		heading.setFont(hfont);
		username.setFont(font1);
		password.setFont(font1);
		Confirm_password.setFont(font1);
		Email.setFont(font1);
		Firstname.setFont(font1);
		Lastname.setFont(font1);
		create.setFont(font1);
		cancel.setFont(font1);	
		
		txtuser.setFont(font1);
		txtemail.setFont(font1);
		txtfname.setFont(font1);
		txtlname.setFont(font1);
	    
		usererror.setFont(font);
		passerror.setFont(font);
		confirmerror.setFont(font);
		emailerror.setFont(font);
		firsterror.setFont(font);
		lasterror.setFont(font);
		
		usererror.setForeground(Color.RED);
		passerror.setForeground(Color.RED);
		confirmerror.setForeground(Color.RED);
		emailerror.setForeground(Color.RED);
		firsterror.setForeground(Color.RED);
		lasterror.setForeground(Color.RED);
		
		heading.setForeground(Color.WHITE);
		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		Confirm_password.setForeground(Color.WHITE);
		Email.setForeground(Color.WHITE);
		Firstname.setForeground(Color.WHITE);
		Lastname.setForeground(Color.WHITE);
		create.setForeground(Color.WHITE);
		cancel.setForeground(Color.WHITE);
		
		create.setBackground(new Color(36,160,237));
		cancel.setBackground(new Color(36,160,237));
  
        ImageIcon background_image=new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg.jpg");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        
 
     
        CreateAcc.add(heading);
        CreateAcc.add(Firstname);
        CreateAcc.add(Lastname);
        CreateAcc.add(username);
        CreateAcc.add(password);
        CreateAcc.add(Confirm_password);
        CreateAcc.add(Email);
		
        CreateAcc.add(txtfname);
        CreateAcc.add(txtlname);
        CreateAcc.add(txtuser);
        CreateAcc.add(txtpass);
        CreateAcc.add(txtconfirm);
//        CreateAcc.add(Tpatient_password);
//        CreateAcc.add(Cpatient_password);
        CreateAcc.add(txtemail);
			
        CreateAcc.add(usererror);
        CreateAcc.add(passerror);
        CreateAcc.add(confirmerror);
        CreateAcc.add(emailerror);
        CreateAcc.add(firsterror);
        CreateAcc.add(lasterror);
		
        CreateAcc.add(create);
        CreateAcc.add(cancel);
		
        background.add(CreateAcc);
		background.setBounds(0, 0, 1920, 1080);
		add(background);
	     
		setTitle("Hospital Create Account");
	    setSize(1920,1080);
	    setLayout(null);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object o=e.getSource();

        if(o==create)
        {
        	
            String First_name=txtfname.getText();
            String Last_name=txtlname.getText();
            String User_name=txtuser.getText();
//          String Password = Tpatient_password.getText();
//			String ConPass = Cpatient_password.getText();
            String Password=txtpass.getText();
            String ConPass=txtconfirm.getText();
            String Email=txtemail.getText();
            Data d=new Data(First_name,Last_name,User_name,Password,ConPass,Email);
            try
            {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dbproject","skcet");
            Statement stmt=con.createStatement();
            String query="insert into Hospital_AccDetails values('"+First_name+"','"+Last_name+"','"+User_name+"','"+Password+"','"+ConPass+"','"+Email+"')";
         
            stmt.executeUpdate(query);
            con.setAutoCommit(true);
            JOptionPane.showMessageDialog(this, "Registration Success!");

            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
            MailRegistration msg = new MailRegistration();
            msg.Servicemsg(Email);
            new HospitalSignin(); 
           
          }
        if(o==cancel)
        {
        	try 
			{
				HospitalSignin signin = new HospitalSignin();
				dispose();
			} 
        	catch (Exception ae) 
			{
				System.out.print(ae);
			}
        	
        }
        

}


	public static void main(String[] args) 
	{
		new HospCreateAccount();
       
	}

}

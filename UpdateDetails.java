package doctor;

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

public class UpdateDetails extends JFrame implements ActionListener
{
	JLabel Doctor_name, Specialist, fees, timing, email, phone, qualification, heading,username,password;
	JLabel nameerror,age_error,gender_error,addresserror,pherror,bgerror,emailerror,usererror,passerror;
	JTextField txtdocname, txtspecialist,txtfees,txttiming, txtmail, txtphone, txtqualification,doctortxt;
	JPasswordField doctorpass;
	Font f1, headf, f2;
	JButton update,showdetails,back;
	ImageIcon img;

	UpdateDetails()
	{

	    JPanel Addpatient = new JPanel();
		Addpatient.setLayout(null);
		Addpatient.setBounds(700, 100, 550, 560);
		Addpatient.setBackground(new Color(0, 0, 0, 130));
		
		JPanel shDetail = new JPanel();
		shDetail.setLayout(null);
		shDetail.setBounds(150,200,450,300);
		shDetail.setBackground(new Color(0, 0, 0, 130));

		Doctor_name = new JLabel("Doctor Name");
		Specialist = new JLabel("Specialist");
		fees = new JLabel("Fees");
		timing = new JLabel("Timing");
		email = new JLabel("e-Mail");
		phone = new JLabel("Phone");
		qualification = new JLabel("Qualification");
		
		username= new JLabel("User name");
		password= new JLabel("Password");
		
		heading = new JLabel("Doctor Details");

		txtdocname = new JTextField();
		txtspecialist = new JTextField();
		txtfees=new JTextField();
		txttiming = new JTextField();
		txtmail = new JTextField();
		txtphone = new JTextField();
		txtqualification = new JTextField();
		
		doctortxt= new JTextField();
		doctorpass= new JPasswordField();
		
	  	pherror=new JLabel();
     	emailerror=new JLabel();
		usererror=new JLabel();
	    passerror=new JLabel();
		
		update = new JButton("Update");
		showdetails = new JButton("Show");
		back= new JButton("Back");
		
		back= new JButton("Back");

        txtphone.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String phno=txtphone.getText();
    		if(Pattern.matches("(0/91)?[7-9][0-9]{9}",phno))
    		{
    			pherror.setVisible(false);
    			
    		}
    		else
    		{
    			pherror.setText("Enter the valid phone number");
    			pherror.setVisible(true);
    		}
    		repaint();
    		
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) {}
    	});


		txtmail.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String email=txtmail.getText();
    		if(Pattern.matches("^(.+)@(.+)$",email))
    		{
    			emailerror.setVisible(false);
    			
    		}
    		else
    		{
    			emailerror.setText("Enter the valid E-mail id");
    			emailerror.setVisible(true);
    		}	
    		repaint();
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) {}
    	});


		doctortxt.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}
    	
    	@Override
    	public void keyReleased(KeyEvent arg0) {

    		String uname=doctortxt.getText();
    		if(Pattern.matches("^[A-Za-z]\\w{5,29}$",uname))
    		{
    			usererror.setVisible(false);
    		}
    		else
    		{
    			usererror.setText("Enter the valid Username name");
    			usererror.setVisible(false);
    		}
    		repaint();
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) {}
    	});


	    doctorpass.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String pass=doctorpass.getText();
    		if(Pattern.matches("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&*+=])"+"(?=\\S+$).{8,20}$",pass))
    		{
    			passerror.setVisible(false);		
    		}
    		else
    		{
    			passerror.setText("Enter the valid Valid password");
    			passerror.setVisible(true);	
    		}
    		repaint();
    	}
    	@Override
    	public void keyTyped(KeyEvent arg0) {}
    	});


				
        f1 = new Font("Serif",Font.BOLD, 20);
		f2 = new Font("Serif",Font.BOLD, 14);
		headf = new Font("Serif",Font.BOLD, 30);

		heading.setFont(headf);
		
		Doctor_name.setFont(f1);
		Specialist.setFont(f1);
		fees.setFont(f1);
		timing.setFont(f1);
		email.setFont(f1);
		phone.setFont(f1);
		qualification.setFont(f1);
		
		username.setFont(f1);
		password.setFont(f1);
		
		txtdocname.setFont(f1);
		txtspecialist.setFont(f1);
		txtfees.setFont(f1);
		txttiming.setFont(f1);
		txtmail.setFont(f1);
		txtphone.setFont(f1);
		txtqualification.setFont(f1);

		update.setFont(f1);
		showdetails.setFont(f1);
		back.setFont(f1);

		doctortxt.setFont(f1);
		doctorpass.setFont(f1);
		
	  	pherror.setFont(f2);
     	emailerror.setFont(f2);
		usererror.setFont(f2);
	    passerror.setFont(f2);

		heading.setBounds(200, 20, 200, 30);
		Doctor_name.setBounds(50,100,200,30);
		Specialist.setBounds(50,150,200,30);
		fees.setBounds(50,200,200,30);
		timing.setBounds(50,250,200,30);
		email.setBounds(50,300,200,30);
		phone.setBounds(50,350,200,30);
		qualification.setBounds(50,400,200,30);
		
	    username.setBounds(50,100,150,30);
		password.setBounds(50, 150,150,30);
		
		txtdocname.setBounds(250, 100, 200, 30);
		txtspecialist.setBounds(250, 150, 200, 30);
		txtfees.setBounds(250,200,200, 30);
		txttiming.setBounds(250, 250, 200, 30);
		txtmail.setBounds(250,300, 200, 30);
		pherror.setBounds(250,320, 200, 30);
		txtphone.setBounds(250, 350, 200, 30);
		txtqualification.setBounds(250,400, 200, 30);
		emailerror.setBounds(250,420, 200, 30);
		
		update.setBounds(280,450,100,40);
		   
		doctortxt.setBounds(200,100,200,30);
		usererror.setBounds(200,120,200,30);
		doctorpass.setBounds(200,150,200,30);
		passerror.setBounds(200,170,200,30);

		showdetails.setBounds(250,200,100,40);
		back.setBounds(100,600,100,40);
		
		heading.setForeground(Color.WHITE);
	
		Doctor_name.setForeground(Color.WHITE);
		Specialist.setForeground(Color.WHITE);
		fees.setForeground(Color.WHITE);
		timing.setForeground(Color.WHITE);
		email.setForeground(Color.WHITE);
		phone.setForeground(Color.WHITE);
		qualification.setForeground(Color.WHITE);

		username.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		
		update.setForeground(Color.WHITE);
		showdetails.setForeground(Color.WHITE);
		back.setForeground(Color.WHITE);
        
		pherror.setForeground(Color.RED);
		emailerror.setForeground(Color.RED);
		usererror.setForeground(Color.RED);
		passerror.setForeground(Color.RED);
		
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

		Addpatient.add(heading);
		
		Addpatient.add(Doctor_name);
		Addpatient.add(Specialist);
		Addpatient.add(fees);
		Addpatient.add(timing);
		Addpatient.add(email);
		Addpatient.add(phone);
		Addpatient.add(qualification);

		Addpatient.add(txtdocname);
		Addpatient.add(txtspecialist);
		Addpatient.add(txtfees);
		Addpatient.add(txttiming);
		Addpatient.add(txtmail);
		Addpatient.add(txtphone);
		Addpatient.add(txtqualification);
		
		Addpatient.add(pherror);
		Addpatient.add(emailerror);

        Addpatient.add(update);
		
		shDetail.add(username);
		shDetail.add(password);
		
		shDetail.add(doctortxt);
		shDetail.add(doctorpass);
		
		shDetail.add(usererror);
		shDetail.add(passerror);
		
		shDetail.add(showdetails);

		background.add(Addpatient);
		background.add(shDetail);
		background.setBounds(0, 0, 1920, 1080);
		add(back);
		add(background);

		setTitle("Update Doctor Details");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

    @Override
    public void actionPerformed(ActionEvent e) 
    {
	Object o = e.getSource();
		
		if (o == update) 
		{
			String username = doctortxt.getText();
			String Name = txtdocname.getText();
			String Specialist = txtspecialist.getText();
			String fees=txtfees.getText();
			String timing = txttiming.getText();
			String email = txtmail.getText();
			String phone = txtphone.getText();
			String qualification = txtqualification.getText();

			try 
			{

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dbproject","skcet");
                String query = "update Doctordetails set name=?,Specialist=?,Fee=?,timing=?,email=?,phone=?,qualification=? where uname=?";
			    PreparedStatement stmt=con.prepareStatement(query);
			    stmt.setString(1,Name);
	            stmt.setString(2,Specialist);
	            stmt.setString(3,fees);
	            stmt.setString(4,timing);
	            stmt.setString(5,email);
	            stmt.setString(6,phone);
	            stmt.setString(7,qualification);
	            stmt.setString(8,username);
				
				stmt.executeUpdate();
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "Updation Success!");

			} catch (Exception ex) 
			{
				JOptionPane.showMessageDialog(this, ex.toString());
			}

		}
		if(o==showdetails)
		{
	
		     String	doctor_username =doctortxt.getText();
		     String	doctor_password =doctorpass .getText();
	
			
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
			    String query = "select * from Doctor_AccDetails where username='" + doctor_username + "' and password='"+ doctor_password + "'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
	             	       
	            if (rs.next())
	            {
					JOptionPane.showMessageDialog(null, "Now you can Update your details");
		
				}
	            else 
	            {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				}

			} 
			catch (Exception ex) 
			{
				System.out.println(ex.toString());
			}
			
		 try
         {
                 String username =doctortxt.getText();
   	             Class.forName("oracle.jdbc.driver.OracleDriver");
   	             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
                 String query="select name,Specialist,Fee,timing,email,phone,qualification from Doctordetails where uname =?"; 
                 PreparedStatement pstmt=con.prepareStatement(query);
                 pstmt.setString(1,username);
                    
                 ResultSet rst=pstmt.executeQuery();

                 if(rst.next())
                 {
                   txtdocname.setText(rst.getString("name")); 
                   txtspecialist.setText(rst.getString("Specialist")); 
                   txtfees.setText(rst.getString("Fee"));
                   txttiming.setText(rst.getString("timing"));
                   txtmail.setText(rst.getString("email"));
                   txtphone.setText(rst.getString("phone"));
                   txtqualification.setText(rst.getString("qualification"));
                }
        }
      
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(this,""+ ex.toString());
       }
	}
		if(o==back)
		{
			new AfterLogin();
			dispose();
		}
   
	}
	public static void main(String arg[])
	{
		new UpdateDetails();
	}

}

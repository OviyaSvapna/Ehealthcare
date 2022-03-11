package patient;

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

public class UpdatePatient extends JFrame implements ActionListener
{
	JLabel Patient_name, Age, Gender, P_Address, P_phone_nmber, Blood_group, E_mail, heading,patunlabel,patientpslabel;
	JLabel pherror,emailerror,usererror,passerror;
	JTextField txtpatname, txtage,txtgender,txtadd, txtphno, txtbg, txtemail,patienttxt;
	JPasswordField patientpass;
	Font f1, headf, f2;
	JButton update,showdetails,back;
	ImageIcon img;

	UpdatePatient()
	{

	    JPanel Addpatient = new JPanel();
		Addpatient.setLayout(null);
		Addpatient.setBounds(700, 100, 550, 560);
		Addpatient.setBackground(new Color(0, 0, 0, 130));
		
		JPanel shDetail = new JPanel();
		shDetail.setLayout(null);
		shDetail.setBounds(150,200,450,300);
		shDetail.setBackground(new Color(0, 0, 0, 130));

		Patient_name = new JLabel("Patient_name");
		Age = new JLabel("Age");
		Gender = new JLabel("Gender");
		P_Address = new JLabel("Address");
		P_phone_nmber = new JLabel("Phone Number");
		Blood_group = new JLabel("Blood Group");
		E_mail = new JLabel("E-mail");
		
		patunlabel= new JLabel("User name");
		patientpslabel= new JLabel("Password");
		
		heading = new JLabel("Patient Details");

		txtpatname = new JTextField();
		txtage = new JTextField();
		txtgender=new JTextField();
		txtadd = new JTextField();
		txtphno = new JTextField();
		txtbg = new JTextField();
		txtemail = new JTextField();

    	pherror=new JLabel();
     	emailerror=new JLabel();
		usererror=new JLabel();
	    passerror=new JLabel();
		
		patienttxt= new JTextField();
		patientpass= new JPasswordField();
		
		update = new JButton("Update");
		showdetails = new JButton("Show");
		back= new JButton("Back");

        txtphno.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String phno=txtphno.getText();
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


		txtemail.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String email=txtemail.getText();
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


		patienttxt.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}
    	
    	@Override
    	public void keyReleased(KeyEvent arg0) {

    		String uname=patienttxt.getText();
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


	    patientpass.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0) {}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String pass=patientpass.getText();
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
		
		Patient_name.setFont(f1);
		Age.setFont(f1);
		Gender.setFont(f1);
		P_Address.setFont(f1);
		P_phone_nmber.setFont(f1);
		Blood_group.setFont(f1);
		E_mail.setFont(f1);
		
		patunlabel.setFont(f1);
		patientpslabel.setFont(f1);
		
		txtpatname.setFont(f1);
		txtage.setFont(f1);
		txtgender.setFont(f1);
		txtadd.setFont(f1);
		txtphno.setFont(f1);
		txtbg.setFont(f1);
		txtemail.setFont(f1);

		update.setFont(f1);
		showdetails.setFont(f1);
		back.setFont(f1);

		patienttxt.setFont(f1);
		patientpass.setFont(f1);
	

		pherror.setFont(f2);
		emailerror.setFont(f2);
		usererror.setFont(f2);
		passerror.setFont(f2);


		heading.setBounds(200, 20, 200, 30);
		Patient_name.setBounds(50,100,200,30);
		Age.setBounds(50,150,200,30);
		Gender.setBounds(50,200,200,30);
		P_Address.setBounds(50,250,200,30);
		P_phone_nmber.setBounds(50,300,200,30);
		Blood_group.setBounds(50,350,200,30);
		E_mail.setBounds(50,400,200,30);
		
	    patunlabel.setBounds(50,100,150,30);
		patientpslabel.setBounds(50, 150,150,30);
		
		txtpatname.setBounds(250, 100, 200, 30);
		txtage.setBounds(250, 150, 200, 30);
		txtgender.setBounds(250,200,200, 30);
		txtadd.setBounds(250, 250, 200, 30);
		txtphno.setBounds(250,300, 200, 30);
		pherror.setBounds(250,320, 200, 30);
		txtbg.setBounds(250, 350, 200, 30);
		txtemail.setBounds(250,400, 200, 30);
		emailerror.setBounds(250,420, 200, 30);
		
		update.setBounds(280,450,100,40);
		   
		patienttxt.setBounds(200,100,200,30);
		usererror.setBounds(200,120,200,30);
		patientpass.setBounds(200,150,200,30);
		passerror.setBounds(200,170,200,30);

		showdetails.setBounds(250,200,100,40);
		back.setBounds(100,600,100,40);
		
		heading.setForeground(Color.WHITE);
	
		Patient_name.setForeground(Color.WHITE);
		Age.setForeground(Color.WHITE);
		Gender.setForeground(Color.WHITE);
		P_Address.setForeground(Color.WHITE);
		P_phone_nmber.setForeground(Color.WHITE);
		Blood_group.setForeground(Color.WHITE);
		E_mail.setForeground(Color.WHITE);

		patunlabel.setForeground(Color.WHITE);
		patientpslabel.setForeground(Color.WHITE);
		
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
		
		Addpatient.add(Patient_name);
		Addpatient.add(Age);
		Addpatient.add(Gender);
		Addpatient.add(P_Address);
		Addpatient.add(P_phone_nmber);
		Addpatient.add(Blood_group);
		Addpatient.add(E_mail);

		Addpatient.add(txtpatname);
		Addpatient.add(txtage);
		Addpatient.add(txtgender);
		Addpatient.add(txtadd);
		Addpatient.add(txtphno);
		Addpatient.add(txtbg);
		Addpatient.add(txtemail);

		Addpatient.add(pherror);
		Addpatient.add(emailerror);

        Addpatient.add(update);
		
		shDetail.add(patunlabel);
		shDetail.add(patientpslabel);
		
		shDetail.add(patienttxt);
		shDetail.add(patientpass);
		
		shDetail.add(usererror);
		shDetail.add(passerror);
		
		shDetail.add(showdetails);

		background.add(Addpatient);
		background.add(shDetail);
		background.setBounds(0, 0, 1920, 1080);
		add(back);
		add(background);

		setTitle("Update Patient Details");
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
			String User_name = patienttxt.getText();
			String Patient_name = txtpatname.getText();
			int Age = Integer.parseInt(txtage.getText());
			String fgender=txtgender.getText();
			String Address = txtadd.getText();
			String phno = txtphno.getText();
			String blood_grp = txtbg.getText();
			String E_mail = txtemail.getText();

			try 
			{

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dbproject","skcet");
				String query = "update Patient_Details set Patient_name=?,Age=?,Gender=?,Address=?,phno=?,blood_grp=?,E_mail=? where User_name=?";
			    PreparedStatement stmt=con.prepareStatement(query);
			    stmt.setString(1,Patient_name);
	            stmt.setInt(2,Age);
	            stmt.setString(3,fgender);
	            stmt.setString(4,Address);
	            stmt.setString(5,phno);
	            stmt.setString(6,blood_grp);
	            stmt.setString(7,E_mail);
	            stmt.setString(8,User_name);
				
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
	
		     String	patient_username =patienttxt.getText();
		     String	patient_password =patientpass .getText();
	
			
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
			    String query = "select * from Patient_AccDetails where User_name='" + patient_username + "' AND password='"+ patient_password + "'";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
	             	       
	            if (rs.next())
	            {
					//JOptionPane.showMessageDialog(null, "Now you can Update your details");
		
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
                 String User_name =patienttxt.getText();
   	             Class.forName("oracle.jdbc.driver.OracleDriver");
   	             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "dbproject", "skcet");
                 String query="select Patient_name,Age,Gender,Address,phno,blood_grp,E_mail from Patient_Details where User_name =?"; 
                 PreparedStatement pstmt=con.prepareStatement(query);
                 pstmt.setString(1,User_name);
                    
                 ResultSet rst=pstmt.executeQuery();

                 if(rst.next())
                 {
                   txtpatname.setText(rst.getString("Patient_name")); 
                   txtage.setText(rst.getString("Age")); 
                   txtgender.setText(rst.getString("Gender"));
                   txtadd.setText(rst.getString("Address"));
                   txtphno.setText(rst.getString("phno"));
                   txtbg.setText(rst.getString("blood_grp"));
                   txtemail.setText(rst.getString("E_mail"));
                }
        }
      
       catch(Exception ex)
       {
          JOptionPane.showMessageDialog(this,""+ ex.toString());
       }
	}
		if(o==back)
		{
			new PatientInterface();
			dispose();
		}
   
	}
	public static void main(String arg[])
	{
		new UpdatePatient();
	}

}

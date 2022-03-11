package doctor;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.*;

public class AddDetails extends JFrame implements ActionListener
{
	JLabel l0,l1, l2, l3, l4, l5, l6, l7, numerr, feerror, mailerror,head;
	JTextField t0,t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2;

	AddDetails()
	{

		JPanel CreateAcc = new JPanel();
		CreateAcc.setLayout(null);
		CreateAcc.setBounds(400,100,550,570);
		CreateAcc.setBackground(new Color(0, 0, 0, 80));
		
        head= new JLabel("Doctor Details");
    	head.setBounds(200,20,200,30);
		head.setFont(new Font("Serif", Font.BOLD,30));
		head.setForeground(Color.white);
		l0 = new JLabel("User name");
		l0.setBounds(50,100, 200, 30);
		l0.setFont(new Font("Serif", Font.BOLD, 20));
		l0.setForeground(Color.white);
		l1 = new JLabel("Name");
		l1.setBounds(50, 150, 200, 30);
		l1.setFont(new Font("Serif", Font.BOLD, 20));
		l1.setForeground(Color.white);
		l2 = new JLabel("Specialist");
		l2.setBounds(50, 200, 200, 30);
		l2.setFont(new Font("Serif", Font.BOLD, 20));
		l2.setForeground(Color.white);
		l3 = new JLabel("Fees");
		l3.setBounds(50, 250, 200, 30);
		l3.setFont(new Font("Serif", Font.BOLD, 20));
		l3.setForeground(Color.white);
		l4 = new JLabel("Timing");
		l4.setBounds(50, 300, 200, 30);
		l4.setFont(new Font("Serif", Font.BOLD, 20));
		l4.setForeground(Color.white);
		l5 = new JLabel("E-Mail");
		l5.setBounds(50, 350, 200, 30);
		l5.setFont(new Font("Serif", Font.BOLD, 20));
		l5.setForeground(Color.white);
		l6 = new JLabel("Phone");
		l6.setBounds(50, 400, 200, 30);
		l6.setFont(new Font("Serif", Font.BOLD, 20));
		l6.setForeground(Color.white);
		l7 = new JLabel("Qualification");
		l7.setBounds(50, 450, 200, 30);
		l7.setFont(new Font("Serif", Font.BOLD, 20));
		l7.setForeground(Color.white);
		numerr = new JLabel();
		numerr.setBounds(250,420, 200, 30);
		numerr.setForeground(Color.red);
		feerror = new JLabel();
		feerror.setBounds(250,270, 200, 30);
		feerror.setForeground(Color.red);
		mailerror = new JLabel();
		mailerror.setBounds(250,370, 180, 36);
		mailerror.setForeground(Color.red);

		t0 = new JTextField();
		t0.setBounds(250,100, 200, 30);
		t0.setFont(new Font("Serif", Font.BOLD,20));
		t1 = new JTextField();
		t1.setBounds(250, 150, 200, 30);
		t1.setFont(new Font("Serif", Font.BOLD,20));
		t2 = new JTextField();
		t2.setBounds(250, 200, 200, 30);
		t2.setFont(new Font("Serif", Font.BOLD, 20));
		t3 = new JTextField();
		t3.setBounds(250, 250, 200, 30);
		t3.setFont(new Font("Serif", Font.BOLD, 20));
		t3.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				String fee = t3.getText();
				if (Pattern.matches("^[0-9]*$", fee)) {
					feerror.setVisible(false);
				} else {
					feerror.setText("*Enter in Numbers");
					feerror.setFont(new Font("Serif",Font.BOLD,14));
					feerror.setVisible(true);
				}
				repaint();
			}

		});
		t4 = new JTextField();
		t4.setBounds(250, 300, 200, 30);
		t4.setFont(new Font("Serif", Font.BOLD,20));
		t5 = new JTextField();
		t5.setBounds(250, 350, 200, 30);
		t5.setFont(new Font("Serif", Font.BOLD,20));
		t5.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				String mail = t5.getText();
				if (Pattern.matches("^(.+)@(.+)$", mail)) {
					mailerror.setVisible(false);
				} else {
					mailerror.setText("*Invalid e-mail");
					mailerror.setFont(new Font("Serif", Font.BOLD,14));
					mailerror.setVisible(true);
				}
				
				repaint();
			}

		});
		t6 = new JTextField();
		t6.setBounds(250, 400, 200, 30);
		t6.setFont(new Font("Serif", Font.BOLD,20));
		t6.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String str1 = t6.getText();
				if (Pattern.matches("^[6-9][0-9]{9}$", str1)) {
					numerr.setVisible(false);
				} else {

					numerr.setText("*Invalid number");
					numerr.setFont(new Font("Serif",Font.BOLD,14));

					numerr.setVisible(true);
				}
				repaint();
			}

		});
		t7 = new JTextField();
		t7.setBounds(250, 450, 200, 30);
		t7.setFont(new Font("Serif", Font.BOLD,20));

		b1 = new JButton("Cancel");
		b1.setFont(new Font("Serif", Font.BOLD, 20));
		b1.setBounds(90,500,100,40);
		b1.setForeground(Color.white);
		b1.setBackground(new Color(160, 182, 45));
	    b1.addActionListener(this);
	   
		b2 = new JButton("Add");
		b2.setFont(new Font("Serif", Font.BOLD, 20));
		b2.setBounds(320,500,100,40);
		b2.setForeground(Color.white);
		b2.setBackground(new Color(160, 182, 45));
		b2.addActionListener(this);
                  
		ImageIcon background_image2 = new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg2.jpg");
		Image img = background_image2.getImage();
		Image temp_img = img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		background_image2 = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image2, JLabel.CENTER);

		CreateAcc.add(head);
		CreateAcc.add(l0);
		CreateAcc.add(l1);
		CreateAcc.add(l2);
		CreateAcc.add(l3);
		CreateAcc.add(l4);
		CreateAcc.add(l5);
		CreateAcc.add(l6);
		CreateAcc.add(l7);
		CreateAcc.add(numerr);
		CreateAcc.add(feerror);
		CreateAcc.add(mailerror);
		CreateAcc.add(t0);
		CreateAcc.add(t1);
		CreateAcc.add(t2);
		CreateAcc.add(t3);
		CreateAcc.add(t4);
		CreateAcc.add(t5);
		CreateAcc.add(t6);
		CreateAcc.add(t7);
		CreateAcc.add(b1);
		CreateAcc.add(b2);

		background.add(CreateAcc);
		background.setBounds(0,0,1920, 1080);
		add(background);
		setTitle("Add Doctor details");
		setSize(1920, 1080);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) 
	{

		Object o=e.getSource();

        if(o==b2)
        {
        String s0=t0.getText();	
        String s1=t1.getText();
        String s2=t2.getText();
        String s3=t3.getText();
        String s4=t4.getText();
        String s5=t5.getText();
        String s6=t6.getText();
        String s7=t7.getText();
        JFrame f2=new JFrame();
        if((s0.length()==0)||(s1.length()==0)||(s2.length()==0)||(s3.length()==0)||(s4.length()==0)||(s5.length()==0)||(s6.length()==0)||(s7.length()==0))
            
        {
            JOptionPane.showMessageDialog(f2,"Enter All Details");
        }
        else
        {
        	try
            {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dbproject","skcet");
            Statement stmt=con.createStatement();
            String query="insert into Doctordetails values('"+s0+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
         
            stmt.executeUpdate(query);
            con.setAutoCommit(true);
            JOptionPane.showMessageDialog(this, "Registration Success!");
        	new AfterLogin();
        	dispose();

            }

            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
         }
       }
        if(o==b1)
        {
        	new AfterLogin();
        	dispose();
        }
	}


	public static void main(String arg[]) 
	{
		new AddDetails();
	}

}

package doctor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import administrator.Home;
public class AfterLogin extends JFrame implements ActionListener{
    JButton Add_Details,Update_Details,ViewDoctor,ViewAppointment,logout;
    Font font,font1;
    JPanel heading,DoctorMainPage;
    JLabel Welcome_msg;
    AfterLogin() 
    {
        font=new Font("Serif",Font.BOLD,20);
        font1=new Font("Serif",Font.BOLD,30);
        
		heading=new JPanel();
    	heading.setLayout(null);
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,1920, 100);
      
        Welcome_msg = new JLabel("WELCOME DOCTOR");
 	    Welcome_msg.setBounds(590,50,400,50);
	    Welcome_msg.setForeground(Color.WHITE);
	    Welcome_msg.setFont(font1);
	    heading.add(Welcome_msg);
	    
		logout = new JButton("Log out");
		logout.setFont(font);
		logout.setBounds(1200, 30, 100, 50);
		logout.setForeground(Color.WHITE);
		logout.setBackground(new Color(20, 110, 180));
		heading.add(logout);
    
        DoctorMainPage=new JPanel();
        DoctorMainPage.setLayout(null);
        DoctorMainPage.setSize(400,350);
        DoctorMainPage.setBounds(450,200,550,450);
        DoctorMainPage.setBackground(new Color(0,0,0,60));
       
        Add_Details=new JButton("Add Details");
        Add_Details.setFont(font);
        Add_Details.setBounds(50,50,450,50);
        Add_Details.setForeground(Color.WHITE);
        Add_Details.setBackground(new Color(20,110,180));
        DoctorMainPage.add(Add_Details);
       
        Update_Details=new JButton("Update Details");
        Update_Details.setFont(font);
        Update_Details.setBounds(50,150,450,50);
        Update_Details.setForeground(Color.WHITE);
        Update_Details.setBackground(new Color(20,110,180));
        DoctorMainPage.add(Update_Details);
       
        ViewDoctor=new JButton("View Doctor");
        ViewDoctor.setFont(font);
        ViewDoctor.setBounds(50,250,450,50);
        ViewDoctor.setForeground(Color.WHITE);
        ViewDoctor.setBackground(new Color(20,110,180));
        DoctorMainPage.add(ViewDoctor);
        
        ViewAppointment=new JButton("View Appointment");
        ViewAppointment.setFont(font);
        ViewAppointment.setBounds(50,350,450,50);
        ViewAppointment.setForeground(Color.WHITE);
        ViewAppointment.setBackground(new Color(20,110,180));
        DoctorMainPage.add(ViewAppointment);
       
        Add_Details.addActionListener(this);
        Update_Details.addActionListener(this);
        ViewDoctor.addActionListener(this);
        ViewAppointment.addActionListener(this);
        logout.addActionListener(this);
        
        ImageIcon background_image=new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0, 0, 1920, 1080);
        
        background.add(DoctorMainPage);
        background.add(heading);
       
        add(background);
        
        setTitle("Doctor Home page");
        setSize(1920,1080);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object obj_source=e.getSource();
        if(obj_source==Add_Details)
        {
           
                new AddDetails();
                dispose();
           
        }
        else if(obj_source==Update_Details)
        {
               new UpdateDetails();
               dispose();
        }
        if(obj_source==ViewDoctor)
        {
        	
            new ViewDoctor();
            dispose();
        	
        }
        if(obj_source==ViewAppointment)
        {
        	new ViewAppointment();
        	dispose();
        	
        }
        if(obj_source==logout)
        {
        	new Home();
        	dispose();
        }
       
     }

    public static void main(String[] args) 
    {
        new AfterLogin();
    }

      
}
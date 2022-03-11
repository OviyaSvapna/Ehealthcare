package patient;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

import administrator.Home;

public class PatientInterface extends JFrame implements ActionListener{
    JButton AddPatient,UpdatePatient,ViewDoctor,ViewHospital,logout;
    Font font,font1;
    JPanel heading,PatientMainPage;
    JLabel Welcome_msg;
    PatientInterface() 
    {
        font=new Font("Serif",Font.BOLD,20);
        font1=new Font("Serif",Font.BOLD,30);
        
		heading=new JPanel();
    	heading.setLayout(null);
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,1920, 100);
      
    	Welcome_msg = new JLabel("WELCOME");
		Welcome_msg.setBounds(650,50,400,50);
		Welcome_msg.setForeground(Color.WHITE);
		Welcome_msg.setFont(font1);
		heading.add(Welcome_msg);

        logout=new JButton("Log out");
        logout.setFont(font);
        logout.setBounds(1200,30,100,50);
        logout.setForeground(Color.WHITE);
        logout.setBackground(new Color(20,110,180));
        heading.add(logout);
    
        PatientMainPage=new JPanel();
        PatientMainPage.setLayout(null);
        PatientMainPage.setSize(400,350);
        PatientMainPage.setBounds(450,200,550,450);
        PatientMainPage.setBackground(new Color(0,0,0,60));
       
        AddPatient=new JButton("Add Patient");
        AddPatient.setFont(font);
        AddPatient.setBounds(50,50,450,50);
        AddPatient.setForeground(Color.WHITE);
        AddPatient.setBackground(new Color(20,110,180));
        PatientMainPage.add(AddPatient);
       
        UpdatePatient=new JButton("Update Patient");
        UpdatePatient.setFont(font);
        UpdatePatient.setBounds(50,150,450,50);
        UpdatePatient.setForeground(Color.WHITE);
        UpdatePatient.setBackground(new Color(20,110,180));
        PatientMainPage.add(UpdatePatient);
       
        ViewDoctor=new JButton("View Doctors \n and Add Appointment");
        ViewDoctor.setFont(font);
        ViewDoctor.setBounds(50,250,450,50);
        ViewDoctor.setForeground(Color.WHITE);
        ViewDoctor.setBackground(new Color(20,110,180));
        PatientMainPage.add(ViewDoctor);
        
        ViewHospital=new JButton("View Hospital");
        ViewHospital.setFont(font);
        ViewHospital.setBounds(50,350,450,50);
        ViewHospital.setForeground(Color.WHITE);
        ViewHospital.setBackground(new Color(20,110,180));
        PatientMainPage.add(ViewHospital);
       
        AddPatient.addActionListener(this);
        UpdatePatient.addActionListener(this);
        ViewDoctor.addActionListener(this);
        ViewHospital.addActionListener(this);
        logout.addActionListener(this);
        
        ImageIcon background_image=new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\ehealthcare.jfif");
        Image img=background_image.getImage();
        Image temp_img=img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0, 0, 1920, 1080);
        
        background.add(PatientMainPage);
        background.add(heading);
    	background.setBounds(0, 0, 1920, 1080);
        add(background);
        
        setTitle("Patient Home Page");
        setSize(1920,1080);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object obj_source=e.getSource();
        if(obj_source==AddPatient)
        {
   
              AddPatient obj=new AddPatient();
              dispose();
           
        }
        if(obj_source==UpdatePatient)
        {
               new UpdatePatient();
               dispose();
        }
        if(obj_source==ViewDoctor)
        {
        	    new ViewDoctor();
        	    dispose();
        }
        if(obj_source==ViewHospital)
        {
        	    new ViewHospital();
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
        new PatientInterface();
    }

      
}



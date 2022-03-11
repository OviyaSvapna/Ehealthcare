package hospital;

import java.awt.Container;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.awt.*;

public class AddHospital extends JFrame implements ActionListener//,ItemListener 
{
    JLabel l_addh,l_hospitalname,l_hospitalid,l_address,l_bedavailability,l_category,l_city,l_phno,l_email,l_ehn,l_ef,l_ba,l_epn,l_eem,pherror,emailerror;
    JTextField t_hospitalid,t_facility,t_hospitalname,t_phno,t_email,t_bedavailability,t_address;
    ButtonGroup bgroup;
    JComboBox jcb_city;
    JComboBox jcb_category;
    JButton jbtn_submit,cancel;
    Font f1,headf,f2;
    ImageIcon img;
    
    public AddHospital()
    {
       
        JPanel container=new JPanel();
        container.setLayout(null);
        container.setBounds(450,100,550,580);
        container.setBackground(new Color(0,0,0,80));
       
        l_hospitalid=new JLabel("Hospital Id");
        l_hospitalname=new JLabel("Hospital Name");
        l_ehn=new JLabel();
        l_ba=new JLabel();
        l_eem=new JLabel();
        l_epn=new JLabel();
        l_category=new JLabel("Category");
        l_bedavailability=new JLabel("Bed Available");
        l_city=new JLabel("City");
        l_phno=new JLabel("Phone");
        l_email=new JLabel("Email");
        l_address=new JLabel("Address");
        pherror=new JLabel();
        emailerror=new JLabel();
        l_addh=new JLabel("ADD HOSPITAL");
       
        t_hospitalid=new JTextField();
        t_facility=new JTextField();
        t_hospitalname=new JTextField();
        t_bedavailability=new JTextField();
        t_phno=new JTextField();
        t_email=new JTextField();
        t_address=new JTextField();

        bgroup=new ButtonGroup();
        jcb_city=new JComboBox();
        jcb_category=new JComboBox();
        jbtn_submit=new JButton("Add");
        cancel=new JButton("Cancel");
        
        
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
        jcb_city.addItem("Madurai");
        jcb_city.addItem("Namakkal");
        jcb_city.addItem("Nilgiris");
        jcb_city.addItem("Pudukkoti");
        jcb_city.addItem("Ramanathapuram");
        jcb_city.addItem("Salem");
        jcb_city.addItem("Trichirappali");
        jcb_city.addItem("Thoothukudi");
        jcb_city.addItem("Vellor");
        jcb_city.addItem("Others");
       
       
        jcb_category=new JComboBox();
        jcb_category.addItem("");
        jcb_category.addItem("General Hospital");
        jcb_category.addItem("Speciality Hospital");
        jcb_category.addItem("Surgical Hospital");
        jcb_category.addItem("Womencare");
        jcb_category.addItem("Pediatrician");
        jcb_category.addItem("Orthopaedic");
        jcb_category.addItem("Cardiac Hospital");
       
        f1=new Font("Serif",Font.BOLD,20);
        f2=new Font("Serif",Font.BOLD,14);
        headf=new Font("Serif",Font.BOLD,30);
       
        //fontlable
        l_hospitalid.setFont(f1);
        l_hospitalname.setFont(f1);
        l_category.setFont(f1);
        l_bedavailability.setFont(f1);
        l_city.setFont(f1);
        l_phno.setFont(f1);
        l_email.setFont(f1);
        l_address.setFont(f1);
        pherror.setFont(f2);
        emailerror.setFont(f2);
        l_addh.setFont(headf);
       
        //fonttext
        t_hospitalid.setFont(f1);
        t_facility.setFont(f1);
        t_hospitalname.setFont(f1);
        t_bedavailability.setFont(f1);
        t_phno.setFont(f1);
        t_email.setFont(f1);
        t_address.setFont(f1);
       
        //fontcombo
        jcb_city.setFont(f1);
        jcb_category.setFont(f1);
        
        jbtn_submit.setFont(f1);
        cancel.setFont(f1);
        
        l_addh.setBounds(170,40,350, 25);
        
        l_hospitalid.setBounds(50,100,200,30);
        l_hospitalname.setBounds(50, 150,200, 25);
        l_category.setBounds(50,200, 120, 25);
        l_city.setBounds(50, 250, 120, 25);
        l_address.setBounds(50,300, 120, 25);
        l_bedavailability.setBounds(50,350, 220, 25);
        l_phno.setBounds(50,400, 120, 25);
        l_email.setBounds(50,450, 120, 25);

        cancel.setBounds(100,530,100,40);
        jbtn_submit.setBounds(300,530,100,40);
        
        t_hospitalid.setBounds(250,100,200,30);
        t_hospitalname.setBounds(250,150,200,30);
        jcb_category.setBounds(250,200,200,30);
        jcb_city.setBounds(250,250,200,30);
        t_address.setBounds(250,300,200,30);
        t_bedavailability.setBounds(250,350,200,30);
        t_phno.setBounds(250,400,200,30);
        pherror.setBounds(250,420,200,30);
        t_email.setBounds(250,450,200,30);
        emailerror.setBounds(250,470,200,30);
        
        pherror.setFont(f2);
        emailerror.setFont(f2);
        
        //color
        l_hospitalid.setForeground(Color.WHITE);
        l_hospitalname.setForeground(Color.WHITE);
        l_category.setForeground(Color.WHITE);
        l_bedavailability.setForeground(Color.WHITE);
        l_city.setForeground(Color.WHITE);
        l_phno.setForeground(Color.WHITE);
        l_email.setForeground(Color.WHITE);
        l_address.setForeground(Color.WHITE);
        jbtn_submit.setForeground(Color.WHITE);
        cancel.setForeground(Color.WHITE);
        jcb_city.setForeground(Color.BLACK);
        jcb_category.setForeground(Color.BLACK);
        l_addh.setForeground(Color.WHITE);
        pherror.setForeground(Color.RED);
        emailerror.setForeground(Color.RED);
       
        jbtn_submit.setBackground(new Color(160,182,45));
        cancel.setBackground(new Color(160,182,45));
        
        jbtn_submit.addActionListener(this);
        cancel.addActionListener(this);

        t_phno.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String phno=t_phno.getText();
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


		t_email.addKeyListener(new KeyListener()
    	{
    	@Override
    	public void keyPressed(KeyEvent arg0){}

    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		String email=t_email.getText();
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

        //bgimg
       
        ImageIcon background_image2=new ImageIcon("C:\\Users\\Welcome\\Pictures\\bootathon\\bg2.jpg");
        Image img=background_image2.getImage();
        Image temp_img=img.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image2=new ImageIcon(temp_img);
        JLabel background=new JLabel("",background_image2,JLabel.CENTER);
       
        container.add(l_hospitalid);
        container.add(l_bedavailability);
        container.add(l_hospitalname);
        container.add(l_category);
        container.add(l_address);
        container.add(l_city);
        container.add(l_phno);
        container.add(l_email);
        container.add(pherror);
        container.add(emailerror);
        container.add(l_addh);
        
        container.add(jbtn_submit);
        container.add(cancel);

        container.add(t_hospitalid);
        container.add(t_hospitalname);
        container.add(t_bedavailability);
        container.add(jcb_category);
        container.add(t_address);
        container.add(jcb_city);
        container.add(t_phno);
        container.add(t_email);
       
        background.add(container);
        background.setBounds(0, 0, 1920, 1080);
        add(background);

        setTitle("Hospital Details");
        setSize(1920,1080);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){

        Object obj_source=ae.getSource();

        if(obj_source==jbtn_submit){

            try{
              
                String  hospitalid=t_hospitalid.getText();
                String hospitalname=t_hospitalname.getText();
                String address=t_address.getText();
                String category=jcb_category.getSelectedItem().toString();
                String bedavailability=t_bedavailability.getText();
                String city=jcb_city.getSelectedItem().toString();
                String phno=t_phno.getText();
                String email=t_email.getText();
 
                   Class.forName("oracle.jdbc.driver.OracleDriver");
                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","dbproject","skcet");
                   Statement stmt=con.createStatement();
                   String query="insert into Hospital_Details values("+hospitalid+",'"+hospitalname+"','"+category+"','"+city+"','"+address+"',"+bedavailability+","+phno+",'"+email+"')";

                   stmt.executeUpdate(query);
                   con.setAutoCommit(true);
                   JOptionPane.showMessageDialog(this, "Registration Success!");
                   new HospitalInterface();
                   dispose();
                   
                }
              
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex.toString());
            }

        }
        if(obj_source==cancel)
        {
        	new HospitalInterface();
        	dispose();
        }
    }
     public static void main(String[] args) {
        new AddHospital();
    }

}


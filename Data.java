package patient;

import java.io.Serializable;

public class Data implements Serializable 
{
	   String First_name=null;
       String Last_name=null;
       String User_name=null;
       String Password=null;
       String ConPass=null;
       String Email=null;
       public Data(String First_name,String Last_name,String User_name,String Password,String ConPass,String Email)
       {
    	   this.First_name=null;
           this.Last_name=null;
           this.User_name=null;
           this.Password=null;
           this.ConPass=null;
           this.Email=null;
    	   
       }
       public String getFirst_name() 
       {
   		return First_name;
   	   }


   	   public String getLast_name() 
   	   {
   		return Last_name;
   	   }


   	   public String getUser_name() 
   	   {
   		return User_name;
   	   }


   	   public String getPassword()
   	   {
   		return Password;
   	   }


   	   public String getConPass()
   	   {
   		return ConPass;
   	   }


   	   public String getEmail()
   	   {
   		return Email;
   	  }

}

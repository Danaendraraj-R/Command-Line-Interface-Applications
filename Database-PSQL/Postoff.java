import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom; 
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;


public class Postoff
{
static void Admin()
{
Scanner sc=new Scanner(System.in);
int opt1;
System.out.println("Enter an option");
System.out.println("1-Add Post Office");
System.out.println("2-Update Post Office");
System.out.println("3-Delete Post Office");
System.out.println("4-View Post Office");
System.out.println("5-Return Back to MainDashboard");
opt1=sc.nextInt();
switch(opt1)
{
   case 1:
      AddPO();
      break;
   case 2:
      UpdatePO();
      break;
   case 3:
      DeletePO();
      break;
   case 4:
      ViewPO();
      break;
   case 5:
      MainDashboard();
      break;
   default:
      System.out.println("Invalid Option");
      Admin();
}
}
static void SendPost()
{
int Cfm,Unum;
SndPODB a=new SndPODB();
Scanner sc=new Scanner(System.in);
System.out.print("Enter Sender Name:");
a.SPODet[0][0]=sc.nextLine();
System.out.print("Enter Sender Address:");
a.SPODet[0][1]=sc.nextLine();
System.out.print("Enter Sender Pincode:");
a.SPODet[0][2]=sc.nextLine();
System.out.print("Enter Sender Contact Number:");
a.SPODet[0][3]=sc.nextLine();
System.out.print("Enter Reciever Name:");
a.SPODet[0][4]=sc.nextLine();
System.out.print("Enter Reciever Address:");
a.SPODet[0][5]=sc.nextLine();
System.out.print("Enter Reciever Pincode:");
a.SPODet[0][6]=sc.nextLine();
System.out.print("Enter Reciever Contact Number:");
a.SPODet[0][7]=sc.nextLine();
System.out.print("Enter your msg:");
a.Msg=sc.nextLine();
System.out.print("Enter 1 to send the post");
Cfm=sc.nextInt();
if(Cfm==1)
{
System.out.println("Post Sent Successfully");
Unum=ThreadLocalRandom.current().nextInt(1000000,5000000);
a.SPODet[0][8]=String.valueOf(Unum);
DisplayPOD();
}
}
static void SendPost1(String Name,String Address,String Pincode,String Phonenumber)
{
int Cfm,Unum;

SndPODB a=new SndPODB();
UserDB c=new UserDB();
Scanner sc=new Scanner(System.in);
a.SPODet[0][0]=Name;
a.SPODet[0][1]=Address;
a.SPODet[0][2]=Pincode;
a.SPODet[0][3]=Phonenumber;
System.out.print("Enter Reciever Name:");
a.SPODet[0][4]=sc.nextLine();
System.out.print("Enter Reciever Address:");
a.SPODet[0][5]=sc.nextLine();
System.out.print("Enter Reciever Pincode:");
a.SPODet[0][6]=sc.nextLine();
System.out.print("Enter Reciever Contact Number:");
a.SPODet[0][7]=sc.nextLine();
System.out.print("Enter your msg:");
a.Msg=sc.nextLine();
System.out.print("Enter 1 to send the post");
Cfm=sc.nextInt();
if(Cfm==1)
{
System.out.println("Post Sent Successfully");
Unum=ThreadLocalRandom.current().nextInt(1000000,5000000);
a.SPODet[0][8]=String.valueOf(Unum);
DisplayPOD();
System.out.println("Redirecting to User Dashboard");
UserDashboard(Name,Address,Pincode,Phonenumber);
}
}
static void AddPO()
{
 Boolean y=true;
 Date date = Calendar.getInstance().getTime(); 
 String a,b,c,d,e,f,g; 
 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
 while(y)
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Unique ID:");
 a=sc.nextLine();
 System.out.print("Enter POName:");
 b=sc.nextLine();
 System.out.print("Enter Address:");
 c=sc.nextLine();
 System.out.print("Enter Pincode:");
 d=sc.nextLine();
 System.out.print("Enter City:");
 e=sc.nextLine();
 System.out.print("Enter State:");
 f=sc.nextLine();
 System.out.print("Enter Telephone:");
 g=sc.nextLine();
 Date h = Calendar.getInstance().getTime();
 Date i = Calendar.getInstance().getTime();
 Connection conn = null;
 Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         conn.setAutoCommit(false);
         stmt = conn.createStatement();
         String sql = "INSERT INTO PODetails (UNIQUEID,PONAME,ADDRESS,PINCODE,CITY,STATE,TELEPHONE,CREATEDTIME,MODIFIEDTIME) "
            + "VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"');";
         stmt.executeUpdate(sql);
         stmt.close();
         conn.commit();
         conn.close();
      } catch (Exception x) {
         System.err.println( x.getClass().getName()+": "+ x.getMessage() );
         System.out.println(x);
         System.exit(0);
      }
System.out.println("Post Office Updated Successfully");

 System.out.println("Would you like to add another PO");
 System.out.println("1 for Yes/0 for No");
 int n=sc.nextInt();
 switch(n)
 {
    case 1:
       y=true;
       break;
    case 0:
       y=false;
       break;
 }
} 
 ViewPO();
 System.out.println("Redirecting to Admin Dashboard");
Admin();
}
static void UpdatePO()
{
      Connection c = null;
      Statement stmt = null;
      Scanner sc=new Scanner(System.in);
      Scanner s=new Scanner(System.in);
      String str,newstr;
      int n;
      String dt;
      DateFormat dateformat=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
      PreparedStatement sql,sql1;
      Date date = Calendar.getInstance().getTime();  
      try {
	 Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         c.setAutoCommit(false);
	 System.out.println("Enter the UNIQUEID of the PO to be updated:");
         str=sc.nextLine();
         System.out.println("Enter an Option:");
         System.out.println("1-UniqueID");
 	 System.out.println("2-POName");
 	 System.out.println("3-Location");
         System.out.println("4-PinCode");
 	 System.out.println("5-City");
	 System.out.println("6-State");
	 System.out.println("7-Telephone");
	 n=sc.nextInt(); 
	 System.out.println("Enter the new data:");
	 newstr=s.nextLine(); 
	 switch(n)
         {
	 case 1:
         sql=c.prepareStatement("UPDATE PODETAILS SET UNIQUEID = ? WHERE UNIQUEID = ?;");			
	 sql.setString(1,newstr);
	 sql.setString(3,str);
         sql.executeUpdate();
	 break;
	 case 2:
         sql=c.prepareStatement("UPDATE PODETAILS SET PONAME = ? WHERE UNIQUEID = ?;");		
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 case 3:
         sql=c.prepareStatement("UPDATE PODETAILS SET LOCATION = ? WHERE UNIQUEID = ?;");			
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 case 4:
         sql=c.prepareStatement("UPDATE PODETAILS SET PINCODE = ? WHERE UNIQUEID = ?;");		
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 case 5:
         sql=c.prepareStatement("UPDATE PODETAILS SET CITY = ? WHERE UNIQUEID = ?;");			
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 case 6:
         sql=c.prepareStatement("UPDATE PODETAILS SET STATE = ? WHERE UNIQUEID = ?;");			
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 case 7:
         sql=c.prepareStatement("UPDATE PODETAILS SET TELEPHONE = ? WHERE UNIQUEID = ?;");		
	 sql.setString(1,newstr);
	 sql.setString(2,str);
         sql.executeUpdate();
	 break;
	 default:
         System.out.println("No Update have been taken place");
         }; 
	 sql1=c.prepareStatement("UPDATE PODETAILS SET MODIFIEDTIME = ? WHERE UNIQUEID = ?;");
         dt=dateformat.format(date);
	 sql1.setString(1,dt);	
	 sql1.setString(2,str);
         sql1.executeUpdate();
         c.commit();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
ViewPO();
System.out.println("Redirecting to Admin Dashboard");
Admin();
}
static void DeletePO()
{
      Connection c = null;
      Statement stmt = null;
      String str;
      PreparedStatement sql;
      Scanner sc=new Scanner(System.in);
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         c.setAutoCommit(false);
         stmt = c.createStatement();
         System.out.println("Enter the UNIQUE ID of the PO to be Deleted");
         str=sc.nextLine();
         sql=c.prepareStatement("DELETE from PODETAILS where UNIQUEID = ?;");			
	 sql.setString(1,str);
         sql.executeUpdate();
         c.commit();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
   System.out.println("Deleted Successfully");
   ViewPO();
   System.out.println("Returning Back to Admin Dashboard");
   Admin();
}
static void ViewPO()
{
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         c.setAutoCommit(false);
	
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
         stmt = c.createStatement();
	 System.out.println("UNIQUEID| PONAME |     ADDRESS |    PINCODE|    CITY|      STATE|     TELEPHONE|       CREATEDTIME|       MODIFIEDTIME");
         ResultSet rs = stmt.executeQuery( "SELECT * FROM PODETAILS;" );
         while ( rs.next() ) {
            String uniqueid = rs.getString("uniqueid");
            String poname = rs.getString("poname");
            String address  = rs.getString("address");
            int pincode = rs.getInt("pincode");
	    String city  = rs.getString("city");
 	    String state  = rs.getString("state");
 	    String telephone  = rs.getString("telephone");
	    String createdtime=rs.getString("createdtime");
	    String modifiedtime=rs.getString("modifiedtime");
            System.out.println(uniqueid+"|      "+poname+"|   "+address+"| "+pincode+"| "+city+"| "+state+"| "+telephone+"| "+createdtime+"| "+modifiedtime);
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
System.out.println("Redirecting to Admin Dashboard");
Admin();
}
static void UserDashboard(String Name,String Address,String Pincode,String Phonenumber)
{
 int opt;
 SndPODB a=new SndPODB();
 System.out.println("Welcome to User Dashboard");
 System.out.println("Enter 1 to Send a post with registered details");
 System.out.println("Enter 2 to Send a post with manual details");
 System.out.println("Enter 3 to Logout");
 Scanner sc=new Scanner(System.in);
 opt=sc.nextInt();
 switch(opt)
 {
 case 1:
 SendPost1(Name,Address,Pincode,Phonenumber);
 break;
 case 2:
 SendPost();
 break;
 case 3:
 Login();
 break;
 default:
 System.out.println("Enter a valid value");
 Login();
 }
}
static void Login()
{
      Connection c = null;
      Statement stmt = null;
      PreparedStatement sql;
      String Username,Password;
      int flag=0;
      String Name="null",Address="null",Pincode="null",Phonenumber="null";
      Scanner sc=new Scanner(System.in);
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         c.setAutoCommit(false);
	 System.out.println("Enter Username:");
         Username=sc.nextLine();
	 System.out.println("Enter Password:");
         Password=sc.nextLine();
         stmt = c.createStatement();
         sql=c.prepareStatement("SELECT * FROM USERDETAILS where USERID=? and PASSWORD=?");			
	 sql.setString(1,Username);
	 sql.setString(2,Password);
         c.commit();
         ResultSet rs = sql.executeQuery();
         while ( rs.next() )
        {
            Name = rs.getString("name");
            Address = rs.getString("address");
            Pincode = rs.getString("pincode");
            Phonenumber = rs.getString("phonenumber");
            flag=1;
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
if(flag==1)
{
System.out.println("Login Successfull...");
System.out.println("Redirecting to UserDashboard");
UserDashboard(Name,Address,Pincode,Phonenumber);
}
else
{    System.out.println("Login Failed");
     System.out.println("Press 1 to retry");
     int ret=sc.nextInt();
     if(ret==1)
     Login();
}
}
static void Register()
{ 
 String Username,Password,Name,Address,Pincode,Phonenumber; 
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Username:");
 Username=sc.nextLine();
 System.out.print("Enter Password:");
 Password=sc.nextLine();
 System.out.print("Enter Name:");
 Name=sc.nextLine();
 System.out.print("Enter Address:");
 Address=sc.nextLine();
 System.out.print("Enter Pincode:");
 Pincode=sc.nextLine();
 System.out.print("Enter PhoneNumber:");
 Phonenumber=sc.nextLine();
 Connection conn = null;
 Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         conn.setAutoCommit(false);
         stmt = conn.createStatement();
         String sql = "INSERT INTO UserDetails (USERID,PASSWORD,NAME,ADDRESS,PINCODE,PHONENUMBER) " 
            + "VALUES ('"+Username+"','"+Password+"','"+Name+"','"+Address+"','"+Pincode+"','"+Phonenumber+"');";
         stmt.executeUpdate(sql);
         stmt.close();
         conn.commit();
         conn.close();
      } catch (Exception x) {
         System.err.println( x.getClass().getName()+": "+ x.getMessage() );
         System.out.println(x);
         System.exit(0);
      }
 
 System.out.println("User Details Updated Successfully");
 System.out.println("Redirecting to Login");
 Login();
}
static void User()
{
Scanner sc=new Scanner(System.in);
int opt2;
System.out.println("Enter an option");
System.out.println("0- Login");
System.out.println("1- Register");
opt2=sc.nextInt();
switch(opt2)
{
case 0:
   Login();
   break;
case 1:
   Register();
   break;
default:
   System.out.println("Invalid Option");
   User();
}
}
static int Price(String a,String b)
{
  int min;
  int snd=Integer.parseInt(a);
  int rvr=Integer.parseInt(b);
  if(snd>rvr)
  min=snd-rvr;
  else
  min=rvr-snd;
  if(min<200)
   return 50;
  else if(min==200||min<500)
   return 100;
  else
   return 150;
}

static void DisplayPOD()
{
SndPODB a=new SndPODB();
System.out.println("Sender Name:"+a.SPODet[0][0]);
System.out.println("Sender Address:"+a.SPODet[0][1]);
System.out.println("Sender Pincode:"+a.SPODet[0][2]);
System.out.println("Sender Contact Number:"+a.SPODet[0][3]);
System.out.println("Reciever Name:"+a.SPODet[0][4]);
System.out.println("Reciever Address:"+a.SPODet[0][5]);
System.out.println("Reciever Pincode:"+a.SPODet[0][6]);
System.out.println("Reciever Contact Number:"+a.SPODet[0][7]);
System.out.println("Consignment Number:"+a.SPODet[0][8]);
System.out.println("Price:"+Price(a.SPODet[0][2],a.SPODet[0][6])+"ruppees");
Connection conn = null;
 Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/library",
            "postgres", "Rajdr039*");
         conn.setAutoCommit(false);
         stmt = conn.createStatement();
         String sql = "INSERT INTO POSTDETAILS (SENDERNAME,SENDERADDRESS,SENDERPINCODE,SENDERPHONENUMBER,RECIEVERNAME,RECIEVERADDRESS,RECIEVERPINCODE,RECIEVERPHONENUMBER,CONSIGNMENTNO,PRICE)"
            + "VALUES ('"+a.SPODet[0][0]+"','"+a.SPODet[0][1]+"','"+a.SPODet[0][2]+"','"+a.SPODet[0][3]+"','"+a.SPODet[0][4]+"','"+a.SPODet[0][5]+"','"+a.SPODet[0][6]+"','"+a.SPODet[0][7]+"','"+a.SPODet[0][8]+"','"+Price(a.SPODet[0][2],a.SPODet[0][6])+"');";
         stmt.executeUpdate(sql);
         stmt.close();
         conn.commit();
         conn.close();
      } catch (Exception x) {
         System.err.println( x.getClass().getName()+": "+ x.getMessage() );
         System.out.println(x);
         System.exit(0);
      }

try
{
int Fn=1;
FileWriter fw = new FileWriter("Person" + Fn + ".txt");
BufferedWriter writer = new BufferedWriter(fw);
for(int i = 0; i<9; i++)
{
 writer.write(a.SPODet[0][i]);
 writer.newLine();
}
writer.flush();
Fn++;
}
catch(Exception e)
{
System.out.println("An error occured");
}
}
static void MainDashboard()
{
int op;
int n;
Scanner sc=new Scanner(System.in);
System.out.println("Enter 1 for Admin or 0 for User");    
op=sc.nextInt();
if(op==1)
Admin();
else if(op==0)
User();
else
System.out.println("Enter a value 0 or 1");	
}

public static void main(String args[])  
{
 MainDashboard();
}
}
class SndPODB
{
public static String[][] SPODet=new String[1][9];
public static String Msg;
}
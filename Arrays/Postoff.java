import java.util.Scanner;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom; 
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 
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
static void SendPost1(int n)
{
int Cfm,Unum;

SndPODB a=new SndPODB();
UserDB c=new UserDB();
Scanner sc=new Scanner(System.in);
a.SPODet[0][0]=c.UserPf[n][0];
a.SPODet[0][1]=c.UserPf[n][1];
a.SPODet[0][2]=c.UserPf[n][2];
a.SPODet[0][3]=c.UserPf[n][3];
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
static void AddPO()
{
 Boolean j=true;
 PODB b=new PODB();
 Date date = Calendar.getInstance().getTime();  
 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
 while(j)
 {
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter Name:");
 b.PODet[b.N][0]=sc.nextLine();
 System.out.print("Enter Location:");
 b.PODet[b.N][1]=sc.nextLine();
 System.out.print("Enter Pincode:");
 b.PODet[b.N][2]=sc.nextLine();
 System.out.print("Enter City:");
 b.PODet[b.N][3]=sc.nextLine();
 System.out.print("Enter State:");
 b.PODet[b.N][4]=sc.nextLine();
 System.out.print("Enter Telephone:");
 b.PODet[b.N][5]=sc.nextLine();
 System.out.print("Enter Unique Code:");
 b.PODet[b.N][6]=sc.nextLine();
 b.PODet[b.N][7]=dateFormat.format(date);
 b.PODet[b.N][8]=dateFormat.format(date);
 b.N++;
 System.out.println("\033[H\033[2J");
 System.out.println("Post Office Updated Successfully");
 System.out.println("Would you like to add another PO");
 System.out.println("1 for Yes/0 for No");
 int n=sc.nextInt();
 switch(n)
 {
    case 1:
       j=true;
       break;
    case 0:
       j=false;
       break;
 }
 }
 ViewPO();
 System.out.println("Redirecting to Admin Dashboard");
 Admin();
}
static void UpdatePO()
{
 ViewPO();
 String temp1,temp2;
 PODB b=new PODB();
 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
 Date date = new Date();
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the Data to be replaced");
 temp1=sc.nextLine();
 System.out.println("Enter the Replacing Data");
 temp2=sc.nextLine();
  for(int i=0;i<b.N;i++)
 {
   for(int j=0;j<7;j++)
   {
   if(b.PODet[i][j].matches(temp1))
   {
   b.PODet[i][j]=temp2;
   b.PODet[i][8]=dateFormat.format(date);
   }
   }
 }
  System.out.println("Updated Succesfully");
  ViewPO();
 System.out.println("Redirecting to Admin Dashboard");
 Admin();
}
static void DeletePO()
{
  PODB b=new PODB();
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the array index to be deleted");
   int index=sc.nextInt();
   for (int i = index; i<b.N; i++)
   {
    for(int j=0;j<7;j++)
    {
    b.PODet[i][j] = b.PODet[i + 1][j];
    }
   }
   System.out.println("DELETED SUCESSFULLY");
   b.N--; 
   ViewPO();
   System.out.println("Returning Back to Admin Dashboard");
   Admin();
}
static void ViewPO()
{
    PODB b=new PODB();
   int i,j;
   for(i=0;i<b.N;i++)
   {
   for(j=0;j<9;j++)
   {
      System.out.printf("%s\t",b.PODet[i][j]);
   }
      System.out.println();
   }
}
static void UserDashboard(int num)
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
 SendPost1(num);
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
 String temp1,temp2;
 Scanner sc=new Scanner(System.in);
 UserDB a=new UserDB();
 System.out.print("Enter Username:");
 temp1=sc.nextLine();
 System.out.print("Enter Password:");
 temp2=sc.nextLine();
 for(int i=0;i<a.N;i++)
 {
  if((a.UserDet[i][0].matches(temp1))&& (a.UserDet[i][1].matches(temp2)))
  {
   System.out.println("Login Successfull");
   UserDashboard(i);
  }
  else
  {
     System.out.println("Login Failed");
     System.out.println("Press 1 to retry");
     int ret=sc.nextInt();
     if(ret==1)
     Login();
  }
}
}
static void Register()
{
 Scanner sc=new Scanner(System.in);
 UserDB a=new UserDB();
 System.out.print("Enter Username:");
 a.UserDet[a.N][0]=sc.nextLine();
 System.out.print("Enter Password:");
 a.UserDet[a.N][1]=sc.nextLine();
 System.out.println("Enter your Name:");
 a.UserPf[a.N][0]=sc.nextLine();
 System.out.println("Enter your Adddress:");
 a.UserPf[a.N][1]=sc.nextLine();
 System.out.println("Enter your Pincode:");
 a.UserPf[a.N][2]=sc.nextLine();
 System.out.println("Enter your Phone Number:");
 a.UserPf[a.N][3]=sc.nextLine();
 System.out.println("\u001b[2J");
 System.out.println("Registered Successfully");
 System.out.println("Your Name:"+a.UserPf[a.N][0]);
 System.out.println("Your Adddress:"+a.UserPf[a.N][1]);
 System.out.println("Your Pincode:"+a.UserPf[a.N][2]);
 System.out.println("Your Phone Number:"+a.UserPf[a.N][3]);
 System.out.println("Redirecting to Login");
 a.N++;
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
class UserDB
{
public static String[][] UserDet=new String[20][2];
public static String[][] UserPf=new String[20][4];
public static int N=0;
}
class PODB
{
public static String[][] PODet=new String[10][9];
public static int N=0; 
}
class SndPODB
{
public static String[][] SPODet=new String[1][9];
public static String[][] DestDet=new String[1][3];
public static String Msg;
}
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
b.PODet[b.N][0]=String.valueOf(b.N);
 System.out.print("Enter Name:");
 b.PODet[b.N][1]=sc.nextLine();
 System.out.print("Enter Location:");
 b.PODet[b.N][2]=sc.nextLine();
 System.out.print("Enter Pincode:");
 b.PODet[b.N][3]=sc.nextLine();
 System.out.print("Enter City:");
 b.PODet[b.N][4]=sc.nextLine();
 System.out.print("Enter State:");
 b.PODet[b.N][5]=sc.nextLine();
 System.out.print("Enter Telephone:");
 b.PODet[b.N][6]=sc.nextLine();
 System.out.print("Enter Unique Code:");
 b.PODet[b.N][7]=sc.nextLine();
 b.PODet[b.N][8]=dateFormat.format(date);
 b.PODet[b.N][9]=dateFormat.format(date);
 System.out.println("\033[H\033[2J");
System.out.println("Post Office Updated Successfully");
try
{ 
 BufferedWriter writer = new BufferedWriter(new FileWriter("PODet.txt", true));
 for(int i = 0; i<10; i++)
 {
 writer.write(b.PODet[b.N][i]);
 writer.newLine();
}
writer.flush();
}
catch(Exception e)
{
System.out.println("An error occured");
}
b.N++;
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
 int temp1,temp2;
 String temp3;
 PODB b=new PODB();
 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
 Date date = new Date();
int flag=0;
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the Replacing data:");
 temp3=sc.nextLine();
 System.out.println("Enter the PO Number to be Edited:");
 temp1=sc.nextInt();
 System.out.println("Enter an Option");
 System.out.println("1-PO Name");
 System.out.println("2-Location");
 System.out.println("3-PinCode");
 System.out.println("4-City");
 System.out.println("5-State");
 System.out.println("6-Telephone");
 System.out.println("7-Unique Code");
 temp2=sc.nextInt();
 System.out.print("Current data:");
 System.out.println(b.PODet[temp1][temp2]);
 b.PODet[temp1][temp2]=temp3;
 b.PODet[temp1][9]=dateFormat.format(date);
 System.out.println("Updated Succesfully");
 try
{ 
 BufferedWriter writer = new BufferedWriter(new FileWriter("PODet.txt", false));
 for(int i= 0; i<b.N; i++)
 {
 for(int j=1;j<10;j++)
{
 String temp=b.PODet[i][j];
 writer.write(temp);
 writer.newLine();
}
}
writer.flush();
}
catch(Exception e)
{
System.out.println("An error occured");
System.out.println(e);
}
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
    try
{ 
 BufferedWriter writer = new BufferedWriter(new FileWriter("PODet.txt", false));
 for(int i= 0; i<b.N; i++)
 {
 for(int j=0;j<9;j++)
{
 String temp=b.PODet[i][j];
 writer.write(temp);
 writer.newLine();
}
}
writer.flush();
}
catch(Exception e)
{
System.out.println("An error occured");
System.out.println(e);
}
 
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
   for(j=0;j<10;j++)
   {
      System.out.printf("%s\t",b.PODet[i][j]);
   }
      System.out.println();
   }
System.out.println("Redirecting to Admin Dashboard");
Admin();
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
 int flag=0;
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
   flag=1;
   UserDashboard(i);
  }
}
if(flag==0)
{    System.out.println("Login Failed");
     System.out.println("Press 1 to retry");
     int ret=sc.nextInt();
     if(ret==1)
     Login();
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
 try
{ 
 BufferedWriter writer = new BufferedWriter(new FileWriter("UserDet.txt", true));
 for(int i = 0;i<2; i++)
{
 writer.write(a.UserDet[a.N][i]);
 writer.newLine();
}
writer.flush();
}
catch(Exception e)
{
System.out.println("An error occured");
}
try
{ 
BufferedWriter writer = new BufferedWriter(new FileWriter("UserPf.txt", true));
for(int i = 0; i<4; i++)
{
 writer.write(a.UserPf[a.N][i]);
 writer.newLine();
}
writer.flush();
}
catch(Exception e)
{
System.out.println("An error occured");
}

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
public static void getPO() throws Exception
{
PODB b=new PODB();
BufferedReader reader = new BufferedReader(new FileReader("PODet.txt"));
int lines=0;
b.PODet[0][0]="PO No";
b.PODet[0][1]="PO Name";
b.PODet[0][2]="Location";
b.PODet[0][3]="Pincode";
b.PODet[0][4]="City";
b.PODet[0][5]="State";
b.PODet[0][6]="Telephone";
b.PODet[0][7]="Unique Code";
b.PODet[0][8]="Created Time";
b.PODet[0][9]="Modified Time";
String line = reader.readLine();
int i=1;
int j=1;
b.PODet[1][0]="1";
  while (line!=null)
  {
   b.PODet[i][j]=line;
   line = reader.readLine();
   if(j==9)
   {
   j=0;
   i++;
   b.PODet[i][0]=String.valueOf(i);
   }
   else
   j++;
b.N=i;
  }
  reader.close();
}
public static void getUser()throws Exception{
UserDB a=new UserDB();
BufferedReader reader1 = new BufferedReader(new FileReader("UserDet.txt"));
BufferedReader reader2= new BufferedReader(new FileReader("UserPf.txt"));
String line1 = reader1.readLine();
int c=0;
int b=0;
while(line1!= null)
{
   a.UserDet[b][c]=line1;
   line1= reader1.readLine();
if(c==1)
{
 c=0;
 b++;  
}
else
c++;
}
a.N=b;
reader1.close();
String line2 = reader2.readLine();
int i=0;
int j=0;
while (line2!= null)
{
   a.UserPf[i][j]=line2;
   line2 = reader2.readLine();
if(j==3)
{
 j=0;
 i++;  
}
j++;
}
  reader2.close();
}
public static void main(String args[])  
{
UserDB a=new UserDB();
PODB b=new PODB();
try
{
 getUser();
 getPO();
}
catch(Exception e)
{
    System.out.println("Cannot get data");
    System.out.println(e);
}
 MainDashboard();
}
}
class UserDB
{
public static String[][] UserDet=new String[20][2];
public static String[][] UserPf=new String[20][4];
public static int N;
}
class PODB
{
public static String[][] PODet=new String[10][10];
public static int N;
}
class SndPODB
{
public static String[][] SPODet=new String[1][9];
public static String[][] DestDet=new String[1][3];
public static String Msg;
}
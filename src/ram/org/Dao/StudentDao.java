package ram.org.Dao;
import java.util.Iterator;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import antlr.collections.List;
import ram.org.pojo.StudentPojo;

public class StudentDao 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{
			System.out.println("******************************************************************");
			System.out.println("******************************************************************");
			System.out.println("1 For Add Student.");
			System.out.println("2 For Show Student.");
			System.out.println("3 For Update Student.");
			System.out.println("4 For Show All Student.");
			System.out.println("5 For Delete a Student.");
			System.out.println("6 For Exit.");
			System.out.print("Make Your Choice: ");
			int ch=sc.nextInt();
			switch (ch)
			{
			case 1:
			{			
				System.out.println("Add a Student record");
				StudentPojo s=new StudentPojo();
				System.out.print("Enter Student Name: ");
				String name=sc.next();
				System.out.print("Enter Student Address: ");
				String address=sc.next();
				s.setName(name);
				s.setAddress(address);
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef= conf.buildSessionFactory();
				Session ses=sef.openSession();
				Transaction tran=ses.beginTransaction();
				ses.save(s);
				tran.commit();
				ses.close();
				break;
			}
			case 2:
			{
				System.out.println("Student Record");
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef= conf.buildSessionFactory();
				Session ses=sef.openSession();
				Transaction tran=ses.beginTransaction();
				System.out.print("Enter Student id: ");
				int id=sc.nextInt();
				System.out.println("Student Record");
				System.out.println("=========================================");
				StudentPojo s=(StudentPojo) ses.get(StudentPojo.class,id);
				System.out.println("Student Id: "+s.getId());
				System.out.println("Student Name: "+s.getName());
				System.out.println("Student Address: "+s.getAddress());
				tran.commit();
				ses.close();			
				break;
			}
			case 3:
			{
				
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef= conf.buildSessionFactory();
				Session ses=sef.openSession();
				Transaction tran=ses.beginTransaction();
				System.out.println("Update Student Record");
				System.out.print("Enter Student id: ");
				int name=sc.nextInt();
				StudentPojo s=(StudentPojo) ses.get(StudentPojo.class,name);
				System.out.println("1 For Update Name.");
				System.out.println("2 For Update Address.");
				int ch1=sc.nextInt();
				switch (ch1)
				{
				case 1:
					System.out.println("Enter Name: ");
					String newName=sc.next();
					s.setName(newName);
					ses.save(s);
					System.out.println("Name Updated");
					break;
					
				case 2:
					System.out.println("Enter Address: ");
					String newAddress=sc.next();
					s.setName(newAddress);
					ses.save(s);
					System.out.println("Address Updated");
					break;
					

				default:
					System.out.println("Wrong choice");
					break;
				}
				
				tran.commit();
				ses.close();			
				break;
			}
			
			case 4:
			{
				
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef= conf.buildSessionFactory();
				Session ses=sef.openSession();
				java.util.List li=ses.createQuery("from StudentPojo").list();
				Iterator it=li.iterator();
				System.out.println("All Student Data");
				while(it.hasNext())
				{
					Object obj=(Object)it.next();
					StudentPojo s=(StudentPojo) obj;
					System.out.println("=======================================");
					System.out.println("Id: "+s.getId());
					System.out.println("Name: "+s.getName());
					System.out.println("Address: "+s.getAddress());
				}
				ses.close();
				System.out.println("======================================================================");
				break;
			}
			case 5:
			{
				
				Configuration conf=new Configuration();
				conf.configure();
				SessionFactory sef= conf.buildSessionFactory();
				Session ses=sef.openSession();
				Transaction tran=ses.beginTransaction();
				System.out.println("Delete a Student Record");
				System.out.print("Enter Student id: ");
				int id=sc.nextInt();
				StudentPojo s=(StudentPojo) ses.get(StudentPojo.class,id);
				ses.delete(s);
				tran.commit();
				System.out.println("Record Deleted");
				ses.close();			
				break;		}
			
			case 6:
			{
				System.out.println("Thank You!");
				System.exit(0);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}
	}
}

# HIbernate-Crud-Management
1.	Create a Java Bean Class / Entity Class / POJO Class.
2.	Mapping between Java application and Relational Model which can be done in 3 different ways namely;
  a)	xml file called as Filename.hbm.xml where hbm refers to Hibernate Mapping
  b)	JPA Annotations in POJO class
3.	Configuration file which is used to connect to the Database [hibernate.cfg.xml]
4.	Test DAO class which “contains main method to execute the application”.
5.	Add Hibernate jars into lib folder.
6.	Add configuration file into the source folder [hibernate.cfg.xml]
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Q.Why we use DAO class?
	Since DAO class is the only area where we can access the properties or functionalities of Java Bean Class / Entity Class / POJO Class
	Only class / area to execute java application which has main method in it.
[JVM is responsible for execution]
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
* JPA Annotations:  [must be declared only in Java Bean Class]
    1.@Entity	specifies it is an Entity class which is used to write Hibernate logic
    2.@Table	specifies Table name in the Database which maps Entity
        [Table name will be associated with Entity class]
    3.@Id	specifies it is Primary Key where the data type must be int or long
    4.@GeneratedValue	specifies auto-generation of Primary Key
      [because of this hibernate supports auto-generation of PK].
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    	Steps for execution of Hibernate Java Application:-

1.	Open Java Perspective and select Navigator mode
2.	Right click within Navigator mode and create a new Java Project & name it
3.	Right click on Project and create a new folder called    lib    and add all the Jar files into the lib folder and build a java path to import the properties from the jar file.
4.	Add the configuration file [hibernate.cfg.xml] into the source folder
5.	Select src folder and create a new package structure
6.	Select application name and create a class [java bean class / entity class / POJO class]
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Steps to be written in a DAO class:-

1.Create an object of Java Bean Class / Entity class / POJO class
2.Set the value of the members of Java Bean Class or Entity class
3.Create an object of Configuration class present in org.hibernate.cfg package
    Syntax:         
        Configuration conf =new Configuration();
4.Call a zero-parameterised configure() method which is declared in Configuration Class.
    Syntax:          
      conf =configure();
5.Create an implementation object of SessionFactory interface present in org.hibernate package by using a factory / helper method called buildSessionFactory( ) which is declared inside Configuration class
    Syntax:          
      SessionFactory sef=conf.buildSessionFactory();
6.Create an implementation object of Session interface present in org.hibernate package by using a factory / helper method called openSession( ) which is declared inside SessionFactory interface
      Syntax:       
        Session ses= sef.openSession();
7.Create an implementation object of Transaction interface present in org.hibernate package by using a factory / helper method called beginTransaction( ) which is declared inside Session interface
      Syntax:          
        Transaction tran= ses.beginTransaction();
8.Perform CRUD operation by using the reference of Session
     Syntax:     
        ses.save(Object);
    save(Object) is declared in Session interface responsible to save / insert data’s into the Database (only objects of java bean class)
9.Commit the Transaction in order to save the data into the Database server
    Syntax:    
      tran.commit()
10.Close the Session   
    Since the Session is considered to be a costly resource, so we need to close the costly resource
    Syntax:   
      ses.close()
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   

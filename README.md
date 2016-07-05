Vote Javapp

#Install MySQL

##Change Password of the database in the following lines

* dataCollectors.java:36:         String password = "mysql501";
* dataCollectors.java:94:         String password = "mysql501";
* dataCollectors.java:126:        String password = "mysql501";

##grant command					
> grant all privileges on election.* to root@localhost identified by 'mysql501';
> FLUSH PRIVILEGES;


##Create Database Election
> create database election;

##Create Tables
###Creating Ballots  table
> CREATE TABLE ballots (
        Image BLOB,
        MarkaTitle VARCHAR(100) NOT NULL,
        CandidateName VARCHAR(200) NOT NULL,
		PRIMARY KEY (MarkaTitle));

insert into ballots (MarkaTitle,CandidateName) value ("Marka or Symbol Name","Candidate Name")

###Creating Results  table	
> CREATE TABLE vote_results (
        Image BLOB,
        MarkaTitle VARCHAR(100) NOT NULL,
        Vote_got VARCHAR(100) NOT NULL,
        Percentage double NOT NULL,
        PRIMARY KEY (MarkaTitle));

> insert into vote_results (MarkaTitle,CandidateName,Vote_Got) SELECT MarkaTitle,CandidateName,0 FROM ballots

###Creating Voter List  table		
> CREATE TABLE voter_list (
        name VARCHAR(100) NOT NULL,
        id int NOT NULL ,
        PRIMARY KEY (id));
		
UPDATE vote_results SET Vote_got = Vote_got + 1 WHERE MarkaTitle = "dog";

##grant command					
> grant all privileges on election.* to root@localhost identified by 'mysql501';
> FLUSH PRIVILEGES;

#How to run the program
Go to the src folder, and then

##Compile from the "src" directory
> javac landingSpace.java

##Run the Java-App
> java landingSpace
					
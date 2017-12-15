# Distributed_File_System_17315016_srivasts
shobhit srivastava 17315016 srivasts@tcd.ie


In this project I have tried to implement the following scenrios :- 


1) File Directory :- I have implemented through a file directory server which pulls the information from the mysql 
			server get the aliasname of the file and than from the alias name , I  pull the information about
                     its file directory form the database(using another table)

Since it is advisable to always access the file and do transaction from the alias name only.

2) Distributed File system :- We have implemented that a file can be present to many file server hence we have given choice to
			      the user to access, read and write from any fileserver, and to all the server we have main-
			      -tained consistency.

4) Locking :- If a file is accessed for write from the fileServer than we have in database table updated its value as locked
              and till the time file is returned back after the changes , the file remains in locked state so to avoid the
              inconsistency.
5)Secutiry :- I have used Kerberos 3 key security where, when user first access to authentiation server , where I have impl
              -emented after the confiramtion of the username form mysql database, server will generate 2 keys and send the
	      one key as encrypted mssg, to the user and than the encrypted 
 	      message is sent to the fileserver where after confirmation that it is send by the authentication server it grants
	      access. 

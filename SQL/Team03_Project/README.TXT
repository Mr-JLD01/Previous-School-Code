Group Members: Corin Canepa, John Luke Denny, Caleb WallS, and Cole Mckay

The files contained within are for the creation of a moch E-commerce database.
The powerpoint gives a brief overview of what the data base is about and some
queries that can be run. The document goes into more detail about how the database
was created. Within the folder "EXCELDATA", these are the comma-delimited text files
for the table creation. 

To run the SQL file, upload the sql file and EXCELDATA folder into a unix file directory.
To use the file, create a mysql username and password. Once created, go to the diectory
containing the sql file and run the command "mysql --local-infile -u^^^^^^^^ -p****** 
^^^^^^^^ <Team03_SQL.sql", where ^'s are your username and *'s are yopur password. This will
both create the tables and run the predesigned queries listed in the document.

To create your own queries, run the sql file, if you haven't before, and use the command
"mysql -u^^^^^^^^ -p******", then use command "use ^^^^^^^^" to be able to use the tables you
created. Again, *'s are your password, and ^'s are your username. At this point, you can enter
any query you want from Select to Update and Delete.
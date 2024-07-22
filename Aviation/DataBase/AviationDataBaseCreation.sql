/*
What does this script do?

This script will automatically create the entire database of the Aviation project for you.
It will create the tablespace for the project alone, a new user with the basic priviliges 
for the project (connect, read, write, delete), create all the tables and insert the 
predefault data.

The purpose of this script is to make the entire process of creating the 
database for the project as swift and painless as possible. And same for later on
deletion.

If you do not fancy running this script whatsoever for any reason (for example, already
having a designed user ), you can
run each individual script





To execute this script, you must log in on either SQLPlus or Oracle SQL Developer
with an user with priviliges, or a role/s, that allows: 

    - To create a tablespace with a datafile.
    - To create a new database user.
    
If you're not the DBA nor an user with these privilges, please contact your DBA or support
for further help.
    


*/

set sqlblanklines on;

connect /as sysdba;

/*Allows the creation and deletetion of database users in this context.*/
alter session set "_Oracle_Script" = true;

/*Creates a tablespace for the example called AviationExampleTableSpace,
with a size of 50MB and autoextent disabled.*/
create tablespace AviationExampleTableSpace
datafile 'AviationExampleTableSpace.DBF'
size 50M autoextend off;

/*Create the database user for the Aviation example. This will be the user
that the WEB API will connect to.*/
create user AviationExampleUser
identified by AviationExampleUserPassword
default tablespace AviationExampleTableSpace
quota unlimited on AviationExampleTableSpace;

/*Give the basic priviliges to the AviationUser.*/
grant create session, create table, create procedure, create sequence, create trigger 
to AviationExampleUser;

/*Disconnect from DBA.*/
disconnect;

/*Connect as the new user for the project.*/

connect AviationExampleUser/AviationExampleUserPassword;

@Tables.sql;
@Sequences.sql;
@Packages/AuditTablePackge.sql;
@Packages/APIUserPackage.sql;
@Packages/APIUserRolePackage.sql;
@Packages/ApplicationUserPackage.sql;
@Triggers.sql;
@InitialData.sql;

disconnect;
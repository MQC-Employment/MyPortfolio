set sqlblanklines on;

connect /as sysdba;

alter session set "_Oracle_Script" = true;

drop user AviationExampleUser cascade;
drop tablespace AviationExampleTableSpace including contents and datafiles;

disconnect;
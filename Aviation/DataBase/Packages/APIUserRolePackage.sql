create or replace package APIUserRolePackage
as

    procedure getRolesFromAPIUser(userAPIIDP in APIUser.userID%type, 
    APIUserRoleCursor out sys_refcursor);
    
end;
/
create or replace package body APIUserRolePackage
as

    procedure getRolesFromAPIUser(userAPIIDP in APIUser.userID%type, 
    APIUserRoleCursor out sys_refcursor)
    as
    begin
    
        open APIUserRoleCursor for
            select roleidentifier, rolename 
            from APIUser_APIUserRole
            inner join apiuser 
            on apiuser.internalapiuserid = apiuser_apiuserrole.internalapiuserid
            inner join apiuserrole
            on apiuserrole.internalapiuserroleid = apiuser_apiuserrole.internalapiuserroleid
            where userid = userAPIIDP;
    
    end;
    
end;
/
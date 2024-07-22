create or replace package APIUserPackage 
as

    procedure getAPIUsers(APIUsersCursor out sys_refcursor);
    procedure getAPIUser(userAPIIDP in raw,APIUserCursor out sys_refcursor);
    procedure apiUsageAuthentication(apiUserEmailP in APIUser.userEmail%type, 
    apiUserPasswordP in APIUser.userPassword%type,
    userAPIKeyP in APIUser.userAPIKey%type, apiUserCursor out sys_refcursor);

end;
/
create or replace package body APIUserPackage
as

    procedure getAPIUsers(APIUsersCursor out sys_refcursor)
    as
    begin
    
        open APIUsersCursor for
            select userid as "userIDbyteArray", userEmail, 
            userAPIKey as "userAPIKeybyteArray"
            from apiuser;
    
    end;
    
    procedure getAPIUser(userAPIIDP in raw,APIUserCursor out sys_refcursor)
    as
    begin
    
        open APIUserCursor for
            select userid as "userIDbyteArray", userEmail,
            userAPIKey as "userAPIKeybyteArray"
            from apiuser
            where userid = userAPIIDP;
    
    end;
    
    procedure apiUsageAuthentication(apiUserEmailP in APIUser.userEmail%type,
    apiUserPasswordP in APIUser.userPassword%type,
    userAPIKeyP in APIUser.userAPIKey%type, apiUserCursor out sys_refcursor)
    as
    begin

        open apiUserCursor for 
            select userid as "userIDbyteArray", userEmail,
            userAPIKey as "userAPIKeybyteArray"
            from apiuser
            where userEmail = apiUserEmailP and
            userPassword = standard_hash(userSalt || apiUserPasswordP,'SHA256') and
            userAPIKey = userAPIKeyP;
    
    end;

end;
/
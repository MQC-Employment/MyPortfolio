    create or replace package ApplicationUserPackage
as

    procedure getAllApplicationUsers(applicationUserCursorP out sys_refcursor);
    procedure getApplicationUserByID(applicationUserIDP in raw,applicationUserCursorP out sys_refcursor);
    procedure registerNewApplicationUser
    (userEmailP in ApplicationUser.useremail%type,
    userPasswordP in ApplicationUser.userPassword%type,
    firstNameP in ApplicationUser.firstName%type,
    lastNameP in ApplicationUser.lastName%type,
    phoneNumberP in ApplicationUser.phoneNumber%type,
    addressP in ApplicationUser.address%type,
    userRegisteredIDP out ApplicationUser.userID%type);

end;
/
create or replace package body ApplicationUserPackage
as

    procedure getAllApplicationUsers(applicationUserCursorP out sys_refcursor)
    as
    begin
    
        open applicationUserCursorP for
            select userID as "userIDByteArray", userEmail,
            firstName, lastname, phoneNumber, address
            from ApplicationUser;
    
    end;
    
    procedure getApplicationUserByID(applicationUserIDP in raw,applicationUserCursorP out sys_refcursor)
    as
    begin 
    
        open applicationUserCursorP for
            select userID as "userIDByteArray", userEmail,
            firstName, lastname, phoneNumber, address
            from ApplicationUser
            where userid = applicationUserIDP;
            
    end;
    
    procedure registerNewApplicationUser
    (userEmailP in ApplicationUser.useremail%type,
    userPasswordP in ApplicationUser.userPassword%type,
    firstNameP in ApplicationUser.firstName%type,
    lastNameP in ApplicationUser.lastName%type,
    phoneNumberP in ApplicationUser.phoneNumber%type,
    addressP in ApplicationUser.address%type,
    userRegisteredIDP out ApplicationUser.userID%type)
    as
    
        userPasswordSalt ApplicationUser.userSalt%type := DBMS_RANDOM.STRING('P',32);
        userPasswordHashed ApplicationUser.userPassword%type := null;
    
    begin
    
        select standard_hash(userPasswordSalt||userPasswordP,'SHA256')
        into userPasswordHashed
        from dual;
    
        insert into applicationuser(userID,userEmail,userSalt,userPassword,firstName,
        lastname,phoneNumber,address)
        values(sys_guid(),lower(userEmailP),userPasswordSalt,userPasswordHashed,firstNameP,
        lastNameP,phoneNumberP,addressP)
        returning userid into userRegisteredIDP;
    
    end;
    
end;
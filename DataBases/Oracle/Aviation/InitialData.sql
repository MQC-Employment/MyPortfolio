insert into APIUserRole(roleidentifier,rolename)
values(1,'Admin.');
insert into APIUserRole(roleidentifier,rolename)
values(2,'General user.');
/
declare

    APIUserInternalID APIUser.internalAPIUserID%type := null;
    APIUserID APIUser.userid%type := sys_guid();
    APIUserEmailAddress APIUser.userEmail%type := lower('admin@example.com');
    APIUserPasswordSalt APIuser.userSalt%type := DBMS_RANDOM.STRING('P',32);
    APIUserPassword APIUser.userPassword%type := 'Admin123';
    APIUserPasswordHashed APIUser.userPassword%type := null;
    InternalAPIUserRoleIDV APIUserRole.internalAPIUserRoleID%type;
    APIUserAPIKey APIUser.userAPIKey%type := 'F537F08AC0A545A3B925DA4A0A1728C1';
    
begin

    
    select standard_hash(APIUserPasswordSalt||APIUserPassword,'SHA256')
    into APIUserPasswordHashed
    from dual;
    
    insert into APIUser(userID,userEmail,
    userPassword,userSalt,userAPIKey)
    values(APIUserID,APIUserEmailAddress,APIUserPasswordHashed,
    APIUserPasswordSalt,APIUserAPIKey);
    
    select internalAPIUserRoleID into InternalAPIUserRoleIDV
    from APIUserRole
    where roleIdentifier = 1;
    
    select internalapiuserid into APIUserInternalID
    from apiuser
    where userid = APIUserID;
    
    insert into APIUser_APIUserRole(internalAPIUserID,internalAPIUserRoleID,roleRelationID)
    values(APIUserInternalID,InternalAPIUserRoleIDV,sys_guid());

    commit;

end;
/
insert into ApplicationUserRole(roleIdentifier,rolename)
values(1,'Admin.');
insert into ApplicationUserRole(roleIdentifier,rolename)
values(2,'General User.');
/
declare

    ApplicationUserInternalID ApplicationUser.internalApplicationUserID%type := null;
    ApplicationUserID ApplicationUser.userid%type := sys_guid();
    ApplicationserEmailAddress ApplicationUser.userEmail%type := lower('admin@example.com');
    ApplicationUserPasswordSalt ApplicationUser.userSalt%type := DBMS_RANDOM.STRING('P',32);
    ApplicationUserPassword ApplicationUser.userPassword%type := 'Admin123';
    ApplicationUserPasswordHashed ApplicationUser.userPassword%type := null;
    InternalApplicationUserRoleIDV ApplicationUserRole.internalApplicationUserRoleID%type := null;
    ApplicationUserFirstName ApplicationUser.firstname%type := 'Miguel';
    ApplicationUserLastMame ApplicationUser.lastname%type := 'Cervantes';
    ApplicationUserPhone ApplicationUser.phoneNumber%type := '1234-5678';
    ApplicationUserAddress ApplicationUser.address%type := '1st street, Orlando Airport, Orlando, Florida';
    
begin

    select standard_hash(ApplicationUserPasswordSalt||ApplicationUserPassword,'SHA256')
    into ApplicationUserPasswordHashed
    from dual;
    
    insert into ApplicationUser(userID,userEmail,
    userPassword,userSalt,firstname,lastname,phonenumber,address)
    values(ApplicationUserID,ApplicationserEmailAddress,ApplicationUserPasswordHashed,
    ApplicationUserPasswordSalt,ApplicationUserFirstName,ApplicationUserLastMame,
    ApplicationUserPhone,ApplicationUserAddress);
    
    select InternalApplicationUserRoleID into InternalApplicationUserRoleIDV
    from ApplicationUserRole
    where roleIdentifier = 1;
    
    select internalApplicationUserID into ApplicationUserInternalID
    from ApplicationUser
    where userid = ApplicationUserID;
    
    insert into ApplicationUser_ApplicationUserRole
    (internalApplicationUserID,internalApplicationUserRoleID,roleRelationID)
    values(ApplicationUserInternalID,InternalApplicationUserRoleIDV,sys_guid());

    commit;

end;
/
declare

    ApplicationUserInternalID ApplicationUser.internalApplicationUserID%type := null;
    ApplicationUserID ApplicationUser.userid%type := sys_guid();
    ApplicationserEmailAddress ApplicationUser.userEmail%type := lower('user1@example.com');
    ApplicationUserPasswordSalt ApplicationUser.userSalt%type := DBMS_RANDOM.STRING('P',32);
    ApplicationUserPassword ApplicationUser.userPassword%type := 'user123';
    ApplicationUserPasswordHashed ApplicationUser.userPassword%type := null;
    InternalApplicationUserRoleIDV ApplicationUserRole.internalApplicationUserRoleID%type := null;
    ApplicationUserFirstName ApplicationUser.firstname%type := 'Ralph';
    ApplicationUserLastMame ApplicationUser.lastname%type := 'Anderson';
    ApplicationUserPhone ApplicationUser.phoneNumber%type := '1234-5679';
    ApplicationUserAddress ApplicationUser.address%type := '2nd street, New York Airport, New York';
    
begin

    select standard_hash(ApplicationUserPasswordSalt||ApplicationUserPassword,'SHA256')
    into ApplicationUserPasswordHashed
    from dual;
    
    insert into ApplicationUser(userID,userEmail,
    userPassword,userSalt,firstname,lastname,phonenumber,address)
    values(ApplicationUserID,ApplicationserEmailAddress,ApplicationUserPasswordHashed,
    ApplicationUserPasswordSalt,ApplicationUserFirstName,ApplicationUserLastMame,
    ApplicationUserPhone,ApplicationUserAddress);
    
    select InternalApplicationUserRoleID into InternalApplicationUserRoleIDV
    from ApplicationUserRole
    where roleIdentifier = 2;
    
    select internalApplicationUserID into ApplicationUserInternalID
    from ApplicationUser
    where userid = ApplicationUserID;
    
    insert into ApplicationUser_ApplicationUserRole
    (internalApplicationUserID,internalApplicationUserRoleID,roleRelationID)
    values(ApplicationUserInternalID,InternalApplicationUserRoleIDV,sys_guid());

    commit;

end;
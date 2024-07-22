insert into APIUserRole(roleidentifier,rolename)
values(1,'Admin.');
insert into APIUserRole(roleidentifier,rolename)
values(2,'General user.');

declare

    APIUserInternalID APIUser.internalAPIUserID%type := null;
    APIUserID APIUser.userid%type := null;
    APIUserEmailAddress APIUser.userEmail%type := lower('admin@example.com');
    APIUserPasswordSalt APIuser.userSalt%type := 'RandomSalt123';
    APIUserPassword APIUser.userPassword%type := 'Admin123';
    APIUserPasswordHashed APIUser.userPassword%type := null;
    InternalAPIUserRoleIDV APIUserRole.internalAPIUserRoleID%type;
    APIUserAPIKey APIUser.userAPIKey%type := 'F537F08AC0A545A3B925DA4A0A1728C1';
    
begin

    
    select standard_hash(APIUserPasswordSalt||APIUserPassword,'SHA256')
    into APIUserPasswordHashed
    from dual;
    
    insert into APIUser(userEmail,
    userPassword,userSalt,userAPIKey)
    values(APIUserEmailAddress,APIUserPasswordHashed,
    APIUserPasswordSalt,APIUserAPIKey)
    returning userID into APIUserID;
    
    select internalAPIUserRoleID into InternalAPIUserRoleIDV
    from APIUserRole
    where roleIdentifier = 1;
    
    select internalapiuserid into APIUserInternalID
    from apiuser
    where userid = APIUserID;
    
    insert into APIUser_APIUserRole(internalAPIUserID,internalAPIUserRoleID)
    values(APIUserInternalID,InternalAPIUserRoleIDV);

    commit;

end;
/

insert into ApplicationUserRole(roleIdentifier,rolename)
values(1,'Admin.');
insert into ApplicationUserRole(roleIdentifier,rolename)
values(2,'General User.');

declare

    ApplicationUserInternalID ApplicationUser.internalApplicationUserID%type := null;
    ApplicationUserID ApplicationUser.userid%type := null;
    ApplicationserEmailAddress ApplicationUser.userEmail%type := lower('admin@example.com');
    ApplicationUserPasswordSalt ApplicationUser.userSalt%type := 'RandomSalt123';
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
    
    insert into ApplicationUser(userEmail,
    userPassword,userSalt,firstname,lastname,phonenumber,address)
    values(ApplicationserEmailAddress,ApplicationUserPasswordHashed,
    ApplicationUserPasswordSalt,ApplicationUserFirstName,ApplicationUserLastMame,
    ApplicationUserPhone,ApplicationUserAddress)
    returning userid into ApplicationUserID;
    
    select InternalApplicationUserRoleID into InternalApplicationUserRoleIDV
    from ApplicationUserRole
    where roleIdentifier = 1;
    
    select internalApplicationUserID into ApplicationUserInternalID
    from ApplicationUser
    where userid = ApplicationUserID;
    
    insert into ApplicationUser_ApplicationUserRole
    (internalApplicationUserID,internalApplicationUserRoleID)
    values(ApplicationUserInternalID,InternalApplicationUserRoleIDV);

    commit;

end;
/

declare

    ApplicationUserInternalID ApplicationUser.internalApplicationUserID%type := null;
    ApplicationUserID ApplicationUser.userid%type := null;
    ApplicationserEmailAddress ApplicationUser.userEmail%type := lower('user1@example.com');
    ApplicationUserPasswordSalt ApplicationUser.userSalt%type := 'RandomSalt456';
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
    
    insert into ApplicationUser(userEmail,
    userPassword,userSalt,firstname,lastname,phonenumber,address)
    values(ApplicationserEmailAddress,ApplicationUserPasswordHashed,
    ApplicationUserPasswordSalt,ApplicationUserFirstName,ApplicationUserLastMame,
    ApplicationUserPhone,ApplicationUserAddress)
    returning userid into ApplicationUserID;
    
    select InternalApplicationUserRoleID into InternalApplicationUserRoleIDV
    from ApplicationUserRole
    where roleIdentifier = 2;
    
    select internalApplicationUserID into ApplicationUserInternalID
    from ApplicationUser
    where userid = ApplicationUserID;
    
    insert into ApplicationUser_ApplicationUserRole
    (internalApplicationUserID,internalApplicationUserRoleID)
    values(ApplicationUserInternalID,InternalApplicationUserRoleIDV);

    commit;

end;
/

declare

    internalAircraftManufacturerIDV AircraftManufacturer.internalAircraftManufacturerID%type := null;
    internalAircraftFamilyIDV AircraftFamily.internalAircraftFamilyID%type := null;

begin

    /*Boeing 747*/

    insert into AircraftManufacturer(manufacturerName,foundationDate,
    officialWEBSite,numberOfEmployees)
    values('Boeing','15/07/1916','https://www.boeing.com/',145000)
    returning internalAircraftManufacturerID into internalAircraftManufacturerIDV;
    
    insert into AircraftFamily(internalAircraftManufacturerID,aircraftFamilyName,
    introductionDate,smallDescription)
    values(internalAircraftManufacturerIDV,'747','22/01/1970',
    'The historic 747, dubbed the ‘Queen of the Skies,’ revolutionized air 
    travel as the world’s first twin-aisle airplane and enabled more people to 
    fly farther, faster and more affordably than ever before. Marked by its 
    distinctively recognizable hump, this iconic airplane is a symbol of great 
    engineering, innovation and often noted as an outstanding work of architecture.')
    returning internalAircraftFamilyID into internalAircraftFamilyIDV;

    insert into Aircraft(internalAircraftFamilyID,aircraftName,aircraftDescription,
    introductionDate,firstFlightDate,maxNumberOfSeats,maxFlyingRange,inStock,isInService,
    thumbNailImage,pricePerUnit,discount)
    values(internalAircraftFamilyIDV,'747-8',
    'The new 747-8 Intercontinental features the newest engine and wing 
    combination in the industry, new advanced materials, and an updated 
    flight deck for better performance with a small environmental footprint.',
    '12/10/2011','08/02/2010',410,13650,20,1,null,418000000,10);
    
    /*Boeing 737 MAX*/
    
    insert into AircraftFamily(internalAircraftManufacturerID,aircraftFamilyName,
    introductionDate,smallDescription)
    values(internalAircraftManufacturerIDV,'737 MAX','22/05/2017',
    'The 737 MAX family delivers enhanced efficiency, improved environmental 
    performance and increased passenger comfort to the single-aisle market. 
    Incorporating advanced technology winglets and efficient engines, the 737 MAX 
    family offers excellent economics, reducing fuel use and emissions by 20 
    percent while producing a 50 percent smaller noise footprint than the airplanes 
    it replaces. Additionally, 737 MAX family offers up to 14 percent lower airframe 
    maintenance costs than the competition. Passengers will enjoy the Boeing Sky Interior, 
    highlighted by modern sculpted sidewalls and window reveals, LED lighting that enhances 
    the sense of spaciousness and larger pivoting overhead storage bins.')
    returning internalAircraftFamilyID into internalAircraftFamilyIDV;

    insert into Aircraft(internalAircraftFamilyID,aircraftName,aircraftDescription,
    introductionDate,firstFlightDate,maxNumberOfSeats,maxFlyingRange,inStock,isInService,
    thumbNailImage,pricePerUnit,discount)
    values(internalAircraftFamilyIDV,'737-7',
    'Enjoy an elevated experience. Passengers can take advantage of greater 
    flexibility to control their environment; controls for reading and 
    lighting are at the passenger’s fingertips..',
    '01/07/2016','16/03/2018',172,7040,120,1,null,100000000,25);
    
    insert into Aircraft(internalAircraftFamilyID,aircraftName,aircraftDescription,
    introductionDate,firstFlightDate,maxNumberOfSeats,maxFlyingRange,inStock,isInService,
    thumbNailImage,pricePerUnit,discount)
    values(internalAircraftFamilyIDV,'737-9',
    'The aircraft is configured with First, Economy Plus and Economy Class seating.
    The standard seats in Economy feature a redesign of the back literature pocket
    and tray table to provide additional legspace. The seats also contain a 
    tablet/personal device holder positioned at a comfortable viewing level. ',
    '01/02/2012','29/01/2016',220,6110,7,1,null,128000000,0);

end;
/
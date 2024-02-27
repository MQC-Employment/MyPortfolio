create table ApplicationUserRole(

    internalApplicationUserRoleID smallint not null,
    roleIdentifier smallint not null,
    roleName varchar2(32) not null,
    
    constraint ApplicationUserRole_InternalApplicationUserRoleID_PK primary key(internalApplicationUserRoleID),
    constraint ApplicationUserRole_RoleIdentifier_Unique unique (roleIdentifier),
    constraint ApplicationUserRole_RoleName_Unique unique (roleName)

);
/
create table APIUserRole(

    internalAPIUserRoleID smallint not null,
    roleIdentifier smallint not null,
    roleName varchar2(32) not null,
    
    constraint APIUserRole_InternalAPIUserRoleID_PK primary key(internalAPIUserRoleID),
    constraint APIUserRole_RoleIdentifier_Unique unique (roleIdentifier),
    constraint APIUserRole_RoleName_Unique unique (roleName)

);
/
create table APIUser(

    internalAPIUserID number not null,
    userID raw(16) not null,
    userEmail varchar2(320) not null,
    userPassword varchar2(64) null,
    userSalt varchar2(32) null,
    userAPIKey raw(16) null,
    
    constraint APIUser_InternalAPIUserID_PK primary key (internalAPIUserID),
    constraint APIUser_UserID_Unique unique(userID),
    constraint APIUser_UserEmail_Unique unique (userEmail),
    constraint APIUser_UserSalt_Unique unique (userSalt),
    constraint APIUser_UserAPIKey_Unique unique (userAPIKey)
    
);
/
create table ApplicationUser(

    internalApplicationUserID number not null,
    userID raw(16) not null,
    userEmail varchar2(320) not null,
    userPassword varchar2(64) null,
    userSalt varchar2(32) null,
    firstName varchar2(64) not null,
    lastName varchar2(64) not null,
    phoneNumber varchar2(32) not null,
    address varchar2(162) not null,
    
    constraint ApplicationUser_InternalApplicationUserID_PK primary key (internalApplicationUserID),
    constraint ApplicationUser_UserID_Unique unique (userID),
    constraint ApplicationUser_UserEmail_Unique unique (userEmail),
    constraint ApplicationUser_UserSalt_Unique unique (userSalt),
    constraint ApplicationUser_PhoneNumber_Unique unique(phoneNumber)

);
/
create table APIUser_APIUserRole(

    internalAPIUserID number not null,
    internalAPIUserRoleID smallint not null,
    roleRelationID raw(16) not null,

    constraint APIUserRole_APIUser_PK primary key(internalAPIUserID,internalAPIUserRoleID),
    constraint APIUser_APIUserRole_InternalAPIUserID_FK foreign key(internalAPIUserID)
    references APIUser(internalAPIUserID),
    constraint APIUser_APIUserRole_InternalAPIUserRoleID_FK foreign key(internalAPIUserRoleID)
    references APIUserRole(internalAPIUserRoleID),
    constraint APIUser_APIUserRole_RoleRelationID_Unique unique(roleRelationID)

);
/
create table ApplicationUser_ApplicationUserRole(

    internalApplicationUserID number not null,
    internalApplicationUserRoleID smallint not null,
    roleRelationID raw(16) not null,

    constraint ApplicationUser_ApplicationUserRole_PK primary key(internalApplicationUserID,internalApplicationUserRoleID),
    constraint ApplicationUser_ApplicationUserRole_InternalApplicationUserID_FK foreign key(internalApplicationUserID)
    references ApplicationUser(internalApplicationUserID),
    constraint ApplicationUser_ApplicationUserRole_InternalApplicationUserRoleID_FK foreign key(internalApplicationUserRoleID)
    references ApplicationUserRole(internalApplicationUserRoleID),
    constraint ApplicationUser_ApplicationUserRole_RoleRelationID_Unique unique(roleRelationID)

);
/
create table AircraftManufacturer(

    internalAircraftManufacturerID number not null,
    aircraftManufacturerID raw(16) not null,
    manufacturerName varchar2(32) not null,
    foundationDate date not null,
    officialWEBSite varchar2(64) null,
    numberOfEmployees number(8) null,
    
    constraint AircraftManufacturer_AircraftManufacturerInternalID_PK primary key(internalAircraftManufacturerID),
    constraint AircraftManufacturer_AircraftManufacturerID_Unique unique (aircraftManufacturerID),
    constraint AircraftManufacturer_ManufacturerName_Unique unique (manufacturerName),
    constraint AircraftManufacturer_NumberOfEmployees_Check check (numberOfEmployees>=0 or numberOfEmployees is null)
    
);
/
create table AircraftFamily(

    aircraftFamilyNumberPerManufacturer number not null,
    internalAircraftManufacturerID number not null,
    aircraftFamilyID raw(16) not null,
    aircraftFamilyName varchar2(32) not null,
    introductionDate date null,
    smallDescription varchar2(1024) null,
    
    constraint AircraftFamily_InternalAircraftFamilyID_PK primary key(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer),
    constraint AircraftFamily_AircraftFamilyID_Unique unique(aircraftFamilyID),
    constraint AircraftFamily_AircraftManufacturerInternalID_FK
    foreign key (internalAircraftManufacturerID) 
    references AircraftManufacturer(internalAircraftManufacturerID),
    constraint AircraftFamily_AircraftFamilyName_Unique unique(aircraftFamilyName)

);
/
create table Aircraft(

    aircraftNumberPerAircraftFamily number not null,
    aircraftFamilyNumberPerManufacturer number not null,
    internalAircraftManufacturerID number not null,
    aircraftID raw(16) not null,
    aircraftName varchar2(32) not null,
    aircraftDescription varchar2(2048),
    introductionDate date null,
    firstFlightDate date null,
    maxNumberOfSeats number(3) null,
    maxFlyingRange number(6) null,
    inStock number(3) null,
    isInService number(1) null,
    thumbNailImage varchar2(2048) null,
    pricePerUnit decimal(14,2) null,
    discount decimal(4,2) null, 
    
    constraint Aircraft_InternalAircraftID_PK primary key (internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily),
    constraint Aircraft_AircraftID_Unique unique (aircraftID),
    constraint Aircraft_InternalAircraftFamilyID_FK 
    foreign key (internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer) references AircraftFamily(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer),
    constraint Aircraft_AircraftName_Unique unique (aircraftName),
    constraint Aircraft_MaxNumberOfSeats_Check check(maxNumberOfSeats>=0 or maxNumberOfSeats is null),
    constraint Aircraft_MaxFlyingRange_Check check (maxFlyingRange >=0 or maxFlyingRange is null),
    constraint Aircraft_InStock_Check check (inStock >=0 or inStock is null),
    constraint Aircraft_IsInService_Check check (isInService = 0 or isInService = 1 or isInService is null),
    constraint Aircraft_PricePerUnit_Check check (pricePerUnit >=0 or pricePerUnit is null),
    constraint Aircraft_Discount_Check check (discount >=0 or discount is null)

);
/
create table AircraftImages(

    aircraftNumberPerAircraftFamily number not null,
    aircraftFamilyNumberPerManufacturer number not null,
    internalAircraftManufacturerID number not null,
    imagineID raw(16) not null,
    imageURLRoute varchar2(2048) not null, 

    constraint AircraftImages_PK 
    primary key(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily,imageURLRoute),
    constraint AircraftImages_FK foreign key(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily)
    references Aircraft(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily),
    constraint AircraftImages_ImagineID_Unique unique(imagineID)

);
/
create table Invoice(

    invoiceNumberPerUser number not null,
    invoiceID raw(16) not null,
    internalApplicationUserID number not null,
    invoiceDescription varchar2(1024) not null,
    dateOfInvoice date not null,
    totalPrice decimal(14,2) not null,
    discountApplied decimal(4,2) null,
    
    constraint Invoice_PK primary key (internalApplicationUserID,invoiceNumberPerUser),
    constraint Invoice_InvoiceID_Unique unique(invoiceID),
    constraint Invoice_InternalApplicationUserID_PK foreign key(internalApplicationUserID)
    references ApplicationUser(internalApplicationUserID)

)partition by range(dateOfInvoice)
interval(numtoyminterval(1,'month'))(

    partition MonthlyPartition values less than (to_date('01/01/2024','DD/MM/YYYY'))

);
/
create table InvoiceDetail(

    invoiceDetailNumberPerInvoice number not null,
    invoiceNumberPerUser number not null,
    internalApplicationUserID number not null,
    aircraftNumberPerAircraftFamily number not null,
    aircraftFamilyNumberPerManufacturer number not null,
    internalAircraftManufacturerID number not null,
    invoiceDetailID raw(16) not null,
    price decimal(14,2) null,
    discount decimal(4,2) null,
    
    constraint InvoiceDetail_PK 
    primary key(internalApplicationUserID,invoiceNumberPerUser,invoiceDetailNumberPerInvoice),
    constraint InvoiceDetail_Invoice_FK foreign key(internalApplicationUserID,invoiceNumberPerUser)
    references Invoice(internalApplicationUserID,invoiceNumberPerUser),
    constraint InvoiceDetail_Aircraft_FK 
    foreign key(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily)
    references Aircraft(internalAircraftManufacturerID,aircraftFamilyNumberPerManufacturer,aircraftNumberPerAircraftFamily),
    constraint InvoiceDetail_InvoiceDetailID_Unique unique(invoiceDetailID)

);
/
create table AuditTable(

    internalEventID number not null,
    dateOfEvent date not null,
    eventMessage varchar2(2024) not null,

    constraint AuditTable_PK primary key(internalEventID)

);
create or replace trigger InsertNewAuditTableTrigger
before insert on AuditTable for each row
begin

    select AuditTableSequence.nextval
    into :new.internalEventID
    from dual;

end;
/
create or replace trigger InsertNewApplicationUserRoleTrigger
before insert on ApplicationUserRole for each row 
begin

    select ApplicationUserRoleSequence.nextval
    into :new.internalApplicationUserRoleID
    from dual;
    
    AuditTablePackge.insertauditevent('New application user role created: ' || :new.roleName, sysdate());

end;
/
create or replace trigger InsertNewAPIUserRoleTrigger
before insert on APIUserRole for each row 
begin

    select APIUserRoleSequence.nextval
    into :new.internalAPIUserRoleID
    from dual;
    
    AuditTablePackge.insertauditevent('New API role created: ' || :new.roleName, sysdate());

end;
/
create or replace trigger InsertNewAPIUserTrigger
before insert on APIUser for each row
begin

    select APIUserSequence.nextval, sys_guid()
    into :new.internalAPIUserID, :new.userID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New API user registered: ' || :new.userEmail, sysdate());

end;
/
create or replace trigger InsertNewApplicationUserTrigger
before insert on ApplicationUser for each row
begin
    
    select ApplicationUserSequence.nextval, sys_guid()
    into :new.internalApplicationUserID, :new.userID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New application user registered: ' || :new.userEmail, sysdate());

end;
/
create or replace trigger InsertNewRelationAPIUserAPIUserRoleTrigger
before insert on APIUser_APIUserRole for each row
begin

    select sys_guid()
    into :new.roleRelationID
    from dual;

end;
/
create or replace trigger InsertNewRelationApplicationUserApplicationUserRoleTrigger
before insert on ApplicationUser_ApplicationUserRole for each row
begin

    select sys_guid()
    into :new.roleRelationID
    from dual;

end;
/
create or replace trigger InsertNewAircraftManufacturerTrigger
before insert on AircraftManufacturer for each row
begin

    select AircraftManufacturerSequence.nextval, sys_guid()
    into :new.internalAircraftManufacturerID, :new.aircraftManufacturerID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New aircraft manufacterer registered: ' || :new.manufacturerName, sysdate());

end;
/
create or replace trigger InsertNewAircraftFamilyTrigger
before insert on AircraftFamily for each row
begin

    select AircraftFamilySequence.nextval, sys_guid()
    into :new.internalAircraftFamilyID, :new.aircraftFamilyID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New aircraft family registered: ' || :new.aircraftFamilyName, sysdate());    

end;
/
create or replace trigger InsertNewAircraftTrigger
before insert on Aircraft for each row
begin

    select AircraftSequence.nextval, sys_guid()
    into :new.internalAircraftID, :new.aircraftID
    from dual;

    AuditTablePackge.insertauditevent
    ('New aircraft registered: ' || :new.aircraftName, sysdate()); 

end;
/
create or replace trigger InsertNewAircraftImageTrigger
before insert on AircraftImage for each row
begin

    select AircraftImageSequence.nextval, sys_guid()
    into :new.internalAirCraftImagineID, :new.imagineID
    from dual;

end;
/
create or replace trigger InsertNewInvoiceTrigger
before insert on Invoice for each row
begin

    select InvoiceSequence.nextval, sys_guid()
    into :new.internalInvoiceID, :new.invoiceID
    from dual;

end;
/
create or replace trigger InsertNewInvoiceDetailTrigger
before insert on InvoiceDetail for each row
begin

    select InvoiceDetailSequence.nextval, sys_guid()
    into :new.internalinvoiceDetailID, :new.invoiceDetailID
    from dual;

end;
/
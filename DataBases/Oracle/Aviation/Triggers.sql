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

    select APIUserSequence.nextval
    into :new.internalAPIUserID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New API user registered: ' || :new.userEmail, sysdate());

end;
/
create or replace trigger InsertNewApplicationUserTrigger
before insert on ApplicationUser for each row
begin
    
    select ApplicationUserSequence.nextval
    into :new.internalApplicationUserID
    from dual;
    
    AuditTablePackge.insertauditevent
    ('New application user registered: ' || :new.userEmail, sysdate());

end;
create or replace package AuditTablePackge
as

    procedure insertAuditEvent
    (eventMessageP in AuditTable.eventMessage%type,
    dateOfEventP in AuditTable.dateOfEvent%type);
    procedure getAllAuditEvents(auditEventsCursorP out sys_refcursor);
    procedure getAuditEventsPerPage(pageNumberP in number,auditEventsCursorP out sys_refcursor);
    
end;
/
create or replace package body AuditTablePackge
as

    procedure insertAuditEvent
    (eventMessageP in AuditTable.eventMessage%type,
    dateOfEventP in AuditTable.dateOfEvent%type)
    as
    begin
    
        insert into audittable(eventMessage,dateofevent)
        values(eventMessageP,dateOfEventP);
    
    end;
    
    procedure getAllAuditEvents(auditEventsCursorP out sys_refcursor)
    as
    begin 
    
        open auditEventsCursorP for
            select *
            from audittable
            order by dateofevent desc;
    
    end;
    
    procedure getAuditEventsPerPage(pageNumberP in number,auditEventsCursorP out sys_refcursor)
    as
    
        numberOfRowsReturned number := 10;
        offsetNumber number := numberOfRowsReturned*(pageNumberP-1);
    
    begin
    
        open auditEventsCursorP for
            select *
            from audittable
            order by dateofevent desc
            offset offsetNumber rows
            fetch next numberOfRowsReturned rows only;
    
    end;
    
end;
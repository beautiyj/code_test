CREATE OR REPLACE TRIGGER trig_03
    AFTER DELETE ON emp01           -- 이벤트 발생
    FOR EACH ROW                    -- 행레벨 트리거
BEGIN
    DELETE FROM sal01 WHERE empno = :old.empno;
END;
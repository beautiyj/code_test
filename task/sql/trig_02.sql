CREATE OR REPLACE TRIGGER trig_02
    AFTER INSERT ON emp01           -- 이벤트 발생. emp01 테이블에 INSERT가 일어난 직후에 실행
    FOR EACH ROW                    -- 행레벨 트리거: 입력되는 '행 하나하나마다' 각각 실행
BEGIN                               -- sal은 임의로 300으로 정함.       empno는 부모테이블의 사원번호를 구해온다
    INSERT INTO sal01 VALUES(sal01_salno_seq.NEXTVAL, 300, :new.empno);
END;
/

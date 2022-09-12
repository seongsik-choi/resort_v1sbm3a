/**********************************/
/* Table Name: 카테고리 그룹 */
/**********************************/
DROP TABLE categrp;
DROP TABLE categrp CASCADE CONSTRAINTS;
CREATE TABLE categrp(
		categrpno                     		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		name                          		VARCHAR2(50)		 NOT NULL,
		seqno                         		NUMBER(7)		 DEFAULT 0		 NOT NULL,
		visible                       		CHAR(1)		 DEFAULT 'Y'		 NOT NULL,
		rdate                         		DATE		 NOT NULL
);

COMMENT ON TABLE categrp is '카테고리 그룹';
COMMENT ON COLUMN categrp.categrpno is '카테고리 그룹 번호';
COMMENT ON COLUMN categrp.name is '이름';
COMMENT ON COLUMN categrp.seqno is '출력 순서';
COMMENT ON COLUMN categrp.visible is '출력 모드';
COMMENT ON COLUMN categrp.rdate is '그룹 생성일';

DROP SEQUENCE categrp_seq;

CREATE SEQUENCE categrp_seq
  START WITH 1                -- 시작 번호
  INCREMENT BY 1            -- 증가값
  MAXVALUE 9999999999  -- 최대값: 9999999999 --> NUMBER(10) 대응
  CACHE 2                        -- 2번은 메모리에서만 계산
  NOCYCLE;                      -- 다시 1부터 생성되는 것을 방지
  
-- Create, 등록
INSERT INTO categrp(categrpno, name, seqno, visible, rdate)
VALUES(categrp_seq.nextval, '영화', 1, 'Y', sysdate);
INSERT INTO categrp(categrpno, name, seqno, visible, rdate)
VALUES(categrp_seq.nextval, '여행', 2, 'Y', sysdate);
INSERT INTO categrp(categrpno, name, seqno, visible, rdate)
VALUES(categrp_seq.nextval, '음악', 3, 'Y', sysdate);

-- List, 목록
SELECT categrpno, name, seqno, visible, rdate
FROM categrp
ORDER BY categrpno ASC;

-- Read, 조회
SELECT categrpno, name, seqno, visible, rdate
FROM categrp
WHERE categrpno = 1;

-- Update, 수정, PK는 일반적으로 update 불가능, 컬럼의 특징을 파악후 변경여부 결정,
-- WHERE 절에 PK 컬럼 명시
UPDATE categrp
SET name='영화2', seqno=5, visible='N'
WHERE categrpno=1;

UPDATE categrp
SET name='영화', seqno=1, visible='Y'
WHERE categrpno=1;

-- Delete, 삭제
DELETE FROM categrp
WHERE categrpno=3;

SELECT * FROM categrp;

INSERT INTO categrp(categrpno, name, seqno, visible, rdate)
VALUES(categrp_seq.nextval, '음악', 3, 'Y', sysdate);

SELECT * FROM categrp;
 CATEGRPNO NAME                                                    SEQNO V RDATE              
---------- -------------------------------------------------- ---------- - -------------------
         1 영화                                                        1 Y 2021-04-01 10:09:29
         2 여행                                                        2 Y 2021-04-01 10:10:24
         4 음악                                                        3 Y 2021-04-01 10:45:56

-- 갯수, 그룹화 함수, *: 전체 컬럼, 컬럼에 null이 있으면 갯수 산정에서 제외됨, as: 컬럼에 별명 사용.
SELECT COUNT(*) FROM categrp;

  COUNT(*)  <- 컬럼명
----------
         3

SELECT COUNT(*) as cnt FROM categrp; 

       CNT  <- 컬럼명
----------
         3
         
commit;       

-- 출력 순서에따른 전체 목록
SELECT categrpno, name, seqno, visible, rdate
FROM categrp
ORDER BY seqno ASC;
 
-- 출력 순서 올림(상향), 10 ▷ 1
UPDATE categrp
SET seqno = seqno - 1
WHERE categrpno=1;
 
-- 출력순서 내림(하향), 1 ▷ 10
UPDATE categrp
SET seqno = seqno + 1
WHERE categrpno=1;

commit;

-- 출력 모드의 변경
UPDATE categrp
SET visible='Y'
WHERE categrpno=1;

SELECT * FROM categrp;

UPDATE categrp
SET visible='N'
WHERE categrpno=1;

commit;

-- 1) ORA-02449: unique/primary keys in table referenced by foreign keys
DROP TABLE categrp;

-- 2) CASCADE option을 이용한 자식 테이블을 무시한 테이블 삭제, 관련된 제약조건이 삭제됨.
DROP TABLE categrp CASCADE CONSTRAINTS;
         
        
  



  
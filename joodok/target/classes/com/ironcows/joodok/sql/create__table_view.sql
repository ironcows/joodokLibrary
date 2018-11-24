-----------------------------------------------------------------------------


-------------------            TABLE 영역            -------------------------


-----------------------------------------------------------------------------


DROP TABLE location;
CREATE TABLE location(
 locationNo     VARCHAR2(2) NOT NULL
,registeredDate DATE DEFAULT sysdate NOT NULL
,modifiedDate   DATE NULL
,locationName   VARCHAR2(30) NOT NULL
,CONSTRAINT pk_location PRIMARY KEY (locationNo)
,CONSTRAINT uq_location_locationName UNIQUE (locationName)
,CONSTRAINT ck_location_locationName CHECK (locationName IN ('중앙도서관', '대덕밸리'))
);

DROP TABLE detailLocation;
CREATE TABLE detailLocation(
 detailLocationNo   VARCHAR2(2) NOT NULL
,locationNo         VARCHAR2(2) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,detailLocationName VARCHAR2(30) NOT NULL
,CONSTRAINT pk_detailLocation PRIMARY KEY (detailLocationNo)
,CONSTRAINT ck_detailLocation_name CHECK (detailLocationName IN ('지하1층'
                                                                ,'1층'
                                                                ,'2층'
                                                                ,'3층'
                                                                ,'전공자료실'
                                                                ,'전자정보실'))
);

DROP TABLE metaBook;
CREATE TABLE metaBook(
 metaBookNo       VARCHAR2(7) NOT NULL
,registeredDate   DATE DEFAULT sysdate NOT NULL
,modifiedDate     DATE NULL
,title            VARCHAR2(200) NOT NULL
,subTitle         VARCHAR2(100) NULL
,volume           VARCHAR2(2) NULL
,author           VARCHAR2(100) NULL
,publisher        VARCHAR2(100) NULL
,isbn             VARCHAR2(13) NOT NULL
,publishYear      VARCHAR2(4) NULL
,page             VARCHAR2(4) NULL
,price            NUMBER(7, 2) NULL
,language         VARCHAR2(30) NULL
,ddc              VARCHAR2(50) NULL
,nationDivision   VARCHAR2(9) NULL
,bookType         VARCHAR2(15) NULL
,CONSTRAINT pk_metaBook PRIMARY KEY (metaBookNo)
,CONSTRAINT uq_metaBook_isbn UNIQUE (isbn)
,CONSTRAINT ck_metaBook_language CHECK (language IN ('한국어', '중국어', '일본어'
                                                    ,'영어', '독어', '불어'
                                                    ,'스페인어', '러시아어', '이탈리아어'
                                                    ,'라틴어', '기타'))
,CONSTRAINT ck_metaBook_ddc CHECK (ddc IN ('컴퓨터 과학, 정보 총류', '철학, 심리학'
                                          ,'종교', '사회과학', '언어', '과학'
                                          ,'기술', '예술, 레크리에이션'
                                          ,'문학', '역사, 지리'))
,CONSTRAINT ck_metaBook_nationDivision CHECK (nationDivision IN ('국내서', '국외서'))
,CONSTRAINT ck_metaBook_bookType CHECK (bookType IN ('단행본', '시청각자료'))                                         
);

DROP TABLE bookDetail;
CREATE TABLE bookDetail(
 bookDetailNo       VARCHAR2(7) NOT NULL
,metaBookNo         VARCHAR2(7) NOT NULL
,detailLocationNo   VARCHAR2(2) NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,duplicate          VARCHAR2(2) NULL
,applicationMark    VARCHAR2(50) NULL
,purpose            VARCHAR2(12) NULL
,borrowStatus       VARCHAR2(1) NOT NULL
,discard            VARCHAR2(1) NULL
,CONSTRAINT pk_detailBook PRIMARY KEY (bookDetailNo)
,CONSTRAINT uq_detailBook_applicationMark UNIQUE (applicationMark)
,CONSTRAINT ck_bookDetail_purpose CHECK (purpose IN ('일반도서', '전공도서', '참고도서', '업무용', '지정도서'))
,CONSTRAINT ck_bookDetail_borrowStatus CHECK (borrowStatus IN ('Y', 'N'))
,CONSTRAINT ck_bookDetail_discard CHECK (discard IN ('Y', NULL))
);

DROP TABLE discardBook;
CREATE TABLE discardBook(
 discardBookNo      VARCHAR2(10) NOT NULL
,bookDetailNo       VARCHAR2(10) NOT NUlL
,librarianNo        VARCHAR2(4) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,discardReason      VARCHAR2(50) NULL
,CONSTRAINT pk_discardBook PRIMARY KEY (discardBookNo)
);

DROP TABLE borrow;
CREATE TABLE borrow(
 borrowNo       VARCHAR2(10) NOT NULL
,memberNo       VARCHAR2(7) NOT NULL
,bookDetailNo   VARCHAR2(10) NOT NULL
,registeredDate DATE DEFAULT sysdate NOT NULL
,modifiedDate   DATE NULL
,status         VARCHAR2(6) NOT NULL
,dueDate        DATE NOT NULL
,returnedDate   DATE NULL
,CONSTRAINT pk_borrow PRIMARY KEY (borrowNo)
,CONSTRAINT ck_borrow_status CHECK (status IN ('대출', '반납', '연체'))   
);

DROP TABLE member;
CREATE TABLE member(
 memberNo           VARCHAR2(7) NOT NULL
,gradeNo            VARCHAR2(2) NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,id                 VARCHAR2(8) NOT NULL
,password           VARCHAR2(20) NOT NULL
,name               VARCHAR2(20) NOT NULL
,contactNumber      VARCHAR2(11) NULL
,email              VARCHAR2(50) NULL
,CONSTRAINT pk_member PRIMARY KEY (memberNo)
,CONSTRAINT uq_member_id UNIQUE (id)
);

DROP TABLE reservation;
CREATE TABLE reservation(
 reservationNo      VARCHAR2(10) NOT NULL
,bookDetailNo       VARCHAR2(10) NOT NULL
,memberNo           VARCHAR2(7)  NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,status             VARCHAR2(15) NOT NULL
,CONSTRAINT pk_reservation PRIMARY KEY (reservationNo)
,CONSTRAINT ck_reservation_status CHECK (status IN ('예약', '완료'))
);

DROP TABLE requestBook;
CREATE TABLE requestBook(
 requestBookNo      VARCHAR2(10) NOT NULL
,memberNo           VARCHAR2(7) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,status             VARCHAR2(6) NOT NULL
,requestIsbn        VARCHAR2(13) NULL
,subject            VARCHAR2(200) NOT NULL
,content            NCLOB DEFAULT empty_clob() NULL 
,CONSTRAINT pk_requestBook PRIMARY KEY (requestBookNo) 
,CONSTRAINT ck_requestBook_status CHECK (status IN ('요청', '접수', '완료'))           
);

DROP TABLE grade;
CREATE TABLE grade(
 gradeNo            VARCHAR2(1) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,position           VARCHAR2(6) NOT NULL
,possibleBorrowDay  NUMBER(2) NULL
,CONSTRAINT pk_grade PRIMARY KEY (gradeNo)    
,CONSTRAINT ck_grade_position CHECK (position IN ('학생', '교수'))    
);

DROP TABLE librarian;
CREATE TABLE librarian(
 librarianNo        VARCHAR2(4) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,id                 VARCHAR2(6) NOT NULL
,password           VARCHAR2(20) NOT NULL
,name               VARCHAR2(15) NOT NULL
,contactNumber      VARCHAR2(11) NULL
,CONSTRAINT pk_librarian PRIMARY KEY (librarianNo)    
,CONSTRAINT uq_librarian_id UNIQUE (id)
);

DROP TABLE acquisition;
CREATE TABLE acquisition(
 acquisitionNo      VARCHAR2(10) NOT NULL
,librarianNo        VARCHAR2(4) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,category           VARCHAR2(6) NULL
,acquisitionIsbn    VARCHAR2(13) NOT NULL
,CONSTRAINT pk_acquisition PRIMARY KEY (acquisitionNo)    
,CONSTRAINT ck_acquisition_category CHECK (category IN ('기증', '요청', '선정'))    
);

DROP TABLE checkUp;
CREATE TABLE checkUp(
 checkUpNo          VARCHAR2(10) NOT NULL
,librarianNo        VARCHAR2(4) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,CONSTRAINT pk_checkUp PRIMARY KEY (checkUpNo)    
);

DROP TABLE checkUpList;
CREATE TABLE checkUpList(
 checkUpListNo      VARCHAR2(10) NOT NULL
,acquisitionNo      VARCHAR2(10) NOT NULL
,checkUpNo          VARCHAR2(10) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,checkUpResult      VARCHAR2(9) NOT NULL
,memo               VARCHAR2(50) NULL
,checkUpIsbn        VARCHAR2(13) NOT NULL
,registeredOrNot    VARCHAR2(1) NULL
,CONSTRAINT pk_checkUpList PRIMARY KEY (checkUpListNo) 
,CONSTRAINT ck_checkUpList_checkUpResult CHECK (checkUpResult IN ('합격', '불합격'))     
,CONSTRAINT ck_checkUpList_registeredOrNot CHECK (registeredOrNot IN ('Y', NULL))
);

DROP TABLE orders;
CREATE TABLE orders(
 orderNo        VARCHAR2(10) NOT NULL
,librarianNo    VARCHAR2(4) NOT NULL
,tradeEnterpriseNo  VARCHAR2(4) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,CONSTRAINT pk_orders PRIMARY KEY (orderNo)    
);

DROP TABLE orderDetail;
CREATE TABLE orderDetail(
 orderDetailNo      VARCHAR2(10) NOT NULL
,orderNo            VARCHAR2(10) NOT NULL
,registeredDate     DATE DEFAULT sysdate NOT NULL
,modifiedDate       DATE NULL
,orderIsbn          VARCHAR2(13) NOT NULL
,orderCount         NUMBER(4) NULL
,CONSTRAINT pk_orderDetail PRIMARY KEY (orderDetailNo)  
);

DROP TABLE budget;
CREATE TABLE budget(
 budgetNo             VARCHAR2(6) NOT NULL
,registeredDate       DATE DEFAULT sysdate NOT NULL
,modifiedDate         DATE NULL
,year                 VARCHAR2(4) NULL
,quarter              VARCHAR2(1) NULL
,allocation           NUMBER(10, 2) NULL
,remainder            NUMBER(10, 2) NULL
,limit                NUMBER(10, 2) NULL
,budgetClassification VARCHAR2(15) NOT NULL
,CONSTRAINT pk_budget PRIMARY KEY (budgetNo)  
,CONSTRAINT ck_budget_quarter CHECK (quarter IN ('1', '2', '3', '4')) 
,CONSTRAINT ck_budget_budgetClassification CHECK (budgetClassification IN ('도서관계정', '국고보조비')) 
);

DROP TABLE tradeEnterprise;
CREATE TABLE tradeEnterprise(
 tradeEnterpriseNo    VARCHAR2(4) NOT NULL
,registeredDate       DATE DEFAULT sysdate NOT NULL
,modifiedDate         DATE NULL
,name                 VARCHAR2(50) NOT NULL
,type                 VARCHAR2(9) NULL
,category             VARCHAR2(12) NULL
,bankName             VARCHAR2(50) NULL
,account              VARCHAR2(30) NULL
,creditGrade          VARCHAR2(1) NULL
,deliveryPeriod       NUMBER(2) NULL
,contactNumber        VARCHAR2(12) NULL
,fax                  VARCHAR2(11) NULL
,address              VARCHAR2(200) NULL
,webAddress           VARCHAR2(100) NULL
,CONSTRAINT pk_tradeEnterprise PRIMARY KEY (tradeEnterpriseNo)  
,CONSTRAINT uq_tradeEnterprise_name UNIQUE (name)
,CONSTRAINT ck_tradeEnterprise_category CHECK (category IN ('교내기관', '외부기관'))
);




-----------------------------------------------------------------------------


-------------------            VIEW 영역            -------------------------


-----------------------------------------------------------------------------


CREATE OR REPLACE VIEW v_member_borrow
AS
SELECT b.borrowNo
      ,bd.bookDetailNo
      ,mb.title
      ,mb.subTitle
      ,bd.applicationMark
      ,b.registeredDate
      ,b.dueDate
      ,b.status
      ,b.memberNo
  FROM borrow b, bookDetail bd, metaBook mb
 WHERE b.bookDetailNo = bd.bookDetailNo
   AND bd.metaBookNo = mb.metaBookNo
   AND b.status IN ('연체', '대출')
 ORDER BY b.dueDate ASC
;


CREATE OR REPLACE VIEW v_member_info
AS
SELECT m.memberNo
      ,m.id
      ,m.password
      ,m.name
      ,g.position
      ,g.possibleBorrowDay
      ,m.contactNumber
      ,m.email
  FROM member m, grade g
 WHERE m.gradeNo = g.gradeNo
;


CREATE OR REPLACE VIEW v_member_reservation
AS
SELECT r.reservationNo
      ,r.registeredDate
      ,mb.title
      ,mb.subTitle
      ,bd.applicationMark
      ,r.status
      ,r.memberNo
  FROM reservation r, bookDetail bd, metaBook mb
 WHERE r.bookDetailNo = bd.bookDetailNo
   AND bd.metaBookNo = mb.metaBookNo
   AND r.status IN ('대출대기', '예약')
;


CREATE OR REPLACE VIEW v_bookDetail_latest_borrow
AS
SELECT br.borrowNo
      ,br.bookDetailNo
      ,br.dueDate
      ,br.returnedDate
  FROM borrow br
 WHERE (br.registeredDate, br.bookDetailNo) IN (SELECT MAX(br.registeredDate)
                                                  ,bd.bookDetailNo
                                              FROM borrow br, bookDetail bd
                                             WHERE br.bookDetailNo = bd.bookDetailNo
                                             GROUP BY bd.bookDetailNo)
;

CREATE OR REPLACE VIEW v_see_book_detail
AS
SELECT bd.bookDetailNo
      ,bd.applicationMark
      ,DECODE(bd.borrowStatus, 'N', '대출중'
                             , 'Y', '대출가능') AS borrowStatus
      ,l.locationName
      ,dt.detailLocationName
      ,bd.metaBookNo
      ,CASE WHEN v.returnedDate IS NULL THEN TO_CHAR(v.dueDate, 'YYYY-MM-DD')
       ELSE NULL
       END dueDate
      ,bd.purpose
      ,bd.duplicate
  FROM bookDetail bd, detailLocation dt, location l, v_bookDetail_latest_borrow v
 WHERE bd.detailLocationNo = dt.detailLocationNo
   AND dt.locationNo = l.locationNo
   AND bd.bookDetailNo = v.bookDetailNo(+)
   AND bd.discard IS NULL
 ORDER BY bd.bookDetailNo ASC
;

CREATE OR REPLACE VIEW v_member_possibleBorrowDay
AS
SELECT m.memberNo
      ,m.id
      ,m.name
      ,TO_CHAR(sysdate + g.possibleBorrowDay, 'YYYY-MM-DD') as dueDate
  FROM member m, grade g
 WHERE m.gradeNo = g.gradeNo
;



CREATE OR REPLACE VIEW v_bookInfo_with_discard
AS
SELECT bd.bookDetailNo
      ,mb.title
      ,mb.subTitle
      ,mb.volume
      ,bd.applicationMark
      ,bd.borrowStatus
      ,bd.discard
  FROM bookDetail bd, metaBook mb
 WHERE bd.metaBookNo = mb.metaBookNo
;

CREATE OR REPLACE VIEW v_ready_checkUpList
AS
SELECT a.acquisitionNo
      ,a.registeredDate
      ,a.category
      ,a.acquisitionIsbn
  FROM acquisition a
 WHERE a.acquisitionIsbn NOT IN (SELECT c.checkUpIsbn
                                   FROM checkUpList c)
 ORDER BY a.registeredDate ASC
;

CREATE OR REPLACE VIEW v_ready_metaBook
AS
SELECT a.acquisitionNo
      ,a.registeredDate
      ,a.category
      ,a.acquisitionIsbn
  FROM acquisition a
 WHERE a.acquisitionIsbn NOT IN (SELECT mb.isbn
                                 FROM metaBook mb)
 ORDER BY a.registeredDate ASC
;


CREATE OR REPLACE VIEW v_unRegistered_checkUpList
AS
SELECT TO_CHAR(count(*)) as num
      ,c.checkUpIsbn
      ,mb.title
      ,mb.author
      ,mb.publisher
  FROM checkUpList c, metaBook mb
 WHERE c.registeredOrNot IS NULL
   AND c.checkUpIsbn = mb.isbn
 GROUP BY c.checkUpIsbn, mb.title, mb.author, mb.publisher
;



CREATE OR REPLACE VIEW v_preRegistered_checkUpList
AS
SELECT cl.checkUpListNo
      ,cl.checkUpIsbn
      ,mb.title
      ,mb.author
      ,mb.publisher
      ,cl.checkUpResult
      ,mb.metaBookNo
  FROM checkUpList cl, metaBook mb
 WHERE cl.checkUpIsbn = mb.isbn
   AND cl.registeredOrNot IS NULL
;
-----------------------------------------------------------------------------


--			        완성된 쿼리문 하나를 만들기 위해 작성되는 SQL                           --


-----------------------------------------------------------------------------




SELECT mb.title
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


SELECT v.title
      ,v.subTitle
      ,v.applicationMark
      ,TO_CHAR(v.registeredDate, 'YYYY-MM-DD')
      ,TO_CHAR(v.dueDate, 'YYYY-MM-DD')
      ,v.status
  FROM v_member_borrow v
 WHERE v.memberNo = '0000003'
 ORDER BY v.dueDate ASC
 ;
 
 
SELECT m.memberNo
      ,m.id
      ,m.password
      ,m.NAME
      ,g.POSITION
      ,g.POSSIBLEBORROWDAY
      ,m.CONTACTNUMBER
      ,m.EMAIL
  FROM member m, grade g
 WHERE m.gradeNo = g.gradeNo
;

SELECT v.memberNo
      ,v.id
      ,v.password
      ,v.name
      ,v.position
      ,v.possibleBorrowDay
      ,v.contactNumber
      ,v.email
  FROM v_member_info v
 WHERE v.memberNo = '0000001'
;


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

SELECT v.reservationNo
      ,TO_CHAR(v.registeredDate, 'YYYY-MM-DD') as registeredDate
      ,v.title
      ,v.subtitle
      ,v.applicationMark
      ,v.status
      ,v.memberNo
  FROM v_member_reservation v
 WHERE v.memberNo = '0000001'
 ORDER BY v.registeredDate DESC
;


SELECT mb.metaBookNo
      ,mb.title
      ,mb.subTitle
      ,mb.author
      ,mb.publisher
      ,mb.publishYear
      ,mb.bookType
      ,mb.ddc
  FROM metaBook mb
 WHERE mb.title LIKE '%' || '트와' || '%'
;


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
  FROM bookDetail bd, detailLocation dt, location l, v_bookDetail_latest_borrow v
 WHERE bd.detailLocationNo = dt.detailLocationNo
   AND dt.locationNo = l.locationNo
   AND bd.bookDetailNo = v.bookDetailNo(+)
   AND bd.discard IS NULL
 ORDER BY bd.bookDetailNo ASC
;





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


SELECT v.bookDetailNo
      ,v.applicationMark
      ,v.borrowStatus
      ,v.locationName
      ,v.detailLocationName
      ,v.metaBookNo
      ,v.dueDate
      ,v.purpose
      ,v.duplicate
  FROM v_see_book_detail v
 WHERE v.metaBookNo = '0000004'
;


SELECT rb.requestBookNo
      ,rb.status
      ,TO_CHAR(rb.subject) AS subject
      ,TO_CHAR(rb.registeredDate, 'YYYY-MM-DD') AS registeredDate
  FROM requestBook rb
 WHERE rb.memberNo = '0000001'
 ORDER BY rb.registeredDate DESC
;


SELECT rb.requestBookNo
  FROM requestBook rb
;
--SUBSTR(str, i, n) 를 이용해서 YYMMDD 부분을 제거. i는 시작 위치이고 주의할 점은 시작이 1부터임
SELECT SUBSTR(rb.requestBookNo, 7, 4)
  FROM requestBook rb
;
--위 쿼리에서 추출한 값은 여러개이므로 가장 높은 값을 구한다.
SELECT MAX(SUBSTR(rb.requestBookNo, 7, 4))
  FROM requestBook rb
;
--위 쿼리에서 추출한 결과에 +1를 해야하므로 000 부분을 제거하고 +1 한 후에 LPAD를 이용해 나머지 자리를 0으로 채운다.
--LPAD,RAPD(str, n, char)
SELECT LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0')
  FROM requestBook rb
;
--오늘하고 같은 날짜에 requestBookNo 가 있으면 위 쿼리를 실행하도록 하고, 없으면 새로운 값(오늘날짜0001)을 부여
--NVL(expr1, expr2) 을 통해 NULL, NOT NULL 분기
SELECT rb.requestBookNo
  FROM requestBook rb
 WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6)
;
SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
  FROM requestBook rb
 WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6)
;

SELECT rb.requestBookNo 
      ,rb.memberNo
      ,TO_CHAR(rb.registeredDate, 'YYYY-MM-DD HH24:MI:SS')
      ,rb.modifiedDate
      ,rb.status
      ,rb.requestIsbn
      ,rb.subject
      ,TO_CHAR(rb.content) AS content
  FROM requestBook rb
 WHERE rb.requestBookNo = '1805100002'
;


SELECT rownum
      ,rb.requestBookNo
      ,rb.status
      ,rb.subject
      ,rb.registeredDate
  FROM requestBook rb
 WHERE rb.memberNo = '0000001'
 ORDER BY rb.registeredDate DESC
;

SELECT rownum as rnum
      ,A.requestBookNo
      ,A.status
      ,A.subject
      ,A.registeredDate
  FROM (SELECT rb.requestBookNo
              ,rb.status
              ,rb.subject
              ,rb.registeredDate
          FROM requestBook rb
         WHERE rb.memberNo = '0000001'
         ORDER BY rb.registeredDate DESC) A
;


SELECT TO_CHAR(X.rnum) AS rnum
      ,X.requestBookNo
      ,X.status
      ,TO_CHAR(X.subject) AS subject
      ,TO_CHAR(X.registeredDate, 'YYYY-MM-DD') AS registeredDate
  FROM (SELECT rownum as rnum
              ,A.requestBookNo
              ,A.status
              ,A.subject
              ,A.registeredDate
          FROM (SELECT rb.requestBookNo
                      ,rb.status
                      ,rb.subject
                      ,rb.registeredDate
                  FROM requestBook rb
                 WHERE rb.memberNo = '0000001'
                 ORDER BY rb.registeredDate DESC) A
         WHERE rownum < (1 + 10) ) X
 WHERE X.rnum >= 1 
;

SELECT count(*)
  FROM requestBook rb
 WHERE rb.memberNo = '0000001'
;


SELECT r.reservationNo
      ,r.memberNo
  FROM reservation r
 WHERE r.bookDetailNo = '0000005'
   AND r.status = '예약'
;


SELECT *
  FROM member m
 WHERE m.memberNo = '0000001'
;

SELECT m.memberNo
      ,m.id
      ,m.name
      ,g.possibleBorrowDay
  FROM member m, grade g
 WHERE m.gradeNo = g.gradeNo
;

SELECT m.memberNo
      ,m.id
      ,m.name
      ,g.possibleBorrowDay
  FROM member m, grade g
 WHERE m.memberNo = '0000001'
   AND m.gradeNo = g.gradeNo
;
SELECT v.memberNo
      ,v.id
      ,v.name
      ,v.dueDate
  FROM v_member_possibleBorrowDay v
 WHERE v.id = '20121623'
;


SELECT v.title
      ,v.subTitle
      ,v.applicationMark
      ,TO_CHAR(v.registeredDate, 'YYYY-MM-DD')
      ,TO_CHAR(v.dueDate, 'YYYY-MM-DD')
      ,v.status
  FROM v_member_borrow v
 WHERE v.memberNo = '0000002'
 ORDER BY v.dueDate ASC
;

SELECT bd.bookDetailNo 
      ,TO_CHAR(mb.title) as title
      ,CASE WHEN mb.subTitle IS NULL THEN ' '
            ELSE mb.subTitle
            END subTitle
      ,CASE WHEN mb.volume IS NULL THEN ' '
            ELSE mb.volume
            END volume
      ,bd.applicationMark
  FROM bookDetail bd, metaBook mb
 WHERE bd.metaBookNo = mb.metaBookNo
   AND bd.bookDetailNo = '0000002'
;

SELECT v.borrowNo
      ,v.bookDetailNo
      ,v.title
      ,v.subTitle
      ,v.applicationMark
      ,TO_CHAR(v.registeredDate, 'YYYY-MM-DD') as borrowDay
      ,v.memberNo
  FROM v_member_borrow v
 WHERE v.bookDetailNo = '0000002'
 ORDER BY v.registeredDate ASC
;


SELECT v.bookDetailNo
      ,v.title
      ,v.subTitle
      ,v.volume
      ,v.applicationMark
      ,v.borrowStatus
      ,v.discard
  FROM v_bookInfo_with_discard v
;



SELECT a.acquisitionIsbn
  FROM acquisition a
 WHERE a.category NOT IN ('기증')
;

SELECT cl.checkUpIsbn
  FROM checkUpList cl
;

SELECT a.acquisitionIsbn
  FROM acquisition a
 WHERE a.category NOT IN ('기증')
MINUS
SELECT cl.checkUpIsbn
  FROM checkUpList cl
;

SELECT acquisitionNo 
      ,a.category
      ,a.acquisitionIsbn
      ,TO_CHAR(a.registeredDate, 'YYYY-MM-DD') as registeredDate
  FROM acquisition a
 WHERE a.acquisitionIsbn IN (SELECT a.acquisitionIsbn
                                   FROM acquisition a
                                  WHERE a.category NOT IN ('기증')
                                  MINUS
                                 SELECT cl.checkUpIsbn
                                   FROM checkUpList cl)
ORDER BY a.registeredDate ASC
;

SELECT o.orderNo
  FROM orders o
 WHERE o.librarianNo = '0001'
   AND rownum = 1
 ORDER BY o.registeredDate DESC
;

SELECT acquisitionNo 
      ,a.category
      ,a.acquisitionIsbn
      ,TO_CHAR(a.registeredDate, 'YYYY-MM-DD') as registeredDate
  FROM acquisition a
 WHERE a.acquisitionIsbn IN (SELECT a.acquisitionIsbn
                                   FROM acquisition a
                                  WHERE a.category NOT IN ('기증')
                                  MINUS
                                 SELECT cl.checkUpIsbn
                                   FROM checkUpList cl)
   AND a.acquisitionIsbn NOT IN (SELECT od.orderIsbn
                                   FROM orderDetail od)
ORDER BY a.registeredDate ASC
;


SELECT a.acquisitionNo
      ,a.registeredDate
      ,a.category
      ,a.acquisitionIsbn
  FROM acquisition a
 WHERE a.acquisitionIsbn NOT IN (SELECT c.checkUpIsbn
                                   FROM checkUpList c)
 ORDER BY a.registeredDate ASC
;

SELECT v.acquisitionNo
      ,v.registeredDate
      ,v.category
      ,v.acquisitionIsbn
  FROM v_ready_checkUpList v
;


SELECT v.acquisitionNo
      ,v.registeredDate
      ,v.category
      ,v.acquisitionIsbn
  FROM v_ready_metaBook v
;

SELECT mb.metaBookNo
  FROM metaBook mb
;

SELECT NVL(LPAD(MAX(LTRIM(mb.metaBookNo, '0')) + 1, 7, '0'), '0000001') as metaBookNo
  FROM metaBook mb
;

SELECT *
  FROM checkUpList c
;

SELECT c.acquisitionNo
      ,count(*)
  FROM checkUpList c
 GROUP BY c.acquisitionNo
;

SELECT count(*) as num
      ,c.checkUpIsbn
      ,mb.title
      ,mb.author
      ,mb.publisher
  FROM checkUpList c, metaBook mb
 WHERE c.registeredOrNot IS NULL
   AND c.checkUpIsbn = mb.isbn
 GROUP BY c.checkUpIsbn, mb.title, mb.author, mb.publisher
;

SELECT cl.checkUpListNo
      ,cl.checkUpIsbn
      ,mb.title
      ,mb.author
      ,mb.publisher
      ,cl.checkUpResult
  FROM checkUpList cl, metaBook mb
 WHERE cl.checkUpIsbn = mb.isbn
   AND cl.registeredOrNot IS NULL
;


SELECT v.num
      ,v.checkUpIsbn
      ,v.title
      ,v.author
      ,v.publisher
  FROM v_unRegistered_checkUpList v
;


SELECT v.checkUpListNo
      ,v.checkUpIsbn
      ,v.title
      ,v.author
      ,v.publisher
      ,v.checkUpResult
      ,v.metaBookNo
  FROM v_preRegistered_checkUpList v
 WHERE v.checkUpIsbn = '5455455455599'
;

UPDATE checkUpList cl
   SET cl.registeredOrNot = 'Y',
       cl.modifiedDate = sysdate
 WHERE cl.checkUpListNo = '1805300001'
;
SELECT *
  FROM checkUpList
 WHERE checkUpListNo = '1805300001'
 ;

SELECT v.borrowNo
      ,v.bookDetailNo
      ,v.title
      ,v.subTitle
      ,v.applicationMark
      ,v.registeredDate
      ,v.dueDate
      ,v.status
      ,TO_CHAR(TRUNC(sysdate - v.duedate, 0), '00') as delayDay
      ,v.memberNo
      ,m.id
      ,m.name
  FROM v_member_borrow v, member m
 WHERE v.memberNo = m.memberNo
   AND v.status = '연체'
;


SELECT TO_CHAR(X.rnum) AS rnum
      ,X.requestBookNo
      ,X.status
      ,TO_CHAR(X.subject) AS subject
      ,TO_CHAR(X.registeredDate, 'YYYY-MM-DD') AS registeredDate
  FROM (SELECT rownum as rnum
              ,A.requestBookNo
              ,A.status
              ,A.subject
              ,A.registeredDate
          FROM (SELECT rb.requestBookNo
                      ,rb.status
                      ,rb.subject
                      ,rb.registeredDate
                  FROM requestBook rb
                 WHERE rb.status = '요청'
                 ORDER BY rb.registeredDate DESC) A
         WHERE rownum < (1 + 10) ) X
 WHERE X.rnum >= 1 
;


SELECT rb.requestBookNo 
      ,rb.memberNo
      ,m.id
      ,m.name
      ,rb.registeredDate
      ,rb.modifiedDate
      ,rb.status
      ,rb.requestIsbn
      ,rb.subject
      ,rb.content
  FROM requestBook rb, member m
 WHERE rb.memberNo = m.memberNo
   AND rb.requestBookNo = '1806050001'
;


 

SELECT NVL(LPAD(MAX(LTRIM(mb.metaBookNo, '0')) + 1, 7, '0'), '0000001') as metaBookNo
 				  FROM metaBook mb
                  ORDER BY mb.registeredDate DESC;
                  
SELECT LPAD(MAX(LTRIM(mb.metaBookNo, '0')) + 1, 7, '0')
  FROM metaBook mb
;
SELECT MAX(mb.metaBookNo)
  FROM metaBook mb
 ORDER BY mb.registeredDate DESC
;
SELECT LTRIM(MAX(mb.metaBookNo), '0') + 1
  FROM metaBook mb
 ORDER BY mb.registeredDate DESC
;
SELECT LPAD(LTRIM(MAX(mb.metaBookNo), '0') + 1, 7, '0')
  FROM metaBook mb
;


SELECT NVL(LPAD(LTRIM(MAX(bd.bookDetailNo), '0') + 1, 7, '0'), '0000001') as bookDetailNo
 				  FROM bookDetail bd
                  ;
                  
SELECT rb.requestBookNo
      ,rb.status
      ,rb.subject
      ,rb.registeredDate
  FROM requestBook rb
 WHERE rb.memberNo = '0000001'
 ORDER BY rb.requestBookNo DESC
 ;
-----------location sample-----------

INSERT INTO location(LOCATIONNO, REGISTEREDDATE, LOCATIONNAME)
VALUES('01', sysdate, '중앙도서관');

INSERT INTO location(LOCATIONNO, REGISTEREDDATE, LOCATIONNAME)
VALUES('02', sysdate, '대덕밸리');


-----------detailLocation sample-----------

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('01', '01', sysdate, '지하1층');

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('02', '01', sysdate, '1층');

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('03', '01', sysdate, '2층');

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('04', '01', sysdate, '3층');

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('05', '02', sysdate, '전공자료실');

INSERT INTO detailLocation(detailLocationNo, locationNo, registeredDate, detailLocationName)
VALUES('06', '02', sysdate, '전자정보실');


-----------metaBook sample-----------

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000001', '2018-03-16', '어린왕자', NULL, NULL, '생텍쥐페리', '문학동네', '9788954603096', '2007', '147', 8000, '한국어', '문학', '국외서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000002', '2018-03-16', '지금, 만나러 갑니다', NULL, NULL, '이치카와 다쿠지', '알에이치코리아', '9788925563428', '2018', '408', 13800, '한국어', '문학', '국외서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000003', '2018-03-16', '살인자의 기억법', NULL, NULL, '김영하', '문학동네', '9788954622035', '2013', '176', 10000, '한국어', '문학', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000004', '2018-03-16', '트와일라잇', NULL, '01', '스테파니 메이어', '북폴리오', '9788937832208', '2008', '564', 13000, '한국어', '문학', '국외서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000005', '2018-03-20', 'LAN이란 이런것이다!', NULL, '01', '지일구', '성원', '8975400107', '1993', '342', 7000, '한국어', '컴퓨터 과학, 정보 총류', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000006', '2018-03-22', '눈물은 왜 짠가', NULL, '01', '함민복', '이레', '8957090002', '2003', '206', 10800, '한국어', '문학', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000007', '2018-03-25', '인도에 두고 온 눈물', '땡초 현몽의 기상천외한 인도 체험기', '01', '현몽', '창해', '8979190972', '1998', '394', 8000, '한국어', '문학', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000008', '2018-03-25', '눈물이, 부질없는 눈물이', 'Tears, idle tears', '01', 'Tennyson Alfred Lord', '민음사', '8937418002', '1995', '144', 6000, '한국어', '문학', '국외서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000009', '2018-03-26', '여자가 눈물을 흘릴 때', NULL, '01', '용인순', '삶과함께', '8976910028', '1993', '319', 5500, '한국어', '문학', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000010', '2018-03-26', '너는 눈부시지만 나는 눈물겹다', NULL, '01', '이정하', '푸른숲', '8971840803', '1994', '100', 4500, '한국어', '문학', '국내서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000011', '2018-06-28', '공주님', NULL, '01', '야마다 에이미', '민음사', '8937480107', '2003', '254', 9000, '한국어', '문학', '국외서', '단행본');

INSERT INTO metaBook(metaBookNo, registeredDate, title, subTitle, volume, author, publisher, isbn, publishYear, page, price, language, ddc, nationDivision, bookType)
VALUES('0000012', '2018-07-11', '마지막 왕자', NULL, '01', '강숙인', '푸른책들', '9788957980934', '2007', '183', 12500, '한국어', '문학', '국내서', '단행본');



-----------bookDetail sample-----------

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus)
VALUES('0000001', '0000001', '02', '2018-03-16', '1', '843 S137pKㄱㅎ', '일반도서', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus)
VALUES('0000002', '0000002', '03', '2018-03-16', '1', '895.636 시813ㅇKㅇ 2018', '일반도서', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus)
VALUES('0000003', '0000003', '03', '2018-03-16', '1', '813.6 김648ㅅ', '일반도서', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus)
VALUES('0000004', '0000004', '03', '2018-03-16', '1', '823.54 M613tK벼', '일반도서', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus)
VALUES('0000005', '0000004', '03', '2018-03-16', '2', '823.54 M613tK벼 c.2', '일반도서', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000006', '0000004', '03', '2018-03-16', NULL, NULL, '일반도서', 'Y', 'Y');

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000007', '0000005', '01', '2018-03-25', '1', '004.68 지69ℓ', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000008', '0000005', '01', '2018-03-25', '2', '004.68 지69ℓ c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000009', '0000005', '01', '2018-03-25', '3', '004.68 지69ℓ c.3', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000010', '0000005', '01', '2018-03-25', '4', '004.68 지69ℓ c.4', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000011', '0000005', '01', '2018-03-25', '5', '004.68 지69ℓ c.5', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000012', '0000006', '03', '2018-03-25', '1', '814.6 함394ㄴ', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000013', '0000006', '03', '2018-03-25', '2', '814.6 함394ㄴ c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000014', '0000007', '03', '2018-04-02', '1', '915.404 현35ㅇ', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000015', '0000007', '03', '2018-04-02', '2', '915.404 현35ㅇ c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000016', '0000008', '03', '2018-04-02', '1', '821.8 T312tKㅇ 1995', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000017', '0000008', '03', '2018-04-02', '2', '821.8 T312tKㅇ 1995 c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000018', '0000009', '03', '2018-04-02', '1', '818.6 용69ㅇ', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000019', '0000009', '03', '2018-04-02', '2', '818.6 용69ㅇ c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000020', '0000010', '03', '2018-04-02', '1', '811.6 이73ㄴ', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000021', '0000010', '03', '2018-04-02', '2', '811.6 이73ㄴ c.2', '일반도서', 'Y', NULL);

INSERT INTO bookDetail(bookDetailNo, metaBookNo, detailLocationNo, registeredDate, duplicate, applicationMark, purpose, borrowStatus, discard)
VALUES('0000022', '0000011', '03', '2018-07-05', '1', '895.636 산73ㅎKㄱ', '일반도서', 'Y', NULL);







-----------discardBook sample-----------

INSERT INTO discardBook(discardBookNo, bookDetailNo, librarianNo, registeredDate, discardReason)
VALUES('1804040001', '0000006', '0001', sysdate, '훼손');


-----------borrow sample-----------

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1804060001', '0000001', '0000002', '2018-04-06', '반납', '2018-04-20', '2018-04-16');

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1804060002', '0000001', '0000004', '2018-04-06', '반납', '2018-04-20', '2018-04-18');

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1804160001', '0000002', '0000001', '2018-04-16', '반납', '2018-04-30', '2018-04-23');

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1805030001', '0000003', '0000004', '2018-05-03', '반납', '2018-06-02', '2018-05-25');

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1805030002', '0000003', '0000003', '2018-05-03', '반납', '2018-06-02', '2018-05-25');

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1806260001', '0000001', '0000018', '2018-06-26', '연체', '2018-07-10', NULL);

UPDATE bookDetail bd
   SET bd.borrowStatus = 'N'
      ,bd.modifiedDate = '2018-06-26'
 WHERE bd.bookDetailNo = '0000018'
;

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1806260002', '0000001', '0000020', '2018-06-26', '연체', '2018-07-10', NULL);

UPDATE bookDetail bd
   SET bd.borrowStatus = 'N'
      ,bd.modifiedDate = '2018-06-26'
 WHERE bd.bookDetailNo = '0000020'
;

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1807100001', '0000003', '0000014', '2018-07-10', '대출', '2018-08-09', NULL);

UPDATE bookDetail bd
   SET bd.borrowStatus = 'N'
      ,bd.modifiedDate = '2018-07-10'
 WHERE bd.bookDetailNo = '0000014'
;

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1807100002', '0000003', '0000013', '2018-07-10', '대출', '2018-08-09', NULL);

UPDATE bookDetail bd
   SET bd.borrowStatus = 'N'
      ,bd.modifiedDate = '2018-07-10'
 WHERE bd.bookDetailNo = '0000013'
;

INSERT INTO borrow(borrowNo, memberNo, bookDetailNo, registeredDate, status, dueDate, returnedDate)
VALUES('1807100003', '0000003', '0000008', '2018-07-10', '대출', '2018-08-09', NULL);

UPDATE bookDetail bd
   SET bd.borrowStatus = 'N'
      ,bd.modifiedDate = '2018-07-10'
 WHERE bd.bookDetailNo = '0000008'
;





-----------member sample-----------

INSERT INTO member(memberNo, gradeNo, registeredDate, id, password, name, contactNumber, email)
VALUES('0000001', '1', sysdate, '20111597', '1234', '신철우', '01050055229', 'qadond@naver.com');

INSERT INTO member(memberNo, gradeNo, registeredDate, id, password, name, contactNumber, email)
VALUES('0000002', '1', sysdate, '20121623', '1234', '김행', '01046342191', 'haengkim@naver.com');

INSERT INTO member(memberNo, gradeNo, registeredDate, id, password, name, contactNumber, email)
VALUES('0000003', '2', sysdate, '061485', '1234', '강신철', '01044004040', 'ntiskang@gmail.com');





-----------reservation sample-----------

INSERT INTO reservation(reservationNo, bookDetailNo, memberNo, registeredDate, status)
VALUES('1807110001', '0000005', '0000002', '2018-07-11', '예약');




-----------requestBook sample-----------

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES('1805090001', '0000001', '해리포터 시리즈 신청합니다.', '해리포터 시리즈가 보고 싶어요. ~!~!','2018-05-09', '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', '반지의제왕 시리즈 신청합니다.', '반지의제왕 시리즈가 보고 싶어요. ~!~!', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플2', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플3', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플4', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플5', '샘플 내용', sysdate, '요청', NULL);       

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플6', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플7', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플8', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플9', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플10', '샘플 내용', sysdate, '요청', NULL);      

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플11', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플12', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플13', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플14', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플15', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플16', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플17', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플18', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플19', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플20', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플21', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플22', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플23', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플24', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플25', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플26', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플27', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플28', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플29', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000002', 'PAGE 출력 확인용 샘플30', '샘플 내용', sysdate, '요청', NULL);      

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플31', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플32', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플33', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플34', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플35', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플36', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플37', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플38', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플39', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플40', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플41', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플42', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플43', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플44', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플45', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플46', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플47', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플48', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플49', '샘플 내용', sysdate, '요청', NULL);

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', 'PAGE 출력 확인용 샘플50', '샘플 내용', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', '함부로 설레는 마음', '이정현 작가의 신작, 함부로 설레는 마음이 꼭 보고 싶어서 신청합니다!', sysdate, '요청', NULL); 

INSERT INTO requestBook(requestBookNo, memberNo, subject, content, registeredDate, status, requestIsbn)
VALUES((SELECT TO_CHAR(sysdate, 'YYMMDD')||NVL(LPAD(MAX(SUBSTR(rb.requestBookNo, 7, 4))+1, 4, '0'), '0001')
			     FROM requestBook rb
			    WHERE TO_CHAR(sysdate, 'YYMMDD') = SUBSTR(rb.requestBookNo, 1, 6))
       , '0000001', '정보처리기사 최신 문제집 또는 요약집', '정보처리기사 자격증 공부중인데 최신 문제집 구비해주세요', sysdate, '요청', NULL); 



-----------grade sample-----------

INSERT INTO grade(gradeNo, registeredDate, position, possibleBorrowDay)
VALUES('1', sysdate, '학생', 15);

INSERT INTO grade(gradeNo, registeredDate, position, possibleBorrowDay)
VALUES('2', sysdate, '교수', 30);


-----------librarian sample-----------

INSERT INTO librarian(librarianNo, registeredDate, id, password, name, contactNumber)
VALUES('0001', sysdate, '140001', '0000', '전종윤', '01027223725');

INSERT INTO librarian(librarianNo, registeredDate, id, password, name, contactNumber)
VALUES('0002', sysdate, '140002', '0000', '이권율', '01045871548');



-----------acquisition sample-----------

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803030001', '0001', '2018-03-03', '선정', '9788954603096');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803030002', '0001', '2018-03-03', '선정', '9788925563428');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803030003', '0001', '2018-03-03', '선정', '9788954622035');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803030004', '0001', '2018-03-03', '선정', '9788937832208');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803200001', '0001', '2018-03-20', '선정', '8975400107');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803220001', '0001', '2018-03-22', '선정', '8957090002');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803250001', '0001', '2018-03-25', '선정', '8979190972');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803250002', '0001', '2018-03-25', '선정', '8937418002');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803260001', '0001', '2018-03-26', '선정', '8976910028');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1803260002', '0001', '2018-03-26', '선정', '8971840803');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1806280001', '0001', '2018-06-28', '선정', '8937480107');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1807110001', '0001', '2018-07-11', '선정', '9788957980934');

INSERT INTO acquisition(acquisitionNo, librarianNo, registeredDate, category, acquisitionIsbn)
VALUES('1807110002', '0001', '2018-07-11', '선정', '8985599135');





-----------checkUp sample-----------

INSERT INTO checkUp(checkUpNo, librarianNo, registeredDate)
VALUES('1803150001', '0002', '2018-03-15');

INSERT INTO checkUp(checkUpNo, librarianNo, registeredDate)
VALUES('1803250001', '0002', '2018-03-25');

INSERT INTO checkUp(checkUpNo, librarianNo, registeredDate)
VALUES('1804020001', '0002', '2018-04-02');

INSERT INTO checkUp(checkUpNo, librarianNo, registeredDate)
VALUES('1807050001', '0002', '2018-07-05');



-----------checkUpList sample-----------

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150001', '1803030001', '1803150001', '2018-03-15', '합격', '9788954603096', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150002', '1803030002', '1803150001', '2018-03-15', '합격', '9788925563428', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150003', '1803030003', '1803150001', '2018-03-15', '합격', '9788954622035', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150004', '1803030004', '1803150001', '2018-03-15', '합격', '9788937832208', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150005', '1803030004', '1803150001', '2018-03-15', '합격', '9788937832208', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803150006', '1803030004', '1803150001', '2018-03-15', '합격', '9788937832208', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250001', '1803200001', '1803250001', '2018-03-25', '합격', '8975400107', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250002', '1803200001', '1803250001', '2018-03-25', '합격', '8975400107', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250003', '1803200001', '1803250001', '2018-03-25', '합격', '8975400107', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250004', '1803200001', '1803250001', '2018-03-25', '합격', '8975400107', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250005', '1803200001', '1803250001', '2018-03-25', '합격', '8975400107', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250006', '1803220001', '1803250001', '2018-03-25', '합격', '8957090002', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1803250007', '1803220001', '1803250001', '2018-03-25', '합격', '8957090002', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020001', '1803250001', '1804020001', '2018-04-02', '합격', '8979190972', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020002', '1803250001', '1804020001', '2018-04-02', '합격', '8979190972', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020003', '1803250002', '1804020001', '2018-04-02', '합격', '8937418002', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020004', '1803250002', '1804020001', '2018-04-02', '합격', '8937418002', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020005', '1803260001', '1804020001', '2018-04-02', '합격', '8976910028', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020006', '1803260001', '1804020001', '2018-04-02', '합격', '8976910028', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020007', '1803260002', '1804020001', '2018-04-02', '합격', '8971840803', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1804020008', '1803260002', '1804020001', '2018-04-02', '합격', '8971840803', 'Y');

INSERT INTO checkUpList(checkUpListNo, acquisitionNo, checkUpNo, registeredDate, checkUpResult, checkUpIsbn, registeredOrNot)
VALUES('1807050001', '1806280001', '1807050001', '2018-07-05', '합격', '8937480107', 'Y');




-----------order sample-----------

INSERT INTO orders(orderNo, librarianNo, tradeEnterpriseNo, registeredDate)
VALUES('1803080001', '0001', '0001', '2018-03-08');

INSERT INTO orders(orderNo, librarianNo, tradeEnterpriseNo, registeredDate)
VALUES('1803220001', '0001', '0001', '2018-03-22');

INSERT INTO orders(orderNo, librarianNo, tradeEnterpriseNo, registeredDate)
VALUES('1803260001', '0001', '0001', '2018-03-26');

INSERT INTO orders(orderNo, librarianNo, tradeEnterpriseNo, registeredDate)
VALUES('1806280001', '0001', '0001', '2018-06-28');




-----------orderDetail sample-----------

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803080001', '1803080001', '2018-03-08', '9788954603096', 1);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803080002', '1803080001', '2018-03-08', '9788925563428', 1);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803080003', '1803080001', '2018-03-08', '9788954622035', 1);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803080004', '1803080001', '2018-03-08', '9788937832208', 3);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803220001', '1803220001', '2018-03-22', '8975400107', 5);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803220002', '1803220001', '2018-03-22', '8957090002', 2);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803260001', '1803260001', '2018-03-26', '8979190972', 2);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803260002', '1803260001', '2018-03-26', '8937418002', 2);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803260003', '1803260001', '2018-03-26', '8976910028', 2);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1803260004', '1803260001', '2018-03-26', '8971840803', 2);

INSERT INTO orderDetail(orderDetailNo, orderNo, registeredDate, orderIsbn, orderCount)
VALUES('1806280001', '1806280001', '2018-06-28', '8937480107', 2);



-----------budget sample-----------

INSERT INTO budget(budgetNo, registeredDate, year, quarter, allocation, remainder, limit, budgetClassification)
VALUES('180101', '2018-01-05', '2018', '1', 10000000, 10000000, 10000000, '도서관계정');

INSERT INTO budget(budgetNo, registeredDate, year, quarter, allocation, remainder, limit, budgetClassification)
VALUES('180102', '2018-01-05', '2018', '1', 10000000, 10000000, 10000000, '국고보조비');

INSERT INTO budget(budgetNo, registeredDate, year, quarter, allocation, remainder, limit, budgetClassification)
VALUES('180201', '2018-04-05', '2018', '2', 10000000, 10000000, 10000000, '도서관계정');

INSERT INTO budget(budgetNo, registeredDate, year, quarter, allocation, remainder, limit, budgetClassification)
VALUES('180202', '2018-04-05', '2018', '2', 10000000, 10000000, 10000000, '국고보조비');



-----------tradeEnterprise sample-----------

INSERT INTO tradeEnterprise(tradeEnterpriseNo, registeredDate, name, type, category, bankName, account, creditGrade, deliveryPeriod, contactNumber, fax, address, webAddress)
VALUES('0001','2018-01-02', '한남대학교 구내서점', '구매처', '교내기관', 'KEB하나은행', '620244827618', '1', 5, '042-629-7803', NULL, '대전 대덕구 오정동 133 한남대학교 법과대학 1층', NULL);

INSERT INTO tradeEnterprise(tradeEnterpriseNo, registeredDate, name, type, category, bankName, account, creditGrade, deliveryPeriod, contactNumber, fax, address, webAddress)
VALUES('0002','2018-01-02', '교보문고 대전점', '구매처', '외부기관', 'NH농협', '3020343945771', '1', 5, '1544-1900', NULL, '대전 서구 대덕대로 226 명동프라자 3층', 'http://www.kyobobook.co.kr/storen/MainStore.laf?SITE=02');


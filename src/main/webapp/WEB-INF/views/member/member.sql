show tables;

create table member (
  idx       int not null auto_increment,			/* 회원 고유번호 */
  mid       varchar(30) not null, 			 		/* 회원 아이디(중복불허) */
  pwd       varchar(100) not null,			 		/* 회원 비밀번호(sha256암호화) */
  nickName  varchar(20) not null,					/* 회원 별명(중복불허/수정가능) - 무조건 공개 */
  name		  varchar(20) not null,					/* 회원 성명 */
  gender    char(2)	not null default '남자',		/* 회원 성별(라디오버튼)(남자/여자) */
  birthday  datetime default now(),					/* 회원 생일(date 형식) */
  tel			  varchar(15),						/* 회원 전화번호(010-1234-5678) */
  address   varchar(100),							/* 회원 주소(다음 API 활용) - 우편번호/주소/상세주소/참조주소 */
  email		  varchar(60) not null,					/* 회원 이메일(아이디/비밀번호 분실시에 이메일 인증처리) - 입력시 이메일형식 필수체크 */
  homePage  varchar(60),							/* 회원 홈페이지(블로그/인스타/페이스북) */
  job			  varchar(20),						/* 회원 직업(콤보상자) */
  hobby		  varchar(100),							/* 회원 취미-체크박스(취미가 2개이상이면 구분자는 '/' 처리) */
  photo		  varchar(100) default 'noimage.jpg',	/* 회원 사진(초기 가입시에 사진이 없으면 'noimage.jpg' 처리) */
  content   text,									/* 회원 자기소개 */
  userInfor char(3) default '공개',					/* 회원 정보 공개/비공개 */
  userDel   char(2)  default 'NO',					/* 회원 탈퇴신청여부(NO: 현재 활동중, OK: 탈퇴신청중) - 탈퇴후 1달간 같은 아이디로 재가입 불가 */
  point		  int default 100,						/* 회원 누적포인트(가입포인트 100점, 1회방문시 10포인트 증가, 1일 최대방문 5회까지 하용, 물건구매시 100원당 1포인트) */
  level     int default 3,							/* 회원 등급(0: 관리자, 1: 우수회원, 2: 정회원, 3: 준회원, 99: 비회원, 999: 탈퇴신청 회원) */
  visitCnt  int default 0,							/* 총 방문횟수 */
  todayCnt 	int default 0,							/* 오늘 방문한 횟수 */
  startDate datetime default now(),					/* 최초 가입일 */
  lastDate  datetime default now(),					/* 마지막 날짜 */
  primary key (idx),
  unique(mid)
);

desc member;
select * from member;

delete from member;

INSERT INTO member (mid, pwd, nickName, name, gender, email)
VALUES ('test1', '1234', '테스트', '홍길동', '남자', 'test@naver.com');
INSERT INTO member (mid, pwd, nickName, name, gender, email)
VALUES
('test2', '1234', '테스트2', 'test2', '남자', 'test2@gmail.com'),
('test3', '1234', '테스트3', 'test3', '여자', 'test3@hanmail.net'),
('test4', '1234', '테스트4', 'test4', '남자', 'test4@daum.net'),
('test5', '1234', '테스트5', 'test5', '여자', 'test5@naver.com');

INSERT INTO member (mid, pwd, nickName, name, gender, birthday, tel, email, job, hobby, level)
VALUES
('user01', SHA2('password01', 256), 'nick01', '홍길동01', '남자', '1990-01-01', '010-0000-0001', 'user01@example.com', '개발자', '독서/영화', 3),
('user02', SHA2('password02', 256), 'nick02', '홍길동02', '여자', '1991-02-02', '010-0000-0002', 'user02@example.com', '디자이너', '영화/운동', 2),
('user03', SHA2('password03', 256), 'nick03', '홍길동03', '남자', '1992-03-03', '010-0000-0003', 'user03@example.com', '기획자', '음악/독서', 1),
('user04', SHA2('password04', 256), 'nick04', '홍길동04', '여자', '1993-04-04', '010-0000-0004', 'user04@example.com', '개발자', '운동/게임', 3),
('user05', SHA2('password05', 256), 'nick05', '홍길동05', '남자', '1994-05-05', '010-0000-0005', 'user05@example.com', '디자이너', '독서/영화', 2),
('user06', SHA2('password06', 256), 'nick06', '홍길동06', '여자', '1995-06-06', '010-0000-0006', 'user06@example.com', '기획자', '영화/운동', 1),
('user07', SHA2('password07', 256), 'nick07', '홍길동07', '남자', '1996-07-07', '010-0000-0007', 'user07@example.com', '개발자', '음악/독서', 3),
('user08', SHA2('password08', 256), 'nick08', '홍길동08', '여자', '1997-08-08', '010-0000-0008', 'user08@example.com', '디자이너', '운동/게임', 2),
('user09', SHA2('password09', 256), 'nick09', '홍길동09', '남자', '1998-09-09', '010-0000-0009', 'user09@example.com', '기획자', '독서/영화', 1),
('user10', SHA2('password10', 256), 'nick10', '홍길동10', '여자', '1999-10-10', '010-0000-0010', 'user10@example.com', '개발자', '영화/운동', 3),
('user11', SHA2('password11', 256), 'nick11', '홍길동11', '남자', '1985-01-11', '010-0000-0011', 'user11@example.com', '디자이너', '음악/독서', 2),
('user12', SHA2('password12', 256), 'nick12', '홍길동12', '여자', '1986-02-12', '010-0000-0012', 'user12@example.com', '기획자', '운동/게임', 1),
('user13', SHA2('password13', 256), 'nick13', '홍길동13', '남자', '1987-03-13', '010-0000-0013', 'user13@example.com', '개발자', '독서/영화', 3),
('user14', SHA2('password14', 256), 'nick14', '홍길동14', '여자', '1988-04-14', '010-0000-0014', 'user14@example.com', '디자이너', '영화/운동', 2),
('user15', SHA2('password15', 256), 'nick15', '홍길동15', '남자', '1989-05-15', '010-0000-0015', 'user15@example.com', '기획자', '음악/독서', 1),
('user16', SHA2('password16', 256), 'nick16', '홍길동16', '여자', '1990-06-16', '010-0000-0016', 'user16@example.com', '개발자', '운동/게임', 3),
('user17', SHA2('password17', 256), 'nick17', '홍길동17', '남자', '1991-07-17', '010-0000-0017', 'user17@example.com', '디자이너', '독서/영화', 2),
('user18', SHA2('password18', 256), 'nick18', '홍길동18', '여자', '1992-08-18', '010-0000-0018', 'user18@example.com', '기획자', '영화/운동', 1),
('user19', SHA2('password19', 256), 'nick19', '홍길동19', '남자', '1993-09-19', '010-0000-0019', 'user19@example.com', '개발자', '음악/독서', 3),
('user20', SHA2('password20', 256), 'nick20', '홍길동20', '여자', '1994-10-20', '010-0000-0020', 'user20@example.com', '디자이너', '운동/게임', 2),
('user21', SHA2('password21', 256), 'nick21', '홍길동21', '남자', '1980-01-21', '010-0000-0021', 'user21@example.com', '기획자', '독서/영화', 1),
('user22', SHA2('password22', 256), 'nick22', '홍길동22', '여자', '1981-02-22', '010-0000-0022', 'user22@example.com', '개발자', '영화/운동', 3),
('user23', SHA2('password23', 256), 'nick23', '홍길동23', '남자', '1982-03-23', '010-0000-0023', 'user23@example.com', '디자이너', '음악/독서', 2),
('user24', SHA2('password24', 256), 'nick24', '홍길동24', '여자', '1983-04-24', '010-0000-0024', 'user24@example.com', '기획자', '운동/게임', 1),
('user25', SHA2('password25', 256), 'nick25', '홍길동25', '남자', '1984-05-25', '010-0000-0025', 'user25@example.com', '개발자', '독서/영화', 3),
('user26', SHA2('password26', 256), 'nick26', '홍길동26', '여자', '1985-06-26', '010-0000-0026', 'user26@example.com', '디자이너', '영화/운동', 2),
('user27', SHA2('password27', 256), 'nick27', '홍길동27', '남자', '1986-07-27', '010-0000-0027', 'user27@example.com', '기획자', '음악/독서', 1),
('user28', SHA2('password28', 256), 'nick28', '홍길동28', '여자', '1987-08-28', '010-0000-0028', 'user28@example.com', '개발자', '운동/게임', 3),
('user29', SHA2('password29', 256), 'nick29', '홍길동29', '남자', '1988-09-29', '010-0000-0029', 'user29@example.com', '디자이너', '독서/영화', 2),
('user30', SHA2('password30', 256), 'nick30', '홍길동30', '여자', '1989-10-30', '010-0000-0030', 'user30@example.com', '기획자', '영화/운동', 1),
('user31', SHA2('password31', 256), 'nick31', '홍길동31', '남자', '1990-01-31', '010-0000-0031', 'user31@example.com', '개발자', '음악/독서', 3),
('user32', SHA2('password32', 256), 'nick32', '홍길동32', '여자', '1991-02-28', '010-0000-0032', 'user32@example.com', '디자이너', '운동/게임', 2),
('user33', SHA2('password33', 256), 'nick33', '홍길동33', '남자', '1992-03-15', '010-0000-0033', 'user33@example.com', '기획자', '독서/영화', 1);

drop table member;

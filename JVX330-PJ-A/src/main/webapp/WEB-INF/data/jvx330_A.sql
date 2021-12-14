SELECT * FROM CAFE_USER;
SELECT * FROM MENU_INFO;
SELECT * FROM ORDERED;
SELECT * FROM PAYMENT_HISTORY;

DROP TABLE CAFE_USER;
DROP TABLE MENU_INFO;
DROP TABLE ORDERED;
DROP TABLE PAYMENT_HISTORY;


CREATE TABLE CAFE_USER(
	id			BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,		
	name		VARCHAR(30)		NOT NULL,
	phone		VARCHAR(20)		NOT NULL,
	passWd		VARCHAR(30)		NOT NULL,
	mileage		DOUBLE			NOT NULL	DEFAULT 0.0,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE MENU_INFO(
	menuNum			BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	category		VARCHAR(50)		NOT NULL,
	menuName		VARCHAR(50)		NOT NULL,
	menuPrice		DOUBLE			NOT NULL DEFAULT 0.0,
	menuCount		BIGINT			NOT NULL DEFAULT 0,
	mileageCount	DOUBLE			NOT NULL DEFAULT 0.0,
	menuImgPath		VARCHAR(300)	NOT NULL DEFAULT ''
)

CREATE TABLE ORDERED(
	orderedList				BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	ordered_customerInfo	VARCHAR(50)	NOT NULL 	DEFAULT 'GUEST', --회원번호가 있으면 회원번호가 찍힐것
	ordered_MenuNum			BIGINT		NOT NULL,
	ordered_extraSize_Price	DOUBLE		NOT NULL 	DEFAULT 0.0,
	ordered_extraTemp_Price	DOUBLE		NOT NULL 	DEFAULT 0.0,
	ordered_menuCount		DOUBLE		NOT NULL 	DEFAULT 0.0,
	ordered_usingMileage	DOUBLE		NOT NULL 	DEFAULT 0.0,
	ordered_totalPrice		DOUBLE		NOT NULL 	DEFAULT 0.0,
	ordered_orderedDate		TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT ORDERED_ordered_MenuNum_FK FOREIGN KEY(ordered_MenuNum) REFERENCES MENU_INFO(menuNum)
)

CREATE TABLE PAYMENT_HISTORY(
	paymentList				BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	payment_customerInfo	VARCHAR(11)	NOT NULL	DEFAULT 'GUEST',
	creditCard				VARCHAR(19)	NOT NULL,
	payment_totalPrice		DOUBLE		NOT NULL	DEFAULT 0.0,
	paymentDate				TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP
)


---CAFE_USER TABLE : admin 계정, 일반 멤버쉽 가입 예제---
INSERT INTO CAFE_USER(name,phone,passWd) VALUES ('admin', 'admin', 'admin');
INSERT INTO CAFE_USER(name, phone, passWd, mileage) VALUES('서명', '010123123', '1234', 1000000.0);
INSERT INTO CAFE_USER(name, phone, passWd, mileage) VALUES('종성테스트', '01012344321', '1234', 12000.0);



---MENU_INFO TABLE : 메뉴 기본 품목 INSERT 하세요---

INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('COFFEE','클래식 아메리카노',6000.0,'/resources/img/coffee_1.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('COFFEE','바닐라빈 라떼',7800.0,'/resources/img/coffee_2.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('COFFEE','벨벳 다크 모카 카푸치노',7500.0, '/resources/img/coffee_3.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('COFFEE','콜드 브루 플로트',7500.0, '/resources/img/coffee_4.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('COFFEE','플랫 화이트',7000.0, '/resources/img/coffee_5.png');

INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('NON_COFFEE','제주 유기농 녹차',7500.0, '/resources/img/non_coffee_1.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('NON_COFFEE','콩고물 블랙 밀크 티',7000.0, '/resources/img/non_coffee_2.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('NON_COFFEE','피치레몬 블렌디드',8000.0, '/resources/img/non_coffee_3.png');

INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('FOOD','우유 품은 초콜릿 크루아상',6000.0, '/resources/img/food1.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('FOOD','한 입에 쏙 치즈 꿀 볼',5500.0, '/resources/img/food2.png');
INSERT INTO MENU_INFO(category, menuName, menuPrice, menuImgPath) VALUES('FOOD','트리플 치즈 크로크무슈',6500.0, '/resources/img/food3.png');

--MENU_INFO TABLE : 판매누적수량, 마일리지 사용액 누적 예제--
UPDATE MENU_INFO SET menuCount=2 WHERE menuNum=1;
UPDATE MENU_INFO SET menuCount=5, MILEAGECOUNT=500.0 WHERE menuNum=2;
UPDATE MENU_INFO SET menuCount=11 WHERE ordered_MenuNum=11 AND orderedList=2;
UPDATE MENU_INFO SET FROM ORDERED a INNER JOIN 

--ORDERED TABLE : INSERT 예제--
INSERT INTO ORDERED(ordered_customerInfo, ordered_MenuNum, ordered_extraSize_Price, ordered_extraTemp_Price,
ordered_menuCount, ordered_usingMileage, ordered_totalPrice) 
VALUES ('GUEST',1,300.0,500.0,2,0.0,6000.0+300.0+500.0);

INSERT INTO ORDERED(ordered_customerInfo, ordered_MenuNum, ordered_extraSize_Price, ordered_extraTemp_Price,
ordered_menuCount, ordered_usingMileage, ordered_totalPrice) 
VALUES ('01023542214',11,0.0,0.0,1,0.0,6500.0);



--서명 SQL 예제 테스트중--
SELECT * FROM MENU_INFO WHERE CATEGORY='COFFEE';
SELECT * FROM MENU_INFO WHERE CATEGORY='NON_COFFEE';
SELECT * FROM MENU_INFO WHERE CATEGORY='FOOD';
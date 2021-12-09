SELECT * FROM CAFE_USER;
SELECT * FROM MENU_INFO;
SELECT * FROM ORDERED;

DROP TABLE CAFE_USER;
DROP TABLE MENU_INFO;
DROP TABLE ORDERED;


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
	menuImgPath		VARCHAR(300)	NOT NULL DEFAULT 'NULL'
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


---admin 계정---
INSERT INTO CAFE_USER(name,phone,passWd) VALUES ('admin', 'admin', 'admin');




---MENU INSERT 하세요---

INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('COFFEE','클래식 아메리카노',6000.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('COFFEE','바닐라빈 라떼',7800.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('COFFEE','벨벳 다크 모카 카푸치노',7500.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('COFFEE','콜드 브루 플로트',7500.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('COFFEE','플랫 화이트',7000.0);

INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('NON_COFFEE','제주 유기농 녹차',7500.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('NON_COFFEE','콩고물 블랙 밀크 티',7000.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('NON_COFFEE','피치레몬 블렌디드',8000.0);

INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('FOOD','우유 품은 초콜릿 크루아상',6000.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('FOOD','한 입에 쏙 치즈 꿀 볼',5500.0);
INSERT INTO MENU_INFO(category, menuName, menuPrice) VALUES('FOOD','트리플 치즈 크로크무슈',6500.0);








------------------[서명]쿼리문 예제 작성중...------------------------------------
--******USER가 메뉴선택 버튼 눌렀을 때 고유번호 부여 ver1, ver2--
INSERT INTO CART_ID(userCartId) VALUES(1251);

--******메뉴선택 후 전송버튼(결제버튼x) 눌렀을 때 고유번호로 CART에 INSERT
INSERT INTO CART(userCartNum, cart_category, cart_menuName, cart_menuPrice, 
cart_menuCount, cart_size, cart_temp, cart_totalPrice)
VALUES(1251, 'COFFEE', 'AMERICANO', 4000.0, 2, 'S', 'H', 4000.0*2);

--******계속해서 주문메뉴 담을때마다 CART INSERT
INSERT INTO CART(userCartNum, cart_category, cart_menuName, cart_menuPrice, 
cart_menuCount, cart_size, cart_temp, cart_totalPrice)
VALUES(1251, 'OTHER', 'ICE TEA', 4500.0, 1, 'S', 'I', 4500.0*1);

--******주문취소 시 카트삭제
DELETE FROM CART where cartNum=1251;
---------------------------------------------------------------------------






--test--
INSERT INTO TestUser(userId, passwd, userName, ssn, email, addr) 
VALUES ('hello001','000123','이서명','950529-2222222','hello001@naver.com','대구시 중구');
ALTER TABLE Account DROP CONSTRAINT Account_customerId_FK;
SELECT * FROM CAFE_USER;
SELECT * FROM MENU;
SELECT * FROM CART;
SELECT * FROM CART_ID;
SELECT * FROM ORDER_LIST;

DROP TABLE CAFE_USER;
DROP TABLE MENU;
DROP TABLE CART;
DROP TABLE CART_ID;
DROP TABLE ORDER_LIST;


CREATE TABLE CAFE_USER(
	id			BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,		
	name		VARCHAR(30)		NOT NULL,
	phone		VARCHAR(20)		NOT NULL,
	passWd		VARCHAR(30)		NOT NULL,
	mileage		DOUBLE			NOT NULL	DEFAULT 0.0,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE MENU(
	menuNum			BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,--	
	category		VARCHAR(50)		NOT NULL,
	menuName		VARCHAR(50)		NOT NULL,
	menuPrice		DOUBLE			NOT NULL DEFAULT 0.0,
	size			CHAR(1)			NOT NULL DEFAULT 'M',
	temp			CHAR(1)			NOT NULL DEFAULT 'I'
)


CREATE TABLE CART_ID(
	userCartId BIGINT NOT NULL PRIMARY KEY
)


CREATE TABLE CART(
	--cartNum				BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,		
	userCartNum			BIGINT			NOT NULL,
	cart_category		VARCHAR(50)		NOT NULL DEFAULT 'NONE',
	cart_menuName		VARCHAR(50)		NOT NULL DEFAULT 'NONE',
	cart_menuPrice		DOUBLE			NOT NULL DEFAULT 0.0,
	cart_menuCount		BIGINT			NOT NULL DEFAULT 0,
	cart_size			CHAR(1)			NOT NULL DEFAULT 'X',
	cart_temp			CHAR(1)			NOT NULL DEFAULT 'X',
	cart_totalPrice		DOUBLE			NOT NULL DEFAULT 0.0,
	CONSTRAINT CART_ID_userCartNum_FK 
		FOREIGN KEY(userCartNum) REFERENCES CART_ID(userCartId)
)


CREATE TABLE ORDER_LIST(
	orderNum			BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,		
	userCartOrder		BIGINT			NOT NULL,
	order_category		VARCHAR(50)		NOT NULL,
	order_menuName		VARCHAR(50)		NOT NULL,
	order_menuPrice		DOUBLE			NOT NULL DEFAULT 0.0,
	order_menuCount		BIGINT			NOT NULL DEFAULT 0,
	order_size			CHAR(1)			NOT NULL DEFAULT 'M',
	order_temp			CHAR(1)			NOT NULL DEFAULT 'I',
	order_totalPrice	DOUBLE			NOT NULL DEFAULT 0.0,
	CONSTRAINT ORDER_LIST_userCartOrder_FK 
		FOREIGN KEY(userCartOrder) REFERENCES CART(cartNum)
)


--******USER가 메뉴선택 버튼 눌렀을 때 고유번호 부여 ver1, ver2--
INSERT INTO CART_ID(userCartId) VALUES(1251);

--******메뉴선택 후 전송버튼(결제버튼x) 눌렀을 때 고유번호로 CART에 INSERT
INSERT INTO CART(userCartNum, cart_category, cart_menuName, cart_menuPrice, 
cart_menuCount, cart_size, cart_temp, cart_totalPrice)
VALUES(1251, 'COFFEE', 'AMERICANO', 4000.0, 2, 'S', 'H', 4000.0*2);

--******계속해서 주문메뉴 담을때마다 CART INSERT
INSERT INTO CART(userCartNum, cart_category, cart_menuName, cart_menuPrice, 
cart_menuCount, cart_size, cart_temp, cart_totalPrice)
VALUES(1251, 'OTHER', 'ICE TEA', 4500.0, 1, 'S', 'I', 4000.0*1);



---MENU INSERT---
--test--
INSERT INTO TestUser(userId, passwd, userName, ssn, email, addr) 
VALUES ('hello001','000123','이서명','950529-2222222','hello001@naver.com','대구시 중구');
ALTER TABLE Account DROP CONSTRAINT Account_customerId_FK;
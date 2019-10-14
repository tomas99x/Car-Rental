INSERT INTO BRANCH (ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET)
VALUES (1, '71567323','Wroclaw','11','55-454','legnicka');
INSERT INTO BRANCH (ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET)
VALUES (2, '60345698', 'Poznań','44','60-454','zachodnia');

INSERT INTO EMPLOYEE(ID, first_Name, LAST_NAME, work_Phone_No, POSITION, BRANCH_ID)
VALUES (1, 'Janusz', 'Kowalski', 765111000 ,'MANAGER', 1);
INSERT INTO EMPLOYEE(ID, first_Name, LAST_NAME, work_Phone_No, POSITION, BRANCH_ID)
VALUES (2, 'Andrzej', 'Kowal', 734333000 ,'MANAGER', 2);
INSERT INTO EMPLOYEE(ID, first_Name, LAST_NAME, work_Phone_No, POSITION, BRANCH_ID)
VALUES (3, 'Marek', 'Pas', 88811000 ,'SELLER', 1);
INSERT INTO EMPLOYEE(ID, first_Name, LAST_NAME, work_Phone_No, POSITION, BRANCH_ID)
VALUES (4, 'Zenek', 'Niema', 698456440 ,'SELLER', 2);
INSERT INTO EMPLOYEE(ID, first_Name, LAST_NAME, work_Phone_No, POSITION, BRANCH_ID)
VALUES (5, 'Marta', 'Piesza', 76268426 ,'ACCOUNTANT', 1);

INSERT INTO CAR (ID, CAR_BRAND_MODEL,	CAR_COLOR, CAR_TYPE, ENGINE_CAPACITY, MILEAGE, HORSE_POWER, PRODUCTION_YEAR, BRANCH_ID )
VALUES (1, 'BMW 320', 'BLACK', 'COUPE', '2000', '14033', '177', '2018-10-10', 1);
INSERT INTO CAR (ID, CAR_BRAND_MODEL,	CAR_COLOR, CAR_TYPE, ENGINE_CAPACITY, MILEAGE, HORSE_POWER, PRODUCTION_YEAR )
VALUES (2, 'VW Passat', 'WHITE', 'COMBI', '1600', '134033', '130', '2017-11-11');
INSERT INTO CAR (ID, CAR_BRAND_MODEL,	CAR_COLOR, CAR_TYPE, ENGINE_CAPACITY, MILEAGE, HORSE_POWER, PRODUCTION_YEAR )
VALUES (3, 'Opel Astra', 'WHITE', 'COMBI', '1700', '12033', '120', '2019-01-11');
INSERT INTO CAR (ID, CAR_BRAND_MODEL,	CAR_COLOR, CAR_TYPE, ENGINE_CAPACITY, MILEAGE, HORSE_POWER, PRODUCTION_YEAR )
VALUES (4, 'Opel Corsa', 'WHITE', 'HATCHBACK', '1200', '112033', '80', '2017-01-11');

INSERT INTO CAR_TO_EMPLOYEE (CAR_ID, EMPLOYEE_ID)
VALUES (1,1);
INSERT INTO CAR_TO_EMPLOYEE (CAR_ID, EMPLOYEE_ID)
VALUES (2,2);
INSERT INTO CAR_TO_EMPLOYEE (CAR_ID, EMPLOYEE_ID)
VALUES (1,3);
INSERT INTO CAR_TO_EMPLOYEE (CAR_ID, EMPLOYEE_ID)
VALUES (2,4);

INSERT INTO CLIENT(ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET, FIRST_NAME, LAST_NAME, CARD_NUMBER, BIRTH_DATE)
VALUES (1, '567345764', 'Wrocław', '1', '54-333', 'Sienkiewicza', 'Anna', 'kowalska', '34569483983', '1990-05-03' );
INSERT INTO CLIENT(ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET, FIRST_NAME, LAST_NAME, CARD_NUMBER, BIRTH_DATE)
VALUES (2, '765896','Wrocław', '2a', '54-333', 'Mala', 'Marek', 'kowalski', '34569483983', '1990-05-03' );
INSERT INTO CLIENT(ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET, FIRST_NAME, LAST_NAME, CARD_NUMBER, BIRTH_DATE)
VALUES (3, '88853456','Wrocław', '3a', '54-333', 'nowa', 'Antoni', 'kowalski', '34569483983', '1990-05-03' );
INSERT INTO CLIENT(ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET, FIRST_NAME, LAST_NAME, CARD_NUMBER, BIRTH_DATE)
VALUES (4, '694567456','Wrocław', '4a', '54-333', 'Sienkiewicza', 'Zenon', 'kowalski', '34569483983', '1990-05-03' );
INSERT INTO CLIENT(ID, PHONE_NO, CITY, HOUSE_NO, POSTAL_CODE, STREET, FIRST_NAME, LAST_NAME, CARD_NUMBER, BIRTH_DATE)
VALUES (5, '988555444','Wrocław', '5a', '54-333', 'Długa', 'Ksawery', 'kowalski', '34569483983', '1990-05-03' );


INSERT INTO RENTAL(ID, START_DATE, END_DATE, TOTAL_PRICE, CAR_ID, CLIENT_ID, BRANCH_START, BRANCH_END)
VALUES(1, '2019-02-10', '2019-02-15', '700', 2, 1, 1,1);
INSERT INTO RENTAL(ID, START_DATE, END_DATE, TOTAL_PRICE, CAR_ID, CLIENT_ID, BRANCH_START, BRANCH_END)
VALUES(2, '2019-10-05', '2019-10-15', '1800', 2, 1, 1, 1);
INSERT INTO RENTAL(ID, START_DATE, END_DATE, TOTAL_PRICE, CAR_ID, CLIENT_ID, BRANCH_START, BRANCH_END)
VALUES(3, '2019-09-25 15:22', '2019-09-28 16:33', '900', 1, 2, 1, 1);
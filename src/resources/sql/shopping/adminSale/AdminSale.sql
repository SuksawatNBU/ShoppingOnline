/*-----------------------------------------------------------------------------------------------------------------------------------------------------------
SQL : นับจำนวนข้อมูล order
Description : 
------------------------------------------------------------------------------------------------------------------------------------------------------------*/
countData {
	SELECT 
		COUNT(1) AS TOT
	FROM ORDER_MAIN O
	INNER JOIN USER U ON O.USER_ID = U.USER_ID
	WHERE O.NO = %s
	, O.SHIP = %s
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------
SQL : ค้นหาข้อมูล order
Description : 
------------------------------------------------------------------------------------------------------------------------------------------------------------*/
searchOrderMain {
	SELECT
		O.ID
		, O.NO
		, O.TOTAL_PRICE
		, O.ORDER_DATE
		, O.SHIP
		, O.SHIP_DATE
		, O.TRACKING_NO
		, U.USER_ID
		, U.FIRST_NAME
		, U.LAST_NAME
	FROM ORDER_MAIN O
	INNER JOIN USER U ON O.USER_ID = U.USER_ID
	WHERE O.NO = %s
	, O.SHIP = %s
	
	LIMIT %s
	, %s
}

searchOrderDetail {
	SELECT 
		O.ID
		, o.NO
		, O.ORDER_DATE
		, O.SHIP
		, O.SHIP_DATE
		, O.TRACKING_NO
		, O.NOTE
		, U.USER_ID
		, U.FIRST_NAME
		, U.LAST_NAME
		, P.CODE
		, P.`DESC`
		, D.TOTAL_NUM
		, D.TOTAL_PRICE
	FROM ORDER_MAIN O 
	INNER JOIN USER U on O.USER_ID = U.USER_ID
	INNER JOIN ORDER_DETAIL D on D.ORDER_ID = O.ID
	INNER JOIN PRODUCT P on P.ID = D.PRODUCT_ID;
}
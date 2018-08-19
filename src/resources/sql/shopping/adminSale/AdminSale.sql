/*-----------------------------------------------------------------------------------------------------------------------------------------------------------
SQL : นับจำนวนข้อมูลรายการสั่งซื้อ
Description : 
------------------------------------------------------------------------------------------------------------------------------------------------------------*/
countOrderMain {
	SELECT 
		COUNT(1) AS TOT
	FROM ORDER_MAIN O
	INNER JOIN USER U ON O.USER_ID = U.USER_ID
	WHERE O.NO = %s
	AND O.SHIP = %s
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------
SQL : ค้นหาข้อมูลรายการสั่งซื้อ
Description : 
------------------------------------------------------------------------------------------------------------------------------------------------------------*/
searchAdminSale {
	SELECT
		O.ID
		, O.NO
		, O.TOTAL_PRICE
		, O.ORDER_DATE
		, O.SHIP
		, O.SHIP_DATE
		, O.TRACKING_NO
		, O.CANCEL
		, U.USER_ID
		, U.FIRST_NAME
		, U.LAST_NAME
	FROM ORDER_MAIN O
	INNER JOIN USER U ON O.USER_ID = U.USER_ID
	WHERE O.NO = %s
	AND O.SHIP = %s
	
	LIMIT %s
	, %s
}

searchAdminSaleById {
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
		, P.PRODUCT_DESC
		, D.TOTAL_NUM
		, D.TOTAL_PRICE
	FROM ORDER_MAIN O 
	INNER JOIN USER U on O.USER_ID = U.USER_ID
	INNER JOIN ORDER_DETAIL D on D.ORDER_ID = O.ID
	INNER JOIN PRODUCT P on P.ID = D.PRODUCT_ID
	WHERE O.ID = %s
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------
SQL : อัพเดตข้อมูลรายการสั่งซื้อ
Description : 
------------------------------------------------------------------------------------------------------------------------------------------------------------*/
updateOrderMain {
	UPDATE ORDER_MAIN SET
	SHIP = %s
	SHIP_DATE = %s
	NOTE = %s
	WHERE ID = %s
}
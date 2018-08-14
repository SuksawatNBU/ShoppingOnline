<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
function sf(){ 
	
}
function order(){ 
	if(confirm('คุณต้องการสั่งซื้อสินค้า ?') == false){ 
		return false;
	}
	
	frm = document.cartAndOrderAddForm;
	submitPage(frm, "<s:url value='/jsp/shopping/addCustomerSale.action' />");
}
function backtoSearch(){ 
	
}

</script>
</head>
<body>
	<s:form name="cartAndOrderAddForm" method="post" cssClass="margin-zero">
		My Cart
		<button id="btnBack" class="submitBtn" type="button"
			onclick="return order();">
			<span> <img src="<s:url value='/images/icon/i_add.png'/>">
					<br /> &nbsp;<s:text name="Order" />&nbsp; </span>
		</button>
		<button id="btnBack" class="submitBtn" type="button"
			onclick="return backtoSearch();">
			<span> <img src="<s:url value='/images/icon/i_back.png'/>">
					<br /> &nbsp;<s:text name="Back" />&nbsp; </span>
		</button>
		
		<s:hidden name="criteria.criteriaKey" />
		<s:token />
	</s:form>
</body>
</html>
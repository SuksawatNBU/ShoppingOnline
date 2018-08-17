<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<script type="text/javascript">
	function sf(){
		
	}
	
	function addProduct(id){
		document.getElementsByName("customerSale.id")[0].value = id;
		
		frm = document.fromProductList;
		submitPage(frm, "<s:url value='/jsp/shopping/addToCartAjaxCustomerSale.action' />");
	}
	
</script>
</head>
<body>
	<s:form id="fromProductList" name="fromProductList" namespace="/jsp/shopping">
		<s:iterator id="listResult" value="listResult">
			<div class="card" style="width: 18rem;">
				<div class="row">
				    <%-- <div class="col"><img class="card-img-top" src="<s:url value='' /><s:property value='image'/>"></div> --%>
				    <div class="col"><img class="card-img-top" src="<s:url value='/images/product/type/product_01/S001.jpg' />"></div>
    				<div class="col">
    					<div class="card-text">
    						<br/>
    						<s:set name="customerSale.id" value="id" />
    						<span>
    						รหัส &nbsp;<s:property value="code"/><br />
    						<s:property value="productDesc"/><br />
    						ราคา  &nbsp;<font color="red"><s:property value="price"/></font><br />
    						จำนวน  &nbsp;<font color="red"><s:property value="stockNum"/></font>&nbsp; ชิ้น
    						</span>
    					</div>
    				</div>
			  	</div>
			  	<div class="row text-center">
			  		<div class="col">
			  			<s:if test='%{stockNum != "0"}'>
			  				<button id="orderAdd" class="submitBtn" type="button" onclick="addProduct(<s:property value="id"/>);"> 
			  					<span> <img src="<s:url value='/images/icon/i_add.png' />"> &nbsp;<s:text name="shopping.orderAdd" />&nbsp; </span>
							</button>
			  			</s:if>
			  			<s:else>
			  				<font color="red">** ขออภัยสินค้าหมด **</font>
			  			</s:else>
			  		</div>
			  	</div>
			</div>
			<br/>
		</s:iterator>
		
		<s:hidden name="customerSale.id" />
		<s:token />
	</s:form>
</body>
</html>
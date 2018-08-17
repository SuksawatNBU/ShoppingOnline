<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script type="text/javascript">
	function sf(){
		
	}
	
	function addProduct(id){
		
	}
	
</script>
</head>
<body>
	<s:form>
		<s:iterator id="listResult" value="listResult" var="p">
			<div class="card" style="width: 18rem;">
				<div class="row">
				    <%-- <div class="col"><img class="card-img-top" src="<s:url value='' /><s:property value='image'/>"></div> --%>
				    <div class="col"><img class="card-img-top" src="<s:url value='/images/product/type/product_01/S001.jpg' />"></div>
    				<div class="col">
    					<div class="card-text">
    						<s:set name="customerSale.id" value="id" />
    						<p>รหัส &nbsp;<s:property value="code"/> </p>
    						<p><s:property value="productDesc"/> </p>
    						<p>ราคา  &nbsp;<font color="red"><s:property value="price"/></font></p>
    						<p>จำนวน  &nbsp;<font color="red"><s:property value="stockNum"/></font>&nbsp; ชิ้น</p>
    					</div>
    				</div>
			  	</div>
			  	<div class="row text-center">
			  		<div class="col">
			  			<s:if test='%{stockNum != "0"}'>
			  				<img onclick="addProduct(id);" src="<s:url value='/images/icon/i_add.png' />" />
			  			</s:if>
			  			<s:else>
			  				<font color="red">** ขออภัยสินค้าหมด **</font>
			  			</s:else>
			  		</div>
			  	</div>
			</div>
			<br/>
		</s:iterator>
	</s:form>
</body>
</html>
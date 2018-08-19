<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
	<s:include value="/jsp/shopping/admin/sale/include/ja-css.jsp"/>
</head>
<body>
	
	<s:form id="addEditForm" name="addEditForm" method="post" namespace="/jsp/shopping">
		
		<!-- set class ให้กับหน้า -->
		<s:if test="page.getPage() == 'view'"> 
		 	<s:set var="viewDisable" value="true" />
		</s:if>
		<s:else> 
			<s:set var="viewDisable" value="" />
		</s:else>
		
		<span>viewDisable : <s:text name="%{viewDisable}"/></span><br/>
		<span>editDisable : <s:text name="%{editDisable}"/></span>
		
		<!------------------------------------- Order Main ------------------------------------->
		<div id="div_orderMain">
			<table width="100%">
				<tr>
					<td align="right"><s:text name="shopping.orderNumber" /></td>
					<td><s:property value="adminSale.orderMain.no"/></td>
					<td align="right"><s:text name="shopping.fullName" /></td>
					<td><s:property value="adminSale.orderMain.fullName"/></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.ship" /></td>
					<td><s:textfield id="adminSale_orderMain_ship" name="adminSale.orderMain.ship" /></td>
					<td align="right"><s:text name="shopping.shipDate" /></td>
					<td><s:textfield id="adminSale_orderMain_shipDate" name="adminSale.orderMain.shipDate" /></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.trackingNo" /></td>
					<td><s:textfield id="adminSale_orderMain_trackingNo" name="adminSale.orderMain.trackingNo" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.note" /></td>
					<td><s:textfield id="adminSale_orderMain_note" name="adminSale.orderMain.note" /></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		
		<!------------------------------------- Data Table --------------------------------->
		<div id="div_datatable">
		    <table id="tableResult" class="table table-striped">
		    	<thead>
		      		<tr>
		        		<th align="center"><s:text name="shopping.code" /></th>
		    			<th align="center"><s:text name="shopping.productDesc" /></th>
		    			<th align="center"><s:text name="shopping.stockNum" /></th>
		    			<th align="center"><s:text name="shopping.price" /></th>
		      		</tr>
		    	</thead>
		    	<tbody>
		    		<s:iterator id="adminSale_listOrderDetail" value="adminSale.listOrderDetail">
		    			<tr>
		    				<td align="center"><s:property value="code"/></td>
		    				<td align="center"><s:property value="productDesc"/></td>
		    				<td align="center"><s:property value="totalNum"/></td>
		    				<td align="left"><s:property value="totalPrice"/></td>
		    			</tr>
		    		</s:iterator>
		    	</tbody>
		  	</table>
	  	</div>
		
		<!------------------------------------- BUTTON ------------------------------------->
		<div style="display: ;"><s:include value="/jsp/template/hiddenSearchForDatatable.jsp" /></div>
	    <s:hidden name="adminSale.id" />
	    <s:token/>
		
	</s:form>
</body>
</html>
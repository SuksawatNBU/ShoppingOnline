<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
	<s:include value="/jsp/shopping/admin/sale/include/ja-css-editview.jsp"/>
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
		
		<!------------------------------------- Order Main ------------------------------------->
		<div id="div_orderMain">
			<table width="100%">
				<tr>
					<td align="right"><s:text name="shopping.orderNumber" /></td>
					<td><font color="blue"><s:property value="adminSale.orderMain.no"/></font></td>
					<td align="right"><s:text name="shopping.fullName" /></td>
					<td><font color="blue"><s:property value="adminSale.orderMain.fullName"/></font></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.ship" /></td>
					<td><s:select id="adminSale_orderMain_ship" name="adminSale.orderMain.ship" list="listShip" listKey="key" listValue="value" cssClass ="combox" disabled="%{viewDisable}"/></td>
					<td align="right"><s:text name="shopping.shipDate" /></td>
					<td><s:textfield id="adminSale_orderMain_shipDate" name="adminSale.orderMain.shipDate" disabled="%{viewDisable}"/></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.trackingNo" /></td>
					<td colspan="3"><s:textfield id="adminSale_orderMain_trackingNo" name="adminSale.orderMain.trackingNo" disabled="%{viewDisable}"/></td>
				</tr>
				<tr>
					<td align="right"><s:text name="shopping.note" /></td>
					<td colspan="3"><s:textarea id="adminSale_orderMain_note" name="adminSale.orderMain.note" disabled="%{viewDisable}"/></td>
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
		    				<td align="left"><s:property value="productDesc"/></td>
		    				<td align="center"><s:property value="totalNum"/></td>
		    				<td align="center"><s:property value="totalPrice"/></td>
		    			</tr>
		    		</s:iterator>
		    	</tbody>
		  	</table>
	  	</div>
	  	
	  	<!--------------------------------------- VIEW PAGE --------------------------------------->
	  	<s:if test="page.getPage() == 'view'"> 
		 	<button type="button" class="btn btn-secondary btn-sm" onclick="cancelView();">
		 		<span><i class="fas fa-times"></i> ปิดหน้าจอ</span>
		 	</button>
		</s:if>
		<!--------------------------------------- EDIT PAGE --------------------------------------->
		<s:if test="page.getPage() == 'edit'"> 
		 	<button type="button" class="btn btn-success btn-sm" onclick="saveEdit();">
		 		<span><i class="fas fa-check"></i> บันทึก</span>
		 	</button>
		 	<button type="button" class="btn btn-secondary btn-sm" onclick="cancelEdit();">
		 		<span><i class="fas fa-times"></i> ยกเลิก</span>
		 	</button>
		</s:if>
		
		<!------------------------------------- BUTTON ------------------------------------->
		<div style="display: ;"><s:include value="/jsp/template/hiddenSearchForDatatable.jsp" /></div>
	    <s:hidden name="adminSale.orderMain.id" />
	    <s:token/>
		
	</s:form>
</body>
</html>
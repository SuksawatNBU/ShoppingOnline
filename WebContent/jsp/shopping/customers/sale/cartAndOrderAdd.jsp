<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
	<script type="text/javascript">
		function sf(){ 
			
		}
		function order(){ 
			if(confirm('คุณต้องการสั่งซื้อสินค้า ?') == false){ 
				return false;
			}
			
			document.getElementsByName('customerSale.orderMain')[0].value = main;
			document.getElementsByName('customerSale.listOrderDetail')[0].value = detail;
			
			frm = document.cartAndOrderAddForm;
			submitPage(frm, "<s:url value='/jsp/shopping/addCustomerSale.action' />");
		}
		function backtoSearch(){ 
			
		}
		
		function calculatePrice(){ 
			frm = document.cartAndOrderAddForm;
			submitPage(frm, "<s:url value='/jsp/shopping/addCustomerSale.action' />");
		}
	
	</script>
</head>
<body>
	<s:form name="cartAndOrderAddForm" method="post" cssClass="margin-zero">
		
		<!------------------------------------- Result ------------------------------------->
	    <div id="div_datatable">
	    	<h5>ตะกร้าสินค้าของคุณ</h5>
	    	<b>จำนวนรายการ <s:property value="criteria.totalResult"/> รายการ</b>
		    <table id="tableResult" class="table table-striped">
		    	<thead>
		      		<tr>
		        		<th align="center"><s:text name="shopping.code" /></th>
		        		<th align="center"></th>
		        		<th align="right"><s:text name="shopping.productDesc" /></th>
		    			<th align="center"><s:text name="shopping.pricePerNum" /></th>
		    			<th align="center"><s:text name="shopping.stockNum" /></th>
		    			<th align="left"><s:text name="shopping.price" /></th>
		    			<th align="right"><s:text name="shopping.delete" /></th>
		      		</tr>
		    	</thead>
		    	<tbody>
		    		<s:if test='%{customerSale.listOrderDetail.size > 0}'>
		    		<s:iterator id="customerSale_listOrderDetail" value="customerSale.listOrderDetail" status="listResultStatus">
		    			<tr>
		    				<td align="center"><s:property value="code"/></td>
		    				<td align="center" width="50px"><img class="card-img-top" src="<s:url value='%{image}' />"></td>
		    				<td align="left"><s:property value="productDesc"/></td>
		    				<td align="center"><s:property value="price"/></td>
		    				<td align="center"><s:textfield name="totalNum" /> </td>
		    				<td align="center"><s:property value="totalPrice"/></td>
		    				<td align="center">
		    					<button type="button" class="btn btn-secondary btn-sm" onclick="">
							 		<span><i class="fas fa-times"></i></span>
							 	</button>
		    				</td>
		    			</tr>
		    		</s:iterator>
		    		</s:if>
		    		<s:else>
		    			<tr><td colspan="6">ไม่มีข้อมูล</td>
		    			</tr>
		    		</s:else>
		    	</tbody>
		  	</table>
		  	
		  	<b>สรุปรายการสินค้า</b>
		  	<table width="100%">
		  		<tr>
		  			<td>ราคารวมสินค้า</td>
		  			<td align="right"><s:property value="customerSale.orderMain.totalPrice"/> </td>
		  		</tr>
		  	</table>
	  	</div>
	  	
	  	<!------------------------------------- BUTTON ------------------------------------->
	  	
		<button type="button" class="btn btn-secondary btn-sm" onclick='return order();'> 
			<span><img src="<s:url value='/images/icon/i_add.png'/>" />สั่งซื้อสินค้า</span>
		</button>
		<button type="button" class="btn btn-secondary btn-sm" onclick="return backtoSearch();">
			<span><img src="<s:url value='/images/icon/i_back.png'/>" />เลือกซื้อสินค้าเพิ่มเติม</span>
		</button>
		
		<s:hidden name="criteria.criteriaKey" />
		<s:token />
		
		<s:hidden name="customerSale.listOrderDetail" />
		<s:hidden name="customerSale.orderMain" />
	</s:form>
</body>
</html>
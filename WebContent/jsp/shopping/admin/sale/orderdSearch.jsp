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
	
	<s:form id="searchForm" name="searchForm" method="post" namespace="/jsp/shopping" action="initAdminSale">
		
	    <!------------------------------------- Criteria ------------------------------------->
		<div id="div_criteria">
			<table width="100%">
				<tr>
					<td align="right"><label for="criteria_no" ><s:text name="shopping.orderNumber" /></label></td>
					<td><s:textfield id="criteria_no" name="criteria.no" class="form-control" /></td>
					<td align="right"><s:label for="criteria_ship"><s:text name="shopping.ship" /></s:label></td>
					<td><s:select id="criteria_ship" name="criteria.ship" list="listShip"  headerKey="" headerValue="ทั้งหมด" listKey="key" listValue="value" cssClass ="combox"/></td>
				</tr>
				<tr>
					<td align="right"><s:label for="criteria_linePerPage" value="จำนวนข้อมูลต่อหน้า" /></td>
					<td><s:select id="criteria_linePerPage" cssClass="lpp-style clearform" name="criteria.linePerPage"  list="LPP" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<button type="button" class="btn btn-primary btn-sm" onclick="search();">Seach</button>
						<button type="button" class="btn btn-secondary btn-sm" onclick="clearPage()">Clear</button>
					</td>
				</tr>
			</table>
		</div>
		<br />
		<br />
	    
	    <!------------------------------------- Result ------------------------------------->
	    <div id="div_datatable">
		    <table id="tableResult" class="table table-striped">
		    	<thead>
		      		<tr>
		        		<th align="center"><s:text name="shopping.no" /></th>
		    			<th align="center"><input id="criteria_selectedIds" type="checkbox" name="criteria.selectedIds" onClick="checkboxToggle('criteria.selectedIds',this.checked)" /></th>
		    			<th align="center"><s:text name="shopping.orderNumber" /></th>
		    			<th align="center"><s:text name="shopping.orderDate" /></th>
		    			<th align="left"><s:text name="shopping.fullName" /></th>
		    			<th align="right"><s:text name="shopping.totalprice" /></th>
		    			<th align="left"><s:text name="shopping.ship" /></th>
		    			<th align="center"><s:text name="shopping.view" /></th>
		    			<th align="center"><s:text name="shopping.ship2" /></th>
		    			<th align="center"><s:text name="shopping.cancel" /></th>
		      		</tr>
		    	</thead>
		    	<tbody>
		    		<s:if test='%{listResult.size > 0}'>
		    		<s:iterator id="listResult" value="listResult" status="listResultStatus">
		    			<tr>
		    				<td align="center"><s:property value="#listResultStatus.index + 1"/></td>
		    				<td align="center">
		    					<s:if test='%{ship eq "N"}'>
									<input type="checkbox" name="id">
								</s:if>
		    				</td>
		    				<td align="center"><s:property value="no"/></td>
		    				<td align="center"><s:property value="orderDate"/></td>
		    				<td align="left"><s:property value="fullName"/></td>
		    				<td align="right"><s:property value="totalPrice"/></td>
		    				<td align="left">
		    					<s:if test='%{ship eq "Y"}'>
									<span>จัดส่งแล้ว</span>
								</s:if>
								<s:elseif test='%{ship eq "N"}'>
									<span>ยังไม่ได้จัดส่ง</span>
								</s:elseif >
		    				</td>
		    				<td align="center">
		    					<button id="orderAdd" class="submitBtn" type="button" onclick="gotoView(<s:property value="id"/>);"> 
			  						<i class="fas fa-search"></i>
								</button>
		    				</td>
		    				<td align="center">
		    					<s:if test='%{ship eq "Y"}'>
									<button id="orderAdd" class="submitBtn" type="button" disabled="disabled">
				  						<i class="fas fa-home"></i>
									</button>
								</s:if>
								<s:elseif test='%{ship eq "N"}'>
									<button id="orderAdd" class="submitBtn" type="button" onclick="gotoEdit(<s:property value="id"/>);"> 
				  						<i class="fas fa-plane-departure"></i>
									</button>
								</s:elseif >
		    				</td>
		    				<td align="center">
		    					<s:if test='%{cancel eq "Y"}'>
									<i class="far fa-lightbulb color-orange"></i>
								</s:if>
								<s:elseif test='%{cancel eq "N"}'>
									<i class="far fa-lightbulb color-bk"></i>
								</s:elseif >
		    				</td>
		    			</tr>
		    		</s:iterator>
		    		</s:if>
		    		<s:else>
		    			<tr><td colspan="10">ไม่มีข้อมูล</td>
		    			</tr>
		    		</s:else>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Shopping Online</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	
	<s:include value="/jsp/shopping/admin/sale/include/ja-css.jsp"/>
	
	<script type="text/javascript" src="<s:url value='/js/datatable/jquery.dataTables.js' />"></script>
	<script type="text/javascript" src="<s:url value='/js/datatable/datatables.js' />"></script>
	<script type="text/javascript" src="<s:url value='/js/datatable/dataTables.fixedColumns.js' />"></script>

</head>
<body>
	
	<s:form id="searchForm" name="searchForm" method="post" namespace="/jsp/shopping" action="initAdminSale" cssClass="margin-zero" onsubmit="return false;">
		
	    <!------------------------------------- Criteria ------------------------------------->
		<div id="divSerachForm" class="CRITERIA CRITERIA_1280">
	    	<div id="divCriteria" class="RESULT_BOX BORDER_COLOR" style="display: ;">
			
				<table class="FORM" id="divCriteria_TableHorizontal">
					<tr style="display: none;">
						<td class="BORDER"></td>
						<td class="LABEL"></td>
						<td class="VALUE"></td>
						<td class="LABEL"></td>
						<td class="VALUE"></td>
						<td class="BORDER"></td>
					</tr>
					<tr>
						<td class="BORDER"></td>
						<td class="LABEL">
							<label for="criteria_no" ><s:text name="shopping.orderNumber" /></label>
						</td>
						<td class="VALUE">
							<s:textfield id="criteria_no" name="criteria.no" />
						</td>
						<td class="LABEL">
							<s:label for="criteria_ship"><s:text name="shopping.ship" /></s:label>
						</td>
						<td class="VALUE">
							<s:select id="criteria_ship" name="criteria.ship" list="listShip"  headerKey="" headerValue="ทั้งหมด" listKey="key" listValue="value" cssClass ="combox"/>
						</td>					
						<td class="BORDER"></td>
					</tr>
					<tr>
						<td class="BORDER"></td>
						<td class="LABEL">
							<s:label for="criteria_endWorkDate" value="จำนวนข้อมูลต่อหน้า" />
						</td>
						<td class="VALUE">
							<s:select id="criteria_linePerPage" cssClass="lpp-style clearform" name="criteria.linePerPage"  list="LPP" />
						</td>
						<td class="LABEL"></td>
						<td class="VALUE"></td>
						<td class="BORDER"></td>
					</tr>
					<tr>
						<td class="BORDER"></td>
						<td class="LABEL"></td>
						<td class="VALUE"></td>
						<td class="LABEL"></td>
						<td class="VALUE">
							<button type="button" class="btn btn-primary btn-sm" onclick="search();">Seach</button>
							<button type="button" class="btn btn-secondary btn-sm" onclick="clearPage()">Clear</button>
						</td>
						<td class="BORDER"></td>
					</tr>
				</table>
				
				
				
			</div>
		</div>
	    
	    <!------------------------------------- Result ------------------------------------->
	    <div class="RESULT">
		    <div id="div_datatable" class="ex_highlight_row" style="display: none;">
		    	<table class="table table-striped" id="tableResult" width="100%">
		    		<thead>
		    			<tr>
			    			<th><s:text name="shopping.no" /></th>
			    			<th><input id="criteria_selectedIds" type="checkbox" name="criteria.selectedIds" onClick="checkboxToggle('criteria.selectedIds',this.checked)" /></th>
			    			<th><s:text name="shopping.orderNumber" /></th>
			    			<th><s:text name="shopping.orderDate" /></th>
			    			<th><s:text name="shopping.fullName" /></th>
			    			<th><s:text name="shopping.totalprice" /></th>
			    			<th><s:text name="shopping.ship" /></th>
			    			<th><s:text name="shopping.view" /></th>
			    			<th><s:text name="shopping.ship2" /></th>
			    			<th><s:text name="shopping.cancel" /></th>
		    			</tr>
		    		</thead>
		    		<tbody>
						<tr>
							<!-- Loading Progress -->
							<td colspan="10" class="dataTables_empty">Loading data from server</td>
						</tr>
					</tbody>
		        </table>
		   	</div>
	   	</div>
	   	
	   	<!------------------------------------- BUTTON ------------------------------------->
		
	   	<div style="display: ;"><s:include value="/jsp/template/hiddenSearchForDatatable.jsp" /></div>
	    <s:hidden name="adminSale.id" />
	    <s:token/>
    
	</s:form>

</body>
</html>
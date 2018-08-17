<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function sf(){
		if(jQuery("[name='criteria.criteriaKey']").val() != ""){
            searchAjax();
        }
	}
	
	function search() {
		document.getElementsByName('criteria.criteriaKey')[0].value = '';
        searchAjax()
	}
	
	function clearPage() {
		submitPage("<s:url value='/jsp/shopping/initAdminSale.action' />");
	}
	
	function searchAjax(){
		var aOption = {
			divResultId: "div_datatable",
			tableId: "tableResult",
			checkbox:"Y",
			urlSearch: "<s:url value='/jsp/shopping/searchAdminSale.action' />",
			urlEdit: { url: "<s:url value='/jsp/shopping/gotoEditAdminSale.action' />" },
            urlView: { url: "<s:url value='/jsp/shopping/gotoViewAdminSale.action' />" },
            pk: "adminSale.id",
            createdRowFunc: "manageRow"
		};
		
		var colData = [
			{ data: null,		  class: "order",  orderable: false, "width":"50px"},
			{ data: null,		  class: "d_checkbox center", orderable: false, "width":"30px", defaultContent: ""},
			{ data: "no",		  class: "center", orderable: false, "width":"100px"},
			{ data: "orderDate",  class: "center", orderable: false, "width":"100px"},
			{ data: "fullName",	  class: "left",   orderable: false, "width":"200px"},
			{ data: "totalPrice", class: "right",  orderable: false, "width":"100px"},
			{ data: "ship",		  class: "left",   orderable: false, "width":"100px"},
			{ data: null,		  class: "center", orderable: false, "width":"50px", defaultContent: ""},
			{ data: "trackingNo", class: "center", orderable: false, "width":"50px"},
			{ data: "cancel",	  class: "center", orderable: false, "width":"50px"},
		];
		
		dataTable("<%=request.getContextPath()%>", colData, aOption);
    }
	
	function manageRow(row, data) {
		/* var htmlIconEdit = "";
		if(data.workStatus == "เลิกจ้าง"){
			htmlIconEdit = jQuery("#tempIconEditDisable").html();
		}else {
			htmlIconEdit = jQuery("#tempIconEditEnable").html();
		}
		jQuery(row).find("td").eq(2).html(htmlIconEdit); */
    }
	
</script>

</head>
<body>
	
	<s:form id="searchForm" name="searchForm" method="post" namespace="/jsp/shopping"  cssClass="margin-zero" onsubmit="return false;">
		
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
							<s:label for="criteria_no" value="เลขที่ใบสั่งซื้อ" />
						</td>
						<td class="VALUE">
							<s:textfield id="criteria_no" name="criteria.no" />
						</td>
						<td class="LABEL">
							<s:label for="criteria_ship" value="สถานะสินค้า" />
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
				</table>
				
				<!-- BUTTON SEARCH -->
				<input type="button" onclick="search()" value="Seach">
				<input type="button" onclick="clearPage()" value="Clear">
			</div>
		</div>
	    
	    <!------------------------------------- Result ------------------------------------->
	    <div class="RESULT">
		    <div id="div_datatable" class="ex_highlight_row" style="display: none;">
		    	<table id="tableResult" class="display">
		    		<thead>
		    			<tr>
		    				<th><s:text name="shopping.no" /></th>
		    				<th><input id="criteria_selectedIds" type="checkbox" name="criteria.selectedIds" onClick="checkboxToggle('criteria.selectedIds',this.checked)" /></th>
		    				<th><s:text name="shopping.code" /></th>
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
							<td colspan="16" class="dataTables_empty">Loading data from server</td>
						</tr>
					</tbody>
		        </table>
		   	</div>
	   	</div>
	   	
	   	<!------------------------------------- BUTTON ------------------------------------->
	   	<s:hidden name="criteria.criteriaKey" />
	    <s:hidden name="P_CODE"/>
	    <s:hidden name="F_CODE"/>
	    <s:hidden name="page"/>
	    <s:hidden name="adminSale.id" />
	    <s:token/>
    
	</s:form>

</body>
</html>
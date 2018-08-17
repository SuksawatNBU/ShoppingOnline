<%@ page contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
	function sf(){
		if(jQuery("[name='criteria.criteriaKey']").val() != ""){
			/* searchAjax(); */
        }
	}
	
	function search() {
		document.getElementsByName('criteria.criteriaKey')[0].value = '';
		
		frm = document.searchForm;
		submitPage(frm, "<s:url value='/jsp/shopping/searchAdminSale.action' />");
	}
	
	function clearPage() {
		frm = document.searchForm;
		submitPage(frm, "<s:url value='/jsp/shopping/initAdminSale.action' />");
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
	
	 function submitStatus() {
		 
	 }
	
</script>
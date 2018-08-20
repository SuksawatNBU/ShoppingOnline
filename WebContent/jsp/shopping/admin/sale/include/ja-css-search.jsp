<%@ page contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
	function sf(){
		if(jQuery("[name='criteria.criteriaKey']").val() != ""){
			/* search(); */
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
		
    }
	
	function checkboxToggle() {
		
	}
	
	function submitStatus() {
		
		//name ของ checkbox table กลางเป็นคน gen ให้โดยชื่อเดียวกัน
	    var chk = validateSelect('criteria.selectedIds');
	    if (chk == false) {
	        return false;
	    }
	 	
	    if(confirm(msg) == false){
	        return false;
	    }
	 
	    //ต้องสร้างให้เนื่องจากเป็น attr ที่อยู่ใน CommonDomain
	    document.getElementsByName('criteria.statusForUpdate')[0].value = active;   
	    
	    frm = document.searchForm;
	    submitPage(frm, action);
	}

	function gotoView(id) {
		document.getElementsByName("adminSale.id")[0].value = id;
		frm = document.searchForm;
		submitPage(frm, "<s:url value='/jsp/shopping/gotoViewAdminSale.action' />");
	}
	
	function gotoEdit(id) {
		document.getElementsByName("adminSale.id")[0].value = id;
		frm = document.searchForm;
		submitPage(frm, "<s:url value='/jsp/shopping/gotoEditAdminSale.action' />");
	}
</script>

<style type="text/css">
	.color-orange {
		color: orange;
		
	}
</style>
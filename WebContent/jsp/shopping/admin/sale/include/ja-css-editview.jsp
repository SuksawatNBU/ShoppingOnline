<%@ page contentType="text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">
	function sf(){
	
	}
	
	function saveEdit(){
	    //1.ขั้นตอนการตรวจสอบ validate
	    /* if(!validateAll()){
	        return false;
	    } */
	    //2.Confirm dialog
	    if(confirm('<s:text name="50004" />') == false){  
	        return false;
	    }
	    frm = document.addEditForm;
	    submitPage(frm,"<s:url value='/jsp/shopping/editAdminSale.action' />");    
	}
	
	/* กดปุ่มยกเลิกแก้ไข  */
	function cancelEdit(){
		if(!confirm("<s:text name='50009' />")){
			return false;
		}
		submitPageForm();
	}
	
	/* กดปุ่มยกเลิกแสดง */
	function cancelView(){
		if (!confirm('<s:text name="50010" />')) {
            return false;
        }
		submitPageForm();
	}
	
	function submitPageForm() {
        if (document.getElementsByName('criteria.criteriaKey')[0].value == '') {
            action = "<s:url value='/jsp/shopping/initAdminSale.action' />";
        } else {
            action = "<s:url value='/jsp/shopping/cancelAdminSale.action' />";
        }
        frm = document.addEditForm;
        submitPage(frm,action);
    }
	
</script>

<style type="text/css">
	.color-orange {
		color: orange;
		background-color: orange;
	}
</style>
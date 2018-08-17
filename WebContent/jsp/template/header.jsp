<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script type="text/javascript">
		function logout() {
			// Confirm dialog
		    if(confirm('<s:text name="50011" />') == false){ 
		        return false;
		    }

		    document.forms[0].action = '<s:url value="/jsp/security/logoutLogin.action"/>';
			document.forms[0].submit();
		}
	</script>
	
	<style type="text/css">
		.btn-link{
			color: black;
		}
	</style>

</head>
<table class="header">
	<tr>
		<td width="50%"></td>
		<td width="30%"></td>
		<td width="20%"></td>
	</tr>
	<tr>
		<td ></td>
		<td ></td>
		<td align="right" style="padding-right: 10px;">
			<s:form>
			<p>ยินดีต้อนรับ &nbsp;<s:property value="#session.user.fullName" /></p>
			<button type="button" class="btn-link" onclick="logout();"><b>Logout</b></button>
			</s:form>
		</td>
	</tr>
</table>

</html>

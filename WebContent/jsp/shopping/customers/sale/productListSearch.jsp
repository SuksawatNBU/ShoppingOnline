<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function sf(){
		
	}
	
	function searchAjax(){
		var aOption = {
			divResultId: "div_datatable",
			tableId: "tableResult",
			urlSearch: "<s:url value='/jsp/tutorial/searchEmployee.action' />",
			pk: "product.id"
		};
		
		var colData = [
			
		];
		
		dataTable("<%=request.getContextPath()%>", colData, aOption);
    }
	
</script>
</head>
<body>
	<s:form>
		<s:iterator id="listResult" value="listResult" var="p">
			<p><s:property value="p.id" /></p>
			<p><s:property value="id" /></p>
		</s:iterator>
	</s:form>
</body>
</html>
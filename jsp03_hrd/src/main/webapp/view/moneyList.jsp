<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 매출조회 -->
	<%
		List<Map<String, Object>> mlist = 
			(List<Map<String, Object>>) request.getAttribute("mlist");
	%>
	<%@include file="header.jsp" %>
	<h2>회원매출조회</h2>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		<%
			if (mlist != null){
				for(Map<String, Object> map:mlist){
		%>
					<tr>
						<td><%=map.get("custno") %> </td>
						<td><%=map.get("custname") %> </td>
						<td><%=map.get("grade") %> </td>
						<td><%=map.get("price") %> </td>
					</tr>				
		<%		}
			}
		%>
		
	</table>
</body>
</html>
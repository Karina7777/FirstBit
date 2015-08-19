<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/create_new_user">Create new user</a>

<table id="usersTable" align="center">	
  <tr>
   	<th width="50%">Name</th>
    <th width="50%">Actions</th>
  </tr>
		      
  <c:forEach items="${AllUsers}" var="user">
  <tr id="tr_${user.id}" align="center">
    <td>${user.name}</td>	
	<td>
      <input type="button" value="Delete" id="btn_${user.id}" onclick="deleteUser(this.id)"><br/>
      <a href="${pageContext.request.contextPath}/contacts/${user.id}">Show contacts</a><br/>
      <a href="${pageContext.request.contextPath}/add_new_contact/${user.id}">Add new contact</a><br/>
    </td>
  </tr>   
  </c:forEach>	
</table>
</body>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function deleteUser(id){
	  var id = id.split("_")[1];
	  
	  $.ajax({
			url : "${pageContext.request.contextPath}/delete_user",
			type : "post",
			data : "userId="+id,
			success : function(response){
				var table = document.getElementById("usersTable");
				var tr = document.getElementById("tr_"+id); 
				table.deleteRow(tr.rowIndex);
				alert(response);
			},
			error : function(error){
				alert(error);
			}
		});
 }
</script>

</html>
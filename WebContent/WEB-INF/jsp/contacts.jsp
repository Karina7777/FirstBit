<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacts</title>
</head>



<body>
  <table id="contactsTable" align="center">  
  <tr>
    <th width="10%">Name</th>
    <th width="10%">Email</th>
    <th width="10%">Telephone</th>
    <th width="10%">Action</th>
  </tr>
          
  <c:forEach items="${contacts}" var="contact">
  <tr align="center" id="tr_${contact.id}">
    <td>${contact.name}</td> 
    <td>${contact.email}</td>
    <td>${contact.telephone}</td>
    <td><input type="button" value="Delete" id="btn_${contact.id}" onclick="deleteContact(this.id)"></td>
  </tr>   
  </c:forEach>
 
</table>
  
</body>

<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script type="text/javascript">
  function deleteContact(id){
    var id = id.split("_")[1];
    
    $.ajax({
      url : "${pageContext.request.contextPath}/delete_contact",
      type : "post",
      data : "contactId="+id,
      success : function(response){
        var table = document.getElementById("contactsTable");
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
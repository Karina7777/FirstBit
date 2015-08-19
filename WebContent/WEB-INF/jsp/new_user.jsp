<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New user</title>
</head>
<body>
  <div><label>${message}</label></div>
  <div>
    <form action="${pageContext.request.contextPath}/new_user/" method="post" onsubmit="return do_validations()">
      <table>
        <tr>
          <td><label>Enter username:</label></td>
          <td><input id="username" type="text" name="username"/></td>
        </tr>
        
        <tr>
          <td>&nbsp</td>
          <td><input type="submit" value="Create user"/></td>
        </tr>
       
      </table>
    </form>
  </div>

</body>
<script type="text/javascript">
  function do_validations(){
	var username   = document.getElementById("username").value;
	if(username == ""){
	  alert("Name can't be empty.");
	  false;
	}
	else{
	  true;
	}
  };
</script>
</html>
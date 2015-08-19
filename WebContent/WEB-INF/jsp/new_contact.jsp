<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Contact</title>
</head>
<body>
  <div><label>${message}</label></div>
  <div>
    <form id="form" action="${pageContext.request.contextPath}/add_new_contact/3" method="post" onsubmit="return do_validations(this)">
      <table>
        <tr>
          <td><label>Enter username:</label></td>
          <td><input id="username" type="text" name="username"/></td>
        </tr>
        
        <tr>
          <td><label>Enter telephone:</label></td>
          <td><input id="telephone" type="text" name="telephone"/></td>
        </tr>
        
        <tr>
          <td><label>Enter email:</label></td>
          <td><input id="email" type="text" name="email"/></td>
        </tr>
        
        <tr>
          <td>&nbsp</td>
          <td><input type="submit" value="Create contact"/></td>
        </tr>
       
      </table>
    </form>
  </div>
</body>
<script type="text/javascript">
  function do_validations(value){
	var url = document.location.href;
	var id = url.split("/")[5];
	value.action = id;	
}
	
</script>
</html>
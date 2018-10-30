<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
</head>
<body>

  <div class="wrapper">
    <form class="form-signin" method="POST" action="LoginServlet"> 
      <link rel="stylesheet" href="resources/css/loginpage.css" />      
      <h2 class="form-signin-heading">Please login</h2>
      <input type="text" class="form-control" name="user_login" placeholder="User Login" required="" autofocus="" />
      <input type="password" class="form-control" name="password" placeholder="Password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
      </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit" >Login</button>
            <center> <section> ${message}  </section></center>
    </form>  
    <form class="form-signin" action="register.jsp"> 
     <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>   </form>  
     
  </div>


</body>
</html>
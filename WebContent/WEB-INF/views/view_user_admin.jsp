<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/button.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your User Profile</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/tables.css" />
<link rel="stylesheet" href="resources/css/main_layout.css" />
<link rel="stylesheet" href="resources/css/button_style.css" />
</head>
<body>

<div id="main">
  <div class="container">
    <nav>
      <div class="nav-xbootstrap">
        <ul>
          <li><a href="ShowAdminPanel">Home</a></li>
          <li><a href="javascript:void(0)">Manage Registrations<span class="glyphicon glyphicon-chevron-down iconsize"></span></a>
            <ul class="dropdown">
              <li><a href="ShowLarpsAndPlayersAdminPanel">List Larps and Users Registered for Them</a></li>
              <li><a href="ShowPlayersAndLarpsAdminPanel">List Users and Larps They Registered For</a></li>
            </ul>
          </li>
          <li><a href="javascript:void(0)" >Manage Larps<span class="glyphicon glyphicon-chevron-down iconsize"></span></a>
            <ul class="dropdown">
              <li><a href="ManageLarpsListAdminPanel">List Of Larps / Edit / Remove Larps</a></li>
              <li><a href="ManageLarpsNewLarpAdminPanel">Add New Larp</a></li>
            </ul>
          </li>
          <li><a href="javascript:void(0)" >User Settings<span class="glyphicon glyphicon-chevron-down iconsize"></span></a>
            <ul class="dropdown">
              <li><a href="ManageUsersListAdminPanel">List All Users / Remove Users</a></li>
              <li><a href="ManageUsersNewUserAdminPanel">Add New User</a></li>
              <li><a href="ViewUserForm_Admin_Player">Your User Profile</a></li>
              <li><a href="EditUserForm_Admin_Player">Edit User Profile</a></li>
            </ul>
          </li>
          <li><a href="LogoutServlet">Logout</a></li>
        </ul>
      </div>
      <div class="nav-bg-xbootstrap">
        <div class="navbar-xbootstrap"> <span></span> <span></span> <span></span> </div>
        <a href="https://xbootstrap.com" class="title-mobile">xBOOTSTRAP.COM</a>
      </div>
    </nav>
</div>
</div>

<br>
<h2 style="text-decoration: underline;">Your User Profile</h2>

 <table class="responstable">
    <tr>
    <th>User ID</th>
    <th>User Login</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Nickname</th>
    <th>Email</th>
    <th>Gender</th>
  </tr>
   <tr>
  
                <td>${chosen_user.id}</td>
                <td>${chosen_user.login}</td>
                <td>${chosen_user.firstName}</td>
                <td>${chosen_user.lastName}</td>
                <td>${chosen_user.nickname}</td>
                <td>${chosen_user.email}</td>
	 			<td>${chosen_user.gender}</td>
  </tr>
  

  
</table>

 <form method="GET" action="EditUserForm_Admin_Player"> 
<button id="submitbutton" type="submit" class="myButton">Edit User</button> <br> <br>
</form>


 
</body>

 <center>  <section>
  ${message}
</section> </center>

</html>

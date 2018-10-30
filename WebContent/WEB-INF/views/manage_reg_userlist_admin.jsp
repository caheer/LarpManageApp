<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/button.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users and Larps They Registered For</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/tables.css" />
<link rel="stylesheet" href="resources/css/button_style.css" />
<link rel="stylesheet" href="resources/css/main_layout.css" />
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
 <h2 style="text-decoration: underline;">List Users and Larps They Registered For</h2>
 <br>
<h2>User List: </h2>

 <form method="POST" action="ShowLarpsInUsersAdmin"> 
 <table class="responstable">
    <tr>
    <th>Selection</th>
    <th>ID</th>
    <th ><span>Login</span></th>
    <th>Fist Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Nickname</th>
    <th>Gender</th>
    <th>User Status</th>
  </tr>
  
<c:if test="${fn:length(user_list) > 0}">
<c:forEach items="${user_list}" var="record">
  <tr>
  				<td><input type="radio" name="chosen_u_id" value="${record.id}" checked/></td>
                <td>${record.id}</td>
                <td>${record.login}</td>
                <td>${record.firstName}</td>
                <td>${record.lastName}</td>
                <td>${record.email}</td>
                <td>${record.nickname}</td>
                <td>${record.gender}</td>
                <td>${record.userstatus}</td>
  </tr>
  
</c:forEach>
        </c:if>
  
</table>
<button id="submitbutton" type="submit" class="myButton">Get Games For This User</button> <br> <br>
 </form>
 
  <h2>Larp List : ${message}</h2>
 
 <form method="GET" action="ShowPlayersAndLarpsAdminPanel"> 
 <table class="responstable">
    <tr>
    <th>ID</th>
    <th>Larp Title</th>
    <th>Larp Authors</th>
    <th>Larp Description</th>
    <th>Larp Place</th>
    <th>Larp Time</th>
    <th ><span>Added By</span></th>
    <th>Current No. Of Pl.</th>
    <th>Max No. Of Pl.</th>
    <th>Registration Status</th>
  </tr>
  
<c:if test="${fn:length(larps_in_users_list) > 0}">
<c:forEach items="${larps_in_users_list}" var="record">
  <tr>
                <td>${record.id}</td>
                <td>${record.larpTitle}</td>
                <td>${record.larp_authors}</td>
                <td>${record.larpDescription}</td>
                <td>${record.larpPlace}</td>
                <td>${record.larpTime}</td>
                <td>${record.addedBy}</td>
                <td>${record.current_participants_no}</td>
                <td>${record.max_participants_no}</td>
				<td>${record.larp_reg_stat}</td>	
  </tr>
  
</c:forEach>
        </c:if>
  
</table>
 <button id="backbutton" class="myButton" type="submit">Back</button>
 </form>
 <c:choose>
  <c:when test="${empty user_list}">
	<script>  
		disablebutton();
	</script>
  </c:when>
</c:choose>
</body>


</body>
</html>
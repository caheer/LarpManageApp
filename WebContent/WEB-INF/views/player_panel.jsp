<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ page import="java.util.*, com.larp.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<script src="larp_validation.js" type="text/javascript"></script>
<script src="user_validation.js" type="text/javascript"></script>
<style>
body {
	font-family: arial, sans-serif;
	font-size: 14px;
}
</Style>
<title>Player Panel</title>
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
          <li><a href="ShowPlayerPanel">Home</a></li>
          <li><a href="javascript:void(0)">Manage Larp Registrations<span class="glyphicon glyphicon-chevron-down iconsize"></span></a>
            <ul class="dropdown">
              <li><a href="ShowLarpsInLoggedUser">Manage Your Current Registrations</a></li>
              <li><a href="ShowPlayerRegistrationPanel">Register For a Larp Game</a></li>
            </ul>
          </li>
          <li><a href="javascript:void(0)" >User Settings<span class="glyphicon glyphicon-chevron-down iconsize"></span></a>
            <ul class="dropdown">
              <li><a href="ViewUserForm_Admin_Player">View Profile</a></li>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<center>
		<h1 style="text-decoration: underline;">PLAYER PANEL</h1>

		Welcome to the player panel. Select one of the positions in
		the menu bar above <br> <br>
		<h1>Manage Registrations - Here you can access menu options
			connected with managing gmae registrations and registering for new games</h1>
		<br>
		<h1>User Settings - Here you can edit and check your own user profile</h1>
	</center>

</body>
</html>
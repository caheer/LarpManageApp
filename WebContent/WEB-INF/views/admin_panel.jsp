<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<%@ page import="java.util.*, com.larp.models.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: arial, sans-serif;
	font-size: 14px;
}
</Style>
<title>Admin Panel</title>
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
						<li><a href="javascript:void(0)">Manage Registrations<span
								class="glyphicon glyphicon-chevron-down iconsize"></span></a>
							<ul class="dropdown">
								<li><a href="ShowLarpsAndPlayersAdminPanel">List Larps
										and Users Registered for Them</a></li>
								<li><a href="ShowPlayersAndLarpsAdminPanel">List Users
										and Larps They Registered For</a></li>
							</ul></li>
						<li><a href="javascript:void(0)">Manage Larps<span
								class="glyphicon glyphicon-chevron-down iconsize"></span></a>
							<ul class="dropdown">
								<li><a href="ManageLarpsListAdminPanel">List Of Larps /
										Edit / Remove Larps</a></li>
								<li><a href="ManageLarpsNewLarpAdminPanel">Add New Larp</a></li>
							</ul></li>
						<li><a href="javascript:void(0)">User Settings<span
								class="glyphicon glyphicon-chevron-down iconsize"></span></a>
							<ul class="dropdown">
								<li><a href="ManageUsersListAdminPanel">List All Users
										/ Remove Users</a></li>
								<li><a href="ManageUsersNewUserAdminPanel">Add New User</a></li>
								<li><a href="ViewUserForm_Admin_Player">Your User Profile</a></li>
								<li><a href="EditUserForm_Admin_Player">Edit User Profile</a></li>
							</ul></li>
						<li><a href="LogoutServlet">Logout</a></li>
					</ul>
				</div>
				<div class="nav-bg-xbootstrap">
					<div class="navbar-xbootstrap">
						<span></span> <span></span> <span></span>
					</div>
					<a href="https://xbootstrap.com" class="title-mobile">xBOOTSTRAP.COM</a>
				</div>
			</nav>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<br>
	<center>
		<h1 style="text-decoration: underline;">ADMINISTRATOR PANEL</h1>

		Welcome to the administration panel. Select one of the positions in
		the menu bar above <br> <br>
		<h1>Manage Registrations - Here you can access menu options
			connected with managing new larp games, game registrations and users</h1>
		<br>
		<h1>Manage Registrations - Here you can check the list of games
			and search for users who registered for them, and check the list of
			users and search for games they registered for</h1>
		<br>
		<h1>Manage Larps - Here you can list, create, edit and remove
			larp games</h1>
		<br>
		<h1>Manage Users - Here you can list, create, edit and remove
			users, as well as edit and check your own user profile</h1>
	</center>





</body>
</html>
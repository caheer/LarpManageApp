<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <style>
.styled-select {
        overflow: hidden;
        height: 30px;
        border-color:#A4A4A4;
}
.styled-select select {
        font-size: 11pt;
        font-family: arial, sans-serif;
        color:#A4A4A4;
        height: 30px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Player Data</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/tables.css" />
<link rel="stylesheet" href="resources/css/main_layout.css" />
<link rel="stylesheet" href="resources/css/button_style.css" />
<link rel="stylesheet" href="resources/css/easydropdown.css" />
<link rel="stylesheet" href="resources/css/easydropdown.metro.css" />

</head>
<body>

<div class="container">
	<div class="row">
		<h2>Edit User Data</h2> 
        
        <form class="form-horizontal"  method="POST" action="EditUser_Any_Admin">
<fieldset>

<!-- Form Name -->
<legend>Change your user data here</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">User ID</label>  
  <div class="col-md-4">
  <input id="textinput" name="user_id" placeholder="ID" class="form-control input-md" required="" type="text" value="${chosen_user.id}" readonly>
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Login</label>  
  <div class="col-md-4">
  <input id="textinput" name="login" placeholder="Enter User login" class="form-control input-md" required="" type="text" value="${chosen_user.login}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">First Name</label>  
  <div class="col-md-4">
  <input id="textinput" name="first_name" placeholder="Enter User First Name" class="form-control input-md" required="" type="text" value="${chosen_user.firstName}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Last Name</label>  
  <div class="col-md-4">
  <input id="textinput" name="last_name" placeholder="Enter User Last Name" class="form-control input-md" required="" type="text" value="${chosen_user.lastName}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Nickname</label>  
  <div class="col-md-4">
  <input id="textinput" name="nickname" placeholder="Enter User Nickname" class="form-control input-md" required="" type="text" value="${chosen_user.nickname}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Email</label>  
  <div class="col-md-4">
  <input id="textinput" name="email" placeholder="Enter User Email" class="form-control input-md" required="" type="email" value="${chosen_user.email}">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="gender">Gender</label>  
  <div class="col-md-4">
  <div class="styled-select">
		<select name="gender">
<c:if test = "${chosen_user.gender == 'Male' }">
			<option value="Female">Female</option>
			<option value="Male" selected>Male</option> 
			</c:if>
		<c:if test = "${chosen_user.gender == 'Female' }">
			<option value="Female" selected>Female</option>
			<option value="Male">Male</option> 
			</c:if>
		</select>
		</div>
		  <span class="help-block"> </span>  
		  </div>
</div>


<!-- Text input-->
<!-- <div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Password</label>  
  <div class="col-md-4">
  <input id="textinput" name="password" placeholder="Insert your Password" class="form-control input-md" required="" type="password">
  <span class="help-block"> </span>  
  </div>
</div>-->


<!-- Text input
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Confirm Password</label>  
  <div class="col-md-4">
  <input id="textinput" name="textinput" placeholder="Confirm your Password" class="form-control input-md" required="" type="text">
  <span class="help-block"> </span>  
  </div>
</div> -->

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"> </label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="myButton">Submit</button>
     <button id="backbutton" class="myButton" type="submit" formaction="ManageUsersListAdminPanel" formnovalidate>Back</button>
  </div>
</div>

</fieldset>
</form>

	</div>
</div>

</body>
</html>
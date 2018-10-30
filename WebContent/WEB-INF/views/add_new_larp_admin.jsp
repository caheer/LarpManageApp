<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ page import="java.util.*, com.larp.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
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

<script src="jquery-3.2.1.min.js"></script>
<title>Add New Larp</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/tables.css" />
<link rel="stylesheet" href="resources/css/main_layout.css" />
<link rel="stylesheet" href="resources/css/button_style.css" />
<link rel="stylesheet" href="resources/css/easydropdown.css" />
<link rel="stylesheet" href="resources/css/easydropdown.metro.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
</head>
<body>

<div class="container">
	<div class="row">
		<h2>Add New Larp</h2> 
        
<form class="form-horizontal"  method="POST" action="AddNewLarp">
<fieldset>

<!-- Form Name -->
<legend>Enter Larp details here</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp ID</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_id" placeholder="Larp ID" class="form-control input-md" required="" type="text" value="${chosen_larp.id}" readonly>
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Title</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_title" placeholder="Enter Larp Title" class="form-control input-md" required="" type="text" value="${chosen_larp.larpTitle}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Description</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_descr" placeholder="Enter Larp Description" class="form-control input-md" required="" type="text" value="${chosen_larp.larpDescription}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Place</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_place" placeholder="Enter Larp Place" class="form-control input-md" required="" type="text" value="${chosen_larp.larpPlace}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Authors</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_authors" placeholder="Enter Larp Authors" class="form-control input-md" required="" type=""text"" value="${chosen_larp.larp_authors}">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
<label class="col-md-4 control-label" for="registr_status">Registration status</label>  
  <div class="col-md-4">
  <div class="styled-select">
    <div class="styled-select">
		<select name="registr_status">
			<option value="Registration_active" selected>Registration_active</option>
			<option value="Registration_disabled">Registration_disabled</option>
			<option value="Registration_ended">Registration_ended</option> 
		</select>
		</div>
		</div>
		  <span class="help-block"> </span>  
		  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Current Number Of Players</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_cur_partic" placeholder="Enter Current Number Of Players" class="form-control input-md" required="" type=""text"" value="${chosen_larp.current_participants_no}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Max. Number Of Players</label>  
  <div class="col-md-4">
  <input id="textinput" name="larp_max_partic" placeholder="Enter Max. Number Of Players" class="form-control input-md" required="" type=""text"" value="${chosen_larp.max_participants_no}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
              <label  class="col-md-4 control-label" for="datepicker">Date</label>
               <div class="col-md-4">
                <input type="text" name="selDate" id="datepicker" value="01/01/2017" required="" readonly>
                  <span class="help-block"> </span>  
 				 </div>
                </div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Hour</label>  
  <div class="col-md-4">
  <input id="textinput" name="hour" placeholder="Insert hour" class="form-control input-md" required="" type=""text"" value="${larp_hour}">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Larp Minute</label>  
  <div class="col-md-4">
  <input id="textinput" name="minute" placeholder="Insert minute" class="form-control input-md" required="" type=""text"" value="${larp_minute}">
  <span class="help-block"> </span>  
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"> </label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="myButton">Submit</button>
    <button id="backbutton" class="myButton" type="submit" formaction="ManageLarpsListAdminPanel" formnovalidate>Back</button>
  </div>
</div>

</fieldset>
</form>
  
	</div>
</div>

 <center>  <section> ${message}
</section> </center>

</body>
</html>
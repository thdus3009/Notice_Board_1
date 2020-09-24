<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<link rel="stylesheet" href="style.css">
<style type="text/css">
.box_size {
color: navy;
width: 500px;
margin: 10% auto;

}
</style>
</head>

<body>
<c:import url="../template/nav.jsp"></c:import>

<div class="box_size" >
	<form action="/action_page.php" >
	  <div class="form-group">
	    <label for="id">ID:</label>
	    <input type="text" class="form-control" id="id">
	  </div>
	  <div class="form-group">
	    <label for="pwd">Password:</label>
	    <input type="password" class="form-control" id="pwd">
	  </div>
	  <div class="checkbox">
	    <label><input type="checkbox"> Remember me</label>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>
</body>
</html>
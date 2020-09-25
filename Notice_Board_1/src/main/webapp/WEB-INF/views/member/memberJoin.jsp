<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/boot.jsp"></c:import>
<link href="../css/boxSize.css" rel="stylesheet" type="text/css">

</head>
<body>
<c:import url="../template/nav.jsp"></c:import>

<div class="box_size" >
<form:form modelAttribute="memberVO" action="./memberJoin" method="post"  enctype="multipart/form-data">

  <div class="form-group">
    <label for="id">ID:</label>
    <form:input path="id" type="text" class="form-control" id="id"/>
    <form:errors path="id" cssClass="r"></form:errors> 
  </div>
  
  <div class="form-group">
    <label for="pw">Password:</label>
    <form:input path="pw" type="password" class="form-control" id="pw"/>
    <form:errors path="pw" cssClass="r"></form:errors> 
  </div>
  
  <div class="form-group">
    <label for="pwd2">Check_Password:</label>
    <form:input path="pwCheck" type="password" class="form-control" id="pwCheck"/>
    <form:errors path="pwCheck" cssClass="r"></form:errors> 
  </div>
  
    <div class="form-group">
    <label for="id">Name:</label>
    <form:input path="name" type="text" class="form-control" id="name"/>
    <form:errors path="name" cssClass="r"></form:errors> 
  </div>
  
    <div class="form-group">
    <label for="email">Email address:</label>
    <form:input path="email" type="email" class="form-control" id="email"/>
    <form:errors path="email" cssClass="r"></form:errors> 
  </div>
  
    <div class="form-group">
    <label for="phone">Phone:</label>
    <form:input path="phone" type="text" class="form-control" id="phone"/>
	<form:errors path="phone" cssClass="r"></form:errors> 
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
</form:form>
</div>

</body>
</html>
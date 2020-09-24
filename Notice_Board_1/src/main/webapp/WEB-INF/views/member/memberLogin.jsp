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
	<form action="./memberLogin" method="post"  >
	  <div class="form-group">
	    <label for="id">ID:</label><!-- label을 클릭하면, 연결된 양식에 입력할 수 있도록 하거나 체크를 하거나 체크를 해제합니다. -->
	    <input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요" > <!-- 데이터는 name으로 넘긴다. name:내용 / id:master -->
	  </div>
	  <div class="form-group">
	    <label for="pw">Password:</label>
	    <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요" >
	  </div>
	  <div class="checkbox">
	    <label><input type="checkbox"> Remember me</label>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>



</body>
</html>
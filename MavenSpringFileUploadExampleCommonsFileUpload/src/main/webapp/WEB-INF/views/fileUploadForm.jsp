<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Example</title>
</head>
<body>

	<h1>Spring MVC - File Upload Example</h1>
	<hr />
	<h3>Single file Upload</h3>
	<form action="singleFileUpload" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select File</td>
				<td><input type="file" name="file"></td>
				<td><button type="submit">Upload</button></td>
			</tr>
		</table>
	</form>

	<br />
	<hr />
	<h3>Multiple file Upload</h3>
	<form action="multipleFileUpload" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select Files</td>
				<td><input type="file" name="file" multiple="multiple"></td>
				<td><button type="submit">Upload</button></td>
			</tr>
		</table>
	</form>
	<br>
	<hr />
	<span style="color: red; font-size: 14px;">${msg}</span>
</body>
</html>
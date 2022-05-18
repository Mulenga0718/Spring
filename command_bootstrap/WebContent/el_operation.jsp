<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setAttribute("a", "1");
request.setAttribute("b", "2");

%>
</head>
<body>
	<h3>사칙연산</h3>
	<ul>
		<li>＄{a+b} : ${a+b}  </li>
		<li>＄{a-b} : ${a-b}  </li>
		<li>＄{a/b} : ${a/b}  </li>
		<li>＄{a*b} : ${a*b}  </li>
	</ul>
	<ul>
		<li>＄{a eq b} : ${a eq b}  </li>
		<li>＄{a ne b} : ${a ne b}  </li>
		<li>＄{a gt b} : ${a gt b}  </li>
		<li>＄{a lt b} : ${a lt b}  </li>
	
	</ul>
	<h3>
	<ul>
		<li>＄{true and true} : ${true and true}  </li>
		<li>＄{false or false} : ${false or false}  </li>
		<li>＄{not true} : ${not true}  </li>
	</ul>	
	</h3>
	<h3>삼항 연산</h3>
	<ul>
		<li>
		＄{true ? 1:0} : ${true ?1:0}
		</li>
	</ul>
	<h3>삼항 연산</h3>
	<ul>
		<li>
		＄{empty member} : ${empty member}
		</li>
	</ul>
</body>
</html>
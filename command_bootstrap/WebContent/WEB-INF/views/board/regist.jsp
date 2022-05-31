<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<style>
 #outter{
	margin: 20px;
	padding-left: 30px;
 }
 #button-align{
 	text-align: right;
 }
</style>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
</head>

<title>자유게시판 등록</title>
<body>
<h2 style="text-align: center">게시글 등록</h2>
<hr>
<br>
	<p id="button-align"><input type="button" class="btn btn-primary" onclick="regist_go()" value="등록">
	<input type="button" class="btn btn-warning" value="목록" onclick="javascript:window.close();"></p>
<div id="outter">
<form action="regist.do" method="post" name="registForm">
<label>제목</label>
<input type="hidden" name="writer" value="${loginUser.id }" >
<input type ="text" name ="title" class="form-control" style="width: 500px; heigth:30px;"><br>
<label>내용</label><br>
<textarea name="content"  id="summernote"></textarea><br>
<p style="text-align: right; padding-right: 50px">
	
</p>

</form>
</div>
 <script type="text/javascript">
    window.onload= function(){
    summernote_go($('textarea[name="content"]'),'<%=request.getContextPath()%>');
    }
    </script>
      <script type="text/javascript">
    function regist_go(){
    	var form = document.registForm;
    	if(form.title.value==""){
    		alert("제목은 필수입니다.");
    		return;
    	}
    	form.submit();
    }

    </script>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>

<script>
	$(document).ready(function(){
		
		$.ajax({
			type : 'get',		// 조회
			url : 'sample',
			success : function(result){
				var content = result.mno
						    += result.firstName
						    += result.lastName
			
				$("#sample").html(content);		    
			}
		});
		
		$.ajax({
			type : 'get',		// 조회
			url : 'list',
			success : function(result){
				var content = "<table><tr><th>번호</th><th>성</th><th>이름</th></tr>"
				$.each(result, function(index, item){
					content += "<tr><td>" + item.mno +"</td>"
					content += "    <td>" + item.firstName + "</td>"
					content += "    <td>" + item.lastName + "</td></tr>"					
				});	
				
				$("#list").html(content);
			}			
		});	
		
	});
</script>

<div id="sample"></div>
<div id="list"></div>

</body>
</html>
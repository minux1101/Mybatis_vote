<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>후보 등록 삭제</title>
<style type="text/css">
/*링크의 색은 검은색, 라인이 안생기게 설정.*/
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>

<table style=text-align:center; border=1px; bordercolor="blue">
	<tr>
		<!-- 각각의 글씨를 누르면 해당하는 주소로 연결된다. -->
		<td style=text-align:center;background-color:yellow;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/">후보등록</a></td>
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/B_01">투표</a></td>
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/C_01">개표결과</a></td> 
	</tr>	
</table>
	후보 삭제 결과 : ${deleteCandidate.name} 후보가 삭제 되었습니다
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>투표</title>
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
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote">후보등록</a></td>
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/B_01">투표</a></td>
		<td style=text-align:center;background-color:yellow;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/C_01">개표결과</a></td> 
	</tr>	
</table>
	<p style=font-size:1.1em;margin-left:20px;>${candidate.num}. ${candidate.name} 후보 득표성향 분석</p>
	<table border=1px>
		<c:forEach items="${ageModel}" var="age">
		<tr>
			<td>${age}대</td> <!-- 각 연령의 득표수와 득표율을 계산하는 메소드를 호출해서 값을 출력 -->
			<td width=500px>
				<table>  <!--열 안에 테이블을 만들어서 td의 넓이를 득표율*5 만큼으로 만들어서 그래프처럼 이용. -->
					<tr> 
						<td style=background-color:red; width=${agePercent.get(age/10-1)*5}></td>
						<td> &ensp;${ageList.get(age/10-1)} (${agePercent.get(age/10-1)}%)</td>
					</tr>
				</table>
		</tr>
	</c:forEach>
</table>
</body>
</html>
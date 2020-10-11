<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>후보 등록</title>
<style type="text/css">
/*링크의 색은 검은색, 라인이 안생기게 설정.*/
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
<script>
function checking() {
	if (document.getElementById("name2").value == "" || document.getElementById("name2").value == null) {
		alert("빈 칸을 채워주십시오");  /*후보 이름이 null값이거나 공백일 때 경고창이 나온다.*/
	} else {
		document.form.action="A_03";  /*후보 이름이 있으면 A_03.jsp로 이동한다.*/
		document.form.submit();  /*form의 값을 넘긴다.*/
	}
}
</script>
</head>
<body>
	<table style=text-align:center; border=1px; bordercolor="blue">
		<tr>
			<!-- 각각의 글씨를 누르면 해당하는 주소로 연결된다. -->
			<td style=text-align:center;background-color:yellow;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote">후보등록</a></td>
			<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/B_01">투표</a></td>
			<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/C_01">개표결과</a></td> 
		</tr>	
	</table>
	<form method="post" name="form">
	<table border=1px>
		<c:choose>
			<c:when test="${empty CandidateList}">			
				<spring:message code="common.CandidateListEmpty"/>			
			<tr> <!-- 등록할 후보의 번호와 이름을 입력하는 창 추가 버튼을 누르면 A_03.jsp로 이동되고, 후보가 추가 된다. -->
			<td>기호번호 : <input style=width:50px;border-color:#27DBB7; type="text" name="num2" value="1" readonly>   
				후보명 : <input style=width:120px;border-color:#27DBB7; onkeyup="this.value=this.value.replace(/[^가-힣]/g,'');" id="name2" name="name2">
				<input style=margin-left:100px;background-color:#27DBB7;border-color:#27DBB7; type="button" value="추가" onclick="checking()"></td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${CandidateList}" var="candidate">
					<tr>
						<td> 기호번호 : <input style=width:50px;border:none; type="text" name="num" value="${candidate.num}" readonly>  
					     	후보명 : <input style=width:120px;border:none; type="text" name="name"  value="${candidate.name}" readonly>
						<input style=margin-left:108px;background-color:#27DBB7;border-color:#27DBB7; type="button" value="삭제" Onclick="window.location='${path}/vote/A_02?num=${candidate.num}'"></td>
					</tr>
				</c:forEach>
		<tr> <!-- 등록할 후보의 번호와 이름을 입력하는 창 추가 버튼을 누르면 A_03.jsp로 이동되고, 후보가 추가 된다. -->
			<td>기호번호 : <input style=width:50px;border-color:#27DBB7; type="text" name="num2" value="${CandidateList.get(CandidateList.size()-1).num + 1}" readonly>   
				후보명 : <input style=width:120px;border-color:#27DBB7; onkeyup="this.value=this.value.replace(/[^가-힣]/g,'');" id="name2" name="name2">
				<input style=margin-left:100px;background-color:#27DBB7;border-color:#27DBB7; type="button" value="추가" onclick="checking()"></td>
		</tr>
			</c:otherwise>
		</c:choose>
	</table>	
	</form>
</body>
</html>

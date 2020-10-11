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
<script>
function checking() {
	if (document.getElementById("candidate").value == "none" || document.getElementById("age").value == "none" ||
		document.getElementById("candidate").value == null || document.getElementById("age").value == null) {		
		alert("후보자와 연령대를 선택해주세요.");  /*선택한 후보자와 연령대가 없거나 null값일 때 경고창이 나온다.*/
	} else {
		document.vote.action="B_02";  /*선택한 후보자와 연령대가 있으면 B_02.jsp로 이동한다.*/
		document.vote.submit();  /*vote의 값을 넘긴다.*/
	}
}
</script>
</head>
<body>

<table style=text-align:center; border=1px; bordercolor="blue">
	<tr>
		<!-- 각각의 글씨를 누르면 해당하는 주소로 연결된다. -->
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/">후보등록</a></td>
		<td style=text-align:center;background-color:yellow;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/B_01">투표</a></td>
		<td style=text-align:center;font-size:1.3em width=120px><a style=text-decoration:none; href="${path}/vote/C_01">개표결과</a></td> 
	</tr>	
</table>
<table border=1px; width=500px; height=1.5em;>
<tr><td>
<form  method="post" name="vote">
  <!-- 후보 기호와 후보명이 들어갈 콤보박스 생성 -->
  <select style=margin-left:40px;width:150px;height:1.5em; name="candidate" id="candidate">
    <option value="none"></option>
		<c:choose>
			<c:when test="${empty CandidateList}">
				<spring:message code="common.CandidateListEmpty"/>
			</c:when>
			<c:otherwise>
				<c:forEach items="${CandidateList}" var="candid">
				<!-- 콤보박스 하나에 후보번호와 이름이 들어간다. -->
    			<option value="${candid.num}">${candid.num}번 ${candid.name}</option>
				</c:forEach>
			</c:otherwise>
		</c:choose>
  </select>
  <!-- 투표 연령대가 들어갈 콤보박스 생성 -->
  <select style=margin-left:50px;width:80px;height:1.5em; name="age" id="age">
    <option value="none"></option>
<%
for (int i = 1; i < 10; i++) {  /*i가 1부터 9까지 for문 수행*/
%>
	<!-- 콤보박스에 투표연령이 들어간다.-->
    <option value="<%=i%>0"><%=i%>0대</option>
<%
}
%>
  </select>
  <!-- 투표하기 버튼을 누르면 투표 테이블에 값이 저장되고, B_02.jsp로 이동된다.-->
<input style=margin-left:50px;background-color:#27DBB7; bordercolor=#27DBB7; type="button" value="투표하기" onclick="checking()">
</form>
</td>
</tr>
</table>
</body>
</html>
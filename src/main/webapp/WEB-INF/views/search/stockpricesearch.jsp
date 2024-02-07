<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

조회조건<br>
필수: 서비스키, 페이지 결과 수, 페이지 번호, 결과 형식
<br>
시작일자, 종료일자, 코드
<br>
시작일자: <input type="text" name = "beginDate"><br>
종료일자: <input type="text" name = "endDate"><br>
종목코드: <input type="text" name = "code"><br>
<input type="button" value="조회" onclick=search()>

<script>

    function search(){
        const beginBasDt = document.getElementsByName("beginDate");
        const endBasDt = document.getElementsByName("endDate");

    }

</script>



</body>
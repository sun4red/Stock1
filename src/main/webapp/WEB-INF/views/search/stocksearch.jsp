<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<a href = "/">홈</a><br>


<select name="condition">
    <option value="default">조회조건</option>
    <option value="corp_name">회사명</option>
    <option value="corp_code">회사코드</option>
    <option value="stock_code">종목코드</option>
</select>
<input type="text" name="keyword"/>
<input type="button" value="조회" name="inquire" onclick="search()"/>


<table border="1">
    <tr>
        <th>회사코드</th>
        <th>회사명</th>
        <th>종목코드</th>
    </tr>
    <tbody id="searchresult">

    </tbody>

    <script>
        function search() {
            const condition = document.getElementsByName("condition")[0].value;
            const keyword = document.getElementsByName("keyword")[0].value;

            fetch("getstockcode?condition=" + condition + "&keyword=" + keyword)
                .then(response => response.json())
                .then(data => {
                    console.log(data);

                    const tableBody = document.querySelector("#searchresult");
                    tableBody.innerHTML = '';

                    var row = '';

                    data.stockList.forEach((corpCode) => {
                        row +=
                            "<tr><td>"
                            + corpCode.corp_code
                            + "</td><td>"
                            + corpCode.corp_name
                            + "</td><td>"
                            + "<a href = stockinfo?stock_code=" + corpCode.stock_code + ">" + corpCode.stock_code + "</a>"
                            + "</td></tr>";

                    });

                    tableBody.innerHTML = row;

                })

        }


    </script>

</table>


</body>
</html>
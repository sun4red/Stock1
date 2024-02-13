<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<a href="/">홈</a><br>

종목코드 : ${stockinfo.stock_code}
<br>
종목명 : ${stockinfo.corp_name}

<br>
<br>
조회 기간 설정
<br>
<%--다음 작업 시 시작부분--%>
시작 : <input type = "date"> 종료 : <input type = "date">
<br>
<br>


<a href="#">탭1 주가 차트 계획</a>
<a href="#">탭2 주가 저평가 여부</a>
<a href="#">탭3</a>

<br>
<a href="javascript:getDailyStockPrice();">시세 확인</a>
<input type=button value="시세확인" onclick="getDailyStockPrice();">

<script>
    function getDailyStockPrice() {

        const url = 'https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo';
        // const serviceKey = "";
        // var numOfRows;
        // var pageNo;
        const resultType = 'json'
        // var beginBasDt;
        // var endBasDt;
        // var likeSrtnCd;


        fetch(url +
            '?serviceKey=' + '${serviceKey}' +
            '&numOfRows=' + '1500' +
            '&pageNo=' + '1' +
            '&resultType=' + resultType +
            '&beginBasDt=' + '20230101' +
            '&endBasDt=' + '20240301' +
            '&likeSrtnCd=' + '${stockinfo.stock_code}'
        )

            .then(response => response.json())
            .then(data => {
                console.log(data);

                const tablebody = document.querySelector('#dailyPriceList');

                tablebody.innerHTML = '';

                var row = '';


                for (const item of data.response.body.items.item) {
                    row += "<tr><td>" + item.basDt + "</td><td>"
                        + item.mkp + "</td><td>"
                        + item.clpr + "</td><td>"
                        + item.vs + "</td><td>"
                        + item.fltRt + "</td><td>"
                        + item.hipr + "</td><td>"
                        + item.lopr + "</td><td>"
                        + item.trqu + "</td>"


                }


                tablebody.innerHTML = row;


            })
            .catch(error => console.error('Error fetching data:', error));

    }
</script>

<table border="1">
    <tr>
        <th>기준일자(basDt)</th>
        <th>시가(mkp)</th>
        <th>종가(clpr)</th>
        <th>대비(vs)</th>
        <th>등락률(fltRt)</th>
        <th>고가(hipr)</th>
        <th>저가(lopr)</th>
        <th>거래량(trqu)</th>

    </tr>
    <tbody id = "dailyPriceList">


    </tbody>
</table>


</body>
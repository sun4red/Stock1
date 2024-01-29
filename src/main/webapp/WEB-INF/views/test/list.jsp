<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<script>


    function getStockPriceInfo(serviceKey,
                               numOfRows,
                               pageNo,
                               resultType) {


        const url = 'https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?&serviceKey=${StockPriceInfoKey}' +
            '&numOfRows=${numOfRows}' +
            '&pageNo=${pageNo}' +
            '&resultType=${resultType}'


        fetch(url)

            .then(response => response.json())
            .then(data => {
                console.log(data);



            const tablebody = document.querySelector('#PriceList');

            tablebody.innerHTML='';

            var row = '';


                for (const item of data.response.body.items.item) {
                    row += "<tr><td>" + item.basDt + "</td><td>"
                        + item.srtnCd + "</td><td>"
                        + item.isinCd + "</td><td>"
                        + item.itmsNm + "</td><td>"
                        + item.mrktCtg + "</td><td>"
                        + item.clpr + "</td><td>"
                        + item.vs + "</td><td>"
                        + item.fltRt + "</td><td>"
                        + item.mkp + "</td><td>"
                        + item.hipr + "</td><td>"
                        + item.lopr + "</td><td>"
                        + item.trqu + "</td><td>"
                        + item.trPrc + "</td><td>"
                        + item.lstgStCnt + "</td><td>"
                        + item.mrktTotAmt + "</td></tr>";
                }





                tablebody.innerHTML = row;

            })
            .catch(error => console.error('Error fetching data:', error));

    }




</script>


<a href="/">테스트 페이지로 이동</a>

<button type="button" onclick="getStockPriceInfo()">
    스크립트 실행
</button>

결과코드
결과메시지
한페이지 결과 수
페이지 번호
전체 결과 수

<br>

<table border="1">
    <tr>
        <td>기준일자</td>
        <td>단축코드</td>
        <td>ISIN코드</td>
        <td>종목명</td>
        <td>시장구분</td>
        <td>종가</td>
        <td>대비</td>
        <td>등락률</td>
        <td>시가</td>
        <td>고가</td>
        <td>저가</td>
        <td>거래량</td>
        <td>거래대금</td>
        <td>상장주식수</td>
        <td>시가총액</td>
    </tr>
    <tbody id="PriceList">

    </tbody>
</table>

</body>
</html>
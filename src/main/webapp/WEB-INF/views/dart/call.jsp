<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
dart 공시 정보 검색
<br><br>

<%--<input type="text" id = "crtfc_key">API 인증키<br>--%>
<%--<input type="text" id = "corp_code">고유번호<br>--%>
<%--<input type="text" id = "bgn_de">시작일<br>--%>
<%--<input type="text" id = "end_de">종료일<br>--%>
<%--<input type="text" id = "last_reprt_at">최종보고서 검색여부<br>--%>
<%--<input type="text" id = "pblntf_ty">공시유형<br>--%>
<%--<input type="text" id = "pblntf_detail_ty">공시상세유형<br>--%>
<%--<input type="text" id = "corp_cls">법인구분<br>--%>
<%--<input type="text" id = "sort">정렬<br>--%>
<%--<input type="text" id = "sort_mth">정렬방법<br>--%>
<%--<input type="text" id = "page_no">페이지 번호<br>--%>
<%--<input type="text" id = "page_count">페이지 별 건수<br>--%>
<h2>Open DART API 요청 폼</h2>
API 인증키: <input type="text" id="crtfcKey" placeholder="API 인증키"><br>
고유번호: <input type="text" id="corpCode" placeholder="고유번호"><br>
시작일: <input type="text" id="bgnDe" placeholder="시작일 (YYYYMMDD)"><br>
종료일: <input type="text" id="endDe" placeholder="종료일 (YYYYMMDD)"><br>
최종보고서 검색여부: <input type="text" id="lastReprtAt" placeholder="Y 또는 N"><br>
공시유형: <input type="text" id="pblntfTy" placeholder="공시유형"><br>
공시상세유형: <input type="text" id="pblntfDetailTy" placeholder="공시상세유형"><br>
법인구분: <input type="text" id="corpCls" placeholder="법인구분"><br>
정렬: <input type="text" id="sort" placeholder="정렬"><br>
정렬방법: <input type="text" id="sortMth" placeholder="정렬방법"><br>
페이지 번호: <input type="text" id="pageNo" placeholder="페이지 번호"><br>
페이지 별 건수: <input type="text" id="pageCount" placeholder="페이지 별 건수"><br>
<button onclick="sendData()">API 요청하기</button>

<%--<h3>API 응답 결과</h3>--%>
<%--<pre id="apiResponse"></pre>--%>

<%--<script>--%>
<%--    function sendData() {--%>
<%--        // 입력 값 가져오기--%>
<%--        const data = {--%>
<%--            crtfc_key: document.getElementById('crtfcKey').value,--%>
<%--            corp_code: document.getElementById('corpCode').value,--%>
<%--            bgn_de: document.getElementById('bgnDe').value,--%>
<%--            end_de: document.getElementById('endDe').value,--%>
<%--            last_reprt_at: document.getElementById('lastReprtAt').value,--%>
<%--            pblntf_ty: document.getElementById('pblntfTy').value,--%>
<%--            pblntf_detail_ty: document.getElementById('pblntfDetailTy').value,--%>
<%--            corp_cls: document.getElementById('corpCls').value,--%>
<%--            sort: document.getElementById('sort').value,--%>
<%--            sort_mth: document.getElementById('sortMth').value,--%>
<%--            page_no: document.getElementById('pageNo').value,--%>
<%--            page_count: document.getElementById('pageCount').value--%>
<%--        };--%>

<%--        // 쿼리 매개변수 생성 (입력된 항목만 추가)--%>
<%--        const queryParams = Object.keys(data)--%>
<%--            .filter(key => data[key])  // 값이 있는 필드만 남김--%>
<%--            .map(key => `${encodeURIComponent(key)}=${encodeURIComponent(data[key])}`)--%>
<%--            .join('&');--%>

<%--        const apiUrl = `https://opendart.fss.or.kr/api/list.json?${queryParams}`;--%>

<%--        // Ajax 요청--%>
<%--        fetch(apiUrl)--%>
<%--            .then(response => response.json())--%>
<%--            .then(response => {--%>
<%--                // 응답 결과 출력--%>
<%--                document.getElementById('apiResponse').textContent = JSON.stringify(response, null, 4);--%>
<%--            })--%>
<%--            .catch(error => {--%>
<%--                console.error("API 요청 실패:", error);--%>
<%--                document.getElementById('apiResponse').textContent = "API 요청에 실패했습니다.";--%>
<%--            });--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
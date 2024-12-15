package make.money.stock1.controller;


import jakarta.servlet.http.HttpServletRequest;
import make.money.stock1.EnvReader;

import make.money.stock1.api.ApiDart;
import make.money.stock1.api.data.DartReportRequest;
import make.money.stock1.model.ApiResponse;
import make.money.stock1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpRequest;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {


    @Autowired
//    private final CodeService codeService;
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

//    public TestController(CodeService codeService) {
//        this.codeService = codeService;
//    }

    @RequestMapping("/")
    public String testPage() {


        return "test/test";
    }


    @RequestMapping("callDart")
    public String callDartPage(Model model) {

        EnvReader envReader = new EnvReader();
        String crtfc_key = envReader.readEnv().get("OpenDartKey");
        model.addAttribute("crtfc_key", crtfc_key);


        return "dart/call";
    }


    @RequestMapping("dartReports")
    public String dartReports(HttpServletRequest request, Model model) {

        EnvReader envReader = new EnvReader();
        String crtfc_key = envReader.readEnv().get("OpenDartKey");
        model.addAttribute("crtfc_key", crtfc_key);

        String url = "https://opendart.fss.or.kr/api/list.json" +
                "?crtfc_key=" + crtfc_key +
                "&corp_code=00938721";

        RestTemplate restTemplate = new RestTemplate();
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);

        System.out.println(response);

        System.out.println(response.getStatus());

//        if (response != null && "success".equals(response.getStatus())){
//
//        }*




        return "redirect:" + url;
    }

@RequestMapping("testApiCall")
public String testApiCall()
{
    DartReportRequest dartReportRequest = new DartReportRequest();

dartReportRequest.setCorp_code("00938721");

    ApiDart apiDart = new ApiDart();
    apiDart.dartReports(dartReportRequest);


    return "redirect:/";
}

//    @WebServlet("/ReportServlet")
//    public class ReportServlet extends HttpServlet {
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            // 폼 데이터 수집
//            String crtfcKey = request.getParameter("crtfcKey");
//            String corpCode = request.getParameter("corpCode");
//            String bgnDe = request.getParameter("bgnDe");
//            String endDe = request.getParameter("endDe");
//            String lastReprtAt = request.getParameter("lastReprtAt");
//            String pblntfTy = request.getParameter("pblntfTy");
//            String pblntfDetailTy = request.getParameter("pblntfDetailTy");
//            String corpCls = request.getParameter("corpCls");
//            String sort = request.getParameter("sort");
//            String sortMth = request.getParameter("sortMth");
//            String pageNo = request.getParameter("pageNo");
//            String pageCount = request.getParameter("pageCount");
//
//            // DTO 객체 생성 및 데이터 설정
//            ReportQueryDTO reportQuery = new ReportQueryDTO();
//            reportQuery.setCrtfcKey(crtfcKey);
//            reportQuery.setCorpCode(corpCode);
//            reportQuery.setBgnDe(bgnDe);
//            reportQuery.setEndDe(endDe);
//            reportQuery.setLastReprtAt(lastReprtAt);
//            reportQuery.setPblntfTy(pblntfTy);
//            reportQuery.setPblntfDetailTy(pblntfDetailTy);
//            reportQuery.setCorpCls(corpCls);
//            reportQuery.setSort(sort);
//            reportQuery.setSortMth(sortMth);
//            reportQuery.setPageNo(pageNo);
//            reportQuery.setPageCount(pageCount);
//
//            // 이후 필요한 비즈니스 로직 처리
//        }
//    }


//
//    @RequestMapping("list")
//    public String listPage(Model model) {
//
//        EnvReader envReader = new EnvReader();
//        String StockPriceInfoKey = envReader.readEnv().get("StockPriceInfoKey");
//
//        System.out.println(StockPriceInfoKey);
//
//        model.addAttribute("StockPriceInfoKey", StockPriceInfoKey);
//        model.addAttribute("numOfRows",10);
//        model.addAttribute("pageNo",1);
//        model.addAttribute("resultType","json");
//
//
//        return "test/list";
//    }
//
//    @RequestMapping("dbin")
//    public String dbin(){
//
//        CorpCode corpCode = new CorpCode();
//
//        corpCode.setCorp_code(1);
//        corpCode.setCorp_name("테스트");
//        corpCode.setStock_code(1);
//        corpCode.setModify_date(new Date());
//
//codeService.insertCode(corpCode);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping("parsingxml")
//    public String parsingXml(){
//        CorpCodeParser corpCodeParser = new CorpCodeParser();
//        List<CorpCode> codeList = corpCodeParser.parsingXml();
//
//        for(int i = 0; i < codeList.size() ; i++){
//            codeService.insertCode(codeList.get(i));
//        }
//
//
//
//        return "redirect:/";
//    }
//
//
//
//    @GetMapping("stock/price")
//    @ResponseBody
//    public StockPriceInfo getStockPrice() {
//
//        StockPriceInfo spi = new StockPriceInfo();
//
//        return spi;
//    }

}

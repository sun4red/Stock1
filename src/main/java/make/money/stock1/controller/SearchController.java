//package make.money.stock1.controller;
//
//import make.money.stock1.model.CorpCode;
//import make.money.stock1.service.CodeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class SearchController {
//
//    @Autowired
//    private final CodeService codeService;
//
//    public SearchController(CodeService codeService) {
//        this.codeService = codeService;
//    }
//
//
//    @RequestMapping("/stocksearch")
//    public String toStockSearch() {
//
//        return "search/stocksearch";
//    }
//
//    @GetMapping("/getstockcode")
//    @ResponseBody
//    public ResponseEntity<Map<String, Object>> getStockCode(@RequestParam String condition, @RequestParam String keyword) {
//
//        System.out.println("condition: " + condition);
//        System.out.println("keyword: " + keyword);
//
//
//        CorpCode corpCode = new CorpCode();
//
//        if (condition.equals("corp_code")) {
//            corpCode.setCorp_code(Integer.parseInt(keyword));
//        } else if (condition.equals("stock_code")) {
//            corpCode.setStock_code(Integer.parseInt(keyword));
//        } else {
//            corpCode.setCorp_name(keyword);
//        }
//
//        List<CorpCode> stockList = codeService.searchStock(corpCode);
//
//        Map<String, Object> response = new HashMap<>();
//
//        response.put("stockList", stockList);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}

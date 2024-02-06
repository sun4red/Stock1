package make.money.stock1.controller;

import make.money.stock1.model.CorpCode;
import make.money.stock1.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private final CodeService codeService;

    public SearchController(CodeService codeService) {
        this.codeService = codeService;
    }


    @RequestMapping("stocksearch")
    public String toStockSearch() {

        return "search/stocksearch";
    }

    @GetMapping("/getstockcode")
    @ResponseBody
    public List<CorpCode> getStockCode(@RequestParam String condition, @RequestParam String keyword) {


        CorpCode corpCode = new CorpCode();
        if (condition == "corp_code") {
            corpCode.setCorp_code(Integer.parseInt(keyword));
        } else if (condition == "stock_code") {
            corpCode.setStock_code(Integer.parseInt(keyword));
        } else {
            corpCode.setCorp_name(keyword);
        }


        return codeService.searchStock(corpCode);
    }

}

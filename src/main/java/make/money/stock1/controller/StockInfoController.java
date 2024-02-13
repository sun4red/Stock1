package make.money.stock1.controller;

import make.money.stock1.EnvReader;
import make.money.stock1.model.CorpCode;
import make.money.stock1.service.CodeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockInfoController {

    private final CodeService codeService;

    public StockInfoController(CodeService codeService) {
        this.codeService = codeService;
    }

    @RequestMapping("stockinfo")
    public String ViewStockInfo(@RequestParam String stock_code, Model model) {


        CorpCode corpCode = new CorpCode();
        corpCode.setStock_code(Integer.parseInt(stock_code));

        CorpCode stockInfo = new CorpCode();

        // DB 조회 시 검색결과가 없을 경우 처리
        // 임시로 try-catch로 처리 했으나 다른 방법 필요
        try {
            stockInfo = codeService.getCorpCodeByStockCode(corpCode);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
        model.addAttribute("stockinfo", stockInfo);

        EnvReader envReader = new EnvReader();
        String StockPriceInfoKey = envReader.readEnv().get("StockPriceInfoKey");
        model.addAttribute("serviceKey", StockPriceInfoKey);

        return "info/stockinfo";
    }

}

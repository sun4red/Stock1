package make.money.stock1.controller;

import lombok.RequiredArgsConstructor;
import make.money.stock1.EnvReader;
import make.money.stock1.model.CorpCode;
import make.money.stock1.model.StockPriceInfo;
import make.money.stock1.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

import static make.money.stock1.EnvReader.readEnv;

@Controller
public class TestController {


@Autowired
    private final CodeService codeService;

    public TestController(CodeService codeService) {
        this.codeService = codeService;
    }

    @RequestMapping("/")
    public String testPage() {



        return "test/test";
    }

    @RequestMapping("list")
    public String listPage(Model model) {

        EnvReader envReader = new EnvReader();
        String StockPriceInfoKey = envReader.readEnv().get("StockPriceInfoKey");

        System.out.println(StockPriceInfoKey);

        model.addAttribute("StockPriceInfoKey", StockPriceInfoKey);
        model.addAttribute("numOfRows",10);
        model.addAttribute("pageNo",1);
        model.addAttribute("resultType","json");


        return "test/list";
    }

    @RequestMapping("dbin")
    public String dbin(){

        CorpCode corpCode = new CorpCode();

        corpCode.setCorp_code(1);
        corpCode.setCorp_name("테스트");
        corpCode.setStock_code(1);
        corpCode.setModify_date(new Date());

codeService.insertCode(corpCode);

        return "redirect:/";
    }



    @GetMapping("stock/price")
    @ResponseBody
    public StockPriceInfo getStockPrice() {

        StockPriceInfo spi = new StockPriceInfo();

        return spi;
    }

}

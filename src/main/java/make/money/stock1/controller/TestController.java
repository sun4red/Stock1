package make.money.stock1.controller;

import make.money.stock1.EnvReader;
import make.money.stock1.model.StockPriceInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static make.money.stock1.EnvReader.readEnv;

@Controller
public class TestController {

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

    @GetMapping("stock/price")
    @ResponseBody
    public StockPriceInfo getStockPrice() {

        StockPriceInfo spi = new StockPriceInfo();

        return spi;
    }

}

package make.money.stock1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String testPage(){
        return "test/test";
    }

    @RequestMapping("list")
    public String listPage(){
        return "test/list";
    }

}

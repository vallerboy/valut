package pl.oskarpolak.wetherx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.oskarpolak.wetherx.models.CurrencyService;

@Controller
public class MainController {


    private final CurrencyService currencyService;

    @Autowired
    public MainController(CurrencyService weatherService) {
        this.currencyService = weatherService;
    }


    @GetMapping("/")
    public String weather(){
        return "currency";
    }

    @PostMapping("/")
    public String weather(@RequestParam("currency") String currency,
                          @RequestParam("pln") double pln,
                          Model model){
        model.addAttribute("cash", currencyService.exchangePLNToCurrency(pln, currency));
        return "currency";
    }

}

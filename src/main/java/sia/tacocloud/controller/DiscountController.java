package sia.tacocloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacocloud.props.DiscountProps;

import java.util.Map;

@Controller
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountProps discountProps;

    @GetMapping
    public String displayDiscountCodes(Model model){
        Map<String, Integer> codes = discountProps.getCodes();
        model.addAttribute("codes", codes);

        return "discountList";
    }
}
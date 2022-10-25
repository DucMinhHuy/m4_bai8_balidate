package minhhuy.thuchanh2.controller;

import minhhuy.thuchanh2.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("number",new PhoneNumber());
        return "/index";
    }
    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("number") PhoneNumber phoneNumber, BindingResult bindingResult,Model model){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/index";
        }else {
            model.addAttribute("number",phoneNumber);
            return "/result";
        }
    }
}

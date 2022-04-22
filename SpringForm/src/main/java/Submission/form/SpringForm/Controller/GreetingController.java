package Submission.form.SpringForm.Controller;

import Submission.form.SpringForm.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
 public String greetingForm(Model model){
        model.addAttribute("greeting",new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String postSubmit(@ModelAttribute Greeting greeting,Model model){
        model.addAttribute("greeting",greeting);
        return "result";
    }
}

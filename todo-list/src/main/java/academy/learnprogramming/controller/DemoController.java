package academy.learnprogramming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
//    private final DemoService demoservice;
//
//    @Autowired
//    public DemoController(DemoService demoservice) {
//        this.demoservice = demoservice;
//    }

    // http://localhost:8080 /todo-list/hello
    // html://localhost:8080/todo-list/welcome?User=Sammie
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage",user);
        model.addAttribute("age",age);
        log.info("model={}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return "welcome to this demo application";
    }

}

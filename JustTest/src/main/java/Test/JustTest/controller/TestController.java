package Test.JustTest.controller;

import model.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    private Admin firstPage(){

        Admin admin = new Admin();
        admin.setName("Korede");
        admin.setId(1L);
        admin.setSalary(737873);
        admin.setEmail("salamikehinde345@gmail.com");
        admin.setRole("Soldier");

        return admin;
    }


}


package com.liberty.gorilla.application.controller;

import com.liberty.gorilla.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping({"/test"})
public class TestController {

    @Autowired
    private  TestService testService;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @ResponseBody
    public String getExpressRouteList() {
        return testService.sayHello();
    }
}


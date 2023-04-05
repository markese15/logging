package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    @Autowired
    Environment environment;
    @Autowired
    BasicService basicService;
    Logger logger= LoggerFactory.getLogger(BasicController.class);
    @GetMapping("/")
    public String getHello(){
        logger.info("start log");
        return "hello";
    }
    @GetMapping("/exp")
    public int getNumber(){
        int var1= Integer.parseInt(environment.getProperty("customEnvs.n1"));
        int var2=Integer.parseInt(environment.getProperty("customEnvs.n2"));
        return basicService.getCalculation(var1,var2);
    }
    @GetMapping("/get-error")
    public void getError(){
        Error error= new Error("error");
        logger.error(error.getMessage());

    }

}

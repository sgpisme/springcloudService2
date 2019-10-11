package com.sgp.helloservice2;

import com.sgp.helloservice2.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Helloservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Helloservice2Application.class, args);
    }

    @Value("${spring.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String id) {
        return "hello " + id + " , " + name + " , I am from port:" + port;
    }

    @RequestMapping(value = "/playgameornot",method = RequestMethod.POST)
    public String playgameornot(@RequestBody User user){
        int p = Integer.valueOf(port);
        String answer = p%2 == 0?"不去":"去";
        String opanswer = p%2 == 1?"不去":"去";
        String result = "今晚"+user.getUsername()+answer+"上网,"+opanswer+"必死！";
        System.err.print(result);
        return result;
    }

}

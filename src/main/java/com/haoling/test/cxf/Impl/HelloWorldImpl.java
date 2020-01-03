package com.haoling.test.cxf.Impl;

import com.haoling.test.cxf.HelloWorld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;


@Component("helloWorld")
@WebService
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String say(String str) {

        System.out.println(str + "----------------------------------------------------");
        return "Hello" + str;
    }
}

package com.haoling.test.cxf;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

    public String say(String str);

}

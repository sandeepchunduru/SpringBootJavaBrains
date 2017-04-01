package io.javabrains.springbootstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sande on 3/31/2017.
 */
@RestController
@RequestMapping(HelloController.BASE_REQUEST_URI)
public class HelloController
{
    public static final String BASE_REQUEST_URI="hello";

    @RequestMapping(value= "/hi")
    public String sayHi()
    {
        return "Hi Sandeep Chunduru";
    }

}

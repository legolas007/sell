package com.usher.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Usher
 * @Description:
 */
@RestController
public class DockerController {
    @RequestMapping("/docker")
    public String index(){
        return "hello Docker!";
    }
}

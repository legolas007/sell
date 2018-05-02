package com.usher.controller;

import com.lly835.bestpay.rest.type.Get;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Usher
 * @Description:
 */
@RestController
@RequestMapping("/wx")
@Slf4j
public class WxController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("access to auth");
        log.info("code={}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx60b5796ca8f45469&secret=f8518a8ee3dfb2e280306d80e8f37623&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}

package com.docdoc.learnspring.link2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {

    @GetMapping("/quote")
    public Quote quote(RestTemplate restTemplate){
        Quote quote = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Quote.class);
        return quote;
    }
}

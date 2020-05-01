package com.microservice.sample.controller;/* 
@Author : Yogesh Deshmukh
*/

import com.microservice.sample.model.ExchangeValue;
import com.microservice.sample.repo.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to")String to){
        ExchangeValue exchange = exchangeValueRepository.findByFromAndTo(from,to);
        exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchange;
    }
}

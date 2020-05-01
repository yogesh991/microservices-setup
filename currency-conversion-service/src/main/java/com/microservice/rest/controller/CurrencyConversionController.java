package com.microservice.rest.controller;/* 
@Author : Yogesh Deshmukh
*/

import com.microservice.rest.model.CurrencyConversionBean;
import com.microservice.rest.service.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyProxy;

    @Autowired
    private Environment env;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from")String from, @PathVariable("to")String to, @PathVariable("quantity") BigDecimal quantity){


        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}"
                , CurrencyConversionBean.class, uriVariables);



        CurrencyConversionBean response = responseEntity.getBody();
        response.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity
                ,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeignProxy(@PathVariable("from")String from, @PathVariable("to")String to, @PathVariable("quantity") BigDecimal quantity){


        CurrencyConversionBean response = currencyProxy.retrieveExchangeValue(from,to);
        return new CurrencyConversionBean(response.getId(),from,to,response.getConversionMultiple(),quantity
                ,quantity.multiply(response.getConversionMultiple()),response.getPort());
    }
}

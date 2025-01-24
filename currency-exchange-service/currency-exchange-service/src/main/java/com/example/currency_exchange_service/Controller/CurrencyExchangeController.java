package com.example.currency_exchange_service.Controller;

import com.example.currency_exchange_service.Entity.ExchangeValue;
import com.example.currency_exchange_service.Repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private ExchangeValueRepository repository;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
    {
        ExchangeValue exchangeValue=repository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
        return new ResponseEntity(exchangeValue,HttpStatus.OK);
    }
    @GetMapping("/currency-exchange/first")
    public String getHello(){
        return "Hello World !";
    }
    @PostMapping("/currency-exchange/data")
    public ResponseEntity saveData(@RequestBody ExchangeValue value){
        value.setPort(Integer.parseInt(environment.getProperty("server.port")));
        repository.save(value);
        return new ResponseEntity(value,HttpStatus.OK);
    }
}

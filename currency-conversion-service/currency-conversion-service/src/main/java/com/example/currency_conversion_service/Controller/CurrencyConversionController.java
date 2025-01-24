package com.example.currency_conversion_service.Controller;

import com.example.currency_conversion_service.Entity.CurrencyConversion;
import com.example.currency_conversion_service.Entity.ExchangeValue;
import com.example.currency_conversion_service.Proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    CurrencyExchangeServiceProxy proxy;
    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/ quantity/{quantity}") //where {from} and {to} represents the column
    public ResponseEntity convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)
    {
        Map<String,String> uriVariables=new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ExchangeValue conversion= proxy.retrieveExchangeValue(from,to);
        CurrencyConversion conversion1= new CurrencyConversion(conversion.getId(), from,to,conversion.getConversionMultiple(), quantity,quantity.multiply(conversion.getConversionMultiple()),conversion.getPort());
        return new ResponseEntity(conversion1, HttpStatus.OK);
    }
    @GetMapping("/currency-converter")
    public String getData(){
        String str=proxy.getHello();
        System.out.println(str);
        return str;
    }

    @PostMapping("/currency-converter/data")
    public ResponseEntity sendDataOnCurrencyExchangeController(@RequestBody ExchangeValue value){
        return new ResponseEntity(proxy.saveData(value),HttpStatus.OK);
    }
}

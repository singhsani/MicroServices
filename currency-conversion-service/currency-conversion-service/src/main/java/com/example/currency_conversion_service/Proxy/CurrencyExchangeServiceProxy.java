package com.example.currency_conversion_service.Proxy;

import com.example.currency_conversion_service.Entity.ExchangeValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * call APIs of another service in feignClient
 * setUrls of another services
 */
@FeignClient(name="currency-exchange-service",url="localhost:8001")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

    @GetMapping("/currency-exchange/first")
    public String getHello();

    @PostMapping("/currency-exchange/data")
    public ResponseEntity saveData(@RequestBody ExchangeValue value);
}
